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
import com.deere.pages.POPage;
import com.deere.pages.SummaryPage;
import com.deere.pages.TradeInPage;
import com.deere.pages.ValueAddedServicesPage;

public class R2Test {
	
	public static String dealerActNumber = "3r2ah0";
	public static String constSerialNumber = "1LV3038EPBH311695";

	// Create a New quote and Add Customer for Russia
	
		public static TestResultReport test_TCNQ001(InputTestDetails inputTestDetails,
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
			 loginPage.enterDealerActNumber(dealerActNumber );
			 loginPage.clickGoButton();
			loginPage.clickContinueButton();
			homePage.clickCreateQuote();
			summaryTab.enterQuoteName();
			summaryTab.selectQuoteCurrency();
			summaryTab.addCustomerByEntityID(inputTestDetails);
			summaryTab.addSecondCustomer(inputTestDetails);
			summaryTab.clickCreateQuoteButton();
			CommonFunctions.acceptAlert(driver);
			summaryTab.clickCreateQuoteButton();
			
			
			return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
					inputBrowserDetails);
		}
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
			 loginPage.enterDealerActNumber(dealerActNumber );
			 loginPage.clickGoButton();
			loginPage.clickContinueButton();
			homePage.clickCreateQuote();
			summaryTab.enterQuoteName();
			summaryTab.selectQuoteCurrency();
			summaryTab.addCustomerByEntityID(inputTestDetails);
			summaryTab.addSecondCustomer(inputTestDetails);
			summaryTab.replace1stCustomer(inputTestDetails);
			summaryTab.replace2ndCustomer(inputTestDetails);
			Thread.sleep(2000);
			summaryTab.clickCreateQuoteButton();
			CommonFunctions.acceptAlert(driver);
			summaryTab.clickCreateQuoteButton();
			return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
					inputBrowserDetails);
		}

		
		// Delete second customer
		public static TestResultReport test_TCNQ003(InputTestDetails inputTestDetails,
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
			 loginPage.enterDealerActNumber(dealerActNumber );
			 loginPage.clickGoButton();
			loginPage.clickContinueButton();
			homePage.clickCreateQuote();
			summaryTab.enterQuoteName();
			summaryTab.selectQuoteCurrency();
			summaryTab.addCustomerByEntityID(inputTestDetails);
			summaryTab.addSecondCustomer(inputTestDetails);
			Thread.sleep(2000);
			summaryTab.deleteCustomer();
			Thread.sleep(2000);
			summaryTab.clickCreateQuoteButton();
			CommonFunctions.acceptAlert(driver);
			summaryTab.clickCreateQuoteButton();
			return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
					inputBrowserDetails);
		}
		
		// Copy From Another Quote
		public static TestResultReport test_TCNQ004(InputTestDetails inputTestDetails,
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
			 loginPage.enterDealerActNumber(dealerActNumber );
			 loginPage.clickGoButton();
			loginPage.clickContinueButton();
			homePage.clickCreateQuote();
			summaryTab.enterQuoteName();
			summaryTab.selectQuoteCurrency();
			summaryTab.clickCreateQuoteButton();
			CommonFunctions.acceptAlert(driver);
			summaryTab.clickCreateQuoteButton();
			equipmentPage.copyFromAnotherQuote_R2();
			return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
					inputBrowserDetails);
		}
		

		// Add equipment from Machine Finder Pro
		public static TestResultReport test_TCNQ006(InputTestDetails inputTestDetails,
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
			loginPage.enterDealerActNumber(dealerActNumber );
			loginPage.clickGoButton();
			loginPage.clickContinueButton();
			homePage.clickCreateQuote();
			summaryTab.enterQuoteName();
			summaryTab.selectQuoteCurrency();
			summaryTab.clickCreateQuoteButton();
			CommonFunctions.acceptAlert(driver);
			summaryTab.clickCreateQuoteButton();
			CommonFunctions.waitForLoad(driver);
			Thread.sleep(10000);
			equipmentPage.ClickOnmachineFinderProEquipment_R2();
			return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
					inputBrowserDetails);
		}

		// Add Equipment from Configurator
		public static TestResultReport test_TCNQ007(InputTestDetails inputTestDetails,
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
			loginPage.enterDealerActNumber(dealerActNumber );
			loginPage.clickGoButton();
			loginPage.clickContinueButton();
			homePage.clickCreateQuote();
			summaryTab.enterQuoteName();
			summaryTab.selectQuoteCurrency();
			summaryTab.clickCreateQuoteButton();
			CommonFunctions.acceptAlert(driver);
			summaryTab.clickCreateQuoteButton();
			CommonFunctions.waitForLoad(driver);
			Thread.sleep(10000);
			equipmentPage.addR2ConfigEquip(inputTestDetails);
			//equipmentPage.replaceFromCollateralOnEquipMentTab();
			//equipmentPage.reconfigureOnEquipmentTab();
			return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
					inputBrowserDetails);
		}
		
		// Add Equipment From FreeForm 

		public static TestResultReport test_TCNQ008(InputTestDetails inputTestDetails,
				InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
				throws WebDriverException, Exception {
			LoginPage loginPage = new LoginPage(driver);
			SummaryPage summaryTab = new SummaryPage(driver);
			HomePage homePage = new HomePage(driver);
			EquipmentPage equipmentPage = new EquipmentPage(driver);
			loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
			Thread.sleep(5000);
			loginPage.enterDealerActNumber(dealerActNumber );
			loginPage.clickGoButton();
			CommonFunctions.waitForLoad(driver);
			loginPage.clickContinueButton();
			homePage.clickCreateQuote();
			summaryTab.enterQuoteName();
			summaryTab.selectQuoteCurrency();
			summaryTab.clickCreateQuoteButton();
			CommonFunctions.acceptAlert(driver);
			summaryTab.clickCreateQuoteButton();
			equipmentPage.addFreeFormEquipment_R2();
			return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
					inputBrowserDetails);
		}
		
		// Verify Powergard Calculator 
		
		public static TestResultReport test_TCNQ009(InputTestDetails inputTestDetails,
				InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
				throws WebDriverException, Exception 
		{
			LoginPage loginPage = new LoginPage(driver);
			SummaryPage summaryTab = new SummaryPage(driver);
			HomePage homePage = new HomePage(driver);
			EquipmentPage equipmentPage = new EquipmentPage(driver);
			ValueAddedServicesPage valueAddedServicesPage = new ValueAddedServicesPage(driver);
			loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
			Thread.sleep(5000);
			loginPage.enterDealerActNumber(dealerActNumber );
			loginPage.clickGoButton();
			CommonFunctions.waitForLoad(driver);
			loginPage.clickContinueButton();
			homePage.selectPurchaseQuote();
			valueAddedServicesPage.verifyR2PGPCalc();
			return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
					inputBrowserDetails);
		}
		
		// Verify Powergard Maintenance Calculator
		
				public static TestResultReport test_TCNQ0010(InputTestDetails inputTestDetails,
						InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
						throws WebDriverException, Exception 
				{
					LoginPage loginPage = new LoginPage(driver);
					SummaryPage summaryTab = new SummaryPage(driver);
					HomePage homePage = new HomePage(driver);
					EquipmentPage equipmentPage = new EquipmentPage(driver);
					ValueAddedServicesPage valueAddedServicesPage = new ValueAddedServicesPage(driver);
					loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
					Thread.sleep(5000);
					loginPage.enterDealerActNumber(dealerActNumber );
					loginPage.clickGoButton();
					CommonFunctions.waitForLoad(driver);
					loginPage.clickContinueButton();
					homePage.selectPurchaseQuote();
					
					valueAddedServicesPage.verifyR2PGMaintenancePCalc();
					return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
							inputBrowserDetails);
				}
				
	// Create Deere To Dealer Quote
				public static TestResultReport test_TCNQ0011(InputTestDetails inputTestDetails,
						InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
						throws WebDriverException, Exception {
					LoginPage loginPage = new LoginPage(driver);
					SummaryPage summaryTab = new SummaryPage(driver);
					HomePage homePage = new HomePage(driver);
					EquipmentPage equipmentPage = new EquipmentPage(driver);
					loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
					Thread.sleep(5000);
					loginPage.enterDealerActNumber(dealerActNumber );
					loginPage.clickGoButton();
					CommonFunctions.waitForLoad(driver);
					loginPage.clickContinueButton();
					homePage.clickCreateQuote();
					summaryTab.enterQuoteName();
					summaryTab.selectQuoteType(inputTestDetails);
					summaryTab.selectQuoteCurrency();
					summaryTab.selectFinanceType();
					summaryTab.clickCreateQuoteButton();
					CommonFunctions.acceptAlert(driver);
					summaryTab.clickCreateQuoteButton();
					equipmentPage.addR2IncoConfigEquip(inputTestDetails);
					return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
							inputBrowserDetails);
				}
				
				
		

}
