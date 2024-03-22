package com.selenium.sanityTests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.actions.SingUp;
import com.selenium.utility.Excel;
import com.selenium.utility.PropertyFile;

public class SingUPTest {

	WebDriver driver;
	PropertyFile objPropertyFile;
	SingUp singUp;
	Excel excel;
	
	@BeforeTest
	public void setUp() throws IOException {
		singUp = new SingUp();
		excel = new Excel(System.getProperty("user.dir")+"//TestData//MyContactForm.xlsx");
		objPropertyFile = new PropertyFile(System.getProperty("user.dir")+"//Resources//config.properties");
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("http://www.mycontactform.com");
		driver.get(objPropertyFile.readProperty("url"));
	}
	
	@Test
	public void signUpTest() throws InterruptedException {
						
		
		singUp.navigateToSignUpForm(driver);
		singUp.fillOutUserDetails(driver, excel.readData("signUpData"));
		singUp.acceptTerms(driver);
		singUp.submitForm(driver);
		String msgSuccess = singUp.verifyTheConfirmationMsg(driver);
		//Assert.assertTrue(msgSuccess.contains("SUCCESS"));
		Assert.assertTrue(msgSuccess.contains(objPropertyFile.readProperty("confMsgContent")));
		
	}
	
	@AfterTest
	public void endOfTest() {
		driver.close();
	}
}
