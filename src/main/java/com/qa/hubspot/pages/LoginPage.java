package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.CommonUtil;
import com.qa.hubspot.util.ElementActions;
import com.qa.hubspot.util.JavaScriptUtil;

public class LoginPage extends BasePage{
	WebDriver driver;
	ElementActions elementActions;
	JavaScriptUtil  jsUtil;
	By username = By.id("username");
	By password = By.id("password");
	By loginBtn = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	
	//1. create a constructor of page class and intialize all the page objects with driver
	public LoginPage(WebDriver driver){
		this.driver = driver;
		elementActions = new ElementActions(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	//2. define your actions/methods
	public String getLoginPageTitle(){
		//return driver.getTitle();
		return jsUtil.getTitleByJS();
	}
	
	public boolean verifySignUpLink(){
		return elementActions.getElement(signUpLink).isDisplayed();
		
	}
	
	public HomePage doLogin(String un, String pwd){
		elementActions.sendKeyElement(username, un);
		
		elementActions.sendKeyElement(password, pwd);
				
		//elementActions.clickOnElement(loginBtn);
		jsUtil.clickElementByJS(elementActions.getElement(loginBtn));
		return new HomePage(driver);
	}
}
