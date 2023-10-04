package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base{
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	//loading properties file using constructor
		public RegisterTest() {
			super(); //supar constructor
		}
	public	WebDriver driver;
	
	@BeforeMethod
		public void setUp() {
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		
		HomePage homepage = new HomePage(driver);
		registerPage = homepage.nevigateToRegisterPage();
		
    	//driver.findElement(By.xpath("//span[text()='My Account']")).click();
    	//driver.findElement(By.linkText("Register")).click();
    	
		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
		
	@Test(priority=1)
	public void verifyRegisteringAnAccountWithMandatoryFields() {

		/*registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("ValidPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("ValidPassword"));
		registerPage.selectPrivacyPolicy();
		accountSuccessPage = registerPage.clickOnContinueButton();*/
		
		accountSuccessPage = registerPage.registerWithMandetoryField(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("telephone"), prop.getProperty("ValidPassword"));
		//AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		String actualSuccessHeading = accountSuccessPage.retrieveAccountSuccessPageHeading();
		Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account success page is not displayed.");
		
		
		/*driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("ValidPassword"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		
		Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account success page is not displayed.");*/
	
		
	}
	
	@Test(priority=2)
	public void verifyRegisteringAnAccountWithAllFields() {
		
		/*registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("ValidPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("ValidPassword"));
		registerPage.selectYesNewsLetterOption();
		registerPage.selectPrivacyPolicy();
		accountSuccessPage = registerPage.clickOnContinueButton();*/
		
		accountSuccessPage = registerPage.registerWithAllField(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("telephone"), prop.getProperty("ValidPassword"));
		//AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		String actualSuccessHeading = accountSuccessPage.retrieveAccountSuccessPageHeading();
		Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account success page is not displayed.");
		
		
		/*driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("ValidPassword"));
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		
		Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account success page is not displayed.");*/
	
		
	}
	
	@Test(priority=3)
	public void verifyRegisteringAnAccountWithExistingEmailAddress() {
		
		/*registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(prop.getProperty("ValidEmail"));
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("ValidPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("ValidPassword"));
		registerPage.selectYesNewsLetterOption();
		registerPage.selectPrivacyPolicy();
		registerPage.clickOnContinueButton();*/
		
		accountSuccessPage = registerPage.registerWithAllField(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), prop.getProperty("ValidEmail"), dataProp.getProperty("telephone"), prop.getProperty("ValidPassword"));
		
		String actualWarningMessage = registerPage.retrieveDuplicateEmailAddressWarning() ;
		String expectedWarningMessage = dataProp.getProperty("duplicateEmailWarning");
		Assert.assertEquals(actualWarningMessage,expectedWarningMessage, "Warning message regarding duplicate email address is not displayed.");
		
		/*driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("ValidEmail"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("ValidPassword"));
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = dataProp.getProperty("duplicateEmailWarning");
		Assert.assertEquals(actualWarningMessage,expectedWarningMessage, "Warning message regarding duplicate email address is not displayed.");*/
	
		
	}
	
	@Test(priority=4)
	public void verifyRegisteringAnAccountWithoutFillingAnyDetails() {
	
		registerPage.clickOnContinueButton();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(registerPage.dispalyStatusOfWarningMessages(dataProp.getProperty("privacyPolicyWarning"), dataProp.getProperty("firstNameWarning"), dataProp.getProperty("lastNameWarning"), dataProp.getProperty("emailWarning"), dataProp.getProperty("telephoneWarning"), dataProp.getProperty("passwordWarning")), "Warning Messages are not displayed");
		
		/*String actuyalPrivacyPolicyWarning = registerPage.retrievePrivacyPolicyWarning();
		String expectedPrivacyPolicyWarning = dataProp.getProperty("privacyPolicyWarning");
		Assert.assertEquals(actuyalPrivacyPolicyWarning,expectedPrivacyPolicyWarning,"Warning message regarding privacy policy is not displayed.");
		
		String actualFirstnameWarning = registerPage.retrieveFirstNameWarning();
		Assert.assertEquals(actualFirstnameWarning,dataProp.getProperty("firstNameWarning"), "Warning message regarding firstname is not displayed.");
		
		String actualLastnameWarning = registerPage.retrieveLastNameWarning();
		Assert.assertEquals(actualLastnameWarning,dataProp.getProperty("lastNameWarning"), "Warning message regarding lastname is not displayed.");
		
		String actualEmailWarning = registerPage.retrieveEmailWarning();
		Assert.assertEquals(actualEmailWarning,dataProp.getProperty("emailWarning"), "Warning message regarding email is not displayed.");
		
		
		String actualTelephoneWarning = registerPage.retrieveTelephoneWarning();
		Assert.assertEquals(actualTelephoneWarning,dataProp.getProperty("telephoneWarning"), "Warning message regarding telephone is not displayed.");
		
		String actualPasswordWarning = registerPage.retrievePasswordWarning();
		Assert.assertEquals(actualPasswordWarning,dataProp.getProperty("passwordWarning"), "Warning message regarding password is not displayed.");*/
		
		
		
		
		/*String actuyalPrivacyPolicyWarning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedPrivacyPolicyWarning = dataProp.getProperty("privacyPolicyWarning");
		Assert.assertEquals(actuyalPrivacyPolicyWarning,expectedPrivacyPolicyWarning,"Warning message regarding privacy policy is not displayed.");
		
		String actualFirstnameWarning = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
		Assert.assertEquals(actualFirstnameWarning,dataProp.getProperty("firstNameWarning"), "Warning message regarding firstname is not displayed.");
	
		
		String actualLastnameWarning = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
		Assert.assertEquals(actualLastnameWarning,dataProp.getProperty("lastNameWarning"), "Warning message regarding lastname is not displayed.");
		
		String actualEmailWarning = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
		Assert.assertEquals(actualEmailWarning,dataProp.getProperty("emailWarning"), "Warning message regarding email is not displayed.");
		
		
		String actualTelephoneWarning = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
		Assert.assertEquals(actualTelephoneWarning,dataProp.getProperty("telephoneWarning"), "Warning message regarding telephone is not displayed.");
		
		String actualPasswordWarning = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		Assert.assertEquals(actualPasswordWarning,dataProp.getProperty("passwordWarning"), "Warning message regarding password is not displayed.");*/
	}

	
}
