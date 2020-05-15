package com.deere.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.deere.global.CommonFunctions;

public class FinancePage {

	WebDriver driver;

	public FinancePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Finance Tab On JDQuote2 Application

	@FindBy(how = How.LINK_TEXT, linkText = "Finance")
	private WebElement financeTab;

	// Finance Equipment List
	@FindBy(how = How.XPATH, xpath = "//*[contains(@id,'selectedJDFFund')]//following-sibling::table//tbody")
	private List<WebElement> equipmentList;

	// Carrot To Open Incentives Of Equipment
	@FindBy(how = How.XPATH, xpath = "//div[@id='perMachine']/table/tbody/tr/td/table/tbody/tr/td/a/img[starts-with(@id,'closedImage')]")
	private WebElement incentiveCarot;

	// Incentive List section
	@FindBy(how = How.XPATH, xpath = "//div[@id='perMachine']//table//tbody//tr[starts-with(@id,'equipmentSectionIncentives')]")
	private List<WebElement> incentiveSection;

	// Finance Incentives
	@FindBy(how = How.XPATH, xpath = "//table[@id='dataTable0perMachine']//tbody//tr[@class='dataTableTR0perMachine']//td[contains(@title,'SMP Medallion Program.')]//a")
	private WebElement financeIncentive;

	// Finance Incentive Check box
	@FindBy(how = How.XPATH, xpath = "//table[@id='dataTable0perMachine']//tbody//tr[9]//td//input")
	private WebElement incentiveChkBox;

	// Finance Offer Carot
	@FindBy(how = How.XPATH, xpath = "//table[starts-with(@id,'chooseOptOffrTable')]//tbody//tr[starts-with(@id,'chooseOptOffrSection')]//td//following::td//a[starts-with(@id,'idShowProgramLink')]//img[@src='/JDQuote/images/downArrow.png']")
	private List<WebElement> financeOfferCarot;

	// create Installment link
	@FindBy(how = How.XPATH, xpath = "//div[starts-with(@id,'idProgramSelection')]//table//tbody//tr//td//h2//a[contains(text(),'Custom Installment')]")
	private List<WebElement> customInstallmentLink;

	// Edit Pencil Image On Finance offer
	@FindBy(how = How.XPATH, xpath = "//table[starts-with(@id,'financeOptOffrTable')]//tbody//tr[2]//td[2]//table//tbody//tr//td//a[starts-with(@id,'perMachinePencilClk')]//img[starts-with(@id,'editPencil')]")
	private WebElement editPencilImg;

	// Installment Title
	@FindBy(how = How.XPATH, xpath = "//table[starts-with(@id,'financeOptOffrTable')]//tbody//tr[starts-with(@id,'editSection')]//td//input[starts-with(@id,'financeOfferType')]")
	private WebElement offerTitle;

	// Create Lease Offer link
	@FindBy(how = How.XPATH, xpath = "//div[starts-with(@id,'idProgramSelection')]//table//tbody//tr[2]//td//h2//a[contains(text(),'Custom Lease')]")
	private List<WebElement> customLeaseLink;

	// Select Offer For Quote
	@FindBy(how = How.XPATH, xpath = "//table[@id='financeOptOffrTable00']//tbody//tr//td//table//tbody//tr//td//input[@id='radioOffer00']")
	private WebElement selectOfferChkBox;

	// Delete Offer
	@FindBy(how = How.XPATH, xpath = "//tr[@id='editSection00']//td[2]//table//tbody//tr//td[2]//a//img[@id='deleteOffr00']")
	private WebElement deleteOffer;
	// Group Equipment link
	@FindBy(how = How.XPATH, xpath = "//div[@id='perMachine']//table//tbody//tr//td//table//tbody//tr//td[6]//div//a//img[starts-with(@id,'dragImage')]")
	private List<WebElement> groupingImg;

	// Group Equipment Incentives Carot
	@FindBy(how = How.XPATH, xpath = "//div[@id='groupingDiv']//table//tbody//tr//td//div[starts-with(@id,'linkImg')]//following::table//tbody//tr//td//table//tbody//tr//td//a//img[starts-with(@id,'closedImage0')]")
	private WebElement grpincentiveCarot;

