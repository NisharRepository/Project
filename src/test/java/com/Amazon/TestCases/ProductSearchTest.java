package com.Amazon.TestCases;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Amazon.Core.BaseTest;
import com.Amazon.Pages.LoginPage;
import com.Amazon.Pages.ProductSearchPage;

public class ProductSearchTest extends BaseTest{
	
	@Test
	
	public void sigleKeywordSearch() throws InterruptedException {
		String searchedItem = "laptop";
		//Accessing webSite
		driver.get("https://www.amazon.in/");
		
		//Login to account
		driver.findElement(By.cssSelector("#nav-hamburger-menu>i")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("hmenu-customer-profile-link")).click();
		
		WebElement userName = driver.findElement(By.cssSelector("[name='email']"));
		if(userName.isEnabled()) {
			userName.sendKeys("9337561245"+Keys.ENTER);
		}
		
		WebElement password = driver.findElement(By.cssSelector("[name='password']"));
		if(password.isEnabled()== true) {
			password.sendKeys("9038497506"+Keys.ENTER);
		}
	
	//Product search for the product  "laptop"
		
		//WebElement searchBar = driver.findElement(By.cssSelector("[name='field-keywords']"));
		
//		if(searchBar != null)
//			System.out.println("Element Found");
//		if(searchBar.isEnabled()) {
//			searchBar.sendKeys(searchedItem + Keys.ENTER);
//		}
		
		//OR
		
		Actions a = new Actions(driver);
		WebElement searchBar = driver.findElement(By.cssSelector("[name='field-keywords']"));
		
		//a.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys(searchedItem).keyUp(Keys.SHIFT).build().perform();
		
		// Move to the search bar, click, hold Shift, type the search item in uppercase, and release Shift
				a.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys(searchedItem).keyUp(Keys.SHIFT);

				// Perform the action
				a.build().perform();

		// Now, you can press Enter separately if needed
		searchBar.sendKeys(Keys.ENTER);
		
		
		//Confirm that the search results include products related to all entered keywords.
		Thread.sleep(2000);
		WebElement searchResult = driver.findElement(By.cssSelector(".a-color-state.a-text-bold"));
		
		Assert.assertEquals(searchResult.getText(), "\"LAPTOP\"");
		//OR
		Assert.assertTrue(searchResult.getText().contains("\"LAPTOP\""));
		//OR
		if(searchResult.getText().startsWith("\"LAPTOP\"")) {
			System.out.println("Verification Successful - search result displays products related to " +searchedItem+" keyword");
		}
		else {
			System.out.println("Verification Failed");
		}
		
	}
	
	
	@Test
	public void multipleKeywordSearch() {
		
		//Accessing webSite
		driver.get("https://www.amazon.in/");
		
		WebElement searchBar = driver.findElement(By.cssSelector("[name='field-keywords']"));
		
		if(searchBar != null)
			System.out.println("Element Found");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Item you want to Search: ");
		String searchedItem = sc.nextLine();
		
		if(searchBar.isEnabled()) {
			searchBar.sendKeys(searchedItem + Keys.ENTER);
	}
		sc.close();
		
	}
	
   @Test
   public void productSearch() throws InterruptedException {
	   String searchedItem = "laptop";
	   LoginPage loginpage = new LoginPage( driver);	
	   loginpage.goToApplication();
	   loginpage.loginApplication("9337561245", "9038497506");
	   ProductSearchPage productsearchpage = new ProductSearchPage(driver);
	   productsearchpage.productSearch(searchedItem);
	   
	 //Confirm that the search results include products related to all entered keywords.
	 		Thread.sleep(2000);
	 		WebElement searchResult = driver.findElement(By.cssSelector(".a-color-state.a-text-bold"));
	 		
	 		Assert.assertEquals(searchResult.getText(), "\"LAPTOP\"");
	 		//OR
	 		Assert.assertTrue(searchResult.getText().contains("\"LAPTOP\""));
	 		//OR
	 		if(searchResult.getText().startsWith("\"LAPTOP\"")) {
	 			System.out.println("Verification Successful - search result displays products related to " +searchedItem+" keyword");
	 		}
	 		else {
	 			System.out.println("Verification Failed");
	 		}
	   
   }
}
