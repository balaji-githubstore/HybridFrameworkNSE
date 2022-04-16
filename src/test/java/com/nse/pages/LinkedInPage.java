package com.nse.pages;

import org.openqa.selenium.WebDriver;

import com.nse.base.WebDriverKeywords;

public class LinkedInPage extends WebDriverKeywords {
	
	private WebDriver driver;

	public LinkedInPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public String getLinkdeinPageTitle() {
		
		return driver.getTitle();
	}

}
