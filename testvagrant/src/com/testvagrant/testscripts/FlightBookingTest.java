
package com.testvagrant.testscripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.testvagrant.po.landingHomePO;
import com.testvagrant.utilities.Testbase;
import com.testvagrant.utilities.Validations;
import com.thoughtworks.selenium.webdriven.commands.KeyEvent;
import com.testvagrant.utilities.Commonutilities;
import com.testvagrant.utilities.DateSelector;

import java.awt.Robot;
import java.util.List;

public class FlightBookingTest extends Testbase {
	landingHomePO land;
	Validations validate;
	Commonutilities outi;
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

    	validate=new Validations();
    	outi=new Commonutilities();
//		To navigate to the respective URL
		land.launchBaseUrl();

		
//		Select the  radio Button for the journey( One way / two way)
	
		outi.ufWaitForElementDisplayed(land.rbtn_oneway,40000);
        land.txt_FromTag.clear();
        land.txt_FromTag.sendKeys(land.fromLocation[0]);


        //wait for the auto complete options to appear for the origin
        outi.waitFor(5000);
        List<WebElement> originOptions = land.actnDdn_SelctionFromLocation;

        originOptions.get(0).click();
        outi.ufWaitForElementDisplayed(land.txt_ToTag,4000);
//        Selecting the To location in the box
        land.txt_ToTag.clear();
        land.txt_ToTag.sendKeys(land.ToLocation[0]);

        //wait for the auto complete options to appear for the destination

        outi.ufWaitForElementDisplayed(land.actnDdn_SelctionToLocation1,4000);
        //select the first item from the destination auto complete list
        List<WebElement> destinationOptions = land.actnDdn_SelctionToLocation;

        destinationOptions.get(0).click();

//  Method is used to select the date
        
        Odate=new DateSelector();
        Odate.dateselection(12);


//all fields filled in. Now click on search
        land.btn_Search.click();

      
//verify that result appears for the provided journey search
        outi.ufWaitForElementDisplayed(land.searchSummarytext,4000);
        Assert.assertTrue(land.searchSummarytext.isDisplayed());


   
    }



}
