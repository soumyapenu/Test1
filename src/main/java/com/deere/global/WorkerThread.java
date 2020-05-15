package com.deere.global;

import static com.deere.global.GlobalThings.driversPath;
import static com.deere.global.GlobalThings.testResultReports;
import static com.deere.global.GlobalThings.userDefinedError;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

class WorkerThread implements Runnable {  
	@SuppressWarnings("unused")
	private String message;  
	private WebDriver driver;
	InputTestDetails inputTestDetails;
	InputEnvironmentDetails inputEnvDetails;
	InputBrowserDetails inputBrowserDetails;

	public WorkerThread(InputTestDetails inputTestDetails ,InputEnvironmentDetails inputEnvDetails ,InputBrowserDetails inputBrowserDetails)
	{  
		this.inputTestDetails = inputTestDetails;
		this.inputEnvDetails = inputEnvDetails;
		this.inputBrowserDetails = inputBrowserDetails;
	}  
	@SuppressWarnings({ "unchecked", "deprecation" })
	public void run()
	{
		if(inputBrowserDetails.getBrowserName().equals("Firefox")){   
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			firefoxProfile.setPreference("browser.download.folderList", 2);
			firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
			firefoxProfile.setPreference("browser.download.dir", driversPath);
			firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
			//driver = new FirefoxDriver(firefoxProfile);
		}
		else if(inputBrowserDetails.getBrowserName().equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", driversPath + "//chromedriver.exe");
			String downloadFilepath =System.getProperty("user.dir")+"\\Drivers";
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			chromePrefs.put("safebrowsing.enabled", "true");
			chromePrefs.put("time-zone", "Eastern");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(cap); 
			//driver = new ChromeDriver();
		}
		else if(inputBrowserDetails.getBrowserName().equals("IE")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			caps.setCapability("ignoreZoomSetting", true);
			caps.setCapability("requireWindowFocus", false);
			driver = new InternetExplorerDriver(caps);
		}
		else if(inputBrowserDetails.getBrowserName().equals("Safari")){
			driver = new SafariDriver();
		}
		driver.manage().deleteAllCookies();
		Method method = null;
		@SuppressWarnings("rawtypes")
		Class methodClass = null;
		String techError = null;
		String functionalError = null;
		TestResultReport testResultReport = null;
		try{
			methodClass = Class.forName("com.deere.testCases." + inputTestDetails.getModule().toString());
			@SuppressWarnings("rawtypes")
			Class [] Parms  = new Class [4];
			Parms [0]= InputTestDetails.class;
			Parms [1]= InputEnvironmentDetails.class;
			Parms [2]= InputBrowserDetails.class;
			Parms [3]= WebDriver.class;
			method = methodClass.getDeclaredMethod("test_" + inputTestDetails.getTestCaseID(), Parms);
			testResultReport = (TestResultReport)method.invoke(methodClass, inputTestDetails,inputEnvDetails,inputBrowserDetails,driver);
			CommonFunctions.writeBakReportExcel(testResultReport);
		}  catch (Throwable e) {

			if(!e.getCause().toString().contains("AssertionError")){
				userDefinedError = "Due to more reponse time , page or object may not be visible/loaded within timeout";
				techError = e.getCause().toString().split("Session info")[0];
			}
			else
			{
				functionalError = e.getCause().toString().substring(25, e.getCause().toString().length()).trim();
			}
			try {
				testResultReport =  CommonFunctions.updateResultObject(inputTestDetails, techError , functionalError , userDefinedError , driver,inputEnvDetails,inputBrowserDetails);
				CommonFunctions.writeBakReportExcel(testResultReport);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		} finally{
			if(driver!=null){
				System.gc();
				driver.quit();
			}
		}
		testResultReports.add(testResultReport);
	}

}  
