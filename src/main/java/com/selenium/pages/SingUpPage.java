package com.selenium.pages;

import org.openqa.selenium.By;

public class SingUpPage {

	public By signUpLink = By.linkText("Sign up");
	public By unameTextBox = By.id("name"); 
	public By emailTextBox = By.id("email");
	public By userIdTextBox = By.id("user_signup");
	public By pswdTextBox = By.id("pass_signup");
	public By confirmPswdTextBox = By.id("pass2");
	public By userAgreeCheckBox = By.id("useragree");
	public By submitBtn = By.name("Submit");
	public By confirmMsgText = By.id("success_status");
	
	
}
