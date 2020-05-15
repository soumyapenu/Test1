package com.deere.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.deere.applicaionSpecific.GlobalThings;
import com.deere.global.CommonFunctions;
import com.deere.global.InputEnvironmentDetails;
import com.deere.global.InputTestDetails;

public class HomePage extends LoadableComponent<SummaryPage> {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Left Allignment Navigation Links
	// Create New Quote Link
	private By createNewQuoteLink = By.xpath("//a[text()='Create New Quote']");
	// Create From Master Link
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Create Quote From Master')]")
	private WebElement createFromMaster;
	// Create from Purchase Order
	@FindBy(how = How.XPATH, xpath = "//a[text()='Create New Purchase Order']")
	private WebElement createPurchaseOrder;
	// navigate to proposal tab
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Proposal')]")
	private WebElement navToProposalTab;
	// click on po image
	@FindBy(how = How.XPATH, xpath = "//img[@title='Create Purchase Order']")
	private WebElement clickPOimage;
	// sales tax drop down
	@FindBy(how = How.XPATH, xpath = "//select[@id='selectedSalesTaxType']")
	private WebElement salesTax;
	// select Agency Doc type
	@FindBy(how = How.XPATH, xpath = "//select[@id='selectedAgencyDocumentationType']")
	private WebElement agencyDocType;
	// select transaction type
	@FindBy(how = How.XPATH, xpath = "//select[@id='selectedTransactionTypeCode']")
	private WebElement transctnType;
	// select agency PO date
	@FindBy(how = How.XPATH, xpath = "//input[@id='agencyPODate']")
	private WebElement agencyPODate;
	@FindBy(how = How.XPATH, xpath = "//*[@id='datepick-div']/div[3]/table/tbody/tr/td/a")
	private List<WebElement> dayOutSelection;
	// quote from company master
	@FindBy(how = How.XPATH, xpath = "//table[@id='ID_1000']/tbody[1]/tr/td[1]/a")
	private List<WebElement> cmpanyMasterQuotes;
	// quote from dealer master
	@FindBy(how = How.XPATH, xpath = "//*[@id='rightColumn']/table[2]/tbody/tr/td[1]/a")
	private List<WebElement> dealerMasterQuotes;

	// Quote ID list on Home Page
	@FindBy(how = How.XPATH, xpath = "//div[@id='normalQuote']//table//tbody//tr//td[@id='quoteId']//a")
	private List<WebElement> quoteIds;
	// Quote Type list on Home Page
	@FindBy(how = How.XPATH, xpath = "//*[@id='normalQuote']//table//tr//td[7]")
	private List<WebElement> quoteType;
	// Customer name on Home Page
	@FindBy(how = How.XPATH, xpath = "//*[@id='normalQuote']//table//tr//td[9]")
	private List<WebElement> customerName;
	// Equipment NAme On Home Page
	@FindBy(how = How.XPATH, xpath = "//*[@id='normalQuote']//table//tr//td[10]")
	private List<WebElement> equipmentModel;
	// Save Quote From Left Panel
	@FindBy(how = How.XPATH, xpath = "//a[text()='Save']")
	private WebElement panelSave;
	// Save Quote From Header
	@FindBy(how = How.XPATH, xpath = "//img[@title='Save']")
	private WebElement headerSave;
	// Select Quote On Home Page
	@FindBy(how = How.XPATH, xpath = "//input[@id='selectedQuotes']")
	private List<WebElement> quoteChkBox;
	// Add To Merge Button
	@FindBy(how = How.XPATH, xpath = "//input[@id='mergeQuotes']")
	private WebElement mergeBtn;
	// Select Quote from Merge Quote Section
	@FindBy(how = How.XPATH, xpath = "//input[@id='selectedMergeQuotes']")
	private List<WebElement> mrgQuoteChkBox;
	// Merge Quotes button
	@FindBy(how = How.XPATH, xpath = "//input[@value='Merge Quotes']")
	private WebElement megQuoteButton;
	// Quote Name
	@FindBy(how = How.XPATH, xpath = "//span[@id='commonQuoteName']")
	private WebElement quoteName;
	// TradeIn name on Home Page
	@FindBy(how = How.XPATH, xpath = "//*[@id='normalQuote']//table//tr//td[11]")
	private List<WebElement> tradeInModel;
	
