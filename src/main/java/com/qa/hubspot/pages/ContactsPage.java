package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementActions;
import com.qa.hubspot.util.JavaScriptUtil;

public class ContactsPage extends BasePage{
	
	WebDriver driver;
	ElementActions elementAction;
	JavaScriptUtil jsUtil;
	
	By createContactBtn = By.xpath("//span[text()='Create contact']");
	By createContactSecondBtn = By.xpath("//li//span[text()='Create contact']");
	By email = By.id("UIFormControl-7");
	By firstName = By.id("UIFormControl-8");
	By lastName = By.id("UIFormControl-10");
	By jobTitle = By.id("UIFormControl-14");
	
	
	public ContactsPage(WebDriver driver){
		this.driver = driver;
		elementAction = new ElementActions(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	public void createNewContact(String emailval,String firstname,String lastname,String jobtitle){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(createContactBtn));
		elementAction.clickOnElement(createContactBtn);
		
		wait.until(ExpectedConditions.elementToBeClickable(email));
		elementAction.sendKeyElement(email, emailval);
		
		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		elementAction.sendKeyElement(firstName, firstname);
		
		wait.until(ExpectedConditions.elementToBeClickable(lastName));
		elementAction.sendKeyElement(lastName, lastname);
		
		wait.until(ExpectedConditions.elementToBeClickable(jobTitle));
		elementAction.sendKeyElement(jobTitle, jobtitle);
		
		wait.until(ExpectedConditions.elementToBeClickable(createContactSecondBtn));
		jsUtil.clickElementByJS(elementAction.getElement(createContactSecondBtn));
	}

}
