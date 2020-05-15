package com.deere.pages;

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

public class AdministrationPage {

	WebDriver driver;

	public AdministrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

 // Admin Link
	@FindBy(how = How.LINK_TEXT, linkText="Administration")
	public WebElement adminLnk;

	// Logo tab
		@FindBy(how = How.LINK_TEXT, linkText="Logo")
		public WebElement logoTab;

   // Logo Title
		@FindBy(how = How.XPATH, xpath = "//h1[contains(text(),'Logo')]")
		public WebElement logoTitle;

   // Links Tab
		@FindBy(how = How.LINK_TEXT, linkText="Links")
		public WebElement linkTab;

  // Delete Selection Check box
		@FindBy(how = How.XPATH, xpath = "//table[@id='adminLinkRow']//tbody//tr//th//input[@id='checkValues']")
		public WebElement deleteChkBox;

 // Delete Link
		@FindBy(how = How.LINK_TEXT, linkText = "Delete Selected")
		public WebElement deleteLnk;

  // link Name field
		@FindBy(how = How.XPATH, xpath="//table[@id='adminLinkRow']//tbody//tr//td//input[@id='linkName']")
		public WebElement linkName;

 // link Name field
		 @FindBy(how = How.XPATH, xpath="//table[@id='adminLinkRow']//tbody//tr//td[2]//input[@id='linkUrl']")
		 public WebElement linkURL;

// Save On Admin
		 @FindBy(how = How.LINK_TEXT, linkText="Save")
		 public WebElement adminSave;


// Navigate to Admin Page
public void navigateToAdminPge()
{
	Assert.assertTrue(adminLnk.isDisplayed(), "Administration link not displayed");
	adminLnk.click();
	Assert.assertTrue(logoTab.isDisplayed(), "Issue in loading Admin page");

}

// Make Changes on Links tab and save

public void addLinkAndSave() throws InterruptedException
{
	linkTab.click();
	Thread.sleep(2000);
	Assert.assertTrue(deleteChkBox.isDisplayed(), "Delete section check box not displayed");
	deleteChkBox.click();
	Assert.assertTrue(deleteLnk.isDisplayed(), "Delete Selected link not displayed");
	deleteLnk.click();
	CommonFunctions.acceptAlert(driver);
	Thread.sleep(5000);
	Assert.assertTrue(linkName.isDisplayed(), "Link name field not displayed");
	linkName.sendKeys("Test link");
	Assert.assertTrue(linkURL.isDisplayed(), "Link URL field not displayed");
	linkURL.sendKeys("about blank");
	adminSave.click();
	Assert.assertTrue(logoTitle.isDisplayed(), "Save Functionality failed");	
}

}
