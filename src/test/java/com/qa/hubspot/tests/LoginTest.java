package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.commons.Constants;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.CommonUtil;

public class LoginTest {
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.intialize_properties();
		driver = basePage.initialize_driver(prop);
		
		driver.get(prop.getProperty("url"));
		CommonUtil.mediumWait();
		loginPage = new LoginPage(driver); 
	}

	@Test(priority=1)
	public void verifyLoginPagetitleTest(){
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login Page title is :"+title);
		Assert.assertEquals(title, Constants.LOGINPAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifySignUpLinkTest(){
		Assert.assertTrue(loginPage.verifySignUpLink(),"Signup Link is not visible");
	}
	@Test(priority=3)
	public void doLogin(){
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		
	}
}
