package com.nse.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private By usernameLocator = By.id("txtUsername");
	private By passwordLocator = By.id("txtPassword");
	private By loginLocator = By.name("Submit");
	private By errorLocator = By.id("spanMessage");

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String username) {
		driver.findElement(usernameLocator).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}

	public void clickOnLogin() {
		driver.findElement(loginLocator).click();
	}

	public String getInvalidCredentialErrorMessage() {
		return driver.findElement(errorLocator).getText();
	}
}
