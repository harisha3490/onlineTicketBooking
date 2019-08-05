package com.testvagrant.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testvagrant.po.landingHomePO;

public  class Commonutilities {
//	landingHomePO land;
//	land=new landingHomePO(driver);
	public static String currentPath;
	static Properties props = new Properties();
	static FileInputStream fileIn = null;
	Logger log = Logger.getLogger(getClass().getSimpleName()); 
	
		 
	public void loadPropertiesFile(String propertiesFileNameWithPath) throws IOException
	{
	
	 log.info("Current dir using System:" + propertiesFileNameWithPath);
		fileIn = new FileInputStream(propertiesFileNameWithPath);
		props.load(fileIn);
		System.getProperties().putAll(props);
		// log.info(util.props);
	}
	
	public boolean ufWaitForElementDisplayed(WebElement element, int itimetowait) throws Exception {
        boolean bResultFlag = false;
        for (int i=0; i<(itimetowait*2); i++)
        {
               try {
               bResultFlag = element.isDisplayed();

               if (bResultFlag){
                     log.info("Element Displayed");
                     log.info(i);
                     log.info("Exit Time "+ i/2);
                     return bResultFlag;
               }
               
               }catch(Exception ea) {
               log.info("page still not loaded");
               }
        
        }
        WebDriverWait wait = new WebDriverWait(Testbase.driver, itimetowait);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
        return bResultFlag; 

  }
	
	public void ufWaitForElementDisplayed1(WebElement element, int itimetowait) throws Exception {
        
        WebDriverWait wait = new WebDriverWait(Testbase.driver, itimetowait);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));

  } 
	public void waitFor(int durationInMilliSeconds) {
      try {
          Thread.sleep(durationInMilliSeconds);
      } catch (InterruptedException e) {
          e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
  }
	
	
}
