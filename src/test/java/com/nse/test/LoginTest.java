package com.nse.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nse.base.WebDriverWrapper;
import com.nse.utilities.DataUtils;

public class LoginTest extends WebDriverWrapper {

	@Test(dataProviderClass = DataUtils.class, dataProvider = "commonDataProvider")
	public void invalidCredentialTest(String username, String password, String expectedTitle) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		extentTest.log(Status.INFO, "Username entered as "+username);
		
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		extentTest.log(Status.INFO, "Password entered as "+password);
		
		driver.findElement(By.id("btnLogin")).click();
		extentTest.log(Status.INFO, "Clicked on Login");

		String actualError = driver.findElement(By.id("spanMessage")).getText();
		extentTest.log(Status.INFO, "Actual Error shown is "+actualError);
		
		Assert.assertEquals(actualError, expectedTitle);
		
	}

	@Test(dataProviderClass = DataUtils.class, dataProvider = "commonDataProvider")
	public void validCredentialTest(String username, String password, String expectedUrl) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		// need to provide explicit wait
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
	}

}
