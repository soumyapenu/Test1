package com.deere.global;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Hyperlink;
import org.openqa.selenium.WebDriver;
/**
 * 
 * @author ng58485
 * This class will provide and object which will hold parameters to write in the report file
 */

public class TestResultReport {
	private String environment, browser,testCaseId, testCaseDescription, result, functionalError, userDefinedError , technicalError;
	String SSPath;
	Map<String,String>testData;
	private WebDriver driver;
	
	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getTestCaseId() {
		return testCaseId;
	}

	public void setTestCaseId(String senario) {
		this.testCaseId = senario;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getFunctionalError() {
		return functionalError;
	}

	public void setFunctionalError(String err) {
		functionalError = err;
	}
	
	public String getTechnicalError() {
		return technicalError;
	}

	public void setTechnicalError(String err) {
		technicalError = err;
	}

	public String getUserDefinedError() {
		return userDefinedError;
	}

	public void setUserDefinedError(String errDesc) {
		userDefinedError = errDesc;
	}

	public String getTestCaseDescription() {
		return testCaseDescription;
	}

	public void setTestCaseDescription(String testCaseDescription) {
		this.testCaseDescription = testCaseDescription;
	}

	public String getSSPath() {
		return SSPath;
	}

	public void setSSPath(String sSPath2) {
		SSPath = sSPath2;
	}
	
	public String getTestData(String keyValue) {
		return testData.get(keyValue);
	}

	public void setTestData(Map testData) {
		this.testData = testData;
	}
}
