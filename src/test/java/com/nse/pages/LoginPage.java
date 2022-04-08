package com.nse.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.nse.base.WebDriverKeywords;

public class LoginPage extends WebDriverKeywords {
	private By usernameLocator = By.id("txtUsername");
	private By passwordLocator = By.id("txtPassword");
	private By loginLocator = By.name("Submit");
	private By errorLocator = By.id("spanMessage");

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterUsername(String username) {
		typeOnElement(usernameLocator, username);
	}

	public void enterPassword(String password) {
		typeOnElement(passwordLocator, password);
	}

	public void clickOnLogin() {
		clickOnElement(loginLocator);
	}

	public String getInvalidCredentialErrorMessage() {
		return getElementText(errorLocator);
	}
}
