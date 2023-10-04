package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	WebDriver driver;
	
	//Objects
	
		@FindBy(xpath= "//div[@id='content']/h1")
		private WebElement accountSuccessPageHeading;
		
	//create a constructor
		
		public AccountSuccessPage(WebDriver driver) {
		   this.driver = driver;
		   PageFactory.initElements(driver, this);
		}
		
	//Actions Or Method
		
		public String retrieveAccountSuccessPageHeading() {
			String accountSuccessPageHeadingText = accountSuccessPageHeading.getText();	
			return accountSuccessPageHeadingText;
		}
				
}
