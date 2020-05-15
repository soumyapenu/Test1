package com.deere.pages;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.record.RecalcIdRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

import com.deere.global.CommonFunctions;

public class TradeInPage {

	WebDriver driver;

	public TradeInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Click on Trade In tab
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Trade-ins')]")
	private WebElement tradeInTab;

	// Click on Freeform trade in
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Free Form')]")
	private WebElement freeformtradein;

	// Select make of Trade In
	@FindBy(how = How.ID, id = "make")
	private WebElement selectMakeTradeIn;

	// Select model of trade in
//	@FindBy(how = How.ID, id = "autocomplete")
//	private WebElement selectModelTradeIn;
	
	private By selectModelTradeIn =By.id("autocomplete");

//	@FindBy(how = How.ID, id = "netTradeValue")
//	private WebElement netTradeValue;
	
	private By netTradeValue =By.id("netTradeValue");

	// Click on Done of TradeIn
	@FindBy(how = How.XPATH, xpath = "//input[@value='Done']")
	private WebElement tradeInDoneButton;

	// Add TradeIn
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Add Trade-In')]")
	private WebElement addTradeIn;

	// Select category of Add Trade in
	@FindBy(how = How.XPATH, xpath = "//*[@id='category_select']")
	private WebElement selectCategory;

	// Iframe of Add Trade In
	String frameName1 = "uxsearch";

	// Select manufacturer
	@FindBy(how = How.XPATH, xpath = "//*[@id='manufacturer_select']")
	private WebElement selectManufacturer;

	// Select model of Trade in
	@FindBy(how = How.XPATH, xpath = "//*[@id='is_model_select']")
	private WebElement selectModelOfAddTradeIn;

	// Select model year of Add Trade In
	@FindBy(how = How.XPATH, xpath = "//*[@id='model_year_input_field']")
	private WebElement selectModelYearOfAddTradeIn;

	// Click on Start button
	@FindBy(how = How.XPATH, xpath = "//*[@value='Start']")
	private WebElement startButton;

	// Click on Apply 2 quote for adding trade in
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'APPLY TO QUOTE')]")
	private WebElement apply2Quote;

	// Edit Add Trade in
	// @FindBy(how = How.XPATH,
	// xpath="//form[@name='TradeInLineItemForm']//table[2]//tr[2]//td[10]")
	// private WebElement editTradeIn;
	@FindBy(how = How.XPATH, xpath = "//*[@id='rightColumn']/table[2]/tbody/tr[2]/td[10]/a")
	private WebElement editTradeIn;

	// Replace current trade in
	@FindBy(how = How.XPATH, xpath = "//*[@title='Replace Current trade-in values with these values']")
	private WebElement replaceCurrentTradeIn;

	// Refresh Trade In
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Refresh Trade In')]")
	private WebElement refreshTradeIn;

	// Click on Yes button for Refresh Trade in
	@FindBy(how = How.XPATH, xpath = "//*[@class='ui-dialog ui-widget ui-widget-content ui-corner-all  ui-draggable ui-resizable']//button[contains(text(),'Yes')]")
	private WebElement clickOnYesButton;

	// Enter Pay off amount for add Trade In
	@FindBy(how = How.ID, xpath = "//input[@name='payOffAmountValue']")
	private WebElement payOffAmount;

	// MachineFinder pro Trade In link
	@FindBy(how = How.XPATH, xpath = "//*[text()='MachineFinder Pro']")
	private WebElement machineFinderProTradeInLink;

	// IframeMachineFinder Pro page
	@FindBy(how = How.XPATH, xpath = "//*[@id='uxsearch']")
	private WebElement iframeMachineFinderProPage;
	// Click on Find In My Inventory of MFPRO
	@FindBy(how = How.XPATH, xpath = "//*[@class='mfm-link tile yellow fade_in fade_in_0 feature' or @class='mfm-link tile yellow fade_in fade_in_1 feature']")
	private WebElement tradeINFindInMYInventory;
	// Manufacturer option
	@FindBy(how = How.XPATH, xpath = "//*[@id='manufacturer']")
	private WebElement ManufacturerLink;
	// John deere check box selection from manufacturer link
	@FindBy(how = How.XPATH, xpath = "//*[@name='sk_atvs_gators']")
	private WebElement sk_trucks;
	// Click on Apply Quote
	@FindBy(how = How.XPATH, xpath = "//*[text()='APPLY TO QUOTE']")
	private WebElement applyToQuote;
	// MFPro Equipment List
	@FindBy(how = How.XPATH, xpath = "//*[contains(@class,'machines_all')]")
	private WebElement mfproEquipList;

	@FindBy(how = How.XPATH, xpath = "//*[@id='manufacturer']/li[1]")
	private WebElement checkBoxJohnDeere;

	// Reorder Trade Ins
	@FindBy(how = How.XPATH, xpath = "//*[@id='rightColumn']/table[2]/tbody/tr[3]/td[8]/img")
	private WebElement reorderTradeIn;

	// Trade in Description
	@FindBy(how = How.XPATH, xpath = "//*[@onclick='javascript:showFreeFormSelectArea(2)']")
	private WebElement clickTradeInDescription;

	// Write description in Trdae In Description
