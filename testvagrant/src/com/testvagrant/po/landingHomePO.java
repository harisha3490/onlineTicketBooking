package com.testvagrant.po;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.testvagrant.utilities.Testbase; 

public class landingHomePO extends Testbase{
	
	@FindBy(linkText="Your trips")
	public WebElement lnk_yourTrip;		
	
	@FindBy(id="SignIn")
	public WebElement btn_SignIn;

	@FindBy(id="modal_window")
	public WebElement Ifrm_modleWindow;
	
	@FindBy(id="signInButton")
	public WebElement btn_RegisterNew;
	
	@FindBy(id="errors1")
	public WebElement err_InSubmission;
	
	public String [] sErrorString= {"There were errors in your submission","Error Message Was not displayed"};
	
	
	
	@FindBy(linkText = "Hotels")
	public WebElement hotelLink;

    @FindBy(id = "Tags")
    public WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    public WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    public WebElement travellerSelection;

    public String [] sLocality= {"Indiranagar, Bangalore"};
    public String [] sTraveler= {"1 room, 2 adults"};

    
    
    
    @FindBy(id = "OneWay")
    public WebElement rbtn_oneway;
    
    @FindBy(id = "FromTag")
    public WebElement txt_FromTag;
    
    @FindBy(id = "ToTag")
    public WebElement txt_ToTag;
    
    public String [] fromLocation= {"Bangalore"};
    public String [] ToLocation= {"Delhi"};
    
    @FindBy(id = "ui-id-1")
    public WebElement ddl_FromSelect;
    
    @FindBy(xpath="//ul[@role='listbox']/li")
	public List<WebElement> ddn_CSRAsignneNames3;
    
    @FindBy(xpath="//ul[@id='ui-id-1']/li")
	public List<WebElement> actnDdn_SelctionFromLocation;
    
    @FindBy(xpath="//ul[@id='ui-id-2']/li")
   	public List<WebElement> actnDdn_SelctionToLocation;
    
    @FindBy(id = "SearchBtn")
    public WebElement btn_Search;
    

    
    @FindBy(xpath="//*[@className='searchSummary']")
  	public WebElement searchSummarytext;

    
	public landingHomePO(WebDriver driver) {
		Testbase.driver = driver;
		PageFactory.initElements(driver, this);
	}
	


}
