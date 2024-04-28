package com.Amazon.Utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {
	
	public static ExtentReports getReport() {
		
		
		String fullPath = "C:\\Users\\ni903\\eclipse-workspace\\Live Projects\\Reports//Index.html";
		//OR
		String path1 = System.getProperty("user.dir")+"Reports/Index.html";
		//OR
		String relativePath = "./Reports/Index.html";
		//OR 
		File path =new File(relativePath);
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		//To set the title of the extent report, we can use setDocumentTitle(“YOUR_TITLE”).
		reporter.config().setDocumentTitle("Test Report Analysis");
		//To set the report name, we can use setReportName(“YOUR_REPORT_NAME”).
		reporter.config().setReportName("Amazon Report");
		reporter.config().setTimeStampFormat("EEEE,MMMM,dd,hh:mm a '('zzz')'");
		reporter.config().setTheme(Theme.STANDARD);
		
		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Tester", "Nishar");
		return extentReport;
	}

}
