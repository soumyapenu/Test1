package com.deere.global;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcelFile {
	
	
    

	
	public static void main(String[] args) throws IOException {
	
		String filePath = "C:\\MOCI_AUTOMATION\\Enhanced Framework\\ExcelFile"; 
		String fileName = "M0002-E000867-P011940_V0002-C0000-D11JAN2018.xlsx";
		String sheetName = "WG Price";
		readExcel(filePath,fileName,sheetName);
		
	}
	
	
	
	
		// TODO Auto-generated method stub
		public static void readExcel(String filePath,String fileName,String sheetName) throws IOException{

		    //Create an object of File class to open xlsx file

		    File file =    new File(filePath+"\\"+fileName);
			
			//File file =    new File("C:/MOCI_AUTOMATION/Enhanced Framework/ExcelFile/M0002-E000867-P011940_V0002-C0000-D11JAN2018.xlsx"); 

		    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = new FileInputStream(file);
		    Workbook wrkbook = null;
		    
		    String fileExtensionName = fileName.substring(fileName.indexOf("."));

		    //Check condition if the file is xlsx file

		    if(fileExtensionName.equals(".xlsx")){

		    //If it is xlsx file then create object of XSSFWorkbook class

		    	wrkbook = new XSSFWorkbook(inputStream);

		    }
		    
		    else if(fileExtensionName.equals(".xls")){

		        //If it is xls file then create object of XSSFWorkbook class

		    	wrkbook = new HSSFWorkbook(inputStream);
		    }
		    	
		    	Sheet wrkGroupSheet = wrkbook.getSheet(sheetName);
		    	int rowCount = wrkGroupSheet.getLastRowNum()-wrkGroupSheet.getFirstRowNum();
		    	//XSSFCell row=null;
		    	
		    	 for (int i = 0; i < rowCount; i++) {
		    		 //row    = wrkGroupSheet.getRow(i).getCell(1);

		    	        Row row = wrkGroupSheet.getRow(i);

		    	        //Create a loop to print cell values in a row
		    	        int j=0;
		    	        while(j < row.getLastCellNum())
		    	        {
		    	       // for (int j = 0; j < row.getLastCellNum(); j++) {

		    	            //Print Excel data in console
		    	        	String val = null;
		    	        	Cell value = row.getCell(j);
		    	        	if(value!=null)
		    	        	{	
		    	        	val = value.toString();
		    	        	if(val.equals("Event Name:"))
		    	        		System.out.println("Event Name = "+row.getCell(j+1)+"|| ");
		    	        	else if(val.equals("Event Type:"))
		    	        		System.out.println("Event Type = "+row.getCell(j+1)+"|| ");
		    	        	else if(val.equals("Program:"))
		    	        		System.out.println("Program Name = "+row.getCell(j+1)+"|| ");
		    	        	else if(val.equals("Program Version:"))
		    	        		System.out.println("Program Version = "+row.getCell(j+1)+"|| ");
		    	        	else if(val.equals("Priced At:"))
		    	        		System.out.println("Priced At = "+row.getCell(j+1)+"|| ");
		    	        	else if(val.equals("Price Area:"))
		    	        		System.out.println("Price Area = "+row.getCell(j+1)+"|| ");
		    	        	else if(val.equals("Map:"))
		    	        		System.out.println("Map = "+row.getCell(j+1)+"|| ");
		    	        	else if(val.equals("Product Hierarchy:"))
		    	        		System.out.println("Product Hierarchy = "+row.getCell(j+1)+"|| ");
		    	        	/*else if(val.equals("NULL"))
		    	        	System.out.println("Hi");*/
		    	        	j++;
		    	        	}
		    	        	
		    	        	else
		    	        		j++;
		    	        	
		    	            //System.out.print(row.getCell(j)+"|| ");

		    	        }

		    	        System.out.println();

		    	    }

		    }

	}











