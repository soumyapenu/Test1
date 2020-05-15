package com.deere.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.util.PDFTextStripper;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class RecapPage {

	WebDriver driver;

	//BY Manisha Singh----- EE122GH
	
	// private PDFTextStripper pdfStripper;
	private PDDocument pdDoc;
	private COSDocument cosDoc;
	private String Text;

	public RecapPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// navigate to RECAP tab
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Recap')]")
	private WebElement recapTabLink;
	// link for full Recap pdf
	@FindBy(how = How.XPATH, xpath = "//img[@name='Full']")
	private WebElement fullRecapPDF;
	// link for mobile freindly rcap
	@FindBy(how = How.XPATH, xpath = "//img[@title='Mobile Friendly']")
	private WebElement mobileFrndlyRecapPDF;

	// Selling Equipment Section*****************
	@FindBy(how = How.XPATH, xpath = "//input[@name='equipment[0].standardOptionList']")
	private WebElement listPriceBaseJDOption;
	@FindBy(how = How.XPATH, xpath = "//*[@id='sed']/tbody[1]/tr/td[1]")
	private List<WebElement> elmUnderSellingSctn;
	@FindBy(how = How.XPATH, xpath = "//input[@name='equipment[0].netCost']")
	private WebElement totalNetCost;
	// Adjusted Selling Price on Pricing page
	@FindBy(how = How.XPATH, xpath = "//input[@name='displayAdjustmentSellingPrice']")
	private WebElement adjustedSellingPrice;
	// dollar above net cost on Pricing page
	@FindBy(how = How.XPATH, xpath = "//input[@name='dollarAboveNetCost']")
	private WebElement dollarsAbvNetCost;
	// Sales Incentive link 
	@FindBy(how = How.XPATH, xpath = "//input[@name='equipment[0].incentiveTotal']")
	public WebElement salesIncentive;
	// Sales Incentive POP UP
	@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Sales Incentives')]")
	public WebElement salesIncentivePopup;
	// Technology Options
	@FindBy(how = How.XPATH, xpath = "//input[@name='equipment[0].technologyOptions.cost']")
	public WebElement techOptsCP;
	// Technology Options
	@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Technology Options')]")
	public WebElement techOptsCPPopup;
	// Dealer Attachments
	@FindBy(how = How.XPATH, xpath = "//input[@name='equipment[0].dealerAttachments.cost']")
	public WebElement dealerAttachsCP;
	// Dealer Attachments
	@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Dealer Attachment')]")
	public WebElement dealerAttachsCPPopUp;
	// Prepaid VAS In MArgin
	@FindBy(how = How.XPATH, xpath = "//input[@name='equipment[0].serviceAgreements.cost']")
	public WebElement prepaidVASInMarginCP;
	// Prepaid VAS In MArgin
	@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Prepaid Valued Added Service inclu. in margin calc.')]")
	public WebElement prepaidVASInMarginCPPopUp;
	//Included VAS 
    @FindBy(how = How.XPATH, xpath = "//input[@name='equipment[0].serviceAgreements.costOfIncldedPlansEquipments']")
    public WebElement includedVASCP;
  //Included VAS 
    @FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Included Value Added Service.')]")
    public WebElement includedVASCPPopUp;
	// Powergard
	@FindBy(how = How.XPATH, xpath = "//input[@name='equipment[0].serviceAgreements.extendedWarrantyCost']")
	public WebElement powergrdCP;
	// Powergard
		@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'PowerGard ')]")
		public WebElement powergrdCPPopUp;
	
	

	// Determining section***********************
	// Base+ JD Options+ Adjustments Value
	@FindBy(how = How.XPATH, xpath = "//input[@name='equipment[0].adjustedSellingPrice']")
	private WebElement adjustedSPVal;
	// Technology Options Value
	@FindBy(how = How.XPATH, xpath = "//input[@name='equipment[0].technologyOptions.sellingPrice']")
	private WebElement techOptionSPVal;
	// Dealer Attachments/Accessories Value
	@FindBy(how = How.XPATH, xpath = "//input[@name='equipment[0].dealerAttachments.sellingPrice']")
	private WebElement dealerAttchmentSPVal;
	// Prepaid Valued Added Service inclu. in margin calc value
	@FindBy(how = How.XPATH, xpath = "//input[@name='equipment[0].serviceAgreements.list']")
	private WebElement serviceAgrmntWithCPVal;
	// Prepaid Valued Added Service not inclu. in margin calc.value
	@FindBy(how = How.XPATH, xpath = "//input[@name='equipment[0].serviceAgreements.withoutCostList']")
	private WebElement serviceAgrmntWithoutCPVal;
	// Included Value Added Service. Value
	@FindBy(how = How.XPATH, xpath = "(//tr[@class='subItem']//input)[1]")
	private WebElement includedAddedServiceVal;
	// PowerGard(Service Agreement) value
	@FindBy(how = How.XPATH, xpath = "//input[@name='equipment[0].serviceAgreements.extendedWarrantyList']")
	private WebElement extendedWarrantyVal;
	// Total selling price under determining section
	@FindBy(how = How.XPATH, xpath = "//input[@name='equipment[0].totalSellingPrice']")
	private WebElement totalSPDeterSecVal;
	// elements under Determining section
	// @FindBy(how = How.XPATH, xpath =
	// "//*[@id='rightColumn']/div[4]/form/div[1]/table/tbody/tr/td[2]")
	@FindBy(how = How.XPATH, xpath = "//*[@id='rightColumn']/div[4]/form/div[1]/table/tbody/tr/td[2]/input")
	private List<WebElement> elementsValUnderDeterminingSec;
	// Technology Options
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Technology Options')]")
	public WebElement techOptsLP;
	// Technology Options
		@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Technology Options')]")
		public WebElement techOptsLPPopup;
	// Dealer Attachments
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Dealer Attachments/Accessories')]")
	public WebElement dealerAttachsLP;
	// Dealer Attachments
		@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Dealer Attachment')]")
		public WebElement dealerAttachsLPPopUp;
	//Prepaid VAS In Margin
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Prepaid Valued Added Service inclu. in margin calc.')]")
	public WebElement prepaidVASInMarginLP;
	// Prepaid VAS In MArgin
		@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Prepaid Valued Added Service inclu. in margin calc.')]")
		public WebElement prepaidVASInMarginLPPopUp;
	// Prepaid VAS Not In MArgin
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Prepaid Valued Added Service not inclu. in margin calc.')]")
	public WebElement prepaidVASNotInMarginLP;
	// Prepaid VAS Not In MArgin
	@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Prepaid Valued Added Service not inclu. in margin calc.')]")
	public WebElement prepaidVASNotInMarginLPPopUp;
	// Included VAS 
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Included Value Added Service.')]")
	public WebElement includedVASLP;
	// //Included VAS 
    @FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Included Value Added Service.')]")
    public WebElement includedVASLPPopUp;
	// Powergard 
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'PowerGard')]")
	public WebElement powergrdLP;
	// Powergard
	@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'PowerGard ')]")
	public WebElement powergrdLPPopUp;
	// Non Equip VAS In Margin 
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Non Equipment Prepaid Value Added Service inclu. in margin calc.')]")
	public WebElement nonEquipPPInMAr;
	// Non Equip VAS In Margin 
		@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Non Equipment Prepaid Value Added Service inclu. in margin calc.')]")
		public WebElement nonEquipPPInMArPopUp;
	// Non Equip VAS Not In Margin
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Non Equipment Prepaid Value Added Service not inclu. in margin calc.')]")
	public WebElement nonEquipPPNInMar;
	// Non Equip VAS Not In Margin
		@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Non Equipment Prepaid Value Added Service not inclu. in margin calc.')]")
		public WebElement nonEquipPPNInMarPopUp;
	// Non Equip Included VAS
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Non Equipment Included Value Added Service.')]")
	public WebElement nonEquipIncInMargin;
	// Non Equip Included VAS
		@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Non Equipment Included Value Added Service.')]")
		public WebElement nonEquipIncInMarginPopUp;

	// Summary section**************************
	// Fees Link on recap page
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Fees')]")
	private WebElement recapFeesLink;
	// Total Admin Fees
	@FindBy(how = How.XPATH, xpath = "//input[@name='totalAdminFees']")
	private WebElement totalFee;
	// List of Fee Names in Fee table
	@FindBy(how = How.XPATH, xpath = "//tr//td[1]//input[@name='adminFeeName' and @type= 'text']")
	private List<WebElement> feeNames;
	// List of Fee Amount in Fee Table
	@FindBy(how = How.XPATH, xpath = "//tr//td//input[@name='adminFeeAmount' and @type= 'text']")
	private List<WebElement> feeAmounts;
	//Tax Calculator Link on Recap Page 
	@FindBy(how = How.XPATH, xpath = "//a[@id='taxLink']")
	private List<WebElement> taxCalcLink;
	
	//Dealer Notes
		private By dealerNotes = By.xpath("//a[@id='dealerNotesShow']");
		/*@FindBy(how = How.XPATH, xpath = "//a[@id='dealerNotesShow']")
		private WebElement dealerNotes;*/
		//enter dealer notes
		@FindBy(how = How.XPATH, xpath = "//body[@id='tinymce']//p")
		private WebElement enterDealerNotes;
		
		
		//click on dealer notes
		public void clickDealerNotes() throws InterruptedException {
			if (CommonFunctions.isElementExist(driver, dealerNotes)) {
	            driver.findElement(dealerNotes).click();
	        } else {
	            Assert.fail("New Order link didn't displayed");
	        }
		}
		
		//enter dealer notes
		public void enterDealerNotes() throws InterruptedException {
			CommonFunctions.javaScriptScrollDown(driver, 1400);
			CommonFunctions.switchToFramewithId(driver,"dealerNotes1_ifr");		
			Actions actions = new Actions(driver);
			actions.moveToElement(enterDealerNotes);
			actions.click();
			actions.sendKeys("This is a test dealer note . Please Ignore!!");
			actions.build().perform();	
			/*enterDealerNotes.click();
			enterDealerNotes.sendKeys("This is a test dealer ote . Please Ignore!!");
			CommonFunctions.waitForLoad(driver);*/
			
		}

	
	// click on recap tab
	public void clickRecapTab() throws InterruptedException {
		recapTabLink.click();
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(10000);
	}

	// click on full recap pdf icon
	public void clickFullRecaPdf() throws InterruptedException {
		fullRecapPDF.click();
	}

	public void clickOnEqpGoBackToPricngPge() throws InterruptedException {
		driver.findElement(By.xpath("/tr[@class='columnHeaders']//a[1]")).click();
		Thread.sleep(8000);
	}

	// click on mobile recap pdf icon
	public void clickMoblileFrndlyRecaPdf() throws InterruptedException, IOException {
		mobileFrndlyRecapPDF.click();

		String MainWindow = driver.getWindowHandle();
		Set<String> sizeOfWindow = driver.getWindowHandles();
		Iterator<String> iterate = sizeOfWindow.iterator();
		while (iterate.hasNext()) {
			String ChildWindow = iterate.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				System.out.println(driver.switchTo().window(ChildWindow).getTitle());
				driver.findElement(By.xpath("//a[@onclick='submitShowDetails()']")).click();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				verifyPDFisOpened();
				/*
				 * String getURL = driver.getCurrentUrl(); if
				 * (getURL.contains(".pdf")){ System.out.println(getURL); } else
				 * System.out.println("is not a pdf");
				 */
				// readPDF();
				// System.out.println("test");
				driver.close();
			}
		}
		driver.switchTo().window(MainWindow);
		System.out.println(driver.switchTo().window(MainWindow).getTitle());

	}

	public void verifyPDFisOpened() {
		boolean abletoOpenPDF = linkResponse(driver.getCurrentUrl());
		System.out.println(abletoOpenPDF);

	}

	public static boolean linkResponse(String url) {
		try {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestMethod("HEAD");
			return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void readPDF() throws IOException {

		String output = "";
		String getURL = driver.getCurrentUrl();
		Assert.assertTrue(getURL.contains(".pdf"));
		try {
			// String currentUrl = driver.getCurrentUrl();
			URL url = new URL(driver.getCurrentUrl());
			BufferedInputStream fileToParse = new BufferedInputStream(url.openStream());
			// PDFParser parser = new PDFParser(fileToParse);
			PDDocument document = null;

			try {
				document = PDDocument.load(fileToParse);
				output = new PDFTextStripper().getText(document);
				System.out.println(output);
			} finally {
				if (document != null) {
					document.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// *********************SELLING EQUIPMENT DETAIL*****************
	
	// Verify Sales Incentive POP Up
	public void verifyPopUp(WebElement link, WebElement popUp) throws InterruptedException
	{
		link.click();
		Thread.sleep(5000);	
		Assert.assertTrue("Pop Up not displayed", popUp.isDisplayed());
	}
	
	// Adjustment count and their names
	public void comprAdjstmnts() throws InterruptedException {
		List<String> recapSellingSctnList = null;
		recapSellingSctnList = sellingEqpSctnElmList();
		System.out.println("RECAP SELLING SECTION LIST:" + recapSellingSctnList);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@id='sed']/thead[1]/tr[3]/th[2]/a[1]")).click();
		Thread.sleep(10000);
		// clickOnEqpGoBackToPricngPge();
		List<String> finalPricingPageAdjustmentList = adjust1();
		int index = finalPricingPageAdjustmentList.indexOf("Setup MST");
		finalPricingPageAdjustmentList.set(index, "Setup  MST");
		System.out.println("ADJUSTMENT SECTION LIST:" + finalPricingPageAdjustmentList);

		try {
			Assert.assertTrue(recapSellingSctnList.containsAll(finalPricingPageAdjustmentList));
			System.out.println("Adjustments are equal");
		} catch (Throwable e) {
			System.err.println("Adjustments are not equal. " + e.getMessage());
		}

	}

	public void baseJDOptionValidate() throws InterruptedException {
		System.out.println("Value:" + listPriceBaseJDOption.getAttribute("value"));
	}

	public void totalNetCostValidate() throws InterruptedException {
		System.out.println("Value:" + totalNetCost.getAttribute("value"));
	}

	public void comprListPriceFrmPricngPage() throws InterruptedException {
		String listPrice_baseJDOption = listPriceBaseJDOption.getAttribute("value");
		System.out.println(listPrice_baseJDOption);
		// String total_net_cost = totalNetCost.getAttribute("value");
		driver.findElement(By.xpath("//table[@id='sed']/thead[1]/tr[3]/th[2]/a[1]")).click();
		Thread.sleep(10000);
		String pricingPage_LP = driver.findElement(By.xpath("//input[@id='equipmentDeereListPrice']"))
				.getAttribute("value");
		System.out.println(pricingPage_LP);
		try {
			Assert.assertEquals(listPrice_baseJDOption, pricingPage_LP);
			System.out.println("List price on PRICING & RECAP pages is equal");
		} catch (Throwable e) {
			System.err.println("List price on PRICING & RECAP pages is not equal" + e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	public void comprTotalNetCostFrmPricngPage() throws InterruptedException {
		String netCost = CommonFunctions.removeCommaFromStr(totalNetCost.getAttribute("value"));
		double totalNetCost_RecapPage = Double.parseDouble(netCost);
		System.out.println(totalNetCost_RecapPage);
		driver.findElement(By.xpath("//table[@id='sed']/thead[1]/tr[3]/th[2]/a[1]")).click();
		Thread.sleep(10000);
		String adjustdSellingPrc = CommonFunctions.removeCommaFromStr(adjustedSellingPrice.getAttribute("value"));
		double adjusted_seling_price = Double.parseDouble(adjustdSellingPrc);
		System.out.println(adjusted_seling_price);
		String dollarNetCost = CommonFunctions.removeCommaFromStr(dollarsAbvNetCost.getAttribute("value"));
		double dollar_abv_net_cost = Double.parseDouble(dollarNetCost);
		System.out.println(dollar_abv_net_cost);
		double finalNetCost_PricingPage = adjusted_seling_price - dollar_abv_net_cost;
		System.out.println(finalNetCost_PricingPage);
		try {
			assertEquals(totalNetCost_RecapPage, finalNetCost_PricingPage, 0.001);
			System.out.println("List price on PRICING & RECAP pages is equal");
		} catch (Throwable e) {
			System.err.println("List price on PRICING & RECAP pages is not equal" + e.getMessage());
		}
	}

	public List<String> sellingEqpSctnElmList() {
		ArrayList<String> summarySectnElements = new ArrayList<String>();
		for (int i = 1; i <= elmUnderSellingSctn.size(); i++) {
			String path1 = "//*[@id='sed']/tbody[1]/tr[";
			String path2 = "]/td[1]";
			String finalPath = path1 + i + path2;
			System.out.println(driver.findElement(By.xpath(finalPath)).getText());
			summarySectnElements.add(driver.findElement(By.xpath(finalPath)).getText());
		}
		return summarySectnElements;
	}

	public List<String> adjust1() {
		// ArrayList<String> finalAdjusmentList = new ArrayList<String>();
		List<String> adjustmentsList1 = new ArrayList<String>();
		List<WebElement> list1OAdjustments = driver.findElements(By.xpath("//tbody[@id='adjBody']/tr/td[2]"));
		for (int i = 1; i <= list1OAdjustments.size(); i++) {
			String path1 = "//tbody[@id='adjBody']/tr[";
			String path2 = "]/td[2]";
			String finalPath = path1 + i + path2;
			System.out.println(driver.findElement(By.xpath(finalPath)).getText());
			adjustmentsList1.add(driver.findElement(By.xpath(finalPath)).getText());
		}
		adjustmentsList1.addAll(adjust2());
		return adjustmentsList1;
	}

	public List<String> adjust2() {
		// ArrayList<String> finalAdjusmentList = new ArrayList<String>();
		List<String> adjustmentsList2 = new ArrayList<String>();
		List<WebElement> list2OfAdjustments = driver.findElements(By.xpath("//*[@id='adjTable']/tbody[2]/tr/td[2]"));
		for (int i = 1; i < list2OfAdjustments.size(); i++) {
			String path1 = "//*[@id='adjTable']/tbody[2]/tr[";
			String path2 = "]/td[2]";
			String finalPath = path1 + i + path2;
			System.out.println(driver.findElement(By.xpath(finalPath)).getText());
			adjustmentsList2.add(driver.findElement(By.xpath(finalPath)).getText());
		}
		return adjustmentsList2;
	}

	// *********************DETERMINING SELLING PRICE************************
	
	public List<String> elmUnderDeterminingSecWithVal() throws InterruptedException {
		List<String> finalElmsWithVal = new ArrayList<String>();
		System.out.println("Total number of elements prsent " + elementsValUnderDeterminingSec.size());
		for (int i = 0; i < elementsValUnderDeterminingSec.size() - 2; i++) {
			System.out.println(elementsValUnderDeterminingSec.get(i).getAttribute("value"));
			finalElmsWithVal.add(elementsValUnderDeterminingSec.get(i).getAttribute("value"));
		}
		return finalElmsWithVal;
	}

	public double addingValuesUnderDeterminingSec() throws InterruptedException {
		List<String> finalList = elmUnderDeterminingSecWithVal();
		System.out.println("DETERMING SECTION NEW LIST WITH VALUE : " + finalList);
		double totalVal = 0.000;
		for (int i = 0; i < finalList.size(); i++) {
			System.out.println("Value from list : " + finalList.get(i));
			totalVal += Double.parseDouble(CommonFunctions.removeCommaFromStr(finalList.get(i)));
			System.out.println("Value after Addition : " + totalVal);
		}
		return totalVal;
	}

	public void cmprTotalSellingPriceUnderDetermngSec() throws InterruptedException {

		System.out.println(elementsValUnderDeterminingSec.size());
		double total_of_all_elmVal = addingValuesUnderDeterminingSec();
		System.out.println("Total Sum : " + total_of_all_elmVal);
		double total_SP = Double
				.parseDouble(CommonFunctions.removeCommaFromStr(totalSPDeterSecVal.getAttribute("value")));
		System.out.println("Total Selling Price : " + total_SP);
		try {
			assertEquals(total_of_all_elmVal, total_SP, 0.001);
			System.out.println("The sum of all the elements under Determining Sec is equal to Total SP");
		} catch (Throwable e) {
			System.err.println(
					"The sum of all the elements under Determining Sec is not equal to Total SP" + e.getMessage());
		}
	}

	public List<String> equipNames1DeterminingSec() {
		List<String> equipNamesList1 = new ArrayList<String>();
		List<WebElement> equipDetermngNamesList = driver
				.findElements(By.xpath("//*[@id='rightColumn']/div[4]/form/div[1]/table/tbody/tr/td[1]"));
		for (int i = 1; i < equipDetermngNamesList.size(); i++) {
			String path1 = "//*[@id='rightColumn']/div[4]/form/div[1]/table/tbody/tr[";
			String path2 = "]/td[1]";
			String finalPath = path1 + i + path2;
			System.out.println(driver.findElement(By.xpath(finalPath)).getText());
			equipNamesList1.add(driver.findElement(By.xpath(finalPath)).getText());
		}
		return equipNamesList1;
	}

	public List<String> equipNames1SellingSec() {
		List<String> equipNamesList2 = new ArrayList<String>();
		List<WebElement> equipSellingNamesList = driver.findElements(By.xpath("//table[@id='sed']/thead/tr[3]/th"));
		String emptyVal = equipSellingNamesList.get(3).getText();
		for (int i = 1; i < equipSellingNamesList.size() - 1; i++) {
			if (equipSellingNamesList.get(i).getText().length() > 3) {
				System.out.println(equipSellingNamesList.get(i).getText());
				equipNamesList2.add(equipSellingNamesList.get(i).getText());
			}
		}
		return equipNamesList2;
	}

	public void verifyEquipNamesUnderDeterminingSec() throws InterruptedException {
		List<String> equipNamesDeterminingSec = equipNames1DeterminingSec();
		System.out.println("Determining Names : " + equipNamesDeterminingSec);
		Thread.sleep(3000);
		List<String> equipNamesSellingSec = equipNames1SellingSec();
		System.out.println("Selling Equipment Names : " + equipNamesSellingSec);
		Thread.sleep(3000);
		try {
			for (int i = 0; i < equipNamesSellingSec.size(); i++) {
				Assert.assertTrue(equipNamesDeterminingSec.contains(equipNamesSellingSec.get(i)));
				System.out.println(equipNamesSellingSec.get(i) + " is present in both the sections");
			}
		} catch (Throwable e) {
			System.err.println("Equipment Name is missing : " + e.getMessage());
		}
	}

	//**************************SUMMARY SECTION**********************

	public List<String> returnFeeNames() throws InterruptedException {
		List<String> feeListNames = new ArrayList<String>();
		System.out.println("Total number of Fee Name entries : " + feeNames.size());
		for (int i = 0; i < feeNames.size(); i++) {
			//System.out.println(feeNames.get(i).getAttribute("value"));
			feeListNames.add(feeNames.get(i).getAttribute("value"));
		}
		return feeListNames;
	}

	public List<String> returnFeeVal() throws InterruptedException {
		List<String> feeListVal = new ArrayList<String>();
		System.out.println("Total number of Fee Amt Entries : " + feeAmounts.size());
		for (int i = 0; i < feeAmounts.size(); i++) {
			// System.out.println(feeAmounts.get(i).getAttribute("value"));
			feeListVal.add(feeAmounts.get(i).getAttribute("value"));
		}
		return feeListVal;
	}

	public double additionOfFeeAmounts() throws InterruptedException {
		List<String> finalAmountList = returnFeeVal();
		double totalFeeVal = 0.00;
		for (int i = 0; i < finalAmountList.size(); i++) {
			System.out.println("Value from list : " + finalAmountList.get(i));
			totalFeeVal += Double.parseDouble(CommonFunctions.removeCommaFromStr(finalAmountList.get(i)));
			System.out.println("Value after Addition : " + totalFeeVal);
		}
		return totalFeeVal;
	}

	public void validateTotalFeeOnRecapPge() throws InterruptedException {
		recapFeesLink.click();
		Thread.sleep(2000);
		driver.switchTo().frame(1);
		List<String> listOfFeeNames = returnFeeNames();
		System.out.println("Fee Names : " + listOfFeeNames);
		List<String> listOfFeeAmt = returnFeeVal();
		System.out.println("Fee Amount : " + listOfFeeAmt);
		for (int i = 0; i < listOfFeeNames.size(); i++) {
			System.out.println("Fee Name : " + listOfFeeNames.get(i) + ", Fee Amount : " + listOfFeeAmt.get(i));
		}
		double total_of_all_FeeAmt = additionOfFeeAmounts();
		System.out.println("Total Sum : " + total_of_all_FeeAmt);
		double total_admin_fee = Double.parseDouble(CommonFunctions.removeCommaFromStr(totalFee.getAttribute("value")));
		System.out.println("Total Admin Fee : " + total_admin_fee);
		try {
			assertEquals(total_admin_fee, total_of_all_FeeAmt, 0.001);
			System.out.println("The sum total of Fee entries is equal to the Total Admin Fee. ");
		} catch (Exception e) {
			System.err.println("The sum total of Fee entries is not equal to the Total Admin Fee.  " + e.getMessage());
		}

	}

	/*
	 * public void verifyPDFContent() throws InterruptedException, IOException{
	 * 
	 * String currentUrl = driver.getCurrentUrl();
	 * System.out.println(currentUrl); String pdfURL = currentUrl + ".pdf";
	 * System.out.println(pdfURL); URL url = new URL(pdfURL);
	 * System.out.println(url); //File file = new File(currentUrl);
	 * 
	 * InputStream is = url.openStream(); BufferedInputStream fileParse = new
	 * BufferedInputStream(is); PDDocument document = null;
	 * System.out.println("test");
	 * 
	 * // PDFParser parser = new PDFParser(new FileInputStream(file));
	 * 
	 * document =PDDocument.load(fileParse); String pdfContent= new
	 * PDFTextStripper().getText(document); System.out.println(pdfContent);
	 * 
	 * //Assert.assertTrue(pdfContent.contains(""));
	 * 
	 * }
	 */

	/*
	 * public void verifyPDF() throws InterruptedException, IOException{
	 * 
	 * /*PDDocument doc = PDDocument.load(new
	 * File("C:\\Users\\ee122gh\\Downloads\\MaintainRecapServlet.pdf"));
	 * PDFTextStripper pdfStripper = new PDFTextStripper(); String text =
	 * pdfStripper.getText(doc); doc.close(); System.out.println(text); //return
	 * text.contains("");
	 */

	/*
	 * String currentUrl = driver.getCurrentUrl();
	 * System.out.println(currentUrl); String pdfURL = currentUrl + ".pdf";
	 * System.out.println(pdfURL);
	 * 
	 * 
	 * 
	 * PDFTextStripper pdfStripper = null; PDDocument pDoc; COSDocument cDoc;
	 * String parsedText = "";
	 * 
	 * URL url = new URL(pdfURL); System.out.println(url);
	 * 
	 * //File file = new File(); //PDFParser parser = new
	 * PDFParser((RandomAccessRead) new FileInputStream(file));
	 * 
	 * BufferedInputStream file = new BufferedInputStream(url.openStream());
	 * PDFParser parser = new PDFParser((RandomAccessRead) file);
	 * parser.parse(); cDoc = parser.getDocument(); pdfStripper = new
	 * PDFTextStripper(); pdfStripper.setStartPage(1);
	 * pdfStripper.setEndPage(2);
	 * 
	 * pDoc = new PDDocument(cDoc); parsedText = pdfStripper.getText(pDoc);
	 * System.out.println(parsedText); }
	 * 
	 * public void verifyPDFText() throws InterruptedException, IOException{
	 * 
	 * String currentUrl = driver.getCurrentUrl();
	 * System.out.println(currentUrl); String pdfURL = currentUrl + ".pdf";
	 * System.out.println(pdfURL);
	 * 
	 * //URL url = new URL(pdfURL); File file = new File(pdfURL);
	 * 
	 * //InputStream is = url.openStream(); //BufferedInputStream fileParse =
	 * new BufferedInputStream(is); PDFParser fileParse = new
	 * PDFParser((RandomAccessRead) new FileInputStream(file));
	 * 
	 * this.pdfStripper = null; this.pdDoc = null; this.cosDoc = null;
	 * 
	 * //pdDoc = PDDocument.load(new File(pdfURL)); pdDoc = PDDocument.load(new
	 * File(pdfURL)); pdfStripper = new PDFTextStripper();
	 * 
	 * pdDoc.getNumberOfPages(); pdfStripper.setStartPage(1);
	 * pdfStripper.setEndPage(3);
	 * 
	 * Text = pdfStripper.getText(pdDoc); System.out.println(Text);
	 * 
	 * 
	 * /* BufferedInputStream fileToParse = new
	 * BufferedInputStream(url.openStream()); // PDFParser parser = new
	 * PDFParser((RandomAccessRead) fileToParse); // parser.parse(); // //
	 * System.out.println(new
	 * PDFTextStripper().getText(parser.getPDDocument())); // // String output =
	 * new PDFTextStripper().getText(parser.getPDDocument());
	 */

	// }

	/*
	 * public void verifyPDFText1() throws InterruptedException, IOException{
	 * 
	 * String currentUrl = driver.getCurrentUrl();
	 * System.out.println(currentUrl); //String pdfURL = currentUrl + ".pdf";
	 * //System.out.println(pdfURL);
	 * 
	 * //URL url = new URL(pdfURL); //File file = new File(currentUrl);
	 * 
	 * PDFTextStripper pdfStripper = null; PDDocument pdDoc = null; COSDocument
	 * cosDoc = null; // File file = new
	 * File("/Users/Desktop/Corporate reports/previous 'fetch' items/ARM2009.pdf"
	 * ); try { URL url = new URL(currentUrl); BufferedInputStream file = new
	 * BufferedInputStream(url.openStream()); PDFParser parser = new
	 * PDFParser((RandomAccessRead) file); //PDFParser parser = new
	 * PDFParser((RandomAccessRead) new FileInputStream(file)); parser.parse();
	 * cosDoc = parser.getDocument(); pdfStripper = new PDFTextStripper(); pdDoc
	 * = new PDDocument(cosDoc); pdfStripper.setStartPage(1);
	 * pdfStripper.setEndPage(3); String parsedText =
	 * pdfStripper.getText(pdDoc); System.out.println(parsedText); } catch
	 * (IOException e) { // TODO Auto-generated catch block
	 * System.out.println("Failed to parse : " ); } }
	 * 
	 * 
	 */
}
