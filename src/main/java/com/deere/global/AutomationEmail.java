package com.deere.global;

import static com.deere.global.GlobalThings.failedTestcaseCount;
import static com.deere.global.GlobalThings.listOfInputs;
import static com.deere.global.GlobalThings.testResultReports;
import static com.deere.global.GlobalThings.timeForExecution;
import static com.deere.global.GlobalThings.listOfEmailId;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class AutomationEmail {

	public static void sendEmail() throws Exception {
		//Set Message Details
		String mailFrom = "MOCIAutomationReporter@johndeere.com";
	//	String mailFrom = "JDQuote2Reporter@johndeere.com";
		List<String> mailTos = new ArrayList<String>();
		for (InputEmailIdDetails inputEmailIdDetails : listOfEmailId) {
			mailTos.add(inputEmailIdDetails.getEmailId());
		}
		String MailSubject = "JDQuote2 Automation - Result Report";
		String fileAttachmentPath = CommonFunctions.curDir + "/TestReport.xls";
		
		//Set Message Body
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(getMessageBodyPart());
		multipart.addBodyPart(getMessageAttachmentPart(fileAttachmentPath));
		Message message = defineMessage(mailFrom, mailTos, MailSubject,	multipart);
		
		// Send the message
		Transport.send(message);
	}
	
	public static void sendFailedTCEmail(String SSpath , String exceptionError, String testCaseId , String testCaseDescription , String flow) throws Exception {
		//Set Message Details
		String mailFrom = "MOCIAutomationReporter@johndeere.com";
		List<String> mailTos = new ArrayList<String>();

		for (InputEmailIdDetails inputEmailIdDetails : listOfEmailId) {
			mailTos.add(inputEmailIdDetails.getEmailId());
		}

		String MailSubject = "MOCI Automation - Failed Test Case Report";

		
		//Set Message Body
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(getFailedTCMessageBodyPart(exceptionError,testCaseId,testCaseDescription,flow));
		multipart.addBodyPart(getFailedTCMessageAttachmentPart(SSpath , testCaseId));

		Message message = defineMessage(mailFrom, mailTos, MailSubject,	multipart);
		
		// Send the message
		Transport.send(message);
	}

	private static Message defineMessage(String mailFrom, List<String> mailTos, String MailSubject, Multipart multipart) throws MessagingException, AddressException {
		// Define message
		Message message = new MimeMessage(getSession());
		message.setFrom(new InternetAddress(mailFrom));
		for(String mailTo:mailTos){
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
		}
		message.setSubject(MailSubject);
		message.setContent(multipart);
		return message;
	}

	private static Session getSession() {
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", "mail.dx.deere.com");
		Session session = Session.getDefaultInstance(properties);
		return session;
	}

	private static BodyPart getMessageBodyPart() throws MessagingException {
		BodyPart messageBodyPart = new MimeBodyPart();
		String mailBody = "Total Number of test cases Executed: " + testResultReports.size() + 
				"\n\nTotal Number of test cases Failed: " + failedTestcaseCount + 
				"\n\nHealth of System (Passing percentage): " + ((float)(testResultReports.size()-failedTestcaseCount)/testResultReports.size())*100 + " %" +
				"\n\nTime for execution is " + (timeForExecution/1000)/60 + " Minute(s) " + (timeForExecution/1000)%60 + " Second(s)" +
				"\n\nThe detailed test report is attached herewith.";

		messageBodyPart.setText(mailBody);
		return messageBodyPart;
	}
	
	private static BodyPart getFailedTCMessageBodyPart(String excpError ,String testCaseId , String testCaseDes , String flow) throws MessagingException {
		BodyPart messageBodyPart = new MimeBodyPart();
		String mailBody = "Test Case Id: " + testCaseId + 
				"\n\nTest Case Description: " + testCaseDes +
				"\n\nFunctional Flow: " + flow +
				"\n\nCause Of Failure: " + excpError +
				"\n\nThe Screen Shot is attached herewith.";
		messageBodyPart.setText(mailBody);
		return messageBodyPart;
	}
	
	private static BodyPart getFailedTCMessageAttachmentPart(String fileAttachmentPath , String testCaseId) throws MessagingException {
		File fileAddress = new File(fileAttachmentPath);
		BodyPart messageBodyPart;
		messageBodyPart = new MimeBodyPart();
		DataSource source = new FileDataSource(fileAddress);
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(testCaseId+".png");
		return messageBodyPart;
	}
	
	private static BodyPart getMessageAttachmentPart(String fileAttachmentPath) throws MessagingException {
		File fileAddress = new File(fileAttachmentPath);
		BodyPart messageBodyPart;
		messageBodyPart = new MimeBodyPart();
		DataSource source = new FileDataSource(fileAddress);
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName("TestReport.xls");
		return messageBodyPart;
	}
}
