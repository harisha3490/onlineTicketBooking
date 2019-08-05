package com.testvagrant.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.testvagrant.po.landingHomePO;


public class DateSelector extends Testbase {

	 public void dateselection(int date) throws Exception
	    {
	    	WebElement eventLink = driver.findElement(By.xpath("//a[contains(text(), '"+date+"')]")); 
	    	eventLink.click(); 
	    	   	   	
	    }
}
