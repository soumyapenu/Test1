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

public class TradeInTabTest {


	public static String dealerActNumber ="010102";
	public static String uniqueQuoteName ="TestQuote9";
	public static String constSerialNumber ="1LV3038EPBH311695";

	public static TestResultReport test_TCNQ001(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
					throws WebDriverException, Exception 
	{	
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		TradeInPage tradeInPage=new TradeInPage(driver);
		POPage poPage=new POPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		CommonFunctions.waitForLoad(driver);

		loginPage.clickContinueButton();		
		homePage.selectPurchaseQuoteAndSpecificCustomerName();		
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(5000);
		tradeInPage.clickOnTradeInTab();
		
		tradeInPage.freeFormtradeInMakeAndModelSelect();	
		
		tradeInPage.tradeInNamesPresentOnTradeIntab();
		
		tradeInPage.validateTradeInsPrices();
		tradeInPage.validateTradeInsPrices();

		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);	
	}


	public static TestResultReport test_TCNQ002(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
					throws WebDriverException, Exception 
	{	
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		TradeInPage tradeInPage=new TradeInPage(driver);
		POPage poPage=new POPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		CommonFunctions.waitForLoad(driver);

		loginPage.clickContinueButton();		
		homePage.selectPurchaseQuoteAndSpecificCustomerName();		
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


	public static TestResultReport test_TCNQ003(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
					throws WebDriverException, Exception 
	{	
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		TradeInPage tradeInPage=new TradeInPage(driver);
		POPage poPage=new POPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		CommonFunctions.waitForLoad(driver);

		loginPage.clickContinueButton();		
		homePage.selectPurchaseQuoteAndSpecificCustomerName();		
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(5000);
		tradeInPage.clickOnTradeInTab();		


		Thread.sleep(5000);
		tradeInPage.machineFinderProTradeIn();	
		tradeInPage.tradeInNamesPresentOnTradeIntab();
		
		tradeInPage.validateTradeInsPrices();

		tradeInPage.writeTradeInDescription();	
		//		tradeInPage.dragAndDropAssociateTradeIn();	
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);	
	}

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
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		CommonFunctions.waitForLoad(driver);

		loginPage.clickContinueButton();		
		homePage.selectPurchaseQuoteAndSpecificCustomerNameAndTradeIn();;		
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(5000);
		//		tradeInPage.clickOnTradeInTab();		

		tradeInPage.select1stTradeIn();

		tradeInPage.cmprTotalSellingPriceUnderDetermngSec();

		Thread.sleep(5000);

		tradeInPage.cmprFinalTradeAllowanceUnderDetermngSec();

		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);	
	}
	//	Add Trade ins from all resources
	public static TestResultReport test_TCNQ005(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
					throws WebDriverException, Exception 
	{	
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		TradeInPage tradeInPage=new TradeInPage(driver);
		POPage poPage=new POPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		CommonFunctions.waitForLoad(driver);

		loginPage.clickContinueButton();		
		homePage.selectPurchaseQuoteAndSpecificCustomerName();		
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(5000);
		tradeInPage.clickOnTradeInTab();	
		Thread.sleep(5000);
		tradeInPage.addTradeIn();
		tradeInPage.freeFormtradeInMakeAndModelSelect();
		Thread.sleep(5000);
		
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
	public static TestResultReport test_TCNQ006(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
					throws WebDriverException, Exception 
	{	
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		TradeInPage tradeInPage=new TradeInPage(driver);
		POPage poPage=new POPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(5000);		
		loginPage.clickContinueButton();		
		homePage.selectPurchaseQuoteAndSpecificCustomerName();;		
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



}
