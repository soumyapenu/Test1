package com.deere.pages;

import java.io.BufferedInputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.deere.global.CommonFunctions;


public class ValueAddedServicesPage {
	
	WebDriver driver;
	HomePage homePage;
	EquipmentPage equipmentPage;
	
	
	public ValueAddedServicesPage(WebDriver driver) {
		equipmentPage = new EquipmentPage(driver);
		homePage = new HomePage(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
// Value Added Services Tab
	@FindBy(how = How.XPATH, xpath = "//div[@class='tabs']//ul//li//a[contains(text(),'Value Added Services')]")
	public WebElement valueAddedServicesTab;
	
// Travel Type DropDown
	@FindBy(how = How.XPATH, xpath = "//select[@id='type']")
	public WebElement travelTypeDrpDwn;
	
// Total count of Agreements
	@FindBy(how = How.XPATH, xpath = "//div[starts-with(@id,'totalCount')]")
	public List<WebElement> agreementCount;
	
// Equipment Carot To View Agreements
	@FindBy(how = How.XPATH, xpath = "//span[starts-with(@id,'firstHead')]")
	public List<WebElement> agreementCarot;
	
// Accepted Button
	@FindBy(how = How.XPATH, xpath = "//input[starts-with(@id,'acceptButton')]")
	public List<WebElement> acceptedBtn;
	
// Accepted Count
    @FindBy(how = How.XPATH, xpath = "//div[starts-with(@id,'acceptedCount')]")
	public List<WebElement> acceptedCount;
// Declined Button
    @FindBy(how = How.XPATH, xpath = "//input[starts-with(@id,'declinedButton')]")
	public List<WebElement> declinedBtn; 
// Declined Count
    @FindBy(how = How.XPATH, xpath = "//div[starts-with(@id,'declinedCount')]")
   	public List<WebElement> declinedCount; 
    
// Agreed Price of Agreements
    @FindBy(how = How.XPATH, xpath = "//input[starts-with(@id,'agreedPrice')and(@name='agreedPrice')]")
    public List<WebElement> agreementAgreedPrice;
    
 // Total Agreed Price of Non Equipment Services
    @FindBy(how = How.XPATH, xpath = "//p[starts-with(@id,'totalAccepted')]")
    public WebElement nonEquipTotAgreedPrice;
    
 // Total Agreed Price of Equipment Services
    @FindBy(how = How.XPATH, xpath = "//div[starts-with(@id,'totalAccepted')]")
    public List<WebElement> equipTotAgreedPrice;
    
 // Total Agreed Price of Non Equipment Services
    @FindBy(how = How.XPATH, xpath = "//div[@id='dueAtInvoiceDiv']")
    public WebElement totalDue;
    
 // Total Agreed Price of Non Equipment Services
    @FindBy(how = How.XPATH, xpath = "//img[@name='toolIMG']")
    public WebElement totalDueCarot;
    
 // Total Agreed Price of Non Equipment Services
    @FindBy(how = How.XPATH, xpath = "//div[@id='prepaidTotalDiv']")
    public WebElement prepaidValue;
    
 // Total Agreed Price of Non Equipment Services
    @FindBy(how = How.XPATH, xpath = "//div[@id='taxPartsTotalDiv']")
    public WebElement partsTax;
    
 // Total Agreed Price of Non Equipment Services
    @FindBy(how = How.XPATH, xpath = "//div[@id='taxLaborTotalDiv']")
    public WebElement laboutTax;
    
 // Total Agreed Price of Non Equipment Services
    @FindBy(how = How.XPATH, xpath = "//div[@id='taxTravelTotalDiv']")
    public WebElement travelTax;
    
 // Total Agreed Price of Non Equipment Services
    @FindBy(how = How.XPATH, xpath = "//div[@id='totalDueDiv']")
    public WebElement totalTax;
    
 // Extended List Of PGP
    @FindBy(how = How.XPATH,xpath = "//td[starts-with(@id,'pgpExtendedListPrice')]")
    public WebElement pgpExtendedList;
    
// PowerGard Protection Plan Link
    @FindBy(how = How.XPATH, xpath = "//a[contains(text(),' PowerGard Protection Plan ')]")
    public WebElement pgpCalculator;
    
// Options On PGp Calculator
    @FindBy(how = How.XPATH, xpath = "//a[@class='row-fluid no-margin pointer product-list link-item ng-scope ng-binding first']")
    public WebElement pgpOptions;
    
// Plan Table
    @FindBy(how = How.XPATH, xpath = "//div[@id='planTermTbl']")
    public WebElement pgpPlanTable;
    
 // Plan On PGp Calculator
    @FindBy(how = How.XPATH, xpath = "//input[@name='selectPlanTerm']")
    public List<WebElement> pgpPlan;
    
 // Add Pricing Button On PGP Calculator
    @FindBy(how = How.XPATH, xpath = "//button[contains(text(),'Add Pricing')]")
    public WebElement pgpAddPricingBtn; 
    
// Protection Fees From PGP Calculator
    @FindBy(how = How.XPATH, xpath = "//*[@id='planTermTbl']//div[2]//div//div[3]//div[5]")
    public WebElement pgpProtectionFees; 
    
// Agreement Name
    @FindBy(how = How.XPATH, xpath = "//a[@class='standAloneData']")
    public List<WebElement> agreementName; 
    
 // Service Agreement Tab
    @FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Service Agreements')]")
    public WebElement serviceAgreementsTab;
    
// Powergard Protection Calculator Of Non SVAP Dealer / R2
    @FindBy(how = How.XPATH, xpath = "//a[contains(text(),'PowerGard Protection')]")
    public WebElement r2PGPCalculator;

// Powergard Maintenance Calculator of Non SVAP Dealer/R2
    @FindBy(how = How.XPATH, xpath = "//a[contains(text(),'PowerGard Maintenance')]")
    public WebElement r2PGMaintenanceCalculator;
	
    public void navigateToVASTab()
	{ 
		if(valueAddedServicesTab.isDisplayed())
			valueAddedServicesTab.click();
		if(travelTypeDrpDwn.isDisplayed())
		    System.out.println("Susccessfully landed on VAS tab");
		
	}
    
    public void navigateToServiceAgreementsTab()
    {
    	if(serviceAgreementsTab.isDisplayed())
    		serviceAgreementsTab.click();
    }
	
	
	// Verify Agreements and Decline One
	
	public void verifyAgreementsAndChangeStatus(List<WebElement> statusCount, List<WebElement> statusBtn) throws InterruptedException
	{
		List <WebElement> stsCount = statusCount;
		List <WebElement> stsBtn = statusBtn;
		
		
		int totAgreementSections = agreementCount.size();
		System.out.println("Agreement sections:"+totAgreementSections);
		int agrcount = 0;
		int counter = 0;
		for(int i=0; i<totAgreementSections; i++ )
		{
			String agreementcount;
			String statuscount;
			agreementcount = agreementCount.get(i).getText();
			statuscount = statusCount.get(i).getText();
			int count = Integer.parseInt(statuscount);
			System.out.println("Number of Agreements available:"+agreementcount);
			System.out.println("Number of Agreements Accepted/Declined by default:"+statuscount);
			
			if(!agreementcount.equals("0"))
			{
				agreementCarot.get(i).click();
				
				for(int j=0;j< Integer.parseInt(agreementcount);j++)
				{  
					statusBtn.get(agrcount).click();
					boolean flag = CommonFunctions.isAlertPresent(driver);
				 
				  if(!flag)
				  {
					
					homePage.headerSaveQuote();
					Thread.sleep(10000);			
					count++;
					String actual = statusCount.get(i).getText();
					int actualCount = Integer.parseInt(actual);
					
					
					if(actualCount==count)
						System.out.println("Agreement status changed Successfully");
					else
						System.out.println("Agreement status changed Failed");
					agrcount = Integer.parseInt(agreementcount);
					break;
				}
				  else
				  {
					CommonFunctions.acceptAlert(driver);
					agrcount++;
				  }	
			}
			
			counter = counter + Integer.parseInt(agreementcount);
			agrcount = counter;
			
			}
			else
			{
				System.out.println("No Agreements Available");
			}
			
		}
	}
	
	// Validate PGP Calculator
	
	public void validatePGPCalculator() throws InterruptedException
	{
		int totAgreementSections = agreementCount.size();
		System.out.println("Agreement sections:"+totAgreementSections);
		int agrcount =0;
		int counter = 0;
		for(int i=0; i<totAgreementSections; i++ )
		{
			String agreementcount;
			String statuscount;

			agreementcount = agreementCount.get(i).getText();
			System.out.println("Number of Agreements available:"+agreementcount);
			agrcount = agrcount+ Integer.parseInt(agreementcount);
			if(i==totAgreementSections-1)
				break;
			
			else if(!agreementcount.equals("0"))
			{
				agreementCarot.get(i).click();
				
					if(pgpCalculator.isDisplayed())
					{
						   pgpCalculator.click();	   
						   CommonFunctions.switchToChildWindow(driver);
						   CommonFunctions.switchToFrameWithFrameName(driver, "powergard-calculator-iframe");
						   Thread.sleep(10000);
						   for(int j=0;j<3;j++)
						   {
							Thread.sleep(10000);
							pgpOptions.click();															
						   }
							Thread.sleep(10000);
								 if(pgpPlan.get(1).isEnabled())
								   {
									String protectionFees = pgpProtectionFees.getText();
									pgpPlan.get(1).click();									
									if(pgpAddPricingBtn.isDisplayed())
									{
										pgpAddPricingBtn.click();
										CommonFunctions.switchToParentWindow(driver);
										int pf = CommonFunctions.convertStringToInt(protectionFees);
										System.out.println(pf);
										String extendList = pgpExtendedList.getText();
										if(extendList.contains(","))
											extendList = extendList.replaceAll(",", "");
										if(extendList.contains("."))
											extendList = extendList.replace(".", "");
										int el = CommonFunctions.convertStringToInt(extendList);
										el = el/100;
										System.out.println(el);
										if(pf==el)
											System.out.println("PGP plan successfully added");
										else
											System.out.println("PGP value is not correct");
									}
									else
										System.out.println("Add Pricing button is not present");
							   }
						     }
					else
					{
						System.out.println("PGP Calculator does not exist");
					}
							
							}
						   }
					
					
					
					}
					
	
	// Validate Total Agreed Price of Accepted Agreements of Individual equip and Non Equip
	
	public void verifyTotlDueAndAgrdPrice()
	{ 
		double price = 0;
		int agrcount = 0;
		int counter = 0;
		int size = agreementCount.size();
		System.out.println("Agreement Sections:"+size);
		for(int i=0; i<size; i++ )
		{
			String agreementcount;
			String statuscount;
			agreementcount = agreementCount.get(i).getText();
			System.out.println("Number of Agreements available:"+agreementcount);
			if(!agreementcount.equals("0"))
			{
				agreementCarot.get(i).click();
				for(int j=0;j< Integer.parseInt(agreementcount);j++)
				{  
					acceptedBtn.get(counter).click();
					boolean flag = CommonFunctions.isAlertPresent(driver);
					if(flag)
					{
						CommonFunctions.acceptAlert(driver);
						String agrdprice = agreementAgreedPrice.get(counter).getAttribute("value");
						System.out.println("Agreed Price is: "+agrdprice);
						price = price+Double.parseDouble(agrdprice);
						System.out.println("Total Agreed Price is: "+price);
					}
					else
					{
						acceptedBtn.get(counter).click();
						counter++;
						
					}
						
				}
				if(i==size-1)
				{
					String s = nonEquipTotAgreedPrice.getText();
					StringBuffer totPri = CommonFunctions.separateDigitsFromString(s);
					double totalPrice = Double.parseDouble(totPri.toString());
					totalPrice = totalPrice/100;
					System.out.println(totalPrice);
					if(totalPrice==price)
						System.out.println("Total Agreed Price Calculated corrctly");
					else
						System.out.println("Total Agreed Price is calculated wrongly");
					
				}
				
				else
				{
					String s = equipTotAgreedPrice.get(i).getText();
					StringBuffer equiptotPri = CommonFunctions.separateDigitsFromString(s);
					System.out.println(equiptotPri);
					double totalPrice = Double.parseDouble(equiptotPri.toString());
					totalPrice = totalPrice/100;
					System.out.println(totalPrice);
					if(totalPrice==price)
						System.out.println("Total Agreed Price Calculated corrctly");
					else
						System.out.println("Total Agreed Price is calculated wrongly");
				}
				}
			price = 0;
			counter = Integer.parseInt(agreementcount);
	        }
        }
	
	// Validate Total due calculation
	
	public void verifyTotalDueCalc()
	{
		int size = agreementCount.size();
		double totalPrice = 0;
		double nonTotPrice = 0;
		System.out.println("Agreement Sections:"+size);
		for(int i=0; i<size-1; i++ )
		{
			String s = equipTotAgreedPrice.get(i).getText();
			StringBuffer equiptotPri = CommonFunctions.separateDigitsFromString(s);
			System.out.println(equiptotPri);
			totalPrice = totalPrice+Double.parseDouble(equiptotPri.toString());
			totalPrice = totalPrice/100;
			System.out.println(totalPrice);
		}
		
		String s = nonEquipTotAgreedPrice.getText();
		StringBuffer totPri = CommonFunctions.separateDigitsFromString(s);
		nonTotPrice = nonTotPrice+Double.parseDouble(totPri.toString());
		nonTotPrice = nonTotPrice/100;
		System.out.println(nonTotPrice);
		
		double summation = totalPrice+nonTotPrice;
		totalDueCarot.click();
		String prepaid = prepaidValue.getText();
		StringBuffer pre = CommonFunctions.separateDigitsFromString(prepaid);		
		double prepaidPrice = Double.parseDouble(pre.toString());
		prepaidPrice = prepaidPrice/100;
		if(summation==prepaidPrice)
		{
			System.out.println("Total Service Agreements Calculated correctly.");
			String parts = partsTax.getText();
			String labour = laboutTax.getText();
			String travel = travelTax.getText();
			String totDue = totalDue.getText();
			StringBuffer part = CommonFunctions.separateDigitsFromString(parts);
			StringBuffer lab = CommonFunctions.separateDigitsFromString(labour);
			StringBuffer trvl = CommonFunctions.separateDigitsFromString(travel);
			StringBuffer totaldue = CommonFunctions.separateDigitsFromString(totDue);
			double partsPrice = Double.parseDouble(part.toString());
			partsPrice=partsPrice/100;
			double labourPrice = Double.parseDouble(lab.toString());
			labourPrice=labourPrice/100;
			double travelPrice = Double.parseDouble(trvl.toString());
			travelPrice=travelPrice/100;
			double totDuePrice = Double.parseDouble(totaldue.toString());
			totDuePrice = totDuePrice/100;
			double calcTotalDue = prepaidPrice+partsPrice+labourPrice+travelPrice;
			
			if(totDuePrice==calcTotalDue)
				System.out.println("Total Due calculated Correctly");			
		}
		
		
		
		
	}
	
	// verify PGP Calculator Of R2
	
	public void verifyR2PGPCalc() throws InterruptedException
	{
		equipmentPage.clickOnEquipmentTab();
		Thread.sleep(2000);
		int equiplist = equipmentPage.equipmentList();
		if(equiplist>0)
		{
			navigateToServiceAgreementsTab();
			Assert.assertTrue(r2PGPCalculator.isDisplayed());
			r2PGPCalculator.click();
			Thread.sleep(60000);
			CommonFunctions.switchToChildWindow(driver);
			String actual = driver.getCurrentUrl();
			String output = "";
			System.out.println(actual);
			Assert.assertTrue(actual.contains(".pdf"));
            System.out.println("PGP Calculator opened successfully");
			
		}
		
	}
	
// Powergard Maintenance Calculator of R2 - r2PGMaintenanceCalculator
	
	public void verifyR2PGMaintenancePCalc() throws InterruptedException
	{
		equipmentPage.clickOnEquipmentTab();
		Thread.sleep(2000);
		int equiplist = equipmentPage.equipmentList();
		if(equiplist>0)
		{
			navigateToServiceAgreementsTab();
			Assert.assertTrue(r2PGMaintenanceCalculator.isDisplayed());
			r2PGMaintenanceCalculator.click();
			Thread.sleep(60000);
			CommonFunctions.switchToChildWindow(driver);
			String actual = driver.getCurrentUrl();
			System.out.println(actual);
			Assert.assertTrue(actual.contains("MaintenanceCalcWeb/DirectLink"));
            System.out.println("PGP Maintenance Calculator opened successfully");
			
		}
		
	}

    }
	
