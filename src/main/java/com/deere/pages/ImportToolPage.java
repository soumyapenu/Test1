package com.deere.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.deere.applicaionSpecific.GlobalThings;
import com.deere.global.CommonFunctions;
import com.deere.global.InputEnvironmentDetails;

public class ImportToolPage {
	
	
	WebDriver driver;
	public ImportToolPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	private By importTranslationsDataLink=By.xpath("//li/*[text()='Import Translations Data']");
	private By workgrpNoteSelectToImport=By.xpath("//label[text()='Workgroup Notes']/preceding-sibling::input");
	private By wholegoodProgramSelect=By.xpath("//*[contains(text(),'Whole Goods Program')]/preceding-sibling::input[@type='radio']");
	private By attachDescSelect=By.xpath("//label[text()='Attachment Descriptions']/preceding-sibling::input");
	private By prodStructSelect=By.xpath("//label[text()='Product Structure']/preceding-sibling::input");
	private By importWholegoodsDataLnk = By.xpath("//li/*[text()='Import Whole Goods Data']");
	private By selectMPIRadioBtn = By.xpath("//*[contains(text(),'MPI Data')]/preceding-sibling::input[@type='radio']");
	private By chooseFileButton = By.xpath("//*[@class='divCell textAlignLeft']/input[@name='files']");
	private By submitButton = By.xpath("//*[@id='multi-post']");
	private By homeButton = By.xpath(".//*[@id='navBg']//following::a[@href='#home']/img");
	private By importToolLink=By.xpath("//*[text()='Import Tool']");
	private By hiddenProgressCirclesOnWholeGoodSearchPage = By.xpath("//*[@id='progress' and @style='top: 0px; left: 0px;']");
	private By adminBtnOnHomePage=By.xpath("//span[contains(text(),'Admin')]");
	private By uploadStatusText=By.xpath("//*[text()='Program Upload Status']");
	private By importAttachmentData=By.xpath("//a[contains(text(),'Import Attachments Data')]");
	private By importWholeGoodData=By.xpath("//a[contains(text(),'Import Whole Goods Data')]");
	private By MAIRadioBtn=By.xpath("//*[@id='uploadFor1']/div/label[contains(text(),'MAI Data')]/preceding-sibling::input");
	private By MAARadioBtn=By.xpath("//*[@id='uploadFor1']/div/label[contains(text(),'MAA Data')]/preceding-sibling::input");
	
	public void clickOnImportTranslationsDataLink(InputEnvironmentDetails inputEnvDetails) throws InterruptedException {
		CommonFunctions.waitForAnObject(driver, importTranslationsDataLink, GlobalThings.minWait);
		CommonFunctions.waitForAjax(driver);
		CommonFunctions.javaScriptClick(importTranslationsDataLink, driver);

	}
	
	public void selectWholeGoodProgramRadioBtnTtoImport(InputEnvironmentDetails inputEnvDetails) throws InterruptedException {
		CommonFunctions.waitForAnObject(driver, wholegoodProgramSelect, GlobalThings.minWait);
		CommonFunctions.waitForAjax(driver);
		CommonFunctions.javaScriptClick(wholegoodProgramSelect, driver);
	}
	
	public void selectWorkgrpNotesRadioBtnToImport(InputEnvironmentDetails inputEnvDetails) throws InterruptedException {
		CommonFunctions.waitForAnObject(driver, workgrpNoteSelectToImport, GlobalThings.minWait);
		CommonFunctions.waitForAjax(driver);
		CommonFunctions.javaScriptClick(workgrpNoteSelectToImport, driver);
	}

