package com.Amazon.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Core.BasePage;
import com.Amazon.Utilities.SyncUtil;

public class RegistrationPage extends BasePage {
	
	private WebDriver driver;
	private SyncUtil syncUtil;
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
		this.syncUtil = new SyncUtil(driver);
	}
	
	@FindBy(css = "#nav-link-accountList>.nav-line-2")
	WebElement accountLists;
	
	@FindBy(css = ".nav_pop_new_cust [href*='register']")
	WebElement createAmozonAccount;
	
	@FindBy(css = ".auth-autofocus")
	WebElement yourName;
	
	@FindBy(css = ".auth-require-phone-validation")
	WebElement mobileNumber;
	
	@FindBy(css =".auth-require-fields-match")
	WebElement password;
	
	@FindBy(css = "#auth-customerName-missing-alert .a-alert-content")
	WebElement usernameError;
	
	@FindBy(css = "#auth-phoneNumber-missing-alert .a-alert-content")
	WebElement mobileNumberError;
	
	@FindBy(css = ".a-list-item")
	WebElement RegistrationError;
	
	public void initiateAccountCreation() {
		syncUtil.implicitWait(15);
		Actions a = new Actions(driver);
		a.moveToElement(accountLists).build().perform();
		createAmozonAccount.click();
	}
	
	public void accountDetail(String name,String mobile, String pass ) {
		if (name != null) {
            yourName.sendKeys(name);
        }
		if (mobile != null) {
            mobileNumber.sendKeys(mobile);
        }
		password.sendKeys(pass+Keys.ENTER);
		
	}
	
	public String getNameErrorText() {
		return usernameError.getText();
		
	}
	
	public String getMobileErrorText() {
		return mobileNumberError.getText();
		
	}
	
	public String getRegistrationErrorText() {
		return RegistrationError.getText();
		
	}
	
	

}
