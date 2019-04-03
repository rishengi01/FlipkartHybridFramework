package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.testbase.TestBase;

public class TestUtil extends TestBase {

	public static long implicitlywaittimeout=30;
	
	public static String TestdataSheetPath="C:\\Users\\Rishabh\\workspace\\FlipkartHybridFramework\\src\\main\\java\\com\\qa\\testdata\\TestDataSheet.xls";
	
	//public String Sheetname="datapro";
	
	static Workbook book;
	static Sheet sheet;
	
	
	
public static Object[][] getdatafromexcel(String Sheetname) throws IOException 
	
	{
		// TODO Auto-generated method stub
		
		Object[][] arrayobject= null;
		
		
		try {
			FileInputStream fs = new FileInputStream(TestdataSheetPath);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			
			HSSFSheet sheet = wb.getSheet(Sheetname);
            
			int totalNoOfRows = sheet.getLastRowNum();
			System.out.println(sheet.getFirstRowNum());
			System.out.println(totalNoOfRows);
			int totalNoOfCols = sheet.getRow(0).getLastCellNum();
			System.out.println(totalNoOfCols);
			
			arrayobject = new String[totalNoOfRows][totalNoOfCols];
			
			for (int i= 1 ; i <= totalNoOfRows; i++) 
			{

				for (int j=0; j < totalNoOfCols; j++) 
				{
					arrayobject[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println(arrayobject[i-1][j]);
				}

			}
			
		}
		
		
				catch (FileNotFoundException e) {
					e.printStackTrace();	
					
				}
		
					return arrayobject;
	
	}

/*
public static Object[][] getTestData(String sheetName) {
	FileInputStream file = null;
	try {
		file = new FileInputStream(TESTDATA_SHEET_PATH);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		book = WorkbookFactory.create(file);
	} catch (InvalidFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	sheet = book.getSheet(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	// System.out.println(sheet.getLastRowNum() + "--------" +
	// sheet.getRow(0).getLastCellNum());
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			// System.out.println(data[i][k]);
		}
	}
	return data;
}
	
*/	

   public static void takeScreenshotAtEndOfTest() throws IOException {
	   
	File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String currentdir=System.getProperty("user.dir");
	System.out.println(currentdir);
	
	FileUtils.copyFile(srcfile, new File(currentdir+"/screenshot/"+System.currentTimeMillis()+".png"));
	   
	   
	   
	   
}
  
	
}
