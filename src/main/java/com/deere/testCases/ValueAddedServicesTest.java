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

public class ValueAddedServicesTest {
	
	// Verify Agreements, Accept And Save
	
		public static TestResultReport test_TCNQ001(InputTestDetails inputTestDetails,
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
	
	public static TestResultReport test_TCNQ002(InputTestDetails inputTestDetails,
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
	public static TestResultReport test_TCNQ003(InputTestDetails inputTestDetails,
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
		public static TestResultReport test_TCNQ004(InputTestDetails inputTestDetails,
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
}
