package com.Amazon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
		public CartPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver,this);		
		}
		
		@FindBy(css = "#add-to-cart-button[type='submit']")
		WebElement addToCart;
		
		@FindBy(css = "#attach-close_sideSheet-link")
		WebElement closeSideSheet;
		
		@FindBy(css = "#nav-cart-text-container")
		WebElement cart;
		
		@FindBy(css = ".a-button-input[name='proceedToRetailCheckout']")
		WebElement buy;
		
		
		
		public void goToCart() throws InterruptedException {
			Thread.sleep(2000);
			addToCart.click();
			Thread.sleep(2000);
			closeSideSheet.click();
			Thread.sleep(2000);
			cart.click();
		}
		
		public CheckoutPage proceedToBuy() {
			buy.click();
			return new CheckoutPage(driver);
		}

}
