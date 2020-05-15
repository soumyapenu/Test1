package com.deere.pages;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.deere.global.CommonFunctions;
import com.deere.global.CommonFunctions;

public class POPage {

	WebDriver driver;

	public POPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Click On PO sign
	@FindBy(how = How.XPATH, xpath = "//*[@id='rightColumn']//table//tbody//tr//td//a//img[@class='i_purchaseOrder']")
	private WebElement clickOnPOSign;

	// Click on Send To JDF
	private By clickOnSendToJDF = By.xpath("//*[@class='i_send']");

	// Scrolling to Appy To JDF
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Apply to John Deere Financial')]")
	private WebElement scrollToApplyToJDF;

	// Click On confirm on JDF page
	private By clickOnConfirmOnJDF = By.xpath("//input[@value='Confirm']");

	private By selectTradeInOnJDF = By.xpath("//input[@name='radioBtn49177338']");

	private By selectInstallmentOnSENDTOJDF = By
			.xpath("//table[@id='financeOptOffrTable0']//input[@name='radioOffer']");

	// private By sendTOJDFOnPage=By.xpath("//*[@value='Send to John Deere
	// Financial']");

	@FindBy(how = How.XPATH, xpath = "//*[@value='Send to John Deere Financial']")
	private WebElement sendTOJDFOnPage;
	// Select Todays date
	@FindBy(how = How.XPATH, xpath = "//*[@class='datepick-days-cell  datepick-today']")
	private WebElement selectTodaysSignedDate;
	// Select Transaction type on PO page
	@FindBy(how = How.XPATH, xpath = "//*[@id='selectedTransactionTypeCode']")
	private WebElement selectTransactionType;

	// Select Purchaser Type on PO page
	@FindBy(how = How.XPATH, xpath = "//*[@name='selectedPurchaserType']//option")
	private WebElement selectPurchaserType;
	// private By clickOnPOSign=By.xpath("//*[@title='Create Purchase Order']");

	// *[@id="rightColumn"]/font[2]
	@FindBy(how = How.XPATH, xpath = "//*[text()='ERROR OCCURRED - REVIEW YOUR JDMINT C&CE ORDERING PLAN TO CONFIRM INVENTORY RECORDS WERE UPDATED.']")
	private WebElement runTimeErrorText;

	// Generate PO PDF
	@FindBy(how = How.XPATH, xpath = "*//td[@id='rightColumn']//table//tbody//tr[@class='hideForCurrencyConv']//td[3]//a//img[@title='Generate Full PO']")
	private WebElement generatePOPDF;

	//	Select Dealer Account
	@FindBy(how = How.XPATH, xpath = "//*[@id='selectedDealerAccount']")
	private List<WebElement> listOfDealerAccount;

	// Select Country name on PO page
	@FindBy(how = How.XPATH, xpath = "//*[@id='selectedUseCounty']")
	private WebElement selectUseCounty;

	//	List of use county
	@FindBy(how = How.XPATH, xpath = "//*[@id='selectedUseCounty']//option")
	private List<WebElement> listOfSelectUseCounty;

	//	Select State/Province
	@FindBy(how = How.XPATH, xpath = "//*[@id='selectedUseState']")
	private WebElement selectStateProvince;


	//	List of use state?province 
	@FindBy(how = How.XPATH, xpath = "//*[@id='selectedUseState']//option")
	private List<WebElement> listOfStateProvince;

	// Select County Name
	@FindBy(how = How.XPATH, xpath = "//*[@id='rightColumn']//table[@class='details']//tbody//tr//td//input[@name='countyName']")
	private WebElement enterCountyName;

	// Select show detail in pop up
	@FindBy(how = How.XPATH, xpath = "//*[@onload='resizeWindowForManitoba();']//form//table//thead//tr//td//h3//input[@name='poDetailsSelected']")
	private WebElement selectShowdetail;

	// Select CCE Warranty in PO pop up
	@FindBy(how = How.XPATH, xpath = "//*[@onload='resizeWindowForManitoba();']//form//table//thead//tr//td//input[@name='cwpWarranty']")
	private WebElement selectCCEWarranty;

	// Select Golf And Turf Warranty
	@FindBy(how = How.XPATH, xpath = "//*[@onload='resizeWindowForManitoba();']//form//table//thead//tr//td//input[@name='golfAndTurfWarranty']")
	private WebElement selectGolfAndTurfWarranty;

	// Click On Continue button
	@FindBy(how = How.XPATH, xpath = "//*[@onload='resizeWindowForManitoba();']//form//table//thead//tr//th//a[text()='Continue']")
	private WebElement clickoNContinueButton;
	
	// Go back to Quote From PO Page
	@FindBy(how = How.XPATH, xpath = "//a[@href='javascript:goBackToQuote();']")
	private WebElement goBackToQuoteLnk;
	
	// View Purchase Order
	@FindBy(how = How.LINK_TEXT, linkText = "View Purchase Order")
	private WebElement viewPurchaseOrderLnk;
	
	// Click on Send To WorkFlow
	@FindBy(how = How.XPATH, xpath = "//*[text()='Send To Workflow']")
	private WebElement clickoNSendToWorkFlow;

