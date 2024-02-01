package com.Amazon.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);		
	}
	
	@FindBy(css = "[type='radio']")
	List<WebElement> addresses;
	
	@FindBy(css = "[type='radio']")
	List<WebElement> payments;
	
	
	
	
	public void selectDeliveryAddress(String addressName) throws InterruptedException {
		Thread.sleep(2000);
		for (int i = 0; i < addresses.size(); i++) {
		    WebElement address = addresses.get(i);

		    // Example: If the radio button has a specific attribute like "value" or "id"
		    String addressValue = address.getAttribute("value");
		    
		    // Check if the attribute value contains "select_2"
		    if (addressValue != null && addressValue.contains("select_2")) {
		        address.click();
		        address.sendKeys(Keys.ENTER);
		        break;
		    }
		}
	}
	
	
	public void selectPayment() throws InterruptedException {
		Thread.sleep(10000);
		for (int i = 0; i < payments.size(); i++) {			
		    WebElement payment = payments.get(i);

		    // Example: If the radio button has a specific attribute like "value" or "id"
		    String paymentValue = payment.getAttribute("value");
		    System.out.println(paymentValue);
		    // Check if the attribute value contains "cash"
		    if (paymentValue != null && paymentValue.contains("cash")) {
		    	payment.click();
		    	break;
		    }
		}
		 driver.findElement(By.cssSelector("input[name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent'][type='submit']")).click();
	}

}
