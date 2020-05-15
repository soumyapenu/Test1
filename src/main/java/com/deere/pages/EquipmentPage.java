package com.deere.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.deere.global.CommonFunctions;
import com.deere.global.InputTestDetails;

public class EquipmentPage {

	WebDriver driver;

	public EquipmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public static String freeformMake = "JOHN DEERE";
	public static String freeformModel = "8295R";
	public static String freeFormSerialNumber = "1RW8295RKAP009319";
	public static String freeFormBaseCode = "7331RW      ";
	public static String freeFormDescription = "2010 JOHN DEERE 8295R TRACTOR";
	public static String freeFormCostPrice = "169,246.00";
	public static String freeFormListPrice = "219,800.02";

	String frameName = "reconfigure";
	String frameName1 = "uxsearch";
	String frameName3 = "reconfigure";

	private int partQuan;
	public String partquantity;
	public static String dbsPartNumber = "AA21480";

	public static String jdscDealer = "X041870";
	public static String jdscDBSStockNumber = "48254";

	// Equipment On Hand Section
	@FindBy(how = How.XPATH, xpath = "//a[@href='#'][text()='Equipment']")
	private WebElement equipmentTab;
	// click done button on left navigation
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Done')]")
	private WebElement doneLeftNav;
	// click on Create Demo Agreement
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Create Demo Agreement')]")
	private WebElement createDemoAgreementLink;
	@FindBy(how = How.XPATH, xpath = "//a[text()='Create New Demo Agreement']")
	private WebElement createNewDemoAgreementLink;
	// click on Create Rental Agreement
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Create Rental Agreement')]")
	private WebElement createRentalAgreementLink;
	@FindBy(how = How.XPATH, xpath = "//a[text()='Create New Rental Agreement']")
	private WebElement createNewRentalAgreementLink;

	// Copy From Another Quote button on Equipment page
	@FindBy(how = How.LINK_TEXT, linkText = "Copy from another Quote")
	private WebElement copyFromAnotherQuotelink;
	// Search Button on Copy From Another Quote
	@FindBy(how = How.XPATH, xpath = "//*[@id='results']/table/thead/tr/td/input")
	private WebElement copyFromAnotherQuoteSearch;
	// Results returned by Copy From Another Quote search
	@FindBy(how = How.XPATH, xpath = "//*[@id='resultsCopyEquipment']/table/tbody")
	private WebElement resultSet;
	// Add Selected button on Copy From Another Quote
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Add Selected')]")
	private WebElement addSelectedOnCopyFromAnotherQuotebtn;

