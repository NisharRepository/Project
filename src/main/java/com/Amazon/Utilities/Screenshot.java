package com.Amazon.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public static void captureScreenshot(WebDriver driver,String fileName) throws IOException {
	TakesScreenshot ts =(TakesScreenshot) driver;
	File screenshotFile = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshotFile, new File("./Screenshots/"+fileName +"" ));	
	}
}
