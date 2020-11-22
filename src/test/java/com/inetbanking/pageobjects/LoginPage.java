package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid")
	WebElement username;
	
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="password")
	WebElement loginbtn;
	
	
	
	public void setUserName(String s)
	{
		
		username.sendKeys(s);
	}
	
	public void setpassword(String s)
	{
		password.sendKeys(s);
	}
	
	public void clickLoginbtn()
	{
		loginbtn.click();
	}
}
