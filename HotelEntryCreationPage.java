package com.hotel.test.pages.hotel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.hotel.test.utils.config.ConfigUtils;



public class HotelEntryCreationPage {

	private RemoteWebDriver driver;
	
	@FindBy()
	private WebElement login;
	
	@FindBy()
	private WebElement userName;
	
	
	@FindBy()
	private WebElement password;
	
	@FindBy(id = "VehicleRegistrationMark")
	private WebElement hotelName;

	@FindBy(id = "VehicleRegistrationMark")
	private WebElement address;
	
	@FindBy(id = "CountryofRegistration")
	private WebElement owner;

	@FindBy(id = "find-vehicle-button")
	private WebElement phoneNo;

	@FindBy(className = "field-validation-error")
	private WebElement email;
	
	@FindBy()
	private WebElement create;
	
	@FindBy()
	private WebElement delete;


	
	

	public HotelEntryCreationPage(RemoteWebDriver driver) {
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(finder, this);
		this.driver = driver;
	}

	public void goToHomePage() {
		driver.get(ConfigUtils.getWebEndPoint());
	}

	public void enterHotelName(String hotelNames) {
		hotelName.clear();
		hotelName.sendKeys(hotelNames);
	}

	public void enterAddress(String addressValue) {
		address.clear();
		address.sendKeys(addressValue);
	}
	
	public void enterOwner(String OwnerName) {
		owner.clear();
		owner.sendKeys(OwnerName);
	}
	
	public void enterPhoneNo(String phNo) {
		phoneNo.clear();
		phoneNo.sendKeys(phNo);
	}
	
	public void enterEmail(String emailaddress) {
		email.clear();
		email.sendKeys(emailaddress);
	}
	
	public void enteruserName(String user) {
		userName.clear();
		userName.sendKeys(user);
	}
	
	public void enterPasssword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	
	
	public void selectCreate(){
		create.click();
	}
	
	public void selectRemove(){
		delete.click();
	}
	
	
	public void selectLogin(){
		login.click();
	}
	
	
	
}