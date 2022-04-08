package com.nse.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nse.base.WebDriverWrapper;
import com.nse.pages.LoginPage;
import com.nse.pages.OrangePortalPage;
import com.nse.utilities.DataUtils;
	
public class LoginTest extends WebDriverWrapper {

	@Test(dataProviderClass = DataUtils.class, dataProvider = "commonDataProvider")
	public void invalidCredentialTest(String username, String password, String expectedTitle) {

		LoginPage login=new LoginPage(driver);
		
		login.enterUsername(username);
		extentTest.log(Status.INFO, "Username entered as "+username);
		
		login.enterPassword(password);
		extentTest.log(Status.INFO, "Password entered as "+password);
		
		login.clickOnLogin();
		extentTest.log(Status.INFO, "Clicked on Login");

		String actualError = login.getInvalidCredentialErrorMessage();
		extentTest.log(Status.INFO, "Actual Error shown is "+actualError);
		
		Assert.assertEquals(actualError, expectedTitle);
	}

	@Test(dataProviderClass = DataUtils.class, dataProvider = "commonDataProvider")
	public void validCredentialTest(String username, String password, String expectedUrl) {
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLogin();
		
		OrangePortalPage portal=new OrangePortalPage(driver);
		portal.waitForPresenceOfMyInfo();
		
		Assert.assertEquals(portal.getPortalUrl(), expectedUrl);
	}

}