	// My Quotes Label
		@FindBy(how = How.XPATH, xpath = "//table//thead//tr//th[contains(text(),'My Quotes')]")
		public WebElement myQuotesLbl;
		
		// Sales Dash Board
		@FindBy(how = How.LINK_TEXT, linkText = "Sales Dashboard")
		private WebElement salesDashBoardLnk; 
		// Links section 
		@FindBy(how = How.LINK_TEXT, linkText="Test link")
		public WebElement linkTitle;

	// Copy Quote
	@FindBy(how = How.XPATH, xpath = "//a[text()='Copy']")
	private WebElement copyLnk;

	// Delete Quote
	@FindBy(how = How.XPATH, xpath = "//a[text()='Delete']")
	private WebElement deleteLnk;

	// Download To Excel
	@FindBy(how = How.XPATH, xpath = "//div[@id='normalQuote']//table//thead//tr[@class='action']//td[2]//a[text()='Download to Excel']")
	private WebElement downloadToExcel;

	// Select on DownloadToExcel
	@FindBy(how = How.XPATH, xpath = "//form[@id = 'selectedColumnsForm']//table//thead//tr[2]//th//input[@id='genericAllBox']")
	private WebElement selectAllChkBox;
	// Done on Popup
	@FindBy(how = How.XPATH, xpath = "//form[@id='selectedColumnsForm']//table//thead//following::tfoot//tr[@class='action']//td//input[@value='Done']")
	private WebElement doneBtn;
	//Search Quote Link on Left Navigation
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Search Quotes')]")
	private WebElement searchQuotes;
	@FindBy(how = How.XPATH, xpath = "//*[@id='rightColumn']/h1[contains(text(),'Quote Search')]")
	public WebElement quoteSearchLabel;
	@FindBy(how = How.XPATH, xpath = "//select[@name='selectedQuoteTypeId']")
	private WebElement quoteTypeId;
	@FindBy(how = How.XPATH, xpath = "//input[@name='quoteName']")
	private WebElement quoteNameSearch;
	@FindBy(how = How.XPATH, xpath = "//input[@id='SearchQuote']")
	private WebElement searchQuoteButton;
	// calender image
	private By calenderIcon = By.xpath("//IMG[@class='datepick-trigger']");
	@FindBy(how = How.XPATH, xpath = "//input[@name='modifedStartDate']")
	private WebElement lastModifiedStartDate;
	@FindBy(how = How.XPATH, xpath = "//*[@id='rightColumn']/table[1]/tbody/tr/td[2]/fieldset[2]/table/tbody/tr[1]/td/input[2]")
	private WebElement tradeInRadioButton;
	@FindBy(how = How.XPATH, xpath = "//input[@id='searchDeletedQuotesFlag']")
	private WebElement searchDeletedQuotesCheckbox;
	@FindBy(how = How.XPATH, xpath = "//*[@id='clicktoSearchForAllQuotes']/td[1]/img")
	private WebElement warningImage;

	// Click on Create New Quote Link
	public void clickCreateQuote() {
		CommonFunctions.waitForAnObject(driver, createNewQuoteLink, GlobalThings.microWait);
		CommonFunctions.click(driver, createNewQuoteLink);
		// createNewQuoteLink.click();
	}

	// Create quote from Master link on left
	public void clickCreateFromMaster() throws InterruptedException {
		createFromMaster.click();
		Thread.sleep(5000);
	}

	// SELECT QUOTE FROM DEALER MASTER
	public void slctQuoteFrmDealerMastr() throws InterruptedException {
		int size = dealerMasterQuotes.size();
		int index = CommonFunctions.randomNumberGenerator(size);
		System.out.println("Selected Quote:" + dealerMasterQuotes.get(index).getText());
		dealerMasterQuotes.get(index).click();
		Thread.sleep(8000);
		System.out.println("New Quote Created:" + driver.findElement(By.xpath("//span[@id='commonQuoteID']")).getText());
	}

