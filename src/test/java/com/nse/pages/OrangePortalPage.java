package com.nse.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//handle all the menu 
public class OrangePortalPage {

	private WebDriver driver;
	public OrangePortalPage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForPresenceOfMyInfo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//b[text()='My Info']")));
	}
	
	public String getPortalUrl()
	{
		return driver.getCurrentUrl();
	}
}