	// Verify Error message for send to workflow
	@FindBy(how = How.XPATH, xpath = "//div[@class='message error']")
	private WebElement verifyErrorMessageforSendToWorkflow;

	// Verify Send to Workflow message
	@FindBy(how = How.XPATH, xpath = "//div[@class='rfqmessage error']")
	private WebElement verifyTextForSend2Workflow;

	// Select sign date
	@FindBy(how = How.XPATH, xpath = "//*[@id='signedDate']")
	private WebElement selectSignedDate;

	// Done button of calendar on PO
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Done')]")
	private WebElement clickOnDoneOFCalendar;

	// Sined PO
	@FindBy(how = How.XPATH, xpath = "//*[text()='Sign']")
	private WebElement signedPO;

	// Generate invoice
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Generate Invoice')]")
	private WebElement generateInvoice;

	// Enter Invoice number
	@FindBy(how = How.XPATH, xpath = "//*[@id='invoiceNumber']")
	private WebElement enterInvoiceNumber;

	@FindBy(how = How.XPATH, xpath = "//*[@id='invoiceDate']")
	private WebElement emterInvoiceDate;

	@FindBy(how = How.XPATH, xpath = "//*[@id='invoiceDocumentForm']//table//tbody//tr//td//input[@name='poDetailsSelected']")
	private WebElement selectShowdetailForInvoiceNumber;

	// Select CCE Warranty in PO pop up
	@FindBy(how = How.XPATH, xpath = "//*[@id='invoiceDocumentForm']//table//tbody//tr//td//input[@name='cwpWarranty']")
	private WebElement selectCCEWarrantyForInvoiceNumber;

	// Select Golf And Turf Warranty
	@FindBy(how = How.XPATH, xpath = "//*[@id='invoiceDocumentForm']//table//tbody//tr//td//input[@name='golfAndTurfWarranty']")
	private WebElement selectGolfAndTurfWarrantyForInvoiceNumber;

	// Click on generate Invoice
	@FindBy(how = How.XPATH, xpath = "//*[@value='Generate Invoice']")
	private WebElement clickOnGenerateInvoice;

	// Click On sold Of PO page
	@FindBy(how = How.XPATH, xpath = "//*[text()='Sold']")
	private WebElement clickOnSold;

	// Revision Signed
	@FindBy(how = How.XPATH, xpath = "//*[@class='i_revise']")
	private WebElement reviseSignedPO;

	// After revising PO, Delete PO
	@FindBy(how = How.XPATH, xpath = "//*[@class='i_delete']")
	private WebElement deletePO;

	// Void PO
	@FindBy(how = How.XPATH, xpath = "//*[text()='Void PO']")
	private WebElement voidPO;

	// Click on Sent To Transaction Pricing
	@FindBy(how = How.XPATH, xpath = "//*[@alt='Send to Transaction Pricing']")
	private WebElement sentToTransactionPricing;

	// Select Transaction Date
	@FindBy(how = How.XPATH, xpath = "//*[@id='transactionDate']")
	private WebElement selectTransactionDate;

	//	TP Page
	@FindBy(how=How.XPATH, xpath="//*[@id='rightColumn']")
	private WebElement transactionPricingPage;

	//	Transaction Pricing Form
	@FindBy(how=How.XPATH, xpath="//form[@name='TransactionPricingForm']")
	private WebElement TransactionPricingForm;

	// Select Current date
	// @FindBy(how=How.XPATH,
	// xpath="//*[@id='datepick-div']//div//table//tbody//tr//td[@class='datepick-days-cell
	// datepick-today']//a")
	// private WebElement selectDate;
	// @FindBy(how=How.XPATH, xpath="//*[@class='datepick-days-cell
	// datepick-today']")
	// private WebElement selectDate;

	private By selectDate = By.xpath("//*[@id='datepick-div']//div[3]//table//tbody//tr//td//a");

	// Click on Continue button on Transaction date
	@FindBy(how = How.XPATH, xpath = "//*[@id='rightColumn']//a[contains(text(),'Continue')]")
	private WebElement continueButton;

	// Expand Equipment on Transaction Pricing page
	@FindBy(how = How.XPATH, xpath = "//tr[@class='leftnav_head1']//td[1]//img")
	private WebElement expandEquipment;

	// Expand Equipment for Selecting Deal
	@FindBy(how = How.XPATH, xpath = "//tr[@class='dealTableRow']//*[@class='dealToggleButton' and @alt='Toggle to show/hide']")
	private WebElement expandEquipmentForDealAndPayment;

	// Select Quote Result
	@FindBy(how = How.XPATH, xpath = "//*[@name='deereDealResult']")
	private WebElement selectDealResult;

	// Select Market Type
	@FindBy(how = How.XPATH, xpath = "//*[@name='dealMarket']")
	private WebElement selectMarketUse;

	// Select Win/Lost Reason
	@FindBy(how = How.XPATH, xpath = "//*[@name='deereSaleReason']")
	private WebElement selectWinLostReason;

	// Select Engine type
	@FindBy(how = How.XPATH, xpath = "//*[@name='engineType']")
	private WebElement selectEngineType;

	// Select Payment Type
	@FindBy(how = How.XPATH, xpath = "//*[@name='deerePaymentType']")
	private WebElement selectPaymentType;

