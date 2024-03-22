package com.selenium.sanityTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.utility.Excel;

public class SingInTest {

WebDriver driver;
Excel excel;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.mycontactform.com");
	}
	

	@BeforeMethod
	public void excelSetUp() {
		excel = new Excel(System.getProperty("user.dir")+"//TestData//MyContactForm.xlsx");
	}
	@Test
	public void signInTest() throws InterruptedException, IOException {
		Thread.sleep(2000);
		//driver.findElement(By.id("user")).sendKeys("sukkumar3");
		//driver.findElement(By.id("pass")).sendKeys("june@2020");
		driver.findElement(By.id("user")).sendKeys(excel.readData("loginData",1,0));
		driver.findElement(By.id("pass")).sendKeys(excel.readData("loginData",1,1));
		driver.findElement(By.name("btnSubmit")).click();
		String msgWelcome = driver.findElement(By.xpath("//h5[contains(text(),'Welcome')]")).getText();
		Assert.assertTrue(msgWelcome.contains("sukkumar3"));
		excel.writeData("loginData",1,2,"success");
		Thread.sleep(5000);
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@AfterTest
	public void endOfTest() {
		driver.close();
	}
	
}
