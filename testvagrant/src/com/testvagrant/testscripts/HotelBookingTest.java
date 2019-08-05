package com.testvagrant.testscripts;
import com.sun.javafx.PlatformUtil;
import com.testvagrant.po.landingHomePO;
import com.testvagrant.utilities.Testbase;
import com.testvagrant.utilities.Validations;


import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HotelBookingTest extends Testbase {
	landingHomePO land;
	Validations validate;
	
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
    public void shouldBeAbleToSearchForHotels() throws Exception {

//		To navigate to the respective URL
		land.launchBaseUrl();
		
//		Actual Test Script execution
        land.hotelLink.click();
        
        land.localityTextBox.sendKeys(land.sLocality[0]);
        new Select(land.travellerSelection).selectByVisibleText(land.sTraveler[0]);
        land.searchButton.click();
    }

}
