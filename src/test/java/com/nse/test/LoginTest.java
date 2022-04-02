package com.nse.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nse.base.WebDriverWrapper;

public class LoginTest extends WebDriverWrapper {

	@Test
	public void invalidCredentialTest() {
		driver.findElement(By.id("txtUsername")).sendKeys("john");
		driver.findElement(By.id("txtPassword")).sendKeys("john123");
		driver.findElement(By.id("btnLogin")).click();

		String actualError = driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(actualError, "Invalid credentials");
	}
	
	@Test
	public void validCredentialTest()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		//need to provide explicit wait
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	}

}
