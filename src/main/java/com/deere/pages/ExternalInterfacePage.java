package com.deere.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.deere.applicaionSpecific.GlobalThings;
import com.deere.global.CommonFunctions;
import com.deere.global.InputEnvironmentDetails;
import com.deere.global.InputTestDetails;


public class ExternalInterfacePage extends LoadableComponent<ExternalInterfacePage>{
	WebDriver driver;

	public ExternalInterfacePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver =driver;
	}
	
	//Text
	private By baseCodeServiceTxt =By.id("restServiceName");
	private By attachmentSearchTxt =By.id("restServiceName");
	
	
	//Tabs
	private By externalInterfaceTab =By.xpath(".//*[(text() ='External Interface')]");
	
	//Buttons
	private By downloadXmlBtn =By.xpath("//*[contains(@value,'Download XML')]");
	
	//text Box
	private By baseCodetxtbox =By.id("BC_NAME");	
	private By localetxtbox =By.id("BC_LOCALE");
	private By Currencytxtbox =By.id("BC_CURRENCY");
	private By attachmentNumberTxtbox =By.xpath(".//*[@name='attachmentNumber']");
	private By attachmentlocaleTxtbox =By.xpath(".//*[@name='AN_locale']");
	//Links
	private By baseCodeServicesLnk =By.id("services/jdsc/basecode:BasecodeDetailDiv:Basecode Service");
	private By attachmentServicesLnk =By.id("services/jdsc/attachmentNumber:AttachmentSearchDiv:Attachment Search");
	private By configurationDatelnk =By.xpath("//*[@id='BC_startDate']/following-sibling::img");
	private By pricingDatelnk =By.xpath("//*[@id='BC_pricingDate']/following-sibling::img");
	private By startDaylnk = By.xpath("//*[contains(@class,'today')]//a");
	
	//drp
	private By userTypedrp =By.name("USER_TYPE");
	//private By fetchFromdrp =By.xpath("//*[@id='BC_responseType']");
	private By fetchFromdrp =By.xpath("//*[@ng-model='fetchFrom']");
	private By attachfetchFromdrp =By.xpath("//*[@name='ATT_TYPE']");
	private By responseTypedrp =By.xpath("//*[@ng-model='responseType']");
	
	//Exchange Rate Request

		private By currencyExpand = By.xpath(".//*[@class = 'currencyExchangeUlContainer marginBottom15 marginTop15']/li[1]//*[@id = 'innerArrow0']");
		private By RequestAChangeBtn = By.xpath(".//*[@class = 'currencyExchangeUlContainer marginBottom15 marginTop15']/li[1]//*[text() = 'Request a Change']");
		private By DraftText = By.xpath(".//*[text() = 'Draft']");
		private By fxRateField = By.xpath(".//*[@id='FXRateindex0']");
		private By exchangeRateComment = By.xpath(".//*[@class = 'greyFont smallFont fleft']/following-sibling::textarea");
		private By submitBtn = By.xpath(".//*[text() = 'Submit']");
		private By datePicker = By.xpath(".//*[@id='effectiveDateindex0']//following-sibling::img");
		private By calenderTable = By.xpath(".//*[@id='ui-datepicker-div']//table");
		private By fxRateValue = By.xpath(".//*[@ng-show = 'exchCurrRate.showCurrRateReqInfo']//*[contains(@ng-include,'pricing/PendingCurrencyExchangeRates')]//*[text() = '1.9000']");
	
		// TODO Auto-generated method stub

		public void baseCodeService(InputTestDetails inputTestDetails) throws InterruptedException
		{
			CommonFunctions.checkFileExist(System.getProperty("user.dir")+"\\Drivers\\BaseCodeDetail.xml");
			CommonFunctions.waitForAnObject(driver, baseCodeServicesLnk, GlobalThings.microWait);
			CommonFunctions.waitForAnObjectToBeVisible(driver, baseCodeServicesLnk, GlobalThings.microWait);
			driver.findElement(baseCodeServicesLnk).click();
			CommonFunctions.waitForAnObject(driver, baseCodeServiceTxt, GlobalThings.microWait);
			CommonFunctions.waitForAnObject(driver, baseCodetxtbox, GlobalThings.microWait);
			driver.findElement(baseCodetxtbox).sendKeys(inputTestDetails.getTestdata()[0].toString());
			CommonFunctions.waitForAnObject(driver, localetxtbox, GlobalThings.microWait);
			driver.findElement(localetxtbox).sendKeys(inputTestDetails.getTestdata()[1].toString());
			CommonFunctions.waitForAnObject(driver, userTypedrp, GlobalThings.microWait);
			CommonFunctions.selectFromDropdown(inputTestDetails.getTestdata()[2].toString(),driver.findElement(userTypedrp));
			CommonFunctions.waitForAnObject(driver, configurationDatelnk, GlobalThings.microWait);
			driver.findElement(configurationDatelnk).click();
			CommonFunctions.waitForAnObject(driver, startDaylnk, GlobalThings.microWait);
			driver.findElement(startDaylnk).click();
			CommonFunctions.waitForAnObjectToBenVisible(driver, startDaylnk, GlobalThings.microWait);
			CommonFunctions.waitForAnObject(driver, Currencytxtbox, GlobalThings.microWait);
			CommonFunctions.waitForAnObjectToBeAvailable(driver, Currencytxtbox, GlobalThings.microWait);
			driver.findElement(Currencytxtbox).sendKeys(inputTestDetails.getTestdata()[3].toString());
			CommonFunctions.waitForAnObject(driver, pricingDatelnk, GlobalThings.microWait);
			driver.findElement(pricingDatelnk).click();
			CommonFunctions.waitForAnObject(driver, pricingDatelnk, GlobalThings.microWait);
			driver.findElement(startDaylnk).click();
			CommonFunctions.waitForAnObjectToBenVisible(driver, startDaylnk, GlobalThings.microWait);
			CommonFunctions.waitForAnObject(driver, fetchFromdrp, GlobalThings.microWait);
			CommonFunctions.waitForAnObjectToBeAvailable(driver, fetchFromdrp, GlobalThings.microWait);
			CommonFunctions.selectFromDropdown(inputTestDetails.getTestdata()[4].toString(),driver.findElement(fetchFromdrp));
			CommonFunctions.waitForAnObject(driver, responseTypedrp, GlobalThings.microWait);
			CommonFunctions.selectFromDropdown(inputTestDetails.getTestdata()[5].toString(),driver.findElement(responseTypedrp));
			driver.findElement(downloadXmlBtn).click();
			Thread.sleep(15000);	
		}
		
		public void attachmentService(InputTestDetails inputTestDetails) throws InterruptedException
		{
			CommonFunctions.checkFileExist(System.getProperty("user.dir")+"\\Drivers\\AttachmentNumberDetail.xml");
			CommonFunctions.waitForAnObject(driver, attachmentServicesLnk, GlobalThings.minWait);
			driver.findElement(attachmentServicesLnk).click();
			CommonFunctions.waitForAnObject(driver, attachmentSearchTxt, GlobalThings.minWait);
			CommonFunctions.waitForAnObject(driver, attachmentNumberTxtbox, GlobalThings.microWait);
			driver.findElement(attachmentNumberTxtbox).sendKeys(inputTestDetails.getTestdata()[0].toString());
			CommonFunctions.waitForAnObject(driver, attachmentlocaleTxtbox, GlobalThings.microWait);
			driver.findElement(attachmentlocaleTxtbox).sendKeys(inputTestDetails.getTestdata()[1].toString());
			CommonFunctions.waitForAnObject(driver, attachfetchFromdrp, GlobalThings.microWait);
			CommonFunctions.waitForAnObjectToBeAvailable(driver, attachfetchFromdrp, GlobalThings.microWait);
			CommonFunctions.selectFromDropdown(inputTestDetails.getTestdata()[2].toString(),driver.findElement(attachfetchFromdrp));
			CommonFunctions.waitForAnObject(driver, downloadXmlBtn, GlobalThings.minWait);
			//CommonFunctions.waitForAnObjectToBeAvailable(driver, downloadXmlBtn, GlobalThings.microWait);
			CommonFunctions.javaScriptClick(downloadXmlBtn, driver);
			Thread.sleep(GlobalThings.minWait*1000);
			//driver.findElement(downloadXmlBtn).click();
		}
	
		public void requestAChange(String fxvalue, String fxComment) throws InterruptedException
		{
			String fxRateComment = fxComment+CommonFunctions.randomNumber();
			CommonFunctions.waitForAnObject(driver, currencyExpand, GlobalThings.minWait);
			CommonFunctions.click(driver, currencyExpand);
			CommonFunctions.waitForAnObject(driver, RequestAChangeBtn, GlobalThings.minWait);
			CommonFunctions.javaScriptClick(RequestAChangeBtn,driver);
			CommonFunctions.waitForAnObject(driver, fxRateField, GlobalThings.maxWait);
			CommonFunctions.sendKeys(driver, fxRateField, fxvalue);
			CommonFunctions.waitForAnObject(driver, exchangeRateComment, GlobalThings.maxWait);
			CommonFunctions.sendKeys(driver, exchangeRateComment, fxRateComment);
			CommonFunctions.waitForAnObject(driver, submitBtn, GlobalThings.minWait);
			CommonFunctions.javaScriptClick(submitBtn, driver);
			if(CommonFunctions.waitForAnObjectToBeVisible(driver, By.xpath(".//*[@alt='A Currency Exchange Rate already exists for the effective date of the new request!']"),  GlobalThings.minWait))
				datePicker();
			Assert.assertEquals(CommonFunctions.waitForAnObject(driver, By.xpath(".//*[text() = 'Currency Rate Request Submitted Successfully']"), GlobalThings.minWait), true, "Success message did not display.");

			CommonFunctions.waitForAnObject(driver, currencyExpand, GlobalThings.minWait);
			CommonFunctions.click(driver, currencyExpand);
			int i = 1;
			while(i>0)
			{
				System.out.println(i);
				CommonFunctions.waitForAnObject(driver, By.xpath(".//*[@ng-show = 'exchCurrRate.showCurrRateReqInfo']//*[contains(@ng-include,'pricing/PendingCurrencyExchangeRates')]/div["+i+"]//*[@id='innerArrow0']"), GlobalThings.minWait);
				CommonFunctions.click(driver, By.xpath(".//*[@ng-show = 'exchCurrRate.showCurrRateReqInfo']//*[contains(@ng-include,'pricing/PendingCurrencyExchangeRates')]/div["+i+"]//*[@id='innerArrow0']"));
				CommonFunctions.waitForAnObject(driver, By.xpath(".//*[@ng-show = 'exchCurrRate.showCurrRateReqInfo']//*[contains(@ng-include,'pricing/PendingCurrencyExchangeRates')]/div["+i+"]//*[@id='logPendingRateRequest']/div/div/div[2]"), GlobalThings.minWait);
				String requesterComment = driver.findElement(By.xpath(".//*[@ng-show = 'exchCurrRate.showCurrRateReqInfo']//*[contains(@ng-include,'pricing/PendingCurrencyExchangeRates')]/div["+i+"]//*[@id='logPendingRateRequest']/div/div/div[2]")).getText().toString();
				System.out.println(requesterComment);
				if(requesterComment.equals(fxRateComment))
				{
					CommonFunctions.waitForAnObject(driver, By.xpath(".//*[@ng-show = 'exchCurrRate.showCurrRateReqInfo']//*[contains(@ng-include,'pricing/PendingCurrencyExchangeRates')]/div["+i+"]//*[text() = 'Edit']"), GlobalThings.minWait);
					CommonFunctions.click(driver, By.xpath(".//*[@ng-show = 'exchCurrRate.showCurrRateReqInfo']//*[contains(@ng-include,'pricing/PendingCurrencyExchangeRates')]/div["+i+"]//*[text() = 'Edit']"));
					int j = i-1;//Edit
					System.out.println(j);
					CommonFunctions.waitForAnObject(driver, By.xpath(".//*[@id='FXRate716index2']"), GlobalThings.minWait);
					CommonFunctions.sendKeys(driver, By.xpath(".//*[@id='FXRate716index2']"), fxvalue);
					CommonFunctions.waitForAnObject(driver, By.xpath(".//*[@id='contentBg']//textarea"), GlobalThings.minWait);
					CommonFunctions.sendKeys(driver, By.xpath(".//*[@id='contentBg']//textarea"), fxRateComment+"Edit");
					datePicker();
					CommonFunctions.waitForAnObject(driver, By.xpath(".//*[text() = 'Delete']"), GlobalThings.minWait);
					CommonFunctions.click(driver, By.xpath(".//*[text() = 'Delete']"));
					CommonFunctions.waitForAnObject(driver, By.xpath(".//*[@id='simpmodal']//*[@class = 'modal-mid']"), GlobalThings.minWait);
					CommonFunctions.waitForAnObject(driver, By.xpath(".//*[@id='simpmodal']//*[@value = 'Delete']"), GlobalThings.minWait);
					CommonFunctions.click(driver, By.xpath(".//*[@id='simpmodal']//*[@value = 'Delete']"));
					Assert.assertEquals(CommonFunctions.waitForAnObject(driver, By.xpath(".//*[text() = 'Currency Rate Request is deleted Successfully']"), GlobalThings.minWait), true, "Success message did not display.");
					break;
				}
				else
					i++;

			}
		}
		public void datePicker() throws NumberFormatException, InterruptedException
		{

			CommonFunctions.waitForAnObject(driver, datePicker, GlobalThings.minWait);
			CommonFunctions.click(driver, datePicker);
			CommonFunctions.waitForAnObject(driver, calenderTable, GlobalThings.minWait);
			WebElement effectiveDate = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']//*[@class = 'ui-state-default ui-state-active']"));
			String effDate = effectiveDate.getText().toString();
			int date = Integer.parseInt(effDate);
			System.out.println(date);
			int currentDate = date+1;
			System.out.println(currentDate);
			CommonFunctions.waitForAnObject(driver, By.xpath(".//*[@id='ui-datepicker-div']//*[text() = '"+currentDate+"']"), GlobalThings.minWait);

			if(!CommonFunctions.waitForAnObjectToBeVisible(driver, By.xpath(".//*[@id='ui-datepicker-div']//*[text() = '"+currentDate+"']"), GlobalThings.minWait))
			{
				CommonFunctions.waitForAnObject(driver, By.xpath(".//*[@id='ui-datepicker-div']//div//*[@data-handler = 'selectMonth']"), GlobalThings.minWait);
				CommonFunctions.click(driver, By.xpath(".//*[@id='ui-datepicker-div']//div//*[@data-handler = 'selectMonth']"));
				WebElement selectedMonth = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']//div//*[@data-handler = 'selectMonth']//*[@selected = 'selected']"));
				String month = selectedMonth.getAttribute("value");
				int monthValue = Integer.parseInt(month);
				System.out.println(monthValue);
				int newMonthValue = monthValue+1;
				CommonFunctions.waitForAnObject(driver, By.xpath(".//*[@id='ui-datepicker-div']//div//*[@data-handler = 'selectMonth']//*[@value = '"+newMonthValue+"']"), GlobalThings.minWait);
				CommonFunctions.click(driver, By.xpath(".//*[@id='ui-datepicker-div']//div//*[@data-handler = 'selectMonth']//*[@value = '"+newMonthValue+"']"));
				CommonFunctions.waitForAnObject(driver, By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[5]/a"), GlobalThings.minWait);
				CommonFunctions.click(driver, By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[5]/a"));
				CommonFunctions.waitForAnObject(driver, submitBtn, GlobalThings.minWait);
				CommonFunctions.javaScriptClick(submitBtn, driver);
			}
			else {
				CommonFunctions.click(driver, By.xpath(".//*[@id='ui-datepicker-div']//*[text() = '"+currentDate+"']"));
				CommonFunctions.waitForAnObject(driver, submitBtn, GlobalThings.minWait);
				CommonFunctions.javaScriptClick(submitBtn, driver);
				if(CommonFunctions.waitForAnObjectToBeVisible(driver, By.xpath(".//*[@alt='A Currency Exchange Rate already exists for the effective date of the new request!']"),  GlobalThings.minWait))
					datePicker();
			}


		}


	@Override
	protected void load() {
		// TODO Auto-generated method stub

	}


	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub

	}
	}
	


