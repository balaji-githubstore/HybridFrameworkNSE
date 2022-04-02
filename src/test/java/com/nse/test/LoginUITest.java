package com.nse.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginUITest {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

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

		Assert.assertTrue(usernameTextBox);
		Assert.assertTrue(passwordTextBox);
		Assert.assertTrue(loginButton);
		Assert.assertTrue(forgotPasswordLink);

		Assert.assertEquals(actualLinkText, "Forgot your password?");

	}

}
