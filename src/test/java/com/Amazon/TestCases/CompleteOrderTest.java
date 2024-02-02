package com.Amazon.TestCases;

import org.testng.annotations.Test;

import com.Amazon.Core.BaseTest;
import com.Amazon.Pages.CartPage;
import com.Amazon.Pages.CheckoutPage;
import com.Amazon.Pages.ProductCatalogPage;

public class CompleteOrderTest extends BaseTest {
	
	@Test
	public void Amazon() throws InterruptedException {		  
		  
		  
		  ProductCatalogPage productcatalogpage = loginpage.loginApplication("9337561245", "9038497506");	
		  
		  productcatalogpage.navigateToMainMenu("Mobiles, Computers");
		  productcatalogpage.navigateToSubMenu("All Mobile Phones");
		  CartPage cartpage = productcatalogpage.specificMobileSearch("ce3 lite");
		  		  
		  cartpage.goToCart();
		  CheckoutPage checkoutpage = cartpage.proceedToBuy();
		  
		  checkoutpage.selectDeliveryAddress("Nishar");
		  checkoutpage.selectPayment();
			
			
	}
}
