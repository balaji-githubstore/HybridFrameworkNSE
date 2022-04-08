package com.nse.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage {
	private By firstNameLocator=By.id("firstName");

	private WebDriver driver;

	public AddEmployeePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterFirstName(String firstName)
	{
		driver.findElement(firstNameLocator).sendKeys(firstName);
	}
}
