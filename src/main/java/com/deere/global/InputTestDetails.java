package com.deere.global;

/**
 * 
 * @author ng58485
 * This class will provide and object which will hold parameters read from test cases list file
 * The columns for this file should be as below
 * 1. Test Case ID
 * 2. Description
 * 3. Module
 * 4. Execute
 * 5. Environment
 * 6. Test Data (this contains all the required parameters separated by ';')
 */
public class InputTestDetails {
	private String testCaseID, functionality,functionalityFlow,testCaseDescription, module, execute, environment, role;
	private String [] testdata;
	
	public InputTestDetails() {
		this.testCaseID = "";
		this.functionality="";
		this.testCaseDescription = "";
		this.module = "";
		this.functionalityFlow="";
		this.execute = "N";
		this.role = "";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTestCaseID() {
		return testCaseID;
	}

	public void setTestCaseID(String testCaseID) {
		this.testCaseID = testCaseID;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getTestCaseDescription() {
		return testCaseDescription;
	}

	public void setTestCaseDescription(String description) {
		this.testCaseDescription = description;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getExecute() {
		return execute;
	}

	public void setExecute(String execute) {
		this.execute = execute;
	}
	
	public String getFunctionality() {
		return functionality;
	}

	public void setFunctionality(String functionality) {
		this.functionality = functionality;
	}

	public String getFunctionalityFlow() {
		return functionalityFlow;
	}

	public void setfunctionalityFlow(String functionalityFlow) {
		this.functionalityFlow = functionalityFlow;
	}

	public String[] getTestdata() {
		return testdata;
	}

	public void setTestdata(String[] testdata) {
		this.testdata = testdata;
	}
	
	
}

