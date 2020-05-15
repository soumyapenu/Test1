package com.deere.pages;

import java.util.Iterator;
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

public class ProposalPage {

	WebDriver driver;
	HomePage homePage;

	public ProposalPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		homePage = new HomePage(driver);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, xpath = "//img[@title='Print Quote']")
	private WebElement generateProposalPDF;

	public void clickGeneratePDF() throws InterruptedException {
		generateProposalPDF.click();
		Thread.sleep(15000);
	}

	// Click on Proposal tab
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Proposal')]")
	private WebElement clickOnProposalTab;

	// Select all checkboxes on Proposal tab
	@FindBy(how = How.XPATH, xpath = "//*[@id='selectAllSelected']")
	private WebElement selectAllCheckBoxes;

	// Print PDF
	@FindBy(how = How.XPATH, xpath = "//*[@title='Print Quote']")
	private WebElement printPDF;

	// Mouse over to the Proposal PDF
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'NavigationServlet')]")
	private WebElement mouseHoverToThePDF;

	
	// Navigation to Proposal Tab
	public void navigateToProposalTab() throws InterruptedException
	{
		clickOnProposalTab.click();
		Thread.sleep(2000);
	}
	
	public void clickOnGenerateProposal() throws InterruptedException
	{
		 CommonFunctions.clickOnElement(driver, printPDF);
			Thread.sleep(3000);
			driver.manage().window().maximize();
	}
	
	// Verify Proposal PDF with only mandatory pages
	public void proposalWithManPages() throws InterruptedException
	{
		navigateToProposalTab();
		if(selectAllCheckBoxes.isSelected())
		{
		  CommonFunctions.clickOnElement(driver, selectAllCheckBoxes);
		  Thread.sleep(3000);	
		  homePage.headerSaveQuote();
		}
		else
		{
			 CommonFunctions.clickOnElement(driver, selectAllCheckBoxes);
			  Thread.sleep(3000);	
			  homePage.headerSaveQuote();	
			  CommonFunctions.clickOnElement(driver, selectAllCheckBoxes);
			  Thread.sleep(3000);	
			  homePage.headerSaveQuote();	
		}
		Thread.sleep(5000);
		clickOnGenerateProposal();
		CommonFunctions.switchToChildWindow(driver);
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		Assert.assertTrue(currentURL.contains("maintainProposalForm"), "Issue In Generating Proposal PDF");
		driver.close();		
	}
	
	public void proposalTab() throws InterruptedException {
		navigateToProposalTab();
		CommonFunctions.clickOnElement(driver, selectAllCheckBoxes);
		Thread.sleep(3000);
		clickOnGenerateProposal();
		CommonFunctions.switchToChildWindow(driver);
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		Assert.assertTrue(currentURL.contains("maintainProposalForm"), "Issue In Generating Proposal PDF");
		driver.close();
	  }

	}

