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
import com.deere.pages.ProposalPage;
import com.deere.pages.SummaryPage;
import com.deere.pages.TradeInPage;

public class ProposalTabTest {

	public static String dealerActNumber = "010102";
	public static String uniqueQuoteName = "TestQuote9";
	public static String constSerialNumber = "1LV3038EPBH311695";

	public static TestResultReport test_TCNQ001(InputTestDetails inputTestDetails,
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
		loginPage.clickContinueButton();
		homePage.selectPurchaseQuote();
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(5000);
		proposalPage.proposalTab();		
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}
	
	// Verify Proposal PDF With Mandatory Fields Only
	
	public static TestResultReport test_TCNQ002(InputTestDetails inputTestDetails,
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
		loginPage.clickContinueButton();
		homePage.selectPurchaseQuote();
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(5000);
		proposalPage.proposalWithManPages();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}
}
