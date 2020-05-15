package com.deere.global;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;

public enum TestEmailEnum {
	
	Email(0) {
		@Override
		public void process(Cell cell, InputEmailIdDetails inputEmailIdDetails) {
			inputEmailIdDetails.setEmaild((cell.getStringCellValue().toString()));
		}
	},
	Flag(1) {
		@Override
		public void process(Cell cell, InputEmailIdDetails inputEmailIdDetails) {
			inputEmailIdDetails.setExecute((cell.getStringCellValue().toString()));
		}
	};

	
	private static Map<Integer, TestEmailEnum> map = new HashMap<Integer, TestEmailEnum>();
	private Integer cellId;
	
	static{
		TestEmailEnum[] values = TestEmailEnum.values();

		for (TestEmailEnum testExcelEnum : values) {
			map.put(testExcelEnum.getCellId(), testExcelEnum);
		}
	}
	
	
	private TestEmailEnum(Integer cellId) {
		this.cellId = cellId;
	}

	public Integer getCellId() {
		return cellId;
	}

	public static TestEmailEnum getTestExcelEnum(Integer value) {
		return map.get(value);
	}
	
	public abstract void process(Cell cell, InputEmailIdDetails inputEmailIdDetails);
}
