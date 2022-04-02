package com.nse.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nse.base.WebDriverWrapper;
import com.nse.utilities.DataUtils;

public class LoginTest extends WebDriverWrapper {

	@Test(dataProviderClass = DataUtils.class, dataProvider = "invalidCredentialData")
	public void invalidCredentialTest(String username, String password, String expectedTitle) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();

		String actualError = driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(actualError, expectedTitle);
	}

	@Test(dataProviderClass = DataUtils.class,dataProvider = "validCredentialData")
	public void validCredentialTest(String username, String password, String expectedUrl) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		// need to provide explicit wait
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
	}

}
