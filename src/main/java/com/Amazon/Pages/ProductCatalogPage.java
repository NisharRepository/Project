package com.Amazon.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogPage {
	
	WebDriver driver;
	public ProductCatalogPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#nav-hamburger-menu>i" )
	WebElement allMenu;
	
	@FindBy(css = "li>a>div")
	List <WebElement> mainMenu;
	
	@FindBy(css = "[data-menu-id='8'] li a")
	List<WebElement> subMenu;
	
	@FindBy(css = ".bxc-grid__image a")
	List<WebElement> mobileList;
	
	public void navigateToMainMenu(String mainMenuList) throws InterruptedException {
		allMenu.click();
		Thread.sleep(2000);
		for (int i = 0; i < mainMenu.size(); i++) {
	        WebElement subMenu1 = mainMenu.get(i);
	        if (subMenu1.getText().equalsIgnoreCase(mainMenuList)) {
	        	subMenu1.click();
	            break;
	        }
		}
		
	}
	
	public void navigateToSubMenu(String subMenuList) {
		
		for (int i = 0; i < subMenu.size(); i++) {
	        WebElement subSubMenu1 = subMenu.get(i);
	       System.out.println("Item " + i + ": " + subSubMenu1.getText());
	        if (subSubMenu1.getText().equalsIgnoreCase(subMenuList)){
	        	
	        	
	        	Actions actions = new Actions(driver);
	        	actions.moveToElement(subSubMenu1).click().perform();
	        	break;
	        }
		}
		
	}
	
	public CartPage specificMobileSearch(String mobile1) {
		
		for (int i = 1; i < mobileList.size(); i++) {
	        WebElement mobile = mobileList.get(i);
	       System.out.println("Item " + i + ": " + mobile.getAttribute("aria-label"));
	       if(mobile.getAttribute("aria-label").contains(mobile1)) {
	    	   mobile.click();
	    	   break;
	       }
	        
		}
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
			

}
