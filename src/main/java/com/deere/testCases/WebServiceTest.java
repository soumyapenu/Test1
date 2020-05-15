package com.deere.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.deere.global.CommonFunctions;
import com.deere.global.InputBrowserDetails;
import com.deere.global.InputEnvironmentDetails;
import com.deere.global.InputTestDetails;
import com.deere.global.TestResultReport;
import com.deere.pages.WebServicePage;

public class WebServiceTest {
	public static TestResultReport test_TCNQ001(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {

		WebServicePage webServicePage = new WebServicePage();
		webServicePage.getSoapResponse(inputTestDetails);
		webServicePage.readResponse(inputTestDetails);

		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}



	public static TestResultReport test_TCNQ002(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {

		WebServicePage webServicePage = new WebServicePage();
		webServicePage.getRestResponseForGetRequests(inputTestDetails);
		webServicePage.readJsonRespons(inputTestDetails);

		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}


	public static TestResultReport test_TCNQ003(InputTestDetails inputTestDetails,
			InputEnvironmentDetails inputEnvDetails, InputBrowserDetails inputBrowserDetails, WebDriver driver)
			throws WebDriverException, Exception {

		WebServicePage webServicePage = new WebServicePage();
		webServicePage.getRestResponseForPOSTRequests(inputTestDetails);
		webServicePage.readJsonRespons(inputTestDetails);

		return CommonFunctions.updateResultObject(inputTestDetails, null, null, null, null, inputEnvDetails,
				inputBrowserDetails);
	}

}
