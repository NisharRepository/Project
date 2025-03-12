package com.Amazon.Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import com.Amazon.Pages.LoginPage;

public class BaseTest extends Variables {
	
	protected WebDriver driver;
	public LoginPage loginpage;
	
	protected String userName = "Cool Nish";
	protected String mobileNumber = "9337...";
	protected String password = "9038..." ;
	
	//@BeforeMethod
	public void initializeDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Browser-Driver\\ChromeDriver\\chromedriver.exe");
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
