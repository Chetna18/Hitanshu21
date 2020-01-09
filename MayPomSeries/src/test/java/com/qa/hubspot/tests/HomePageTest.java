package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class HomePageTest {
	WebDriver driver;// import selenium
	Properties prop;// import util
	BasePage basepage;// reference of the base page
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeMethod
	public void setup() {
		basepage = new BasePage();
		prop = basepage.initialize_properties();// u put ". " u will get method
												// frmo the base class. return
												// type is prop so we store in
												// prop
		driver = basepage.initialize_driver(prop);
		loginpage = new LoginPage(driver);
		loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void verifygoogleSignIn(){
		
	}
		
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() { // teardown means close the browser
		driver.quit();
	}


}
