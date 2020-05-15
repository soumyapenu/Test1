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
import com.deere.pages.HomePage;
import com.deere.pages.FinancePage;
import com.deere.pages.JDQuoteCommonFunctions;

import com.itextpdf.text.List;

public class FinanceTest {
	public static String dealerActNumber = "010102";

	public static TestResultReport test_TCNQ001(InputTestDetails inputTestDetails,
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
		financepage.clickOnFinanceTab();
		CommonFunctions.waitForLoad(driver);
		financepage.verifyEquipmentList();
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(10000);
		financepage.clickOnCarot();
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
		FinancePage financepage = new FinancePage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		Thread.sleep(50000);
		// loginPage.enterDealerActNumber(dealerActNumber );
		// loginPage.clickGoButton();
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

	public static TestResultReport test_TCNQ003(InputTestDetails inputTestDetails,
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
		financepage.clickOnFinanceTab();
		CommonFunctions.waitForLoad(driver);
		financepage.verifyEquipmentList();
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(10000);
		financepage.clickOnCarot();
		Thread.sleep(30000);
		financepage.createIncentiveLease();
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

	public static TestResultReport test_TCNQ004(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		FinancePage financepage = new FinancePage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		Thread.sleep(50000);
		// loginPage.enterDealerActNumber(dealerActNumber );
		// loginPage.clickGoButton();
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

	public static TestResultReport test_TCNQ005(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {
		LoginPage loginPage = new LoginPage(driver);
		SummaryPage summaryTab = new SummaryPage(driver);
		HomePage homePage = new HomePage(driver);
		EquipmentPage equipmentPage = new EquipmentPage(driver);
		FinancePage financepage = new FinancePage(driver);
		loginPage.newLogin(inputTestDetails, inputEnvDetails, driver, false, "", "");
		Thread.sleep(50000);
		// loginPage.enterDealerActNumber(dealerActNumber );
		// loginPage.clickGoButton();
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
		financepage.createIncentiveLease();
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
	

	public static TestResultReport test_TCNQ008(InputTestDetails inputTestDetails,
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
		financepage.grpCreateIncentiveLease();
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
	

	public static TestResultReport test_TCNQ009(InputTestDetails inputTestDetails,
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

}