	// Add competitior model
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Add Competitor Model')]")
	private WebElement addCompetitorModel;

	// Enter model Name in competitor model
	// @FindBy(how=How.XPATH, xpath="//input[@name='compModel' and
	// @type='text']")
	// private WebElement enterModelName;

	private By enterModelName = By.xpath("//table[@class='compTable0']//input[@name='compModel' and @type='text']");

	// Select Make for Competitor model
	@FindBy(how = How.XPATH, xpath = "//table[@class='compTable0']//*[@name='compMake']")
	private WebElement selectMake;

	// Select Deal result for competitive model
	@FindBy(how = How.XPATH, xpath = "//table[@class='compTable0']//*[@class='dealResults mandatory']")
	private WebElement selectDealResultForCompetitiveModel;

	// Enter Delaer name
	private By enterDealerName = By.xpath("//table[@class='compTable0']//*[@name='compDealerName']");

	private By enterSalesAmount = By.xpath("//table[@class='compTable0']//*[@name='compSaleAmtPerUnit']");

	// Select Payment type from add competitior model
	// private By
	// enterPaymentTypeFromCompetitiorModel=By.xpath("//td[@class='leftInput']//*[@class='paymentTypeSelect
	// mandatory']");
	@FindBy(how = How.XPATH, xpath = "//table[@class='compTable0']//td[@class='leftInput']//*[@class='paymentTypeSelect mandatory']")
	private WebElement enterPaymentTypeFromCompetitiorModel;

	// Click on Sent To TP
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Send to Transaction Pricing')]")
	private WebElement sentToTransactionPricingOnTPPage;

	// Verify Information regarding Sent To Tp (Success or not)

	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Deal 1: Information updated in Transaction Pricing')]")
	private WebElement actualSentToTP;

	// Back To Quote
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Back To Quote')]")
	private WebElement backToQuote;

	// Verify WorkFlow Status on Summary tab
	@FindBy(how = How.XPATH, xpath = "//div[@id='includedEquipCurtain']//a//b//font")
	private WebElement summ_WorkFlow;

	// Click on Electronic Signature
	@FindBy(how = How.XPATH, xpath = "//div[@class='box_esign positionRel_esign']//img[@src='/JDQuote/images/emailEditIcon.jpg']")
	private WebElement clickOnElectronicSignature;

	//	Electronic Page
	@FindBy(how = How.XPATH, xpath = "//*[@class='poppUp_docusign']")
	private WebElement electronicSignaturePage;

	//	Customer Email address on Electronic Page
	private By enterCustomerEmailAddress =By.xpath("//*[@id='customerEmail']");

	//	Sales Person email address on Electronic Sign Page
	private By enterSalesPersonEmailAddress =By.xpath("//*[@id='salesPersonEmail']");

	//	Customer Email sign Icon
	private By customerEmailSignIcon =By.xpath("//*[@class='customerSignInIcon_esign']");

	//	Sales Person email sign icon
	private By salesPersonEmailSignIcon =By.xpath("//*[@class='salesPersonSignInIcon_esign']");

	//	Click on submit button on  Electronic Signature Page
	private By submitButtonEPage =By.xpath("//*[@id='submitButton']");

	//	Sign Now Page on E sign

	//	private By signNowpage=By.xpath("//*[@class='poppUp_docusign_signNow']");

	@FindBy(how = How.XPATH, xpath = "//*[@class='poppUp_docusign_signNow']")
	private WebElement signNowpage;

	//	Sign Now for Customer 
	private By signNowForCustomer =By.xpath("//*[@id='customerSignNowEnable']");

	//	Docu Sign Page
	@FindBy(how = How.XPATH, xpath = "//div[@class='overlay']")
	private WebElement docuSignpage;

	//	Sign Now for Sales Person

	private By signNowForSalesPerson=By.xpath("//input[@id='salesPersonSignNowEnable']");

	//	Check the checkbox on Docu Sign Page
	private By checkboxOfDocuSignPage =By.xpath("//label[@class='cb_label']");

	//	Click on continue button
	private By continuButtonOnDocuSignPage =By.xpath("//*[contains(text(),'Continue')]");

	//	Click On Start Button
	private By clickOnStartButton =By.xpath("//button[contains(text(),'Start')]");

	//	Required Sign 
	private By requiredSign =By.xpath("//div[@class='tab-content-wrapper']");

	//	Sign on Page
	//	private By drawSign =By.xpath("//div[@class='signature-draw signature']");

	@FindBy(how = How.XPATH, xpath = "//div[@class='signature-draw signature']")
	private WebElement drawSign;

	//	Click On Adopt and Sign
	private By adoptAndSign =By.xpath("//div[@class='footer']//button[1]");

	//	Click On OK
	private By clickOnOK =By.xpath("//*[contains(text(),'OK')]");

	//	Click On Finish on E sign Page
	private By clickOnFinish=By.xpath("//div[@class='visible-inline-xs']//button[contains(text(),'Finish')]");

	//	Click on exit on E sign page
	private By clickOnExit=By.xpath("//input[@id='exit']");

	//	Status of E sign page on PO
	//	private By statusOfESignpage=By.xpath("//div[@id='esign_status_show']");

