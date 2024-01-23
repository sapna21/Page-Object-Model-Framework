package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;
//more comment added
public class LoginTest extends Base{
	LoginPage loginPage;
	AccountPage accountPage;
	//loading properties file using constructor
	public LoginTest() {
		super(); //supar constructor
	}
	
	public WebDriver driver;
	
	@BeforeMethod
		public void setUp() {
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		
		HomePage homepage = new HomePage(driver);
		loginPage = homepage.nevigateToLoginPage();
		
    	//driver.findElement(By.xpath("//span[text()='My Account']")).click();
    	//driver.findElement(By.linkText("Login")).click();
    	
		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
    @Test(priority=1,dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email,String password) {
    	
      //Read data from properties file
    	
		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("ValidEmail"));
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
    	
     //Read data from dataprovider (data driven method)
  
    	accountPage = loginPage.Login(email, password);
    	
    	/* driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();  */
		
    	//AccountPage accountPage = new AccountPage(driver);
    	Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption(),"Edit your account information not displayed.");
    	
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"Edit your account information not displayed.");
	
	}
    
    @DataProvider(name="validCredentialsSupplier")
    //HardCodedDataDrivenApproch
   /* public Object[][] supplyTestData() {
    	Object[][] data = {{"malaviyasapna@gmail.com","12345"},
    					  {"malaviyasapna1@gmail.com","12345"},
    					  {"malaviyasapna2@gmail.com","12345"}};
    	return data;
    }*/
    
    // DataReadFromExcelFile
    public Object[][] supplyTestData() {
    	
    	Object[][] data = Utilities.getTestDataFromExcel("Login");
    	return data;
    }
    
    @Test(priority=2)
    public void VerifyLoginWithInvalidCredentials() {
    	
    	accountPage = loginPage.Login(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
    	
    	/*loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
    	loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
    	loginPage.clickOnLoginButton();*/
    	
    
		//driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		
    	String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText(); 
		//String actualWarningMessage =  driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		//System.out.println(actualWarningMessage);
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage,"Expected Warning Message is not Displayed");
		//Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning Message is not Displayed");
		
    }
    
    @Test(priority=3)
    public void VerifyLoginWithInvalidEmailAndValidPassword() {
    	
    	
    	accountPage = loginPage.Login(Utilities.generateEmailWithTimeStamp(), prop.getProperty("ValidPassword"));
    	
    	/*loginPage.enterEmailAddress(dataProp.getProperty("invalidEmailAddress"));
    	loginPage.enterPassword(prop.getProperty("ValidPassword"));
    	loginPage.clickOnLoginButton();*/
    	
    	
		//driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("ValidPassword"));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
    	
    	String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText(); 
		//String actualWarningMessage =  driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		System.out.println(actualWarningMessage);
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage,"Expected Warning Message is not Displayed");
		//Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning Message is not Displayed");
		
    }
    
    @Test(priority=4)
    public void VerifyLoginWithValidEmailAndInvalidPassword() {
    	
    	accountPage = loginPage.Login(prop.getProperty("ValidEmail"), dataProp.getProperty("invalidPassword"));
    	
    	/*loginPage.enterEmailAddress(prop.getProperty("ValidEmail"));
    	loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
    	loginPage.clickOnLoginButton();*/
    	
		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("ValidEmail"));
		//driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
    	
    	
    	String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText(); 
		//String actualWarningMessage =  driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		System.out.println(actualWarningMessage);
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage,"Expected Warning Message is not Displayed");
		//Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning Message is not Displayed");
		
    }
    
    @Test(priority=5)
    public void VerifyLoginWithoutAnyCredentials() {
    	
		//driver.findElement(By.id("input-email")).sendKeys("");
		//driver.findElement(By.id("input-password")).sendKeys("");
    	
    	
    	loginPage.clickOnLoginButton();
    	
    	//driver.findElement(By.xpath("//input[@value='Login']")).click();
		
    	String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText(); 
		//String actualWarningMessage =  driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		System.out.println(actualWarningMessage);
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage,"Expected Warning Message is not Displayed");
		//Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning Message is not Displayed");
		
    }
    
    
   
    
}