	// Group Finance Offer Carot
	@FindBy(how = How.XPATH, xpath = "//table[starts-with(@id,'blendedchooseOptOffrTable')]//tbody//tr//td[2]//a[@name='idShowProgramLink00']//img[@src='/JDQuote/images/downArrow.png']")
	private WebElement grpfinanceOfferCarot;

	// Group Custom Installment link
	@FindBy(how = How.XPATH, xpath = "//div[@id='blendedidProgramSelection00']//table//tbody//tr//td//h2//a[contains(text(),'Custom Installment')]")
	private WebElement grpcustomInstallmentLink;

	// Group Custom Installment link
	@FindBy(how = How.XPATH, xpath = "//div[@id='blendedidProgramSelection00']//table//tbody//tr//td//h2//a[contains(text(),'Custom Lease')]")
	private WebElement grpcustomLeaseLink;

	// Group Edit Pencil Image On Finanace Offer

	@FindBy(how = How.XPATH, xpath = "//table[@id='blendedfinanceOptOffrTable00']//tbody//tr[@id='blendededitSection00']//td[2]//table//tbody//tr//td//a//img[@id='blendededitPencil00']")
	private WebElement grpeditPencilImg;

	// Group Offer Title
	@FindBy(how = How.XPATH, xpath = "//table[@id='blendedfinanceOptOffrTable00']//tr[@id='blendededitSection00']//td//input[@id='blendedfinanceOfferType00']")
	private WebElement grpOfferTitle;

	// Group Select Offer For Quote Check box
	@FindBy(how = How.XPATH, xpath = "//table[starts-with(@id,'blendedchooseOptOffrTable')]//following::table[starts-with(@id,'blendedfinanceOptOffrTable')]//tbody//tr//td//table//tbody//tr//td//input[starts-with(@id,'blendedradioOffer')]")
	private WebElement grpSelectOfferForQuote;

	// Accept Alert for Selecting Offer To Quote
	@FindBy(how = How.XPATH, xpath = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable ui-resizable']//div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']//div[@class='ui-dialog-buttonset']//button[2]//span[text()='Yes']")
	private WebElement yesButton;

	// Group Delete Offer
	@FindBy(how = How.XPATH, xpath = "//table[@id='blendedfinanceOptOffrTable00']//tbody//tr[2]//td[2]//table//tbody//tr//td[2]//input[@id='deleteSelectedFinanceOffer']//following::a//img[@id='deleteOffr00']")
	private WebElement grpDeleteOffer;

	// Ungroup pin img
	@FindBy(how = How.XPATH, xpath = "//div[@id='groupingDiv']//table//tbody//tr//td//div[@id='linkImg0']//a//img[@id='dragImage']")
	private WebElement ungroupImg;

	// Ungroup Alert Yes Button
	@FindBy(how = How.XPATH, xpath = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all no-close success-dialog ui-draggable-disabled']//div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']//div[@class='ui-dialog-buttonset']//button[2]//span[text()='Yes']")
	private WebElement ungroupYesButton;

	// Filters In Finance Section
	@FindBy(how = How.XPATH, xpath = "//table[@id='incentiveTable0perMachine']//tbody//tr//td//table//tbody//tr//td[2]//a[contains(text(),'Filters')]")
	private WebElement filters;

	// Installment Incentive
	@FindBy(how = How.XPATH, xpath = "//table[@id='dataTable0perMachine']//tbody//tr[10]//td[2]//a")
	private WebElement installmentIncentive;

	// Lease Button
	@FindBy(how = How.XPATH, xpath = "//tr[@id='filterSection0perMachine']//td//table//tbody//tr//td//input[@id='leaseBtn0perMachine']")
	private WebElement leaseButton;

	// Lease Incentive
	@FindBy(how = How.XPATH, xpath = "//table[@id='dataTable0perMachine']//tbody//tr[32]//td[2]//a")
	private WebElement leaseIncentive;

	// Lease Incentive Checkbox
	@FindBy(how = How.XPATH, xpath = "//table[@id='dataTable0perMachine']//tbody//tr//td//input")
	private WebElement leaseIncentiveChkBox;