	@FindBy(how = How.XPATH, xpath = "//div[@id='esign_status_show']")
	private WebElement statusOfESignpage;




	// Verify PO page
	public void generatePO() throws InterruptedException, IOException {

		Thread.sleep(5000);

		// sentToTransactionPricing();

		// Click on PO sign
		CommonFunctions.clickOnElement(driver, clickOnPOSign);

		List<WebElement> listOfDealerAccount = driver.findElements(By.xpath("//*[@id='selectedDealerAccount']//option"));

		for (int i = 2; i <= listOfDealerAccount.size(); i++) {

			List<WebElement> innerOptionsOfDealerAcccount = driver
					.findElements(By.xpath("//*[@id='selectedDealerAccount']//option[" + i + "]"));

			int count = innerOptionsOfDealerAcccount.size();
			System.out.println("Number of dealership present on PO Page "+count);
			if(!innerOptionsOfDealerAcccount.isEmpty()){
				for (int j = 1; j <= count; j++) {
					WebElement values = driver.findElement(
							By.xpath("//*[@id='selectedDealerAccount']//option[" + i + "]"));

					By b = By.xpath("//*[@id='selectedDealerAccount']//option[" + i + "]");

					String a = values.getText().trim();
					System.out.println("Selected Dealer Account is :"+a);


					if (CommonFunctions.isElementExist(driver, b) && CommonFunctions.isElementDisplayed(driver, b)) {
						driver.findElement(b).click();

					} else {
						System.out.println("Dropdown values not displayed for purchaseer type on PO page");
					}

					break;

				}

				break;

			}
			else{
				System.out.println("List is empty for Dealer Account ");
			}

		}

		// Select Transaction type on PO page
		List<WebElement> listOfTransactionType = driver
				.findElements(By.xpath("//*[@id='selectedTransactionTypeCode']//option"));
		System.out.println(listOfTransactionType.size());
		if(!listOfTransactionType.isEmpty()){
			for (int i = 1; i < listOfTransactionType.size(); i++) {

				System.out.println("Name of transaction type is " + listOfTransactionType.get(i).getText());
			}

			CommonFunctions.selectFromDropdown("Cash Sale", selectTransactionType);
		}

		Thread.sleep(5000);

		// Select Purchase Type on PO page
		List<WebElement> listOfPurchaseType = driver
				.findElements(By.xpath("//*[@name='selectedPurchaserType']//optgroup"));
		//
		for (int i = 2; i <= listOfPurchaseType.size(); i++) {

			List<WebElement> innerOptionsOfPurchaserType = driver
					.findElements(By.xpath("//*[@name='selectedPurchaserType']//optgroup[" + i + "]//option"));

			int count = innerOptionsOfPurchaserType.size();
			System.out.println("Number of Purchaser type present on Po page "+count);
			if(!innerOptionsOfPurchaserType.isEmpty()){

				for (int j = 1; j <= count; j++) {
					WebElement values = driver.findElement(
							By.xpath("//*[@name='selectedPurchaserType']//optgroup[" + i + "]//option[" + j + "]"));

					By b = By.xpath("//*[@name='selectedPurchaserType']//optgroup[" + i + "]//option[" + j + "]");

					String a = values.getText().trim();
					System.out.println("Selected purchaser type is :"+a);
					if (CommonFunctions.isElementExist(driver, b) && CommonFunctions.isElementDisplayed(driver, b)) {
						driver.findElement(b).click();

					} else {
						System.out.println("Dropdown values not displayed for purchaseer type on PO page");
					}

					break;

				}

				break;
			}
			else{
				System.out.println("List of purchaser type is empty");
			}
		}
		System.out.println("Purchase Type selected sucessfully on PO page");

		// Select Market Use on PO page
		List<WebElement> listOfMarketUse = driver.findElements(By.xpath("//*[@name='selectedMarketUse']//optgroup"));

		for (int i = 1; i <= listOfMarketUse.size(); i++) {
			List<WebElement> innerOptionsOfMarketUse = driver
					.findElements(By.xpath("//*[@name='selectedMarketUse']//optgroup[" + i + "]//option"));

			int count = innerOptionsOfMarketUse.size();
			System.out.println("Number of Market use present on PO tab "+count);
			if(!innerOptionsOfMarketUse.isEmpty()){
				for (int j = 1; j <= count; j++) {
					WebElement values = driver.findElement(
							By.xpath("//*[@name='selectedMarketUse']//optgroup[" + i + "]//option[" + j + "]"));

					By b = By.xpath("//*[@name='selectedMarketUse']//optgroup[" + i + "]//option[" + j + "]");

					String a = values.getText().trim();
					System.out.println("Selected Market Use is :"+a);
					if (CommonFunctions.isElementExist(driver, b) && CommonFunctions.isElementDisplayed(driver, b)) {
						driver.findElement(b).click();

					} else {
						System.out.println("Dropdown values not displayed for market use on PO page");
					}

					break;

				}

				break;
			}
			else{
				System.out.println("List of Market use is empty");
			}
		}
		System.out.println("Market use selected sucessfully on PO page");

		CommonFunctions.waitForLoad(driver);

		Thread.sleep(3000);

		// Provide county name on PO page
		//		enterCountyName.sendKeys("INDIA");

		//		Select State province on PO page
		Thread.sleep(3000);
		List<WebElement> innerOptionsOfStateProvince=driver.findElements(By.xpath("//*[@id='selectedUseState']//option"));
		
		System.out.println("Number of state/ province present on Po page "+innerOptionsOfStateProvince);
		
		if(innerOptionsOfStateProvince.size()>2){
		for (int i = 2; i <= listOfStateProvince.size(); i++) {

//			List<WebElement> innerOptionsOfStateProvince = listOfStateProvince;

			
			
			
				for (int j = 1; j <= innerOptionsOfStateProvince.size(); j++) {
					WebElement values = driver.findElement(
							By.xpath("//*[@id='selectedUseState']//option[" + i + "]"));

					By b = By.xpath("//*[@id='selectedUseState']//option[" + i + "]");

					String a = values.getText().trim();
					System.out.println("Selected Use state/province  is :"+a);
					if (CommonFunctions.isElementExist(driver, b) && CommonFunctions.isElementDisplayed(driver, b)) {
						driver.findElement(b).click();

					} else {
						System.out.println("Dropdown values not displayed for use state/province");
					}

					break;

				}

				break;

			}}
			else{
				System.out.println("List of state province is empty");
			}
		
		CommonFunctions.explicitWaitClickOn(driver, 5, selectUseCounty);

		CommonFunctions.scrollToElement(driver, selectUseCounty);

		Thread.sleep(5000);

		// Select USE Country on PO page\
		
		List<WebElement> innerOptionsOfUseCounty = driver.findElements(By.xpath("//*[@id='selectedUseCounty']//option"));
System.out.println("Total number of use county present on PO page "+innerOptionsOfUseCounty.size());
if(innerOptionsOfUseCounty.size()>2){		
for (int i = 2; i <= innerOptionsOfUseCounty.size(); i++) {

			

//			int count = innerOptionsOfUseCounty.size();
		
			
				for (int j = 1; j <= listOfSelectUseCounty.size(); j++) {
					WebElement values = driver.findElement(
							By.xpath("//*[@id='selectedUseCounty']//option[" + i + "]"));

					By b = By.xpath("//*[@id='selectedUseCounty']//option[" + i + "]");

					String a = values.getText().trim();
					System.out.println("Selected Use county is :"+a);
					if (CommonFunctions.isElementExist(driver, b) && CommonFunctions.isElementDisplayed(driver, b)) {
						driver.findElement(b).click();

					} else {
						System.out.println("Dropdown values not displayed for use county");
					}

					break;

				}

				break;

			}}
else{
	System.out.println("List of Use county is empty");

			
		}

		//		CommonFunctions.selectFromDropdown("261-VALDEZ-CORDOVA", selectUseCounty);

		//		System.out.println("Use county name is :"+selectUseCounty.getText());




		//		CommonFunctions.selectFromDropdown(" AK-ALASKA ", selectStateProvince);


		//		System.out.println("State/ Provice name is :"+selectStateProvince.getText());
		// Generate PO PDF
		CommonFunctions.clickOnElement(driver, generatePOPDF);

		Thread.sleep(8000);

		// Using only window handle (PO PDF) after clicking on generation pop up

		String MainWindow = driver.getWindowHandle();
		Set<String> sizeOfWindow = driver.getWindowHandles();
		// Assert.assertEquals(actual, expected);("Validation Window is not
		// displayed for option code", 2,sizeOfWindow.size());
		Iterator<String> iterate = sizeOfWindow.iterator();
		while (iterate.hasNext()) {
			String ChildWindow = iterate.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				System.out.println(driver.switchTo().window(ChildWindow).getTitle());
				//
				driver.manage().window().maximize();				
				CommonFunctions.clickOnElement(driver, selectShowdetail);
				Thread.sleep(2000);
				CommonFunctions.clickOnElement(driver, clickoNContinueButton);
				Thread.sleep(5000);
				driver.close();
				// System.out.println(driver.switchTo().window(ChildWindow).getTitle());
				// driver.close();
				driver.switchTo().window(MainWindow);
				Thread.sleep(5000);
				System.out.println(driver.switchTo().window(MainWindow).getTitle());
			}

		}
	}
	
	public void viewPO() throws InterruptedException
	{
		if(goBackToQuoteLnk.isDisplayed())
		{
			goBackToQuoteLnk.click();
			CommonFunctions.explicitWaitWebElement(driver, viewPurchaseOrderLnk);
			viewPurchaseOrderLnk.click();
			CommonFunctions.clickOnElement(driver, generatePOPDF);

			Thread.sleep(8000);

			// Using only window handle (PO PDF) after clicking on generation pop up

			String MainWindow = driver.getWindowHandle();
			Set<String> sizeOfWindow = driver.getWindowHandles();
			// Assert.assertEquals(actual, expected);("Validation Window is not
			// displayed for option code", 2,sizeOfWindow.size());
			Iterator<String> iterate = sizeOfWindow.iterator();
			while (iterate.hasNext()) {
				String ChildWindow = iterate.next();
				if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
					driver.switchTo().window(ChildWindow);
					System.out.println(driver.switchTo().window(ChildWindow).getTitle());
					//
					driver.manage().window().maximize();				
					Thread.sleep(2000);
					CommonFunctions.clickOnElement(driver, clickoNContinueButton);
					Thread.sleep(5000);
					driver.close();
					// System.out.println(driver.switchTo().window(ChildWindow).getTitle());
					// driver.close();
					driver.switchTo().window(MainWindow);
					Thread.sleep(5000);
					System.out.println(driver.switchTo().window(MainWindow).getTitle());
		}
			}
			}
	}


	// Click On sent to workflow

	public void sendToWorkflow() throws InterruptedException {
		Thread.sleep(2000);
		clickoNSendToWorkFlow.click();
		CommonFunctions.acceptAlert(driver);
		Thread.sleep(3000);

	}
	//

	public void signedPO() throws InterruptedException {

		Thread.sleep(2000);

		// Signed PO
		CommonFunctions.clickOnElement(driver, selectSignedDate);

		Thread.sleep(2000);

		// Enter signed date
		selectSignedDate.sendKeys("28-Feb-2020");

		selectSignedDate.sendKeys(Keys.TAB);

		//
		Thread.sleep(2000);
		// clickOnDoneOFCalendar.click();

		System.out.println("Date is selected for signing PO");

		// CLick on PO signed
		try {
			CommonFunctions.clickOnElement(driver, signedPO);

			System.out.println("PO sign successfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Thread.sleep(2000);

	}

	// Click on Generate Invoice
	public void generateInvoice() throws InterruptedException {

		CommonFunctions.clickOnElement(driver, generateInvoice);

		// Handing window of Invoice generator for PO
		String MainWindow1 = driver.getWindowHandle();
		Set<String> sizeOfWindow1 = driver.getWindowHandles();
		// Assert.assertEquals(actual, expected);("Validation Window is not
		// displayed for option code", 2,sizeOfWindow.size());
		Iterator<String> iterate1 = sizeOfWindow1.iterator();
		while (iterate1.hasNext()) {
			String ChildWindow = iterate1.next();
			if (!MainWindow1.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				System.out.println(driver.switchTo().window(ChildWindow).getTitle());
				//
				driver.manage().window().maximize();

				// Select checkboxes from Invoice Generator pop up
				enterInvoiceNumber.sendKeys("1234567890");
				Thread.sleep(2000);
				emterInvoiceDate.sendKeys("04-Dec-2019");
				Thread.sleep(2000);
				CommonFunctions.clickOnElement(driver, selectShowdetailForInvoiceNumber);
				Thread.sleep(2000);
				CommonFunctions.clickOnElement(driver, selectCCEWarrantyForInvoiceNumber);
				Thread.sleep(5000);
				CommonFunctions.clickOnElement(driver, selectGolfAndTurfWarrantyForInvoiceNumber);


				// Generate Invoice
				CommonFunctions.clickOnElement(driver, clickOnGenerateInvoice);
				Thread.sleep(5000);

				driver.close();
				// System.out.println(driver.switchTo().window(ChildWindow).getTitle());
				// driver.close();
				driver.switchTo().window(MainWindow1);
				Thread.sleep(5000);
				System.out.println(driver.switchTo().window(MainWindow1).getTitle());
				System.out.println("Invoice generated successfully");
			}

		}
	}

	public void sendToJDMint() throws InterruptedException {

		String errorText = "ERROR OCCURRED - REVIEW YOUR JDMINT C&CE ORDERING PLAN TO CONFIRM INVENTORY RECORDS WERE UPDATED.";

		// Send To JDMint
		CommonFunctions.clickOnElement(driver, clickOnSold);
		System.out.println("Sold PO");
		Thread.sleep(3000);

		// Compares error message
		try {
			assertEquals(errorText, runTimeErrorText.getText());
			System.out.println("Sold functionality failed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	// errorText.contains("Your Text Here"));

	// Void PO
	// CommonFunctions.clickOnElement(driver, voidPO);
	// CommonFunctions.acceptAlert(driver);
	// System.out.println("PO voided");
	// Thread.sleep(3000);

	// Revision Of Signed Po

	public void revisionSignedPO() throws InterruptedException {
		CommonFunctions.clickOnElement(driver, reviseSignedPO);
		CommonFunctions.acceptAlert(driver);
		System.out.println("Revised Signed PO");
		Thread.sleep(3000);

	}

	// Delete PO
	// String applicationError="";
	// CommonFunctions.clickOnElement(driver, deletePO);
	// CommonFunctions.acceptAlert(driver);
	// System.out.println("Deleted PO");
	// Thread.sleep(5000);

	public void deletePO() {
		try {
			CommonFunctions.clickOnElement(driver, deletePO);
			CommonFunctions.acceptAlert(driver);
			System.out.println("Deleted PO");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	public void validateSentToWorkflow() {
		String status = summ_WorkFlow.getText();

		if (status.contains("Sent"))
			System.out.println(" This Purchase Order has been successfully submitted to WorkFlow ");
		else if (status.contains("Failed"))
			System.out.println("Error occurred whilw sending to workflow");
	}


	//	Electronic Sign of PO
	public void electronicSignPOPage() throws InterruptedException{

		CommonFunctions.clickOnElement(driver, clickOnElectronicSignature);

		CommonFunctions.explicitWaitClickOn(driver, 5, electronicSignaturePage);

		if(electronicSignaturePage.isDisplayed()){

			CommonFunctions.sendKeys(driver, enterCustomerEmailAddress, "kenesanketa@johndeere.com");

			CommonFunctions.sendKeys(driver, enterSalesPersonEmailAddress, "kenesanketa1@johndeere.com");

			CommonFunctions.click(driver, customerEmailSignIcon);

			CommonFunctions.click(driver, salesPersonEmailSignIcon);

			CommonFunctions.click(driver, submitButtonEPage);}



		else{

			System.out.println("Electronic Sign Page is not displayed");
		}

		Thread.sleep(10000);
		if(signNowpage.isDisplayed()){
			CommonFunctions.click(driver, signNowForCustomer);
			System.out.println("Click on Sign Now for Customer");
		}
		else{
			System.out.println("Sign Now Page for Customer is not present");
		}


		Thread.sleep(25000);

		String oldTab = driver.getWindowHandle();

		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		// change focus to new tab
		driver.switchTo().window(newTab.get(1));
		////			    assertAdvertisingBlog();
		//
		//			    // Do what you want here, you are in the new tab
		Thread.sleep(25000);
		System.out.println("Title page of Docu sign  is "+driver.getTitle());
		Thread.sleep(5000);
		CommonFunctions.click(driver, checkboxOfDocuSignPage);

		CommonFunctions.click(driver, continuButtonOnDocuSignPage);

		CommonFunctions.click(driver, clickOnStartButton);

		CommonFunctions.click(driver, requiredSign);

		Thread.sleep(5000);

		CommonFunctions.click(driver, clickOnOK);

		//	CommonFunctions.click(driver, drawSign);

		Actions builder = new Actions(driver);
		Action drawAction = builder.moveToElement(drawSign,135,15) //start points x axis and y axis. 
				.click()
				.moveByOffset(200, 60) // 2nd points (x1,y1)
				.click()
				.moveByOffset(100, 70)// 3rd points (x2,y2)
				.doubleClick()
				.build();
		drawAction.perform();

		CommonFunctions.click(driver, adoptAndSign);

		CommonFunctions.click(driver, clickOnFinish);

		System.out.println("Sign done for customer");

		driver.close();


		driver.switchTo().window(oldTab);

		//			if(docuSignpage.isDisplayed()){	
		//				 String oldTab = driver.getWindowHandle();
		////				    driver.findElement(By.linkText("Twitter Advertising Blog")).click();
		//				    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		////				    newTab.remove(oldTab);
		//				    // change focus to new tab
		//				    driver.switchTo().window(newTab.get(1));
		////				    assertAdvertisingBlog();
		//
		//				    // Do what you want here, you are in the new tab
		//				    
		//				    System.out.println("Title page of create order is "+driver.getTitle());
		//		
		//		CommonFunctions.click(driver, checkboxOfDocuSignPage);
		//		
		//		CommonFunctions.click(driver, continuButtonOnDocuSignPage);
		//		
		//		CommonFunctions.click(driver, clickOnStartButton);
		//		
		//		CommonFunctions.click(driver, requiredSign);
		//		
		//		CommonFunctions.click(driver, clickOnOK);
		//		
		////		CommonFunctions.click(driver, drawSign);
		//		
		//		Actions builder = new Actions(driver);
		//	    Action drawAction = builder.moveToElement(drawSign,135,15) //start points x axis and y axis. 
		//	              .click()
		//	              .moveByOffset(200, 60) // 2nd points (x1,y1)
		//	              .click()
		//	              .moveByOffset(100, 70)// 3rd points (x2,y2)
		//	              .doubleClick()
		//	              .build();
		//	    drawAction.perform();
		//		
		//		CommonFunctions.click(driver, adoptAndSign);
		//		
		//		CommonFunctions.click(driver, clickOnFinish);
		//		
		//		
		//				    
		//				    driver.close();
		//		
		//				    
		//				    driver.switchTo().window(oldTab);
		//			}
		//			else{
		//				System.out.println("Docu sign is not displayed");
		//			}
		Thread.sleep(7000);
		if(signNowpage.isDisplayed()){
			CommonFunctions.click(driver, signNowForSalesPerson);
			System.out.println("Click on sign now for sales person");
		}
		else{
			System.out.println("Click On Sign Now for sales person is not displayed");
		}


		Thread.sleep(15000);

		String oldTab1 = driver.getWindowHandle();
		//				    driver.findElement(By.linkText("Twitter Advertising Blog")).click();
		ArrayList<String> newTab1 = new ArrayList<String>(driver.getWindowHandles());
		//				    newTab.remove(oldTab);
		// change focus to new tab
		driver.switchTo().window(newTab1.get(1));
		//				    assertAdvertisingBlog();
		Thread.sleep(10000);
		// Do what you want here, you are in the new tab

		System.out.println("Title page of create order is "+driver.getTitle());
		Thread.sleep(5000);
		CommonFunctions.click(driver, checkboxOfDocuSignPage);

		CommonFunctions.click(driver, continuButtonOnDocuSignPage);
		Thread.sleep(5000);

		CommonFunctions.click(driver, clickOnStartButton);

		Thread.sleep(10000);
		CommonFunctions.click(driver, requiredSign);
		Thread.sleep(5000);
		CommonFunctions.click(driver, clickOnOK);

		//					CommonFunctions.click(driver, drawSign);

		Actions builder1 = new Actions(driver);
		Action drawAction1 = builder1.moveToElement(drawSign,135,15) //start points x axis and y axis. 
				.click()
				.moveByOffset(200, 60) // 2nd points (x1,y1)
				.click()
				.moveByOffset(100, 70)// 3rd points (x2,y2)
				.doubleClick()
				.build();
		drawAction1.perform();

		CommonFunctions.click(driver, adoptAndSign);

		CommonFunctions.click(driver, clickOnFinish);
		System.out.println("Sign done for the Sales Person");
		driver.close();

		// change focus back to old tab
		driver.switchTo().window(oldTab1);


		CommonFunctions.click(driver, clickOnExit);

		System.out.println("Status of Elctronic Sign on PO Page is "+statusOfESignpage.getText());


		revisionSignedPO();



	}






	// Sent To Transaction pricing
	public void sentToTransactionPricing() throws InterruptedException {
		if(sentToTransactionPricing.isDisplayed()){
			CommonFunctions.clickOnElement(driver, sentToTransactionPricing);

		}
		else{

			System.out.println("Sent To TP button is not displayed on page");
		}
		Thread.sleep(5000);

		if(transactionPricingPage.isDisplayed()){

			System.out.println("Page name is "+driver.getTitle());
			CommonFunctions.clickOnElement(driver, selectTransactionDate);
			Thread.sleep(3000);
			// CommonFunctions.clickOnElement(driver, selectDate);
			CommonFunctions.javaScriptClick(selectDate, driver);
			List<WebElement> selectDeal = driver.findElements(By.xpath("//*[@type='checkbox']"));
			int size = selectDeal.size();
			System.out.println(size);
			int index = CommonFunctions.randomNumberGenerator(size);
			selectDeal.get(index).click();
			CommonFunctions.clickOnElement(driver, continueButton);
			Thread.sleep(5000);}
		else{
			System.out.println("TP Page is not displayed");
		}

		if(TransactionPricingForm.isDisplayed()){


			CommonFunctions.clickOnElement(driver, expandEquipment);
			CommonFunctions.clickOnElement(driver, expandEquipmentForDealAndPayment);
			CommonFunctions.selectFromDropdown("Won", selectDealResult);
			CommonFunctions.selectFromDropdown("Commercial ", selectMarketUse);
			CommonFunctions.selectFromDropdown("Machine Availability", selectWinLostReason);
			CommonFunctions.selectFromDropdown("I4", selectEngineType);
			CommonFunctions.selectFromDropdown("Cash Sale", selectPaymentType);
			CommonFunctions.clickOnElement(driver, addCompetitorModel);
			Thread.sleep(5000);
			CommonFunctions.sendKeys(driver, enterModelName, "420J");
			CommonFunctions.selectFromDropdown("Won", selectDealResultForCompetitiveModel);
			CommonFunctions.selectFromDropdown("Akerman", selectMake);
			Thread.sleep(3000);
			CommonFunctions.sendKeys(driver, enterModelName, "420J");
			CommonFunctions.sendKeys(driver, enterDealerName, "John Deere");
			CommonFunctions.sendKeys(driver, enterSalesAmount, "1000");
			Thread.sleep(5000);
			CommonFunctions.scrollToElement(driver, enterPaymentTypeFromCompetitiorModel);
			CommonFunctions.selectFromDropdown("Cash Sale", enterPaymentTypeFromCompetitiorModel);
			CommonFunctions.clickOnElement(driver, sentToTransactionPricingOnTPPage);
			CommonFunctions.clickOnElement(driver, backToQuote);}

		else{

			System.out.println("Transaction Pricing form page is not displayed");
		}


		WebElement transPricing = driver
				.findElement(By.xpath("//div[@id='includedEquipCurtain']//a[@id='idShowRevisionsLink']"));
		transPricing.click();
		// String statusOfSentToTP = summ_WorkFlow.getText();
		List<WebElement> equipmentDealName = driver
				.findElements(By.xpath("//div[@id='idRevisionSelection']//table//tbody//tr"));
		System.out.println("No of Equipment:" + (equipmentDealName.size() - 2));
		for (int i = 2; i < equipmentDealName.size(); i++) {
			System.out.println("Equipment name in TP pop up:" + equipmentDealName.get(i).getText());
		}
		List<WebElement> statusOfTransactionPricing = driver
				.findElements(By.xpath("//*[@id='idRevisionSelection']//table//tbody//tr//td[3]"));

		for (int i = 2; i < statusOfTransactionPricing.size(); i++) {
			System.out.println("Equipments status " + statusOfTransactionPricing.get(i).getText());
		}
		List<WebElement> equipmentDealKey = driver
				.findElements(By.xpath("//*[@id='idRevisionSelection']//table//tbody//tr//td[5]"));

		for (int i = 2; i < equipmentDealKey.size(); i++) {
			System.out.println("Equipment Deal Key is: " + equipmentDealKey.get(i).getText());
		}

	}

}
