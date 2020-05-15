package com.deere.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.deere.global.CommonFunctions;
import com.deere.global.InputBrowserDetails;
import com.deere.global.InputEnvironmentDetails;
import com.deere.global.InputTestDetails;
import com.deere.global.TestResultReport;
import com.deere.pages.AdministrationPage;
import com.deere.pages.CreateOrder;
import com.deere.pages.EquipmentPage;
import com.deere.pages.FinancePage;
import com.deere.pages.HomePage;
import com.deere.pages.LoginPage;
import com.deere.pages.NotesPage;
import com.deere.pages.POPage;
import com.deere.pages.ProposalPage;
import com.deere.pages.RFQPage;
import com.deere.pages.RecapPage;
import com.deere.pages.SendToJDFPage;
import com.deere.pages.SummaryPage;
import com.deere.pages.TradeInPage;
import com.deere.pages.ValueAddedServicesPage;

public class QualTest {
	
	public static String dealerActNumber = "010102";
	public static String constSerialNumber = "1LV3038EPBH311695";
	public static String uniqueQuoteName = "TestQuote9";
	
	//************************* Summary***********************************************

	public static TestResultReport test_TCNQ001(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		//CommonFunctions.waitForLoad(driver);
		Thread.sleep(5000);
		 //loginPage.enterDealerActNumber(dealerActNumber );
		// loginPage.clickGoButton();
		loginPage.clickContinueButton();
		homePage.clickCreateQuote();
		summaryTab.enterQuoteName();
		summaryTab.addFirstCustomer(inputTestDetails);
		summaryTab.addSecondCustomer(inputTestDetails);
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.acceptAlert(driver);
		summaryTab.clickCreateQuoteButton();
		
		
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}
	
	// Replace 1st and second customer
			public static TestResultReport test_TCNQ002(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
					throws WebDriverException, Exception {
				LoginPage loginPage = new LoginPage(driver);
				SummaryPage summaryTab = new SummaryPage(driver);
				HomePage homePage = new HomePage(driver);
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				//CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				/*loginPage.enterDealerActNumber(dealerActNumber );
				loginPage.clickGoButton();*/
				loginPage.clickContinueButton();
				homePage.clickCreateQuote();
				summaryTab.enterQuoteName();
				summaryTab.addFirstCustomer(inputTestDetails);
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
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				//CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				/* loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();
				homePage.clickCreateQuote();
				summaryTab.enterQuoteName();
				summaryTab.addFirstCustomer(inputTestDetails);
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
			
			//*********************************************** Equipment*******************************************************
			public static TestResultReport test_TCNQ004(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
				LoginPage loginPage = new LoginPage(driver);
				SummaryPage summaryTab = new SummaryPage(driver);
				HomePage homePage = new HomePage(driver);
				EquipmentPage equipmentPage = new EquipmentPage(driver);
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				//CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				 /*loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();
				homePage.clickCreateQuote();
				summaryTab.enterQuoteName();
				summaryTab.clickCreateQuoteButton();
				CommonFunctions.acceptAlert(driver);
				summaryTab.clickCreateQuoteButton();
				equipmentPage.clickOnDBSTab();
				Thread.sleep(3000);
				equipmentPage.enterSerialNumber(constSerialNumber);
				equipmentPage.clickSearchedSerialNumberLink();
				equipmentPage.clickOnAddSelected();
				equipmentPage.comparisionOfOptionsCodes();
				return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);
			}

			// DBS Parts
			public static TestResultReport test_TCNQ005(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
				LoginPage loginPage = new LoginPage(driver);
				SummaryPage summaryTab = new SummaryPage(driver);
				HomePage homePage = new HomePage(driver);
				EquipmentPage equipmentPage = new EquipmentPage(driver);
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				//CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				 /*loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();
				homePage.clickCreateQuote();
				summaryTab.enterQuoteName();
				summaryTab.clickCreateQuoteButton();
				CommonFunctions.acceptAlert(driver);
				summaryTab.clickCreateQuoteButton();
				equipmentPage.addDBSParts();
				return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);

			}

