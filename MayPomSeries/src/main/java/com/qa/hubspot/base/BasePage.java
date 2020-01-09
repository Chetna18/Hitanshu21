package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.hubspot.util.TimeUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author chetn
 *
 */

public class BasePage {

	public WebDriver driver;// we need this, so it is global variable accessible throughout the program
	
	public Properties prop; // we need this, so it is global variable accessible throughout the program
	/**
	 * This method is used to initialize the webdriver
	 * @param prop
	 * @return driver
	 */
	
	public WebDriver initialize_driver(Properties prop){ //start with void then change it to Properties
		String broserName = prop.getProperty("browser");
		
		if(broserName.equals("chrome")){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		}
		else if(broserName.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else{
			System.out.println(" Browser" +broserName+ "is defined is properties file, please give the correct browser name");
		}
		
		driver.manage().deleteAllCookies();//basic stuff
		driver.manage().window().fullscreen();//basic stuff
		driver.get(prop.getProperty("url"));
		TimeUtil.MediumWait();// instated of writing thread.sleep we create class and then use it here
		return driver;// after u open ur browser u return ur driver
		
		
		}
	/**
	 * This method is used to initialize the properties and it will return properties reference
	 * @return
	 */
	
	public Properties initialize_properties(){ // start with void then change it to Properties
	
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\chetn\\workspace\\MayPomSeries\\"
					+ "src\\main\\java\\com\\qa\\hubspot\\configuration\\config.properties");//import file and add try/catch
			try {
				prop.load(ip);//import try/catch
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;
			}
	
	
	
	
	
	
	
	
	
	
	
}
