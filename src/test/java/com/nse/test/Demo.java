package com.nse.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Demo {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream file=new FileInputStream("data/data.properties");
		
		Properties prop=new Properties();
		prop.load(file);
		
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("browser"));
	}

}