	// Slider
	@FindBy(how = How.XPATH, xpath = "//div[@class='ui-slider-range ui-widget-header']")
	private WebElement slider;

	// Group slider
	@FindBy(how = How.XPATH, xpath = "//div[@class='ui-slider-range ui-widget-header']")
	private WebElement grpSlider;

	// Group Filter

	@FindBy(how = How.XPATH, xpath = "//table[@id='incentiveTable0blended']//tbody//tr//td//table//tbody//tr//td[2]//a[contains(text(),'Filters')]")
	private WebElement grpFilter;

	// Group Installment Incentive
	@FindBy(how = How.XPATH, xpath = "//table[@id='dataTable0blended']//tbody//tr[9]//td[2]//a")
	private WebElement grpIncentiveInstallment;

	// Group Installment Check box
	@FindBy(how = How.XPATH, xpath = "//table[@id='dataTable0blended']//tbody//tr[9]//td//input")
	private WebElement grpIncentiveInstallmentChkBox;

	// Group Lease Button
	@FindBy(how = How.XPATH, xpath = "//table[@id='incentiveTable0blended']//tbody//tr[@id='filterSection0blended']//td//table//tbody//tr//td//input[@id='leaseBtn0blended']")
	private WebElement grpLeaseBtn;

	// Group Lease Incentive Lease
	@FindBy(how = How.XPATH, xpath = "//div[@id='dataTableDiv0blended']//table[@id='dataTable0blended']//tbody//tr[@class='dataTableTR0blended']//td[2]//a")
	private WebElement grpIncentiveLease;

	// Group slider
	@FindBy(how = How.XPATH, xpath = "//div[@id='dataTableDiv0blended']//table[@id='dataTable0blended']//tbody//tr[@class='dataTableTR0blended']//td//input")
	private WebElement grpIncentiveLeaseChkBox;
	private By clickOnFinanceTab = By.xpath("//a[contains(text(),'Finance')]");
	private By expandEquipmentOnFinanceTab = By.xpath("//*[@id='closedImage0']");
	private By chooseFinanceoption = By.xpath("//*[@id='idShowProgramLink00']");
	private By selectCustomInstallment = By.xpath(
			"//*[@id='idProgramSelection00']//table//tbody//tr[1]//td[1]//h2//a[contains(text(),'Custom Installment')]");

	@FindBy(how = How.XPATH, xpath = "//*[@id='radioOffer00']")
	private WebElement selectOfferForCustomInstallment;

	private By selectYesButton = By.xpath("//*[contains(text(),'Yes')]");

	private By clickOnPOSign = By
			.xpath("//*[@id='rightColumn']//table//tbody//tr//td//a//img[@class='i_purchaseOrder']");

	// Selected Equipment Number To Create offer
	int equipnumber;

	// Navigate to Finance tab

	public void clickOnFinanceTab() {
		financeTab.click();
	}

	public void verifyEquipmentList() {
		int size = equipmentList.size();
		if (size != 0) {
			System.out.println("Equipment list is not empty");
		}

		else {
			System.out.println("Equipment list is empty");
		}
	}

	public void clickOnCarot() throws InterruptedException {
		incentiveCarot.click();
		String expected = "Incentives not found. Please refer to incentives recap. A&T CWP C&F";
		Thread.sleep(90000);
		  if (filters.isDisplayed()){
			System.out.println("Filters available");
			Thread.sleep(10000);
			if (slider.isDisplayed()) {
				if (installmentIncentive.isDisplayed())
					System.out.println("Installment Icentives available");
				else if (leaseButton.isDisplayed()) {
					leaseButton.click();
					Thread.sleep(30000);
					if (leaseIncentive.isDisplayed())
						System.out.println("Lease Incentives Available");
				} 
				}

				else {
					System.out.println("Error in loading Incentives");
				}
			}
		   else if (incentiveSection.get(equipnumber).getText().contains(expected)) {
				System.out.println("Incentives are not available for Equipment");

		}
		
		
	}

	// Create Installment Offer From Incentives