//	@FindBy(how = How.XPATH, xpath = "//*[@id='tinymce']")
//	private WebElement textinTradeInDescription;
	
	private By textinTradeInDescription =By.xpath("//*[@id='tinymce']");

	String TradeInDescription = "description_ifr";

	// Open Associate Trade-in to Equipment for Sale
	@FindBy(how = How.XPATH, xpath = "//*[@id='openCloseImageId']")
	private WebElement associateTradeintoEquipmentforSale;

	// Webelement drag
	// @FindBy(how = How.XPATH, xpath = "//*[contains(text(),'JOHN DEERE 3038E
	// TRACTOR')]//following::div[1]")
	// private WebElement dragTradeIn;

	@FindBy(how = How.XPATH, xpath = "//*[@id='perMachine']//table//tbody//tr//td//following::div[1]//img[1]")
	private WebElement dragTradeIn;

	// WebElement drop
	@FindBy(how = How.XPATH, xpath = "//*[@id='addIcon']")
	private WebElement dropTradeIn;

	// Close Associate Trade-in to Equipment for Sale
	@FindBy(how = How.XPATH, xpath = "//*[@id='openCloseImageId']")
	private WebElement closeAssociateTradeintoEquipmentforSale;

	// Select Deleting checkbox of Trade Ins present on tab
	@FindBy(how = How.XPATH, xpath = "//*[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix ']//button//span[contains(text(),'Yes')]")
	private WebElement clickOnYesForDeletingTradeIn;

	// Deleting Trade Ins
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Delete Selected')]")
	private WebElement deletingTradeIn;
	
	// Trade In Header
		@FindBy(how = How.XPATH,xpath = "//h1[contains(text(),'Trade-Ins')]")
		public WebElement tradeInHeader;
		
	// MFPro Button
		@FindBy(how = How.XPATH,xpath = "//a[@id='uxid']")
		public WebElement mFProbtn;
		
	// MFPRo Logo
		@FindBy(how = How.XPATH,xpath = "//img[@id='mfpro_logo']")
		public WebElement mFPrologo;
		
	//  MFPRO Equipment List 
		@FindBy(how = How.XPATH,xpath = "//li[text()='Value Pricing']")
		public WebElement mfproValuePricing;
		
	//  Value Pricing Link on MFPro Application
		@FindBy(how = How.XPATH,xpath = "//div[@class='r_e r_mmy rx_click']//a[1]")
		public List<WebElement> mfProEquipmentList;
		
	//  Sales Pro Filter
		@FindBy(how = How.XPATH,xpath = "//ul[@id='sales pro']//li//label")
		public List<WebElement> salesProChkBox;
	//  MDP Assessment Label
		@FindBy(how = How.XPATH,xpath = "//input[@id='base_method_change_mdp']")
		public WebElement mdpAssessmentRadioBtn;
		
	// Apply To Quote button
		@FindBy(how = How.XPATH,xpath = "//ul[@id='mfpro_jdquote_top']//li[@class='quote']//a[contains(text(),'APPLY TO QUOTE')]")
		public WebElement mfproApplyToQuoteBtn;
		
	// Green Arrow Button
		@FindBy(how = How.XPATH, xpath = "//img[@src='/JDQuote/images/move_right.gif']")
		public WebElement greenArrowBtn;

	//	Verify Trade in name
	@FindBy(how = How.XPATH, xpath = "//input[@name='tradeInLineItemDescriptions']")
	private WebElement verifyTradeInName;

	//	Display Adjustment values in trade ins
	@FindBy(how = How.XPATH, xpath = "//*[@id='rightColumn']/table[2]/tbody/tr/td[8]/input[@type ='text']")
	private List<WebElement> optionAdjustmentValue;


	//	Select 1st trade in
	@FindBy(how = How.XPATH, xpath = "//*[@id='rightColumn']//table[2]//tbody//tr[1]//td[10]//a")
	private WebElement clickOn1stTradeIn;


	//	Expected Selling Price
	@FindBy(how = How.XPATH, xpath = "//input[@name='expectedSellingPriceValue']")
	private WebElement expectedSellingPrice;


	//	Net Trade Value
	@FindBy(how = How.XPATH, xpath = "//*[@name='netTradeValue']")
	private WebElement compareNetTradeValue;

	// Add trade in from different resources
	public void clickOnTradeInTab() throws InterruptedException {

		CommonFunctions.clickOnElement(driver, tradeInTab);

		Thread.sleep(3000);

		List<WebElement> deleteTradeIn = driver
				.findElements(By.xpath("//input[@name='lineNumbers']"));
		System.out.println("Total number of trade ins present on page " + deleteTradeIn.size());
        
		if(deleteTradeIn.size()!=0)
		{
		for (int i = 0; i < deleteTradeIn.size(); i++) {
			deleteTradeIn.get(i).click();

		}

		Thread.sleep(5000);
		CommonFunctions.clickOnElement(driver, deletingTradeIn);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clickOnYesForDeletingTradeIn);
		}
		
		else
		{
			System.out.println("No Trade Ins available");
		}
	}

	// Reorder Trade Ins
	public void reorderTradeIns() throws InterruptedException {

		List<WebElement> listOfTradeIns = driver.findElements(By.xpath("//*[@name='tradeInLineItemDescriptions']"));
		System.out.println("Number of Trade Ins " + listOfTradeIns.size());

		for (int i = 0; i < listOfTradeIns.size(); i++) {
			String nameOfTradeInsAddedBeforeReordering = listOfTradeIns.get(i).getAttribute("value");

			System.out.println("Before reordering trade ins are " + nameOfTradeInsAddedBeforeReordering);
		}
		Thread.sleep(5000);
		
		CommonFunctions.clickOnElement(driver, reorderTradeIn);
		
		List<WebElement> listOfTradeInsAfterReorder = driver
				.findElements(By.xpath("//*[@name='tradeInLineItemDescriptions']"));
		for (int i = 0; i < listOfTradeIns.size(); i++) {
			String nameOfTradeInsAddedAfterReordering = listOfTradeInsAfterReorder.get(i).getAttribute("value");

			System.out.println("After reordering trade ins are " + nameOfTradeInsAddedAfterReordering);
		}

	}

	// Write Some notes Into Trade In description
	public void writeTradeInDescription() throws InterruptedException {
		Thread.sleep(5000);
	CommonFunctions.clickOnElement(driver, clickTradeInDescription);

		// textinTradeInDescription.sendKeys("Profit is added");
		//
		// tradeInDoneButton.click();
		//
		String MainWindow = driver.getWindowHandle();
		Set<String> sizeOfWindow = driver.getWindowHandles();

		Iterator<String> iterate = sizeOfWindow.iterator();
		while (iterate.hasNext()) {
			String ChildWindow = iterate.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);

				driver.manage().window().maximize();
				System.out.println(driver.switchTo().window(ChildWindow).getTitle());
				CommonFunctions.switchToFrameWithFrameName(driver, TradeInDescription);
				Thread.sleep(5000);
				CommonFunctions.sendKeys(driver, textinTradeInDescription, "Profit Is Added");
				CommonFunctions.switchToDefaultFrame(driver);
			CommonFunctions.clickOnElement(driver, tradeInDoneButton);
				// driver.close();

			}
		}
		driver.switchTo().window(MainWindow);

		System.out.println(driver.switchTo().window(MainWindow).getTitle());
	}

	public void dragAndDropAssociateTradeIn() throws InterruptedException {
		Thread.sleep(5000);
		CommonFunctions.clickOnElement(driver, associateTradeintoEquipmentforSale);

		Thread.sleep(5000);
		Actions act = new Actions(driver);

		// Dragged and dropped.

		act.dragAndDrop(dragTradeIn, dropTradeIn).build().perform();
		Thread.sleep(10000);
		System.out.println("Drag and drop of Trade in is done successfully ");
		CommonFunctions.clickOnElement(driver, closeAssociateTradeintoEquipmentforSale);
		CommonFunctions.waitForLoad(driver);
	}

	// Freeform Trade In
	public void freeFormtradeInMakeAndModelSelect() throws InterruptedException {

		CommonFunctions.explicitWaitWebElement(driver, freeformtradein);
		Thread.sleep(10000);
		CommonFunctions.clickOnElement(driver, freeformtradein);
		CommonFunctions.explicitWaitWebElement(driver, selectMakeTradeIn);
//		Select make = new Select(selectMakeTradeIn);
//		make.selectByVisibleText("JOHN DEERE");
		
		CommonFunctions.selectFromDropdown("JOHN DEERE", selectMakeTradeIn);
		Thread.sleep(3000);
		CommonFunctions.sendKeys(driver, selectModelTradeIn, "3038");
		Thread.sleep(5000);


		List<WebElement> selectmodel = driver.findElements(By.xpath("//*[@role='listbox']/li"));

		// Select random number
		// int size = selectmodel.size();
		// System.out.println(size);
		// int index = CommonFunctions.randomNumberGenerator(size);
		// selectmodel.get(index).click();
		// Thread.sleep(1jmgik0000);

		int count = selectmodel.size();
		System.out.println("Total number of models found " + count);
		for (int i = 1; i <= count; i++) {
			String modelList = driver.findElement(By.xpath("//ul[@role='listbox']//li[" + i + "]//a")).getText();
			System.out.println("Model name is " + modelList.trim());
		}
//		WebElement selectModel = driver.findElement(By.xpath("//*[@role='listbox']/li[1]"));
//		selectModel.click();
		
		CommonFunctions.randomNumberGenerator(count);
		int index = CommonFunctions.randomNumberGenerator(count);
		selectmodel.get(index).click();
		
		
		CommonFunctions.clear(driver, netTradeValue);
	
		CommonFunctions.sendKeys(driver, netTradeValue, "2500");
		Thread.sleep(10000);
	clickOnDoneButtonOfTradeIns();

		System.out.println("*********************************************************");
	}
	
	public void tradeInNamesPresentOnTradeIntab(){
		List<WebElement> totalNumberOfTradeInNames=driver.findElements(By.xpath("//input[@name='tradeInLineItemDescriptions']"));
		
		System.out.println("Total number of Trade ins present on trade in Tab "+totalNumberOfTradeInNames.size());

	for(int i=0; i<totalNumberOfTradeInNames.size(); i++){
		String tradeInName=totalNumberOfTradeInNames.get(i).getAttribute("value");
		System.out.println("Trade In name is "+tradeInName);
	}
	}
	
	public void validateTradeInsPrices() throws InterruptedException{
		
		CommonFunctions.clickOnElement(driver, clickOn1stTradeIn);
		//		System.out.println("Freeform trade in added successfully");
		Thread.sleep(5000);

		//		validate pricing on Add Trade in
		cmprTotalSellingPriceUnderDetermngSec();

		cmprFinalTradeAllowanceUnderDetermngSec();

		Thread.sleep(5000);
	}
	
	public void clickOnDoneButtonOfTradeIns() throws InterruptedException{
		Thread.sleep(5000);

		CommonFunctions.clickOnElement(driver, tradeInDoneButton);
		Thread.sleep(5000);
	}

	// Add trade in
	public void addTradeIn() throws InterruptedException {
		CommonFunctions.explicitWaitWebElement(driver, addTradeIn);
		CommonFunctions.clickOnElement(driver, addTradeIn);
		// CommonFunctions.explicitWaitWebElement(driver, selectCategory);
		Thread.sleep(10000);
		driver.switchTo().frame(frameName1);
		// Select category=new Select(selectCategory);
		CommonFunctions.selectFromDropdownByIndex(2, selectCategory);
		Thread.sleep(10000);
		// Select manufacturer=new Select(selectManufacturer);
		CommonFunctions.selectFromDropdown("John Deere", selectManufacturer);
		Thread.sleep(10000);
		CommonFunctions.selectFromDropdown("6x4 Dsl", selectModelOfAddTradeIn);
		Thread.sleep(10000);
		CommonFunctions.selectFromDropdownByIndex(2, selectModelYearOfAddTradeIn);
		CommonFunctions.scrollToElement(driver, startButton);
		CommonFunctions.clickOnElement(driver, startButton);
		Thread.sleep(10000);
		// driver.switchTo().frame(frameName1);
		// CommonFunctions.javaScriptScrollUp(driver, 5000);
		CommonFunctions.scrollToElement(driver, apply2Quote);
		Thread.sleep(5000);
		CommonFunctions.clickOnElement(driver, apply2Quote);
		Thread.sleep(10000);
		CommonFunctions.scrollToElement(driver, tradeInDoneButton);
		CommonFunctions.clickOnElement(driver, tradeInDoneButton);
		Thread.sleep(10000);
		CommonFunctions.clickOnElement(driver, clickOn1stTradeIn);
//		Thread.sleep(5000);
		CommonFunctions.clickOnElement(driver, replaceCurrentTradeIn);
	CommonFunctions.clickOnElement(driver, refreshTradeIn);
		Thread.sleep(10000);
		// CommonFunctions.acceptAlert(driver);
		CommonFunctions.clickOnElement(driver, clickOnYesButton);
		// CommonFunctions.explicitWaitClickOn(driver, 5, payOffAmount);
		Thread.sleep(7000);
		CommonFunctions.clickOnElement(driver, payOffAmount);
		payOffAmount.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		payOffAmount.sendKeys(Keys.BACK_SPACE);

		Thread.sleep(10000);
		payOffAmount.sendKeys("500");
		
		Thread.sleep(8000);
		
		clickOnDoneButtonOfTradeIns();
	
	
		System.out.println("************************************************************");
		Thread.sleep(7000);
	}

	// MacgineFinder Pro Trade In
	public void machineFinderProTradeIn() throws InterruptedException {
		CommonFunctions.clickOnElement(driver, machineFinderProTradeInLink);
		Thread.sleep(10000);
		CommonFunctions.switchToFrameWithFrameName(driver, frameName1);
		// sk_trucks.click();
		CommonFunctions.scrollToElement(driver, checkBoxJohnDeere);
		CommonFunctions.clickOnElement(driver, checkBoxJohnDeere);
		Thread.sleep(5000);
		List<WebElement> clickOnElement = driver.findElements(By.xpath("//*[contains(text(),'APPLY TO QUOTE')]"));
		int size = clickOnElement.size();
		System.out.println(size);
		int index = CommonFunctions.randomNumberGenerator(size);
		clickOnElement.get(index).click();
		Thread.sleep(10000);
		CommonFunctions.clickOnElement(driver, replaceCurrentTradeIn);
		CommonFunctions.clickOnElement(driver, payOffAmount);
		payOffAmount.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		payOffAmount.sendKeys(Keys.BACK_SPACE);

		Thread.sleep(10000);
		payOffAmount.sendKeys("500");

		Thread.sleep(5000);
		clickOnDoneButtonOfTradeIns();

		System.out.println("***********************************************************");

		

	}
	public void select1stTradeIn() throws InterruptedException{
		tradeInTab.click();

		Thread.sleep(3000);
		CommonFunctions.clickOnElement(driver, clickOn1stTradeIn);
		greenArrowBtn.click();

		//		System.out.println(driver.findElement(By.xpath("//*[@id='rightColumn']/table[2]/tbody/tr[4]/td[8]/input[@type ='text']")).getAttribute("value"));

	}

	public List<String> verifyExpectedBaseCashValuebeforeadjustments() throws InterruptedException{
		List<String> finalElmsWithVal = new ArrayList<String>();
		System.out.println("Total number of elements prsent " + optionAdjustmentValue.size());
		for (int i = 0; i < optionAdjustmentValue.size(); i++) {
			System.out.println(optionAdjustmentValue.get(i).getAttribute("value"));
			finalElmsWithVal.add(optionAdjustmentValue.get(i).getAttribute("value"));
		}
		return finalElmsWithVal;
	}

	public double summationOfExpectedSellingPrice() throws InterruptedException{
		List<String> finalList = verifyExpectedBaseCashValuebeforeadjustments();
		System.out.println("Expected Selling Price : " + finalList);
		double totalVal = 0.000;	
		for (int i = 0; i < 5; i++) 
		{
			System.out.println("Value from list before adjustments: " + finalList.get(i));
			totalVal += Double.parseDouble(CommonFunctions.removeCommaFromStr(finalList.get(i)));
			System.out.println("Value after Addition for before adjustments: " + totalVal);
		}		
		return totalVal;

	}

	public void cmprTotalSellingPriceUnderDetermngSec() throws InterruptedException{

		System.out.println(optionAdjustmentValue.size());
		double total_of_all_elmVal = summationOfExpectedSellingPrice();
		System.out.println("Total Sum : " + total_of_all_elmVal);
		double total_SP = Double.parseDouble(CommonFunctions.removeCommaFromStr(expectedSellingPrice.getAttribute("value")));
		System.out.println("Total Selling Price : " + total_SP);
		try {
			assertEquals(total_of_all_elmVal, total_SP, 0.001);
			System.out.println("The sum of all the elements under expected  Selling pricing  is equal to Expected Base Cash Value(before adjustments)");
		} catch (Throwable e) {
			System.err.println("The sum of all the elements under expected  Selling price is not equal to Expected Base Cash Value(before adjustments)" + e.getMessage());
		}
	}


	public double finalTradeAllowance() throws InterruptedException{
		List<String> finalList2 = verifyExpectedBaseCashValuebeforeadjustments();
		System.out.println("DETERMING SECTION NEW LIST WITH VALUE : " + finalList2);
		double totalVal1=Double.parseDouble(CommonFunctions.removeCommaFromStr(finalList2.get(5)));	
		for (int i = 6; i <=9; i++) 
		{
			System.out.println("Value from list net trade value: " + finalList2.get(i));
			totalVal1 -= Double.parseDouble(CommonFunctions.removeCommaFromStr(finalList2.get(i)));
			System.out.println("Value after Addition for net trade value: " + totalVal1);
		}		
		return totalVal1;

	}

	public void cmprFinalTradeAllowanceUnderDetermngSec() throws InterruptedException{

		System.out.println(optionAdjustmentValue.size());
		double total_of_all_elmVal = finalTradeAllowance();
		System.out.println("Total Sum : " + total_of_all_elmVal);
		double total_SP = Double.parseDouble(CommonFunctions.removeCommaFromStr(compareNetTradeValue.getAttribute("value")));
		System.out.println("Total Selling Price : " + total_SP);
		try {
			assertEquals(total_of_all_elmVal, total_SP, 0.001);
			System.out.println("The sum of all the elements under Final Trade Allowance  is equal to Net Trade Value");
		} catch (Throwable e) {
			System.err.println("The sum of all the elements under Final Trade Allowance is not equal to Net Trade Value" + e.getMessage());
		}
		CommonFunctions.clickOnElement(driver, tradeInDoneButton);

	}


	// Add MDP Assessment Trade in From MFPro
	
		public void addMDPTrdIn() throws InterruptedException
		{
			navigateToTradeInTab();
			Thread.sleep(20000);
			navigateToMFPROAppli();
			Thread.sleep(20000);
			selectMDPEquip();
		}
			
		// Navigate to Trade In Page
		public void navigateToTradeInTab()
		{
			if(tradeInTab.isDisplayed())
				tradeInTab.click();		
		}
		
	    // Click on MFPRo Button
		public void navigateToMFPROAppli()
		{
			if(mFProbtn.isDisplayed());
			mFProbtn.click();
		}
		
		//Select MDP Assessment Equipment
		
		public void selectMDPEquip() throws InterruptedException
		{ 
			CommonFunctions.switchToFrameWithFrameName(driver, "uxsearch");
			int salesProSize = salesProChkBox.size();
			
			for(int i=0; i<salesProSize; i++)
			{
				String name = salesProChkBox.get(i).getText();
				System.out.println("Sales Person name: "+name);
				if(name.contains("Soumya")&&!salesProChkBox.get(i).isSelected())
				{
					salesProChkBox.get(i).click();
					break;
				}
						
			}		
			
			int equipSize = mfProEquipmentList.size();
			
			for(int j=0;j<equipSize;++j)
			{
				mfProEquipmentList.get(j).click();
				Thread.sleep(10000);
				if(mfproValuePricing.isDisplayed())
				{
					mfproValuePricing.click();
					Thread.sleep(10000);
				}
				else
				{
					System.out.println("Error occurred while opening Equipment details");
				}
			    if(mdpAssessmentRadioBtn.isEnabled())
			    {
			    	if(mdpAssessmentRadioBtn.isSelected())
			    	{
			    		if(mfproApplyToQuoteBtn.isDisplayed());
			    		mfproApplyToQuoteBtn.click();
			    	}
			    	else
			    	{
			    		mdpAssessmentRadioBtn.click();
			    		if(mfproApplyToQuoteBtn.isDisplayed());
			    		mfproApplyToQuoteBtn.click();		    		
			    	}
			    	System.out.println("MDP Trade In Equipment added successfully");
			    	break;
			    }
			    else{
			    	driver.navigate().back();
			    	Thread.sleep(5000);
			    	CommonFunctions.switchToFrameWithFrameName(driver, "uxsearch");
			    }
			
			    	
			}
		}


}
