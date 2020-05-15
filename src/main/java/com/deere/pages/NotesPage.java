package com.deere.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.util.List;

import com.deere.global.CommonFunctions;

public class NotesPage {

	WebDriver driver;
	SummaryPage summaryPage;

	public NotesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		summaryPage = new SummaryPage(driver);
		this.driver = driver;
	}

	// Click on Notes History Tab
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Notes History')]")
	private WebElement clickOnNotesTab;

	// Write note in it
	@FindBy(how = How.XPATH, xpath = "//*[@id='generalNotesTA']")
	private WebElement writeNotes;

	// Save button on notes tab
	@FindBy(how = How.XPATH, xpath = "//*[@id='savebutton']")
	private WebElement saveButton;

	String notes = "Notes written";

	@FindBy(how = How.XPATH, xpath = "//*[@id='generalNotestablediv']//div//table//tbody//tr//td[@class='notes']")
	private WebElement verifyNotes;
	
	@FindBy(how = How.XPATH, xpath = "//div[@id='generalNotestablediv']//div//table//tbody//tr//td[3]")
	public List<WebElement> notesTable;
	
	//Navigate to Notes History tab
	public void navigateToNotesHistory() throws InterruptedException
	{
		CommonFunctions.clickOnElement(driver, clickOnNotesTab);
		Thread.sleep(5000);
	}

	public void clickOnNotesHistorytab() throws InterruptedException {
		 navigateToNotesHistory();
		writeNotes.sendKeys("Notes written");
		Thread.sleep(2000);
		saveButton.click();
		try {
			Assert.assertEquals(notes, verifyNotes.getText());
			System.out.println("Notes verified");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Notes are not verfied");
		}
	}
	
	// Verify QuoteStatus Change On Notes History
	
	public void verifystatusChange() throws InterruptedException
	{
		 navigateToNotesHistory();
		 int rowCount = notesTable.size();
		 System.out.println(rowCount);
		 for(int i=0;i<rowCount;i++)
		 {
			String value = (notesTable).get(i).getText();
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(value.contains("Bought"));
			break;
			
		 }
		 
	}
}
