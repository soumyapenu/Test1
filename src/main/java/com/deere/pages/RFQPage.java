package com.deere.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

import org.openqa.selenium.JavascriptExecutor;



public class RFQPage {
	WebDriver driver;


	public RFQPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver =driver;
	}
	
	private By enterUsernameForConfigPage=By.xpath("//*[@name='username']");
	
	private By clickOnNext=By.xpath("//*[@value='Next']");
	
	private By selectAgricultureEquipment=By.xpath("//*[contains(text(),'Agriculture')]");
	
	private By selectApplicationEquipment=By.xpath("//*[contains(text(),'Application Equipment')]");
	
	private By clickOnBuild=By.xpath("//button[@ng-if='modelPicker.activeBasecode']");
	
	private By clickOnOptions=By.xpath("//button[contains(text(),'Options')]");
	
	private By clickOnAttachment=By.xpath("//span[contains(text(),'Attachments')]");
	
	private By clickOnSummary=By.xpath("//span[contains(text(),'Summary')]");
	
	private By clickOnNextQuote=By.xpath("//button[contains(text(),'Next: Quote')]");
	
	private By enterZipCode=By.xpath("//input[@name='zipCode']");
	
	private By clickOnFindDealer=By.xpath("//button[contains(text(),'Find Dealer')]");
	
	private By selectDealer=By.xpath("//div[@class='dealer-option']//button[contains(text(),'Select Dealer')]");
	
	private By enterEmail=By.xpath("//input[@name='email']");
	
	private By enterFirstName=By.xpath("//input[@name='firstName']");
	
	private By enterLastName=By.xpath("//input[@name='lastName']");
	
	private By streetAddrss=By.xpath("//input[@name='addressOne']");
	
	public By enterCityName=By.xpath("//input[@name='city']");
	
//	private By enterPostalCode=By.xpath("//input[@name='postalCode']");
	
	private By enterPhone=By.xpath("//input[@name='phone']");
	
	private By checkoboxOfIHaveAtradeIn=By.xpath("//input[@ng-model='quote.hasTradeIn']");
	
	private By checkoboxOfInterestedInFinancial=By.xpath("//input[@ng-model='quote.hasFinanceInterest']");
	
    private By submitMyRequest=By.xpath("//*[contains(text(),'Submit My Request')]");
			
	
	
			
	
	private By impersonateUser=By.xpath("//*[contains(text(),'Impersonate User')]");
	
	@FindBy(how = How.XPATH, xpath = "//select[@name='userSbu']")
	private  WebElement selectSBU;
	
//	private By selectUserType=By.xpath("//select[@name='userType']");
	
	@FindBy(how = How.XPATH, xpath = "//select[@name='userType']")
	private  WebElement selectUserType;
	
	private By enterMaidID=By.xpath("//input[@name='deereMailId']");
	
	private By clickOnBeginImporsonate=By.xpath("//input[@id='beginImpersonation']");
	
	private By clickOnHitachi=By.xpath("//tbody//tr[2]//td//a[contains(text(),'HITACHI')]");
	
//	Select AG_US adding configurator equipment
	@FindBy(how = How.XPATH, xpath = "//tbody//tr[586]//td//a[contains(text(),'hitachi.html')]")
	private  WebElement hitachiHTML;
	
	private By clickOnCompactexcavators=By.xpath("//*[contains(text(),'Compact Excavators')]");
	
	private By expandCompactexcavator=By.xpath("//*[contains(text(),'COMPACT EXCAVATORS')]");
	
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'ZX17U-5 COMPACT EXCAVATOR')]")
	private  WebElement selectEquipmentZX17U5COMPACTEXCAVATOR;
	
	private By buildProductpage=By.xpath("//div[@class='content_area1']");
			
	
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Request a Dealer Quote')]")
	private  WebElement clickOnRequestQuoteLInk;
	
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Request a Dealer Quote')]")
	private  WebElement requestADealerQuote;
	
	private By enterPostalCode=By.xpath("//input[@name='txtZip']");
	
	
	private By searchPostalCode=By.xpath("//input[@id='SearchButton']");
	
	private By selectFirstRadioButton=By.xpath("//input[@type='radio']");
	
	private By enterEmailAddress=By.xpath("//input[@name='txtUserEmail']");
	
	private By sendRequestForQuote=By.xpath("//input[@value='Send']");
	
//	Select Category tractor
//	private By selectCategoryTractor=By.xpath("//*[contains(text(),'Tractors')]");
	
//	Expand 5 Family and Specialty Tractors
	@FindBy (how= How.XPATH, xpath="//*[contains(text(),'5 Family and Specialty Tractors')]") 
	private WebElement expand5FamilyandSpecialtyTractors;
	
	String frame="_atssh861";
	
	public void requestForQuote() throws InterruptedException, AWTException{

		
//		Using robot class, for navigating to new tab
		/*Robot r = new Robot();                          
		r.keyPress(KeyEvent.VK_CONTROL); 
		r.keyPress(KeyEvent.VK_T); 
		r.keyRelease(KeyEvent.VK_CONTROL); 
		r.keyRelease(KeyEvent.VK_T);*/
		
		((JavascriptExecutor)driver).executeScript("window.open()"); 
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1)); //switches to new tab
		
		driver.get("https://configuratorcerttc.deere.com/testAll.html");
		
		CommonFunctions.waitForLoad(driver);
		Thread.sleep(5000);
		CommonFunctions.sendKeys(driver, enterUsernameForConfigPage, "sk07884");
		CommonFunctions.click(driver, clickOnNext);
		
		CommonFunctions.explicitWaitWebElement(driver, selectUserType);
		
		CommonFunctions.click(driver, impersonateUser);