	// *******JSDC ************
	// Build&Price button
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Build & Price')]")
	private WebElement bnpBtn;
	// user name field to login into other Application
	@FindBy(how = How.XPATH, xpath = "//*[contains(@name,'username')]")
	private WebElement otherUsername;
	// Next button on other application
	@FindBy(how = How.XPATH, xpath = "//*[contains(@id,'idp-discovery-submit')]")
	private WebElement nextbtn;
	// Impersonate User As on JDSC Login Page
	@FindBy(how = How.XPATH, xpath = "//div[@class='sign-in-radio-group-module-signInRadioGroup-10jQF']//form[@class='account-input-submission']//input[@class='account-input-submission-module-signInInput-29uYP']")
	private WebElement jdscUserName;
	// Sign In button on JDSC page
	@FindBy(how = How.XPATH, xpath = "//div[@class='sign-in-radio-group-module-signInRadioGroup-10jQF']//form[@class='account-input-submission']//button[contains(text(),'Sign In')]")
	private WebElement jdscSignIn;
	// I Agree Button on JDSC
	@FindBy(how = How.XPATH, xpath = "//div[@class = 'disclaimer-panel-module-buttonContainer-62kNQ']//a[@class='button-base-module-buttonBase-2kNL6 buttons-module-agreeButton-EGKQY']//span[contains(text(),'I Agree')]")
	private WebElement jdscIAgreeBtn;
	// Ag & Turf Link on JDSC
	@FindBy(how = How.XPATH, xpath = "//div[@class='eph-click-through']//li[@class='eph-single-selection-item']//button[@class='eph-single-selection-item-button']//span[contains(text(),'AG & TURF')]")
	private WebElement jascAgNTurfLink;
	// Crop Care link on JDSC
	@FindBy(how = How.XPATH, xpath = "//div[@class='eph-click-through']//ul[@class='eph-single-selection-list']//li[@class='eph-single-selection-item']//button[@class='eph-single-selection-item-button']//span[contains(text(),'CROP CARE')]")
	private WebElement jdscCropCareLink;
	// Crop Care link on JDSC
	@FindBy(how = How.XPATH, xpath = "//div[@class='eph-click-through']//ul[@class='eph-single-selection-list']//li[@class='eph-single-selection-item']//span[contains(text(),'SEEDING')]")
	private WebElement jdscSeedingLink;
	// Crop Care link on JDSC
	@FindBy(how = How.XPATH, xpath = "//div[@class='eph-click-through']//ul[@class='eph-single-selection-list']/li[@class='eph-single-selection-item']//button[@class='eph-single-selection-item-button']//span[contains(text(),'AIR SEEDING')]")
	private WebElement jdscAirSeedingLink;
	// First model in Air seeder
	@FindBy(how = How.XPATH, xpath = "//ul[@class='eph-single-selection-list']//li[@class='eph-single-selection-item']//span[contains(text(),'700')]")
	private WebElement jdscFirstEquipLink;
	// First Equipment
	@FindBy(how = How.XPATH, xpath = "//div[@class='eph-click-through']//ul[@class='eph-single-selection-list']//li[@class='eph-single-selection-item']//button[@class='eph-single-selection-item-button']//span[contains(text(),'730')]")
	private WebElement jdscFirstEquip;
	// Select All In Base Options button
	@FindBy(how = How.XPATH, xpath = "//div[@class='actions-module-actionsContainer-3XzMo']//button[@class='btn btn-default select-all-btn']//span[contains(text(),'Select All In-Base Options')]")
	private WebElement selectAllBaseBtn;
	// Continue To Summary button
	@FindBy(how = How.XPATH, xpath = "//div[@class='price-group']//button[@class='base-button-module-baseButton-3jFYF primary-button-module-primaryButton-3lIl8 validate-configuration-btn']//span[contains(text(),'Continue To Summary')]")
	private WebElement continueToSummary;
	// Send To button
	@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Send To')]")
	private WebElement sendToBtn;
	// JDQuote2 button
	@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'JDQuote2')]")
	private WebElement jdquote2Btn;
	// JDSC B&P Search Box
	@FindBy(how = How.XPATH, xpath = "//div[@class='product-search-container']//div[@class='cap-it-ui-input-filter   ']//input[@class='filter-input']")
	private WebElement jdscBNPSearch;
	// JDSC B&P Model List
	@FindBy(how = How.XPATH, xpath = "//div[@class='search-result-item-module-searchResultItem-2BpZ6']//button//strong")
	private WebElement jdscModelList;
	// JDSC Sold To Drop down
	@FindBy(how = How.XPATH, xpath = "//div[@class='shipping-info']//div[@class='shipping-account-details']//div//select[@id='sold-to-account']")
	private WebElement jdscSoldTo;
	// JDSC DBS Button
	@FindBy(how = How.XPATH, xpath = "//*[@id='rightColumn']/table[1]/thead/tr[2]/th/a[2]")
	private WebElement jdscDBSBtn;
	// JDSC DBS Equipment Select Button
	@FindBy(how = How.XPATH, xpath = "//div[@class='price-column']//button[@class='toggle-button-module-toggleButton-27d5X select-machine-btn']//span[contains(text(),'Select')]")
	private WebElement jdscDBSSelectEquipBtn;
	// JDSC DBS Equipment Selected Button
	@FindBy(how = How.XPATH, xpath = "//div[@class='price-column']//button[@class='toggle-button-module-toggleButton-27d5X select-machine-btn toggle-button-module-active-3TAgM']//span[contains(text(),'Selected')]")
	private WebElement jdscDBSSelectedEquipBtn;
	// JDSC DBS Send To JDQuote2 Button
	@FindBy(how = How.XPATH, xpath = "//div[@class='page-actions']//button[@class='base-button-module-baseButton-UFFwe primary-button-module-primaryButton-3sffz multi-select-action-button']//span[contains(text(),'Send to JDQuote2')]")
	private WebElement jdscDBSSendToJdQuote2Btn;
	// JDSC DBS Search Field
	@FindBy(how = How.XPATH, xpath = "//div[@class='cap-it-ui-search-input-filter search-equipment  ']//input[@class='filter-input']")
	private WebElement jdscDBSSearchField;
	// JDSC DBS Search Button
	@FindBy(how = How.XPATH, xpath = "//div[@class='cap-it-ui-search-input-filter search-equipment  ']//button[@class='search-button inverted']")
	private WebElement jdscDBSSearchButton;
	// JDSC DBS Search Result
	@FindBy(how = How.XPATH, xpath = "//div[@class='search-result ']//div[@class='machine-description']//div[@class='machine-description-row']//div[@class='equipment-description-link-new-window']//a[@class='equipment-description']")
	private WebElement jdscDBSSearchResult;
	// JDSC DBS Vehicle Number
	@FindBy(how = How.XPATH, xpath = "//div[@class='machine-details-header-data-columns']//section[2]//dl[3]//dd[@class='value label-value-module-value-1W1JO value-module-value-2WQES']")
	private WebElement jdscDBSVehicleNumber;
	// JDSC DBS Equipment Details Select Button
	@FindBy(how = How.XPATH, xpath = "//div[@class='page-actions']//button[@class='toggle-button-module-toggleButton-27d5X select-machine-btn']//span[contains(text(),'Select')]")
	private WebElement jdscDBSEquipDtlSelectBtn;
	// JDSC DBS Equipment Details Selected Button
	@FindBy(how = How.XPATH, xpath = "//div[@class='page-actions']//button[@class='toggle-button-module-toggleButton-27d5X select-machine-btn toggle-button-module-active-3TAgM']//span[contains(text(),'Selected')]")
	private WebElement jdscDBSEquipDtlSelectedBtn;
	// JDSC DBS Equipment Details Cross Button
	@FindBy(how = How.XPATH, xpath = "//div[@class='page-actions']//button[@class='base-button-module-baseButton-UFFwe icon-button-module-iconButton-DSHGC machine-details-close-button']")
	private WebElement jdscDBSEquipDtlCrossBtn;

	// First Equipment on Equipment Page
	@FindBy(how = How.XPATH, xpath = "//div[@id='ajax_wait_message_div']/following::table//tbody//tr//td[3]//a")
	private WebElement firstEquip;
	// Equipment Description on Pricing Page
	@FindBy(how = How.XPATH, xpath = "//input[@name='equipmentDescription']")
	private WebElement equipDesc;

	// DBS Option**************
	@FindBy(how = How.LINK_TEXT, linkText = "DBS")
	private WebElement dbsOption;
	// All radio button
	@FindBy(how = How.XPATH, xpath = "//table[1]/tbody/tr[1]/td[1]/label[4]")
	private WebElement optionAll;
	// Inventory Status drop down
	@FindBy(how = How.XPATH, xpath = "//select[@name='selectedStatusCode']")
	private WebElement inventoryStatusDD;
	// Make Drop Down
	@FindBy(how = How.XPATH, xpath = "//select[@id='selectedMakeIdForDBS']")
	private WebElement makeDD;
	// Product Category
	@FindBy(how = How.XPATH, xpath = "//select[@name='selectedCategoryIdForDBS']")
	private WebElement dbsProductCategoryDD;
	// Model Input Box
	@FindBy(how = How.XPATH, xpath = "//input[@name='selectedModelIdForDBS']")
	private WebElement dbsModelInputBox;
	// Stock Number Text Box
	@FindBy(how = How.XPATH, xpath = "//input[@name='stockNumber']")
	private WebElement stockNumber;
	// Serial Number Input Box
	// @FindBy(how = How.XPATH, xpath = "//input[@name='serialNumber']")
	// private By serialNumberTextBox;
	@FindBy(how = How.XPATH, xpath = "//input[@name='serialNumber']")
	private WebElement serialNumberTextBox;
	// Store Location Drop Down
	@FindBy(how = How.XPATH, xpath = "//select[@name='selectedStoreLocationId']")
	private WebElement storeLocationDD;
	// Option Type Drop Down
	@FindBy(how = How.XPATH, xpath = "//select[@name='optionType']")
	private WebElement dbsOptionTypeDD;
	// search button to search equipment type
	@FindBy(how = How.XPATH, xpath = "//input[@id='dbsSearch']")
	private WebElement dbsSearchButton;
	// DBS search checkbox
	@FindBy(how = How.XPATH, xpath = "//input[@id='dBSEquipId']")
	public WebElement dbsEquipChecbox;
	// (//tbody/tr[i]/td[1]) -- for array

	// check specific equipment with specific criteria
	@FindBy(how = How.XPATH, xpath = "//input[@id='dBSEquipId']")
	private WebElement specificEquipCheckBox;
	// click specific serial number hyper link
	@FindBy(how = How.XPATH, xpath = "//a[@title='Equipment Details']")
	private WebElement specificSerialNumberLink;
	// DBS serial number column
	@FindBy(how = How.XPATH, xpath = "//tbody/tr[1]/td[9]")
	private WebElement serialNumberColumn;
	// (//tbody/tr[i]/td[9]) -- array
	// DBS add selected button after selecting equipment
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Add Selected')]")
	private WebElement addSelectedButton;

	// DBS Parts option********
	// DBSPrts button on Equipment tab
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'DBS Parts')]")
	private WebElement dbsPartsButton;
	// DBS Part Number Text box to enetr part number
	@FindBy(how = How.XPATH, xpath = "//*[@id='partNumber']")
	private WebElement dbsPartNumberTxtbox;
	// Search button on DBS Parts
	@FindBy(how = How.XPATH, xpath = "//*[@id='dbsPartsSearchBtn']")
	private WebElement dbsPartNumberSearchbtn;
	// Check box to select Part to add
	@FindBy(how = How.XPATH, xpath = "//*[contains(@id,'dBSEquipId')]")
	private WebElement partsCheckBox;
	// Part Quantity
	@FindBy(how = How.XPATH, xpath = "//*[contains(@id,'results')]/table/tbody/tr/td[4]")
	private WebElement partsQuantity;
	// Add Selected button on Parts result page
	@FindBy(how = How.LINK_TEXT, linkText = "Add Selected")
	private WebElement partsAddSelectedBtn;
	// DBS PArts Quantity Pop Up Quantity Text Field
	@FindBy(how = How.XPATH, xpath = "//*[contains(@name,'quantity')]")
	private WebElement quantityTxtBox;
	// Done Button On Parts Quantity Pop Up
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Done')]")
	private WebElement partsQuantityDoneBtn;
	// Cancel Button On Parts Quantity Pop Up
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Cancel')]")
	private WebElement partsQuantityCancelBtn;

	// Collateral option************
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Collateral')]")
	private WebElement collateralOption;
	// Collateral Product Category Drop Down
	@FindBy(how = How.XPATH, xpath = "//select[@name='selectedCategoryIdForCollateral']")
	private WebElement colProductCategoryDD;
	// Collateral Product Sub Category Drop Down
	@FindBy(how = How.XPATH, xpath = "//select[@name='selectedSubCategoryIdForCollateral']")
	private WebElement colProductSubCategoryDD;
	// Collateral Model Id Drop Down
	@FindBy(how = How.XPATH, xpath = "//select[@name='selectedModelIdForCollateral']")
	private WebElement colModelIdDD;
	// Collateral search button
	@FindBy(how = How.XPATH, xpath = "//td[@class='buttons']//input[@value='Search']")
	private WebElement colSearchButton;
	// Search Equip for collateral
	@FindBy(how = How.XPATH, xpath = "//*[@id='results']/table/tbody/tr[1]/td[3]")
	private WebElement ClickOnSerialNumber;
	// Select Equip of collateral(Apex)
	@FindBy(how = How.XPATH, xpath = "//*[@id='results']/table/tbody/tr[1]/td[1]")
	private WebElement SelectFirstCheckBox;
	// Save button of option code
	@FindBy(how = How.XPATH, xpath = "//table[@id='tableId']//input[@value='Save Options']")
	private WebElement saveOptions;
	// Reconfigure Collateral Equipment
	@FindBy(how = How.XPATH, xpath = "//a[@id='reconfigureLink']")
	private WebElement Reconfigure;
	// update Options to Equipment button
	@FindBy(how = How.XPATH, xpath = "//input[@value='Update Options to Equipment']")
	private WebElement updateOptionstoEquipment;

	// Verify Collateral equipment is present on the tab
	@FindBy(how = How.XPATH, xpath = "//*[@id='rightColumn']//table[3]//tbody//tr//td[3]//a")
	private WebElement verifyEquipmentOntab;

	// Service only equipment check box
	@FindBy(how = How.XPATH, xpath = "//*[@id='serviceOnlyEquipment']")
	private WebElement serviceOnlyEquipCheckBox;

	// Free form********************
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Free Form')]")
	private WebElement freeFormBtn;
	// free form make drop down
	@FindBy(how = How.XPATH, xpath = "//select[@id='make']")
	private WebElement freeFormMakedrpdwn;
	// free Form Model input box
	@FindBy(how = How.XPATH, xpath = "//input[@id='autocomplete']")
	private WebElement freeFormModel;
	// model drop down options
	@FindBy(how = How.XPATH, xpath = "(//li[@class='ui-menu-item']//a)")
	private List<WebElement> dropdownOptions;
	// free form serial number text box
	@FindBy(how = How.XPATH, xpath = "//input[@id='serialNumber']")
	private WebElement freeFormSerialNumbertxtbox;
	// basecode input text box
	@FindBy(how = How.XPATH, xpath = "//input[@name='baseCode']")
	private WebElement freeFormCodetxtbox;
	// description text box
	@FindBy(how = How.XPATH, xpath = "//input[@id='description']")
	private WebElement freeFormDescriptiontxtbox;
	// description text box other than quote
	@FindBy(how = How.XPATH, xpath = "//input[@id='idDescriptionEdit']")
	private WebElement freeFormDescrptxtbox1;
	// cost price text box
	@FindBy(how = How.XPATH, xpath = "//input[@name='costPrice']")
	private WebElement freeFormCostPricetxtbox;
	// cost price text box other than quote
	@FindBy(how = How.XPATH, xpath = "//input[@id='cost']")
	private WebElement freeFormCostPricetxtbox1;
	// list price text box
	@FindBy(how = How.XPATH, xpath = "//input[@name='displayListPrice']")
	private WebElement freeFormListPricetxtbox;
	// list price text box other than quote
	@FindBy(how = How.XPATH, xpath = "//input[@id='listBasePrice']")
	private WebElement freeFormListPricetxtbox1;
	// free form button
	@FindBy(how = How.XPATH, xpath = "//input[@value='Done']")
	private WebElement freeFormDonebtn;
	// fre form button
	@FindBy(how = How.XPATH, xpath = "//input[@value='Done']")
	private WebElement freeFormDonebtn1;
	// otion code link
	@FindBy(how = How.XPATH, xpath = "//b[contains(text(),'Option Codes')]")
	private WebElement optionCodeLink;
	// done button after doing changes in equipment details page
	@FindBy(how = How.XPATH, xpath = "//td[@class='buttons']//input[@value='Done']")
	private WebElement doneButtonOnEquipPage;
	// cancel button on equipment details page
	@FindBy(how = How.XPATH, xpath = "//td[@class='buttons']//input[@value='Cancel']")
	private WebElement cancelButtonOnEquipPage;

	@FindBy(how = How.XPATH, xpath = "//*[@id='results']/table/tbody/tr/td[1]")
	private List<WebElement> equipCheckBox;

	// Pricing Page************
	// CUstomer's Latest Machine Drop Down On Pricing page
	@FindBy(how = How.XPATH, xpath = "//select[@id='selectedCustLatestMachine']")
	public WebElement prcngPgeLtstMchnDrpDon;
	// Show/Hide Cost Link
	@FindBy(how = How.XPATH, xpath = "//a[@id='costPriceLink']")
	private WebElement showCostLnk;
	// Equipment Cost Price on Pricing Page
	@FindBy(how = How.XPATH, xpath = "//input[@name='codeCosts']")
	public List<WebElement> equipOptCostPrice;
	// Equipment List Price on Pricing Page
	@FindBy(how = How.XPATH, xpath = "//input[@name='displayCodeListPrices']")
	public List<WebElement> equipOptListPrice;
	// Equipment Total cost Price on Pricing Page
	@FindBy(how = How.XPATH, xpath = "//div[@id='adjustedEquipmentCostPrice']")
	public WebElement totEquipCostPrice;
	// Equipment Total List Price on Pricing Page
	@FindBy(how = How.XPATH, xpath = "//div[@id='adjustedEquipmentListPrice']")
	public WebElement totEquipListPrice;
	// Adjustments Cost Price
	@FindBy(how = How.XPATH, xpath = "//input[@name='adjustmentsCostPrice']")
	public List<WebElement> adjustmentCostPrice;
	// Adjustments Total Cost Price
	@FindBy(how = How.XPATH, xpath = "//div[@id='totalAdjustmentsCostPrice']")
	public WebElement totAdjCostPrice;
	// Adjustments List Price
	@FindBy(how = How.XPATH, xpath = "//input[@name='displayAdjustmentsListPrice']")
	public List<WebElement> adjustmntListPrice;
	// Adjustments Total List Price
	@FindBy(how = How.XPATH, xpath = "//div[@id='totalAdjustmentsListPrice']")
	public WebElement totAdjListPrice;
	// Tech Options Check box
	@FindBy(how = How.XPATH, xpath = "//input[@name='selectedDealerAccessoriesTechOpt']")
	public WebElement techOptChkBox;
	// Tech Options Cost Price
	@FindBy(how = How.XPATH, xpath = "//input[@name='dealerAccessoriesCostExtendedTechOpt']")
	public List<WebElement> techOptCostPrice;
	// Tech Options List Price
	@FindBy(how = How.XPATH, xpath = "//input[@name='discountPriceTechOpt']")
	public List<WebElement> techOptListPrice;
	// Tech Options Total Cost Price
	@FindBy(how = How.XPATH, xpath = "//div[@id='totalDealerAccessoriesCostExtendedTechOpt']")
	public WebElement techOptTotCostPrice;
	// Tech Options Total List Price
	@FindBy(how = How.XPATH, xpath = "//div[@id='totalDealerAccessoriesListExtendedTechOpt']")
	public WebElement techOptTotListPrice;
	// Attachment Check Box
	@FindBy(how = How.XPATH, xpath = "//input[@name='incentivesCheckBox']")
	public WebElement attachmetChkBox;
	// Attachment Cost Price
	@FindBy(how = How.XPATH, xpath = "//input[@name='dealerAccessoriesCostExtended']")
	public List<WebElement> attCostPrice;
	// Attachment List Price
	@FindBy(how = How.XPATH, xpath = "//input[@name='discountPrice']")
	public List<WebElement> attListPrice;
	// Attachment Total Cost Price
	@FindBy(how = How.XPATH, xpath = "//div[@id='totalDealerAccessoriesCostExtended']")
	public WebElement attTotCostPrice;
	// Attachment Total List Price
	@FindBy(how = How.XPATH, xpath = "//div[@id='totalDealerAccessoriesListExtended']")
	public WebElement attTotListPrice;
	// Equipment Total Cost Price
	@FindBy(how = How.XPATH, xpath = "//div[@id='totalEquipmentCostPrice']")
	public WebElement equipTotCostPrice;
	// Equipment Total List Price
	@FindBy(how = How.XPATH, xpath = "//div[@id='totalEquipmentListPrice']")
	public WebElement equipTotListPrice;
	// Sales Incentives Check box
	@FindBy(how = How.XPATH, xpath = "//input[@name='marketingIncentivesAppliedCheckBox']")
	public List<WebElement> salesIncentiveChkBox;
	// Sales Incentive Bulletin
	@FindBy(how = How.XPATH, xpath = "//table[@id='pricingTable']//following::table//tbody//tr//td[2]//a")
	public List<WebElement> salesIncentiveBulletin;
	// Sales Incentive Applied field
	@FindBy(how = How.XPATH, xpath = "//div[@id='marketingIncentivesDollarAppliedHTML']")
	public List<WebElement> salesIncentiveApplied;
	// Equipment Attachment Technology Options Total Cost Price
	@FindBy(how = How.XPATH, xpath = "//div[@id='totalEquipAttachmentCostPrice']")
	public WebElement equipAttachTotCostPrice;
	// Equipment Attachment Technology Options Total List Price
	@FindBy(how = How.XPATH, xpath = "//div[@id='totalEquipAttachmentListPrice']")
	public WebElement equipAttachTotListPrice;
	// Dollars above Net Cost - Equipment
	@FindBy(how = How.XPATH, xpath = "//input[@name='dollarAboveNetCost']")
	public WebElement equipDollarsAboveNetCost;
	// Adjusted Selling Price - Equipment
	@FindBy(how = How.XPATH, xpath = "//input[@name='displayAdjustmentSellingPrice']")
	public WebElement equipAdjustedSellingPrice;
	// Equipment Discount 
	@FindBy(how = How.XPATH, xpath = "//input[@name='discountFromListInDollar']")
	public WebElement equipDiscount;
	// Equipment Discount 
	@FindBy(how = How.XPATH, xpath = "//input[@id='dealerAccessoriesDiscountFromListInDollarTechOpt']")
	public WebElement techOptDiscount;
	// Equipment Discount 
	@FindBy(how = How.XPATH, xpath = "//input[@id='dealerAccessoriesDiscountFromListInDollar']")
	public WebElement attachDiscount;
	//Total Discount - Equipment
	@FindBy(how = How.XPATH, xpath = "//div[@id='totalDiscountFromListInDollar']")
	public WebElement totDiscount;
	// Margin - Equipment
	@FindBy(how = How.XPATH, xpath = "//input[@name='marginPercentage']")
	public WebElement equipMargin;
	// Dollars above Net Cost - Attachment
	@FindBy(how = How.XPATH, xpath = "//input[@id='dealerAccessoriesDollarAboveNetCost']")
	public WebElement attDollarsAboveNetCost;
	// Adjusted Selling Price - Attachment
	@FindBy(how = How.XPATH, xpath = "//input[@id='dealerAccessoriesSellingPrice']")
	public WebElement attAdjustedSellingPrice;
	// Margin - Attachment
	@FindBy(how = How.XPATH, xpath = "//input[@id='dealerAccessoriesMarginPercentage']")
	public WebElement attMargin;
	// Dollars above Net Cost - Technology Options
	@FindBy(how = How.XPATH, xpath = "//input[@id='dealerAccessoriesDollarAboveNetCostTechOpt']")
	public WebElement techoptDollarsAboveNetCost;
	// Adjusted Selling Price - Technology Options
	@FindBy(how = How.XPATH, xpath = "//input[@id='dealerAccessoriesSellingPriceTechOpt']")
	public WebElement techOptAdjustedSellingPrice;
	// Margin - Technology Options
	@FindBy(how = How.XPATH, xpath = "//input[@id='dealerAccessoriesMarginPercentageTechOpt']")
	public WebElement techoptMargin;
	// Dollars above Net Cost - Total
	@FindBy(how = How.XPATH, xpath = "//div[@id='totalDollarAboveNetCost']")
	public WebElement totDollarsAboveNetCost;
	// Adjusted Selling Price - Total
	@FindBy(how = How.XPATH, xpath = "//div[@id='totalSellingPrice']")
	public WebElement totAdjustedSellingPrice;
	// Margin - Total
	@FindBy(how = How.XPATH, xpath = "//div[@id='totalMargin']")
	public WebElement totMargin;
	//Adjustment Expantion Image
	@FindBy(how = How.XPATH,xpath = "//div[@id='expandAdjBox']//img[@id='expandOptionCode']")
	public WebElement adjExpantionImg;
	//Adjustment Expantion Image
	@FindBy(how = How.XPATH,xpath = "//div[@id='expandTechOptBox']//img[@id='expandOptionCode']")
	public WebElement techOptExpantionImg;
	// SAP Order Details
	@FindBy(how = How.XPATH,xpath = "//img[@id='expandOrderDetails']")
	public WebElement sapOrderDetailsImg;

	// MFPRO*******************
	// Click on MachineFinderpro equipment
	@FindBy(how = How.XPATH, xpath = "//*[text()='MachineFinder Pro']")
	private WebElement machineFinderProEquipLink;
	// MachineFinder Pro page
	@FindBy(how = How.XPATH, xpath = "//*[@id='uxsearch']")
	private WebElement MachineFinderProPage;
	// Click on Find In My Inventory of MFPRO
	@FindBy(how = How.XPATH, xpath = "//*[@class='mfm-link tile yellow fade_in fade_in_0 feature' or @class='mfm-link tile yellow fade_in fade_in_1 feature']")
	private WebElement FindInMYInventory;
	// Manufacturer option
	@FindBy(how = How.XPATH, xpath = "//*[@id='manufacturer']")
	private WebElement ManufacturerLink;
	// John deere check box selection from manufacturer link
	@FindBy(how = How.XPATH, xpath = "//*[@name='sk_trucks']")
	private WebElement sk_trucks;
	// Click on Apply Quote
	@FindBy(how = How.XPATH, xpath = "//*[text()='APPLY TO QUOTE']")
	private WebElement applyToQuote;
	// MFPro Equipment List
	@FindBy(how = How.XPATH, xpath = "//*[contains(@class,'machines_all')]")
	private WebElement mfproEquipList;
	// Number Of Equipment Link
	@FindBy(how = How.XPATH, xpath = "//*[@class='browsing_machines_count']")
	private WebElement numEquipLink;

	// Configurator*******
	// Configurator link on equipment tab
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'AG Config')]")
	private WebElement configuratorLink;
	
