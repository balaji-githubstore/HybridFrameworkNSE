package com.nse.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nse.base.WebDriverWrapper;
	
public class LoginTest extends WebDriverWrapper {
	
	@Test
	public void invalidCredentialTest()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("john");
		driver.findElement(By.id("txtPassword")).sendKeys("john123");
		driver.findElement(By.id("btnLogin")).click();
		
		String actualError= driver.findElement(By.id("spanMessage")).getText();
		
		Assert.assertEquals(actualError, "Invalid credentials");
	}
	
	

}
