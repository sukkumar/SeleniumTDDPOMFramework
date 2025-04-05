package com.selenium.regressionTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.selenium.utility.ExtentReport;

// this program is to demostration selenium automation
//another line
@Listeners(com.selenium.utility.Listners.class)
public class BasicContactForm {
	
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.mycontactform.com");
	}
	
	@BeforeTest
	public void setUpExtent() {
		ExtentReport.startReport("windows", "chrome", System.getProperty("user.dir") +"//extentReports//testReport2.html");
	}

	@Test
	public void basicContactFormTest() throws InterruptedException {
		ExtentReport.test = ExtentReport.extent.createTest("Test Case 1", "PASSED test case");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sample Forms")).click();
		driver.findElement(By.linkText("Basic Contact Form")).click();
		driver.findElement(By.name("q[1]")).sendKeys("sukkumar");
		driver.findElement(By.id("email")).sendKeys("sample5@gmail.com");
		driver.findElement(By.name("q[2]")).sendKeys("sample text");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		String msgConfirmation = driver.findElement(By.tagName("h4")).getText();
		Assert.assertTrue(msgConfirmation.contains("Thank You"));
	}
	// @Test
	// public void sampleFailMethod() {
	// 	ExtentReport.test = ExtentReport.extent.createTest("Test Case 2", "FAILED test case");
	// 	Assert.assertTrue(false);
	// }
	
	@AfterMethod
    public void getResult(ITestResult result) { 
        if(result.getStatus() == ITestResult.FAILURE) {
        	ExtentReport.test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
        	ExtentReport.test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
        	ExtentReport.test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
        	ExtentReport.test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
        	ExtentReport.test.skip(result.getThrowable());
        }
    }
	@AfterTest
	public void endOfTest() {
		
		driver.close();
		ExtentReport.extent.flush();
	}
	
	
}
