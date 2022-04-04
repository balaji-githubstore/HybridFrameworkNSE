package com.nse.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nse.base.WebDriverWrapper;

public class EmployeeTest extends WebDriverWrapper {
	
	@Test
	public void addEmployeeTest()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.partialLinkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		driver.findElement(By.id("firstName")).sendKeys("john");
		//complete remaining steps
		
	}

}
