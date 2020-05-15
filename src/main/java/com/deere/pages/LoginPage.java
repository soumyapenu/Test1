package com.deere.pages;


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

public class LoginPage extends LoadableComponent<LoginPage>

{
	// user name text box
	@FindBy(how = How.XPATH, xpath = "//input[@id='username']")
	private  WebElement userName;
	//password text box
	@FindBy(how = How.XPATH, xpath = "//input[@placeholder='Password']")
	private  WebElement inputPassword;
	//sign In button
	@FindBy(how = How.XPATH, xpath = "//button[@name='login']")
	private  WebElement signInButton;
	//dealer account number
	@FindBy(how = How.XPATH, xpath = "//input[@id='dealerNumber']")
	private  WebElement dealerAccountNumber;
	// go button 
	@FindBy(how = How.XPATH, xpath = "//input[@id='submit']")
	private  WebElement goButton;
	//Continue button
	@FindBy(how = How.XPATH, xpath = "//input[@value='Continue']")
	private  WebElement continueButton;
	@FindBy(how = How.XPATH, xpath = "//input[@value='Cancel']")
	private  WebElement cancelButton;

	
	

	private By loginPanel = By.xpath("//*[@class='login-content']");
	private By signOutBtn = By.xpath("//*[@id='user-popover']//*[text()='Log Out']");
	private By logInUser = By.xpath("//*[contains(text(),'Welcome')]//following-sibling::a");
	private By userNametxtbox = By.xpath("//*[@name='username']");
    private By passtxtbox = By.xpath("//*[@name='password']");
   	private By disclaimerAgreeBtn = By.xpath(".//*[@id='app']/div/div[2]/div/div[2]/button[1]");
	private By agreeBtn = By.xpath("//*[text()='I AGREE']");
	private By signInBtn = By.xpath("//button[@type='submit']");
	@FindBy(how = How.XPATH, xpath = "//*[contains(text(),'Welcome')]//following-sibling::a/span")
	private  WebElement loggedInuser;
	private By spinner = By.xpath("//*[@class='spinner']");
	private By waklMeDoneBtn=By.xpath("//*[contains(@class,'walkme-custom-balloon-button')]/span[text()='Done']");
	private By walkMeOkBtn=By.xpath("//*[contains(@class,'walkme-custom-balloon-button')]/span[text()='OK']");


	int logoutOccurances=0;
	protected WebDriver driver;

	// **********Sign In Page
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver =driver;
	}

	public void enterUserName(String username){
		userName.sendKeys(username);
	} 

	public void enterPassword(String pass){
		inputPassword.sendKeys(pass);
	} 

	/*
	// clicking on Sign In button
	public void clickSignInButton(){
		signInButton.click();
	} */
	
	//********employee access page************
	public void enterDealerActNumber(String dealerActNumber){
		dealerAccountNumber.sendKeys(dealerActNumber);
	} 
	
	public void dealerActNumbrLogin(InputTestDetails inputTestDetails) throws InterruptedException {
		String dealerActNumber = inputTestDetails.getTestdata()[0].toString();
		dealerAccountNumber.sendKeys(dealerActNumber);
		goButton.click();
		CommonFunctions.waitForLoad(driver);		
	}

	public void clickGoButton(){
		goButton.click();
	}
	
	//Disclaimer Page
	public void clickContinueButton() throws InterruptedException{
		continueButton.click();
	} 
	
	public void clickCancelButton(){
		cancelButton.click();
	} 	
