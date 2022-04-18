package com.nse.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropUtils {

	public static String getPropValue(String key) throws IOException {
		FileInputStream file = new FileInputStream("data/data.properties");

		Properties prop = new Properties();
		prop.load(file);

		return prop.getProperty(key);
	}

}