			// Copy From Another Quote
			public static TestResultReport test_TCNQ006(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
				LoginPage loginPage = new LoginPage(driver);
				SummaryPage summaryTab = new SummaryPage(driver);
				HomePage homePage = new HomePage(driver);
				EquipmentPage equipmentPage = new EquipmentPage(driver);
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				//CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				/* loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();
				homePage.clickCreateQuote();
				summaryTab.enterQuoteName();
				summaryTab.clickCreateQuoteButton();
				CommonFunctions.acceptAlert(driver);
				summaryTab.clickCreateQuoteButton();
				equipmentPage.copyFromAnotherQuote();
				return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);
			}

			// Build And Price
			public static TestResultReport test_TCNQ007(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
				LoginPage loginPage = new LoginPage(driver);
				SummaryPage summaryTab = new SummaryPage(driver);
				HomePage homePage = new HomePage(driver);
				EquipmentPage equipmentPage = new EquipmentPage(driver);
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				//CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				 /*loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();
				Thread.sleep(5000);
				homePage.clickCreateQuote();
				summaryTab.enterQuoteName();
				summaryTab.selectQuoteType(inputTestDetails);
				summaryTab.clickCreateQuoteButton();
				CommonFunctions.acceptAlert(driver);
				summaryTab.clickCreateQuoteButton();
				equipmentPage.addEquipmentFromBNP();
		        return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);
			}

			// Equipment From Build & Price Model List
			public static TestResultReport test_TCNQ008(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
				LoginPage loginPage = new LoginPage(driver);
				SummaryPage summaryTab = new SummaryPage(driver);
				HomePage homePage = new HomePage(driver);
				EquipmentPage equipmentPage = new EquipmentPage(driver);
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				//CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				/* loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();
				Thread.sleep(10000);
				homePage.clickCreateQuote();
				summaryTab.enterQuoteName();
				summaryTab.selectQuoteType(inputTestDetails);
				summaryTab.clickCreateQuoteButton();
				CommonFunctions.acceptAlert(driver);
				summaryTab.clickCreateQuoteButton();
				equipmentPage.addEquipmentFromBNPModelList();
				
				return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);
			}

			// Equipment From JDSC DBS
			public static TestResultReport test_TCNQ009(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
				LoginPage loginPage = new LoginPage(driver);
				SummaryPage summaryTab = new SummaryPage(driver);
				HomePage homePage = new HomePage(driver);
				EquipmentPage equipmentPage = new EquipmentPage(driver);
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				//CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				/* loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();
				Thread.sleep(10000);
				homePage.clickCreateQuote();
				summaryTab.enterQuoteName();
				summaryTab.selectQuoteType(inputTestDetails);
				summaryTab.clickCreateQuoteButton();
				CommonFunctions.acceptAlert(driver);
				summaryTab.clickCreateQuoteButton();
				// equipmentPage.clickOnEquipmentTab();
				equipmentPage.addEquipmentFromJDSCDBS();
				return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);
			}

			// Equipment From JDSC DBS By Search
			public static TestResultReport test_TCNQ0010(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
				LoginPage loginPage = new LoginPage(driver);
				SummaryPage summaryTab = new SummaryPage(driver);
				HomePage homePage = new HomePage(driver);
				EquipmentPage equipmentPage = new EquipmentPage(driver);
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				Thread.sleep(5000);
				/* loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();
				Thread.sleep(10000);
				homePage.clickCreateQuote();
				summaryTab.enterQuoteName();
				summaryTab.selectQuoteType(inputTestDetails);
				summaryTab.clickCreateQuoteButton();
				CommonFunctions.acceptAlert(driver);
				summaryTab.clickCreateQuoteButton();
				equipmentPage.addEquipmentFromJDSCDBSBySearch();
				equipmentPage.pricingCalc(equipmentPage.equipOptCostPrice, equipmentPage.equipOptListPrice,
						equipmentPage.totEquipCostPrice, equipmentPage.totEquipListPrice);
				equipmentPage.pricingCalc(equipmentPage.adjustmentCostPrice, equipmentPage.adjustmntListPrice,
						equipmentPage.totAdjCostPrice, equipmentPage.totAdjListPrice);
				if (equipmentPage.techOptChkBox.isDisplayed())
					equipmentPage.pricingCalc(equipmentPage.techOptCostPrice, equipmentPage.techOptListPrice,
							equipmentPage.techOptTotCostPrice, equipmentPage.techOptTotListPrice);
				if (equipmentPage.attachmetChkBox.isDisplayed())
					equipmentPage.pricingCalc(equipmentPage.attCostPrice, equipmentPage.attListPrice,
							equipmentPage.attTotCostPrice, equipmentPage.attTotListPrice);
				return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);
			}

			// Verify  Collateral equipment
			public static TestResultReport test_TCNQ0011(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
				LoginPage loginPage = new LoginPage(driver);
				SummaryPage summaryTab = new SummaryPage(driver);
				HomePage homePage = new HomePage(driver);
				EquipmentPage equipmentPage = new EquipmentPage(driver);
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				//CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				/* loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();
				homePage.clickCreateQuote();
				summaryTab.enterQuoteName();
				summaryTab.clickCreateQuoteButton();
				CommonFunctions.acceptAlert(driver);
				summaryTab.clickCreateQuoteButton();
				equipmentPage.clickOnDBSTab();
				equipmentPage.enterSerialNumber(constSerialNumber);
				equipmentPage.clickSearchedSerialNumberLink();
				equipmentPage.comparisionOfOptionsCodes();
				return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);
			}

			// Add equipment from Machine Finder Pro
			public static TestResultReport test_TCNQ0012(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
				LoginPage loginPage = new LoginPage(driver);
				SummaryPage summaryTab = new SummaryPage(driver);
				HomePage homePage = new HomePage(driver);
				EquipmentPage equipmentPage = new EquipmentPage(driver);
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				//CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				 /*loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();
				homePage.clickCreateQuote();
				summaryTab.enterQuoteName();
				summaryTab.clickCreateQuoteButton();
				CommonFunctions.acceptAlert(driver);
				summaryTab.clickCreateQuoteButton();
				CommonFunctions.waitForLoad(driver);
				Thread.sleep(10000);
				equipmentPage.ClickOnmachineFinderProEquipment();
				return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);
			}

			// Add Equipment from Configurator
			public static TestResultReport test_TCNQ0013(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
				LoginPage loginPage = new LoginPage(driver);
				SummaryPage summaryTab = new SummaryPage(driver);
				HomePage homePage = new HomePage(driver);
				EquipmentPage equipmentPage = new EquipmentPage(driver);
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				//CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				 /*loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				 Thread.sleep(5000);
				loginPage.clickContinueButton();
				homePage.clickCreateQuote();
				summaryTab.enterQuoteName();
				summaryTab.clickCreateQuoteButton();
				CommonFunctions.acceptAlert(driver);
				summaryTab.clickCreateQuoteButton();
				CommonFunctions.waitForLoad(driver);
				Thread.sleep(10000);
				equipmentPage.clickOnConfiguratorLink();
				equipmentPage.replaceFromCollateralOnEquipMentTab();
				return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);
			}
			// Add Equipment From FreeForm 

				public static TestResultReport test_TCNQ0014(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
					LoginPage loginPage = new LoginPage(driver);
					SummaryPage summaryTab = new SummaryPage(driver);
					HomePage homePage = new HomePage(driver);
					EquipmentPage equipmentPage = new EquipmentPage(driver);
					loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
					//CommonFunctions.waitForLoad(driver);
					Thread.sleep(5000);
					 /*loginPage.enterDealerActNumber(dealerActNumber );
					 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();
				homePage.clickCreateQuote();
				summaryTab.enterQuoteName();
				summaryTab.clickCreateQuoteButton();
				CommonFunctions.acceptAlert(driver);
				summaryTab.clickCreateQuoteButton();
				equipmentPage.addFreeFormEquipment();
				return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);
			}


			//	Add equipment from collateral
			public static TestResultReport test_TCNQ0015(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
				LoginPage loginPage = new LoginPage(driver);
				SummaryPage summaryTab = new SummaryPage(driver);
				HomePage homePage = new HomePage(driver);
				EquipmentPage equipmentPage = new EquipmentPage(driver);
				TradeInPage tradeInPage = new TradeInPage(driver);
				POPage poPage = new POPage(driver);
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				//CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				 /*loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();
				homePage.clickCreateQuote();
				summaryTab.enterQuoteName();
				summaryTab.clickCreateQuoteButton();
				CommonFunctions.acceptAlert(driver);
				summaryTab.clickCreateQuoteButton();
				CommonFunctions.waitForLoad(driver);
				Thread.sleep(10000);
				equipmentPage.addCollateralEquipmentOnEquipmentTab();
				return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);
			}

//			Add equipment from Frontier Configurator
			public static TestResultReport test_TCNQ0016(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
				LoginPage loginPage = new LoginPage(driver);
				SummaryPage summaryTab = new SummaryPage(driver);
				HomePage homePage = new HomePage(driver);
				EquipmentPage equipmentPage = new EquipmentPage(driver);
				TradeInPage tradeInPage = new TradeInPage(driver);
				POPage poPage = new POPage(driver);
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				//CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				 /*loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();
				homePage.clickCreateQuote();
				summaryTab.enterQuoteName();
				summaryTab.clickCreateQuoteButton();
				CommonFunctions.acceptAlert(driver);
				summaryTab.clickCreateQuoteButton();
				CommonFunctions.waitForLoad(driver);
				Thread.sleep(10000);
				equipmentPage.clickOnFrontierEquipment();
				return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);
			}
			
	//**************************************** End Of Equipment *******************************************************************
			
	//******************************************* Trade In*************************************************************************
			public static TestResultReport test_TCNQ0017(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception 
			{	
				LoginPage loginPage = new LoginPage(driver);
				HomePage homePage = new HomePage(driver);			
				TradeInPage tradeInPage = new TradeInPage(driver);			
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				//CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				 /*loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();		
				homePage.selectPurchaseQuote();		
				CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				tradeInPage.clickOnTradeInTab();
				tradeInPage.freeFormtradeInMakeAndModelSelect();
				tradeInPage.tradeInNamesPresentOnTradeIntab();
				tradeInPage.validateTradeInsPrices();
				//tradeInPage.validateTradeInsPrices();

				return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);	
			}


			public static TestResultReport test_TCNQ0018(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception 
			{	
				LoginPage loginPage = new LoginPage(driver);
				HomePage homePage = new HomePage(driver);
				TradeInPage tradeInPage = new TradeInPage(driver);
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				//CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				 /*loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();		
				homePage.selectPurchaseQuote();		
				CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				tradeInPage.clickOnTradeInTab();
				Thread.sleep(5000);
				tradeInPage.addTradeIn();	
				tradeInPage.tradeInNamesPresentOnTradeIntab();
				tradeInPage.validateTradeInsPrices();
				return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);	
			}


			public static TestResultReport test_TCNQ0019(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception 
			{	
				LoginPage loginPage = new LoginPage(driver);
				HomePage homePage = new HomePage(driver);
				TradeInPage tradeInPage = new TradeInPage(driver);
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				//CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				 /*loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();		
				homePage.selectPurchaseQuote();		
				CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				tradeInPage.clickOnTradeInTab();
				Thread.sleep(5000);
				tradeInPage.machineFinderProTradeIn();	
				tradeInPage.tradeInNamesPresentOnTradeIntab();
				tradeInPage.validateTradeInsPrices();	
				//		tradeInPage.dragAndDropAssociateTradeIn();	
				return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);	
			}

			public static TestResultReport test_TCNQ0020(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception 
			{	
				LoginPage loginPage = new LoginPage(driver);
				HomePage homePage = new HomePage(driver);
				TradeInPage tradeInPage = new TradeInPage(driver);
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				//CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				/* loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();		
				homePage.selectPurchaseQuote();		
				CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				tradeInPage.select1stTradeIn();
				tradeInPage.cmprTotalSellingPriceUnderDetermngSec();
				Thread.sleep(5000);
				tradeInPage.cmprFinalTradeAllowanceUnderDetermngSec();
				return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);	
			}
			//	Add Trade ins from all resources
			public static TestResultReport test_TCNQ0021(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception 
			{	
				LoginPage loginPage = new LoginPage(driver);
				HomePage homePage = new HomePage(driver);
				EquipmentPage equipmentPage = new EquipmentPage(driver);
				TradeInPage tradeInPage = new TradeInPage(driver);
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				//CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				/* loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();		
				homePage.selectPurchaseQuote();		
				CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				equipmentPage.clickOnEquipmentTab();
				equipmentPage.copyEquipmentbySelecting();
				Thread.sleep(5000);
				tradeInPage.clickOnTradeInTab();	
				Thread.sleep(5000);
				tradeInPage.addTradeIn();
				tradeInPage.freeFormtradeInMakeAndModelSelect();
				Thread.sleep(5000);
				tradeInPage.machineFinderProTradeIn();
		tradeInPage.tradeInNamesPresentOnTradeIntab();
				tradeInPage.reorderTradeIns();	
				tradeInPage.writeTradeInDescription();	
				tradeInPage.dragAndDropAssociateTradeIn();	

				return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);	
			}

			//MDP Assessment
			public static TestResultReport test_TCNQ0022(InputTestDetails inputTestDetails,
					InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception 
			{	
				LoginPage loginPage = new LoginPage(driver);
				HomePage homePage = new HomePage(driver);
				TradeInPage tradeInPage = new TradeInPage(driver);
				loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
				//CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				 /*loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();		
				homePage.selectPurchaseQuote();		
				CommonFunctions.waitForLoad(driver);
				Thread.sleep(5000);
				tradeInPage.clickOnTradeInTab();	
				tradeInPage.addMDPTrdIn();
				tradeInPage.select1stTradeIn();
				tradeInPage.cmprTotalSellingPriceUnderDetermngSec();
				Thread.sleep(5000);

				tradeInPage.cmprFinalTradeAllowanceUnderDetermngSec();
				return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);	
			}
			
	// ************************************** End Of Trade In*******************************************************************************

	// ***********************************************Recap Page*********************************************************************************
			public static TestResultReport test_TCNQ0023(InputTestDetails inputTestDetails,
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
				Thread.sleep(5000);
				/* loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
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
			public static TestResultReport test_TCNQ0024(InputTestDetails inputTestDetails,
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
				Thread.sleep(5000);
				 /*loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
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
			public static TestResultReport test_TCNQ0025(InputTestDetails inputTestDetails,
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
				Thread.sleep(5000);
				 /*loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
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
			public static TestResultReport test_TCNQ0026(InputTestDetails inputTestDetails,
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
				Thread.sleep(5000);
				/* loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
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
			public static TestResultReport test_TCNQ0027(InputTestDetails inputTestDetails,
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
				Thread.sleep(5000);
				 /*loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
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
			public static TestResultReport test_TCNQ0028(InputTestDetails inputTestDetails,
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
				Thread.sleep(5000);
				 /*loginPage.enterDealerActNumber(dealerActNumber );
				 loginPage.clickGoButton();*/
				loginPage.clickContinueButton();
				homePage.selectPurchaseQuote();
				CommonFunctions.waitForLoad(driver);
				recapPage.clickRecapTab();
				recapPage.cmprTotalSellingPriceUnderDetermngSec();
				return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
						inputBrowserDetails);
			    }
			
			
			//Verifying Fees calculation on Recap Page
				public static TestResultReport test_TCNQ0029(InputTestDetails inputTestDetails,
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
					Thread.sleep(5000);
					/* loginPage.enterDealerActNumber(dealerActNumber );
					 loginPage.clickGoButton();*/
					loginPage.clickContinueButton();
					homePage.selectPurchaseQuote();
					CommonFunctions.waitForLoad(driver);
					recapPage.clickRecapTab();
					recapPage.validateTotalFeeOnRecapPge();
					return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
							inputBrowserDetails);
				    }
				
				// verify and enter notes on RECAP page
				public static TestResultReport test_TCNQ0030(InputTestDetails inputTestDetails,
						InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
						throws WebDriverException, Exception {
					LoginPage loginPage = new LoginPage(driver);
					SummaryPage summaryTab = new SummaryPage(driver);
					HomePage homePage = new HomePage(driver);
					EquipmentPage equipmentPage = new EquipmentPage(driver);
					RecapPage recapPage = new RecapPage(driver);
					loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
					// loginPage.dealerActNumbrLogin(inputTestDetails);
					Thread.sleep(5000);
					 /*loginPage.enterDealerActNumber(dealerActNumber );
					 loginPage.clickGoButton();*/
					loginPage.clickContinueButton();
					homePage.selectPurchaseQuote();
					CommonFunctions.waitForLoad(driver);
					recapPage.clickRecapTab();
					recapPage.clickDealerNotes();
					recapPage.enterDealerNotes();
					return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
							inputBrowserDetails);
				}
			//  Verify POPUp on Selling Equipment Detail
				
				public static TestResultReport test_TCNQ0031(InputTestDetails inputTestDetails,
						InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
						throws WebDriverException, Exception {
					LoginPage loginPage = new LoginPage(driver);
					SummaryPage summaryTab = new SummaryPage(driver);
					HomePage homePage = new HomePage(driver);
					EquipmentPage equipmentPage = new EquipmentPage(driver);
					RecapPage recapPage = new RecapPage(driver);
					loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
					// loginPage.dealerActNumbrLogin(inputTestDetails);
					Thread.sleep(5000);
					 /*loginPage.enterDealerActNumber(dealerActNumber );
					 loginPage.clickGoButton();*/
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
					Thread.sleep(5000);
					/* loginPage.enterDealerActNumber(dealerActNumber );
					 loginPage.clickGoButton();*/
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
		
		//************************************************************ End Of Recap Page**********************************************************************************
		
		//************************************************************* Proposal Page ***************************************************************************************
		
		public static TestResultReport test_TCNQ0033(InputTestDetails inputTestDetails,
				InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
				throws WebDriverException, Exception {

			LoginPage loginPage = new LoginPage(driver);
			SummaryPage summaryTab = new SummaryPage(driver);
			HomePage homePage = new HomePage(driver);
			EquipmentPage equipmentPage = new EquipmentPage(driver);
			TradeInPage tradeInPage = new TradeInPage(driver);
			POPage poPage = new POPage(driver);
			ProposalPage proposalPage = new ProposalPage(driver);
			loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
			CommonFunctions.waitForLoad(driver);
			Thread.sleep(5000);
			 /*loginPage.enterDealerActNumber(dealerActNumber );
			 loginPage.clickGoButton();*/
			loginPage.clickContinueButton();
			homePage.selectPurchaseQuote();
			CommonFunctions.waitForLoad(driver);
			Thread.sleep(5000);
			proposalPage.proposalTab();		
			return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
					inputBrowserDetails);
		}
		
		// Verify Proposal PDF With Mandatory Fields Only
		
		public static TestResultReport test_TCNQ0034(InputTestDetails inputTestDetails,
				InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
				throws WebDriverException, Exception {

			LoginPage loginPage = new LoginPage(driver);
			SummaryPage summaryTab = new SummaryPage(driver);
			HomePage homePage = new HomePage(driver);
			EquipmentPage equipmentPage = new EquipmentPage(driver);
			TradeInPage tradeInPage = new TradeInPage(driver);
			POPage poPage = new POPage(driver);
			ProposalPage proposalPage = new ProposalPage(driver);
			loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
			CommonFunctions.waitForLoad(driver);
			Thread.sleep(5000);
			 /*loginPage.enterDealerActNumber(dealerActNumber );
			 loginPage.clickGoButton();*/
			loginPage.clickContinueButton();
			homePage.selectPurchaseQuote();
			CommonFunctions.waitForLoad(driver);
			Thread.sleep(5000);
			proposalPage.proposalWithManPages();
			return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
					inputBrowserDetails);
		}
		
	//********************************************************** End Of Proposal Page****************************************************************************************
		
	//**************************************************************Notes History Page***********************************************************************************
		public static TestResultReport test_TCNQ0035(InputTestDetails inputTestDetails,
				InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
				throws WebDriverException, Exception {

			LoginPage loginPage = new LoginPage(driver);
			SummaryPage summaryTab = new SummaryPage(driver);
			HomePage homePage = new HomePage(driver);
			EquipmentPage equipmentPage = new EquipmentPage(driver);
			TradeInPage tradeInPage = new TradeInPage(driver);
			POPage poPage = new POPage(driver);

			ProposalPage proposalPage = new ProposalPage(driver);
			NotesPage notesPage = new NotesPage(driver);

			loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");

			CommonFunctions.waitForLoad(driver);
			Thread.sleep(5000);
			 /*loginPage.enterDealerActNumber(dealerActNumber );
			 loginPage.clickGoButton();*/

			loginPage.clickContinueButton();

			homePage.selectPurchaseQuote();

			CommonFunctions.waitForLoad(driver);
			Thread.sleep(5000);

			notesPage.clickOnNotesHistorytab();

			return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
					inputBrowserDetails);

		}
		
		public static TestResultReport test_TCNQ0036(InputTestDetails inputTestDetails,
				InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
				throws WebDriverException, Exception {

			LoginPage loginPage = new LoginPage(driver);
			SummaryPage summaryTab = new SummaryPage(driver);
			HomePage homePage = new HomePage(driver);
			EquipmentPage equipmentPage = new EquipmentPage(driver);
			TradeInPage tradeInPage = new TradeInPage(driver);
			POPage poPage = new POPage(driver);

			ProposalPage proposalPage = new ProposalPage(driver);
			NotesPage notesPage = new NotesPage(driver);

			loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");

			CommonFunctions.waitForLoad(driver);
			Thread.sleep(5000);
			 /*loginPage.enterDealerActNumber(dealerActNumber );
			 loginPage.clickGoButton();*/
			loginPage.clickContinueButton();
			homePage.selectPurchaseQuote();
			summaryTab.changeQuoteStatus();
			notesPage.verifystatusChange();
			return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
					inputBrowserDetails);

		}
		
		// Copy Quote Functionality	
				public static TestResultReport test_TCNQ0037(InputTestDetails inputTestDetails,
						InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
						throws WebDriverException, Exception {
					LoginPage loginPage = new LoginPage(driver);
					SummaryPage summaryTab = new SummaryPage(driver);
					HomePage homePage = new HomePage(driver);
					EquipmentPage equipmentPage = new EquipmentPage(driver);
					FinancePage financepage = new FinancePage(driver);
					loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
					Thread.sleep(5000);
					Thread.sleep(5000);
					 /*loginPage.enterDealerActNumber(dealerActNumber );
					 loginPage.clickGoButton();*/
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
				
			//******************************************************** End Of Notes History*****************************************************************************************
			// **************************************************************Quote Types and Agreements******************************************************************************
				// Create Demo Agreement from quote
					public static TestResultReport test_TCNQ0038(InputTestDetails inputTestDetails,
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
						Thread.sleep(5000);
						 /*loginPage.enterDealerActNumber(dealerActNumber );
						 loginPage.clickGoButton();*/
						loginPage.clickContinueButton();
						homePage.clickCreateQuote();
						summaryTab.enterQuoteName();
						summaryTab.selectQuoteType(inputTestDetails);
						summaryTab.addCustomer(inputTestDetails);
						summaryTab.clickCreateQuoteButton();
						CommonFunctions.acceptAlert(driver);
						summaryTab.clickCreateQuoteButton();
						equipmentPage.addFreeFormEquipment();
						equipmentPage.createDemoAgreementOnLeftNav();
						summaryTab.generateDemoAgreement();
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);
					}

					// Create Rental Agreement from quote
					public static TestResultReport test_TCNQ0039(InputTestDetails inputTestDetails,
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
						Thread.sleep(5000);
						 /*loginPage.enterDealerActNumber(dealerActNumber );
						 loginPage.clickGoButton();*/
						loginPage.clickContinueButton();
						homePage.clickCreateQuote();
						summaryTab.enterQuoteName();
						summaryTab.selectQuoteType(inputTestDetails);
						summaryTab.addCustomer(inputTestDetails);
						summaryTab.clickCreateQuoteButton();
						CommonFunctions.acceptAlert(driver);
						summaryTab.clickCreateQuoteButton();
						equipmentPage.addFreeFormEquipment();
						equipmentPage.createRentalAgreementOnLeftNav();
						summaryTab.selectPurchaserType(inputTestDetails);
						summaryTab.selectMarketUse(inputTestDetails);
						summaryTab.selectDayOut();
						summaryTab.generateRentalAgreement();
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);
					}

					public static TestResultReport test_TCNQ0040(InputTestDetails inputTestDetails,
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
						Thread.sleep(5000);
						/* loginPage.enterDealerActNumber(dealerActNumber );
						 loginPage.clickGoButton();*/
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
					
//					Create Purchase Order
					public static TestResultReport test_TCNQ0041(InputTestDetails inputTestDetails,
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
						 /*loginPage.enterDealerActNumber(dealerActNumber );
						 loginPage.clickGoButton();	*/
						loginPage.clickContinueButton();		
						homePage.clickCreateQuote();
						summaryTab.enterQuoteName();
						Thread.sleep(2000);
						summaryTab.selectQuoteType(inputTestDetails);
						summaryTab.addCustomer(inputTestDetails);
						summaryTab.clickCreateQuoteButton();
						CommonFunctions.acceptAlert(driver);
						summaryTab.clickCreateQuoteButton();
						Thread.sleep(5000);		
						poPage.generatePO();
						poPage.viewPO();
						poPage.deletePO();				
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);
					}

					// Create new Rental Agreement on left navigation pane
					public static TestResultReport test_TCNQ0042(InputTestDetails inputTestDetails,
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
						LoginPage loginPage = new LoginPage(driver);
						SummaryPage summaryTab = new SummaryPage(driver);
						HomePage homePage = new HomePage(driver);
						EquipmentPage equipmentPage = new EquipmentPage(driver);
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
						// loginPage.dealerActNumbrLogin(inputTestDetails);
						Thread.sleep(5000);
						 /*loginPage.enterDealerActNumber(dealerActNumber );
						 loginPage.clickGoButton();*/
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
					public static TestResultReport test_TCNQ0043(InputTestDetails inputTestDetails,
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
						LoginPage loginPage = new LoginPage(driver);
						SummaryPage summaryTab = new SummaryPage(driver);
						HomePage homePage = new HomePage(driver);
						EquipmentPage equipmentPage = new EquipmentPage(driver);
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
						// loginPage.dealerActNumbrLogin(inputTestDetails);
						Thread.sleep(5000);
						 /*loginPage.enterDealerActNumber(dealerActNumber );
						 loginPage.clickGoButton();*/
						loginPage.clickContinueButton();
						equipmentPage.createNewDemoAgreement();
						summaryTab.addCustomerDirect(inputTestDetails);
						equipmentPage.addFreeFormEquipOtherThaQuote();
						summaryTab.generateDemoAgreement();
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);
					}

					// Generate Blank Demo
					public static TestResultReport test_TCNQ0044(InputTestDetails inputTestDetails,
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
						LoginPage loginPage = new LoginPage(driver);
						SummaryPage summaryTab = new SummaryPage(driver);
						HomePage homePage = new HomePage(driver);
						EquipmentPage equipmentPage = new EquipmentPage(driver);
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
						// loginPage.dealerActNumbrLogin(inputTestDetails);
						Thread.sleep(5000);
						/* loginPage.enterDealerActNumber(dealerActNumber );
						 loginPage.clickGoButton();*/
						loginPage.clickContinueButton();
						homePage.generateBlankDemo();
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);
					}

					// Generate blank rental
					public static TestResultReport test_TCNQ0045(InputTestDetails inputTestDetails,
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
						LoginPage loginPage = new LoginPage(driver);
						SummaryPage summaryTab = new SummaryPage(driver);
						HomePage homePage = new HomePage(driver);
						EquipmentPage equipmentPage = new EquipmentPage(driver);
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
						// loginPage.dealerActNumbrLogin(inputTestDetails);
						Thread.sleep(5000);
						 /*loginPage.enterDealerActNumber(dealerActNumber );
						 loginPage.clickGoButton();*/
						loginPage.clickContinueButton();
						homePage.generateBlankRental();
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);
					}

					// Generate Blank PO
					public static TestResultReport test_TCNQ0046(InputTestDetails inputTestDetails,
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
						LoginPage loginPage = new LoginPage(driver);
						SummaryPage summaryTab = new SummaryPage(driver);
						HomePage homePage = new HomePage(driver);
						EquipmentPage equipmentPage = new EquipmentPage(driver);
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
						// loginPage.dealerActNumbrLogin(inputTestDetails);
						Thread.sleep(5000);
						 /*loginPage.enterDealerActNumber(dealerActNumber );
						 loginPage.clickGoButton();*/
						loginPage.clickContinueButton();
						homePage.generateBlankPO();
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);
					}

					// Create proposal pdf of Rental type quote
					public static TestResultReport test_TCNQ0047(InputTestDetails inputTestDetails,
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
						Thread.sleep(5000);
						 /*loginPage.enterDealerActNumber(dealerActNumber );
						 loginPage.clickGoButton();*/
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
					public static TestResultReport test_TCNQ0048(InputTestDetails inputTestDetails,
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
						LoginPage loginPage = new LoginPage(driver);
						SummaryPage summaryTab = new SummaryPage(driver);
						HomePage homePage = new HomePage(driver);
						EquipmentPage equipmentPage = new EquipmentPage(driver);
						ProposalPage proposalPage = new ProposalPage(driver);
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
						// loginPage.dealerActNumbrLogin(inputTestDetails);
						Thread.sleep(5000);
						 /*loginPage.enterDealerActNumber(dealerActNumber );
						 loginPage.clickGoButton();*/
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
					public static TestResultReport test_TCNQ0049(InputTestDetails inputTestDetails,
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
						LoginPage loginPage = new LoginPage(driver);
						SummaryPage summaryTab = new SummaryPage(driver);
						HomePage homePage = new HomePage(driver);
						EquipmentPage equipmentPage = new EquipmentPage(driver);
						ProposalPage proposalPage = new ProposalPage(driver);
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
						// loginPage.dealerActNumbrLogin(inputTestDetails);
						Thread.sleep(5000);
						/* loginPage.enterDealerActNumber(dealerActNumber );
						 loginPage.clickGoButton();*/
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
					public static TestResultReport test_TCNQ0050(InputTestDetails inputTestDetails,
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
						LoginPage loginPage = new LoginPage(driver);
						SummaryPage summaryTab = new SummaryPage(driver);
						HomePage homePage = new HomePage(driver);
						EquipmentPage equipmentPage = new EquipmentPage(driver);
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
						Thread.sleep(5000);
						 /*loginPage.enterDealerActNumber(dealerActNumber );
						 loginPage.clickGoButton();*/
						loginPage.clickContinueButton();
						homePage.clickCreateFromMaster();
						homePage.slctQuoteFrmCompnyMastr();
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);
					}

					// Create Quote From dealer Master
					public static TestResultReport test_TCNQ0051(InputTestDetails inputTestDetails,
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
						LoginPage loginPage = new LoginPage(driver);
						SummaryPage summaryTab = new SummaryPage(driver);
						HomePage homePage = new HomePage(driver);
						EquipmentPage equipmentPage = new EquipmentPage(driver);
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
						Thread.sleep(5000);
						 /*loginPage.enterDealerActNumber(dealerActNumber );
						 loginPage.clickGoButton();*/
						loginPage.clickContinueButton();
						homePage.clickCreateFromMaster();
						homePage.slctQuoteFrmDealerMastr();
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);
					}
					
			//************************************************************ End Of Quote Types And Agreements************************************************************************
					
			//**************************************************************Finance***************************************************************************************************

					public static TestResultReport test_TCNQ0052(InputTestDetails inputTestDetails,
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
						LoginPage loginPage = new LoginPage(driver);
						SummaryPage summaryTab = new SummaryPage(driver);
						HomePage homePage = new HomePage(driver);
						EquipmentPage equipmentPage = new EquipmentPage(driver);
						FinancePage financepage = new FinancePage(driver);
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
						Thread.sleep(5000);
						/*loginPage.enterDealerActNumber(dealerActNumber );
						loginPage.clickGoButton();*/
						CommonFunctions.waitForLoad(driver);
						loginPage.clickContinueButton();
						homePage.clickCreateQuote();
						CommonFunctions.acceptAlert(driver);
						summaryTab.clickCreateQuoteButton();
						CommonFunctions.waitForLoad(driver);
						Thread.sleep(10000);
						summaryTab.clickCreateQuoteButton();
						CommonFunctions.waitForLoad(driver);
						equipmentPage.addFreeFormEquipment();
					    equipmentPage.addFreeFormEquipment();
						financepage.clickOnFinanceTab();
						CommonFunctions.waitForLoad(driver);
						financepage.verifyEquipmentList();
						CommonFunctions.waitForLoad(driver);
						Thread.sleep(10000);
						financepage.clickOnCarot();
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);

					}
					
					public static TestResultReport test_TCNQ0053(InputTestDetails inputTestDetails,
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
						LoginPage loginPage = new LoginPage(driver);
						SummaryPage summaryTab = new SummaryPage(driver);
						HomePage homePage = new HomePage(driver);
						EquipmentPage equipmentPage = new EquipmentPage(driver);
						FinancePage financepage = new FinancePage(driver);
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
						Thread.sleep(50000);
						/*loginPage.enterDealerActNumber(dealerActNumber );
						loginPage.clickGoButton();*/
						loginPage.clickContinueButton();
						homePage.selectPurchaseQuote();
						CommonFunctions.waitForLoad(driver);
						financepage.clickOnFinanceTab();
						CommonFunctions.waitForLoad(driver);
						financepage.verifyEquipmentList();
						CommonFunctions.waitForLoad(driver);
						Thread.sleep(10000);
						financepage.clickOnCarot();
						Thread.sleep(50000);
						financepage.clickCustomInstallment();
						Thread.sleep(20000);
						financepage.clickEditPencil();
						Thread.sleep(10000);
						financepage.selectOfferForQuote();
						financepage.deleteOffer();
						Thread.sleep(20000);
						homePage.headerSaveQuote();

						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);

					}
					
					public static TestResultReport test_TCNQ0054(InputTestDetails inputTestDetails,
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
						LoginPage loginPage = new LoginPage(driver);
						SummaryPage summaryTab = new SummaryPage(driver);
						HomePage homePage = new HomePage(driver);
						EquipmentPage equipmentPage = new EquipmentPage(driver);
						FinancePage financepage = new FinancePage(driver);
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
						Thread.sleep(5000);
						/*loginPage.enterDealerActNumber(dealerActNumber );
						loginPage.clickGoButton();*/
						CommonFunctions.waitForLoad(driver);
						loginPage.clickContinueButton();
						homePage.selectPurchaseQuote();
						CommonFunctions.waitForLoad(driver);
						financepage.clickOnFinanceTab();
						CommonFunctions.waitForLoad(driver);
						financepage.verifyEquipmentList();
						CommonFunctions.waitForLoad(driver);
						Thread.sleep(10000);
						financepage.clickOnCarot();
						Thread.sleep(30000);
						financepage.clickCustomLease();
						Thread.sleep(10000);
						financepage.clickEditPencil();
						Thread.sleep(10000);
						financepage.selectOfferForQuote();
						financepage.deleteOffer();
						Thread.sleep(10000);
						homePage.headerSaveQuote();
						Thread.sleep(20000);

						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);

					}
					
					public static TestResultReport test_TCNQ0055(InputTestDetails inputTestDetails,
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
						LoginPage loginPage = new LoginPage(driver);
						SummaryPage summaryTab = new SummaryPage(driver);
						HomePage homePage = new HomePage(driver);
						EquipmentPage equipmentPage = new EquipmentPage(driver);
						FinancePage financepage = new FinancePage(driver);
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
						Thread.sleep(50000);
						/*loginPage.enterDealerActNumber(dealerActNumber );
						loginPage.clickGoButton();*/
						loginPage.clickContinueButton();
						homePage.selectPurchaseQuote();
						CommonFunctions.waitForLoad(driver);
						financepage.clickOnFinanceTab();
						CommonFunctions.waitForLoad(driver);
						financepage.verifyEquipmentList();
						CommonFunctions.waitForLoad(driver);
						Thread.sleep(10000);
						financepage.clickOnCarot();
						Thread.sleep(50000);
						financepage.createIncentiveInstallment();
						Thread.sleep(20000);
						financepage.clickEditPencil();
						Thread.sleep(10000);
						financepage.selectOfferForQuote();
						financepage.deleteOffer();
						Thread.sleep(20000);
						homePage.headerSaveQuote();

						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);

					}
					
					public static TestResultReport test_TCNQ0056(InputTestDetails inputTestDetails,
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
						LoginPage loginPage = new LoginPage(driver);
						SummaryPage summaryTab = new SummaryPage(driver);
						HomePage homePage = new HomePage(driver);
						EquipmentPage equipmentPage = new EquipmentPage(driver);
						FinancePage financepage = new FinancePage(driver);
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
						Thread.sleep(5000);
						/*loginPage.enterDealerActNumber(dealerActNumber );
						loginPage.clickGoButton();*/
						CommonFunctions.waitForLoad(driver);
						loginPage.clickContinueButton();
						homePage.selectPurchaseQuote();
						CommonFunctions.waitForLoad(driver);
						financepage.clickOnFinanceTab();
						CommonFunctions.waitForLoad(driver);
						financepage.verifyEquipmentList();
						Thread.sleep(10000);
						financepage.groupinEquipment();
						Thread.sleep(30000);
						financepage.grpclickOnCarot();
						Thread.sleep(10000);
						financepage.grpclickOnFinanceCarot();
						Thread.sleep(10000);
						financepage.grpclickCustomLease();
						Thread.sleep(10000);
						financepage.grpclickEditPencil();
						Thread.sleep(10000);
						financepage.grpselectOfferForQuote();
						financepage.clickGrpDeleteOffer();
						Thread.sleep(10000);
						financepage.ungroup();
						homePage.headerSaveQuote();
						Thread.sleep(20000);
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);

					}

					public static TestResultReport test_TCNQ0057(InputTestDetails inputTestDetails,
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
						LoginPage loginPage = new LoginPage(driver);
						SummaryPage summaryTab = new SummaryPage(driver);
						HomePage homePage = new HomePage(driver);
						EquipmentPage equipmentPage = new EquipmentPage(driver);
						FinancePage financepage = new FinancePage(driver);
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
						Thread.sleep(5000);
						/*loginPage.enterDealerActNumber(dealerActNumber );
						loginPage.clickGoButton();*/
						CommonFunctions.waitForLoad(driver);
						loginPage.clickContinueButton();
						homePage.selectPurchaseQuote();
						CommonFunctions.waitForLoad(driver);
						financepage.clickOnFinanceTab();
						CommonFunctions.waitForLoad(driver);
						financepage.verifyEquipmentList();
						Thread.sleep(10000);
						financepage.groupinEquipment();
						Thread.sleep(30000);
						financepage.grpclickOnCarot();
						Thread.sleep(20000);
						financepage.grpclickOnFinanceCarot();
						Thread.sleep(10000);
						financepage.grpclickCustomInstallment();
						Thread.sleep(10000);
						financepage.grpclickEditPencil();
						Thread.sleep(10000);
						financepage.grpselectOfferForQuote();
						financepage.clickGrpDeleteOffer();
						Thread.sleep(10000);
						financepage.ungroup();
						homePage.headerSaveQuote();
						Thread.sleep(20000);
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);
					}
					
					public static TestResultReport test_TCNQ0058(InputTestDetails inputTestDetails,
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
							throws WebDriverException, Exception {
						LoginPage loginPage = new LoginPage(driver);
						SummaryPage summaryTab = new SummaryPage(driver);
						HomePage homePage = new HomePage(driver);
						EquipmentPage equipmentPage = new EquipmentPage(driver);
						FinancePage financepage = new FinancePage(driver);
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
						Thread.sleep(5000);
						/*loginPage.enterDealerActNumber(dealerActNumber );
						loginPage.clickGoButton();*/
						CommonFunctions.waitForLoad(driver);
						loginPage.clickContinueButton();
						homePage.selectPurchaseQuote();
						CommonFunctions.waitForLoad(driver);
						financepage.clickOnFinanceTab();
						CommonFunctions.waitForLoad(driver);
						financepage.verifyEquipmentList();
						Thread.sleep(10000);
						financepage.groupinEquipment();
						Thread.sleep(30000);
						financepage.grpclickOnCarot();
						Thread.sleep(10000);
						financepage.grpclickOnFinanceCarot();
						Thread.sleep(10000);
						financepage.grpCreateIncentiveInstallment();
						Thread.sleep(10000);
						financepage.grpclickEditPencil();
						Thread.sleep(10000);
						financepage.grpselectOfferForQuote();
						financepage.clickGrpDeleteOffer();
						Thread.sleep(10000);
						financepage.ungroup();
						homePage.headerSaveQuote();
						Thread.sleep(20000);
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);

					}
					
					//**************************************************Download To Excel**************************************************************************************	
					public static TestResultReport test_TCNQ0059(InputTestDetails inputTestDetails,	
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)	
							throws WebDriverException, Exception {	
						LoginPage loginPage = new LoginPage(driver);	
						SummaryPage summaryTab = new SummaryPage(driver);	
						HomePage homePage = new HomePage(driver);	
						EquipmentPage equipmentPage = new EquipmentPage(driver);	
						FinancePage financepage = new FinancePage(driver);	
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");	
						Thread.sleep(5000);	
						/*loginPage.enterDealerActNumber(dealerActNumber );	
					    loginPage.clickGoButton();	*/
						CommonFunctions.waitForLoad(driver);	
						loginPage.clickContinueButton();	
						homePage.downloadToExcelFun();	
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,	
								inputBrowserDetails);	
					}	

			//***************************************************** End Of Download To Excel**********************************************************************************	

			//*****************************************************  Admin Functionaity*************************************************************************************	
					public static TestResultReport test_TCNQ0060(InputTestDetails inputTestDetails,	
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)	
							throws WebDriverException, Exception {	
						LoginPage loginPage = new LoginPage(driver);	
						SummaryPage summaryTab = new SummaryPage(driver);	
						HomePage homePage = new HomePage(driver);	
						EquipmentPage equipmentPage = new EquipmentPage(driver);	
						FinancePage financepage = new FinancePage(driver);	
						AdministrationPage adminPage = new AdministrationPage(driver);	
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");	
						Thread.sleep(5000);	
						/*loginPage.enterDealerActNumber(dealerActNumber );	
					    loginPage.clickGoButton();*/	
						CommonFunctions.waitForLoad(driver);	
						loginPage.clickContinueButton();	
						adminPage.navigateToAdminPge();	
						adminPage.addLinkAndSave();				
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,	
								inputBrowserDetails);	
					}	

				// Application Setting	
					public static TestResultReport test_TCNQ0061(InputTestDetails inputTestDetails,	
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)	
							throws WebDriverException, Exception {	
						LoginPage loginPage = new LoginPage(driver);	
						SummaryPage summaryTab = new SummaryPage(driver);	
						HomePage homePage = new HomePage(driver);	
						EquipmentPage equipmentPage = new EquipmentPage(driver);	
						FinancePage financepage = new FinancePage(driver);	
						AdministrationPage adminPage = new AdministrationPage(driver);	
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");	
						Thread.sleep(5000);	
						/*loginPage.enterDealerActNumber(dealerActNumber );	
					    loginPage.clickGoButton();*/	
						CommonFunctions.waitForLoad(driver);	
						loginPage.clickContinueButton();	
						homePage.verifyApplicationSetting();	
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,	
								inputBrowserDetails);	
					}	

			// **************************************************************Prod Dealer Login *******************************************************************************	
					public static TestResultReport test_TCNQ0062(InputTestDetails inputTestDetails,	
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)	
							throws WebDriverException, Exception {	
						LoginPage loginPage = new LoginPage(driver);	
						SummaryPage summaryTab = new SummaryPage(driver);	
						HomePage homePage = new HomePage(driver);	
						EquipmentPage equipmentPage = new EquipmentPage(driver);	
						FinancePage financepage = new FinancePage(driver);	
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");	
						Thread.sleep(5000);	
						CommonFunctions.waitForLoad(driver);	
						loginPage.clickContinueButton();	
						homePage.clickCreateQuote();	
						CommonFunctions.acceptAlert(driver);	
						summaryTab.clickCreateQuoteButton();	
						CommonFunctions.waitForLoad(driver);	
						Thread.sleep(10000);	
						summaryTab.clickCreateQuoteButton();	
						CommonFunctions.waitForLoad(driver);	
						equipmentPage.addFreeFormEquipment();	
						CommonFunctions.clickOnElement(driver, equipmentPage.deleteQuote);	
						CommonFunctions.acceptAlert(driver);	
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,	
								inputBrowserDetails);	
					}	

					// Verify Sales Dashboard	

					public static TestResultReport test_TCNQ0063(InputTestDetails inputTestDetails,	
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)	
							throws WebDriverException, Exception {	
						LoginPage loginPage = new LoginPage(driver);	
						SummaryPage summaryTab = new SummaryPage(driver);	
						HomePage homePage = new HomePage(driver);	
						EquipmentPage equipmentPage = new EquipmentPage(driver);	
						FinancePage financepage = new FinancePage(driver);	
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");	
						Thread.sleep(5000);	
						CommonFunctions.waitForLoad(driver);	
						loginPage.clickContinueButton();	
						homePage.verifySalesDashBoard();	
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,	
								inputBrowserDetails);	
					}	

			//******************************************** Translation Cache**********************************************************	
					public static TestResultReport test_TCNQ0064(InputTestDetails inputTestDetails,	
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)	
							throws WebDriverException, Exception {	
						LoginPage loginPage = new LoginPage(driver);	
						SummaryPage summaryTab = new SummaryPage(driver);	
						HomePage homePage = new HomePage(driver);	
						EquipmentPage equipmentPage = new EquipmentPage(driver);	
						FinancePage financepage = new FinancePage(driver);	
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");	
						Thread.sleep(5000);	
						/*loginPage.enterDealerActNumber(dealerActNumber );	
					    loginPage.clickGoButton();*/	
						CommonFunctions.waitForLoad(driver);	
						loginPage.clickContinueButton();	
						homePage.varifyLabels();	
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,	
								inputBrowserDetails);	
					}
					
