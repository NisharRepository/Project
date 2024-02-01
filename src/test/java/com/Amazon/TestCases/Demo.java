package com.Amazon.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Amazon.Core.BaseTest;
import com.Amazon.Pages.LoginPage;

public class Demo extends BaseTest  {
	
	
	@Test
	public void loginApplication1() throws InterruptedException {
		  
		  //Verify successful login with valid credentials.
		  
		  LoginPage loginpage = new LoginPage( driver);	
		  loginpage.goToApplication();
		  loginpage.loginApplication("9337561245", "9038497506");
		 
		  String pageURL=loginpage.getUrl();
		  System.out.println(pageURL);
			Assert.assertEquals(pageURL, "https://www.amazon.in/?_encoding=UTF8&ref_=nav_em_hd_re_signin","homepage or Expected URL does not load successfully" );
			//OR
			Assert.assertTrue(pageURL.startsWith("https://www.amazon.in/"));
			//OR
			if(pageURL.contains("https://www.amazon.in/")) {
				System.out.println("Verification Successful - homepage or Expected URL loads successfully");
			}
			else {
				System.out.println("Verification Successful - homepage or Expected URL does not load successfully");
			}
		  
	  }
	}