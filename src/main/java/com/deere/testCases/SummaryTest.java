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

public class SummaryTest {

	public static String dealerActNumber = "010102";
	public static String constSerialNumber = "1LV3038EPBH311695";

	public static TestResultReport test_TCNQ001(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		//loginPage.clickSignInButton();
		CommonFunctions.waitForLoad(driver);
	    //loginPage.dealerActNumbrLogin(inputTestDetails);
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
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		//loginPage.clickSignInButton();
		//CommonFunctions.waitForLoad(driver);
		//loginPage.dealerActNumbrLogin(inputTestDetails);
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
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		//loginPage.clickSignInButton();
		//CommonFunctions.waitForLoad(driver);
		//loginPage.dealerActNumbrLogin(inputTestDetails);
		//Thread.sleep(10000);
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

}
