package com.inetbanking.testcaes;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
//import org.testng.log4testng.Logger;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class BaseClass {

	public String baseurl = "http://www.demo.guru9.com/v4/";
	public String username = "mngr295855";
	public String password = "bAqUhUm";
	public static WebDriver driver;
	public static Logger logger;
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setExtent()
	{
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myreport.html");
		htmlreporter.config().setDocumentTitle("Autimation report");
		htmlreporter.config().setReportName("functional report");
		htmlreporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("hostname", "LocalHost");
		extent.setSystemInfo("OS", "windows10");
		extent.setSystemInfo("testername", "minakshi");
		extent.setSystemInfo("Browser name", "chrome");
		
	}
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}
	
	

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		logger=Logger.getLogger("BaseClass");
	
		PropertyConfigurator.configure("log4j.properties");
		

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	@AfterMethod
	public void checkstatus(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "TEST CASE FAILED IS"+result.getName());
			test.log(Status.FAIL, "TEST CASE FAILED IS"+result.getThrowable());
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "TEST CASE PASSED"+result.getName());
			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			
			test.log(Status.SKIP, "TEST CASE SKIPPED"+result.getName());
			test.log(Status.SKIP, "Test case skipped"+result.getThrowable());
		}
		
		
	}
}
