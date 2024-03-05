package com.Amazon.Pages;

import java.util.List;

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
	
	//
	
	@FindBy(css = ".left-pane-results-container div.s-suggestion[aria-label*='laptop']")
	List <WebElement> suggestedItems;
	
	public void productSearch1(String searchItem) {
		if(searchBar.isEnabled()) {
			searchBar.sendKeys(searchItem);
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
	
	public void clickCorrectlySpelledSuggestion(String correctSpelling) {
		for(WebElement suggestedItem: suggestedItems) {
			if(suggestedItem.getText().toLowerCase().contains(correctSpelling.toLowerCase())) {
				suggestedItem.click();
				break;// Assuming you want to click the first matching suggestion
			}
		}
       
	}

	public boolean areSuggestionsDisplayed() {
		syncUtil.waitInSec(1);
		return !suggestedItems.isEmpty();
	}

	
	

}

