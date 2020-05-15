package com.deere.global;
import static com.deere.global.GlobalThings.listOfEnv;
import static com.deere.global.GlobalThings.listOfsuite;
import static com.deere.global.GlobalThings.timeForExecution;

/**
 * @author an61450
 * This class contains main function and Automation execution starts from here
 */

public class Driver{

	public static void main(String[] args) throws Exception {

		long startTime_Excution = System.currentTimeMillis();
		CommonFunctions.createReportDirectory();
		CommonFunctions.getBrowserToBeExecuted();
		CommonFunctions.getEnvironemtToBeExecuted();
		CommonFunctions.getSuiteToBeExecuted(); 
		CommonFunctions.getEmailId();
		System.out.println("PAth is sisisisiis "+System.getProperty("user.dir"));
		for(InputSuiteDetails suite : listOfsuite)
		{
			CommonFunctions.getTestsToBeExecuted(suite.getModule().toString());
		}
		for(InputEnvironmentDetails inputEnvDetails : listOfEnv){

			CommonFunctions.executeTestCase(inputEnvDetails);
		}
		CommonFunctions.writeReportExcel();
		timeForExecution = System.currentTimeMillis()-startTime_Excution;
		AutomationEmail.sendEmail();
		for(int i=0;i<com.deere.applicaionSpecific.GlobalThings.pgmDelete.size(); i++){
		System.out.println(com.deere.applicaionSpecific.GlobalThings.pgmDelete.get(i).toString());
		}
		//System.exit(0);
	}
}