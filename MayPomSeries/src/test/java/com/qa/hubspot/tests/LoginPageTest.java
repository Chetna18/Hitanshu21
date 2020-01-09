package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspots.constants.Constants;

public class LoginPageTest {

	WebDriver driver;// import selenium
	Properties prop;// import util
	BasePage basepage;// reference of the base page
	LoginPage loginpage;

	@BeforeMethod
	public void setup() {
		basepage = new BasePage();
		prop = basepage.initialize_properties();// u put ". " u will get method
												// frmo the base class. return
												// type is prop so we store in
												// prop
		driver = basepage.initialize_driver(prop);
		loginpage = new LoginPage(driver);

	} 

	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title = loginpage.getLoginPageTitle();
		System.out.println("the login page title is:" + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);// actual url and
																// expected url
	}
	@Test(priority=2)
	public void verifySignUpLinkTest(){
		Assert.assertTrue(loginpage.verifySignupLinkDisplayed());
	}
	
	@Test(priority=3)
	public void loginTestWithCorrectCredntialTest(){
		loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=4)
	public void loginTestWithinCorrectCredntialTest(){
		loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() { // teardown means close the browser
		driver.quit();
	}

}
