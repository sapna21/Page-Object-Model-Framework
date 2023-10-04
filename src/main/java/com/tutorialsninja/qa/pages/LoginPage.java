package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver driver;
	
	//Objects
	
	@FindBy(id= "input-email")
	private WebElement emailAddressField;
	
	@FindBy(id= "input-password")
	private WebElement passwordField;
	
	@FindBy(xpath= "//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath= "//div[contains(@class,'alert-dismissible')]")
	private WebElement emailPasswordNotMatching;
	
	//create a constructor
	
		public LoginPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		
	//Actions Or Method
		
		
		public AccountPage Login(String emailText,String passwordText) {
			emailAddressField.sendKeys(emailText);
			passwordField.sendKeys(passwordText);
			loginButton.click();
			return new AccountPage(driver);
		}
		public void clickOnLoginButton() {
			loginButton.click();
			
		}
		
		public String retrieveEmailPasswordNotMatchingWarningMessageText() {
			String WarningText = emailPasswordNotMatching.getText();
			return WarningText;
		}
}
