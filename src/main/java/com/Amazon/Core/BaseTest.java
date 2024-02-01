package com.Amazon.Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import com.Amazon.Pages.LoginPage;

public class BaseTest {
	
	protected WebDriver driver;
	public LoginPage loginpage;
	
	//@BeforeMethod
	public void initializeDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Browser-Driver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		loginpage = new LoginPage( driver);
		loginpage.goToApplication();
	}
	
	@BeforeMethod
	public void initializeDriverAfterBrowserFactory() {
		driver = BrowserFactory.getInstance();
		driver.manage().window().maximize();
		loginpage = new LoginPage( driver);
		loginpage.goToApplication();
	}
	
//	public LoginPage lauchApplication() {	
//	  LoginPage loginpage = new LoginPage( driver);	
//	  loginpage.goToApplication();
//	  return loginpage;		
//		}
		
	//@AfterMethod
	public void cleanUp() {
		if(driver !=null) {
			driver.quit();
		}
	}

}
