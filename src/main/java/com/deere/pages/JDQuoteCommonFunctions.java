package com.deere.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.deere.applicaionSpecific.GlobalThings;
import com.deere.global.CommonFunctions;
import com.deere.global.InputEnvironmentDetails;


public class JDQuoteCommonFunctions {
	private By userNametxtbox = By.xpath("//*[@name='username']");
    private By passtxtbox = By.xpath("//*[@name='password']");
    private By actionsOnMPIDrp = By.xpath("//*[contains(text(),'Action')]");
    private By validateMpiDataLnk = By.xpath(".//*[contains(text(),'Validate')]");
    private By Loading = By.xpath(".//*[@id='progress']");
    private By suceesValidateMpiMsg = By.xpath(".//*[contains(text(),'Data Validation for')]");
    private By closeOnPublishMPABtn = By.xpath("//*[@value='Close']");
    private By dataLoadingOnMPI = By.xpath("//*[contains(@id,'dataLoadingDivOverlay')]");
    private By startDateTriggerBtn = By.xpath("//*[contains(@id,'startDate')]/following-sibling::img");
    private static By walkMeCloseBtn = By.xpath("//*[contains(@class,'walkme-action-close')]");
    private By waklMeDoneBtn=By.xpath("//*[contains(@class,'walkme-custom-balloon-button')]/span[text()='Done']");
	private By walkMeOkBtn=By.xpath("//*[contains(@class,'walkme-custom-balloon-button')]/span[text()='OK']");
	
    WebDriver driver;
    public JDQuoteCommonFunctions(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver =driver;
	}
	
   	public void closeWalkMePopUp()
    {
    	if (CommonFunctions.waitForAnObject(driver, walkMeCloseBtn, GlobalThings.microWait)) {
			CommonFunctions.javaScriptClick(walkMeCloseBtn, driver);
			CommonFunctions.waitForAnObjectToBenVisible(driver, walkMeCloseBtn, GlobalThings.microWait);
		}
		if (CommonFunctions.waitForAnObject(driver, walkMeCloseBtn, GlobalThings.microWait)) {
			CommonFunctions.javaScriptClick(walkMeCloseBtn, driver);
			CommonFunctions.waitForAnObjectToBenVisible(driver, walkMeCloseBtn, GlobalThings.microWait);
		}
		
		if(CommonFunctions.isElementExist(driver, waklMeDoneBtn))
		{
			CommonFunctions.click(driver, waklMeDoneBtn);
		}
		if(CommonFunctions.isElementExist(driver, waklMeDoneBtn))
		{
			CommonFunctions.javaScriptClick(waklMeDoneBtn, driver);
		}
		
		if(CommonFunctions.isElementExist(driver, walkMeOkBtn))
		{
			CommonFunctions.javaScriptClick(walkMeOkBtn, driver);
		}if(CommonFunctions.isElementExist(driver, walkMeOkBtn))
		{
			CommonFunctions.click(driver, walkMeOkBtn);
		}
    }
   	
    public void checkMailForStepForward(String pgmName, String msg, InputEnvironmentDetails inputEnvDetails) throws Exception {
    	Thread.sleep(6000);
		if (!CommonFunctions.isElementExist(driver, By.xpath(".//*[contains(@id,'_ariaId_')][1]//*[contains(@class,'SubjectClass')]"))) {
			driver.get("https://outlook.com/owa/johndeere.com");
			if (CommonFunctions.waitForAnObject(driver, userNametxtbox, GlobalThings.minWait)) {
                driver.findElement(userNametxtbox).clear();
                driver.findElement(userNametxtbox).sendKeys(inputEnvDetails.getUsername());
                driver.findElement(passtxtbox).clear();
                driver.findElement(passtxtbox).sendKeys(CommonFunctions.decrypt(inputEnvDetails.getPassword()));
                CommonFunctions.javaScriptClick(By.xpath("//*[@type='submit' and @value='Sign In']"), driver);
            }
			CommonFunctions.waitForAnObject(driver, By.xpath(".//*[contains(@id,'_ariaId_')][1]//*[contains(@class,'SubjectClass')]"), GlobalThings.midWait);
        }
        CommonFunctions.refreshWindow(driver);
        CommonFunctions.waitForAnObject(driver, By.xpath(".//*[contains(@id,'_ariaId_')][1]//*[contains(@class,'SubjectClass')]"), GlobalThings.midWait);
        String mailSubject = CommonFunctions.gettext(driver.findElement(By.xpath(".//*[contains(@id,'_ariaId_')][1]//*[contains(@class,'SubjectClass')]")));
        if (!mailSubject.contains(msg) || !mailSubject.contains(pgmName)) {
            Thread.sleep(GlobalThings.minWait * 1000);
            CommonFunctions.refreshWindow(driver);
            CommonFunctions.refreshWindow(driver);
            CommonFunctions.waitForAnObject(driver, By.xpath(".//*[contains(@id,'_ariaId_')][1]//*[contains(@class,'SubjectClass')]"), GlobalThings.midWait);
            mailSubject = CommonFunctions.gettext(driver.findElement(By.xpath("//*[contains(@id,'_ariaId_')][1]//*[contains(@class,'SubjectClass')]")));
            boolean found = false;
            if (!mailSubject.contains(msg)) {
                for (int i = 1; i <= 10; i++) {
                    mailSubject = CommonFunctions.gettext(driver.findElement(By.xpath("//*[contains(@id,'_ariaId_')][" + i + "]//*[contains(@class,'SubjectClass')]")));
                    if (mailSubject.contains(pgmName) && mailSubject.contains(msg)) {
                        found = true;
                        break;
                    }
                }
                for(int j = 1; j<=5; j++)
                {
                	if (found!=true) {
                        CommonFunctions.refreshWindow(driver);
                        CommonFunctions.refreshWindow(driver);
                        CommonFunctions.refreshWindow(driver);
                        Thread.sleep(GlobalThings.minWait * 1000);
                        CommonFunctions.waitForAnObject(driver, By.xpath(".//*[contains(@id,'_ariaId_')][1]//*[contains(@class,'SubjectClass')]"), GlobalThings.midWait);
                        mailSubject = CommonFunctions.gettext(driver.findElement(By.xpath("//*[contains(@id,'_ariaId_')][1]//*[contains(@class,'SubjectClass')]")));
                        for (int i = 1; i <= 10; i++) {
                            if (CommonFunctions.isElementExist(driver, By.xpath("//*[contains(@id,'_ariaId_')][" + i + "]//*[contains(@class,'SubjectClass')]"))) {
                                mailSubject = CommonFunctions.gettext(driver.findElement(By.xpath("//*[contains(@id,'_ariaId_')][" + i + "]//*[contains(@class,'SubjectClass')]")));
                                if (mailSubject.contains(pgmName) && mailSubject.contains(msg)) {
                                    found = true;
                                    break;
                                }
                            }
                          
                        }
                	}
                		Assert.assertEquals(mailSubject.contains(pgmName), true, msg + "--for--" + pgmName + "--is not displayed");
                        Assert.assertEquals(mailSubject.contains(msg), true, msg + "--for--" + pgmName + "--is not displayed");
                        break;
                }
            }
        }
	}
	
