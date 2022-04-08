package com.nse.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public static void enterUsername(WebDriver driver, String username) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
	}

	public static void enterPassword(WebDriver driver, String password) {
		driver.findElement(By.id("txtPassword")).sendKeys(password);
	}

	public static void clickOnLogin(WebDriver driver) {
		driver.findElement(By.id("btnLogin")).click();
	}

	public static String getInvalidCredentialErrorMessage(WebDriver driver)
	{
		return driver.findElement(By.id("spanMessage")).getText();
	}
}
