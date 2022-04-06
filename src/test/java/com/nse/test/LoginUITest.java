package com.nse.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nse.base.WebDriverWrapper;
	
public class LoginUITest extends WebDriverWrapper {
	
	@Test
	public void validateTitleTest() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM12");
	}

	@Test
	public void UIComponentTest() {

		boolean usernameTextBox = driver.findElement(By.xpath("//input[@id='txtUsername']")).isDisplayed();
		boolean passwordTextBox = driver.findElement(By.xpath("//input[@id='txtUsername']")).isDisplayed();
		boolean loginButton = driver.findElement(By.xpath("//input[@id='btnLogin']")).isDisplayed();
		boolean forgotPasswordLink = driver.findElement(By.partialLinkText("Forgot")).isDisplayed();

		String actualLinkText = driver.findElement(By.partialLinkText("Forgot")).getText();

		Assert.assertTrue(usernameTextBox);
		Assert.assertTrue(passwordTextBox);
		Assert.assertTrue(loginButton);
		Assert.assertTrue(forgotPasswordLink);

		Assert.assertEquals(actualLinkText, "Forgot your password?");

	}

}
