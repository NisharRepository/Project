package com.Amazon.TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Amazon.Core.BaseTest;
import com.Amazon.Pages.RegistrationPage;

public class RegistrationTest extends BaseTest{
	
		
	@Test
	public void accountCreation() {
		
		//Verify successful user registration with valid information.
		
		RegistrationPage registrationpage = new RegistrationPage(driver);//we can place this object creation in BaseTest as we did for LoginPage
		registrationpage.initiateAccountCreation();
		registrationpage.accountDetail(userName, mobileNumber, password);
	}
	
	@Test	
	public void missingFieldsErrorMessagesTest () {
		
		//Test registration with missing required fields (e.g., email, password).
		
		RegistrationPage registrationpage = new RegistrationPage(driver);
		registrationpage.initiateAccountCreation();
		registrationpage.accountDetail(null, mobileNumber, password);
		
		String expectedTextForNameError = "Enter your name";
        String expectedTextForMobileError = "Enter your mobile number";
        
      //Validation for Missing information
        if(registrationpage.getNameErrorText().contains(expectedTextForNameError) || registrationpage.getMobileErrorText().contains(expectedTextForMobileError)) {
        	System.out.println("Test Passed: Error messages displayed for missing fields");
        }
        else {
        	System.out.println("Test Failed: Error messages not displayed for missing fields");
        }
        
        //OR
        Assert.assertTrue(registrationpage.getNameErrorText().contentEquals(expectedTextForNameError),"Error messages not displayed for missing fields");
        //OR
		Assert.assertEquals(registrationpage.getNameErrorText(), expectedTextForNameError);
        
		
	}
	
	@Test
	public void registrationWithExistingEmail() {
		
		//Test registration with a pre-existing mobile Number or username
		
		RegistrationPage registrationpage = new RegistrationPage(driver);
		registrationpage.initiateAccountCreation();
		registrationpage.accountDetail(userName, mobileNumber, password);
		
		String expectedTextForRegistrationError = "You indicated you are a new customer, but an account already exists with the mobile phone number";
		System.out.println(registrationpage.getRegistrationErrorText());
		//Validation for  Error received for Registration with Existing Mobile
        if(registrationpage.getRegistrationErrorText().contains(expectedTextForRegistrationError)) {
        	System.out.println("Test Passed: Error messages displayed for Registration with Existing Mobile");
        }
        else {
        	System.out.println("Test Failed: Error messages not displayed for Registration with Existing Mobile");
        }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void accountCreation1() throws InterruptedException {
		
		//Verify successful user registration with valid information.
		
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Actions a = new Actions(driver);
		WebElement accountLists = driver.findElement(By.cssSelector("#nav-link-accountList>.nav-line-2"));
		a.moveToElement(accountLists).build().perform();
		driver.findElement(By.cssSelector(".nav_pop_new_cust [href*='register']")).click();
		
		driver.findElement(By.cssSelector(".auth-autofocus")).sendKeys(userName);
		driver.findElement(By.cssSelector(".auth-require-phone-validation")).sendKeys(mobileNumber);
		driver.findElement(By.cssSelector(".auth-require-fields-match")).sendKeys(password +Keys.ENTER);
		
		driver.switchTo().frame(driver.findElement(By.xpath("iframe[@id='cvf-aamation-challenge-iframe']")));//frame not working
		
		////iframe[@id='cvf-aamation-challenge-iframe']
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".sc-nkuzb1-0")).click();
	}
	
	
	
	@Test
	public void missingFieldsErrorMessagesTest1 () {
		
		//Test registration with missing required fields (e.g., email, password).
		
		driver.get("https://www.amazon.in/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Actions a = new Actions(driver);
		WebElement accountLists = driver.findElement(By.cssSelector("#nav-link-accountList>.nav-line-2 "));
		a.moveToElement(accountLists).build().perform();
		driver.findElement(By.cssSelector(".nav_pop_new_cust [href*='register']")).click();
		
		
		driver.findElement(By.cssSelector(".auth-autofocus"));
		driver.findElement(By.cssSelector(".auth-require-phone-validation"));
		driver.findElement(By.cssSelector(".auth-require-fields-match")).sendKeys(password +Keys.ENTER);
		
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