//	public void clickContinueInButton(){
//		CommonFunctions.javaScriptClick(signInBtn, driver);
//	}

	public void logout(InputEnvironmentDetails inputEnvDetails) throws InterruptedException
	{
			CommonFunctions.waitForAnObject(driver, logInUser, GlobalThings.midWait);
			System.out.println("tEST");
		CommonFunctions.waitForAnObjectToBeVisible(driver, logInUser, GlobalThings.midWait);
		CommonFunctions.findElement(driver, By.xpath("//*[contains(text(),'Welcome')]//following-sibling::a"), GlobalThings.midWait);
		loggedInuser.click();
		if(!CommonFunctions.waitForAnObject(driver, signOutBtn, GlobalThings.microWait)){
			loggedInuser.click();
			CommonFunctions.waitForAnObject(driver, signOutBtn, GlobalThings.microWait);
		}
		if(!CommonFunctions.isElementExist(driver, signOutBtn)){
			CommonFunctions.javaScriptClick(logInUser, driver);
			CommonFunctions.waitForAnObject(driver, signOutBtn, GlobalThings.microWait);
			CommonFunctions.javaScriptClick(signOutBtn, driver);
		}
		else{
			CommonFunctions.waitForAnObject(driver, signOutBtn, GlobalThings.microWait);
			CommonFunctions.javaScriptClick(signOutBtn, driver);
			if(CommonFunctions.waitForAlert(driver, GlobalThings.minWait))
				CommonFunctions.acceptAlert(driver);
		}
		CommonFunctions.acceptAlert(driver);
		CommonFunctions.waitForAnObject(driver, loginPanel, GlobalThings.minWait);
	}


	public void newLogin(InputTestDetails inputTestDetails,InputEnvironmentDetails inputEnvDetails,WebDriver driver , boolean altUserPass , String altUserName , String altPassword) throws Exception {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String env = inputEnvDetails.getEnvironment();
		driver.get(inputEnvDetails.getUrl());
		Thread.sleep(10000);
		if(env.contains("CERT"))
		{
		  if (CommonFunctions.waitForAnObject(driver, userNametxtbox, GlobalThings.minWait)) {
            driver.findElement(userNametxtbox).clear();
            driver.findElement(userNametxtbox).sendKeys(inputEnvDetails.getUsername());
            driver.findElement(passtxtbox).clear();
            driver.findElement(passtxtbox).sendKeys(CommonFunctions.decrypt(inputEnvDetails.getPassword()));
            Thread.sleep(5000);
            CommonFunctions.javaScriptClick(By.xpath("//*[@type='submit' and @value='Sign In']"), driver);
            Thread.sleep(20000);
        }else {
		CommonFunctions.waitForAnObject(driver, loginPanel, GlobalThings.midWait);
		CommonFunctions.acceptAlert(driver);
		if(driver.getTitle().contains("503")){
			CommonFunctions.refreshWindow(driver);
			CommonFunctions.waitForLoad(driver);
			CommonFunctions.acceptAlert(driver);
			if(driver.getTitle().contains("503"))
				CommonFunctions.refreshWindow(driver);
		}
		Assert.assertEquals(driver.getTitle().contains("503"), false, inputEnvDetails.getEnvironment()+" "+"is not available currently.503 Service unavailable is showing");

		if(CommonFunctions.isElementExist(driver, loginPanel))
		{
			CommonFunctions.acceptAlert(driver);
			if(altUserPass==true)
				enterUserNameAndPass(altUserName , altPassword);
			else
				enterUserNameAndPass(inputEnvDetails.getUsername() , inputEnvDetails.getPassword());
		}
		else{
			CommonFunctions.acceptAlert(driver);
			newLogin(inputTestDetails, inputEnvDetails,driver,altUserPass,altUserName,altPassword);
			Assert.assertEquals(CommonFunctions.isElementExist(driver, loginPanel), true, "Login panel is not displayed");
		}
		Thread.sleep(2000);
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
		}
	}


	public void newPricingPresentationLogin(InputTestDetails inputTestDetails,InputEnvironmentDetails inputEnvDetails,WebDriver driver) throws Exception {
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(inputTestDetails.getTestdata()[0].toString());
		CommonFunctions.waitForAnObject(driver, loginPanel, GlobalThings.midWait);
		CommonFunctions.acceptAlert(driver);
		if(driver.getTitle().contains("503")){
			CommonFunctions.refreshWindow(driver);
			CommonFunctions.waitForLoad(driver);
			CommonFunctions.acceptAlert(driver);
			if(driver.getTitle().contains("503"))
				CommonFunctions.refreshWindow(driver);
		}
		Assert.assertEquals(driver.getTitle().contains("503"), false, inputTestDetails.getTestdata()[0].toString()+" "+"is not available currently.503 Service unavailable is showing");

		if(CommonFunctions.isElementExist(driver, loginPanel))
		{
			CommonFunctions.acceptAlert(driver);
			enterUserNameAndPass(inputTestDetails.getTestdata()[1].toString() , inputTestDetails.getTestdata()[2].toString());
		}
		else{
			CommonFunctions.acceptAlert(driver);
			Assert.assertEquals(CommonFunctions.isElementExist(driver, loginPanel), true, "Login panel is not displayed");
		}
		Thread.sleep(2000);
		if(CommonFunctions.isElementExist(driver, waklMeDoneBtn))
		{
			CommonFunctions.click(driver, waklMeDoneBtn);
		}
		
		if(CommonFunctions.isElementExist(driver, walkMeOkBtn))
		{
			CommonFunctions.javaScriptClick(walkMeOkBtn, driver);
		}
	}

	public boolean acceptDisclaimer() throws InterruptedException
	{
		if(CommonFunctions.waitForAnObject(driver,disclaimerAgreeBtn, GlobalThings.microWait)){
			CommonFunctions.javaScriptClick(disclaimerAgreeBtn, driver);
			Thread.sleep(GlobalThings.microWait*1000);
			//		driver.findElement(disclaimerAgreeBtn).click();
			return true;
		}
		else
			return false;

	}

	public void enterUserNameAndPass(String user , String Pass) throws Exception
	{
		userName.sendKeys(user);
		Thread.sleep(1000);
		inputPassword.sendKeys(CommonFunctions.decrypt(Pass));
		//
	}

//	public boolean clickAgreeBtn() throws InterruptedException{
//		if(CommonFunctions.waitForAnObject(driver, agreeBtn, GlobalThings.minWait)){
//			CommonFunctions.waitForAnObjectToBeVisible(driver, agreeBtn, GlobalThings.minWait);
//			clickAgree();
//			return true;
//		}
//		else{
//			return false;
//		}
//	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub

	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub

	}
}

