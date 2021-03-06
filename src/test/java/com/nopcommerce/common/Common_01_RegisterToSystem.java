package com.nopcommerce.common;


import commons.AbstractTest;
import pageObjects.nopCommerce.HomePage;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPage;

import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

public class Common_01_RegisterToSystem extends AbstractTest {
	private WebDriver driver;
	public static String email, password, registerSuccessMsg;
	private HomePage homePage;
	private RegisterPage registerPage;
	
  @Parameters({ "browser" , "url" })
  @BeforeSuite
	public void createNewUser(String browserName, String autUrl ) {
			  
	  driver = getBrowserDriver(browserName, autUrl);
	
	  homePage = PageGeneratorManager.getHomePageObject(driver);
	
	  email = "thaoluu" + randomNumber() + "@yopmail.com";
	  password = "310228";
	  
	 
	  registerPage = homePage.clickToRegisterLink();
	
	  registerPage.clickToFemale();
	  registerPage.inputToFirstName("Thao");
	  registerPage.inputToLastName("Phuong");
	  registerPage.selectDay("3");
	  registerPage.selectMonth("October");
	  registerPage.selectYear("1996");
	  registerPage.inputToEmailTextbox(email);
	  registerPage.inputToCompanyTextbox("Testing");
	  registerPage.inputToPassword(password);
	  registerPage.inputToConfirmPassword(password);
	  registerPage.clickToRegisterButton();
	  registerSuccessMsg = registerPage.getRegisterSuccessMessage();
	  Assert.assertEquals(registerSuccessMsg, "Your registration completed");
	  homePage = registerPage.clickToLogoutLink();
	  
	  driver.quit();
  }
  
}
