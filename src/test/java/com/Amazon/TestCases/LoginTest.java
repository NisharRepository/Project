package com.Amazon.TestCases;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Amazon.Core.BaseTest;
import com.Amazon.Pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test
	public void loginApplication() throws InterruptedException {
		
		//Verify successful login with valid credentials.		
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.cssSelector("#nav-hamburger-menu>i")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("hmenu-customer-profile-link")).click();
		
		try {
		WebElement userName = driver.findElement(By.cssSelector("[name='email']"));
		if(userName.isEnabled()) {
			userName.sendKeys("9337561245"+Keys.ENTER);
		}
		WebElement password = driver.findElement(By.cssSelector("[name='password']"));
		if(password.isEnabled()== true) {
			password.sendKeys("9038497506"+Keys.ENTER);
		}
		}
		catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		}
		catch (TimeoutException  e) {
			System.out.println("Timeout waiting for element: " + e.getMessage());
		}
		catch (Exception  e) {
			System.out.println("Invalid Credential " + e.getMessage());
		}
		
		//Verification after Login to account
		try {
		WebElement userNameSalutation = driver.findElement(By.cssSelector(".nav-line-1-container span"));		
		Assert.assertTrue(userNameSalutation.getText().contains("Hello, Salami"));
		}
		catch(NoSuchElementException e) {
			System.out.println("userNameSalutation : Element not found");
		}
		
		Actions a = new Actions(driver);
		WebElement accountLists = driver.findElement(By.cssSelector("#nav-link-accountList>.nav-line-2 "));
		a.moveToElement(accountLists).build().perform();
		try {
		WebElement signOut = driver.findElement(By.cssSelector("#nav-item-signout"));
		if(signOut.isDisplayed()== true) {
			System.out.println("Verification Done : Login Sucessful");
		}
		}
		catch(NoSuchElementException e) {
			System.out.println("Login Not Sucessful");
		}
		
		
		
	}
	
  @Test
  public void loginApplication1() throws InterruptedException {
	  
	  //Verify successful login with valid credentials.
	  
	  Scanner sc = new Scanner(System.in);
	  System.out.print("Please Enter User ID & Password");
	  String userID =sc.nextLine();
	  String password = sc.nextLine();
	  sc.close();
	  LoginPage loginpage = new LoginPage( driver);	
	  loginpage.goToApplication();
	  loginpage.loginApplication(userID, password);
	 
	  String pageURL=loginpage.getUrl();
	  System.out.println(pageURL);
		Assert.assertEquals(pageURL, "https://www.amazon.in/?_encoding=UTF8&ref_=nav_em_hd_re_signin","homepage or Expected URL does not load successfully" );
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
}
