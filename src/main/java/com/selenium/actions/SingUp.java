package com.selenium.actions;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.pages.SingUpPage;

public class SingUp  {
	
	SingUpPage objSingUp ;
	
	public SingUp() {
		objSingUp = new SingUpPage();
	}
	
	public void navigateToSignUpForm(WebDriver driver){
		
		driver.findElement(objSingUp.signUpLink).click();
	}
	
	public void fillOutUserDetails(WebDriver driver, HashMap<String,String> formData){
		
		driver.findElement(objSingUp.unameTextBox).sendKeys(formData.get("name"));
		driver.findElement(objSingUp.emailTextBox).sendKeys(formData.get("email"));
		driver.findElement(objSingUp.userIdTextBox).sendKeys(formData.get("userName"));
		driver.findElement(objSingUp.pswdTextBox).sendKeys(formData.get("passWord"));
		driver.findElement(objSingUp.confirmPswdTextBox).sendKeys(formData.get("passWord"));
	
	}
	public void acceptTerms(WebDriver driver){
		driver.findElement(objSingUp.userAgreeCheckBox).click();
		
	}
	public void submitForm(WebDriver driver){
		driver.findElement(objSingUp.submitBtn).click();
	}
	
	public String verifyTheConfirmationMsg(WebDriver driver){
		return driver.findElement(objSingUp.confirmMsgText).getText();
		//Assert.assertTrue(msgSuccess.contains("SUCCESS"));
	}	

}
