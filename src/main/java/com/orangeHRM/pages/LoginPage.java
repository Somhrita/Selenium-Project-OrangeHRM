package com.orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangeHRM.actiondriver.ActionDriver;

public class LoginPage {
	private ActionDriver actionDriver;
	
	
	//Define locators using By Class
	private By usernameField= By.name("username");
	private By passwordField= By.cssSelector("input[type='password']");
	private By loginButton= By.xpath("//button[text()=' Login ']");
	private By errorMessage=By.xpath("//p[text()='Invalid credentials']");
	
	public LoginPage(WebDriver driver) {
		this.actionDriver = new ActionDriver(driver);
	}
	
	
	//Method to perform login
	public void login(String userName,String password) {
		actionDriver.enterText(usernameField, "Admin");
		actionDriver.enterText(passwordField, "admin123");
		actionDriver.click(loginButton);
	}
	
	//Method to check if error message is displayed
	public boolean isErrorMessageDisplayed() {
		return actionDriver.isDisplayed(errorMessage);
	}
	
	//Method to get the text from Error Message
	public String getErrorMessageTexr() {
		return actionDriver.getText(errorMessage);
		
	}
	
	//Verify if error is correct or not 
	public boolean verifyErrorMessage(String expectedError) {
		return actionDriver.compareText(errorMessage, expectedError);
	}
	
}
