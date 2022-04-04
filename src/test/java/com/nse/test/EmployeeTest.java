package com.nse.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nse.base.WebDriverWrapper;
import com.nse.utilities.DataUtils;

public class EmployeeTest extends WebDriverWrapper {
	
	@Test(dataProviderClass = DataUtils.class, dataProvider = "commonDataProvider")
	public void addEmployeeTest(String username,String password,String firstName)
	{
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.partialLinkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		//complete remaining steps
		
	}

}