	public void saveAndValidateData(String pgmName , String saveOrValidate) throws InterruptedException{
		String parentWinHandle=null;
		
		if(saveOrValidate.equals("SaveAndValidate")){
			CommonFunctions.waitForAnObject(driver, actionsOnMPIDrp, GlobalThings.microWait);
			CommonFunctions.javaScriptClick(actionsOnMPIDrp, driver);
			if(!CommonFunctions.waitForAnObject(driver, validateMpiDataLnk, GlobalThings.microWait)){
				CommonFunctions.waitForAnObject(driver, actionsOnMPIDrp, GlobalThings.microWait);
				CommonFunctions.click(driver, actionsOnMPIDrp);
				if(!CommonFunctions.waitForAnObject(driver, validateMpiDataLnk, GlobalThings.microWait)){
					CommonFunctions.waitForAnObject(driver, actionsOnMPIDrp, GlobalThings.microWait);
					CommonFunctions.click(driver, actionsOnMPIDrp);
					CommonFunctions.waitForAnObject(driver, validateMpiDataLnk, GlobalThings.microWait);
					CommonFunctions.waitForAnObjectToBeVisible(driver, validateMpiDataLnk, GlobalThings.microWait);
					CommonFunctions.javaScriptClick(validateMpiDataLnk, driver);
				}
			}
			else{
				parentWinHandle = driver.getWindowHandle();
				CommonFunctions.javaScriptClick(validateMpiDataLnk, driver);
				CommonFunctions.waitForAnObjectToBenVisible(driver, Loading, GlobalThings.minWait);
			}
			if(!CommonFunctions.waitForAnObject(driver, suceesValidateMpiMsg, GlobalThings.minWait)){
				try{
					Set<String> winHandles = driver.getWindowHandles();
					for(String handle : winHandles){
						if(!handle.equals(parentWinHandle))
							driver.switchTo().window(handle);
					}
					CommonFunctions.waitForAnObject(driver, closeOnPublishMPABtn, GlobalThings.minWait);
					driver.close();
					driver.switchTo().window(parentWinHandle);
				}
				catch(Exception e){
					driver.switchTo().window(parentWinHandle);
				}
			}
			if(CommonFunctions.isElementExist(driver, dataLoadingOnMPI))
				CommonFunctions.waitForAnObjectToBenVisible(driver, dataLoadingOnMPI, GlobalThings.minWait);
		}
	}
	public void clickOnProgramCrumb(String pgmName) {
	       By pgmNameBreadCrumb = By.xpath(".//*[text() = '"+pgmName+"']");
	        CommonFunctions.waitForAnObject(driver, pgmNameBreadCrumb, GlobalThings.midWait);
	        if (CommonFunctions.isElementExist(driver, pgmNameBreadCrumb))
	            CommonFunctions.javaScriptClick(pgmNameBreadCrumb, driver);
	        if (!CommonFunctions.waitForAnObject(driver, startDateTriggerBtn, GlobalThings.minWait)) {
	            if (CommonFunctions.isElementExist(driver, pgmNameBreadCrumb))
	                CommonFunctions.click(driver, pgmNameBreadCrumb);
	        }
	        if (!CommonFunctions.waitForAnObject(driver, startDateTriggerBtn, GlobalThings.minWait)) {
	            CommonFunctions.refreshWindow(driver);
	            CommonFunctions.waitForAnObject(driver, pgmNameBreadCrumb, GlobalThings.midWait);
	            CommonFunctions.waitForAnObjectToBeAvailable(driver, pgmNameBreadCrumb, GlobalThings.minWait);
	            CommonFunctions.javaScriptClick(pgmNameBreadCrumb, driver);
	        }
	        CommonFunctions.waitForAnObject(driver, startDateTriggerBtn, GlobalThings.minWait);

	    }
}
