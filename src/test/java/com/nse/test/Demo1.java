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
		
		String[][] main=new String[2][3];
		
		for(int r=1;r<3;r++)
		{
			for(int c=0;c<3;c++)
			{
				String cellValue= sheet.getRow(r).getCell(c).getStringCellValue();
				System.out.println(cellValue);
				main[r-1][c]=cellValue;
			}
		}
		
		System.out.println(main);
		
	}

}
