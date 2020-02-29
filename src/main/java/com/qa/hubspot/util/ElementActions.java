package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.commons.Constants;

public class ElementActions extends BasePage{
	
	
	WebDriver driver;
	
	public ElementActions(WebDriver driver){
		this.driver = driver;
		
	}
	
	public WebElement getElement(By selector){
		WebDriverWait wait = new WebDriverWait(driver,Constants.DEFAULT_EXPLICIT_WAIT);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
		WebElement element = driver.findElement(selector);
		return element;
	}
	
	public void sendKeyElement(By selector,String value){
		getElement(selector).sendKeys(value);
	}
	
	public void clickOnElement(By selector){
		getElement(selector).click();
	}
	public String getTextElement(By selector){
		return getElement(selector).getText();
		
	}
	//public void 

}
