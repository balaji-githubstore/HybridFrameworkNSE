package com.nse.utilities;

import org.testng.annotations.DataProvider;

public class DataUtils {
	
	@DataProvider
	public String[][] validCredentialData()
	{
		String[][] main=new String[2][3];
		
		main[0][0] = "Admin";
		main[0][1] = "admin123";
		main[0][2] = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";

		main[1][0] = "Admin";
		main[1][1] = "admin123";
		main[1][2] = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";

		return main;
	}

	@DataProvider
	public String[][] invalidCredentialData() {
		String[][] main = new String[4][3];

			main[0][0] = "john";
			main[0][1] = "john123";
			main[0][2] = "Invalid credentials";
	
			main[1][0] = "peter";
			main[1][1] = "peter123";
			main[1][2] = "Invalid credentials";
			
			main[2][0]="";
			main[2][1]="pass123";
			main[2][2]="Username cannot be empty";
			
			main[3][0]="admin";
			main[3][1]="";
			main[3][2]="Password cannot be empty";

		return main;
	}

}
