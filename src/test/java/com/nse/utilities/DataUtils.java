package com.nse.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataUtils {

	@DataProvider
	public String[][] validCredentialData() throws IOException {
		String[][] main = ExcelUtils.getSheetIntoTwoDimArray("data/TestData.xlsx", "validCredentialTest");
		return main;
	}

	@DataProvider
	public String[][] invalidCredentialData() throws IOException {

		String[][] main = ExcelUtils.getSheetIntoTwoDimArray("data/TestData.xlsx", "invalidCredentialTest");
		return main;
	}

}
