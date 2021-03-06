package com.nse.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nse.base.WebDriverWrapper;
import com.nse.pages.AddEmployeePage;
import com.nse.pages.LoginPage;
import com.nse.pages.OrangePortalPage;
import com.nse.utilities.DBMySqlUtils;
import com.nse.utilities.DataUtils;

public class EmployeeTest extends WebDriverWrapper {
	
	@Test(dataProviderClass = DataUtils.class, dataProvider = "commonDataProvider")
	public void addEmployeeTest(String username,String password,String firstName)
	{
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLogin();	
		
		OrangePortalPage portal=new OrangePortalPage(driver);
		portal.clickOnPIM();
		portal.clickOnAddEmployee();
		
		AddEmployeePage empPage=new AddEmployeePage(driver);
		empPage.enterFirstName(firstName);
		//complete remaining steps
		
		//Assertion
		//Assertion on db
		
		String output=DBMySqlUtils.executeQuery("Select count(*) from Products where product_id=50101");
		int countInDB=Integer.parseInt(output);
		Assert.assertTrue(countInDB==1,"Records not available");
		
	}

}
