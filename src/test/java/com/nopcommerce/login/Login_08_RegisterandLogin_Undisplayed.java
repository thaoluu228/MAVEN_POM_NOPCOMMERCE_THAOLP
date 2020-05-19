package com.nopcommerce.login;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopCommerce.HomePage;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_08_RegisterandLogin_Undisplayed extends AbstractTest {
	private WebDriver driver;
	 String email, password;
	private HomePage homePage;
	private RegisterPage registerPage;
	
  @Parameters({ "browser" , "url" })
  @BeforeTest
   public void beforeTest(String browserName, String autUrl ) {
		  
		  driver = getBrowserDriver(browserName, autUrl);
	  
	  homePage = PageGeneratorManager.getHomePageObject(driver);
	
	  email = "thaoluu" + randomNumber() + "@yopmail.com";
	  password = "310228";
  }
  
  @Test 
  public void TC_01_CheckDisplayed() throws InterruptedException {
	  registerPage = homePage.clickToRegisterLink();
	  //Firstname textbox displayed
	  Assert.assertTrue(registerPage.isFirstnameTextboxDisplayed());
	  
	  //Lastname textbox displayed
	  Assert.assertTrue(registerPage.isElementDisplayed(driver, "//input[@id='LastName']"));
  }
  
  @Test
  public void TC_02_CheckUndisplayed() {
	  //Request verification token undisplayed (co trong DOM)
	  Assert.assertFalse(registerPage.isRequestUndisplayed());
  }  
  @Test
  public void TC_03_CheckUndisplayed_Not_In_Dom() {
	  //ko co trong DOM
	  Assert.assertFalse(registerPage.isRegisterUndisplayed());
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  
  public int randomNumber() {
		Random rand = new Random();
		int value = rand.nextInt(1000);
		return value;
		}

}
