package com.selenium.utility;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import net.bytebuddy.utility.RandomString;

public class ExtentReport {

	 public static ExtentHtmlReporter htmlReporter;
	    
	 public static ExtentReports extent; 
	 
	 public static ExtentTest test;
	 
	 public static void startReport(String OS, String browser, String reportPath) {
	    	// initialize the HtmlReporter
		 	String path2 = "Test"+RandomString.class;
	
	        htmlReporter = new ExtentHtmlReporter(reportPath);
	        
	        //initialize ExtentReports and attach the HtmlReporter
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	         
	        //To add system or environment info by using the setSystemInfo method.
	        extent.setSystemInfo("OS", OS);
	        extent.setSystemInfo("Browser", browser);
	        
	        //configuration items to change the look and feel
	        //add content, manage tests etc
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setDocumentTitle("Extent Report Demo");
	        htmlReporter.config().setReportName("Test Report");
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	        
	        
	    }
	 
	 
	    
}
