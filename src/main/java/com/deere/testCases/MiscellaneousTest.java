package com.deere.testCases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import com.deere.applicaionSpecific.GlobalThings;
import com.deere.global.CommonFunctions;
import com.deere.global.InputBrowserDetails;
import com.deere.global.InputEnvironmentDetails;
import com.deere.global.InputTestDetails;
import com.deere.global.TestResultReport;
import com.deere.pages.CreateOrder;
import com.deere.pages.EquipmentPage;
import com.deere.pages.FinancePage;
import com.deere.pages.HomePage;
import com.deere.pages.LoginPage;
import com.deere.pages.POPage;
import com.deere.pages.ProposalPage;
import com.deere.pages.RFQPage;
import com.deere.pages.RecapPage;
import com.deere.pages.SendToJDFPage;
import com.deere.pages.SummaryPage;
import com.deere.pages.TradeInPage;

public class MiscellaneousTest {

	// Send to CBD GS
	public static TestResultReport test_TCNQ001(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		ProposalPage proposalPage = new ProposalPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		// loginPage.dealerActNumbrLogin(inputTestDetails);
		loginPage.clickContinueButton();
		homePage.clickCreateQuote();
		summaryTab.enterQuoteName();
		summaryTab.addCBDCustomer(inputTestDetails);
		summaryTab.selectQuoteType(inputTestDetails);
		summaryTab.selectDealerRadioBttn();
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.acceptAlert(driver);
		summaryTab.clickCreateQuoteButton();
		equipmentPage.addFreeFormEquipCBD();
		homePage.clickPOSign();
		homePage.salesTax(inputTestDetails);
		homePage.agencyDocType(inputTestDetails);
		homePage.transactionType(inputTestDetails);
		homePage.agencyPODate();
		homePage.generateCBDPO();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	// Send To TP
	public static TestResultReport test_TCNQ002(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		TradeInPage tradeInPage = new TradeInPage(driver);
		POPage poPage = new POPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(5000);
		loginPage.clickContinueButton();
		homePage.selectPurchaseQuoteAndSpecificCustomerNameAndTradeIn();
		// poPage.pOtab();
		poPage.sentToTransactionPricing();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	// Create Order Functionality
	public static TestResultReport test_TCNQ003(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		TradeInPage tradeInPage = new TradeInPage(driver);
		POPage poPage = new POPage(driver);
		CreateOrder createCartNumber = new CreateOrder(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(5000);
		loginPage.clickContinueButton();
		homePage.clickCreateQuote();
		summaryTab.enterQuoteName();
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.acceptAlert(driver);
		summaryTab.clickCreateQuoteButton();
		Thread.sleep(10000);
		equipmentPage.clickOnConfiguratorLink();
		createCartNumber.generateCartNumberForOrder();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	// RFQ Functionality
	public static TestResultReport test_TCNQ004(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		TradeInPage tradeInPage = new TradeInPage(driver);
		POPage poPage = new POPage(driver);
		RFQPage rFQ = new RFQPage(driver);
		CreateOrder createCartNumber = new CreateOrder(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(5000);
		loginPage.clickContinueButton();
		rFQ.requestForQuote();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	// Send To Ceres/Send To JDF
	public static TestResultReport test_TCNQ005(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		TradeInPage tradeInPage = new TradeInPage(driver);
		POPage poPage = new POPage(driver);
		FinancePage fianacePO = new FinancePage(driver);
		SendToJDFPage sendToJDF = new SendToJDFPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(5000);
		loginPage.clickContinueButton();
		homePage.selectPurchaseQuote();
		Thread.sleep(5000);
		fianacePO.selectOfferOnFinanceTab();
		sendToJDF.sendToJDF();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	// Copy Quote Functionality
	public static TestResultReport test_TCNQ006(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		FinancePage financepage = new FinancePage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		Thread.sleep(5000);
		// loginPage.enterDealerActNumber(dealerActNumber );
		// loginPage.clickGoButton();
		CommonFunctions.waitForLoad(driver);
		loginPage.clickContinueButton();
		homePage.selectPurchaseQuote();
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(20000);
		homePage.copyQuote();
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(10000);
		homePage.deleteQuote();
		CommonFunctions.waitForLoad(driver);
		homePage.selectQuotes();
		Thread.sleep(10000);
		homePage.mergeQuote();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	// Download Excel Functionality
	public static TestResultReport test_TCNQ007(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		FinancePage financepage = new FinancePage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		Thread.sleep(5000);
		// loginPage.enterDealerActNumber(dealerActNumber );
		// loginPage.clickGoButton();
		CommonFunctions.waitForLoad(driver);
		loginPage.clickContinueButton();
		homePage.downloadToExcelFun();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	
//   Signed PO and Sent To JDMINT and generate invoice
	public static TestResultReport test_TCNQ008(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
					throws WebDriverException, Exception 
	{
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		TradeInPage tradeInPage=new TradeInPage(driver);
		POPage poPage=new POPage(driver);		
		FinancePage fianacePO= new FinancePage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(5000);		
		loginPage.clickContinueButton();		
		homePage.selectPurchaseQuote();		
		Thread.sleep(5000);		
		poPage.generatePO();	
//		poPage.sendToWorkflow();		
		poPage.signedPO();		
		poPage.generateInvoice();		
		poPage.sendToJDMint();		
		poPage.revisionSignedPO();		
		poPage.deletePO();		
//		poPage.validateSentToWorkflow();		
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}
	
	
	public static TestResultReport test_TCNQ010(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
					throws WebDriverException, Exception 
	{
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		TradeInPage tradeInPage=new TradeInPage(driver);
		POPage poPage=new POPage(driver);		
		FinancePage fianacePO= new FinancePage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(5000);		
		loginPage.clickContinueButton();		
		homePage.selectPurchaseQuote();		
		Thread.sleep(5000);		
		poPage.generatePO();
		poPage.electronicSignPOPage();
//		poPage.sendToWorkflow();		
//		poPage.signedPO();		
//		poPage.generateInvoice();		
//		poPage.sendToJDMint();		
//		poPage.revisionSignedPO();		
		poPage.deletePO();		
//		poPage.validateSentToWorkflow();		
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}
	
//	Send To Workflow
	public static TestResultReport test_TCNQ009(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
					throws WebDriverException, Exception 
	{
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		TradeInPage tradeInPage=new TradeInPage(driver);
		POPage poPage=new POPage(driver);		
		FinancePage fianacePO= new FinancePage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(5000);		
		loginPage.clickContinueButton();		
		homePage.selectPurchaseQuote();		
		Thread.sleep(5000);		
//		poPage.generatePO();	
		poPage.sendToWorkflow();		
//		poPage.signedPO();		
//		poPage.generateInvoice();		
//		poPage.sendToJDMint();		
//		poPage.revisionSignedPO();		
//		poPage.deletePO();		
		poPage.validateSentToWorkflow();		
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}
	
	

	
}
