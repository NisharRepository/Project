package com.Amazon.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Utilities.SyncUtil;

public class ProductSearchPage {
	
	
	private WebDriver driver;
	private SyncUtil syncUtil;
	
	public ProductSearchPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		syncUtil = new SyncUtil(driver);
	}
	
	@FindBy(css = "[name='field-keywords']")
	WebElement searchBar;
	
	@FindBy(css = ".a-color-state.a-text-bold")
	WebElement searchResult;
	
	public void productSearch1(String searchItem) {
		if(searchBar.isEnabled()) {
			searchBar.sendKeys(searchItem + Keys.ENTER);
		}
	}
	
	
	public void productSearch(String searchItem) {
		Actions a = new Actions(driver);
		// Move to the search bar, click, hold Shift, type the search item in uppercase, and release Shift
		a.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys(searchItem).keyUp(Keys.SHIFT);
		// Perform the action
		a.build().perform();
		// Now, you can press Enter separately if needed
		searchBar.sendKeys(Keys.ENTER);
	}
	
	public String getsearchResultText() {
		syncUtil.waitInSec(2);
		return searchResult.getText();
	}
	

}

