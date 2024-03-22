package com.selenium.workFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.utility.LoggerMngr;

public class FeedBackFlow {

WebDriver driver;
LoggerMngr log;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.mycontactform.com");
		
	}
	
	@BeforeMethod
	public void setUpLogger() {
		log = new LoggerMngr(this.getClass().getSimpleName());
	}

	@Test
	public void feedBackWorkFlow() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sample Forms")).click();
		log.logger.info("navigated to Sample Forms");
		
		driver.findElement(By.linkText("Simple Web Feedback")).click();
		log.logger.info("navigated to Simple Web Feedback form");
		
		driver.findElement(By.id("q[1]")).sendKeys("sukumar");
		driver.findElement(By.id("email")).sendKeys("sample@gmail.com");
		driver.findElement(By.xpath("//tr[4]//td[1]//font[1]//input[1]")).click();
		driver.findElement(By.xpath("//tr[6]//td[1]//font[1]//input[1]")).click();
		driver.findElement(By.name("submit")).click();
		
		log.logger.info("submitted Simple web feedback form");
		Thread.sleep(2000);
		String msgConfirmation1 = driver.findElement(By.tagName("h4")).getText();
		Assert.assertTrue(msgConfirmation1.contains("Thank You"));
		log.logger.info("verified confirmation msg");
		
		driver.findElement(By.linkText("Detailed Web Feedback")).click();
		log.logger.info("navigated to DEtailed web Feedback");
		
		driver.findElement(By.id("subject")).sendKeys("feedback");
		driver.findElement(By.id("q1")).sendKeys("sukumar");
		driver.findElement(By.id("email")).sendKeys("sample@gmail.com");
		driver.findElement(By.xpath("//tr[4]//td[1]//div[1]//input[1]")).click();
		driver.findElement(By.xpath("//tr[4]//td[1]//div[1]//input[1]")).click();
		
		Select navSys = new Select(driver.findElement(By.id("q5")));
		navSys.selectByVisibleText("9");
		
		driver.findElement(By.id("visver_code")).sendKeys("A9A665");
		driver.findElement(By.name("submit")).click();
		
		log.logger.info ("submitted Details web feedback form");
		Thread.sleep(10000);
		String msgConfirmation2 = driver.findElement(By.tagName("h4")).getText();
		Assert.assertTrue(msgConfirmation2.contains("Thank You"));
		
		log.logger.info("Verified confirmation msg");
	}
	
	@AfterTest
	public void endOfTest() {
		driver.close();
	}
	
}
