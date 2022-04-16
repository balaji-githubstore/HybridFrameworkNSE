package com.nse.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nse.base.WebDriverWrapper;
import com.nse.pages.LinkedInPage;
import com.nse.pages.LoginPage;

public class LoginUITest extends WebDriverWrapper {

	@Test
	public void validateTitleTest() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@Test
	public void UIComponentTest() {

		boolean usernameTextBox = driver.findElement(By.xpath("//input[@id='txtUsername']")).isDisplayed();
		boolean passwordTextBox = driver.findElement(By.xpath("//input[@id='txtUsername']")).isDisplayed();
		boolean loginButton = driver.findElement(By.xpath("//input[@id='btnLogin']")).isDisplayed();
		boolean forgotPasswordLink = driver.findElement(By.partialLinkText("Forgot")).isDisplayed();

		String actualLinkText = driver.findElement(By.partialLinkText("Forgot")).getText();
		String actualHref = driver.findElement(By.partialLinkText("Forgot")).getAttribute("href");
		Assert.assertTrue(usernameTextBox);
		Assert.assertTrue(passwordTextBox);
		Assert.assertTrue(loginButton);
		Assert.assertTrue(forgotPasswordLink);
		Assert.assertEquals(actualHref, "https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode");

		Assert.assertEquals(actualLinkText, "Forgot your password?");

	}
	@Test
	public void linkedInIconLinkTest()
	{
		LoginPage login=new LoginPage(driver);
		login.clickOnLinkedinIcon();
		
		login.switchToWindowUsingTitle("Sign Up | LinkedIn");
		
		LinkedInPage linPage=new LinkedInPage(driver);
		Assert.assertEquals(linPage.getLinkdeinPageTitle(), "Sign Up | LinkedIn");
	}

}
