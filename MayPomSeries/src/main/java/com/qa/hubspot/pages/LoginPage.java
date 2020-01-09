package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage{
	//1.page factory--page objects:
	@FindBy(id="username")//import selenium, same as driver.findele.(by.id
	WebElement emailid;//import selenium
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement loginButton;
	
	@FindBy(linkText="Sign up")
	WebElement signUpLink;
	
	//2. create the constructor of login page class and initialize your page objects:
	
	public LoginPage(WebDriver driver){//how to create constructor public/ class name/
	  this.driver = driver; 
	  PageFactory.initElements(driver,this);// this will initialize element above by help of driver in this class
	}
	
	
	//3. page Actions/ page library:
	public String getLoginPageTitle(){// first void then add string
		return driver.getTitle(); // this is coming from parent class
	}
	
	public boolean verifySignupLinkDisplayed(){// first void then add boolean
		return signUpLink.isDisplayed();
	}
	
	public  HomePage doLogin(String username, String pwd){
		System.out.println("credetials:"+ username+"/"+pwd);
		emailid.sendKeys(username);	//veriable from top and username from String above
		password.sendKeys(pwd);
		loginButton.click();
		
		return new HomePage(driver);
	}
	
	
	
	
	
	
	
	

}
