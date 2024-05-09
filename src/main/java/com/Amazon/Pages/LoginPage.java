package com.Amazon.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Core.BasePage;
import com.Amazon.Utilities.SyncUtil;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	private SyncUtil syncUtil;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.syncUtil = new SyncUtil(driver);
	}
	
	
			
	@FindBy(css ="#nav-hamburger-menu>i" )
	WebElement allMenu;
			
	@FindBy(id = "hmenu-customer-profile-link")
	WebElement helloSignIn;
			
	@FindBy(css = "[name='email']")
	WebElement userEmail;
			
	@FindBy(css = "[name='password']")
	WebElement userPassword;
	
	public ProductSearchPage loginApplication(String mobile,String password) throws InterruptedException {
		allMenu.click();
		//SyncUtil.wait(1);
		syncUtil.waitInSec(1);
		helloSignIn.click();
		if(userEmail.isEnabled()) {
			userEmail.sendKeys(mobile + Keys.ENTER);
		}
		if(userPassword.isEnabled()) {
			userPassword.sendKeys(password +Keys.ENTER);
		}
		ProductSearchPage productSearchPage = new ProductSearchPage(driver);
		return productSearchPage;
		
	}
			
//	public ProductCatalogPage loginApplication(String mobile,String password) throws InterruptedException {
//		allMenu.click();
//		//SyncUtil.wait(1);
//		syncUtil.waitInSec(1);
//		helloSignIn.click();
//		if(userEmail.isEnabled()) {
//			userEmail.sendKeys(mobile + Keys.ENTER);
//		}
//		if(userPassword.isEnabled()== true) {
//			userPassword.sendKeys(password +Keys.ENTER);
//		}
//		ProductCatalogPage productcatalogpage = new ProductCatalogPage(driver);
//		return productcatalogpage;
//		
//	}
	
	public void goToApplication() {
		driver.get("https://www.amazon.in/");
	}
}
