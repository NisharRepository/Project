package com.Amazon.Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserFactory {
	//Location to the executable driver
		public static final String CHROME_DRIVER_PATH = "C:\\Users\\Browser-Driver\\chromedriver-win64\\chromedriver.exe";
		public static final String EDGE_DRIVER_PATH = "C:\\Users\\Browser-Driver\\edgedriver_win64\\msedgedriver.exe";
		
		//Browser name to run tests on		
		public static final String BROWSER_NAME = "Chrome";
		
		
		public static WebDriver getInstance() {
			WebDriver driver = null;
			
			switch (BROWSER_NAME.toUpperCase()) {
			case "CHROME":
				System.setProperty("webdriver.chrome.driver",CHROME_DRIVER_PATH);
				driver = new ChromeDriver();			
				break;
				
			case "EDGE":
				System.setProperty("webdriver.chrome.driver",EDGE_DRIVER_PATH);
				driver = new EdgeDriver();			
				break;

			default:
				new RuntimeException("Invalid browser name: " +BROWSER_NAME);
				break;
			}
			return driver;
		}


}
