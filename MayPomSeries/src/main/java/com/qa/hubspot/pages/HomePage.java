package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {
	
	//1. page factory / elements 
	@FindBy(xpath = "a[@class='google-sign-in']")
	WebElement googleSignIn;
	
	public HomePage(WebDriver driver){//how to create constructor public/ class name/
		  this.driver = driver; 
		  PageFactory.initElements(driver,this);// this will initialize element above by help of driver in this class
		}
	
	//page actions:
	public String getHomePageTitle(){// first void then add string
		return driver.getTitle(); // this is coming from parent class
	}
	
	public String getgoogleSignIntext(){ // to get the text
		return googleSignIn.getText();
	}
	
	public boolean verifygoogleSignIn(){ // to verify
		return googleSignIn.isDisplayed();
	}
	
	

}
