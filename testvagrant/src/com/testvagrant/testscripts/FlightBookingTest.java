
package com.testvagrant.testscripts;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.testvagrant.po.landingHomePO;
import com.testvagrant.utilities.Testbase;
import com.testvagrant.utilities.Validations;
import com.testvagrant.utilities.utilities;
import com.testvagrant.utilities.DateSelector;


import java.util.ArrayList;
import java.util.List;

public class FlightBookingTest extends Testbase {
	landingHomePO land;
	Validations validate;
	utilities outi;
	DateSelector Odate;
	
	@BeforeTest
	public void setup() {
	land=new landingHomePO(driver);
	}
	
	@AfterTest
	public void quitbrowser()
	{
		driver.quit();
	}

    
    @Test
    public void testThatResultsAppearForAOneWayJourney() throws Exception {

//		To navigate to the respective URL
		land.launchBaseUrl();
    	
		waitFor(2000);
//		outi.ufWaitForElementDisplayed(land.rbtn_oneway, 2000);
        land.rbtn_oneway.click();
        land.txt_FromTag.clear();
        land.txt_FromTag.sendKeys(land.fromLocation[0]);


        //wait for the auto complete options to appear for the origin

        waitFor(2000);
        List<WebElement> originOptions = land.actnDdn_SelctionFromLocation;

        originOptions.get(0).click();
       waitFor(2000);
//        Selecting the To location in the box
        land.txt_ToTag.clear();
        land.txt_ToTag.sendKeys(land.ToLocation[0]);

        //wait for the auto complete options to appear for the destination

       waitFor(2000);
        //select the first item from the destination auto complete list
        List<WebElement> destinationOptions = land.actnDdn_SelctionToLocation;

        destinationOptions.get(0).click();

//  Method is used to select the date
        Odate.dateselection(12);


        //all fields filled in. Now click on search
        land.btn_Search.click();

        waitFor(5000);
        //verify that result appears for the provided journey search
        Assert.assertTrue(validate.isElementPresent(land.searchSummarytext));

   
    }
    public void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
