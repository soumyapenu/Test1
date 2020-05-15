package com.deere.global;

import static com.deere.global.GlobalThings.BROWSER;
import static com.deere.global.GlobalThings.driversPath;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserWebDriver {
	private static WebDriver driver;
	public static String 
			FIREFOX = "FireFox", 
			CHROME = "Chrome", 
			IE32 =  "InternetExplorer32", 
			IE64 =  "InternetExplorer64";
	
	public static WebDriver getDriver() {
		if(BROWSER.equals("FireFox")){
			//FirefoxProfile profile = new FirefoxProfile(new File("C://Users//AN61450//AppData//Roaming//Mozilla//Firefox//Profiles//r5b0n7uh.SeleniumProfile"));                  
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("Chrome")){
			
			System.setProperty("webdriver.chrome.driver", driversPath + "chromedriver.exe");
			driver = new ChromeDriver();
		}else if(BROWSER.equals("InternetExplorer32")){

	        System.setProperty("webdriver.ie.driver", driversPath + "IEDriverServer32.exe");
	        driver = new InternetExplorerDriver();
		}else if(BROWSER.equals("InternetExplorer64")){
	        System.setProperty("webdriver.ie.driver", driversPath + "IEDriverServer64.exe");
	        driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	
	
	
}
