package com.deere.global;

import static com.deere.global.GlobalThings.listOfBrowser;
import static com.deere.global.GlobalThings.listOfEmailId;
import static com.deere.global.GlobalThings.listOfEnv;
import static com.deere.global.GlobalThings.listOfInputs;
import static com.deere.global.GlobalThings.listOfsuite;
import static com.deere.global.GlobalThings.reportDirectory;
import static com.deere.global.GlobalThings.testDirectory;
import static com.deere.global.GlobalThings.testResultReports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.Key;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.xml.XmlInclude;

import com.deere.applicaionSpecific.GlobalThings;
import com.google.common.base.Function;

//import sun.misc.BASE64Decoder;

@SuppressWarnings("restriction")
public class CommonFunctions {
	private static final String ALGO = "AES";
	private static final byte[] keyValue = new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't',

			'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };
	public static String curDir;
	static FileOutputStream reportOut;
	static FileOutputStream reportBakOut;
	static HSSFWorkbook reportWorkbook;
	static HSSFSheet reportWorksheet;
	static HSSFWorkbook reportBakWorkbook;
	static HSSFSheet reportBakWorksheet;
	static HSSFWorkbook reportOrderBakWorkbook;
	static Integer currRow;
	static Integer currBakRow;

	/**
	 * Method to setup report directory
	 */
	public static void createReportDirectory() {
		String curTS = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Timestamp(new Date().getTime()));
		File file = new File(reportDirectory);
		file.mkdir();
		curDir = reportDirectory + curTS;
		file = new File(curDir);
		file.mkdir();
		createReportExcel();
	}

	public static String decrypt(String encryptedData) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, key);
		// byte[] decordedValue = new
		// BASE64Decoder().decodeBuffer(encryptedData);
		byte[] decordedValue = java.util.Base64.getDecoder().decode(encryptedData);
		byte[] decValue = c.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}

	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}

	public static boolean selectFromDropdownByIndex(int index, WebElement elmt) {
		try {
			Select select = new Select(elmt);
			select.selectByIndex(index);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private static void createReportExcel() {
		// Create report excel
		try {
			reportOut = new FileOutputStream(curDir + "/TestReport.xls");
			reportWorkbook = new HSSFWorkbook();
			reportWorksheet = reportWorkbook.createSheet("Result");
			reportBakOut = new FileOutputStream(curDir + "/TestReportBak.xls");
			reportBakWorkbook = new HSSFWorkbook();
			reportBakWorksheet = reportBakWorkbook.createSheet("Result");
			setColumnStyle();
			reportBakOut.flush();
			reportBakOut.close();
			reportOut.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		currRow = 0;
		currBakRow = 0;
	}

	private static void setColumnStyle() {
		for (int x = 0; x < 9; x++) {
			if (x == 0 || x == 1 || x == 2 || x == 5) {
				reportWorksheet.setColumnWidth(x, 4000);
				reportBakWorksheet.setColumnWidth(x, 4000);
			} else {
				reportWorksheet.setColumnWidth(x, 12800);
				reportBakWorksheet.setColumnWidth(x, 12800);
			}
		}
	}

	public static void getEnvironemtToBeExecuted() {
		try {
			FileInputStream file = new FileInputStream(new File(testDirectory + "JDQuote_AUT.xlsx"));
			XSSFWorkbook resultWorkbook;
			resultWorkbook = new XSSFWorkbook(file);
			XSSFSheet resultWorksheet = resultWorkbook.getSheet("Environment");
			/*
			 * HSSFWorkbook resultWorkbook; resultWorkbook = new
			 * HSSFWorkbook(file); HSSFSheet resultWorksheet =
			 * resultWorkbook.getSheet("Environment");
			 */
			Iterator<Row> rowIterator = resultWorksheet.iterator();
			iterateRowsAndColumnsForReadingAndStoringEnvironemt(rowIterator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private static void iterateRowsAndColumnsForReadingAndStoringEnvironemt(Iterator<Row> rowIterator) {
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			InputEnvironmentDetails inputEnvDetails = new InputEnvironmentDetails();
			if (row.getRowNum() > 0 && row.getCell(4)!=null &&  row.getCell(4).toString().equals("Y")) {
				Iterator<Cell> cellIterator = row.cellIterator();
				iterateColumnsAndBuildEnvObject(inputEnvDetails, cellIterator);
			}
			if (row.getRowNum() > 0 && inputEnvDetails.getExecute().equals("Y")) {
				listOfEnv.add(inputEnvDetails);
			}
		}

	}

	public static void getSuiteToBeExecuted() {
		try {
			FileInputStream file = new FileInputStream(new File(testDirectory + "JDQuote_AUT.xlsx"));
			XSSFWorkbook resultWorkbook;
			resultWorkbook = new XSSFWorkbook(file);
			XSSFSheet resultWorksheet = resultWorkbook.getSheet("Module");
			/*
			 * HSSFWorkbook resultWorkbook; resultWorkbook = new
			 * HSSFWorkbook(file); HSSFSheet resultWorksheet =
			 * resultWorkbook.getSheet("Module");
			 */
			Iterator<Row> rowIterator = resultWorksheet.iterator();
			iterateRowsAndColumnsForReadingAndStoringSuites(rowIterator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getBrowserToBeExecuted() {
		try {
			FileInputStream file = new FileInputStream(new File(testDirectory + "JDQuote_AUT.xlsx"));
			XSSFWorkbook resultWorkbook;
			resultWorkbook = new XSSFWorkbook(file);
			XSSFSheet resultWorksheet = resultWorkbook.getSheet("Browser");
			/*
			 * HSSFWorkbook resultWorkbook; resultWorkbook = new
			 * HSSFWorkbook(file); HSSFSheet resultWorksheet =
			 * resultWorkbook.getSheet("Browser");
			 */
			Iterator<Row> rowIterator = resultWorksheet.iterator();
			iterateRowsAndColumnsForReadingAndStoringBrowser(rowIterator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private static void iterateRowsAndColumnsForReadingAndStoringSuites(Iterator<Row> rowIterator) {
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			InputSuiteDetails inputSuiteDetails = new InputSuiteDetails();
			if (row.getRowNum() > 0 && row.getCell(3).toString().equals("Y")) {
				Iterator<Cell> cellIterator = row.cellIterator();
				iterateColumnsAndBuildSuiteObject(inputSuiteDetails, cellIterator);
			}
			if (row.getRowNum() > 0 && inputSuiteDetails.getExecute().equals("Y")) {
				listOfsuite.add(inputSuiteDetails);
			}
		}
	}

	@SuppressWarnings("unused")
	private static void iterateRowsAndColumnsForReadingAndStoringBrowser(Iterator<Row> rowIterator) {
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			InputBrowserDetails inputBrowserDetails = new InputBrowserDetails();
			if (row.getRowNum() > 0 && row.getCell(1).toString().equals("Y")) {
				Iterator<Cell> cellIterator = row.cellIterator();
				iterateColumnsAndBuildBrowserObject(inputBrowserDetails, cellIterator);
			}
			if (row.getRowNum() > 0 && inputBrowserDetails.getExecute().equals("Y")) {
				listOfBrowser.add(inputBrowserDetails);
			}
		}
	}

	/**
	 * Method to collect test case related information in list of
	 * InputTestDetails.class
	 */
	public static void getTestsToBeExecuted(String SheetName) {
		try {
			FileInputStream file = new FileInputStream(new File(testDirectory + "JDQuote_AUT.xlsx"));
			XSSFWorkbook resultWorkbook;
			resultWorkbook = new XSSFWorkbook(file);
			XSSFSheet resultWorksheet = resultWorkbook.getSheet(SheetName);
			/*
			 * HSSFWorkbook resultWorkbook; resultWorkbook = new
			 * HSSFWorkbook(file); HSSFSheet resultWorksheet =
			 * resultWorkbook.getSheet(SheetName);
			 */
			Iterator<Row> rowIterator = resultWorksheet.iterator();
			iterateRowsAndColumnsForReadingAndStoring(rowIterator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void iterateRowsAndColumnsForReadingAndStoring(Iterator<Row> rowIterator) {
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			InputTestDetails inputTestDetails = new InputTestDetails();
			if (row.getRowNum() > 0 && row.getCell(5).toString().equals("Y")) {
				Iterator<Cell> cellIterator = row.cellIterator();
				iterateColumnsAndBuildInputObject(inputTestDetails, cellIterator);
			}
			if (row.getRowNum() > 0 && inputTestDetails.getExecute().equals("Y")) {

				listOfInputs.add(inputTestDetails);
			}
		}
	}

	private static void iterateColumnsAndBuildEnvObject(InputEnvironmentDetails inputEnvDetails,
			Iterator<Cell> cellIterator) {
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			TestEnvironmentEnum testExcelEnum = TestEnvironmentEnum.getTestEnvironmentEnum(cell.getColumnIndex());
			testExcelEnum.process(cell, inputEnvDetails);
		}
	}

	private static void iterateColumnsAndBuildSuiteObject(InputSuiteDetails inputSuiteDetails,
			Iterator<Cell> cellIterator) {
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			TestSuiteEnum testExcelEnum = TestSuiteEnum.getTestExcelEnum(cell.getColumnIndex());
			testExcelEnum.process(cell, inputSuiteDetails);
		}
	}

	private static void iterateColumnsAndBuildBrowserObject(InputBrowserDetails inputBrowserDetails,
			Iterator<Cell> cellIterator) {
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			TestBrowserEnum testExcelEnum = TestBrowserEnum.getTestExcelEnum(cell.getColumnIndex());
			testExcelEnum.process(cell, inputBrowserDetails);
		}
	}

	private static void iterateColumnsAndBuildInputObject(InputTestDetails inputTestDetails,
			Iterator<Cell> cellIterator) {
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			TestExcelEnum testExcelEnum = TestExcelEnum.getTestExcelEnum(cell.getColumnIndex());
			testExcelEnum.process(cell, inputTestDetails);
		}
	}

	/**
	 * Method to execute test cases on collected in a List
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void executeTestCase(InputEnvironmentDetails inputEnvDetails) {
		ExecutorService executor = Executors.newFixedThreadPool(6);
		for (InputBrowserDetails inputBrowserDetails : listOfBrowser) {
			for (InputTestDetails inputTestDetails : listOfInputs) {
				Runnable worker = new WorkerThread(inputTestDetails, inputEnvDetails, inputBrowserDetails);
				executor.execute(worker);
			}
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}

	public static String getSelectedValueFromDropdown(By elmt, WebDriver driver) {
		Select s = new Select(driver.findElement(elmt));
		return s.getFirstSelectedOption().getText().trim();
	}

	public static boolean click(WebDriver driver, By elmt) {
		try {
			acceptAlert(driver);
			driver.findElement(elmt).click();
			CommonFunctions.waitForLoad(driver);
			return true;
		} catch (Exception e) {
			acceptAlert(driver);
			return false;
		}
	}

	public static boolean sendKeys(WebDriver driver, By elmt, String value) {
		try {
			driver.findElement(elmt).clear();
			driver.findElement(elmt).sendKeys(value);
			CommonFunctions.waitForLoad(driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * In case of Pass result send only first parameter and rest send as null
	 * 
	 * @param inputTestDetails
	 * @param exceptionError
	 * @param userDefinedError
	 * @param driver
	 * @return TestResultReport.class
	 * @throws Exception
	 */
	public static TestResultReport updateResultObject(InputTestDetails inputTestDetails, String techError,
			String functionalError, String userDefinedError, WebDriver driver, InputEnvironmentDetails inputEnvDetails,
			InputBrowserDetails inputBrowserDetails) throws Exception {
		String result = "Pass",
				sSPath = curDir + "\\" + inputTestDetails.getTestCaseID() + "_" + inputTestDetails.getRole() + ".png";
		TestResultReport testResultReport = new TestResultReport();
		if (techError != null || functionalError != null) {
			result = "Fail";
			// takeScreenShot(driver, sSPath, testResultReport);
			testResultReport.setFunctionalError(functionalError);
			testResultReport.setTechnicalError(techError);
			testResultReport.setUserDefinedError(userDefinedError);
			if (functionalError != null)
				AutomationEmail.sendFailedTCEmail(sSPath, functionalError, inputTestDetails.getTestCaseID(),
						inputTestDetails.getTestCaseDescription(), inputTestDetails.getFunctionalityFlow());
		}
		testResultReport.setEnvironment(inputEnvDetails.getEnvironment());
		testResultReport.setTestCaseId(inputTestDetails.getTestCaseID());
		testResultReport.setBrowser(inputBrowserDetails.getBrowserName());
		testResultReport.setTestCaseDescription(inputTestDetails.getTestCaseDescription());
		testResultReport.setResult(result);
		testResultReport.setTestData(GlobalThings.testData);
		/*
		 * if(exceptionError.contains("AssertionError"))
		 * AutomationEmail.sendFailedTCEmail(sSPath , exceptionError
		 * ,inputTestDetails.getTestCaseID() ,
		 * inputTestDetails.getTestCaseDescription());
		 */
		return testResultReport;
	}

	/*
	 * private static void takeScreenShot(WebDriver driver, String sSPath,
	 * TestResultReport testResultReport) { if(driver!=null){ File scrFile =
	 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); try {
	 * FileUtils.copyFile(scrFile, new File(sSPath)); } catch (IOException e) {
	 * e.printStackTrace(); } testResultReport.setSSPath(sSPath); }
	 * 
	 * }
	 */

	/**
	 * Function to write results in excel at the end of execution and launch
	 * report file
	 */
	public static void writeReportExcel() {
		HSSFRow row = reportWorksheet.createRow(currRow);
		HSSFFont font = reportWorkbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		HSSFCellStyle cellStyleHeader = reportWorkbook.createCellStyle();
		setReportHeader(row, cellStyleHeader, font);
		HSSFCellStyle cellStyleInGeneral = reportWorkbook.createCellStyle();
		HSSFCellStyle cellStyleForFailed = reportWorkbook.createCellStyle();
		HSSFCellStyle cellStyleForPass = reportWorkbook.createCellStyle();
		setReportStyle(cellStyleInGeneral, cellStyleForFailed, cellStyleForPass);
		updateReportRowsWithResult(cellStyleInGeneral, cellStyleForFailed, cellStyleForPass);
		writeReportExcelInWindowsFileSystem();
	}

	public static void writeBakReportExcel(TestResultReport testResultReport) {
		if (currBakRow == 0) {
			HSSFRow row = reportBakWorksheet.createRow(currBakRow);
			HSSFFont font = reportBakWorkbook.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			HSSFCellStyle cellStyleHeader = reportBakWorkbook.createCellStyle();
			setReportHeader(row, cellStyleHeader, font);
		}
		HSSFCellStyle cellStyleInGeneral = reportBakWorkbook.createCellStyle();
		HSSFCellStyle cellStyleForFailed = reportBakWorkbook.createCellStyle();
		HSSFCellStyle cellStyleForPass = reportBakWorkbook.createCellStyle();
		setReportStyle(cellStyleInGeneral, cellStyleForFailed, cellStyleForPass);
		updateReportRowsWithBackupResult(cellStyleInGeneral, cellStyleForFailed, cellStyleForPass, testResultReport);
		writeBakupReportExcelInWindowsFileSystem();
	}

	private static void updateReportRowsWithResult(HSSFCellStyle cellStyleInGeneral, HSSFCellStyle cellStyleForFailed,
			HSSFCellStyle cellStyleForPass) {
		HSSFRow row;
		HSSFCell cell;
		for (TestResultReport testResultReport : testResultReports) {
			currRow++;
			row = reportWorksheet.createRow(currRow);
			for (int i = 0; i < 9; i++) {
				cell = row.createCell(i);
				TestResultEnum testResultEnum = TestResultEnum.getTestResultEnum(i);
				testResultEnum.process(testResultReport, cell, cellStyleInGeneral, cellStyleForFailed,
						cellStyleForPass);
			}
		}
	}

	private static void updateReportRowsWithBackupResult(HSSFCellStyle cellStyleInGeneral,
			HSSFCellStyle cellStyleForFailed, HSSFCellStyle cellStyleForPass, TestResultReport testResultReport) {
		HSSFRow row;
		HSSFCell cell;
		currBakRow++;
		row = reportBakWorksheet.createRow(currBakRow);

		for (int i = 0; i < 9; i++) {
			cell = row.createCell(i);
			TestResultBakEnum testResultEnum = TestResultBakEnum.getTestResultEnum(i);
			testResultEnum.process(testResultReport, cell, cellStyleInGeneral, cellStyleForFailed, cellStyleForPass);
		}
	}

	private static void setReportHeader(HSSFRow row, HSSFCellStyle cellStyleHeader, HSSFFont font) {
		cellStyleHeader.setFillForegroundColor(HSSFColor.GOLD.index);
		cellStyleHeader.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyleHeader.setBorderBottom((short) 1);
		cellStyleHeader.setBorderLeft((short) 1);
		cellStyleHeader.setBorderRight((short) 1);
		cellStyleHeader.setBorderTop((short) 1);
		cellStyleHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyleHeader.setFont(font);
		putReportHeaders(row, cellStyleHeader);
	}

	private static void putReportHeaders(HSSFRow row, HSSFCellStyle cellStyleHeader) {
		HSSFCell cell;
		String[] columnHeadings = { "Environment", "Browser", "TestCase ID", "Description", "Test Data", "Result",
				"Screenshot Path", "Functional Error", "Script/Sync Error", "Error Description" };

		// loop for writing column headings
		for (int i = 0; i < columnHeadings.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(columnHeadings[i]);
			cell.setCellStyle(cellStyleHeader);
		}
	}

	private static void setReportStyle(HSSFCellStyle cellStyleInGeneral, HSSFCellStyle cellStyleForFailed,
			HSSFCellStyle cellStyleForPass) {
		cellStyleInGeneral.setWrapText(true);
		cellStyleInGeneral.setBorderBottom((short) 1);
		cellStyleInGeneral.setBorderLeft((short) 1);
		cellStyleInGeneral.setBorderRight((short) 1);
		cellStyleInGeneral.setBorderTop((short) 1);
		cellStyleForPass.setFillForegroundColor(HSSFColor.BRIGHT_GREEN.index);
		cellStyleForPass.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyleForFailed.setFillForegroundColor(HSSFColor.RED.index);
		cellStyleForFailed.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	}

	private static void writeReportExcelInWindowsFileSystem() {
		try {
			reportOut = new FileOutputStream(curDir + "/TestReport.xls");
			reportWorkbook.write(reportOut);
			reportOut.flush();
			reportOut.close();
			// String[] excelOpen = new String[]{"cmd.exe","/c",curDir +
			// "/TestReport.xls"};
			// Runtime.getRuntime().exec(excelOpen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeBakupReportExcelInWindowsFileSystem() {
		try {
			reportBakOut = new FileOutputStream(curDir + "/TestReportBak.xls");
			reportBakWorkbook.write(reportBakOut);
			reportBakOut.flush();
			reportBakOut.close();
			// String[] excelOpen = new String[]{"cmd.exe","/c",curDir +
			// "/TestReport.xls"};
			// Runtime.getRuntime().exec(excelOpen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used for element wait till presence of the element or
	 * prescribed time
	 * 
	 * @param driver
	 * @param elmt
	 * @param time
	 */
	public static boolean waitForAnObject(WebDriver driver, By elmt, Integer time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(presenceOfElementLocated(elmt));
			acceptAlert(driver);
			return true;
		}

		catch (Exception e) {
			acceptAlert(driver);
			return false;
		}
	}

	public static boolean waitForAlert(WebDriver driver, Integer time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (Throwable e) {
			return false;
		}
	}

	public static boolean acceptAlert(WebDriver driver) {
		try {
			driver.switchTo().alert().accept();
			return true;
		} catch (Throwable e) {
			return false;
		}
	}

	public static boolean dismissAlert(WebDriver driver) {
		try {
			driver.switchTo().alert().dismiss();
			return true;
		} catch (Throwable e) {
			return false;
		}
	}

	public static void waitForJQuery(WebDriver driver) {
		(new WebDriverWait(driver, 5)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				JavascriptExecutor js = (JavascriptExecutor) d;
				return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
			}
		});
	}

	public static Function<WebDriver, WebElement> presenceOfElementLocated(final By locator) {
		return new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		};
	}

	public static boolean waitForAnObjectToBeAvailable(WebDriver driver, By element, Integer time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
			return true;
		}

		catch (Exception e) {
			return false;
		}

	}

	public static boolean waitForAnObjectToBeVisible(WebDriver driver, By element, Integer time)
			throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
			acceptAlert(driver);
			return true;
		} catch (Exception e) {
			acceptAlert(driver);
			return false;
		}
	}

	public static boolean waitForAnObjectToBenVisible(WebDriver driver, By element, Integer time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
			acceptAlert(driver);
			return true;
		} catch (Exception e) {
			acceptAlert(driver);
			return false;
		}

	}

	public static boolean isEnabled(By elmt, WebDriver driver) {
		return driver.findElement(elmt).isEnabled();
	}

	public static void waitForAjax(WebDriver driver) throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		if ((Boolean) executor.executeScript("return window.jQuery != undefined")) {
			while (!(Boolean) executor.executeScript("return jQuery.active == 0")) {
				Thread.sleep(1000);
			}
		}
		acceptAlert(driver);
		return;
	}

	public static boolean selectFromDropdown(String Value, WebElement elmt) {
		try {
			Select select = new Select(elmt);
			select.selectByVisibleText(Value);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public static String getSelectedOption(WebElement elmt) {
		try {
			Select select = new Select(elmt);
			return select.getFirstSelectedOption().getText().trim();
		} catch (Exception e) {
			return null;
		}

	}

	public static boolean selectFromDropdownByValue(String value, WebElement elmt) throws InterruptedException {
		try {
			Select select = new Select(elmt);
			select.selectByValue(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String[] splitString(String splitChar, String stringvalue) {
		return stringvalue.split(splitChar);
	}

	public static String gettext(WebElement elmt) {
		return elmt.getText().trim();
	}

	public static String javaScriptGettext(WebDriver driver, By elmt) {
		return ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", driver.findElement(elmt))
				.toString();
	}

	public static void refrshPage(WebDriver driver) throws InterruptedException {
		driver.navigate().refresh();
		CommonFunctions.waitForLoad(driver);
		acceptAlert(driver);
	}

	public static String getAttributeValue(String attribute, WebElement elmt) {
		return elmt.getAttribute(attribute);
	}

	/*
	 * @SuppressWarnings({ "unchecked", "rawtypes" }) public static
	 * TestResultReport methodToHandleTryCatch(String className, String
	 * methodName, String [] pamameters, String errorMessage, InputTestDetails
	 * inputTestDetails, WebDriver driver,InputEnvironmentDetails
	 * inputEnvDetails) throws Exception{ Class methodClass =
	 * Class.forName(className); Class [] Parms = new Class [1]; Parms [0]=
	 * String[].class; Method method = methodClass.getDeclaredMethod(methodName,
	 * Parms); try{ method.invoke(methodClass, (Object[])pamameters); return
	 * CommonFunctions.updateResultObject(inputTestDetails, null, null , null,
	 * null,inputEnvDetails); }catch(Exception e){ e.printStackTrace(); return
	 * CommonFunctions.updateResultObject(inputTestDetails, e.toString(),
	 * errorMessage, driver,inputEnvDetails); } }
	 */

	public static void waitForLoad(WebDriver driver) throws InterruptedException {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				acceptAlert(driver);
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(pageLoadCondition);
	}

	public static int randomNumber() {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(25000 - 10000 + 1);
		// return randomGenerator.nextInt(25000-10000+1);
	}

	// FUNCTION TO DRAG AND DROP
	@SuppressWarnings("deprecation")
	public static boolean dragAndDrop(WebDriver driver, By Src, By Dest) {
		try {
			/*
			 * Point point = driver.findElement(Dest).getLocation(); int xcord =
			 * point.getX(); int ycord = point.getY();
			 * System.out.println(xcord+"----"+ycord); point =
			 * driver.findElement(Src).getLocation(); int xcord1 = point.getX();
			 * int ycord1 = point.getY();
			 * System.out.println(xcord1+"----"+ycord1); WebElement srcElement =
			 * driver.findElement(Src); WebElement destElement =
			 * driver.findElement(Dest);
			 */

			Actions builder = new Actions(driver);
			Action dragAndDrop = builder.clickAndHold(driver.findElement(Src)).moveToElement(driver.findElement(Dest))
					.release(driver.findElement(Dest)).build();
			dragAndDrop.perform();

			/*
			 * final Actions action = new Actions(driver); action.clickAndHold()
			 * .moveByOffset(-1, -1) // To fix issue with drag and drop in
			 * Chrome V61.0.3163.79 .moveToElement(driver.findElement(Dest),
			 * driver.findElement(Dest).getLocation().getX()+driver.findElement(
			 * Dest).getSize().getWidth()/2,
			 * driver.findElement(Dest).getLocation().getY()+driver.findElement(
			 * Dest).getSize().getHeight()/2) .release(driver.findElement(Dest))
			 * .build() .perform();
			 */

			// Drag 1st control to layout
			/*
			 * String js_filepath =
			 * "C:\\Users\\AN61450\\Documents\\MOCI_Automation\\Enhanced Framework\\drag_and_drop_helper.js"
			 * ; String java_script=""; String text;
			 * 
			 * BufferedReader input = new BufferedReader(new
			 * FileReader(js_filepath)); StringBuffer buffer = new
			 * StringBuffer();
			 * 
			 * while ((text = input.readLine()) != null) buffer.append(text +
			 * " "); java_script = buffer.toString();
			 * 
			 * input.close();
			 * 
			 * String source = "price-org"; String target =
			 * "create-event-drop-target"; java_script =
			 * java_script+"$('."+source+"').simulate( 'k" +target+ "');" ;
			 * ((JavascriptExecutor)driver).executeScript(java_script);
			 */

			/*
			 * Robot robot = new Robot(); robot.setAutoDelay(50);
			 * 
			 * //Fullscreen page so selenium coordinates work
			 * robot.keyPress(KeyEvent.VK_F11); Thread.sleep(2000);
			 * 
			 * //Get size of elements org.openqa.selenium.Dimension fromSize =
			 * driver.findElement(Src).getSize(); org.openqa.selenium.Dimension
			 * toSize = driver.findElement(Dest).getSize();
			 * 
			 * //Get centre distance int xCentreFrom = fromSize.width / 2; int
			 * yCentreFrom = fromSize.height / 2; int xCentreTo = toSize.width /
			 * 2; int yCentreTo = toSize.height / 2;
			 * 
			 * //Get x and y of WebElement to drag to Point toLocation =
			 * driver.findElement(Dest).getLocation(); Point fromLocation =
			 * driver.findElement(Src).getLocation();
			 * 
			 * //Make Mouse coordinate centre of element toLocation.x +=
			 * xCentreTo; toLocation.y += yCentreTo; fromLocation.x +=
			 * xCentreFrom; fromLocation.y += yCentreFrom;
			 * 
			 * //Move mouse to drag from location
			 * robot.mouseMove(fromLocation.x, fromLocation.y);
			 * 
			 * //Click and drag robot.mousePress(InputEvent.BUTTON1_MASK);
			 * 
			 * //Drag events require more than one movement to register //Just
			 * appearing at destination doesn't work so move halfway first
			 * robot.mouseMove(((toLocation.x - fromLocation.x) / 2) +
			 * fromLocation.x, ((toLocation.y - fromLocation.y) / 2) +
			 * fromLocation.y);
			 * 
			 * //Move to final position robot.mouseMove(toLocation.x,
			 * toLocation.y);
			 * 
			 * //Drop robot.mouseRelease(InputEvent.BUTTON1_MASK);
			 */

			/*
			 * final String java_script =
			 * "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe"
			 * +
			 * "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun"
			 * +
			 * "ction(format,data){this.items[format]=data;this.types.append(for"
			 * +
			 * "mat);},getData:function(format){return this.items[format];},clea"
			 * +
			 * "rData:function(format){}};var emit=function(event,target){var ev"
			 * +
			 * "t=document.createEvent('Event');evt.initEvent(event,true,false);"
			 * +
			 * "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('"
			 * +
			 * "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit("
			 * + "'drop',tgt);emit('dragend',src);"; JavascriptExecutor jse =
			 * (JavascriptExecutor) driver; jse.executeScript(java_script, Src,
			 * Dest); Thread.sleep(2000);
			 */
			// .moveByOffset(xcord,
			// ycord).release(driver.findElement(Src)).build().perform();
			/*
			 * Robot robot = new Robot(); robot.mouseMove(xcord1,ycord1); //The
			 * element I want to drag and move
			 * robot.mousePress(InputEvent.BUTTON1_MASK);
			 * robot.mouseMove(xcord,ycord); // the new location I want to move
			 * the element to robot.mouseRelease(InputEvent.BUTTON1_MASK);
			 */

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Sumit Kothari
	public static boolean dragAndDrop1(WebDriver driver) {
		try {
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath(".//*[@id='rgtCountryList']/li//img"))).sendKeys(Keys.ENTER)
					.dragAndDrop(driver.findElement(By.xpath(".//*[@id='rgtCountryList']/li//img")),
							driver.findElement(By.xpath(".//*[@id='mainAccordianList']/li")))
					.build().perform();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/// Vikram
	public static boolean clear(WebDriver driver, By elmt) {
		try {
			acceptAlert(driver);
			driver.findElement(elmt).clear();
			CommonFunctions.waitForLoad(driver);
			return true;
		} catch (Exception e) {
			acceptAlert(driver);
			return false;
		}
	}

	public static boolean elementSize(WebDriver driver, By elmt) {
		try {
			// acceptAlert(driver);
			driver.findElement(elmt).getSize();
			CommonFunctions.waitForLoad(driver);
			return true;
		} catch (Exception e) {
			acceptAlert(driver);
			return false;
		}
	}

	public static void javaScriptScrollUp(By elmt, WebDriver driver) {
		try {
			// JavascriptExecutor jse = (JavascriptExecutor)driver;
			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].scrollIntoView(true);",
			// elmt);
			// ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,
			// document.body.scrollHeight)");
			// ((JavascriptExecutor) driver).executeScript("scroll(0, -250);");
			// ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
			// jse.executeScript("window.scrollBy(0,-250)", "");
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			acceptAlert(driver);
		} catch (Throwable e) {
			acceptAlert(driver);
			driver.findElement(elmt).click();
		}

	}

	public static boolean isElementExist(WebDriver driver, By elmt) {
		try {
			driver.findElement(elmt);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isElementDisplayed(WebDriver driver, By elmt) {
		try {
			driver.findElement(elmt).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<XmlInclude> constructIncludes(String... methodNames) {
		List<XmlInclude> includes = new ArrayList<XmlInclude>();
		for (String eachMethod : methodNames) {
			includes.add(new XmlInclude(eachMethod));
		}
		return includes;
	}

	public static int convertStringToInt(String value) {
		return (Integer.parseInt(value));
	}

	public static float convertStringToFloat(String value) {
		return Float.parseFloat(value);
	}

	public static BigDecimal convertStringToDouble(String value) {
		double costBasis = Double.valueOf(value).doubleValue(); // Assume the
																// string
																// "12345.123456789088888"
																// as teh one
																// read from the
																// txtfield
		BigDecimal d = new BigDecimal(costBasis);
		return d.setScale(2, d.ROUND_UP);
	}

	public static void javaScriptClick(By elmt, WebDriver driver) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(elmt));
			acceptAlert(driver);
		} catch (Throwable e) {
			acceptAlert(driver);
			driver.findElement(elmt).click();
		}

	}

	public static void highlightElement(By elmt, WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(elmt));
		Thread.sleep(1000);
		js.executeScript("arguments[0].style.border=''", driver.findElement(elmt));
		Thread.sleep(1000);
	}

	public static WebElement findElement(final WebDriver driver, final By locator, final int timeoutSeconds) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeoutSeconds, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(InvalidElementStateException.class, StaleElementReferenceException.class);

		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver webDriver) {
				return driver.findElement(locator);
			}
		});
	}

	public static void javaScriptClearAndSetContents(WebDriver driver, By elmt, String value)
			throws InterruptedException {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value = '';", driver.findElement(elmt));
		Thread.sleep(2000);
		executor.executeScript("arguments[0].value = '" + value + "';", driver.findElement(elmt));
	}

	public static boolean checkFileExist(String path) {
		try {
			File xx = new File(path);
			if (xx.exists()) {
				xx.delete();
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void refreshWindow(WebDriver driver) {
		try {
			driver.navigate().refresh();
			acceptAlert(driver);
		} catch (Throwable t) {
			acceptAlert(driver);
		}

	}

	public static boolean checkDateAfterOrEqualExpDate(String expDate, String actualDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		Date date1 = sdf.parse(expDate);
		Date date2 = sdf.parse(actualDate);

		if (date1.after(date2)) {
			return false;
		}
		// before() will return true if and only if date1 is before date2
		else if (date1.before(date2)) {
			return true;
		}

		else if (date1.equals(date2)) {
			return true;
		}

		return false;
	}

	/*
	 * public static boolean checkFilesAtRemoteMachine(String host , String
	 * userName , String pass , String port , String dirPath) throws Exception{
	 * String SFTPHOST = host; int SFTPPORT = Integer.valueOf(port); String
	 * SFTPUSER = CommonFunctions.decrypt(userName); String SFTPPASS =
	 * CommonFunctions.decrypt(pass);; String SFTPWORKINGDIR = dirPath;
	 * 
	 * Session session = null; Channel channel = null; ChannelSftp channelSftp =
	 * null;
	 * 
	 * try{ JSch jsch = new JSch(); session =
	 * jsch.getSession(SFTPUSER,SFTPHOST,SFTPPORT);
	 * session.setPassword(SFTPPASS); java.util.Properties config = new
	 * java.util.Properties(); config.put("StrictHostKeyChecking", "no");
	 * session.setConfig(config); session.connect(); channel =
	 * session.openChannel("sftp"); channel.connect(); channelSftp =
	 * (ChannelSftp)channel; channelSftp.cd(SFTPWORKINGDIR); Vector filelist =
	 * channelSftp.ls(SFTPWORKINGDIR); if(filelist.size()>2){
	 * System.out.println(filelist.size()); session.disconnect(); return true; }
	 * else { System.out.println(filelist.size()); session.disconnect(); return
	 * false; }
	 * 
	 * 
	 * }catch(Exception ex){ ex.printStackTrace(); session.disconnect(); return
	 * false; }
	 * 
	 * }
	 */

	// Added by Sumit 25 oct 2017
	public static void waitForAnObjectToBeClickable(WebDriver driver, By loadingImg, By element, Integer time)
			throws InterruptedException {
		CommonFunctions.waitForAnObjectToBenVisible(driver, loadingImg, time);
		CommonFunctions.waitForLoad(driver);
		CommonFunctions.waitForAnObject(driver, element, time);
		CommonFunctions.waitForAnObjectToBeAvailable(driver, element, time);
	}

	public static WebElement findElementNoSuchElement(final WebDriver driver, final By locator,
			final int timeoutSeconds) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeoutSeconds, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(InvalidElementStateException.class, org.openqa.selenium.NoSuchElementException.class);

		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver webDriver) {
				return driver.findElement(locator);
			}
		});
	}

	public static void javaScriptScrollDown(WebDriver driver, Integer pixels) {
		JavascriptExecutor executor = ((JavascriptExecutor) driver);
		executor.executeScript("scroll(0," + pixels + ")");
	}

	/*
	 * public static void javaScriptScrollDown(By elmt ,WebDriver driver) { try{
	 * JavascriptExecutor jse = (JavascriptExecutor)driver;
	 * ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].scrollIntoView(true);", elmt);
	 * //((JavascriptExecutor)
	 * driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	 * // ((JavascriptExecutor) driver).executeScript("scroll(0, 1250);");
	 * acceptAlert(driver); }catch(Throwable e){ acceptAlert(driver);
	 * //driver.findElement(elmt).click(); }
	 * 
	 * }
	 */

	public static void javaScriptScrollDown(By elmt, WebDriver driver) // ******duplicate
	{
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elmt);
			// ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,
			// document.body.scrollHeight)");
			// ((JavascriptExecutor) driver).executeScript("scroll(0, 1250);");
			acceptAlert(driver);
		} catch (Throwable e) {
			acceptAlert(driver);
		}

	}

	public static String removeCommaFromStr(String str) {
		String newStr = str.replaceAll(",", "");
		return newStr;
	}

	public static String generateRandomString(int length) {
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String randomString = sb.toString();
		return randomString;
	}

	public static String generateRandomNumber(int length) {
		char[] chars = "0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String randomString = sb.toString();
		return randomString;
	}

	public static String FirstLatertoUppercase(String str) {

		String[] string = str.split(" ");
		StringBuffer stringbuff = new StringBuffer();

		for (int i = 0; i < string.length; i++) {

			stringbuff.append(string[i].charAt(0)).append(string[i].substring(1).toLowerCase());

		}

		return stringbuff.toString().trim();
	}

	public static void getEmailId() {
		try {
			FileInputStream file = new FileInputStream(new File(testDirectory + "JDQuote_AUT.xlsx"));
			XSSFWorkbook resultWorkbook;
			resultWorkbook = new XSSFWorkbook(file);
			XSSFSheet resultWorksheet = resultWorkbook.getSheet("EmailId");
			Iterator<Row> rowIterator = resultWorksheet.iterator();
			iterateRowsAndColumnsForReadingAndStoringEmailId(rowIterator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private static void iterateRowsAndColumnsForReadingAndStoringEmailId(Iterator<Row> rowIterator) {
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			InputEmailIdDetails inputEmailIdDetails = new InputEmailIdDetails();
			if (row.getRowNum() > 0 && row.getCell(1).toString().equals("Y")) {
				Iterator<Cell> cellIterator = row.cellIterator();
				iterateColumnsAndBuildEmailIdObject(inputEmailIdDetails, cellIterator);
			}
			if (row.getRowNum() > 0 && inputEmailIdDetails.getExecute().equals("Y")) {
				listOfEmailId.add(inputEmailIdDetails);
			}
		}
	}

	private static void iterateColumnsAndBuildEmailIdObject(InputEmailIdDetails inputEmailIdDetails,
			Iterator<Cell> cellIterator) {
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			TestEmailEnum testExcelEnum = TestEmailEnum.getTestExcelEnum(cell.getColumnIndex());
			testExcelEnum.process(cell, inputEmailIdDetails);
		}
	}

	public static double roundUpDouble(double value) {
		BigDecimal bd = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
		double newInput = bd.doubleValue();
		return newInput;
	}

	public static void switchToFramewithIndex(WebDriver driver, int index) {
		 driver.switchTo().frame(index);

	}
	 
	public static void switchToFramewithId(WebDriver driver, String frameId) {
			driver.switchTo().frame(frameId);

		}

	public static void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public static void switchToAlert(WebDriver driver) {
		driver.switchTo().alert();
	}

	public static int randomNumberGenerator(int size) {
		int ranNumber;
		Random ran = new Random();
		ranNumber = ran.nextInt(size);
		return ranNumber;
	}

	public static void switchToChildWindow(WebDriver driver) {
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();

		String parentWindow = it.next();
		System.out.println("Parent Window id:" + parentWindow);

		String childWindow = it.next();
		System.out.println("Child Window Id:" + childWindow);

		driver.switchTo().window(childWindow);

		System.out.println(driver.getTitle());

	}

	public static void switchToParentWindow(WebDriver driver) {
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();

		String parentWindow = it.next();
		System.out.println("Parent Window id:" + parentWindow);

		driver.switchTo().window(parentWindow);

		System.out.println(driver.getTitle());
	}

	public static void explicitWaitClickOn(WebDriver driver, int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
	}

	// ScrollToWebElement
	public static void scrollToElement(WebDriver driver, WebElement element) {
		// WebElement elem = driver.findElement(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void switchToFrameWithFrameName(WebDriver driver, String fname) {
		driver.switchTo().frame(fname);
	}
	

	private static WebDriverWait wait;

	public static boolean explicitWaitWebElement(WebDriver driver, WebElement element) {
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void javaScriptScrollUp(WebDriver driver, Integer pixels) {
		JavascriptExecutor executor = ((JavascriptExecutor) driver);
		executor.executeScript("scroll(" + pixels + ",0)");
	}

	public static void clickOnElement(WebDriver driver, WebElement element) {
		element.click();
	}

	public static void downloadFile(WebDriver driver, WebElement element) throws InterruptedException

	{
		File folder;
		folder = new File("C:\\Users\\sp23213\\Documents\\Project\\qa-JDautomation12(Useful)\\Drivers\\JDQuote2");
		if (element.isDisplayed()) {
			driver.manage().window().maximize();
			element.click();
		} else
			System.out.println("WebElement not displayed ");
		Thread.sleep(30000);
		File listOfFiles[] = folder.listFiles();
		Assert.assertTrue(listOfFiles.length > 0);
		for (File file : listOfFiles) {
			Assert.assertTrue(file.length() > 0);
			System.out.println("File downloaded Successfully");
		}
		for (File file : folder.listFiles()) {
			file.delete();
			System.out.println("Downloaded file successfully deleted.");
		}
	}
	
	public static boolean isAlertPresent(WebDriver driver)
	{
		try
		{
		  driver.switchTo().alert();
		  return true;
		 }
		catch(NoAlertPresentException ex)
		{
		  return false;
		 }
	}
	
	public static StringBuffer separateDigitsFromString(String str)
	{
		StringBuffer num = new StringBuffer();
		for(int l=0; l<str.length();l++)
		{
			 if (Character.isDigit(str.charAt(l)))
			{
				num.append(str.charAt(l));
			}
		}
		return num;
	}
	
	public static void isExpanded(WebElement ele)
	{
		String value = ele.getAttribute("alt");
		System.out.println(value);
		if(value.equals("Expand"))
			ele.click();
	}
			

	//
	// public static void handleframes(WebDriver driver, WebElement element ){
	// driver.switchTo().frame(element);
	// driver.switchTo().defaultContent();
	//
	// }}

}
