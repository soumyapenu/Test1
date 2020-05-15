package com.deere.global;

import static com.deere.global.GlobalThings.failedTestcaseCount;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;

public enum TestResultBakEnum {
	SET_ENVIRONMENT(0){
		@Override
		public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,HSSFCellStyle cellStyleForFailed,HSSFCellStyle cellStyleForPass) {
			cell.setCellValue(testResultReport.getEnvironment());	
			cell.setCellStyle(cellStyleInGeneral);
		}
	},
	SET_Browser(1){
		@Override
		public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,HSSFCellStyle cellStyleForFailed,HSSFCellStyle cellStyleForPass) {
			cell.setCellValue(testResultReport.getBrowser());	
			cell.setCellStyle(cellStyleInGeneral);
		}
	},
	SET_TEST_ID(2){
		@Override
		public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,HSSFCellStyle cellStyleForFailed,HSSFCellStyle cellStyleForPass) {
			cell.setCellValue(testResultReport.getTestCaseId());	
			cell.setCellStyle(cellStyleInGeneral);
		}
	},SET_TEST_DESCRIPTION(3){
		@Override
		public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,HSSFCellStyle cellStyleForFailed,HSSFCellStyle cellStyleForPass) {
			cell.setCellValue(testResultReport.getTestCaseDescription());	
			cell.setCellStyle(cellStyleInGeneral);
		}
	},
	TestData(4){
		@Override
		public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,HSSFCellStyle cellStyleForFailed,HSSFCellStyle cellStyleForPass) {
			cell.setCellValue(testResultReport.getTestData(testResultReport.getTestCaseId()));	
			cell.setCellStyle(cellStyleInGeneral);
		}
	},

	SET_TEST_RESULT(5){
		@Override
		public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,HSSFCellStyle cellStyleForFailed,HSSFCellStyle cellStyleForPass) {
			cell.setCellValue(testResultReport.getResult());	
			if(testResultReport.getResult().equals("Fail")) {
				cell.setCellStyle(cellStyleForFailed);
			} else {
				cell.setCellStyle(cellStyleForPass);
			}
		}
	},SET_SCREENSHOT_PATH(6){
		@Override
		public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,HSSFCellStyle cellStyleForFailed,HSSFCellStyle cellStyleForPass) {
			cell.setCellValue(testResultReport.getSSPath());	
			cell.setCellStyle(cellStyleInGeneral);
		}
	},SET_FUNCTIONAL_ERROR(7){
		@Override
		public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,HSSFCellStyle cellStyleForFailed,HSSFCellStyle cellStyleForPass) {
			cell.setCellValue(testResultReport.getFunctionalError());	
			cell.setCellStyle(cellStyleInGeneral);
		}
	},SET_TECHNICAL_ERROR(8){
		@Override
		public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,HSSFCellStyle cellStyleForFailed,HSSFCellStyle cellStyleForPass) {
			cell.setCellValue(testResultReport.getTechnicalError());	
			cell.setCellStyle(cellStyleInGeneral);
		}
	},SET_USERDEFINED_ERROR(9){
		@Override
		public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,HSSFCellStyle cellStyleForFailed,HSSFCellStyle cellStyleForPass) {
			cell.setCellValue(testResultReport.getUserDefinedError());	
			cell.setCellStyle(cellStyleInGeneral);
		}
	};

	private static Map<Integer, TestResultBakEnum> map = new HashMap<Integer, TestResultBakEnum>();
	private Integer cellValue;

	static{
		TestResultBakEnum[] values = TestResultBakEnum.values();
		for(TestResultBakEnum testResultEnum:values){
			map.put(testResultEnum.getCellValue(), testResultEnum);
		}
	}

	private TestResultBakEnum (Integer cellValue){
		this.cellValue = cellValue;
	}

	public Integer getCellValue() {
		return cellValue;
	}

	public static TestResultBakEnum getTestResultEnum(Integer cellColumnIndex){
		return map.get(cellColumnIndex);
	}

	public abstract void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,HSSFCellStyle cellStyleForFailed,HSSFCellStyle cellStyleForPass);
}