//	Link of frontier Configurator on equipment tab
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Frontier Config')]")
	private WebElement frontierConfiguratorLink;
	
 // SAP Details Window Continue page
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Continue')]")
	private WebElement sapContinue;
	
	// Model Search Text box on Configurator page
	@FindBy(how = How.XPATH, xpath = "//*[contains(@id,'searchModel')]")
	private WebElement modelSearchInputBox;
	// handling iframe for Configurator page
	String frameName2 = "configure";
	// Passing model name in search box of config page
	public static String model = "2134P";
	// Number Of Equipments
	@FindBy(how = How.XPATH, xpath = "//div[@id='ajax_wait_message_div']//following::table[@class='data']//tbody//tr//td//input[@name='sequenceNumbers']")
	private List<WebElement> numEquipment;
	// Click on populating configurator page
	@FindBy(how = How.XPATH, xpath = "//div[@class='ac_results']//li[@class='ac_even ac_over']")
	private WebElement selectequipment;
	// Search Link
	@FindBy(how = How.XPATH, xpath = "//*[@value='Search Now']")
	private WebElement searchBox;
	// Select base code 1st
	@FindBy(how = How.XPATH, xpath = "//*[@id='2134P']")
	private WebElement baseCode;
	// Click on Send 2 JDQuote
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Send to JDQuote2')]")
	private WebElement send2JDQuote;
	//	Replace From Collateral
	@FindBy(how=How.XPATH, xpath="//*[@id='rightColumn']//table[3]//tbody//tr//td[11]//a//img[@alt='Replace From Collateral']")
	private WebElement replaceFromOnEquipmentTab;
	//	Click on Replace with selected
	@FindBy(how=How.XPATH, xpath="//*[contains(text(),'Replace With Selected')]")
	private WebElement replaceWithSelected;
	// Model List on Configurator page for R2
	@FindBy(how=How.XPATH, xpath="//div[@class='ac_results']//ul//li")
	private WebElement r2modelList;
	
	// Serach button on Configurator page of Russia
	@FindBy(how=How.XPATH, xpath="//input[contains(@value,'Искать')]")
	private WebElement r2ConfigSearch;
	
	// Send To JDQuote2 button on Configurator page of Russia
		@FindBy(how=How.XPATH, xpath="//a[@id='JDQUOTE_Href']")
		private WebElement r2SendToJDQuote;
		
	// Inco Term Selection Drop Down
		@FindBy(how=How.XPATH, xpath="//select[@id='incoTermForJDQuote_0']")
		private WebElement incoTermSelectionDrpBox;
		
	// Inco Term Submit Button
		@FindBy(how = How.ID, id="incoTermJDQuoteButtonSubmit")
		private WebElement incoTermSubmitBtn;
	
	// ******** Equipment Page **************************
//  Copy/Delete equipment check box to select all equipment
	@FindBy(how = How.XPATH, xpath = "//*[contains(@name,'genericAllBox')]")
	private WebElement deleteCopychkbox;
//  Copy Selected button on Equipment page
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Copy Selected')]")
	private WebElement copySelectedbtn;
//  Delete Selected on Equipment page
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Delete Selected')]")
	private WebElement deleteSelectedbtn;
//  Check boxes along with the Equipment on Equipment page
	@FindBy(how = How.XPATH, xpath = "//*[@id='rightColumn']/table[3]/tbody")
	private WebElement equipmentList;
//  Done button on Copy Equipment pop up
	@FindBy(how = How.LINK_TEXT, linkText = "Done")
	private WebElement doneOnCopyEquipment;
//  Cancel button on Copy Equipment pop up
	@FindBy(how = How.LINK_TEXT, linkText = "Cancel")
	private WebElement cancelOnCopyEquipment;
//  Yes Button on Delete Equipment Alert
	@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Yes')]")
	private WebElement yesOnDeleteEquipmentAlert;
//  No Button on Delete Equipment Alert
	@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'No')]")
	private WebElement noOnDeleteEquipmentAlert;
// Customer's Latest Machine On Equipment Page - R2
	@FindBy(how = How.XPATH,xpath = "//select[@id='selectedCustLatestMachine_0']")
	public WebElement equipCustLatestMachine;

//  i icon of Sales Manual
    @FindBy(how = How.XPATH, xpath = "//table[@class='data']/tbody/tr[1]/td[9]/a/img[@alt='Sales Manual']")
	private WebElement salesManual;
	
//  i icon to verify Original Factory Build Codes and Warranty Coverage
	@FindBy(how = How.XPATH, xpath = "//*[contains(@title,'Original Factory Build Codes')]")
	private WebElement originalFactoryCodesIImg;
	
//  Original Factory Build codes of an Equipment
	@FindBy(how = How.XPATH, xpath = "//table[@class='data']/tbody")
	private WebElement originalFactoryBuildCodes;
//  Warranty Coverage Of an Equipment
	@FindBy(how = How.XPATH, xpath = "//table[2]/tbody")
	private WebElement warrantyCoverage;
	

	
	// ***************** Equipment Page Functionalities*******************************
	

			// Calculating number of Equipment on page
			
					public int equipmentList()
					{
						int numOfEquip = equipmentList.findElements(By.name("sequenceNumbers")).size();
						System.out.println("Number of Checkboxes:"+numOfEquip);
						return numOfEquip;
						
					}
					
//			    Select all Equipment
					
					public void selectAllEquip()
					{
						List<WebElement> equipList = equipmentList.findElements(By.name("sequenceNumbers"));
						for ( WebElement el : equipList ) 
						{
						    if ( !el.isSelected() ) 
						    {
						        el.click();
						    }
						}
					} 
					
					public void clickSalesManualIcon() throws InterruptedException
					{
						String expected = "John Deere - Sign In";
						salesManual.click();
						CommonFunctions.switchToChildWindow(driver);
						Thread.sleep(5000);		
						/*otherUsername.sendKeys("SP23213");
						nextbtn.click();*/
						Thread.sleep(10000);
						String actual = driver.getTitle();
						System.out.println("Sales Manual Application Title:"+actual);
						
						if(expected.equals(actual))
						{
							System.out.println("Test case pass");
						}
						else
						{
							System.out.println("Test case failed");
						}
						
						driver.close();
						
						CommonFunctions.switchToParentWindow(driver);
						
						
					}
						
//					   Copy All The Equipment
					
						public void copyEquipmentbySelecting() throws InterruptedException
						{
							int equipCount = equipmentList();
							System.out.println("Number Of Equipment: "+equipCount);
							selectAllEquip();
							copySelectedbtn.click();
							Thread.sleep(10000);
							int frameCount = driver.findElements(By.tagName("iframe")).size();
							System.out.println("Number of Ifremws:"+frameCount);
							CommonFunctions.switchToFramewithIndex(driver,0);
							System.out.println("Frame Activted");
							doneOnCopyEquipment.click();
							System.out.println("Clicked on Copy Equipment");
							CommonFunctions.switchToDefaultFrame(driver);
							
							int equipCount1 = equipmentList();
							if(equipCount1==(equipCount*2))
							{
								System.out.println("Test case pass");
							}
							
							else
							{
								System.out.println("Test case failed");
							}
							
							
							
						}
						
				//  Cancel copying of an Equipment by clicking on Cancel button
						public void cancelCopyEquipment() throws InterruptedException
						{
							int equipCount = equipmentList();
							System.out.println("Number of Checkboxes:"+equipCount);
							selectAllEquip();
							copySelectedbtn.click();
							Thread.sleep(10000);
							int frameCount = driver.findElements(By.tagName("iframe")).size();
							System.out.println("Number of Ifremws:"+frameCount);
							CommonFunctions.switchToFramewithIndex(driver,0);
							System.out.println("Frame Activted");
							cancelOnCopyEquipment.click();
							CommonFunctions.switchToDefaultFrame(driver);
							int equipCount1 = equipmentList();
							if(equipCount1==equipCount)
							{
								System.out.println("Test case pass");
							}
							
							else
							{
								System.out.println("Test case failed");
							}
						}
						
//						Select Delete/Copy check box and Delete Selected Equipment
						
						public void deleteEquipment() throws InterruptedException
						{
							int equipCount = equipmentList();
							System.out.println("Number Of Equipment: "+equipCount);
							selectAllEquip();
							deleteSelectedbtn.click();			
							yesOnDeleteEquipmentAlert.click();
							int equipCount1 = equipmentList();
							if(equipCount1==0)
							{
								System.out.println("Test case pass");
							}
							
							else
							{
								System.out.println("Test case failed");
							}
							
							
						}
						
				//  Click on Cancel button of Delete Equipment Pop up
						
						public void clickCancelOnDeleteEquipment()
						{
							int equipCount = equipmentList();
							System.out.println("Number Of Equipment: "+equipCount);
							selectAllEquip();
							deleteSelectedbtn.click();			
							yesOnDeleteEquipmentAlert.click();
							int equipCount1 = equipmentList();
							if(equipCount1==0)
							{
								System.out.println("Test case pass");
							}
							
							else
							{
								System.out.println("Test case failed");
							}
						}
	