	// SELECT QUOTE FROM COMPANY MASTER
	public void slctQuoteFrmCompnyMastr() throws InterruptedException {
		int size = cmpanyMasterQuotes.size();
		int index = CommonFunctions.randomNumberGenerator(size);
		System.out.println("Selected Quote:" + cmpanyMasterQuotes.get(index).getText());
		cmpanyMasterQuotes.get(index).click();
		Thread.sleep(5000);
		System.out
				.println("New Quote Created:" + driver.findElement(By.xpath("//span[@id='commonQuoteID']")).getText());
	}

	// click purchase order icon
	public void clickPOSign() throws InterruptedException {
		clickPOimage.click();
		Thread.sleep(10000);
	}

	// ****CBD quote****
	public void salesTax(InputTestDetails inputTestDetails) throws InterruptedException {
		salesTax.click();
		String salesTaxSelection = inputTestDetails.getTestdata()[3].toString();
		System.out.println(salesTaxSelection);
		Thread.sleep(2000);
		CommonFunctions.selectFromDropdown(salesTaxSelection, salesTax);
		Thread.sleep(5000);
	}

	public void agencyDocType(InputTestDetails inputTestDetails) throws InterruptedException {
		agencyDocType.click();
		String agencyDocSelection = inputTestDetails.getTestdata()[4].toString();
		System.out.println(agencyDocSelection);
		Thread.sleep(2000);
		CommonFunctions.selectFromDropdown(agencyDocSelection, agencyDocType);
		Thread.sleep(5000);
	}

	public void transactionType(InputTestDetails inputTestDetails) throws InterruptedException {
		transctnType.click();
		String transctnTypeSelection = inputTestDetails.getTestdata()[5].toString();
		System.out.println(transctnTypeSelection);
		Thread.sleep(2000);
		CommonFunctions.selectFromDropdown(transctnTypeSelection, transctnType);
		Thread.sleep(5000);
	}

	public void agencyPODate() throws InterruptedException {
		agencyPODate.click();
		Thread.sleep(2000);
		int size = dayOutSelection.size();
		int index = CommonFunctions.randomNumberGenerator(size);
		dayOutSelection.get(index).click();
		Thread.sleep(10000);
	}

	// generate CBD/GS PO
	public void generateCBDPO() throws InterruptedException {
		driver.findElement(By.xpath("//img[@src='/JDQuote/images/i_generate.gif']")).click();
		Thread.sleep(10000);
		CommonFunctions.acceptAlert(driver);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@id='sameAsDefaultShippingAddress0']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Done']")).click();
		Thread.sleep(15000);
		String MainWindow = driver.getWindowHandle();
		Set<String> sizeOfWindow = driver.getWindowHandles();
		Iterator<String> iterate = sizeOfWindow.iterator();
		while (iterate.hasNext()) {
			String ChildWindow = iterate.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				Thread.sleep(7000);
				driver.manage().window().maximize();
				System.out.println(driver.switchTo().window(ChildWindow).getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(MainWindow);
		Thread.sleep(7000);
		System.out.println(driver.switchTo().window(MainWindow).getTitle());
		driver.findElement(By.xpath("//a[contains(text(),'Submit to SABD/GS')]")).click();
		Thread.sleep(3000);
		// CommonFunctions.dismissAlert(driver);
		driver.findElement(By.xpath("//button[contains(text(),'NO')]")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//input[@value='Done']")).click();
		Thread.sleep(15000);
		String actual_msg = driver.findElement(By.xpath("//div[@class='rfqmessage error']")).getText();
		System.out.println(actual_msg);
		String expected_msg = "This Purchase Order has been successfully submitted to CBD/GS";
		try {
			Assert.assertEquals(actual_msg, expected_msg);
			System.out.println("Successfully submitted to CBD/GS");
		} catch (Throwable e) {
			System.err.println("Failure:" + e.getMessage());
		}
	}

	// click on Create Purchase Order
	public void clickcreatePrchseOrdr() {
		createPurchaseOrder.click();
	}

	// generate blank demo
	public void generateBlankDemo() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Generate Blank Demo')]")).click();
		Thread.sleep(10000);
	}

	// generate rental agreement
	public void generateBlankRental() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Generate Blank Rental')]")).click();
		Thread.sleep(10000);
	}

	// navigate to proposal tab
	public void naviagteProposalTab() throws InterruptedException {
		navToProposalTab.click();
		Thread.sleep(10000);
	}

