package com.Amazon.TestCases;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Amazon.Core.BaseTest;
import com.Amazon.Pages.LoginPage;
import com.Amazon.Pages.ProductSearchPage;

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
		
		String ItemsToSearch = "Latop";
		//Test searching with misspelled keywords and check for suggestions.
		ProductSearchPage productSearchPage = new ProductSearchPage(driver);
		productSearchPage.productSearch1(ItemsToSearch);
		
		// Verify that suggestions are displayed
	    Assert.assertTrue(productSearchPage.areSuggestionsDisplayed(), "Suggestions should be displayed.");
	    
	    productSearchPage.clickCorrectlySpelledSuggestion("Laptop");  

		
	}
	
	@Test	
	public void insensitivitySearch() throws InterruptedException {
		
		//Check for case insensitivity in search queries and check for suggestions.
		ProductSearchPage productSearchPage = new ProductSearchPage(driver);
		productSearchPage.productSearch1("apPLe");
		
		// Verify that suggestions are displayed
		Assert.assertTrue(productSearchPage.areSuggestionsDisplayed(), "Suggestion should be displayed");
		
		// Verify if suggestions are equal to the search items case-insensitively
		
		Assert.assertTrue(productSearchPage.suggestionsEqualSearchItems("Apple"), "Suggestions are not equal");
	}	
	
	
	@Test	
	public void filterSearch() {
		
		//Verify that advanced search filters work as expected.
		ProductSearchPage productSearchPage = new ProductSearchPage(driver);
		productSearchPage.productSearch("mobile");
		
		// Wait for mobile brands to be visible
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#brandsRefinements span.a-size-base")));
		
		List<WebElement> mobileBrands = driver.findElements(By.cssSelector("#brandsRefinements span.a-size-base"));
		for(WebElement mobileBrand : mobileBrands ) {
			if(mobileBrand.getText().equalsIgnoreCase("Redmi")) {
				mobileBrand.click();
				break;
			}
		}
			
		
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
