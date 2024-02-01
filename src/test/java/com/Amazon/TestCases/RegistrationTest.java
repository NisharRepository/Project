package com.Amazon.TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Amazon.Core.BaseTest;

public class RegistrationTest extends BaseTest{
	
	@Test
	public void accountCreation() throws InterruptedException {
		
		//Verify successful user registration with valid information.
		
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Actions a = new Actions(driver);
		WebElement accountLists = driver.findElement(By.cssSelector("#nav-link-accountList>.nav-line-2 "));
		a.moveToElement(accountLists).build().perform();
		driver.findElement(By.cssSelector(".nav_pop_new_cust [href*='register']")).click();
		
		driver.findElement(By.cssSelector(".auth-autofocus")).sendKeys("Cool Nish");
		driver.findElement(By.cssSelector(".auth-require-phone-validation")).sendKeys("9337561245");
		driver.findElement(By.cssSelector(".auth-require-fields-match")).sendKeys("9038497506"+Keys.ENTER);
		
		driver.switchTo().frame(driver.findElement(By.xpath("iframe[@id='cvf-aamation-challenge-iframe']")));//frame not working
		
		////iframe[@id='cvf-aamation-challenge-iframe']
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".sc-nkuzb1-0")).click();
	}
	
	@Test
	public void missingFieldsErrorMessagesTest () {
		
		//Test registration with missing required fields (e.g., email, password).
		
		driver.get("https://www.amazon.in/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Actions a = new Actions(driver);
		WebElement accountLists = driver.findElement(By.cssSelector("#nav-link-accountList>.nav-line-2 "));
		a.moveToElement(accountLists).build().perform();
		driver.findElement(By.cssSelector(".nav_pop_new_cust [href*='register']")).click();
		
		
		driver.findElement(By.cssSelector(".auth-autofocus"));
		driver.findElement(By.cssSelector(".auth-require-phone-validation"));
		driver.findElement(By.cssSelector(".auth-require-fields-match")).sendKeys("9038497506"+Keys.ENTER);
		
		// Locate the error message elements
        WebElement usernameError = driver.findElement(By.cssSelector("#auth-customerName-missing-alert .a-alert-content"));
        WebElement mobileNumberError = driver.findElement(By.cssSelector("#auth-phoneNumber-missing-alert .a-alert-content"));
        
//        if(usernameError.isDisplayed() || mobileNumberError.isDisplayed()) {
//        	System.out.println("Test Passed: Error messages displayed for missing fields");
//        }
//        else {
//        	System.out.println("Test Failed: Error messages not displayed for missing fields");
//        }
        
        //OR
        if(usernameError.getText().contains(" Enter your mobile number") || mobileNumberError.isDisplayed()) {
        	System.out.println("Test Passed: Error messages displayed for missing fields");
        }
        else {
        	System.out.println("Test Failed: Error messages not displayed for missing fields");
        }
		
	}
	
	
	
	
	

}