	// generate blank PO
	public void generateBlankPO() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Generate Blank PO')]")).click();
		String MainWindow = driver.getWindowHandle();
		Set<String> sizeOfWindow = driver.getWindowHandles();
		Iterator<String> iterate = sizeOfWindow.iterator();
		while (iterate.hasNext()) {
			String ChildWindow = iterate.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				System.out.println(driver.switchTo().window(ChildWindow).getTitle());
				driver.findElement(By.xpath("//input[@name='cwpWarranty']")).click();
				driver.findElement(By.xpath("//input[@name='golfAndTurfWarranty']")).click();
				driver.findElement(By.xpath("//input[@name='golfAndTurfWarranty']")).click();
				driver.findElement(By.xpath("//a[text()='Continue']")).click();
				Thread.sleep(10000);
				System.out.println(driver.switchTo().window(ChildWindow).getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(MainWindow);
		System.out.println(driver.switchTo().window(MainWindow).getTitle());
		Thread.sleep(10000);
	}

	// Select Purchase Type Quote From Quote List
	public void selectPurchaseQuote() {
		// int size = quoteIds.size();
		// System.out.println(size);

		int typeSize = quoteType.size();
		System.out.println(typeSize);

		for (int i = 0; i < typeSize; i++) {
			String expected = "Purchase";
			String actual = quoteType.get(i).getText();
			if (expected.equals(actual)) {
				quoteIds.get(i).click();
				break;
			}

		}

	}

	// Save Quote From Left Panel

	public void panelSaveQuote() {
		if (panelSave.isDisplayed()) {
			panelSave.click();
		}
	}

	// Save Quote From Header icon

	public void headerSaveQuote() {
		if (headerSave.isDisplayed()) {
			headerSave.click();
		}
	}

	public void selectQuotes() {
		int i = 0;
		int size = quoteChkBox.size();
		String quotetype1 = quoteType.get(i).getText();
		quoteChkBox.get(i).click();
		for (int j = 1; j < size; j++) {
			String quotetype2 = quoteType.get(j).getText();
			if (quotetype1.equals(quotetype2)) {
				quoteChkBox.get(j).click();
				break;
			}
		}

	}

	public void mergeQuote() throws InterruptedException {
		mergeBtn.click();
		Thread.sleep(5000);
		int size = mrgQuoteChkBox.size();
		for (int i = 0; i < size; i++) {
			mrgQuoteChkBox.get(i).click();
		}
		megQuoteButton.click();
		CommonFunctions.switchToAlert(driver);
		CommonFunctions.acceptAlert(driver);
		CommonFunctions.switchToParentWindow(driver);
		CommonFunctions.waitForLoad(driver);
		String name = quoteName.getText();
		if (name.startsWith("Merge")) {
			System.out.println("Quote Merge Successful");
		}

		else {
			System.out.println("Quote Merge failed");
		}
	}

	// Selecting quote with has customer, equipment and Trade Ins
	public void selectPurchaseQuoteAndSpecificCustomerNameAndTradeIn() {
		int size = quoteIds.size();
		System.out.println("Number of Quote IDs present on my quote page " + size);

		int typeSize = quoteType.size();
		System.out.println("Number of Quote type present on my quote page " + typeSize);

		for (int i = 0; i < typeSize; i++) {
			String expected = "Purchase";
			String actual = quoteType.get(i).getText();
			String expectedCustomer = "ARB CONSTRUCTIO...";
			String actualCustomer = customerName.get(i).getText();
			String actualEquipment = equipmentModel.get(i).getText();
			String actualTradeIn = tradeInModel.get(i).getText();
			// && actualEquipment.contains("More")
			if (expected.equals(actual) && expectedCustomer.equals(actualCustomer) && actualEquipment.contains("More")
					&& actualTradeIn.contains("More")) {
				quoteIds.get(i).click();
				break;
			}
			System.out.println("Click on quote, which has multiple equipment and trade ins");
		}
	}

	// Selecting quote with has customer, equipment
	public void selectPurchaseQuoteAndSpecificCustomerName() {
		int size = quoteIds.size();
		System.out.println("Number of Quote IDs present on my quote page " + size);

		int typeSize = quoteType.size();
		System.out.println("Number of Quote type present on my quote page " + typeSize);

		for (int i = 0; i < typeSize; i++) {
			String expected = "Purchase";
			String actual = quoteType.get(i).getText();
			String expectedCustomer = "ARB CONSTRUCTIO...";
			String actualCustomer = customerName.get(i).getText();
			String actualEquipment = equipmentModel.get(i).getText();
			// && actualEquipment.contains("More")
			if (expected.equals(actual) && expectedCustomer.equals(actualCustomer)
					&& actualEquipment.contains("More")) {
				quoteIds.get(i).click();
				break;
			}
		}
		System.out.println("Entered to the quote");
	}

	// Copy Quote

	public void copyQuote() throws InterruptedException {
		if (copyLnk.isDisplayed()) {
			copyLnk.click();
			Thread.sleep(20000);
			CommonFunctions.switchToAlert(driver);
			CommonFunctions.acceptAlert(driver);
			CommonFunctions.switchToParentWindow(driver);
			String name = quoteName.getText();
			if (name.startsWith("Copy of")) {
				System.out.println("Quote copied successfully");
			} else {
				System.out.println("Test case failed");
			}
		}
	}

	// Delete Quote

	public void deleteQuote() throws InterruptedException {
		if (deleteLnk.isDisplayed()) {
			deleteLnk.click();
			Thread.sleep(20000);
			CommonFunctions.switchToAlert(driver);
			CommonFunctions.acceptAlert(driver);
		}
	}

	// Download To Excel

	@SuppressWarnings("deprecation")
	public void downloadToExcelFun() throws InterruptedException {

		if (downloadToExcel.isDisplayed()) {
			downloadToExcel.click();
			CommonFunctions.switchToAlert(driver);
			CommonFunctions.acceptAlert(driver);
			Thread.sleep(10000);
			CommonFunctions.switchToChildWindow(driver);
			if (selectAllChkBox.isDisplayed()) {
				selectAllChkBox.click();
			}

			else {
				System.out.println("Pop Up not displayed");
			}
			Thread.sleep(10000);
			CommonFunctions.javaScriptScrollDown(driver, 200);
			Thread.sleep(10000);
			CommonFunctions.downloadFile(driver, doneBtn);

		}
	}
	
	public void verifySalesDashBoard() throws InterruptedException
	{
		Assert.assertTrue(salesDashBoardLnk.isDisplayed(),"Sales Dashboard link not displayed");
		salesDashBoardLnk.click();
		Thread.sleep(20000);
		String title = driver.getTitle();
		Assert.assertTrue(title.equals("John Deere :: JDQuote 2 - Dashboard"), "Issue in loading Sales Dash Board");
	}

// Validate Labels For Validating Transaction Cache Refresh

	public void varifyLabels()
	{
		Assert.assertTrue(myQuotesLbl.getText().equals("My Quotes"), "Translation cache failed");
	}

	public void verifyApplicationSetting()
	{
		Assert.assertTrue(linkTitle.isDisplayed());
	}

	protected void load() {

	}

	@Override
	protected void isLoaded() throws Error {

	}
	
	// Search Quotes link on left Navigation
	public void clickSearchQuote() throws InterruptedException {
		Thread.sleep(2000);
		searchQuotes.click();
		Thread.sleep(5000);
		Assert.assertTrue(quoteSearchLabel.getText().equals("Quote Search"), "There is exception in Quote Search Page");
		
	}
	
	public void searchQuote(InputTestDetails inputTestDetails) throws InterruptedException {
		String quoteName = inputTestDetails.getTestdata()[0];
		String quoteType = inputTestDetails.getTestdata()[1];
		String lastModStartDate = inputTestDetails.getTestdata()[2];
		System.out.println(quoteTypeId.getText());
		quoteNameSearch.clear();
		quoteNameSearch.sendKeys(quoteName);
		CommonFunctions.selectFromDropdownByValue(quoteType, quoteTypeId);
		Thread.sleep(2000);
		lastModifiedStartDate.clear();
		lastModifiedStartDate.sendKeys(lastModStartDate);
		Thread.sleep(3000);
		tradeInRadioButton.click();
		searchDeletedQuotesCheckbox.click();
		searchQuoteButton.click();
		Thread.sleep(5000);
	}

	public void verifySearchQuotePage() {
		Assert.assertTrue(warningImage.isDisplayed(), "There is exception in Quote Search Result Page");
	}

}
