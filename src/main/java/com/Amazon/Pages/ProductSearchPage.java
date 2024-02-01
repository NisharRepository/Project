package com.Amazon.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchPage {
	
	
	private WebDriver driver;
	
	public ProductSearchPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[name='field-keywords']")
	WebElement searchBar;
	
	@FindBy(css = ".a-color-state.a-text-bold")
	WebElement searchResult;
	
	
	public void productSearch(String searchedItem) {
		Actions a = new Actions(driver);
		a.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys(searchedItem).keyUp(Keys.SHIFT);
		a.build().perform();
		searchBar.sendKeys(Keys.ENTER);
	}
	

}

