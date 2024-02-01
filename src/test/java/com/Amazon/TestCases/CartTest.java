package com.Amazon.TestCases;

import org.testng.annotations.Test;

import com.Amazon.Core.BaseTest;
import com.Amazon.Pages.CartPage;
import com.Amazon.Pages.ProductCatalogPage;

public class CartTest extends BaseTest {
	
	@Test
	public void goToCartPage() throws InterruptedException{	
		
		driver.get("https://www.amazon.in/");
		ProductCatalogPage productcatalogpage = new ProductCatalogPage(driver);
		productcatalogpage.navigateToMainMenu("Mobiles, Computers");
		productcatalogpage.navigateToSubMenu("All Mobile Phones");
		productcatalogpage.specificMobileSearch("ce3 lite");
		CartPage cartpage = new CartPage(driver);
		cartpage.goToCart();
		cartpage.proceedToBuy();
		
		
	}

}