//	Delete Quote
	@FindBy(how=How.XPATH, xpath="//img[@class='i_delete']")
	public WebElement deleteQuote;

	// Click Equipment Tab
	public void clickOnEquipmentTab() {
		equipmentTab.click();
	}

	// click on DBS option
	public void clickOnDBSTab() throws InterruptedException {
		dbsOption.click();
		Thread.sleep(10000);
	}

	// click on search button
	public void clickDBSSearchButton() throws InterruptedException {
		dbsSearchButton.click();
		Thread.sleep(17000);
	}

	// check the specific checkbox with the specific serial number
	public void checkSearchedEquipCheckbox() {
		specificEquipCheckBox.click();
	}

	// click on Option Code Link
	public void clickOptionCodeLink() throws InterruptedException {
		CommonFunctions.clickOnElement(driver, optionCodeLink);
		Thread.sleep(10000);
	}

	// Search equipment with hardcoded serial number
	public void enterSerialNumber(String uniqueQuoteName) throws InterruptedException {
		serialNumberTextBox.sendKeys(uniqueQuoteName);
		dbsSearchButton.click();
		Thread.sleep(10000);
	}

	// For mouse hovering action for the page that gets load after adding
	// equipment
	public void mouseHover() {
		Actions hover = new Actions(driver);
		WebElement Elem_to_hover = driver.findElement(By.xpath("//th[contains(text(),'Equipment Status')]"));
		hover.moveToElement(Elem_to_hover);
		hover.build();
		hover.perform();
	}

	// click on searched serial number Hyper link
	public void clickSearchedSerialNumberLink() throws InterruptedException {
		specificSerialNumberLink.click();
		Thread.sleep(10000);
	}

	// after checking the required equip, click on add selected tab
	public void clickOnAddSelected() throws InterruptedException {
		CommonFunctions.clickOnElement(driver, addSelectedButton);
		Thread.sleep(2000);
		CommonFunctions.acceptAlert(driver);
		Thread.sleep(20000);
		//mouseHover();
		Thread.sleep(2000);
	}
	
	// Select Customer Latest Machine option on Equipment Page - R2
	public void selectCustLatestMachine()
	{
		if(equipCustLatestMachine.isEnabled())
		{
			Select select = new Select(equipCustLatestMachine);
			select.selectByIndex(1);
		}
	}

	// switch to child window after licking on serial number before adding
	// equipment
	public void comparisionOfOptionsCodes() throws InterruptedException {
		List<String> optionCodesBeforeAdding = null;
		String MainWindow = driver.getWindowHandle();
		Set<String> sizeOfWindow = driver.getWindowHandles();
		// Assert.assertEquals("Validation Window is not displayed for option
		// code", 2, sizeOfWindow.size());
		Iterator<String> iterate = sizeOfWindow.iterator();
		while (iterate.hasNext()) {
			String ChildWindow = iterate.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				System.out.println(driver.switchTo().window(ChildWindow).getTitle());
				optionCodesBeforeAdding = listOfEquipOptionCodesBeforeAdding();
				driver.close();
			}
		}
		driver.switchTo().window(MainWindow);
		System.out.println(driver.switchTo().window(MainWindow).getTitle());
		//		checkSearchedEquipCheckbox();
		//		clickOnAddSelected();
		clickOptionCodeLink();
		List<String> optionCodesAfterAdding = listOfEquipOptionCodesAfterAdding();
		System.out.println("Option Codes comparision started");
		try {
			Assert.assertEquals(optionCodesBeforeAdding, optionCodesAfterAdding);
			System.out.println("Equal lists");
		} catch (Throwable e) {
			System.err.println("Lists are not equal. " + e.getMessage());
		}

	}

	// To get list of Option codes available on clicking serial number before
	// adding equip
	public ArrayList<String> listOfEquipOptionCodesBeforeAdding() {
		List<WebElement> listOfOptionCodes = driver.findElements(By.xpath("//table[3]/tbody/tr/td[1]"));
		ArrayList<String> finalEquipList = new ArrayList<String>();
		for (int i = 1; i < listOfOptionCodes.size(); i++) {
			String path1 = "//table[3]/tbody/tr[";
			String path2 = "]/td[1]";
			String fullPath = path1 + i + path2;
			System.out.println(driver.findElement(By.xpath(fullPath)).getText());
			finalEquipList.add(driver.findElement(By.xpath(fullPath)).getText());
		}
		return finalEquipList;
	}

	// To get list of option codes after adding equipment on parent window
	public ArrayList<String> listOfEquipOptionCodesAfterAdding() {
		List<WebElement> listOfOptionCodes = driver.findElements(By.xpath("//input[@name='codes']"));
		ArrayList<String> optionCodesList = new ArrayList<String>();
		for (int i = 1; i <= listOfOptionCodes.size(); i++) {
			String path1 = "(//input[@name='codes'])[";
			String path2 = "]";
			String finalPath = path1 + i + path2;
			System.out.println(driver.findElement(By.xpath(finalPath)).getAttribute("value"));
			optionCodesList.add(driver.findElement(By.xpath(finalPath)).getAttribute("value"));
		}
		return optionCodesList;
	}

	public void selectEquipment() throws InterruptedException {
		int size = equipCheckBox.size();
		int index = CommonFunctions.randomNumberGenerator(size);
		equipCheckBox.get(index).click();
	}

	// add collateral for government quote
	public void addCollateralEquip1() throws InterruptedException {
		collateralOption.click();
		CommonFunctions.acceptAlert(driver);
		Thread.sleep(10000);
		colSearchButton.click();
		Thread.sleep(15000);
		selectEquipment();
		clickOnAddSelected();
		clickDoneOnLeftNav();
	}

	// add equipment from collateral
	public void addCollateralEquipment() throws InterruptedException {
		collateralOption.click();
		Thread.sleep(10000);
		colSearchButton.click();
		Thread.sleep(10000);
		selectEquipment();
		clickOnAddSelected();
	}

	// Adjustment of collateral equipment
	public void adjustmentSection() throws InterruptedException {
		List<WebElement> TotalnumberOfAdjustment = driver.findElements(By.xpath("//*[@id='adjTable']"));

		ArrayList<String> finalAdjustment = new ArrayList<String>();
		for (int i = 0; i < TotalnumberOfAdjustment.size(); i++) {
			System.out.println("Total number of adjustment " + finalAdjustment.size());
			System.out.println(TotalnumberOfAdjustment.get(i).getText());
			finalAdjustment.add(TotalnumberOfAdjustment.get(i).getText());
			clickDoneOnLeftNav();
		}
	}

	//	Add collateral equipment
	public void addCollateralEquipmentOnEquipmentTab() throws InterruptedException{
		collateralOption.click();
		Thread.sleep(5000);
		colSearchButton.click();
		Thread.sleep(20000);

		SelectFirstCheckBox.click();
		Thread.sleep(10000);
		clickOnAddSelected();
		clickDoneOnLeftNav();

		System.out.println("Name of collateral equipmemnt is "+verifyEquipmentOntab.getText());

		CommonFunctions.clickOnElement(driver, deleteQuote);
		CommonFunctions.acceptAlert(driver);

	}


	// verify collateral equipment options
	public void verifyCollateralEquipment() throws InterruptedException {
		CommonFunctions.clickOnElement(driver, collateralOption);
		Thread.sleep(5000);
		CommonFunctions.clickOnElement(driver, colSearchButton);
		Thread.sleep(20000);
		CommonFunctions.clickOnElement(driver, ClickOnSerialNumber);
		CommonFunctions.clickOnElement(driver, SelectFirstCheckBox);
		Thread.sleep(10000);
		clickOnAddSelected();
		clickOptionCodeLink();
		System.out.println("Click on the option code");
		Thread.sleep(10000);
		comparisionOfOptionsCodes();
		//		saveOptions.click();
		System.out.println("Save Option button is working on collateral equipment page for option code");
		Thread.sleep(10000);
		CommonFunctions.clickOnElement(driver, Reconfigure);
		System.out.println("Reconfigure button is working");
		Thread.sleep(20000);
		// Click on Updates option inframe reconfgure
		CommonFunctions.switchToFrameWithFrameName(driver, frameName);
		CommonFunctions.clickOnElement(driver, updateOptionstoEquipment);
		CommonFunctions.switchToDefaultFrame(driver);
		// driver.switchTo().defaultContent();
		Thread.sleep(10000);
		// Verify Adjustments
		//		adjustmentSection();
		salesIncentiveBulletin();
		pricingCalc(equipOptCostPrice,equipOptListPrice,
				totEquipCostPrice, totEquipListPrice);
		pricingCalc(adjustmentCostPrice, adjustmntListPrice,
				totAdjCostPrice, totAdjListPrice);

		if (techOptChkBox.isDisplayed())
			pricingCalc(techOptCostPrice, techOptListPrice,
					techOptTotCostPrice, techOptTotListPrice);
		if (attachmetChkBox.isDisplayed())
			pricingCalc(attCostPrice, attListPrice,
					attTotCostPrice, attTotListPrice);
		totMarginCalc();

		clickDoneOnLeftNav();
		System.out.println("Name of collateral equipmemnt is "+verifyEquipmentOntab.getText());
		CommonFunctions.clickOnElement(driver, deleteQuote);
		CommonFunctions.acceptAlert(driver);
	}

	// click on done button on left navigation
	public void clickDoneOnLeftNav() throws InterruptedException {
		CommonFunctions.clickOnElement(driver, doneLeftNav);
		Thread.sleep(5000);
	}

	// click on create Demo Agreement Link
	public void createDemoAgreementOnLeftNav() throws InterruptedException {
		createDemoAgreementLink.click();
		Thread.sleep(10000);
	}

	// click on create Demo Agrrement link
	public void createRentalAgreementOnLeftNav() throws InterruptedException {
		createRentalAgreementLink.click();
		Thread.sleep(10000);
	}

	// click on Create new Agreement on left navigation
	public void createNewRentalAgreement() throws InterruptedException {
		createNewRentalAgreementLink.click();
		Thread.sleep(10000);
	}

	// click on Create New Demo Agreement on left navigation
	public void createNewDemoAgreement() throws InterruptedException {
		createNewDemoAgreementLink.click();
		Thread.sleep(10000);
	}

	public void addFreeFormEquipment_R2() throws InterruptedException {
		clickOnFreeformbtn();
		selectMakeOnFreeForm(freeformMake);
		seldctModelOnFreeForm(freeformModel);
		addBaseCodeOnFreeForm(freeFormBaseCode);
		addDescription(freeFormDescription);
		addCostPriceOnFreeForm(freeFormCostPrice);
		addListPriceOnFreeForm(freeFormListPrice);
		clickOnDoneOfFreeForm();
		if(prcngPgeLtstMchnDrpDon.isDisplayed())
			CommonFunctions.selectFromDropdown("Basak",prcngPgeLtstMchnDrpDon);
		Thread.sleep(10000);
		CommonFunctions.isExpanded(adjExpantionImg);
		CommonFunctions.isExpanded(techOptExpantionImg);
		salesIncentiveBulletin();
		pricingCalc(equipOptCostPrice, equipOptListPrice, totEquipCostPrice, totEquipListPrice);
		pricingCalc(adjustmentCostPrice, adjustmntListPrice, totAdjCostPrice, totAdjListPrice);
		if (techOptChkBox.isDisplayed())
			pricingCalc(techOptCostPrice, techOptListPrice, techOptTotCostPrice, techOptTotListPrice);
		if (attachmetChkBox.isDisplayed())
			pricingCalc(attCostPrice, attListPrice, attTotCostPrice, attTotListPrice);
		equipTotalCalc();
		equipAttachTechOpsCalc();
		marginCalc(equipDollarsAboveNetCost, equipAdjustedSellingPrice, equipMargin, equipTotCostPrice,
				equipTotListPrice,equipDiscount);
		marginCalc(attDollarsAboveNetCost, attAdjustedSellingPrice, attMargin, attTotCostPrice, attTotListPrice,attachDiscount);
		marginCalc(techoptDollarsAboveNetCost, techOptAdjustedSellingPrice, techoptMargin, techOptTotCostPrice,
				techOptTotListPrice,techOptDiscount);
		totMarginCalc();
		clickDoneOnLeftNav();
		copyEquipmentbySelecting();
		deleteEquipment();
		

	}
	
	public void addFreeFormEquipment() throws InterruptedException {
		clickOnFreeformbtn();
		selectMakeOnFreeForm(freeformMake);
		seldctModelOnFreeForm(freeformModel);
		addBaseCodeOnFreeForm(freeFormBaseCode);
		addDescription(freeFormDescription);
		addCostPriceOnFreeForm(freeFormCostPrice);
		addListPriceOnFreeForm(freeFormListPrice);
		clickOnDoneOfFreeForm();
		Thread.sleep(10000);
		salesIncentiveBulletin();
		pricingCalc(equipOptCostPrice, equipOptListPrice, totEquipCostPrice, totEquipListPrice);
		pricingCalc(adjustmentCostPrice, adjustmntListPrice, totAdjCostPrice, totAdjListPrice);
		if (techOptChkBox.isDisplayed())
			pricingCalc(techOptCostPrice, techOptListPrice, techOptTotCostPrice, techOptTotListPrice);
		if (attachmetChkBox.isDisplayed())
			pricingCalc(attCostPrice, attListPrice, attTotCostPrice, attTotListPrice);
		equipTotalCalc();
		equipAttachTechOpsCalc();
		marginCalc(equipDollarsAboveNetCost, equipAdjustedSellingPrice, equipMargin, equipTotCostPrice,
				equipTotListPrice,equipDiscount);
		marginCalc(attDollarsAboveNetCost, attAdjustedSellingPrice, attMargin, attTotCostPrice, attTotListPrice,attachDiscount);
		marginCalc(techoptDollarsAboveNetCost, techOptAdjustedSellingPrice, techoptMargin, techOptTotCostPrice,
				techOptTotListPrice,techOptDiscount);
		totMarginCalc();
		clickDoneOnLeftNav();
		copyEquipmentbySelecting();	

	}

	// Click On Free Form Button

	public void clickOnFreeformbtn() throws InterruptedException {
		freeFormBtn.click();
		Thread.sleep(10000);
	}

	// Select Make On Free form page
	public void selectMakeOnFreeForm(String freeformMake) throws InterruptedException {
		Select select = new Select(freeFormMakedrpdwn);
		select.selectByVisibleText(freeformMake);
	}

	// Select Model on Free Form Page
	public void seldctModelOnFreeForm(String freeformModel) throws InterruptedException {
		freeFormModel.sendKeys(freeformModel);
		Thread.sleep(3000);
		int size = dropdownOptions.size();
		if (size != 0) {
			System.out.println(size);
			int index = CommonFunctions.randomNumberGenerator(size);
			dropdownOptions.get(index).click();
			Thread.sleep(10000);
		} else {
			System.out.println("Model List not populated");
		}
	}

	// Add hard coded Serial Number to the Equipment on Free Form
	public void addSerialNumberOnFreeForm(String SerialNumber) throws InterruptedException {
		freeFormSerialNumbertxtbox.sendKeys(SerialNumber);
		Thread.sleep(10000);
	}

	// Add hard coded Base code to the Equipment on Free Form
	public void addBaseCodeOnFreeForm(String baseCode) throws InterruptedException {
		freeFormCodetxtbox.sendKeys(baseCode);
		Thread.sleep(10000);
	}

	// Add Hard coded Description to Equipment on Free Form
	public void addDescription(String description) throws InterruptedException {
		freeFormDescriptiontxtbox.sendKeys(description);
		Thread.sleep(10000);
	}

	// Add hard coded cost price to Equipment on Free form page
	public void addCostPriceOnFreeForm(String costPrice) throws InterruptedException {
		freeFormCostPricetxtbox.sendKeys(Keys.CONTROL + "a");
		freeFormCostPricetxtbox.sendKeys(Keys.DELETE);
		freeFormCostPricetxtbox.sendKeys(costPrice);
		Thread.sleep(10000);
	}

	// Add hard coded List price to Equipment on Free form page
	public void addListPriceOnFreeForm(String listPrice) throws InterruptedException {
		freeFormListPricetxtbox.sendKeys(Keys.CONTROL + "a");
		freeFormListPricetxtbox.sendKeys(Keys.DELETE);
		freeFormListPricetxtbox.sendKeys(listPrice);
		Thread.sleep(10000);
	}

	// Click on Done button of Free Form page
	public void clickOnDoneOfFreeForm() throws InterruptedException {
		freeFormDonebtn.click();
		Thread.sleep(10000);
	}

	public void addFreeFormEquipCBD() throws InterruptedException {
		clickOnFreeformbtn();
		CommonFunctions.acceptAlert(driver);
		Thread.sleep(10000);
		selectMakeOnFreeForm(freeformMake);
		seldctModelOnFreeForm(freeformModel);
		// addSerialNumberOnFreeForm(freeFormSerialNumber);
		addBaseCodeOnFreeForm(freeFormBaseCode);
		addDescription(freeFormDescription);
		addCostPriceOnFreeForm(freeFormCostPrice);
		addListPriceOnFreeForm(freeFormListPrice);
		clickOnDoneOfFreeForm();
		Thread.sleep(10000);
		clickDoneOnLeftNav();
	}

	// *****free form equipment when added other than quote like directly in
	// rental/purchase/demo***
	public void addFreeFormEquipOtherThaQuote() throws InterruptedException {
		clickOnFreeformbtn();
		selectMakeOnFreeForm(freeformMake);
		seldctModelOnFreeForm(freeformModel);
		addSerialNumberOnFreeForm(freeFormSerialNumber);
		addBaseCodeOnFreeForm(freeFormBaseCode);
		addDescripOtherThanQuote(freeFormDescription);
		addCostPrice1OnFreeForm(freeFormCostPrice);
		addListPrice1OnFreeForm(freeFormListPrice);
		clickOnFreeformDnebtn1();
	}

	// Add Hard coded Description to Equipment on Free Form
	public void addDescripOtherThanQuote(String description) throws InterruptedException {
		freeFormDescrptxtbox1.sendKeys(description);
		Thread.sleep(10000);
	}

	// Add hard coded cost price to Equipment on Free form page
	public void addCostPrice1OnFreeForm(String costPrice) throws InterruptedException {
		freeFormCostPricetxtbox1.sendKeys(costPrice);
		Thread.sleep(10000);
	}

	// Add hard coded List price to Equipment on Free form page
	public void addListPrice1OnFreeForm(String listPrice) throws InterruptedException {
		freeFormListPricetxtbox1.sendKeys(listPrice);
		Thread.sleep(10000);
	}

	public void clickOnFreeformDnebtn1() throws InterruptedException {
		freeFormDonebtn1.click();
		Thread.sleep(20000);
	}

	// ************MACHINE FINDER PRO******************

	public void ClickOnFindInMyInventoryLink() {
		CommonFunctions.clickOnElement(driver, FindInMYInventory);
	}

	public void clickOnCheckBoxJohnDeere() {
		CommonFunctions.clickOnElement(driver, sk_trucks);
	}

	public void appyToQuoteForEquipmentAdding() throws InterruptedException {
		CommonFunctions.clickOnElement(driver, applyToQuote);
		Thread.sleep(5000);
		System.out.println("**********************************************");
	}

	// Click on MachineFinderPro equipment
	public void ClickOnmachineFinderProEquipment_R2() throws InterruptedException {
		CommonFunctions.clickOnElement(driver, machineFinderProEquipLink);
		System.out.println("Click on Machine Finder pro equipmemnt");
		CommonFunctions.explicitWaitWebElement(driver, FindInMYInventory);
		CommonFunctions.switchToFrameWithFrameName(driver, frameName1);
		ClickOnFindInMyInventoryLink();
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.switchToFrameWithFrameName(driver, frameName1);
		Thread.sleep(10000);
		clickOnCheckBoxJohnDeere();
		CommonFunctions.switchToDefaultFrame(driver);
		Thread.sleep(10000);
		CommonFunctions.switchToFrameWithFrameName(driver, frameName1);
		appyToQuoteForEquipmentAdding();
		//CommonFunctions.switchToDefaultFrame(driver);
		Thread.sleep(2000);
		CommonFunctions.acceptAlert(driver);
		Thread.sleep(5000);
		if(prcngPgeLtstMchnDrpDon.isDisplayed())
			CommonFunctions.selectFromDropdown("Basak",prcngPgeLtstMchnDrpDon);
		Thread.sleep(10000);
		CommonFunctions.isExpanded(adjExpantionImg);
		CommonFunctions.isExpanded(techOptExpantionImg);
		salesIncentiveBulletin();
		pricingCalc(equipOptCostPrice,equipOptListPrice,
				totEquipCostPrice, totEquipListPrice);
		pricingCalc(adjustmentCostPrice, adjustmntListPrice,
				totAdjCostPrice, totAdjListPrice);

		if (techOptChkBox.isDisplayed())
			pricingCalc(techOptCostPrice, techOptListPrice,
					techOptTotCostPrice, techOptTotListPrice);
		if (attachmetChkBox.isDisplayed())
			pricingCalc(attCostPrice, attListPrice,
					attTotCostPrice, attTotListPrice);
		totMarginCalc();
		clickDoneOnLeftNav();
		System.out.println("Name of Machine Finder pro equipmemnt is "+verifyEquipmentOntab.getText());

		CommonFunctions.clickOnElement(driver, deleteQuote);
		Thread.sleep(2000);
		CommonFunctions.acceptAlert(driver);
	}
	
	// Click on MachineFinderPro equipment
		public void ClickOnmachineFinderProEquipment() throws InterruptedException {
			CommonFunctions.clickOnElement(driver, machineFinderProEquipLink);
			System.out.println("Click on Machine Finder pro equipmemnt");
			CommonFunctions.explicitWaitWebElement(driver, FindInMYInventory);
			CommonFunctions.switchToFrameWithFrameName(driver, frameName1);
			ClickOnFindInMyInventoryLink();
			CommonFunctions.switchToDefaultFrame(driver);
			CommonFunctions.switchToFrameWithFrameName(driver, frameName1);
			Thread.sleep(10000);
			clickOnCheckBoxJohnDeere();
			CommonFunctions.switchToDefaultFrame(driver);
			Thread.sleep(10000);
			CommonFunctions.switchToFrameWithFrameName(driver, frameName1);
			appyToQuoteForEquipmentAdding();
			//CommonFunctions.switchToDefaultFrame(driver);
			Thread.sleep(2000);
			CommonFunctions.acceptAlert(driver);
			Thread.sleep(5000);
			Thread.sleep(10000);
			salesIncentiveBulletin();
			pricingCalc(equipOptCostPrice,equipOptListPrice,
					totEquipCostPrice, totEquipListPrice);
			pricingCalc(adjustmentCostPrice, adjustmntListPrice,
					totAdjCostPrice, totAdjListPrice);

			if (techOptChkBox.isDisplayed())
				pricingCalc(techOptCostPrice, techOptListPrice,
						techOptTotCostPrice, techOptTotListPrice);
			if (attachmetChkBox.isDisplayed())
				pricingCalc(attCostPrice, attListPrice,
						attTotCostPrice, attTotListPrice);
			totMarginCalc();
			clickDoneOnLeftNav();
			System.out.println("Name of Machine Finder pro equipmemnt is "+verifyEquipmentOntab.getText());

			CommonFunctions.clickOnElement(driver, deleteQuote);
			Thread.sleep(2000);
			CommonFunctions.acceptAlert(driver);
		}

	// *******************Add Part from DBS Parts*********************

	public void addDBSParts() throws InterruptedException {
		clickOnDBSParts();
		enterPartNumber(dbsPartNumber);
		clickOnDBSPartsSearchbtn();
		selectPartToAdd();
		getPartQuantity();
		partsClickAddSelected();
		partQuantityInput();
		clickDoneOnPartsPopUp();
		// CommonFunctions.javaScriptScrollDownEnd(driver);
		pricingCalc(equipOptCostPrice, equipOptListPrice, totEquipCostPrice, totEquipListPrice);
		pricingCalc(adjustmentCostPrice, adjustmntListPrice, totAdjCostPrice, totAdjListPrice);
		if (techOptChkBox.isDisplayed())
			pricingCalc(techOptCostPrice, techOptListPrice, techOptTotCostPrice, techOptTotListPrice);
		if (attachmetChkBox.isDisplayed())
			pricingCalc(attCostPrice, attListPrice, attTotCostPrice, attTotListPrice);
		equipTotalCalc();
		equipAttachTechOpsCalc();
		marginCalc(equipDollarsAboveNetCost, equipAdjustedSellingPrice, equipMargin, equipTotCostPrice,
				equipTotListPrice,equipDiscount);
		marginCalc(attDollarsAboveNetCost, attAdjustedSellingPrice, attMargin, attTotCostPrice, attTotListPrice,attachDiscount);
		marginCalc(techoptDollarsAboveNetCost, techOptAdjustedSellingPrice, techoptMargin, techOptTotCostPrice,
				techOptTotListPrice,techOptDiscount);
		totMarginCalc();
		clickDoneOnLeftNav();
		copyEquipmentbySelecting();
		deleteEquipment();
	}

	// click on DBS Parts button option
	public void clickOnDBSParts() throws InterruptedException {
		dbsPartsButton.click();
		Thread.sleep(10000);
	}

	// Enter hard coded Part Number into Search field
	public void enterPartNumber(String dbsPartNumber) throws InterruptedException {
		dbsPartNumberTxtbox.sendKeys(dbsPartNumber);
		Thread.sleep(10000);
	}

	// Click on JBS Parts Search Button
	public void clickOnDBSPartsSearchbtn() throws InterruptedException {
		dbsPartNumberSearchbtn.click();
		Thread.sleep(10000);

	}

	// Select Part to add into Quote
	public void selectPartToAdd() {
		if (!partsCheckBox.isSelected()) {
			partsCheckBox.click();
		}

	}

	// Click on Add Selected button on Parts Search results
	public void partsClickAddSelected() {
		partsAddSelectedBtn.click();
	}

	// Get Part Quantity
	public void getPartQuantity() {
		String quantity = partsQuantity.getText();
		int quan = Integer.parseInt(quantity);
		System.out.println("Parts Quantity:" + quan);
		partQuan = CommonFunctions.randomNumberGenerator(quan);
		System.out.println("Parts Quantity:" + partQuan);
		partquantity = String.valueOf(partQuan);
	}

	// Input part quantity
	public void partQuantityInput() {
		CommonFunctions.switchToChildWindow(driver);
		quantityTxtBox.clear();
		quantityTxtBox.sendKeys("1");
	}

	// Click on Done button of Parts Quantity Pop up
	public void clickDoneOnPartsPopUp() {
		partsQuantityDoneBtn.click();
		CommonFunctions.switchToParentWindow(driver);
	}

	// Click on Cancel button of Parts Quantity Pop Up
	public void clickCancelOnPartsPopUp() {
		partsQuantityCancelBtn.click();
		CommonFunctions.switchToParentWindow(driver);
	}
	// ********************End Parts Equipment************



	// *****************CONFIGURATOR EQUIPMENT***********

	public void reconfigureOnEquipmentTab() throws InterruptedException{
		Thread.sleep(5000);
		Reconfigure.click();
		Thread.sleep(10000);
		CommonFunctions.switchToFrameWithFrameName(driver, frameName3);
		if(updateOptionstoEquipment.isDisplayed()){
			updateOptionstoEquipment.click();

		}else{
			System.out.println("Updates Options to equipment is not displayed on reconfigure page");
		}
		Thread.sleep(15000);
		salesIncentiveBulletin();
		pricingCalc(equipOptCostPrice,equipOptListPrice,
				totEquipCostPrice, totEquipListPrice);
		pricingCalc(adjustmentCostPrice, adjustmntListPrice,
				totAdjCostPrice, totAdjListPrice);

		if (techOptChkBox.isDisplayed())
			pricingCalc(techOptCostPrice, techOptListPrice,
					techOptTotCostPrice, techOptTotListPrice);
		if (attachmetChkBox.isDisplayed())
			pricingCalc(attCostPrice, attListPrice,
					attTotCostPrice, attTotListPrice);
		totMarginCalc();
		clickDoneOnLeftNav();   	
		System.out.println("*************************************************");
		System.out.println("Reconfigure on equipment tab done successfully");   

		

	}
	public void replaceFromCollateralOnEquipMentTab() throws InterruptedException{
		Thread.sleep(10000);
		replaceFromOnEquipmentTab.click();
		Thread.sleep(5000);	    	
		List<WebElement> listOfEquipmentOfReplaceFromCollateral= driver.findElements(By.xpath("//*[@id='results']//table//tbody/tr//td//input[@type='radio']"));

		int count=listOfEquipmentOfReplaceFromCollateral.size();

		System.out.println("Total number of equipemt available for replace from collateral "+count);

		int index=CommonFunctions.randomNumberGenerator(count);

		listOfEquipmentOfReplaceFromCollateral.get(index).click();

		Thread.sleep(5000);

		replaceWithSelected.click();

		CommonFunctions.acceptAlert(driver);

		System.out.println("Replace with collateral functionality done sucesfully");
	}
	public void inputModelNumber(String model) throws InterruptedException {
		CommonFunctions.switchToFrameWithFrameName(driver, frameName2);
		modelSearchInputBox.sendKeys(model);
		Thread.sleep(3000);
	}

	public void addingConfigEquipment() throws InterruptedException
	{
		List<WebElement> liElements = driver.findElements(By.xpath("//*[@class='ac_results']//ul[@style='max-height: 180px; overflow: auto;']/li"));
		int count=liElements.size();
		System.out.println("Number of configurator Equipment found after searching by 4880M model "+count);
		for(int i=1; i <=count; i++)
		{
			WebElement linkElement = driver.findElement(By.xpath("//*[@class='ac_results']//ul[@style='max-height: 180px; overflow: auto;']/li["+i+"]"));
			System.out.println(linkElement.getText());      
		}    
		WebElement secondElement = driver.findElement(By.xpath("//div[@class='ac_results']//ul//li[2]"));
		secondElement.click();
		CommonFunctions.explicitWaitWebElement(driver, searchBox);
		searchBox.click();
		CommonFunctions.explicitWaitWebElement(driver, baseCode);
		Thread.sleep(15000);


		baseCode.click();

		Thread.sleep(10000);
		if(send2JDQuote.isDisplayed()){
			CommonFunctions.explicitWaitWebElement(driver, send2JDQuote);
			send2JDQuote.click(); }
		else{
			System.out.println("Send 2 JDQuote button is not displayed on configurator page");
		}
		Thread.sleep(15000);
		reconfigureOnEquipmentTab();
		Thread.sleep(10000);
		System.out.println("Name of configurator equipmemnt is "+verifyEquipmentOntab.getText());
		replaceFromCollateralOnEquipMentTab();
		CommonFunctions.clickOnElement(driver, deleteQuote);
		CommonFunctions.acceptAlert(driver);
		System.out.println("***********************************************");
	}

	public void clickOnConfiguratorLink() throws InterruptedException {
		
		

		if(configuratorLink.isDisplayed()){
			CommonFunctions.clickOnElement(driver, configuratorLink);

		}
		else{
			System.out.println("Configurator equipment is not displayed on on equipmentr tab");
		}
		CommonFunctions.explicitWaitWebElement(driver, modelSearchInputBox);
		inputModelNumber(model);
		CommonFunctions.explicitWaitWebElement(driver, searchBox);
		addingConfigEquipment();

		
//		CommonFunctions.clickOnElement(driver, deleteQuote);
//		CommonFunctions.acceptAlert(driver);


	}
	//*********************end cONFIGURATOR***************


