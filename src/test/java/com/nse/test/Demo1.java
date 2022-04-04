package com.nse.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo1 {

	public static void main(String[] args) throws IOException {
	
			
		FileInputStream file=new FileInputStream("data/TestData.xlsx");
		
		XSSFWorkbook book=new XSSFWorkbook(file);
		
		XSSFSheet sheet=  book.getSheet("invalidCredentialTest");
		
		String cellValue= sheet.getRow(2).getCell(0).getStringCellValue();
		
		System.out.println(cellValue);
		
		
		
	}

}
