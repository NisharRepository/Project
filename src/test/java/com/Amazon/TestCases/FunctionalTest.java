package com.Amazon.TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Amazon.Core.BaseTest;

public class FunctionalTest extends BaseTest {
	
	@Test
	public void getUrl() {		
		
		//Verify that the homepage or Expected URL loads successfully.
		driver.get("https://www.amazon.in/");		
		String pageURL=driver.getCurrentUrl();		
		Assert.assertEquals(pageURL, "https://www.amazon.in/","homepage or Expected URL does not load successfully" );
		//OR
		Assert.assertTrue(pageURL.startsWith("https://www.amazon.in/"));
		//OR
		if(pageURL.contains("https://www.amazon.in/")) {
			System.out.println("Verification Successful - homepage or Expected URL loads successfully");
		}
		else {
			System.out.println("Verification Successful - homepage or Expected URL does not load successfully");
		}
	}
		
		
		@Test
		public void getSignButton() {

			// Test the functionality of the "Sign In" button on the homepage
			driver.get("https://www.amazon.in/");
			WebElement signButton = driver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1"));

			// Verify The "Sign In" button should be clearly visible/Exists
			Assert.assertTrue(signButton.isDisplayed());

			// Verify The "Sign In" button (WebElement) should exist(Presence)
			if (signButton != null) {
				System.out.println("Verification Successful - Sign-in Button Exists");
			}

			// Verify if the signButton variable is currently enabled then click
			if (signButton.isEnabled()) {
				signButton.click();
			}
			
			
		}
		
		
}
