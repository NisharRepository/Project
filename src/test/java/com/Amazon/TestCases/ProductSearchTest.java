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
import com.Amazon.Utilities.Screenshot;

public class ProductSearchTest extends BaseTest{
	
	
	@Test
	public void sigleKeywordSearch()throws InterruptedException {
		
		String ItemsToSearch = "laptop";
		ProductSearchPage productSearchPage=loginpage.loginApplication(mobileNumber, password);
		//productSearchPage.productSearch1(ItemsToSearch);
		productSearchPage.productSearch(ItemsToSearch);		
			
		//Confirm that the search results include products related to all entered keywords.
					
		Assert.assertEquals(productSearchPage.getsearchResultText().toUpperCase(), "\"LAPTOP\"");
		//OR
		Assert.assertTrue(productSearchPage.getsearchResultText().contains("\"LAPTOP\""));
		//OR
	    if(productSearchPage.getsearchResultText().startsWith("\"LAPTOP\"")) {
			System.out.println("Verification Successful - search result displays products related to " +ItemsToSearch+" keyword");
			}
		else {
			System.out.println("Verification Failed");
			}		
	}
	
	@Test
	public void multipleKeywordSearch() throws InterruptedException {	
		//String ItemsToSearch = "Laptop cover";
		
		ProductSearchPage productSearchPage=loginpage.loginApplication(mobileNumber, password);				
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Item you want to Search: ");
		String ItemsToSearch = sc.nextLine();
		productSearchPage.productSearch1(ItemsToSearch);
		sc.close();		
	}
	
	@Test
	public void misspelledKeywords() {
		//Test searching with misspelled keywords and check for suggestions.
		ProductSearchPage productSearchPage = new ProductSearchPage(driver);
		productSearchPage.productSearch1("Latop");
		
		// Verify that suggestions are displayed
	    Assert.assertTrue(productSearchPage.areSuggestionsDisplayed(), "Suggestions should be displayed.");
	    
	    productSearchPage.clickCorrectlySpelledSuggestion("Laptop");
	    
	    

		
	}
		
		
	@Test
	public void sigleKeywordSearch1() throws InterruptedException {
		String searchedItem = "laptop";
		//Accessing webSite
		driver.get("https://www.amazon.in/");
		
		//Login to account
		driver.findElement(By.cssSelector("#nav-hamburger-menu>i")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("hmenu-customer-profile-link")).click();
		
		WebElement userName = driver.findElement(By.cssSelector("[name='email']"));
		if(userName.isEnabled()) {
			userName.sendKeys(mobileNumber +Keys.ENTER);
		}
		
		WebElement passwod = driver.findElement(By.cssSelector("[name='password']"));
		if(passwod.isEnabled()== true) {
			passwod.sendKeys(password +Keys.ENTER);
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
	public void multipleKeywordSearch1() {
		
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
	   loginpage.loginApplication(mobileNumber, password);
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
