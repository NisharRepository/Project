package com.Amazon.Core;

import org.openqa.selenium.WebDriver;

import com.Amazon.Utilities.SyncUtil;

public class BasePage {
	
	
protected WebDriver driver;
	
	public BasePage(WebDriver driver ) {
		this.driver = driver;
		
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}

}
