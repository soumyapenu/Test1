package com.deere.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.deere.global.CommonFunctions;
import com.deere.global.InputBrowserDetails;
import com.deere.global.InputEnvironmentDetails;
import com.deere.global.InputTestDetails;
import com.deere.global.TestResultReport;
import com.deere.pages.EquipmentPage;
import com.deere.pages.FinancePage;
import com.deere.pages.HomePage;
import com.deere.pages.LoginPage;
import com.deere.pages.POPage;
import com.deere.pages.ProposalPage;
import com.deere.pages.SummaryPage;
import com.deere.pages.TradeInPage;

public class QuoteTypesTest {

	// Create Demo Agreement from quote
	public static TestResultReport test_TCNQ001(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		// loginPage.clickSignInButton();
		// CommonFunctions.waitForLoad(driver);
		// loginPage.dealerActNumbrLogin(inputTestDetails);
		loginPage.clickContinueButton();
		homePage.clickCreateQuote();
		summaryTab.enterQuoteName();
		summaryTab.selectQuoteType(inputTestDetails);
		summaryTab.addCustomer(inputTestDetails);
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.acceptAlert(driver);
		summaryTab.clickCreateQuoteButton();
		equipmentPage.addCollateralEquipment();
		equipmentPage.clickDoneOnLeftNav();
		equipmentPage.createDemoAgreementOnLeftNav();
		summaryTab.generateDemoAgreement();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	// Create Rental Agreement from quote
	public static TestResultReport test_TCNQ002(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		// loginPage.clickSignInButton();
		// CommonFunctions.waitForLoad(driver);
		// loginPage.dealerActNumbrLogin(inputTestDetails);
		loginPage.clickContinueButton();
		homePage.clickCreateQuote();
		summaryTab.enterQuoteName();
		summaryTab.selectQuoteType(inputTestDetails);
		summaryTab.addCustomer(inputTestDetails);
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.acceptAlert(driver);
		summaryTab.clickCreateQuoteButton();
		equipmentPage.addCollateralEquipment();
		equipmentPage.clickDoneOnLeftNav();
		equipmentPage.createRentalAgreementOnLeftNav();
		summaryTab.selectPurchaserType(inputTestDetails);
		summaryTab.selectMarketUse(inputTestDetails);
		summaryTab.selectDayOut();
		summaryTab.generateRentalAgreement();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	public static TestResultReport test_TCNQ003(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		// loginPage.clickSignInButton();
		CommonFunctions.waitForLoad(driver);
		//loginPage.dealerActNumbrLogin(inputTestDetails);
		loginPage.clickContinueButton();
		homePage.clickCreateQuote();
		summaryTab.enterQuoteName();
		Thread.sleep(2000);
		summaryTab.selectQuoteType(inputTestDetails);
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.acceptAlert(driver);
		summaryTab.clickCreateQuoteButton();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}
	
//	Create Purchase Order
	public static TestResultReport test_TCNQ004(InputTestDetails inputTestDetails,
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
		homePage.selectPurchaseQuoteAndSpecificCustomerNameAndTradeIn();		
		Thread.sleep(5000);		
		poPage.generatePO();
//		poPage.electronicSignPOPage();
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

	// Create new Rental Agreement on left navigation pane
	public static TestResultReport test_TCNQ005(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		// loginPage.dealerActNumbrLogin(inputTestDetails);
		loginPage.clickContinueButton();
		equipmentPage.createNewRentalAgreement();
		summaryTab.addCustomerDirect(inputTestDetails);
		summaryTab.selectPurchaserType(inputTestDetails);
		summaryTab.selectMarketUse(inputTestDetails);
		summaryTab.selectDayOut();
		CommonFunctions.javaScriptScrollDown(driver, 350);
		equipmentPage.addFreeFormEquipOtherThaQuote();
		summaryTab.generateRentalAgreement();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	// Create new Demo Agreement on left navigation pane
	public static TestResultReport test_TCNQ006(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		// loginPage.dealerActNumbrLogin(inputTestDetails);
		loginPage.clickContinueButton();
		equipmentPage.createNewDemoAgreement();
		summaryTab.addCustomerDirect(inputTestDetails);
		equipmentPage.addFreeFormEquipOtherThaQuote();
		summaryTab.generateDemoAgreement();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	// Generate Blank Demo
	public static TestResultReport test_TCNQ007(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		// loginPage.dealerActNumbrLogin(inputTestDetails);
		loginPage.clickContinueButton();
		homePage.generateBlankDemo();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	// Generate blank rental
	public static TestResultReport test_TCNQ008(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		// loginPage.dealerActNumbrLogin(inputTestDetails);
		loginPage.clickContinueButton();
		homePage.generateBlankRental();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	// Generate Blank PO
	public static TestResultReport test_TCNQ009(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		// loginPage.dealerActNumbrLogin(inputTestDetails);
		loginPage.clickContinueButton();
		homePage.generateBlankPO();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	// Create proposal pdf of Rental type quote
	public static TestResultReport test_TCNQ0010(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		ProposalPage proposalPage = new ProposalPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		// loginPage.clickSignInButton();
		// CommonFunctions.waitForLoad(driver);
		// loginPage.dealerActNumbrLogin(inputTestDetails);
		loginPage.clickContinueButton();
		homePage.clickCreateQuote();
		summaryTab.enterQuoteName();
		summaryTab.selectQuoteType(inputTestDetails);
		summaryTab.addCustomer(inputTestDetails);
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.acceptAlert(driver);
		summaryTab.clickCreateQuoteButton();
		equipmentPage.addCollateralEquipment();
		equipmentPage.clickDoneOnLeftNav();
		homePage.naviagteProposalTab();
		proposalPage.clickGeneratePDF();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	// Create New Governmental quote
	public static TestResultReport test_TCNQ0011(InputTestDetails inputTestDetails,
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
		summaryTab.selectQuoteType(inputTestDetails);
		summaryTab.addCustomer(inputTestDetails);
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.acceptAlert(driver);
		summaryTab.clickCreateQuoteButton();
		equipmentPage.addCollateralEquip1();
		//equipmentPage.clickDoneOnLeftNav();
		homePage.naviagteProposalTab();
		proposalPage.clickGeneratePDF();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	// Create new New Quote_National Sales
	public static TestResultReport test_TCNQ0012(InputTestDetails inputTestDetails,
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
		summaryTab.addCustomer(inputTestDetails);
		summaryTab.selectQuoteType(inputTestDetails);
		summaryTab.selectDealerRadioBttn();
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.acceptAlert(driver);
		summaryTab.clickCreateQuoteButton();
		equipmentPage.addCollateralEquip1();
		//equipmentPage.clickDoneOnLeftNav();
		homePage.naviagteProposalTab();
		proposalPage.clickGeneratePDF();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	// Create Quote From company Master
	public static TestResultReport test_TCNQ0013(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		loginPage.clickContinueButton();
		homePage.clickCreateFromMaster();
		homePage.slctQuoteFrmCompnyMastr();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	// Create Quote From dealer Master
	public static TestResultReport test_TCNQ0014(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		loginPage.clickContinueButton();
		homePage.clickCreateFromMaster();
		homePage.slctQuoteFrmDealerMastr();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}
	
	public static TestResultReport test_TCNQ0015(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		//SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		//EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		loginPage.clickContinueButton();
		homePage.clickSearchQuote();
		homePage.searchQuote(inputTestDetails);
		homePage.verifySearchQuotePage();
		//homePage.slctQuoteFrmDealerMastr();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

}
