package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
WebDriver driver;
	
	
	//Objects
	
		@FindBy(id= "input-firstname")
		private WebElement firstNameField;
		
		@FindBy(id= "input-lastname")
		private WebElement lastNameField;
		
		@FindBy(id= "input-email")
		private WebElement emailField;
		
		@FindBy(id= "input-telephone")
		private WebElement telephoneField;
		
		@FindBy(id= "input-password")
		private WebElement passwordField;
		
		@FindBy(id= "input-confirm")
		private WebElement passwordConfirmField;
		
		@FindBy(xpath= "//input[@name='newsletter'][@value='1']")
		private WebElement yesNewsLetterOption;
		
		@FindBy(name= "agree")
		private WebElement privacyPolicyField;
		
		@FindBy(xpath= "//input[@value='Continue']")
		private WebElement continueButton;
		
		@FindBy(xpath= "//div[contains(@class,'alert-dismissible')]")
		private WebElement duplicateEmailAddressWarning;
		
		@FindBy(xpath= "//div[contains(@class,'alert-dismissible')]")
		private WebElement privacyPolicyWarning;
		
		@FindBy(xpath= "//input[@id='input-firstname']/following-sibling::div")
		private WebElement firstNameWarning;
		
		@FindBy(xpath= "//input[@id='input-lastname']/following-sibling::div")
		private WebElement lastNameWarning;
		
		@FindBy(xpath= "//input[@id='input-email']/following-sibling::div")
		private WebElement emailWarning;
		
		@FindBy(xpath= "//input[@id='input-telephone']/following-sibling::div")
		private WebElement telephoneWarning;
		
		@FindBy(xpath= "//input[@id='input-password']/following-sibling::div")
		private WebElement passwordWarning;
		
	//create a constructor
	
		public RegisterPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
			
	//Actions Or Method
			
		public void enterFirstName(String firstNameText) {
			firstNameField.sendKeys(firstNameText);	
		}
		
		public void enterLastName(String lastNameText) {
			lastNameField.sendKeys(lastNameText);	
		}	
		
		public void enterEmailAddress(String emailText) {
			emailField.sendKeys(emailText);	
		}
		
		public void enterTelephoneNumber(String telephoneText) {
			telephoneField.sendKeys(telephoneText);	
		}	
		
		public void enterPassword(String passwordText) {
			passwordField.sendKeys(passwordText);	
		}	
		
		public void enterConfirmPassword(String passwordText) {
			passwordConfirmField.sendKeys(passwordText);	
		}
		
		public void selectYesNewsLetterOption() {
			yesNewsLetterOption.click();	
		}

		public void selectPrivacyPolicy() {
			privacyPolicyField.click();	
		}
		
		public AccountSuccessPage clickOnContinueButton() {
			continueButton.click();	
			return new AccountSuccessPage(driver);
		}
		
		public AccountSuccessPage registerWithMandetoryField(String firstNameText,String lastNameText,String emailText,String telephoneText,String passwordText) {
			firstNameField.sendKeys(firstNameText);	
			lastNameField.sendKeys(lastNameText);
			emailField.sendKeys(emailText);	
			telephoneField.sendKeys(telephoneText);	
			passwordField.sendKeys(passwordText);	
			passwordConfirmField.sendKeys(passwordText);	
			yesNewsLetterOption.click();
			privacyPolicyField.click();	
			continueButton.click();	
			return new AccountSuccessPage(driver);
		}
		
		public AccountSuccessPage registerWithAllField(String firstNameText,String lastNameText,String emailText,String telephoneText,String passwordText) {
			firstNameField.sendKeys(firstNameText);	
			lastNameField.sendKeys(lastNameText);
			emailField.sendKeys(emailText);	
			telephoneField.sendKeys(telephoneText);	
			passwordField.sendKeys(passwordText);	
			passwordConfirmField.sendKeys(passwordText);	
			privacyPolicyField.click();	
			continueButton.click();	
			return new AccountSuccessPage(driver);
		}
		public String retrieveDuplicateEmailAddressWarning() {
			String DuplicateEmailWarningText = duplicateEmailAddressWarning.getText();
			return DuplicateEmailWarningText;
		}
		
		public boolean dispalyStatusOfWarningMessages(String expectedPrivacyPolicyWarningText,String expectedFirstNameWarningText,String expectedLastNameWarningText, String expectedEmailWarningText, String expectedTelephoneWarningText,String expectedPasswordWarningText) {
			
			//String actualPrivacyPolicyWarningText= privacyPolicyWarning.getText();
			//boolean privacyPolicyWarningStatus = actualPrivacyPolicyWarningText.contains(expectedPrivacyPolicyWarningText);
			
			//we can reduce line like this
			
			boolean privacyPolicyWarningStatus = privacyPolicyWarning.getText().contains(expectedPrivacyPolicyWarningText);
			boolean firstNameWarningStatus = firstNameWarning.getText().equals(expectedFirstNameWarningText);
			boolean lastNameWarningStatus = lastNameWarning.getText().equals(expectedLastNameWarningText);
			boolean emailWarningStatus = emailWarning.getText().equals(expectedEmailWarningText);
			boolean telephoneWarningStatus = telephoneWarning.getText().equals(expectedTelephoneWarningText);
			boolean passwordWarningStatus = passwordWarning.getText().equals(expectedPasswordWarningText);
			return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && telephoneWarningStatus && passwordWarningStatus;
			
		}
		public String retrievePrivacyPolicyWarning() {
			String PrivacyPolicyWarningText = privacyPolicyWarning.getText();
			return PrivacyPolicyWarningText;
		}
		
		public String retrieveFirstNameWarning() {
			String FirstNameWarningText = firstNameWarning.getText();
			return FirstNameWarningText;
		}
		
		public String retrieveLastNameWarning() {
			String LastNameWarningText = lastNameWarning.getText();
			return LastNameWarningText;
		}
		
		public String retrieveEmailWarning() {
			String EmailWarningText = emailWarning.getText();
			return EmailWarningText;
		}
		
		public String retrieveTelephoneWarning() {
			String TelephoneWarningText = telephoneWarning.getText();
			return TelephoneWarningText;
		}
		
		public String retrievePasswordWarning() {
			String PasswordWarningText = passwordWarning.getText();
			return PasswordWarningText;
		}
		
}
