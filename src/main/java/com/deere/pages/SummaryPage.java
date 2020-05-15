package com.deere.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.deere.applicaionSpecific.GlobalThings;
import com.deere.global.CommonFunctions;
import com.deere.global.InputEnvironmentDetails;
import com.deere.global.InputTestDetails;

public class SummaryPage extends LoadableComponent<SummaryPage> {
	WebDriver driver;
	HomePage homePage;

	public SummaryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		homePage = new HomePage(driver);
	}

	@FindBy(how = How.XPATH, xpath = "//*[@id='quoteDetail']/tbody/tr[1]/th")
	private WebElement quoteID;
	@FindBy(how = How.XPATH, xpath = "//th[contains(text(),'Quote Name')]")
	private WebElement quoteNameField;
	@FindBy(how = How.XPATH, xpath = "//input[@name='quoteName']")
	private WebElement quoteNameInputBox;
	@FindBy(how = How.XPATH, xpath = "//th[contains(text(),'Sales Person')]")
	private WebElement salesPersonField;
	@FindBy(how = How.XPATH, xpath = "//select[@id='selectedSalesPerson']")
	private WebElement salesPersonDropDown;
	@FindBy(how = How.XPATH, xpath = "//select[@id='selectedStatus']")
	private WebElement quoteStatus;
	@FindBy(how = How.XPATH, xpath = "//th[contains(text(),'Status')]")
	private WebElement quoteStatusField;
	@FindBy(how = How.XPATH, xpath = "//a[@id='customerNotesShow']")
	private WebElement customerNotesShowLink;
	@FindBy(how = How.XPATH, xpath = "//input[@name='limitedAccess']")
	private WebElement limitedAccessCheckBox;
	@FindBy(how = How.XPATH, xpath = "//select[@id='selectedQuoteType']")
	private WebElement selectQuoteType;
	@FindBy(how = How.XPATH, xpath = "//input[@id='expirationDate']")
	private WebElement selectDate;
	// calender image
	private By calenderIcon = By.xpath("//IMG[@class='datepick-trigger']");
	@FindBy(how = How.XPATH, xpath = "//input[@value='Create Quote']")
	private WebElement createQuote;
	@FindBy(how = How.XPATH, xpath = "//input[@id='CMP_DFND']")
	private WebElement compDefinedEvent;
	@FindBy(how = How.XPATH, xpath = "//input[@id='DLR_DFND']")
	private WebElement dealerDefinedEvent;

	// *****Customer Section*****
	@FindBy(how = How.XPATH, xpath = "(//input[@value='Search'])[2]")
	private WebElement searchBtn;
	@FindBy(how = How.XPATH, xpath = "//input[@id='businessName']")
	private WebElement businessName;
	@FindBy(how = How.XPATH, xpath = "//input[@id='ikcId']")
	private WebElement customerEntityId;
	// search button on customer page
	@FindBy(how = How.XPATH, xpath = "(//input[@type='button'])[2]")
	private WebElement searchCustmrBtn;
	// list of searched customer with business name
	@FindBy(how = How.XPATH, xpath = "//*[@id='results']/tbody/tr/td[2]/a")
	private List<WebElement> customerSearchedList;
	@FindBy(how = How.XPATH, xpath = "//a[@id='secondCustomerLink']")
	private WebElement addSecondCustmrLink;
	@FindBy(how = How.XPATH, xpath = "//input[@value='Replace'][1]")
	private WebElement replace1stCustBtn;
	@FindBy(how = How.XPATH, xpath = "//*[@id='secondCustLegendDiv']//input[@value='Replace']")
	private WebElement replace2ndCustBtn;
	@FindBy(how = How.XPATH, xpath = "//input[@value='Delete']")
	private WebElement deleteCustBtn;
	// satet dropdown
	@FindBy(how = How.XPATH, xpath = "//select[@id='state']")
	private WebElement custStateDD;

	// create demo agreement image
	@FindBy(how = How.XPATH, xpath = "//img[@src='/JDQuote/images/i_generate.gif']")
	private WebElement demoAgreementImage;

	// create rental agreement image
	@FindBy(how = How.XPATH, xpath = "//img[@src='/JDQuote/images/i_generate.gif']")
	private WebElement rentalAgreementImage;
	// select Purchaser Type
	@FindBy(how = How.XPATH, xpath = "//select[@name='selectedPurchaserType']")
	private WebElement selectPurchaseType;
	// market use selection
	@FindBy(how = How.XPATH, xpath = "//select[@name='selectedMarketUse']")
	private WebElement marketUseDD;
	// select Day out
	@FindBy(how = How.XPATH, xpath = "//*[@id='datepick-div']/div[3]/table/tbody/tr/td/a")
	private List<WebElement> dayOutSelection;
	@FindBy(how = How.XPATH, xpath = "//input[@id='dateOut']")
	private WebElement dayOut;
	@FindBy(how = How.XPATH, xpath = "//select[@id='selectedQuoteCurrency']")
	private WebElement quoteCurrency;
	@FindBy(how = How.XPATH, xpath = "//select[@id='selectedFinanceType']")
	private WebElement financeType;

	// *******Demo Agreement page**********
	// Click on generate Demo Agreement image
	public void generateDemoAgreement() throws InterruptedException {
		demoAgreementImage.click();
		Thread.sleep(10000);
	}

	// ***********Rental agreement page********
	// Click on generate Rental Agreement image
	public void generateRentalAgreement() throws InterruptedException {
		rentalAgreementImage.click();
		Thread.sleep(15000);
	}

	// select Purchaser type
	public void selectPurchaserType(InputTestDetails inputTestDetails) throws InterruptedException {
		selectPurchaseType.click();
		String purchaserType = inputTestDetails.getTestdata()[3].toString();
		System.out.println(purchaserType);
		Thread.sleep(2000);
		CommonFunctions.selectFromDropdown(purchaserType, selectPurchaseType);
		Thread.sleep(5000);
	}

	// select Market use
	public void selectMarketUse(InputTestDetails inputTestDetails) throws InterruptedException {
		marketUseDD.click();
		String marketUse = inputTestDetails.getTestdata()[4].toString();
		System.out.println(marketUse);
		Thread.sleep(2000);
		CommonFunctions.selectFromDropdown(marketUse, marketUseDD);
		Thread.sleep(5000);
	}

	// To select day out
	public void selectDayOut() throws InterruptedException {
		dayOut.click();
		Thread.sleep(2000);
		int size = dayOutSelection.size();
		int index = CommonFunctions.randomNumberGenerator(size);
		dayOutSelection.get(index).click();
		Thread.sleep(10000);
	}

	// To select date from calendar
	public void selctDateFromCalender() throws InterruptedException {
		// Thread.sleep(4000);
		if (CommonFunctions.waitForAnObject(driver, calenderIcon, GlobalThings.minWait)) {
			CommonFunctions.click(driver, calenderIcon);
		}
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 7);
		String newDate = dateFormat.format(cal.getTime());
		selectDate.sendKeys(newDate);
	}
	

	// Create Quote Button
	public void clickCreateQuoteButton() throws InterruptedException {
		createQuote.click();
		Thread.sleep(7000);
	}

	// Enter quote name in the input box
	public void enterQuoteName1(String uniqueQuoteName) {
		quoteNameInputBox.sendKeys(uniqueQuoteName);
	}

	public void enterQuoteName() throws InterruptedException {
		quoteNameInputBox.sendKeys("Test" + CommonFunctions.generateRandomNumber(6));
		Thread.sleep(2000);
	}

	// enter test name in business field
	public void enterBusinessName(String testBName) throws InterruptedException {
		businessName.sendKeys(testBName);
	}

	// Click on search Customer button
	public void searchCustomer() throws InterruptedException {
		searchBtn.click();
		CommonFunctions.waitForLoad(driver);
	}
	
	// Change Quote Status
	public void changeQuoteStatus()
	{
		Assert.assertTrue(quoteStatus.isDisplayed(), "Quote Status field is not displayed");
		CommonFunctions.selectFromDropdownByIndex(1,quoteStatus);
		homePage.headerSaveQuote();		
	}
    
	public void addCBDCustomer(InputTestDetails inputTestDetails) throws InterruptedException {
		String stateCust = inputTestDetails.getTestdata()[2].toString();
		searchCustomer();
		CommonFunctions.waitForLoad(driver);
		CommonFunctions.switchToFrameWithFrameName(driver, "cscsearch");
		businessName.sendKeys("test");
		Thread.sleep(1000);
		CommonFunctions.selectFromDropdown(stateCust, custStateDD);
		Thread.sleep(1000);
		searchCustmrBtn.click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//*[@id='results']/tbody/tr[2]/td[2]/a")).click();
		//CommonFunctions.javaScriptScrollDown(driver, 200);
		//int size = customerSearchedList.size();
		//int index = CommonFunctions.randomNumberGenerator(size);
		//customerSearchedList.get(index).click();
		Thread.sleep(10000);
	}
	
	public void addCustomer(InputTestDetails inputTestDetails) throws InterruptedException {
		String stateCust = inputTestDetails.getTestdata()[2].toString();
		searchCustomer();
		CommonFunctions.waitForLoad(driver);
		CommonFunctions.switchToFrameWithFrameName(driver, "cscsearch");
		businessName.sendKeys("test");
		Thread.sleep(1000);
		CommonFunctions.selectFromDropdown(stateCust, custStateDD);
		Thread.sleep(1000);
		searchCustmrBtn.click();
		Thread.sleep(20000);
		CommonFunctions.javaScriptScrollDown(driver, 200);
		int size = customerSearchedList.size();
		int index = CommonFunctions.randomNumberGenerator(size);
		customerSearchedList.get(index).click();
		Thread.sleep(10000);
	}

	public void addFirstCustomer(InputTestDetails inputTestDetails) throws InterruptedException {
		String stateCust = inputTestDetails.getTestdata()[1].toString();
		searchCustomer();
		CommonFunctions.waitForLoad(driver);
		CommonFunctions.switchToFrameWithFrameName(driver, "cscsearch");
		businessName.sendKeys("test");
		Thread.sleep(1000);
		CommonFunctions.selectFromDropdown(stateCust, custStateDD);
		Thread.sleep(1000);
		searchCustmrBtn.click();
		Thread.sleep(20000);
		CommonFunctions.javaScriptScrollDown(driver, 200);
		int size = customerSearchedList.size();
		int index = CommonFunctions.randomNumberGenerator(size);
		customerSearchedList.get(index).click();
		Thread.sleep(10000);
	}

	// Add second customer
	public void addSecondCustomer(InputTestDetails inputTestDetails) throws InterruptedException {
		String stateCust = inputTestDetails.getTestdata()[2].toString();
		addSecondCustmrLink.click();
		CommonFunctions.waitForLoad(driver);
		CommonFunctions.switchToFrameWithFrameName(driver, "cscsearch");
		businessName.sendKeys("test");
		Thread.sleep(1000);
		CommonFunctions.selectFromDropdown(stateCust, custStateDD);
		Thread.sleep(1000);
		searchCustmrBtn.click();
		Thread.sleep(20000);
		CommonFunctions.javaScriptScrollDown(driver, 200);
		int size = customerSearchedList.size();
		int index = CommonFunctions.randomNumberGenerator(size);
		customerSearchedList.get(index).click();
		Thread.sleep(10000);
	}

	// Replace 1stCustomer
	public void replace1stCustomer(InputTestDetails inputTestDetails) throws InterruptedException {
		String stateCust = inputTestDetails.getTestdata()[3].toString();
		replace1stCustBtn.click();
		CommonFunctions.waitForLoad(driver);
		CommonFunctions.switchToFrameWithFrameName(driver, "cscsearch");
		businessName.sendKeys("test");
		Thread.sleep(1000);
		CommonFunctions.selectFromDropdown(stateCust, custStateDD);
		Thread.sleep(1000);
		searchCustmrBtn.click();
		Thread.sleep(20000);
		CommonFunctions.javaScriptScrollDown(driver, 200);
		int size = customerSearchedList.size();
		int index = CommonFunctions.randomNumberGenerator(size);
		customerSearchedList.get(index).click();
		Thread.sleep(10000);
	}

	// Replace 2nd Customer
	public void replace2ndCustomer(InputTestDetails inputTestDetails) throws InterruptedException {
		String stateCust = inputTestDetails.getTestdata()[4].toString();
		replace2ndCustBtn.click();
		CommonFunctions.waitForLoad(driver);
		CommonFunctions.switchToFrameWithFrameName(driver, "cscsearch");
		businessName.sendKeys("test");
		Thread.sleep(1000);
		CommonFunctions.selectFromDropdown(stateCust, custStateDD);
		Thread.sleep(1000);
		searchCustmrBtn.click();
		Thread.sleep(20000);
		CommonFunctions.javaScriptScrollDown(driver, 200);
		int size = customerSearchedList.size();
		int index = CommonFunctions.randomNumberGenerator(size);
		customerSearchedList.get(index).click();
		Thread.sleep(10000);
	}

	// Delete Customer
	public void deleteCustomer() throws InterruptedException {
		deleteCustBtn.click();
	}

	public void addCustomerDirect(InputTestDetails inputTestDetails) throws InterruptedException {
		String stateCust = inputTestDetails.getTestdata()[2].toString();
		CommonFunctions.waitForLoad(driver);
		CommonFunctions.switchToFrameWithFrameName(driver, "cscsearch");
		businessName.sendKeys("test");
		Thread.sleep(1000);
		CommonFunctions.selectFromDropdown(stateCust, custStateDD);
		Thread.sleep(1000);
		searchCustmrBtn.click();
		Thread.sleep(20000);
		CommonFunctions.javaScriptScrollDown(driver, 200);
		int size = customerSearchedList.size();
		int index = CommonFunctions.randomNumberGenerator(size);
		customerSearchedList.get(index).click();
		Thread.sleep(10000);
	}

	protected void load() {

	}

	// select Quote type from drop down
	public void selectQuoteType(InputTestDetails inputTestDetails) throws InterruptedException {
		String quoteType = inputTestDetails.getTestdata()[1].toString();
		// CommonFunctions.selectFromDropdownByValue(quoteType,
		// selectQuoteType);
		CommonFunctions.selectFromDropdown(quoteType, selectQuoteType);
		Thread.sleep(2000);
	}

	// select dealer ship radio button
	public void selectDealerRadioBttn() throws InterruptedException {
		driver.findElement(By.xpath("(//input[@name='cbdDealerSelected'])[1]")).click();
		Thread.sleep(2000);
	}
	
	// Select Quote Currency type
		public void selectQuoteCurrency()
		{
			Select select = new Select(quoteCurrency);
			select.selectByIndex(2);		
		}
		
		// Select Finance type
				public void selectFinanceType()
				{
					Select select = new Select(financeType);
					select.selectByIndex(1);		
				}
		
   // Add Customer by Entity Id 
		public void addCustomerByEntityID(InputTestDetails inputTestDetails) throws InterruptedException 
		{
			String entityIdCust = inputTestDetails.getTestdata()[5].toString();
			searchCustomer();
			CommonFunctions.waitForLoad(driver);
			CommonFunctions.switchToFrameWithFrameName(driver, "cscsearch");
			customerEntityId.sendKeys(entityIdCust);
			Thread.sleep(1000);
			searchCustmrBtn.click();
			Thread.sleep(20000);
			CommonFunctions.javaScriptScrollDown(driver, 200);
			int size = customerSearchedList.size();
			int index = CommonFunctions.randomNumberGenerator(size);
			customerSearchedList.get(index).click();
			Thread.sleep(10000);
		}

	@Override
	protected void isLoaded() throws Error {

	}

}
