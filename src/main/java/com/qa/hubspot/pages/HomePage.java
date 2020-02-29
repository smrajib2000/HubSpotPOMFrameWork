package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.CommonUtil;
import com.qa.hubspot.util.ElementActions;

public class HomePage extends BasePage{
	
	WebDriver driver;
	ElementActions elementActions;
	
	By homePageHeader = By.xpath("//h1[@class='private-page__title']");
	By accountName = By.xpath("//span[@class='account-name ']");
	By contactsMainLink = By.id("nav-primary-contacts-branch");
	By contactsSecondLink = By.id("nav-secondary-contacts");
	
	
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		elementActions = new ElementActions(driver);
	}
	
	public String getHomePageTitle(){
		return driver.getTitle();
		
	}
	
	public String getHomePageHeadervalue(){
		//return homePageHeader.getText();
		return elementActions.getTextElement(homePageHeader);
	}
	
	public String getLoggedInAccountName(){
		//return accountName.getText();
		return elementActions.getTextElement(accountName);
		
	}
	
	public ContactsPage goToContactsPage(){
		elementActions.clickOnElement(contactsMainLink);
		CommonUtil.shortWait();
		elementActions.clickOnElement(contactsSecondLink);
		return new ContactsPage(driver);
	}

}
