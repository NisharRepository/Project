package com.Amazon.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Amazon.Core.BaseTest;
import com.Amazon.Pages.LoginPage;

public class Demo  {
	
	protected WebDriver driver;
	
	
	
	
	public WebDriver initializeDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Browser-Driver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
		}
	
	public LoginPage launchApplication() {
		initializeDriver();
		LoginPage loginpage = new LoginPage( driver);	
		loginpage.goToApplication();
		return loginpage;
	}
	
	
	}