//**************************************************** Value Added Services***********************************************************************************
					
					// Verify Agreements, Accept And Save
					
					public static TestResultReport test_TCNQ0065(InputTestDetails inputTestDetails,
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
									throws WebDriverException, Exception 
					{	
						LoginPage loginPage = new LoginPage(driver);
						SummaryPage summaryTab = new SummaryPage(driver);
						HomePage homePage = new HomePage(driver);
						EquipmentPage equipmentPage = new EquipmentPage(driver);
						ValueAddedServicesPage valueAddedServicesPage = new ValueAddedServicesPage(driver);
						TradeInPage tradeInPage=new TradeInPage(driver);
						POPage poPage=new POPage(driver);
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
						CommonFunctions.waitForLoad(driver);
						Thread.sleep(5000);		
						loginPage.clickContinueButton();		
						homePage.selectPurchaseQuote();		
						Thread.sleep(5000);
						valueAddedServicesPage.navigateToVASTab();
						Thread.sleep(10000);
						valueAddedServicesPage.verifyAgreementsAndChangeStatus(valueAddedServicesPage.acceptedCount, valueAddedServicesPage.acceptedBtn);
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);	
				}
				
			// Verify Agreements, Decline And Save
				
				public static TestResultReport test_TCNQ0066(InputTestDetails inputTestDetails,
						InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
								throws WebDriverException, Exception 
				{	
					LoginPage loginPage = new LoginPage(driver);
					SummaryPage summaryTab = new SummaryPage(driver);
					HomePage homePage = new HomePage(driver);
					EquipmentPage equipmentPage = new EquipmentPage(driver);
					ValueAddedServicesPage valueAddedServicesPage = new ValueAddedServicesPage(driver);
					TradeInPage tradeInPage=new TradeInPage(driver);
					POPage poPage=new POPage(driver);
					loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
					CommonFunctions.waitForLoad(driver);
					Thread.sleep(5000);		
					loginPage.clickContinueButton();		
					homePage.selectPurchaseQuote();		
					Thread.sleep(5000);
					valueAddedServicesPage.navigateToVASTab();
					Thread.sleep(10000);
					valueAddedServicesPage.verifyAgreementsAndChangeStatus(valueAddedServicesPage.declinedCount, valueAddedServicesPage.declinedBtn);
					return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
							inputBrowserDetails);	
			}
				
			// Validate calculation of Total due and Individual Equipment agreed agreements
				public static TestResultReport test_TCNQ0067(InputTestDetails inputTestDetails,
						InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
								throws WebDriverException, Exception 
				{	
					LoginPage loginPage = new LoginPage(driver);
					SummaryPage summaryTab = new SummaryPage(driver);
					HomePage homePage = new HomePage(driver);
					EquipmentPage equipmentPage = new EquipmentPage(driver);
					ValueAddedServicesPage valueAddedServicesPage = new ValueAddedServicesPage(driver);
					TradeInPage tradeInPage=new TradeInPage(driver);
					POPage poPage=new POPage(driver);
					loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
					CommonFunctions.waitForLoad(driver);
					Thread.sleep(5000);		
					loginPage.clickContinueButton();		
					homePage.selectPurchaseQuote();		
					Thread.sleep(5000);
					valueAddedServicesPage.navigateToVASTab();
					Thread.sleep(10000);
					valueAddedServicesPage.verifyTotlDueAndAgrdPrice();
					valueAddedServicesPage.verifyTotalDueCalc();
					return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
							inputBrowserDetails);	
			}
				
				// Validate PGP
					public static TestResultReport test_TCNQ0068(InputTestDetails inputTestDetails,
							InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
									throws WebDriverException, Exception 
					{
						LoginPage loginPage = new LoginPage(driver);
						SummaryPage summaryTab = new SummaryPage(driver);
						HomePage homePage = new HomePage(driver);
						EquipmentPage equipmentPage = new EquipmentPage(driver);
						ValueAddedServicesPage valueAddedServicesPage = new ValueAddedServicesPage(driver);
						TradeInPage tradeInPage=new TradeInPage(driver);
						POPage poPage=new POPage(driver);
						loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
						CommonFunctions.waitForLoad(driver);
						Thread.sleep(5000);		
						loginPage.clickContinueButton();		
						homePage.selectPurchaseQuote();		
						Thread.sleep(5000);
						valueAddedServicesPage.navigateToVASTab();
						Thread.sleep(10000);
						valueAddedServicesPage.validatePGPCalculator();
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);
					}