	public void selectAttachdescRadioBtnToImport(InputEnvironmentDetails inputEnvDetails) throws InterruptedException {
        CommonFunctions.waitForAnObject(driver, attachDescSelect, GlobalThings.minWait);
        CommonFunctions.waitForAjax(driver);
        CommonFunctions.refreshWindow(driver);
        Thread.sleep(5000);
         CommonFunctions.javaScriptClick(attachDescSelect, driver);
     }
	public void selectProductSturctureRadioBtnToImport(InputEnvironmentDetails inputEnvDetails) throws InterruptedException {
		CommonFunctions.waitForAnObject(driver, prodStructSelect, GlobalThings.minWait);
		CommonFunctions.waitForAjax(driver);
		CommonFunctions.javaScriptClick(prodStructSelect, driver);
		
	}
	public void clickOnImportWholegoodDataLink(InputEnvironmentDetails inputEnvDetails) throws InterruptedException {
		CommonFunctions.waitForAnObject(driver, importWholegoodsDataLnk, GlobalThings.minWait);
		CommonFunctions.waitForAjax(driver);
		CommonFunctions.javaScriptClick(importWholegoodsDataLnk, driver);

	}
    public void selectMPIDataRadioBtnToImport(InputEnvironmentDetails inputEnvDetails) throws InterruptedException {
		CommonFunctions.waitForAnObject(driver, selectMPIRadioBtn, GlobalThings.minWait);
		CommonFunctions.waitForAjax(driver);
		CommonFunctions.javaScriptClick(selectMPIRadioBtn, driver);
	}
    public void clickOnChooseFileButton(InputEnvironmentDetails inputEnvDetails) throws InterruptedException {
        CommonFunctions.waitForAnObject(driver, chooseFileButton, GlobalThings.minWait);
        CommonFunctions.waitForAjax(driver);
        CommonFunctions.click(driver, chooseFileButton);
        System.out.println("click fileupload");

    }
    public void clickOnSubmitButton(InputEnvironmentDetails inputEnvDetails) throws InterruptedException {
        CommonFunctions.waitForAnObject(driver, submitButton, GlobalThings.minWait);
        CommonFunctions.waitForAjax(driver);
        CommonFunctions.click(driver, submitButton);
        CommonFunctions.waitForAjax(driver);
    }
    public void clickOnHomeButton() throws InterruptedException {
        CommonFunctions.waitForAnObject(driver, homeButton, GlobalThings.minWait);
        CommonFunctions.waitForAjax(driver);
        CommonFunctions.click(driver, homeButton);
     }
    public void verifyUploadSuccessColor(InputEnvironmentDetails inputEnvDetails, String fileName) throws InterruptedException {
        CommonFunctions.refreshWindow(driver);
        Thread.sleep(8000);
        String bgcolor = "rgba(255, 255, 255, 1)";
        CommonFunctions.refreshWindow(driver);
        CommonFunctions.waitForAnObject(driver, By.xpath(" //div[@class='divRow ng-scope'][1]/div[@class='divCell ng-binding'][2][contains(text(),'"+fileName+"')]/following-sibling::div//div[contains(@title,'Uploaded To SharePoint')]"), GlobalThings.minWait * 500);
        List<WebElement> UpdateStatusList = driver.findElements(By.xpath("//div[contains(@title,'Uploaded To SharePoint')]"));
        String checkstatus = UpdateStatusList.get(0).getCssValue("background-color");
        if (!checkstatus.equalsIgnoreCase(bgcolor)) {
            System.out.println(!checkstatus.equalsIgnoreCase(bgcolor));
          } else {
            Assert.assertTrue(true, "file not uploaded successfully");
        }
       }
    
    public void verifyUploadSuccessColorForAttachment(InputEnvironmentDetails inputEnvDetails, String Filename) throws InterruptedException {
        Thread.sleep(8000);
        String bgcolor = "rgba(255, 255, 255, 1)";
        List<WebElement> UpdateStatusList = driver.findElements(By.xpath("//div[contains(@title,'Uploaded To SharePoint')]"));
        String checkstatus = UpdateStatusList.get(0).getCssValue("background-color");
        if (!checkstatus.equalsIgnoreCase(bgcolor)) {
            System.out.println(!checkstatus.equalsIgnoreCase(bgcolor));
           } else {
            Assert.assertTrue(true, "file not uploaded successfully");
        }
       }
    public void verifyUploadSuccessColor_Sumit(InputEnvironmentDetails inputEnvDetails) throws InterruptedException {

        String bgcolor = "rgba(255, 255, 255, 1)";
        if (driver.findElement(By.xpath(".//*[contains(text(),'across_chk1')]//following::div[@title='Uploaded To SharePoint']")).getCssValue("background-color").equalsIgnoreCase(bgcolor)) {
            System.out.println(driver.findElement(By.xpath(".//*[contains(text(),'across_chk1')]//following::div[@title='Uploaded To SharePoint']")).getCssValue("background-color").equalsIgnoreCase(bgcolor));
            } else {
            Assert.assertTrue(true, "file not uploaded successfully");
        }
        }
  
