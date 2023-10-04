package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends Base{
	
	SearchPage searchPage;
	//loading properties file using constructor
			public SearchTest() {
				super(); //supar constructor
			}
	public	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		
		HomePage HomePage = new HomePage(driver);
		
		//HomePage.enterProductNameIntoSearchBoxField(dataProp.getProperty("validProduct"));
		searchPage = HomePage.searchForAProduct(dataProp.getProperty("validProduct"));
		
		//SearchPage searchPage = new SearchPage(driver);
		Assert.assertTrue(searchPage.displayStatusOfHpValidProduct(),"Valid product HPis not displayed in the search result");
		
		//driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validProduct"));
		//driver.findElement(By.xpath("//button[contains(@class,'btn-default')]")).click();
		
		//or xpath = //div[@id='search']/descendant::button"
		//Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),"Valid product HPis not displayed in the search result");
		
	}
	
	@Test(priority=2)
	public void verifySearchWithInvalidProduct() {
		
		HomePage HomePage = new HomePage(driver);
		
		//HomePage.enterProductNameIntoSearchBoxField(dataProp.getProperty("inValidProduct"));
		searchPage = HomePage.searchForAProduct(dataProp.getProperty("inValidProduct"));
		
		//SearchPage searchPage = new SearchPage(driver);
		String actualSearchMessage = searchPage.retrieveNoProductMessageText();
		Assert.assertEquals(actualSearchMessage, dataProp.getProperty("NoProductTextInSearchResults"),"No product message in search results is not displayed.");
		
		/*driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("inValidProduct"));
		driver.findElement(By.xpath("//button[contains(@class,'btn-default')]")).click();
		String actualSearchMessage = driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText();
		Assert.assertEquals(actualSearchMessage, dataProp.getProperty("NoProductTextInSearchResults"),"No product message in search results is not displayed.");*/
		
	}
	
	//changes made on 10/04/2023

	@Test(priority=3)
	public void verifySearchWithoutAnyProduct() {
		
		HomePage HomePage = new HomePage(driver);
		searchPage = HomePage.clickOnSearchButton();
		
		//SearchPage searchPage = new SearchPage(driver);
		String actualSearchMessage = searchPage.retrieveNoProductMessageText();
		Assert.assertEquals(actualSearchMessage, dataProp.getProperty("NoProductTextInSearchResults"),"No product message in search results is not displayed.");
		
		/*driver.findElement(By.name("search")).sendKeys("");
		driver.findElement(By.xpath("//button[contains(@class,'btn-default')]")).click();
		
		String actualSearchMessage = driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText();
		Assert.assertEquals(actualSearchMessage, dataProp.getProperty("NoProductTextInSearchResults"),"No product message in search results is not displayed.");*/
	}
}
