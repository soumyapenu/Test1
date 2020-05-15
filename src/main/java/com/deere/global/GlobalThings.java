package com.deere.global;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ng58485
 * This class is a storage of all global static variables
 */
public class GlobalThings {
	public static final String reportDirectory = new File(".").getAbsolutePath() + "\\TestReport\\";
	public static final String testDirectory = new File(".").getAbsolutePath() + "TestDirectory\\";
	public static final String loadTransmittionFile=System.getProperty("user.dir")+"\\Drivers\\";
	public static final List <InputTestDetails> listOfInputs = new ArrayList<InputTestDetails>();
	public static final List <InputSuiteDetails> listOfsuite = new ArrayList<InputSuiteDetails>();
	public static final List <InputBrowserDetails> listOfBrowser = new ArrayList<InputBrowserDetails>();
	public static final List <InputEnvironmentDetails> listOfEnv = new ArrayList<InputEnvironmentDetails>();
	public static final List<TestResultReport> testResultReports = new ArrayList<TestResultReport>();
	public static final List<InputTestDetails> failedTestCases = new ArrayList<InputTestDetails>();
	public static final List <InputEmailIdDetails> listOfEmailId = new ArrayList<InputEmailIdDetails>();
	public static final String serverName_CERT = "jdbc:db2://db2t.deere.com:3700/DB234";
	public static final String serverName_QUAL = "jdbc:db2://db2t.deere.com:3700/DB233";
	public static final String hanaserverName_QUAL = "jdbc:sap://ctahdb.dx.deere.com:30015/?autocommit=false";
	public static final String hanaserverName_CERT = "jdbc:sap://ta3hdb.dx.deere.com:30015/?autocommit=false";

    
	
	public static final String dealerActNumber = "010102";
	public static final String dbUserName = "SK84451";
    
	public static final String dbPassWord = "jdnet133";
	public static final String hanadbUserName = "sk84451";
	public static final String hanadbPassWord = "jdnet133";
	public static String userDefinedError = null;
	//public static final String driversPath = System.getProperty("user.dir")+"\\ee122gh\\Desktop\\qa-JDautomation24\\Drivers\\";
	//public static final String driversPath = "C:\\Users\\ee122gh\\Desktop\\qa-JDautomation24\\Drivers";
	//public static final String driversPath = "C:\\Users\\ee122gh\\Documents\\workspace-sts-3.8.2.RELEASE\\jdquote2Automation-Selenium\\Drivers";
	public static final String driversPath = System.getProperty("user.dir")+"\\Drivers\\";
	public static final String MOCI_WHPrograms = System.getProperty("user.dir")+"\\src\\main\\resource\\MOCI_PROG.properties";
	public static final String MOCI_ATTCHWorkgroups = System.getProperty("user.dir")+"\\src\\main\\resource\\MOCI_PROG.properties";
	public static Long timeForExecution = (long) 0;
	public static int failedTestcaseCount = 0;
	public static final String BROWSER = BrowserWebDriver.CHROME;
	
}