//********************************************** End Of Value Added Services********************************************************************************
					
//**************************************************************Miscellaneous******************************************************************************************************
					// Send to CBD GS
					public static TestResultReport test_TCNQ0069(InputTestDetails inputTestDetails,
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
					public static TestResultReport test_TCNQ0070(InputTestDetails inputTestDetails,
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
					public static TestResultReport test_TCNQ0071(InputTestDetails inputTestDetails,
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
					public static TestResultReport test_TCNQ0073(InputTestDetails inputTestDetails,
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
					public static TestResultReport test_TCNQ0072(InputTestDetails inputTestDetails,
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
					public static TestResultReport test_TCNQ0074(InputTestDetails inputTestDetails,
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
					public static TestResultReport test_TCNQ0075(InputTestDetails inputTestDetails,
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
					public static TestResultReport test_TCNQ0076(InputTestDetails inputTestDetails,
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
//						poPage.sendToWorkflow();		
						poPage.signedPO();		
						poPage.generateInvoice();		
						poPage.sendToJDMint();		
						poPage.revisionSignedPO();		
						poPage.deletePO();		
//						poPage.validateSentToWorkflow();		
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
//						poPage.sendToWorkflow();		
//						poPage.signedPO();		
//						poPage.generateInvoice();		
//						poPage.sendToJDMint();		
//						poPage.revisionSignedPO();		
						poPage.deletePO();		
//						poPage.validateSentToWorkflow();		
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);
					}
					
//					Send To Workflow
					public static TestResultReport test_TCNQ0077(InputTestDetails inputTestDetails,
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
//						poPage.generatePO();	
						poPage.sendToWorkflow();		
//						poPage.signedPO();		
//						poPage.generateInvoice();		
//						poPage.sendToJDMint();		
//						poPage.revisionSignedPO();		
//						poPage.deletePO();		
						poPage.validateSentToWorkflow();		
						return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
								inputBrowserDetails);
					}		
					

}
