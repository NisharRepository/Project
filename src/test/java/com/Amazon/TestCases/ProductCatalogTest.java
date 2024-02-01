package com.Amazon.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Amazon.Core.BaseTest;
import com.Amazon.Pages.ProductCatalogPage;

public class ProductCatalogTest extends BaseTest {
	
	@Test
	public void catalog() throws InterruptedException {		
	
		//Navigating to URL
		driver.get("https://www.amazon.in/");
		//Navigating to All Menu
		WebElement allMenu = driver.findElement(By.cssSelector("#nav-hamburger-menu>i"));
		allMenu.click();
		Thread.sleep(2000);
		//Navigative to SubMunu
		List <WebElement>subMenu = driver.findElements(By.cssSelector("li>a>div"));
		
		if (!subMenu.isEmpty()) {
		    System.out.println("Element(s) Found");
		    System.out.println("Number of SubMenu: " + subMenu.size());
		}
		
		for (int i = 0; i < subMenu.size(); i++) {
	        WebElement subMenu1 = subMenu.get(i);
	        if (subMenu1.getText().equalsIgnoreCase("Mobiles, Computers")) {
	        	subMenu1.click();
	            break;
	        }
		}
		
		Thread.sleep(2000);
		//Navigative to SubSubMunu
		List<WebElement> subSubMenu = driver.findElements(By.cssSelector("[data-menu-id='8'] li a"));
	
		if (!subSubMenu.isEmpty()) {
		    System.out.println("Element(s) Found");
		    System.out.println("Number of subSubMenu: " + subSubMenu.size());
		}
		
		for (int i = 0; i < subSubMenu.size(); i++) {
	        WebElement subSubMenu1 = subSubMenu.get(i);
	       System.out.println("Item " + i + ": " + subSubMenu1.getText());
	        if (subSubMenu1.getText().equalsIgnoreCase("All Mobile Phones")){
	        	
	        	
	        	Actions actions = new Actions(driver);
	        	actions.moveToElement(subSubMenu1).click().perform();
	        	break;
	        }
		}
		
		//Finding the Mobile
		List<WebElement> mobiles = driver.findElements(By.cssSelector(".bxc-grid__image a"));
		
		
		if (!mobiles.isEmpty()) {
		    System.out.println("Elements Found");
		    System.out.println("Number of Mobiles: " + mobiles.size());		
		}
		
		for (int i = 1; i < mobiles.size(); i++) {
	        WebElement mobile = mobiles.get(i);
	       System.out.println("Item " + i + ": " + mobile.getAttribute("aria-label"));
	       if(mobile.getAttribute("aria-label").contains("ce3 lite")) {
	    	   mobile.click();
	    	   break;
	       }
	        
		}
		
		Thread.sleep(2000);
		// Click on Add to Cart Button
		driver.findElement(By.cssSelector("#add-to-cart-button[type='submit']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#attach-close_sideSheet-link")).click();
		
		
		Thread.sleep(2000);
		//Go to Cart Page
		driver.findElement(By.cssSelector("#nav-cart-text-container")).click();
		
		//Click on Proceed to Buy
		driver.findElement(By.cssSelector(".a-button-input[name='proceedToRetailCheckout']")).click();
		
		
		
		
		
}
	
	
	@Test
	public void ProductCatalog() throws InterruptedException {
		
		//Navigating to URL
				driver.get("https://www.amazon.in/");
				ProductCatalogPage productcatalogpage = new ProductCatalogPage(driver);
				productcatalogpage.navigateToMainMenu("Mobiles, Computers");
				productcatalogpage.navigateToSubMenu("All Mobile Phones");
				productcatalogpage.specificMobileSearch("ce3 lite");
		
	}
}