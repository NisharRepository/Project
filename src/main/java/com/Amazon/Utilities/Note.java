package com.Amazon.Utilities;

public class Note {
	
	//We Can Create Utilities class like SyncUtil, Switching to Frame, Switching to window, Java Script executor,Alert Handling,
	
	
//	Example-use of SyncUtil Class
//	
//	In your SyncUtil class, you are trying to initialize WebDriverWait and WebDriver at the class level.
//
//	1-Create Constructor in SyncUtil Class
//
//	2-Now, in your LoginPage class or wherever you want to use SyncUtil, you can create an instance of SyncUtil by passing the driver instance
//	create one instance like below 
//
//	a-private SyncUtil syncUtil;
//	b-this.syncUtil = new SyncUtil(driver);//use this statement in constructor of the loginpage
//	c- use the method of SyncUtil Class
	
	
	//***************ScreenShot************
	
//	To Take Screen of any WebPage in Selenium we have one Interface TakesScreenshot
//
//	1-we cannot create Object Directly for any Interface so we will cast Driver into TakesScreenshot( as Through driver only we open any Browser)
//	TakesScreenshot ts = (TakesScreeshot)driver;
//
//	2-Now we can get Screenshot putting a file Type storing into a variable so that we can use it futher
//	File file = ts.getScreenshotAs(OutputType.FILE);
//
//	3-Now we have to store in our local Machine for that we have to use another Class "FileUtils"
//
//	FileUtils.copyFile(srcFile, DestFile);
//	srcFile = file 
//	DestFile is the Path where you want store ie  new File("./Screenshots/image.jpeg")
//
//	FileUtils.copyFile(file, new File("./Screenshots/image.jpeg"));
	
	
	//***************ExtentReport************

}
