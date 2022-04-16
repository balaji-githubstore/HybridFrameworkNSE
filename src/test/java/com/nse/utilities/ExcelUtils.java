package com.nse.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static String[][] getSheetIntoTwoDimArray(String path, String sheetName) throws Exception {
		FileInputStream file = null;
		XSSFWorkbook book = null;
		String[][] main = null;

		try {
			file = new FileInputStream(path);
			book = new XSSFWorkbook(file);
			XSSFSheet sheet = book.getSheet(sheetName);
			int rowCount = sheet.getPhysicalNumberOfRows();
			int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();

			main = new String[rowCount - 1][cellCount];

			DataFormatter format = new DataFormatter();
			for (int r = 1; r < rowCount; r++) {
				for (int c = 0; c < cellCount; c++) {
					main[r - 1][c] = format.formatCellValue(sheet.getRow(r).getCell(c));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		} finally {
			book.close();
			file.close();
		}

		return main;

	}

}