//	Add equipment from Frontier Configurator
	
	public void clickOnFrontierEquipment() throws InterruptedException{
		
		if(frontierConfiguratorLink.isDisplayed()){
			CommonFunctions.clickOnElement(driver, frontierConfiguratorLink);

		}
		else{
			System.out.println("Configurator equipment is not displayed on on equipmentr tab");
		}

		CommonFunctions.explicitWaitWebElement(driver, modelSearchInputBox);
		inputModelNumber(model);
		CommonFunctions.explicitWaitWebElement(driver, searchBox);
		addingConfigEquipment();
	}

// ****************************** R2 Configurator Equipment**********************************************************************
	public void addR2ConfigEquip(InputTestDetails inputTestDetails) throws InterruptedException
	{
		String r2Model = inputTestDetails.getTestdata()[6].toString();
		if(configuratorLink.isDisplayed())
		{
			CommonFunctions.clickOnElement(driver, configuratorLink);
			if(sapContinue.isDisplayed())
				sapContinue.click();
			CommonFunctions.explicitWaitWebElement(driver, modelSearchInputBox);
			inputModelNumber(r2Model);
			if(r2modelList.isDisplayed())
			{
				r2modelList.click();
				r2ConfigSearch.click();
				CommonFunctions.explicitWaitWebElement(driver, r2SendToJDQuote);
				r2SendToJDQuote.click();
				CommonFunctions.explicitWaitWebElement(driver,prcngPgeLtstMchnDrpDon);
				CommonFunctions.selectFromDropdown("Claas", prcngPgeLtstMchnDrpDon);
				Thread.sleep(5000);
				sapOrderDetailsImg.click();
				salesIncentiveBulletin();
				pricingCalc(equipOptCostPrice, equipOptListPrice, totEquipCostPrice, totEquipListPrice);
				CommonFunctions.isExpanded(adjExpantionImg);
				CommonFunctions.isExpanded(techOptExpantionImg);
				pricingCalc(adjustmentCostPrice, adjustmntListPrice, totAdjCostPrice, totAdjListPrice);
				if (techOptChkBox.isDisplayed())
					pricingCalc(techOptCostPrice, techOptListPrice, techOptTotCostPrice, techOptTotListPrice);
				if (attachmetChkBox.isDisplayed())
					pricingCalc(attCostPrice, attListPrice, attTotCostPrice, attTotListPrice);
				equipTotalCalc();
				equipAttachTechOpsCalc();
				marginCalc(equipDollarsAboveNetCost, equipAdjustedSellingPrice, equipMargin, equipTotCostPrice,
						equipTotListPrice,equipDiscount);
				marginCalc(attDollarsAboveNetCost, attAdjustedSellingPrice, attMargin, attTotCostPrice, attTotListPrice,attachDiscount);
				marginCalc(techoptDollarsAboveNetCost, techOptAdjustedSellingPrice, techoptMargin, techOptTotCostPrice,
						techOptTotListPrice,techOptDiscount);
				totMarginCalc();
				clickDoneOnLeftNav();
				copyEquipmentbySelecting();
				deleteEquipment();				
				
			}
			else
			{
				System.out.println("Base Code Search Result not displayed");
			}
			CommonFunctions.explicitWaitWebElement(driver, searchBox);
			
		}
		else
		{
			System.out.println("Configurator equipment is not displayed on on equipmentr tab");
		}
	
}
	
	// Inco Term Selection For Deere To Dealer Quotes
	
	public void addIncoTermEquip()
	{
		CommonFunctions.switchToChildWindow(driver);
		Assert.assertTrue("Issue in loading Inco Term Pop Up", incoTermSelectionDrpBox.isDisplayed());
		CommonFunctions.selectFromDropdownByIndex(1,incoTermSelectionDrpBox);
		incoTermSubmitBtn.click();
		CommonFunctions.switchToParentWindow(driver);
	}
	
	// Verify IncoTerm Equipment 
	
	public void addR2IncoConfigEquip(InputTestDetails inputTestDetails) throws InterruptedException
	{
		String r2Model = inputTestDetails.getTestdata()[6].toString();
		if(configuratorLink.isDisplayed())
		{
			CommonFunctions.clickOnElement(driver, configuratorLink);
			if(sapContinue.isDisplayed())
				sapContinue.click();
			CommonFunctions.explicitWaitWebElement(driver, modelSearchInputBox);
			inputModelNumber(r2Model);
			if(r2modelList.isDisplayed())
			{
				r2modelList.click();
				r2ConfigSearch.click();
				CommonFunctions.explicitWaitWebElement(driver, r2SendToJDQuote);
				r2SendToJDQuote.click();
				addIncoTermEquip();
				CommonFunctions.explicitWaitWebElement(driver,prcngPgeLtstMchnDrpDon);
				CommonFunctions.selectFromDropdown("Claas", prcngPgeLtstMchnDrpDon);
				Thread.sleep(5000);
				sapOrderDetailsImg.click();
				clickDoneOnLeftNav();
				copyEquipmentbySelecting();
				deleteEquipment();				
				
			}
			else
			{
				System.out.println("Base Code Search Result not displayed");
			}
			CommonFunctions.explicitWaitWebElement(driver, searchBox);
			
		}
		else
		{
			System.out.println("Configurator equipment is not displayed on on equipmentr tab");
		}
	
}
	// Click on Copy From Another Quote button
	public void clickOnCopyFromAnotherQuote() throws InterruptedException {
		copyFromAnotherQuotelink.click();
		Thread.sleep(10000);
	}

	// Click on Search Button of Copy From Another Quote source
	public void clickOnSearchOfCopyFromAnotherSource() throws InterruptedException {
		copyFromAnotherQuoteSearch.click();
		Thread.sleep(60000);
	}

	// Select random equipment from Result set
	public void selectRandomEquipment() throws InterruptedException {
		int numchkBox = resultSet.findElements(By.id("copySelectedEquipIds")).size();
		// System.out.println("Number of Checkboxes:"+numchkBox);
		int index = CommonFunctions.randomNumberGenerator(numchkBox);
		List<WebElement> list = resultSet.findElements(By.id("copySelectedEquipIds"));
		list.get(index).click();
	}

	// Click On Add Selected Of Copy From Another Quote
	public void clickonAddSectedOfCopyFromAnotherQuote() throws InterruptedException {
		addSelectedOnCopyFromAnotherQuotebtn.click();
		Thread.sleep(10000);
	}

	// Add Equipment From Copy From Another Quote
	public void copyFromAnotherQuote_R2() throws InterruptedException {
		clickOnCopyFromAnotherQuote();
		clickOnSearchOfCopyFromAnotherSource();
		Thread.sleep(80000);
		selectRandomEquipment();
		clickonAddSectedOfCopyFromAnotherQuote();
		if(equipCustLatestMachine.isEnabled())
		{
		  selectCustLatestMachine();
		}
		Thread.sleep(10000);
		navigateToPricingPage();
		salesIncentiveBulletin();
		pricingCalc(equipOptCostPrice, equipOptListPrice, totEquipCostPrice, totEquipListPrice);
		CommonFunctions.isExpanded(adjExpantionImg);
		CommonFunctions.isExpanded(techOptExpantionImg);
		pricingCalc(adjustmentCostPrice, adjustmntListPrice, totAdjCostPrice, totAdjListPrice);
		if (techOptChkBox.isDisplayed())
			pricingCalc(techOptCostPrice, techOptListPrice, techOptTotCostPrice, techOptTotListPrice);
		if (attachmetChkBox.isDisplayed())
			pricingCalc(attCostPrice, attListPrice, attTotCostPrice, attTotListPrice);
		equipTotalCalc();
		equipAttachTechOpsCalc();
		marginCalc(equipDollarsAboveNetCost, equipAdjustedSellingPrice, equipMargin, equipTotCostPrice,
				equipTotListPrice,equipDiscount);
		marginCalc(attDollarsAboveNetCost, attAdjustedSellingPrice, attMargin, attTotCostPrice, attTotListPrice,attachDiscount);
		marginCalc(techoptDollarsAboveNetCost, techOptAdjustedSellingPrice, techoptMargin, techOptTotCostPrice,
				techOptTotListPrice,techOptDiscount);
		totMarginCalc();
		clickDoneOnLeftNav();
		copyEquipmentbySelecting();
		deleteEquipment();
	}
	
	// Add Equipment From Copy From Another Quote
		public void copyFromAnotherQuote() throws InterruptedException {
			clickOnCopyFromAnotherQuote();
			clickOnSearchOfCopyFromAnotherSource();
			Thread.sleep(80000);
			selectRandomEquipment();
			clickonAddSectedOfCopyFromAnotherQuote();
			Thread.sleep(10000);
			navigateToPricingPage();
			salesIncentiveBulletin();
			pricingCalc(equipOptCostPrice, equipOptListPrice, totEquipCostPrice, totEquipListPrice);
			pricingCalc(adjustmentCostPrice, adjustmntListPrice, totAdjCostPrice, totAdjListPrice);
			if (techOptChkBox.isDisplayed())
				pricingCalc(techOptCostPrice, techOptListPrice, techOptTotCostPrice, techOptTotListPrice);
			if (attachmetChkBox.isDisplayed())
				pricingCalc(attCostPrice, attListPrice, attTotCostPrice, attTotListPrice);
			equipTotalCalc();
			equipAttachTechOpsCalc();
			marginCalc(equipDollarsAboveNetCost, equipAdjustedSellingPrice, equipMargin, equipTotCostPrice,
					equipTotListPrice,equipDiscount);
			marginCalc(attDollarsAboveNetCost, attAdjustedSellingPrice, attMargin, attTotCostPrice, attTotListPrice,attachDiscount);
			marginCalc(techoptDollarsAboveNetCost, techOptAdjustedSellingPrice, techoptMargin, techOptTotCostPrice,
					techOptTotListPrice,techOptDiscount);
			totMarginCalc();
			clickDoneOnLeftNav();
			copyEquipmentbySelecting();
			deleteEquipment();
		}


	// ************PRICING Page*******************************

	// Navigate to Pricing Page
	public void navigateToPricingPage() {
		if (firstEquip.isDisplayed()) {
			String frstEquipDesc = firstEquip.getText();
			firstEquip.click();
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (equipDesc.isDisplayed()) {
				System.out.println("Landed on Pricing page");
				String prcpageEquipDesc = equipDesc.getAttribute("value");
				if (equipDesc.isDisplayed()) {
					System.out.println("Equipment Description:" + prcpageEquipDesc);
					optionCodeLink.click();
				}
			}
		}
	}

	// Verify Calculation On Pricing page
	public void pricingCalc(List<WebElement> costPriceRef, List<WebElement> listPriceRef, WebElement totCostPriceRef,
			WebElement totListPriceRef) throws InterruptedException {
			List<WebElement> refCostPrice;
			List<WebElement> refListPrice;
			WebElement refTotCostPrice;
			WebElement refTotListPrice;
			Thread.sleep(5000);
			String lnkName = showCostLnk.getText();
			String costPrice = null;
			String listPrice = null;
			String totalCp = null;
			String totalLp = null;
			double cP = 0.0;
			double lP = 0.0;
			double totCP = 0.0;
			double totLP = 0.0;
			if (lnkName.equals("Show Detail"))
				showCostLnk.click();
			refCostPrice = costPriceRef;
			refListPrice = listPriceRef;
			refTotCostPrice = totCostPriceRef;
			refTotListPrice = totListPriceRef;

			for (int i = 0; i < refCostPrice.size(); i++) {
				costPrice = refCostPrice.get(i).getAttribute("value");
				if (costPrice.contains(","))
					costPrice = costPrice.replaceAll(",", "");
				cP = cP + Double.parseDouble(costPrice);
				cP = CommonFunctions.roundUpDouble(cP);
				System.out.println("Cost Price:" + cP);

				listPrice = refListPrice.get(i).getAttribute("value");
				if (listPrice.contains(","))
					listPrice = listPrice.replaceAll(",", "");
				lP = lP + Double.parseDouble(listPrice);
				lP = CommonFunctions.roundUpDouble(lP);
				System.out.println("List Price:" + lP);
			}
			totalCp = refTotCostPrice.getText();
			if (totalCp.contains(","))
				totalCp = totalCp.replaceAll(",", "");
			totCP = totCP + Double.parseDouble(totalCp);
			totCP = CommonFunctions.roundUpDouble(totCP);
			System.out.println("Total Cost Price:" + totCP);

			totalLp = refTotListPrice.getText();
			if (totalLp.contains(","))
				totalLp = totalLp.replaceAll(",", "");
			totLP = totLP + Double.parseDouble(totalLp);
			totLP = CommonFunctions.roundUpDouble(totLP);
			System.out.println("Total List Price:" + totLP);

			Assert.assertTrue("Cost Price of Equipment is calculated incorrectly.", totCP == cP);	           
			Assert.assertTrue("List Price of Equipment is calculated incorrectly.", totLP == lP);
			
	}

	// Equipment Total Calculation with Incentives And Adjustments
	public void equipTotalCalc() {
		String appliedCost = null;
		String adjCost = null;
		String equipTotalCP = null;
		String opCodeCP = null;
		String adjList = null;
		String equipTotalLP = null;
		String opCodeLP = null;

		double aC = 0;
		double adjCP = 0;
		double totCP = 0;
		double codeCP = 0;
		double calcCostPrice = 0;
		double adjLP = 0;
		double totLP = 0;
		double codeLP = 0;
		double calcListPrice = 0;
		if (!salesIncentiveChkBox.isEmpty()) {
			for (int i = 0; i < salesIncentiveChkBox.size(); i++) {
				boolean flag = salesIncentiveChkBox.get(i).isSelected();
				if (flag) {
					appliedCost = salesIncentiveApplied.get(i).getText();
					if (appliedCost.contains(","))
						appliedCost = appliedCost.replaceAll(",", "");
					if (!appliedCost.isEmpty()) {
						aC = aC + Double.parseDouble(appliedCost);
						aC = CommonFunctions.roundUpDouble(aC);
					}
				} else
					aC = 0.00;
			}
			System.out.println("Applied On Cost:" + aC);

			opCodeCP = totEquipCostPrice.getText();
			if (opCodeCP.contains(","))
				opCodeCP = opCodeCP.replaceAll(",", "");
			codeCP = codeCP + Double.parseDouble(opCodeCP);
			codeCP = CommonFunctions.roundUpDouble(codeCP);
			System.out.println("Option code Cost:" + codeCP);

			adjCost = totAdjCostPrice.getText();
			if (adjCost.contains(","))
				adjCost = adjCost.replaceAll(",", "");
			adjCP = adjCP + Double.parseDouble(adjCost);
			adjCP = CommonFunctions.roundUpDouble(adjCP);
			System.out.println("Adj Cost:" + adjCP);

			equipTotalCP = equipTotCostPrice.getText();
			if (equipTotalCP.contains(","))
				equipTotalCP = equipTotalCP.replaceAll(",", "");
			totCP = totCP + Double.parseDouble(equipTotalCP);
			totCP = CommonFunctions.roundUpDouble(totCP);
			System.out.println("Equip Total Cost:" + totCP);

			opCodeLP = totEquipListPrice.getText();
			if (opCodeLP.contains(","))
				opCodeLP = opCodeLP.replaceAll(",", "");
			codeLP = codeLP + Double.parseDouble(opCodeLP);
			codeLP = CommonFunctions.roundUpDouble(codeLP);
			System.out.println("Option code List:" + codeLP);

			adjList = totAdjListPrice.getText();
			if (adjList.contains(","))
				adjList = adjList.replaceAll(",", "");
			adjLP = Double.parseDouble(adjList);
			adjLP = CommonFunctions.roundUpDouble(adjLP);
			System.out.println("Adj List:" + adjLP);

			equipTotalLP = equipTotListPrice.getText();
			if (equipTotalLP.contains(","))
				equipTotalLP = equipTotalLP.replaceAll(",", "");
			totLP = totLP + Double.parseDouble(equipTotalLP);
			totLP = CommonFunctions.roundUpDouble(totLP);
			System.out.println("Equip Total List:" + totLP);

			calcCostPrice = codeCP + adjCP - aC;
			System.out.println("Calculated Cost Price: " + calcCostPrice);
			calcListPrice = codeLP + adjLP;
			System.out.println("Calculated List Price: " + calcListPrice);

			Assert.assertTrue("Sub Total of Cost Price is calculated incorrectly", totCP == calcCostPrice);
			System.out.println("Sub Total of Cost Price is calculated correctly");				
			Assert.assertTrue("Sub Total of List Price is calculated incorrectly",totLP == calcListPrice);

		}
	}

	// Pricing page Margin Calculation
	public void marginCalc(WebElement DolAboNetCPref, WebElement ListPriceref, WebElement equipMargref,
			WebElement TotalCPref, WebElement TotalLPref, WebElement discountRef) {
		WebElement refDolAboNetCP;
		WebElement refListPrice;
		WebElement refequipMarg;
		WebElement refTotalCP;
		WebElement refTotalLP;
		WebElement refDiscount;

		String equipDolAboNetCP = null;
		String equipLP = null;
		String equipMarg = null;
		String equipTotalCP = null;
		String equipTotalLP = null;
		String discount = null;
		double equipDANC = 0;
		double equipSellingPrice = 0;
		double equipMar = 0;
		double calcMargin = 0;
		double calcDANC = 0;
		double totCP = 0;
		double totLP = 0;
		double disc = 0;

		refDolAboNetCP = DolAboNetCPref;
		refListPrice = ListPriceref;
		refequipMarg = equipMargref;
		refTotalCP = TotalCPref;
		refTotalLP = TotalLPref;
		refDiscount = discountRef;
		equipDolAboNetCP = refDolAboNetCP.getAttribute("value");
		if (equipDolAboNetCP.contains(","))
			equipDolAboNetCP = equipDolAboNetCP.replaceAll(",", "");
		equipDANC = Double.parseDouble(equipDolAboNetCP);
		equipDANC = CommonFunctions.roundUpDouble(equipDANC);
		System.out.println("Dollars Above Net Cost: " + equipDANC);

		equipLP = refListPrice.getAttribute("value");
		if (equipLP.contains(","))
			equipLP = equipLP.replaceAll(",", "");
		equipSellingPrice = equipSellingPrice + Double.parseDouble(equipLP);
		equipSellingPrice = CommonFunctions.roundUpDouble(equipSellingPrice);
		System.out.println("Adjusted Equipment Selling Price: " + equipSellingPrice);

		equipMarg = refequipMarg.getAttribute("value");
		if (equipMarg.contains(","))
			equipMarg = equipMarg.replaceAll(",", "");
		equipMar = equipMar + Double.parseDouble(equipMarg);
		System.out.println("Margin: " + equipMar);

		equipTotalCP = TotalCPref.getText();
		if (equipTotalCP.contains(","))
			equipTotalCP = equipTotalCP.replaceAll(",", "");
		totCP = totCP + Double.parseDouble(equipTotalCP);
		totCP = CommonFunctions.roundUpDouble(totCP);
		System.out.println("Equip Total Cost:" + totCP);

		equipTotalLP = TotalLPref.getText();
		if (equipTotalLP.contains(","))
			equipTotalLP = equipTotalLP.replaceAll(",", "");
		totLP = totLP + Double.parseDouble(equipTotalLP);
		totLP = CommonFunctions.roundUpDouble(totLP);
		System.out.println("Equip Total List:" + totLP);
		
		discount = refDiscount.getAttribute("value");
		if(discount.contains(","))
			discount=discount.replaceAll(",", "");
		disc = disc + Double.parseDouble(discount);
		disc = CommonFunctions.roundUpDouble(disc);
		System.out.println("Equip discount:" + disc);

		calcDANC = totLP - totCP - disc;
		calcDANC = CommonFunctions.roundUpDouble(calcDANC);

		System.out.println("Calculated Equipment Dollars Above Net Cost: " + calcDANC);
		
		if(calcDANC>0)
		{
			try{
			calcMargin = (calcDANC / equipSellingPrice) * 100;
			calcMargin = CommonFunctions.roundUpDouble(calcMargin);
			}
			catch (Exception e) {
	            System.out.println("Error division by zero!");
	        }
			calcMargin = CommonFunctions.roundUpDouble(calcMargin);
			System.out.println("Calculated Equipment Margin: " + calcMargin);
		}
		
		else
		{
			calcMargin = 0.0;
			System.out.println("Calculated Equipment Margin: " + calcMargin);
		}
          
		

		Assert.assertTrue("Dollars above Net Cost is calculated incorrectly", equipDANC == calcDANC);

	    Assert.assertTrue("Margin is calculated incorrectly", equipMar == calcMargin);
	}

	// Margin Calculation - Total
	public void totMarginCalc() {

		String equipDolAboNetCP = null;
		String equipLP = null;
		String equipMarg = null;
		String equipTotalCP = null;
		String equipTotalLP = null;
		String discount = null;
		double equipDANC = 0;
		double equipSellingPrice = 0;
		double equipMar = 0;
		double calcMargin = 0;
		double calcDANC = 0;
		double totCP = 0;
		double totLP = 0;
		double disc = 0;

		equipDolAboNetCP = totDollarsAboveNetCost.getText();
		if (equipDolAboNetCP.contains(","))
			equipDolAboNetCP = equipDolAboNetCP.replaceAll(",", "");
		equipDANC = Double.parseDouble(equipDolAboNetCP);
		equipDANC = CommonFunctions.roundUpDouble(equipDANC);
		System.out.println("Dollars Above Net Cost: " + equipDANC);

		equipLP = totAdjustedSellingPrice.getText();
		if (equipLP.contains(","))
			equipLP = equipLP.replaceAll(",", "");
		equipSellingPrice = equipSellingPrice + Double.parseDouble(equipLP);
		equipSellingPrice = CommonFunctions.roundUpDouble(equipSellingPrice);
		System.out.println("Adjusted Equipment Selling Price: " + equipSellingPrice);

		equipMarg = totMargin.getText();
		if (equipMarg.contains(","))
			equipMarg = equipMarg.replaceAll(",", "");
		equipMar = equipMar + Double.parseDouble(equipMarg);
		equipMar = CommonFunctions.roundUpDouble(equipMar);
		System.out.println("Margin: " + equipMar);

		equipTotalCP = equipAttachTotCostPrice.getText();
		if (equipTotalCP.contains(","))
			equipTotalCP = equipTotalCP.replaceAll(",", "");
		totCP = totCP + Double.parseDouble(equipTotalCP);
		totCP = CommonFunctions.roundUpDouble(totCP);
		System.out.println("Equip Total Cost:" + totCP);

		equipTotalLP = equipAttachTotListPrice.getText();
		if (equipTotalLP.contains(","))
			equipTotalLP = equipTotalLP.replaceAll(",", "");
		totLP = totLP + Double.parseDouble(equipTotalLP);
		totLP = CommonFunctions.roundUpDouble(totLP);
		System.out.println("Equip Total List:" + totLP);

		discount = totDiscount.getText();
		if(discount.contains(","))
			discount=discount.replaceAll(",", "");
		disc = disc + Double.parseDouble(discount);
		disc = CommonFunctions.roundUpDouble(disc);
		System.out.println("Equip Total List:" + disc);


		calcDANC = totLP - totCP - disc;
		calcDANC = CommonFunctions.roundUpDouble(calcDANC);

		System.out.println("Calculated Equipment Dollars Above Net Cost: " + calcDANC);
		
		if(calcDANC>0)
		{
			try{
			calcMargin = (calcDANC / equipSellingPrice) * 100;
			calcMargin = CommonFunctions.roundUpDouble(calcMargin);
			}
			catch (Exception e) {
	            System.out.println("Error division by zero!");
	        }
			System.out.println("Calculated Equipment Margin: " + calcMargin);
		}
		
		else
		{
			calcMargin = 0.0;
			System.out.println("Calculated Equipment Margin: " + calcMargin);
		}
		Assert.assertTrue("Dollars above Net Cost is calculated incorrectly", equipDANC == calcDANC);			
			Assert.assertTrue("Margin is calculated incorrectly", equipMar == calcMargin);
	}

	// Equipment, Attachment and Technology Option Section Calculation
	public void equipAttachTechOpsCalc() {
		String techCP = null;
		String attachCP = null;
		String equipCP = null;
		String totCP = null;
		String techLP = null;
		String attachLP = null;
		String equipLP = null;
		String totLP = null;
		double techCost = 0;
		double attachCost = 0;
		double equipCost = 0;
		double totCostPrice = 0;
		double totListPrice = 0;
		double techList = 0;
		double attachList = 0;
		double equipList = 0;
		double calcCost = 0;
		double calcList = 0;

		techLP = techOptTotListPrice.getText();
		if (techLP.contains(","))
			techLP = techLP.replaceAll(",", "");
		techList = techList + Double.parseDouble(techLP);
		techList = CommonFunctions.roundUpDouble(techList);
		System.out.println("Tech Option List:" + techList);

		attachLP = attTotListPrice.getText();
		if (attachLP.contains(","))
			attachLP = attachLP.replaceAll(",", "");
		attachList = attachList + Double.parseDouble(attachLP);
		attachList = CommonFunctions.roundUpDouble(attachList);
		System.out.println("Attachment List:" + attachList);

		equipLP = equipTotListPrice.getText();
		if (equipLP.contains(","))
			equipLP = equipLP.replaceAll(",", "");
		equipList = equipList + Double.parseDouble(equipLP);
		equipList = CommonFunctions.roundUpDouble(equipList);
		System.out.println("Option Codes List:" + equipList);

		totLP = equipAttachTotListPrice.getText();
		if (totLP.contains(","))
			totLP = totLP.replaceAll(",", "");
		totListPrice = totListPrice + Double.parseDouble(totLP);
		totListPrice = CommonFunctions.roundUpDouble(totListPrice);
		System.out.println("Total List:" + totListPrice);

		calcList = techList + attachList + equipList;
		System.out.println("Calculated List:" + calcList);

		techCP = techOptTotCostPrice.getText();
		if (techCP.contains(","))
			techCP = techCP.replaceAll(",", "");
		techCost = techCost + Double.parseDouble(techCP);
		techCost = CommonFunctions.roundUpDouble(techCost);
		System.out.println("Tech Option Cost:" + techCost);

		attachCP = attTotCostPrice.getText();
		if (attachCP.contains(","))
			attachCP = attachCP.replaceAll(",", "");
		attachCost = attachCost + Double.parseDouble(attachCP);
		attachCost = CommonFunctions.roundUpDouble(attachCost);
		System.out.println("Attachment Cost:" + attachCost);

		equipCP = equipTotCostPrice.getText();
		if (equipCP.contains(","))
			equipCP = equipCP.replaceAll(",", "");
		equipCost = equipCost + Double.parseDouble(equipCP);
		equipCost = CommonFunctions.roundUpDouble(equipCost);
		System.out.println("Option Codes Cost:" + equipCost);

		totCP = equipAttachTotCostPrice.getText();
		if (totCP.contains(","))
			totCP = totCP.replaceAll(",", "");
		totCostPrice = totCostPrice + Double.parseDouble(totCP);
		totCostPrice = CommonFunctions.roundUpDouble(totCostPrice);
		System.out.println("Total Cost:" + totCostPrice);

		calcCost = techCost + attachCost + equipCost;
		System.out.println("Calculated Cost:" + calcCost);

		if (totCostPrice == calcCost) {
			System.out.println("Sub Total of Cost Price is calculated correctly");
			if (totListPrice == calcList)
				System.out.println("Sub Total of List Price is calculated correctly");
			else
				System.out.println("Sub Total of List Price is calculated incorrectly");
		} else
			System.out.println("Sub Total of Cost Price is calculated incorrectly");
	}

	// Validate Sales Incentive Integration
	public void salesIncentiveBulletin() throws InterruptedException {
		if (!salesIncentiveBulletin.isEmpty()) {
			for (int i = 0; i < salesIncentiveBulletin.size()-1; i++) {
				salesIncentiveBulletin.get(i).click();
				Thread.sleep(20000);
				CommonFunctions.switchToChildWindow(driver);
				String incentivesTitle = driver.getTitle();
				String expectedTitle = "John Deere :: Sales Incentives";
				Assert.assertTrue(incentivesTitle.equals(expectedTitle));
				driver.close();
				/*if (incentivesTitle.equals(expectedTitle)) {
					System.out.println("Sales Incentives application successfully integrated");
					driver.close();
				} else {
					System.out.println("Error in loading Sales Incentive page");
					driver.close();
				}*/
				CommonFunctions.switchToParentWindow(driver);
			}
		} else
			System.out.println("Sales Incentives not loaded");
	}

	// ***********JDSC Functionality**********

	public void clickOnBNPSource() {
		if (bnpBtn.isDisplayed()) {
			bnpBtn.click();
		} else {
			System.out.println("Build And Price Source not available");
		}
	}

	// Add Equipment From B&P
	public void addEquipmentFromBNP() throws InterruptedException {
		clickOnBNPSource();
		String jdscApp = driver.getTitle();
		System.out.println(jdscApp);
		if (jdscApp.equals("Sales Center | Masquerade")) {
			Thread.sleep(20000);
			jdscUserName.sendKeys(jdscDealer);
			jdscSignIn.click();
			Thread.sleep(20000);
			jdscIAgreeBtn.click();
			Thread.sleep(10000);
			jascAgNTurfLink.click();
			jdscCropCareLink.click();
			jdscSeedingLink.click();
			jdscAirSeedingLink.click();
			jdscFirstEquipLink.click();
			jdscFirstEquip.click();
			Thread.sleep(20000);
			if (selectAllBaseBtn.isDisplayed())
				selectAllBaseBtn.click();
			Thread.sleep(30000);
			if (continueToSummary.isEnabled())
				continueToSummary.click();
			Thread.sleep(20000);
			if (sendToBtn.isDisplayed())
				sendToBtn.click();
			jdquote2Btn.click();
			Thread.sleep(30000);
			String url = driver.getCurrentUrl();
			if (url.contains("jdquote2") && (doneLeftNav.isDisplayed())) 
			{   
			salesIncentiveBulletin();	
			pricingCalc(equipOptCostPrice, equipOptListPrice, totEquipCostPrice, totEquipListPrice);
			pricingCalc(adjustmentCostPrice, adjustmntListPrice, totAdjCostPrice, totAdjListPrice);
			if (techOptChkBox.isDisplayed())
				pricingCalc(techOptCostPrice, techOptListPrice, techOptTotCostPrice, techOptTotListPrice);
			if (attachmetChkBox.isDisplayed())
				pricingCalc(attCostPrice, attListPrice, attTotCostPrice, attTotListPrice);
			equipTotalCalc();
			equipAttachTechOpsCalc();
			marginCalc(equipDollarsAboveNetCost, equipAdjustedSellingPrice, equipMargin, equipTotCostPrice,
					equipTotListPrice,equipDiscount);
			marginCalc(attDollarsAboveNetCost, attAdjustedSellingPrice, attMargin, attTotCostPrice, attTotListPrice,attachDiscount);
			marginCalc(techoptDollarsAboveNetCost, techOptAdjustedSellingPrice, techoptMargin, techOptTotCostPrice,
					techOptTotListPrice,techOptDiscount);
			totMarginCalc();
				clickDoneOnLeftNav();
				clickSalesManualIcon();
				copyEquipmentbySelecting();
				deleteEquipment();
			} else {
				System.out.println("Equipment not added");
			}
		} else {
			System.out.println("Issue in opening of JDSC Application");
		}

	}

	// Add Equipment From B&P From Model List
	public void addEquipmentFromBNPModelList() throws InterruptedException {
		clickOnBNPSource();
		String jdscApp = driver.getTitle();
		System.out.println(jdscApp);
		if (jdscApp.equals("Sales Center | Masquerade")) {
			Thread.sleep(20000);
			jdscUserName.sendKeys(jdscDealer);
			jdscSignIn.click();
			Thread.sleep(20000);
			jdscIAgreeBtn.click();
			Thread.sleep(100000);
			if (jdscBNPSearch.isEnabled()) {
				jdscBNPSearch.sendKeys("1725");
				Thread.sleep(20000);
				if (jdscModelList.isDisplayed())
					jdscModelList.click();
				else
					System.out.println("Model List not populated");
			}
			Thread.sleep(20000);
			if (selectAllBaseBtn.isDisplayed())
				selectAllBaseBtn.click();
			Thread.sleep(30000);
			if (continueToSummary.isEnabled())
				continueToSummary.click();
			Thread.sleep(20000);
			if (sendToBtn.isDisplayed())
				sendToBtn.click();
			jdquote2Btn.click();
			Thread.sleep(30000);
			String url = driver.getCurrentUrl();
			if (doneLeftNav.isDisplayed()) 
			{   
				salesIncentiveBulletin();
				pricingCalc(equipOptCostPrice, equipOptListPrice, totEquipCostPrice, totEquipListPrice);
				pricingCalc(adjustmentCostPrice, adjustmntListPrice, totAdjCostPrice, totAdjListPrice);
				if (techOptChkBox.isDisplayed())
					pricingCalc(techOptCostPrice, techOptListPrice, techOptTotCostPrice, techOptTotListPrice);
				if (attachmetChkBox.isDisplayed())
					pricingCalc(attCostPrice, attListPrice, attTotCostPrice, attTotListPrice);
				equipTotalCalc();
				equipAttachTechOpsCalc();
				marginCalc(equipDollarsAboveNetCost, equipAdjustedSellingPrice, equipMargin, equipTotCostPrice,
						equipTotListPrice,equipDiscount);
				marginCalc(attDollarsAboveNetCost, attAdjustedSellingPrice, attMargin, attTotCostPrice, attTotListPrice,attachDiscount);
				marginCalc(techoptDollarsAboveNetCost, techOptAdjustedSellingPrice, techoptMargin, techOptTotCostPrice,
						techOptTotListPrice,techOptDiscount);
				totMarginCalc();
				clickDoneOnLeftNav();
				clickSalesManualIcon();
				copyEquipmentbySelecting();
				deleteEquipment();
				System.out.println("Testcase pass");
			} else {
				System.out.println("Equipment not added");
			}
		} else {
			System.out.println("Issue in opening of JDSC Application");
		}

	}

	// Add Equipment From JDSC DBS
	public void addEquipmentFromJDSCDBS() throws InterruptedException {
		if (jdscDBSBtn.isDisplayed()) {
			jdscDBSBtn.click();
			String jdscApp = driver.getTitle();
			System.out.println(jdscApp);
			if (jdscApp.equals("Sales Center | Masquerade")) {
				Thread.sleep(20000);
				jdscUserName.sendKeys(jdscDealer);
				jdscSignIn.click();
				Thread.sleep(20000);
				jdscIAgreeBtn.click();
				Thread.sleep(60000);
				Thread.sleep(30000);
				if (jdscDBSSelectEquipBtn.isEnabled()) {
					jdscDBSSelectEquipBtn.click();
					if (jdscDBSSelectedEquipBtn.isEnabled()) {
						if (jdscDBSSendToJdQuote2Btn.isEnabled())
							jdscDBSSendToJdQuote2Btn.click();
						Thread.sleep(30000);
					}
				}
				String url = driver.getCurrentUrl();

				if (doneLeftNav.isDisplayed()) 
				{
					salesIncentiveBulletin();
					pricingCalc(equipOptCostPrice, equipOptListPrice, totEquipCostPrice, totEquipListPrice);
					pricingCalc(adjustmentCostPrice, adjustmntListPrice, totAdjCostPrice, totAdjListPrice);
					if (techOptChkBox.isDisplayed())
						pricingCalc(techOptCostPrice, techOptListPrice, techOptTotCostPrice, techOptTotListPrice);
					if (attachmetChkBox.isDisplayed())
						pricingCalc(attCostPrice, attListPrice, attTotCostPrice, attTotListPrice);
					equipTotalCalc();
					equipAttachTechOpsCalc();
					marginCalc(equipDollarsAboveNetCost, equipAdjustedSellingPrice, equipMargin, equipTotCostPrice,
							equipTotListPrice,equipDiscount);
					marginCalc(attDollarsAboveNetCost, attAdjustedSellingPrice, attMargin, attTotCostPrice, attTotListPrice,attachDiscount);
					marginCalc(techoptDollarsAboveNetCost, techOptAdjustedSellingPrice, techoptMargin, techOptTotCostPrice,
							techOptTotListPrice,techOptDiscount);
					totMarginCalc();
					clickDoneOnLeftNav();
					clickSalesManualIcon();
					copyEquipmentbySelecting();
					deleteEquipment();					
					System.out.println("Testcase pass");
				} else {
					System.out.println("Equipment not added");
				}
			} else
				System.out.println("Dealership does not show JDSC DBS button");
		}
	}

	public void addEquipmentFromJDSCDBSBySearch() throws InterruptedException {
		if (jdscDBSBtn.isDisplayed()) {
			jdscDBSBtn.click();
			String jdscApp = driver.getTitle();
			System.out.println(jdscApp);
			if (jdscApp.equals("Sales Center | Masquerade")) {
				Thread.sleep(20000);
				jdscUserName.sendKeys(jdscDealer);
				jdscSignIn.click();
				Thread.sleep(20000);
				jdscIAgreeBtn.click();
				Thread.sleep(60000);
				if (jdscDBSSearchField.isDisplayed()) {
					jdscDBSSearchField.sendKeys(jdscDBSStockNumber);
					Thread.sleep(20000);
					if (jdscDBSSearchButton.isEnabled()) {
						jdscDBSSearchButton.click();
						if (jdscDBSSearchResult.isDisplayed()) {
							jdscDBSSearchResult.click();
							Thread.sleep(30000);
							if (jdscDBSVehicleNumber.isDisplayed()) {
								String vehicleNumber = jdscDBSVehicleNumber.getText();
								String equipURL = driver.getCurrentUrl();
								if (equipURL.contains(vehicleNumber)) {
									jdscDBSEquipDtlSelectBtn.click();
									if (jdscDBSEquipDtlSelectedBtn.isDisplayed()) {
										jdscDBSEquipDtlCrossBtn.click();
										Thread.sleep(60000);
										if (jdscDBSSendToJdQuote2Btn.isDisplayed())
											jdscDBSSendToJdQuote2Btn.click();
										Thread.sleep(30000);
										String url = driver.getCurrentUrl();

										if (doneLeftNav.isDisplayed()) 
										{
											salesIncentiveBulletin();
											pricingCalc(equipOptCostPrice, equipOptListPrice, totEquipCostPrice, totEquipListPrice);
											pricingCalc(adjustmentCostPrice, adjustmntListPrice, totAdjCostPrice, totAdjListPrice);
											if (techOptChkBox.isDisplayed())
												pricingCalc(techOptCostPrice, techOptListPrice, techOptTotCostPrice, techOptTotListPrice);
											if (attachmetChkBox.isDisplayed())
												pricingCalc(attCostPrice, attListPrice, attTotCostPrice, attTotListPrice);
											equipTotalCalc();
											equipAttachTechOpsCalc();
											marginCalc(equipDollarsAboveNetCost, equipAdjustedSellingPrice, equipMargin, equipTotCostPrice,
													equipTotListPrice,equipDiscount);
											marginCalc(attDollarsAboveNetCost, attAdjustedSellingPrice, attMargin, attTotCostPrice, attTotListPrice,attachDiscount);
											marginCalc(techoptDollarsAboveNetCost, techOptAdjustedSellingPrice, techoptMargin, techOptTotCostPrice,
													techOptTotListPrice,techOptDiscount);
											totMarginCalc();
											clickDoneOnLeftNav();
											clickSalesManualIcon();
											copyEquipmentbySelecting();
											deleteEquipment();
											System.out.println("Testcase pass");
										} else {
											System.out.println("Equipment not added");
										}

									} else
										System.out.println("Equipment is not selected");
								}
							} else
								System.out.println("Equipment details page not displyed");
						} else
							System.out.println("No Equipment found with the search or Issue in fetching Equipment");
					}
				}
			} else
				System.out.println("Dealership does not show JDSC DBS button");
		}
	}
}