	public void createIncentiveInstallment() {
		String expected = "Incentives not found. Please refer to incentives recap. A&T CWP C&F";
		if (financeIncentive.isDisplayed()) {
			if (!incentiveChkBox.isSelected()) {
				incentiveChkBox.click();
			}
		} else if (incentiveSection.get(equipnumber).getText().contains(expected)) {
			int size = financeOfferCarot.size();

			for (int i = 0; i < size; i++) {
				WebElement carot = financeOfferCarot.get(i);
				if (carot.isDisplayed()) {
					financeOfferCarot.get(i).click();
					break;
				}

			}
		} else {
			System.out.println("Test case fail");
		}

	}

	public void createIncentiveLease() {
		if (leaseButton.isDisplayed()) {
			leaseButton.click();
			if (leaseIncentive.isDisplayed()) {

				leaseIncentiveChkBox.click();

			}

		}

		else {
			System.out.println("Incentives not available");
		}
	}

	// Click on Custom Installment link

	public void clickCustomInstallment() {
		if (!financeOfferCarot.isEmpty()) {

			int size = customInstallmentLink.size();

			for (int i = 0; i < size; i++) {
				financeOfferCarot.get(i).click();
				WebElement carot = customInstallmentLink.get(i);
				if (carot.isDisplayed()) {
					customInstallmentLink.get(i).click();
					break;
				}

			}
		}
	}

	// Click On Custom Lease Offer

	public void clickCustomLease() {
		int size = customLeaseLink.size();
		if (!financeOfferCarot.isEmpty()) {

			for (int i = 0; i < size; i++) {
				financeOfferCarot.get(i).click();
				WebElement carot = customLeaseLink.get(i);
				if (carot.isDisplayed()) {
					customLeaseLink.get(i).click();
					break;
				}

			}
		}
	}

	// Click on Edit Pencil Image

	public void clickEditPencil() {
		editPencilImg.click();
		if (offerTitle.isDisplayed()) {
			System.out.println("Finance Offer successfully created");
		} else {
			System.out.println(" Finance offer not created");
		}
	}

	// Select Offer To Quote

	public void selectOfferForQuote() throws InterruptedException {
		if (!selectOfferChkBox.isSelected()) {
			selectOfferChkBox.click();
			Thread.sleep(10000);
			yesButton.click();
			Thread.sleep(50000);
			clickOnCarot();
			if (selectOfferChkBox.isSelected()) {
				System.out.println("Test case pass");
			} else {
				System.out.println("Test case fail");
			}
		}

	}

	// Delete Offer

	public void deleteOffer() throws InterruptedException {
		deleteOffer.click();
		Thread.sleep(10000);
		yesButton.click();
		CommonFunctions.waitForLoad(driver);
		if (!offerTitle.isDisplayed()) {
			System.out.println("Finance Offer successfully deleted");
		} else {
			System.out.println(" Finance offer not deleted");
		}

	}
	// Group Equipment

	public void groupinEquipment() {
		WebElement element = groupingImg.get(0);
		WebElement target = groupingImg.get(1);
		Actions action = new Actions(driver);
		action.dragAndDrop(element, target).build().perform();

	}

	// Click on group Incentive carot

	public void grpclickOnCarot() throws InterruptedException {
		grpincentiveCarot.click();
		String expected = "Incentives not found. Please refer to incentives recap. A&T CWP C&F";
		Thread.sleep(60000);
		if (grpFilter.isDisplayed()) {
			System.out.println("Filters available");
			Thread.sleep(10000);
			if (grpSlider.isDisplayed()) {
				if (grpIncentiveInstallment.isDisplayed())
					System.out.println("Installment Icentives available");
				else if (grpLeaseBtn.isDisplayed()) {
					grpLeaseBtn.click();
					Thread.sleep(30000);
					if (grpIncentiveLease.isDisplayed())
						System.out.println("Lease Incentives Available");
				} else if (incentiveSection.get(equipnumber).getText().contains(expected)) {
					System.out.println("Incentives are not available for Equipment");
				}

				else {
					System.out.println("Error in loading Incentives");
				}
			}

		}

	}

	// Create Group Incentive Installment

