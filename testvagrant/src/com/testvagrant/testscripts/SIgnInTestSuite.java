package com.testvagrant.testscripts;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.Augmentable;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testvagrant.po.landingHomePO;
import com.testvagrant.utilities.Testbase;
import com.testvagrant.utilities.Validations;


public class SIgnInTestSuite extends Testbase {

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
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() throws Exception {
		
//		To navigate to the respective URL
			land.launchBaseUrl();		 	
		 	land.lnk_yourTrip.click();
		 	land.btn_SignIn.click();
		 	driver.switchTo().frame(land.Ifrm_modleWindow);
		 	land.btn_RegisterNew.click();

	        String errorMessage = land.err_InSubmission.getText();
	       
//Function to validate the assertion in the script
	        validate=new Validations();

	        validate.AssertFun(errorMessage, land.sErrorString[0], land.sErrorString[1]);
	}
	
	
	
}

