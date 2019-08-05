package com.testvagrant.utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.apache.log4j.Logger;

public class Testbase {

	public static WebDriver driver;
	Logger log = Logger.getLogger(getClass().getSimpleName());

	public utilities oUtil = new utilities();
	
	@BeforeSuite
	public void launch() throws Exception 
	{
		oUtil.loadPropertiesFile(System.getProperty("user.dir")+"/src/com/testvagrant/properties/log4j.properties");
		oUtil.loadPropertiesFile(System.getProperty("user.dir")+"/src/com/testvagrant/properties/TestData.properties");
		
		if(System.getProperty("Browser").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else{
			log.error("Browser Name invalid : "+System.getProperty("Browser"));
		}
		driver.manage().window().maximize();
		
	}

	@AfterSuite
	public void close ()
	{
		driver.quit();
	}
	
	@AfterTest
	public void quitbrowser()
	{
		driver.quit();
	}
	
	public void launchBaseUrl() throws Exception
	{
		System.out.println("URL :: "+System.getProperty("URL"));
		log.info("URL :: "+System.getProperty("URL"));
		driver.get(System.getProperty("URL"));
		
	}
	
}
