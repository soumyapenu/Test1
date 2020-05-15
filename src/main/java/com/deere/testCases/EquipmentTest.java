package com.deere.testCases;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.deere.applicaionSpecific.GlobalThings;
import com.deere.global.CommonFunctions;
import com.deere.global.InputBrowserDetails;
import com.deere.global.InputEnvironmentDetails;
import com.deere.global.InputTestDetails;
import com.deere.global.TestResultReport;
import com.deere.pages.SummaryPage;
import com.deere.pages.LoginPage;
import com.deere.pages.EquipmentPage;
import com.deere.pages.POPage;
import com.deere.pages.TradeInPage;
import com.deere.pages.HomePage;
import com.deere.pages.JDQuoteCommonFunctions;

import com.itextpdf.text.List;

// Created By Manisha -- EE122GH

public class EquipmentTest {

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
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		CommonFunctions.waitForLoad(driver);
		// loginPage.enterDealerActNumber(dealerActNumber );
		// loginPage.clickGoButton();
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

	// DBS Parts
	public static TestResultReport test_TCNQ002(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
					throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		// loginPage.enterDealerActNumber(dealerActNumber );
		// loginPage.clickGoButton();
		CommonFunctions.waitForLoad(driver);
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
	public static TestResultReport test_TCNQ003(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
					throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		Thread.sleep(2000);
		// loginPage.enterDealerActNumber(dealerActNumber );
		// loginPage.clickGoButton();
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
	public static TestResultReport test_TCNQ004(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
					throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		// loginPage.enterDealerActNumber(dealerActNumber );
		// loginPage.clickGoButton();
		loginPage.clickContinueButton();
		Thread.sleep(5000);
		homePage.clickCreateQuote();
		summaryTab.enterQuoteName();
		summaryTab.selectQuoteType(inputTestDetails);
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.acceptAlert(driver);
		summaryTab.clickCreateQuoteButton();
		// equipmentPage.clickOnEquipmentTab();
		equipmentPage.addEquipmentFromBNP();
        return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	// Equipment From Build & Price Model List
	public static TestResultReport test_TCNQ005(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
					throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		Thread.sleep(2000);
		// loginPage.enterDealerActNumber(dealerActNumber );
		// loginPage.clickGoButton();
		loginPage.clickContinueButton();
		Thread.sleep(10000);
		homePage.clickCreateQuote();
		summaryTab.enterQuoteName();
		summaryTab.selectQuoteType(inputTestDetails);
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.acceptAlert(driver);
		summaryTab.clickCreateQuoteButton();
		// equipmentPage.clickOnEquipmentTab();
		equipmentPage.addEquipmentFromBNPModelList();
		
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	// Equipment From JDSC DBS
	public static TestResultReport test_TCNQ006(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
					throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		Thread.sleep(2000);
		// loginPage.enterDealerActNumber(dealerActNumber );
		// loginPage.clickGoButton();
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
	public static TestResultReport test_TCNQ007(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
					throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		Thread.sleep(2000);
		// loginPage.enterDealerActNumber(dealerActNumber );
		// loginPage.clickGoButton();
		loginPage.clickContinueButton();
		Thread.sleep(10000);
		homePage.clickCreateQuote();
		summaryTab.enterQuoteName();
		summaryTab.selectQuoteType(inputTestDetails);
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.acceptAlert(driver);
		summaryTab.clickCreateQuoteButton();
		// equipmentPage.clickOnEquipmentTab();
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
	public static TestResultReport test_TCNQ008(InputTestDetails inputTestDetails,
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
		// loginPage.enterDealerActNumber(dealerActNumber );
		// loginPage.clickGoButton();
		loginPage.clickContinueButton();
		homePage.clickCreateQuote();
		summaryTab.enterQuoteName();
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.acceptAlert(driver);
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(10000);
		equipmentPage.verifyCollateralEquipment();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

	// Add equipment from Machine Finder Pro
	public static TestResultReport test_TCNQ009(InputTestDetails inputTestDetails,
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
		// loginPage.enterDealerActNumber(dealerActNumber );
		// loginPage.clickGoButton();
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
	public static TestResultReport test_TCNQ0010(InputTestDetails inputTestDetails,
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
		// loginPage.enterDealerActNumber(dealerActNumber );
		// loginPage.clickGoButton();
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
		equipmentPage.reconfigureOnEquipmentTab();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}
	// Add Equipment From FreeForm 

		public static TestResultReport test_TCNQ011(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
					throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		Thread.sleep(5000);
		// loginPage.enterDealerActNumber(dealerActNumber );
		// loginPage.clickGoButton();
		CommonFunctions.waitForLoad(driver);
		loginPage.clickContinueButton();
		homePage.clickCreateQuote();
		summaryTab.enterQuoteName();
		summaryTab.clickCreateQuoteButton();
		CommonFunctions.acceptAlert(driver);
		summaryTab.clickCreateQuoteButton();
		equipmentPage.addFreeFormEquipment();
		equipmentPage.deleteEquipment();
		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}


	//	Add equipment from collateral
	public static TestResultReport test_TCNQ012(InputTestDetails inputTestDetails,
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
		// loginPage.enterDealerActNumber(dealerActNumber );
		// loginPage.clickGoButton();
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

//	Add equipment from Frontier Configurator
	public static TestResultReport test_TCNQ013(InputTestDetails inputTestDetails,
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
		// loginPage.enterDealerActNumber(dealerActNumber );
		// loginPage.clickGoButton();
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

}
