package com.deere.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class CreateOrder{
	
	
	WebDriver driver;


	public CreateOrder(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver =driver;
	}
	
//	Click on sign Create Order
	@FindBy(how = How.XPATH, xpath = "//*[@title='Create Order']")
	private WebElement clickOnCreateOrder;

//	Select equipment for creating order
	@FindBy(how = How.XPATH, xpath = "//*[@type='checkbox']")
	private WebElement selectCheckBoxForCreateOrder;
	
	@FindBy(how = How.XPATH, xpath = "//*[@id='sendToConfiguratorButton']")
	private WebElement clickOnSendToConfigurator;
	
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Review Availability')]")
	private WebElement clickOnReviewAvailability;
//	private By clickOnReviewAvailability=By.xpath("//*[contains(text(),'Review Availability')]"); 
	
//	Click on Create Order on configurator page
	@FindBy(how=How.XPATH, xpath="//*[contains(text(),'Create Order')]")
	private WebElement clickOnCreateOrderOnConfiguratorPage;
	
//	Enter customer name on configurator page
	private By enterCustomerNameOnConfiguratorPage=By.xpath("//input[@id='businessName']"); 
	
//	@FindBy(how=How.XPATH, xpath="//input[@id='customer_businessname']")
//	private WebElement enterCustomerNameOnConfiguratorPage;
	
//	Search customer on Configurator Page
	@FindBy(how=How.XPATH, xpath="//input[@id='searchCust']")
	private WebElement searchCustomerButtonOnConfiguratorPage;
	
//	Select state from dropdown on customer page
	@FindBy(how=How.XPATH, xpath="//div[@id='stateTypeSelect']//*[@name='state']")
	private WebElement selectStateFromDropdownOnCustomerpage;
	
//	Click on search customer
	@FindBy(how = How.XPATH, xpath = "//input[@value='Search Customers']")
	private  WebElement searchButtonOfCustomer;
	
//	Submit Order
	private By clickOnSubmitOrder=By.xpath("//input[@value='Submit Order']"); 	
	
//	Accept all for create order
	private By acceptAllForCreateOrder=By.xpath("//input[@value='ACCEPT ALL']"); 
	
//	Frame name for customer page
	String frameOnCustomerPage="cscsearch";
	
//	Click on Done button of configurator page
	@FindBy(how = How.XPATH, xpath = "//div[@class='hideForD2DQuote']//input[@value='Done']")
	private  WebElement doneButtonOnEquipPageForCreateOrder;
	
	@FindBy(how = How.XPATH, xpath = "//*[@id='rightColumn']//table[3]//tbody//tr//td[12]//a//img")
	private  WebElement orderNumberAndCartNumber;
	
	public void generateCartNumberForOrder() throws InterruptedException{
		
		CommonFunctions.explicitWaitWebElement(driver, clickOnCreateOrder);
		
		CommonFunctions.clickOnElement(driver, clickOnCreateOrder);
		
		
		selectCheckBoxForCreateOrder.sendKeys(Keys.CONTROL +"t");
		
		
	
//		driver.get("https://jdquote2certsuptc.deere.com/MaintainEquipmentServlet");
//	    assertStartAdvertising();

	    // considering that there is only one tab opened in that point.
	    String oldTab = driver.getWindowHandle();
//	    driver.findElement(By.linkText("Twitter Advertising Blog")).click();
	    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
//	    newTab.remove(oldTab);
	    // change focus to new tab
	    driver.switchTo().window(newTab.get(1));
//	    assertAdvertisingBlog();

	    // Do what you want here, you are in the new tab
	    
	    System.out.println("Title page of create order is "+driver.getTitle());

CommonFunctions.clickOnElement(driver, selectCheckBoxForCreateOrder);
		
		CommonFunctions.clickOnElement(driver, clickOnSendToConfigurator);
		
		System.out.println("Title page of shooping cart is "+driver.getTitle());
		
		CommonFunctions.explicitWaitWebElement(driver, clickOnReviewAvailability);
		
		CommonFunctions.clickOnElement(driver, clickOnReviewAvailability);
		
		CommonFunctions.explicitWaitWebElement(driver, clickOnCreateOrderOnConfiguratorPage);
		
		CommonFunctions.clickOnElement(driver, clickOnCreateOrderOnConfiguratorPage);
		
//		CommonFunctions.explicitWaitWebElement(driver, enterCustomerNameOnConfiguratorPage);
		
		
		
		CommonFunctions.clickOnElement(driver, searchCustomerButtonOnConfiguratorPage);
		
		
		
		CommonFunctions.acceptAlert(driver);
		
		CommonFunctions.switchToFrameWithFrameName(driver, frameOnCustomerPage);
		
		System.out.println("Title of customer page is "+driver.getTitle());
		
		CommonFunctions.sendKeys(driver, enterCustomerNameOnConfiguratorPage, "Test");
		
		CommonFunctions.selectFromDropdown("Alabama", selectStateFromDropdownOnCustomerpage);
	    
        CommonFunctions.clickOnElement(driver, searchButtonOfCustomer);
        
        Thread.sleep(5000);
		
//      Select customer randomly from displayed customer
        CommonFunctions.javaScriptScrollDown(driver, 350);
        
        List<WebElement> listOfselectCustomer=driver.findElements(By.xpath("//*[@id='results']//tbody//tr//td[2]//a"));
         int count=listOfselectCustomer.size();
         
         System.out.println("Number of customer found for create order"+count);
       int index= CommonFunctions.randomNumberGenerator(count);
        
        listOfselectCustomer.get(index).click();
        
        Thread.sleep(3000);
        
        CommonFunctions.click(driver, clickOnSubmitOrder);
        
        Thread.sleep(2000);
        CommonFunctions.click(driver, acceptAllForCreateOrder);
        Thread.sleep(2000);
        
	    driver.close();
	    // change focus back to old tab
	    driver.switchTo().window(oldTab);
//	    doneButtonOnEquipPageForCreateOrder.sendKeys(Keys.CONTROL +"t");
	    Thread.sleep(5000);
	    CommonFunctions.scrollToElement(driver, doneButtonOnEquipPageForCreateOrder);
	    
	    CommonFunctions.clickOnElement(driver, doneButtonOnEquipPageForCreateOrder);
	   
	    String cartAndOrderNumbertext=orderNumberAndCartNumber.getAttribute("title");
	    
	    System.out.println("Order number and car number"+cartAndOrderNumbertext);
	    StringBuffer getOrderAndCarNumber=new StringBuffer(cartAndOrderNumbertext);
	    
	    StringBuffer alpha = new StringBuffer(),  
	            num = new StringBuffer(), special = new StringBuffer(); 
	              
	            for (int i=0; i<getOrderAndCarNumber.length(); i++) 
	            { 
	                if (Character.isDigit(getOrderAndCarNumber.charAt(i))) 
	                    num.append(getOrderAndCarNumber.charAt(i)); 
	                else if(Character.isAlphabetic(getOrderAndCarNumber.charAt(i))) 
	                    alpha.append(getOrderAndCarNumber.charAt(i)); 
	                else
	                    special.append(getOrderAndCarNumber.charAt(i)); 
	            } 
	           
//	            System.out.println(alpha); 
	            System.out.println(num);
	            System.out.println("CART NUMBER IS "+num.substring(0,8));
	            System.out.println("Order numbetr is "+num.substring(8, 16));
//	            System.out.println(special); 
//	    assertStartAdvertising();

	    // Do what you want here, you are in the old tab
	}
	}
	

