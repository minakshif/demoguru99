package com.inetbanking.testcaes;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.inetbanking.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	
	
	@Test
	public void launchURl()
	{
		test=extent.createTest("launch URL");
		driver.get(baseurl);
		logger.info("launch url");
	}
	
	@Test(dependsOnMethods="launchURl")
	public void logintest()
	{
		test=extent.createTest("Logintest");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setpassword(password);
		logger.info("Entered  pasword");
		lp.clickLoginbtn();
		logger.info("click on login btn");
		
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Home Page");

	}

}
