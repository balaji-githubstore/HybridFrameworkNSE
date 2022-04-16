package com.nse.utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataUtils {

//	@DataProvider
//	public String[][] validCredentialData() throws IOException {
//		String[][] main = ExcelUtils.getSheetIntoTwoDimArray("data/TestData.xlsx", "validCredentialTest");
//		return main;
//	}
//
//	@DataProvider
//	public String[][] invalidCredentialData() throws IOException {
//
//		String[][] main = ExcelUtils.getSheetIntoTwoDimArray("data/TestData.xlsx", "invalidCredentialTest");
//		return main;
//	}

	@DataProvider
	public String[][] commonDataProvider(Method method) throws Exception {
		
		//testMethodName and sheetname should be same
		String testMethodName=method.getName();
		
		String[][] main = ExcelUtils.getSheetIntoTwoDimArray("data/TestData.xlsx", testMethodName);
		return main;
	}
	
}