	public void grpCreateIncentiveInstallment() {
		String expected = "Incentives not found. Please refer to incentives recap. A&T CWP C&F";
		if (grpIncentiveInstallment.isDisplayed()) {
			if (!grpIncentiveInstallmentChkBox.isSelected()) {
				grpIncentiveInstallmentChkBox.click();
			}
		} else if (incentiveSection.get(equipnumber).getText().contains(expected)) {

			WebElement carot = grpfinanceOfferCarot;
			if (carot.isDisplayed()) {
				grpfinanceOfferCarot.click();
			}

		} else {
			System.out.println("Test case fail");
		}

	}

	// Create Group Lease Incentive Offer

	public void grpCreateIncentiveLease() throws InterruptedException {
		if (grpLeaseBtn.isDisplayed()) {
			grpLeaseBtn.click();
			Thread.sleep(10000);
			if (grpIncentiveLease.isDisplayed()) {

				grpIncentiveLeaseChkBox.click();

			}

		}

		else {
			System.out.println("Incentives not available");
		}
	}

	// Click on Group Finance offer carot

	public void grpclickOnFinanceCarot() {
		grpfinanceOfferCarot.click();
	}

	// Click on group Custom Installment link

	public void grpclickCustomInstallment() {
		grpcustomInstallmentLink.click();
	}

	// Click On group Custom Lease Offer

	public void grpclickCustomLease() {
		grpcustomLeaseLink.click();
	}

	// Click on Edit Pencil Image

	public void grpclickEditPencil() {
		grpeditPencilImg.click();

		if (grpOfferTitle.isDisplayed()) {
			System.out.println("Finance Offer successfully created");
		} else {
			System.out.println(" Finance offer not created");
		}
	}

	// Select offer for Quote

	public void grpselectOfferForQuote() throws InterruptedException {
		if (!grpSelectOfferForQuote.isSelected()) {
			grpSelectOfferForQuote.click();
			Thread.sleep(10000);
			yesButton.click();
			Thread.sleep(50000);
			grpclickOnCarot();
			if (grpSelectOfferForQuote.isSelected()) {
				System.out.println("Test case pass");
			} else {
				System.out.println("Test case fail");
			}
		}
	}

	// Delete Finance Offer

	public void clickGrpDeleteOffer() throws InterruptedException {
		grpDeleteOffer.click();
		Thread.sleep(10000);
		yesButton.click();
		CommonFunctions.waitForLoad(driver);
		if (!grpOfferTitle.isDisplayed()) {
			System.out.println("Finance Offer successfully deleted");
		} else {
			System.out.println(" Finance offer not deleted");
		}
	}

	public void selectOfferOnFinanceTab() throws InterruptedException {

		CommonFunctions.click(driver, clickOnFinanceTab);

		CommonFunctions.waitForAnObjectToBeAvailable(driver, expandEquipmentOnFinanceTab, 10);

		Thread.sleep(5000);
		CommonFunctions.click(driver, expandEquipmentOnFinanceTab);

		CommonFunctions.waitForAnObjectToBeAvailable(driver, chooseFinanceoption, 3);

		CommonFunctions.click(driver, chooseFinanceoption);

		CommonFunctions.waitForAnObjectToBeAvailable(driver, selectCustomInstallment, 5);

		CommonFunctions.click(driver, selectCustomInstallment);

		// CommonFunctions.waitForAnObjectToBeAvailable(driver,
		// selectOfferForCustomInstallment, 5);

		if (!selectOfferForCustomInstallment.isSelected()) {

			selectOfferForCustomInstallment.click();
		}

		// CommonFunctions.click(driver, selectOfferForCustomInstallment);

		CommonFunctions.click(driver, selectYesButton);

		Thread.sleep(3000);

		CommonFunctions.waitForAnObjectToBeAvailable(driver, clickOnPOSign, 10);

		CommonFunctions.waitForAnObjectToBeAvailable(driver, clickOnPOSign, 10);

		CommonFunctions.click(driver, clickOnPOSign);
	}

	// Ungroup group

	public void ungroup() {
		ungroupImg.click();
		ungroupYesButton.click();
	}

}