package com.deere.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.deere.global.CommonFunctions;
import com.deere.global.InputBrowserDetails;
import com.deere.global.InputEnvironmentDetails;
import com.deere.global.InputTestDetails;
import com.deere.global.TestResultReport;
import com.deere.pages.EquipmentPage;
import com.deere.pages.HomePage;
import com.deere.pages.LoginPage;
import com.deere.pages.SummaryPage;
import com.deere.pages.RecapPage;

public class RecapTest {

	//Generate RECAP Mobile friendly pdf
	public static TestResultReport test_TCNQ001(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception 
	   {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		RecapPage recapPage = new RecapPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		//loginPage.dealerActNumbrLogin(inputTestDetails);
		loginPage.clickContinueButton();
		homePage.clickCreateQuote();
		summaryTab.enterQuoteName();
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.acceptAlert(driver);
		summaryTab.clickCreateQuoteButton();
		//equipmentPage.addCollateralEquipment();
		equipmentPage.addFreeFormEquipCBD();
		recapPage.clickRecapTab();
		recapPage.clickMoblileFrndlyRecaPdf();		
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	    }

	//Verify Adjustments on RECAP page and Pricing page under Selling Equipment detail
	public static TestResultReport test_TCNQ002(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception 
	   {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		RecapPage recapPage = new RecapPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		//loginPage.dealerActNumbrLogin(inputTestDetails);
		loginPage.clickContinueButton();
		homePage.clickCreateQuote();
		summaryTab.enterQuoteName();
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.acceptAlert(driver);
		summaryTab.clickCreateQuoteButton();
		equipmentPage.addFreeFormEquipCBD();
		recapPage.clickRecapTab();
		recapPage.comprAdjstmnts();	
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	    }
	
	//verify List Price verification from pricing page
	public static TestResultReport test_TCNQ003(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception 
	   {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		RecapPage recapPage = new RecapPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		//loginPage.dealerActNumbrLogin(inputTestDetails);
		loginPage.clickContinueButton();
		homePage.clickCreateQuote();
		summaryTab.enterQuoteName();
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.acceptAlert(driver);
		summaryTab.clickCreateQuoteButton();
		equipmentPage.addFreeFormEquipCBD();
		recapPage.clickRecapTab();
		recapPage.comprListPriceFrmPricngPage();	
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	    }
	
	//verify Total Net Cost verification from pricing page
	public static TestResultReport test_TCNQ004(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception 
	   {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		RecapPage recapPage = new RecapPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		//loginPage.dealerActNumbrLogin(inputTestDetails);
		loginPage.clickContinueButton();
		homePage.clickCreateQuote();
		summaryTab.enterQuoteName();
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.acceptAlert(driver);
		summaryTab.clickCreateQuoteButton();
		equipmentPage.addFreeFormEquipCBD();
		recapPage.clickRecapTab();
		recapPage.comprTotalNetCostFrmPricngPage();	
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	    }
	
	//verify equipment names on selling section page and determining section page
	public static TestResultReport test_TCNQ005(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception 
	   {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		RecapPage recapPage = new RecapPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		//loginPage.dealerActNumbrLogin(inputTestDetails);
		loginPage.clickContinueButton();
		homePage.clickCreateQuote();
		summaryTab.enterQuoteName();
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.acceptAlert(driver);
		summaryTab.clickCreateQuoteButton();
		equipmentPage.addFreeFormEquipCBD();
		equipmentPage.addFreeFormEquipCBD();
		equipmentPage.addFreeFormEquipCBD();
		recapPage.clickRecapTab();
		recapPage.verifyEquipNamesUnderDeterminingSec();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	    }
	
	
	//Verifying addition of selling price of the componets with total selling price under Determining Sec
	public static TestResultReport test_TCNQ006(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception 
	   {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		RecapPage recapPage = new RecapPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		//loginPage.dealerActNumbrLogin(inputTestDetails);
		loginPage.clickContinueButton();
		homePage.selectPurchaseQuote();
		CommonFunctions.waitForLoad(driver);
		recapPage.clickRecapTab();
		recapPage.cmprTotalSellingPriceUnderDetermngSec();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	    }
	
	
	//Verifying Fees calculation on Recap Page
		public static TestResultReport test_TCNQ007(InputTestDetails inputTestDetails,
				InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
				throws WebDriverException, Exception 
		   {
			LoginPage loginPage = new LoginPage(driver);
			SummaryPage summaryTab = new SummaryPage(driver);
			HomePage homePage = new HomePage(driver);
			EquipmentPage equipmentPage = new EquipmentPage(driver);
			RecapPage recapPage = new RecapPage(driver);
			loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
			//loginPage.dealerActNumbrLogin(inputTestDetails);
			loginPage.clickContinueButton();
			homePage.selectPurchaseQuote();
			CommonFunctions.waitForLoad(driver);
			recapPage.clickRecapTab();
			recapPage.validateTotalFeeOnRecapPge();
			return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
					inputBrowserDetails);
		    }
		
		// verify and enter notes on RECAP page
		public static TestResultReport test_TCNQ0010(InputTestDetails inputTestDetails,
				InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
				throws WebDriverException, Exception {
			LoginPage loginPage = new LoginPage(driver);
			SummaryPage summaryTab = new SummaryPage(driver);
			HomePage homePage = new HomePage(driver);
			EquipmentPage equipmentPage = new EquipmentPage(driver);
			RecapPage recapPage = new RecapPage(driver);
			loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
			// loginPage.dealerActNumbrLogin(inputTestDetails);
			loginPage.clickContinueButton();
			homePage.selectPurchaseQuote();
			CommonFunctions.waitForLoad(driver);
			recapPage.clickRecapTab();
			recapPage.clickDealerNotes();
			recapPage.enterDealerNotes();
			return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
					inputBrowserDetails);
		}
		
		// Verify POPUp on Selling Equipment Detail
		
				public static TestResultReport test_TCNQ0011(InputTestDetails inputTestDetails,
						InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
						throws WebDriverException, Exception {
					LoginPage loginPage = new LoginPage(driver);
					SummaryPage summaryTab = new SummaryPage(driver);
					HomePage homePage = new HomePage(driver);
					EquipmentPage equipmentPage = new EquipmentPage(driver);
					RecapPage recapPage = new RecapPage(driver);
					loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
					// loginPage.dealerActNumbrLogin(inputTestDetails);
					loginPage.clickContinueButton();
					homePage.selectPurchaseQuote();
					CommonFunctions.waitForLoad(driver);
					recapPage.clickRecapTab();
					recapPage.verifyPopUp(recapPage.salesIncentive,recapPage.salesIncentivePopup);
					recapPage.verifyPopUp(recapPage.techOptsCP,recapPage.techOptsCPPopup);
					recapPage.verifyPopUp(recapPage.dealerAttachsCP,recapPage.dealerAttachsCPPopUp);
					recapPage.verifyPopUp(recapPage.prepaidVASInMarginCP,recapPage.prepaidVASInMarginCPPopUp);
					recapPage.verifyPopUp(recapPage.includedVASCP,recapPage.includedVASCPPopUp);
					recapPage.verifyPopUp(recapPage.powergrdCP,recapPage.powergrdCPPopUp);
					return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
							inputBrowserDetails);
				}
				
			//  Verify POPUp on Determine Selling Price
				
				public static TestResultReport test_TCNQ0032(InputTestDetails inputTestDetails,
						InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
								throws WebDriverException, Exception {
							LoginPage loginPage = new LoginPage(driver);
							SummaryPage summaryTab = new SummaryPage(driver);
							HomePage homePage = new HomePage(driver);
							EquipmentPage equipmentPage = new EquipmentPage(driver);
							RecapPage recapPage = new RecapPage(driver);
							loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
							// loginPage.dealerActNumbrLogin(inputTestDetails);
							loginPage.clickContinueButton();
							homePage.selectPurchaseQuote();
							CommonFunctions.waitForLoad(driver);
							recapPage.clickRecapTab();
							recapPage.verifyPopUp(recapPage.techOptsLP,recapPage.techOptsLPPopup);
							recapPage.verifyPopUp(recapPage.dealerAttachsLP,recapPage.dealerAttachsLPPopUp);
							recapPage.verifyPopUp(recapPage.prepaidVASInMarginLP,recapPage.prepaidVASInMarginLPPopUp);
							recapPage.verifyPopUp(recapPage.includedVASLP,recapPage.includedVASLPPopUp);
							recapPage.verifyPopUp(recapPage.powergrdLP,recapPage.powergrdLPPopUp);
							recapPage.verifyPopUp(recapPage.prepaidVASNotInMarginLP,recapPage.prepaidVASNotInMarginLPPopUp);
							recapPage.verifyPopUp(recapPage.nonEquipPPInMAr,recapPage.nonEquipPPInMArPopUp);
							recapPage.verifyPopUp(recapPage.nonEquipPPNInMar,recapPage.nonEquipPPNInMarPopUp);
							recapPage.verifyPopUp(recapPage.nonEquipIncInMargin,recapPage.nonEquipIncInMarginPopUp);
							return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
									inputBrowserDetails);
						}
	
}