//		
		CommonFunctions.selectFromDropdown("HITACHI", selectSBU);
//		
		CommonFunctions.selectFromDropdown("Retail Customer", selectUserType);
//		
		CommonFunctions.sendKeys(driver, enterMaidID, "kenesanketa@johndeere.com");
		
		
		CommonFunctions.click(driver, clickOnBeginImporsonate);
		
		CommonFunctions.click(driver, clickOnHitachi);
//		
//		CommonFunctions.scrollToElement(driver, agHTML);
//		
		CommonFunctions.clickOnElement(driver, hitachiHTML);
	
		CommonFunctions.click(driver, clickOnCompactexcavators);
		Thread.sleep(5000);
		
		CommonFunctions.click(driver, expandCompactexcavator);
		
		CommonFunctions.clickOnElement(driver, selectEquipmentZX17U5COMPACTEXCAVATOR);
		
//		Thread.sleep(15000);
		
		CommonFunctions.waitForAnObjectToBeAvailable(driver, buildProductpage, 50);
		
		CommonFunctions.waitForLoad(driver);
		
		CommonFunctions.clickOnElement(driver, clickOnRequestQuoteLInk);
		
		CommonFunctions.sendKeys(driver, enterPostalCode, "27529");
		
		CommonFunctions.click(driver, searchPostalCode);
		
		CommonFunctions.click(driver, selectFirstRadioButton);
		
		CommonFunctions.sendKeys(driver, enterEmailAddress, "kenesanketa@johndeere.com");
		
		
		CommonFunctions.click(driver, sendRequestForQuote);
//		
////		CommonFunctions.waitForLoad(driver);
//		
//		CommonFunctions.click(driver, selectAgricultureEquipment);
//		
//		CommonFunctions.click(driver, selectApplicationEquipment);
//		
//		CommonFunctions.click(driver, clickOnBuild);
//		
//		CommonFunctions.click(driver, clickOnOptions);
//		
//		CommonFunctions.click(driver, clickOnAttachment);
//		
//		CommonFunctions.click(driver, clickOnSummary);
//		
//		CommonFunctions.click(driver, clickOnNextQuote);
//		
//		CommonFunctions.sendKeys(driver, enterZipCode, "33430");
//		
//		CommonFunctions.click(driver, clickOnFindDealer);
//		
//		CommonFunctions.click(driver, selectDealer);
//		
//		CommonFunctions.sendKeys(driver, enterMaidID, "kenesanketa@johndeere.com");
//		
//		CommonFunctions.sendKeys(driver, enterFirstName, "Sanket");
//		
//		CommonFunctions.sendKeys(driver, enterLastName, "Kene");
//		
//		CommonFunctions.sendKeys(driver, streetAddrss, "Hadapsar Road");
//		
//		CommonFunctions.sendKeys(driver, enterCityName, "Pune");
//		
//		CommonFunctions.sendKeys(driver, enterPostalCode, "33430");
//		
//		CommonFunctions.sendKeys(driver, enterPhone, "1234567890");
//		
//		CommonFunctions.click(driver, checkoboxOfIHaveAtradeIn);
//		
//		CommonFunctions.click(driver, checkoboxOfInterestedInFinancial);
//		
//		CommonFunctions.click(driver, submitMyRequest);
////		
//		CommonFunctions.click(driver, selectCategoryTractor);
//		
//		CommonFunctions.explicitWaitWebElement(driver, expand5FamilyandSpecialtyTractors);
//		
//		CommonFunctions.clickOnElement(driver, expand5FamilyandSpecialtyTractors);
//		
//		
//		List<WebElement> selectAModel=driver.findElements(By.xpath("//div[@class='column_model' and @id='r1b0']//div[1]//a[1]"));
//		
//		System.out.println("Total number of equipment available are "+selectAModel.size());
//		
//		int count=selectAModel.size();
//		
//		int index=CommonFunctions.randomNumberGenerator(count);
//		
//		selectAModel.get(index).click();
//		
//		Thread.sleep(70000);
////		driver.switchTo().frame(0);
//		//List<WebElement> countFrame=driver.findElements(By.tagName("iframe"));
//		//System.out.println(countFrame.size());
//		
//		List<WebElement> openOptionCode=driver.findElements(By.xpath("//*[@class='option_header']"));
//		System.out.println(openOptionCode.size());
//		
//		
//		for(int i=0; i<openOptionCode.size(); i++){
//			
//			openOptionCode.get(i).click();
//			
//			List<WebElement> selectOptionCode=driver.findElements(By.xpath("//*[@alt='Select this option.']"));
//			
//			int count1 =selectOptionCode.size();
//			
//			System.out.println("Total number of option code" +count1);
//			
//			int index1=CommonFunctions.randomNumberGenerator(count1);
//			
//			selectOptionCode.get(index1).click();
//		}
		
//		
}
	}
