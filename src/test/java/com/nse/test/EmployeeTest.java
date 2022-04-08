package com.nse.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nse.base.WebDriverWrapper;
import com.nse.pages.LoginPage;
import com.nse.utilities.DataUtils;

public class EmployeeTest extends WebDriverWrapper {
	
	@Test(dataProviderClass = DataUtils.class, dataProvider = "commonDataProvider")
	public void addEmployeeTest(String username,String password,String firstName)
	{
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLogin();	
		driver.findElement(By.partialLinkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		//complete remaining steps
		
	}

}
