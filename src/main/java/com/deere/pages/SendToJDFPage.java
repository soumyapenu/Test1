package com.deere.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class SendToJDFPage {

	WebDriver driver;


	public SendToJDFPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver =driver;
	}
	
	
	
//	Click On PO sign
	@FindBy(how = How.XPATH, xpath="//*[@id='rightColumn']//table//tbody//tr//td//a//img[@class='i_purchaseOrder']")
	private  WebElement clickOnPOSign;

//	Click on Send To JDF
	private By clickOnSendToJDF=By.xpath("//*[@class='i_send']");

	//Scrolling to Appy To JDF	
	@FindBy(how=How.XPATH, xpath="//*[contains(text(),'Apply to John Deere Financial')]")
	private WebElement scrollToApplyToJDF;
	
//	Click On confirm on JDF page
	private By clickOnConfirmOnJDF=By.xpath("//input[@value='Confirm']");
	
//	private By selectTradeInOnJDF=By.xpath("//input[@name='radioBtn49177338'] OR //*[@name='radioBtn49178477']");
	
	private By selectTradeInOnJDF=By.xpath("//input[@type='radio']");
	
	private By selectInstallmentOnSENDTOJDF=By.xpath("//table[@id='financeOptOffrTable0']//input[@name='radioOffer']");
	
	
//	private By sendTOJDFOnPage=By.xpath("//*[@value='Send to John Deere Financial']");
	
	@FindBy(how = How.XPATH, xpath="//*[@value='Send to John Deere Financial']")
	private  WebElement sendTOJDFOnPage;
	
	String fname="topFrame";
	
	public void sendToJDF() throws InterruptedException{
		
		
		
		CommonFunctions.scrollToElement(driver, scrollToApplyToJDF);
        List<WebElement> selectOnlyOneEquipment=driver.findElements(By.xpath("//input[@type='checkbox']"));
        
        for(int i=1; i<=2; i++){
       	 
       	 if(selectOnlyOneEquipment.get(i).isSelected()){
       	 selectOnlyOneEquipment.get(i).click();
        }
  
        }
		// @formatter:on

		CommonFunctions.click(driver, clickOnSendToJDF);
		
		
		CommonFunctions.click(driver, clickOnConfirmOnJDF);
		
		CommonFunctions.click(driver, selectTradeInOnJDF);
		
		CommonFunctions.click(driver, clickOnConfirmOnJDF);
		
		CommonFunctions.click(driver, selectInstallmentOnSENDTOJDF);
		
		CommonFunctions.click(driver, clickOnConfirmOnJDF);
		
//		CommonFunctions.waitForAnObjectToBeAvailable(driver, sendTOJDFOnPage, 3);
		
		if(sendTOJDFOnPage.isDisplayed()){
			
			sendTOJDFOnPage.click();
			
		}
		

		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1)); //switches to new tab
		
	
		
		CommonFunctions.waitForLoad(driver);
		
		CommonFunctions.switchToFrameWithFrameName(driver, fname);
		
		System.out.println("Verified CERES page as "+driver.getTitle());
		driver.close();
	}
	
}
