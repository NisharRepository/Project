package com.Amazon.Core;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Amazon.Utilities.ExtentReportNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extentReport = ExtentReportNG.getReport();
	
	@Override
	public void onTestStart(ITestResult result) {
		test= extentReport.createTest(result.getMethod().getMethodName());    
	  }

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	  }
	
	@Override 
	public void onTestFailure(ITestResult result) {

		test.fail(result.getThrowable());
		//Screenshot
		//Take Screenshot,Keep in the Path & Attach to Report & driver initialization also required
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String destinationPath = null;
		try {
			destinationPath = getScreenshot(driver,result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(destinationPath, result.getMethod().getMethodName());


	   
	  }

	@Override 
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "TestCase Skipped");
	    }
	@Override 
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	   
	  }

	 
	@Override   
	public void onTestFailedWithTimeout(ITestResult result) {
	    
	  }

	  
	@Override 
	public void onStart(ITestContext context) {
	    
	  }

	 
	@Override 
	public void onFinish(ITestContext context) {
		extentReport.flush();
	  }

	
	
}