    public void importMAIWholeGoodData(InputEnvironmentDetails inputEnvDetails) throws InterruptedException {
    		CommonFunctions.waitForAnObject(driver, importWholeGoodData, GlobalThings.minWait);
    		CommonFunctions.javaScriptClick(importWholeGoodData, driver);
            CommonFunctions.waitForAnObject(driver, selectMPIRadioBtn, GlobalThings.maxWait);
            CommonFunctions.click(driver, selectMPIRadioBtn);
            this.clickOnChooseFileButton(inputEnvDetails);
        }
    
    public void importMAIAttachmentData(InputEnvironmentDetails inputEnvDetails) throws InterruptedException
	{
    	CommonFunctions.waitForAnObject(driver, importAttachmentData, GlobalThings.minWait);
		CommonFunctions.javaScriptClick(importAttachmentData, driver);
		CommonFunctions.refreshWindow(driver);
		CommonFunctions.waitForAnObject(driver, MAIRadioBtn, GlobalThings.maxWait);
		CommonFunctions.javaScriptClick(MAIRadioBtn, driver);
		this.clickOnChooseFileButton(inputEnvDetails);
	}
	public void importMAAttachmentData(InputEnvironmentDetails inputEnvDetails) throws InterruptedException
	{
			CommonFunctions.waitForAnObject(driver, importAttachmentData, GlobalThings.minWait);
			CommonFunctions.javaScriptClick(importAttachmentData, driver);
			CommonFunctions.refreshWindow(driver);
			CommonFunctions.waitForAnObject(driver, MAARadioBtn, GlobalThings.maxWait*50);
			CommonFunctions.click(driver, MAARadioBtn);
			this.clickOnChooseFileButton(inputEnvDetails);
	}
    public void clickOnImportToolLink() {
        CommonFunctions.waitForAnObject(driver, adminBtnOnHomePage, GlobalThings.microWait);
        CommonFunctions.javaScriptClick(adminBtnOnHomePage, driver);
		CommonFunctions.waitForAnObject(driver, importToolLink, GlobalThings.maxWait*50);
        CommonFunctions.javaScriptClick(importToolLink, driver);
        CommonFunctions.waitForAnObject(driver, uploadStatusText, GlobalThings.midWait);
        CommonFunctions.waitForAnObject(driver, hiddenProgressCirclesOnWholeGoodSearchPage, GlobalThings.microWait*500);
    }
    
	public void verifyImportSuccesful_Error(String Filename) throws InterruptedException
	{
			this.clickOnHomeButton();
			Thread.sleep(8000);
			CommonFunctions.waitForAnObject(driver, By.xpath("//div[contains(text(),'MAI - Automation Workgroup- for cross division2628_XD.xlsx')]"), GlobalThings.maxWait);
			CommonFunctions.click(driver, By.xpath("//div[contains(text(),'"+Filename+"')]/following-sibling::div/a[contains(text(),'Error')]"));
			boolean Status=CommonFunctions.isElementDisplayed(driver, By.xpath("//div[contains(text(),'Child PAT file for cross-division can not be imported. No changes applied.')]"));
			Thread.sleep(5000);
			CommonFunctions.waitForAnObjectToBeAvailable(driver, By.xpath("//div[contains(@class,'close_popUpGa closePopup')]"), GlobalThings.maxWait);
			Assert.assertEquals(Status, true,"Error message not displayed");
			Thread.sleep(2000);
	}
}
