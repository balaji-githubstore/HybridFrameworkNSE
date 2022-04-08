package com.nse.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//handle all the menu 
public class OrangePortalPage {
	private By myInfoLocator = By.xpath("//b[text()='My Info']");
	private By adminLocator = By.xpath("//b[text()='Admin']");
	private By pimLocator = By.partialLinkText("PIM");
	private By addEmployeeLocator = By.linkText("Add Employee");

	private WebDriver driver;

	public OrangePortalPage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForPresenceOfMyInfo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.presenceOfElementLocated(myInfoLocator));
	}

	public String getPortalUrl() {
		return driver.getCurrentUrl();
	}

	public void clickOnMyInfo() {
		driver.findElement(myInfoLocator).click();
	}

	public void clickOnPIM() {
		driver.findElement(pimLocator).click();
	}

	public void clickOnAddEmployee() {
		driver.findElement(addEmployeeLocator).click();
	}

}
