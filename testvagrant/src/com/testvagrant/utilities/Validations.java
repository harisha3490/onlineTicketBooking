package com.testvagrant.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class Validations extends Testbase {

	public void AssertFun(String Actual,String Expected,String FailureAssetionMessage)
	{
		 Assert.assertTrue(Actual.contains(Expected),FailureAssetionMessage);
	}
	
	public boolean isElementPresent(WebElement searchSummarytext) {
        try {
            driver.findElement((By) searchSummarytext);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
	
	
	 
	 
}
