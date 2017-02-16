package com.hotel.test.steps.jp;

import static org.junit.Assert.assertTrue;

import com.hotel.test.pages.hotel.HotelEntryCreationPage;
import com.hotel.test.steps.CommonSteps;
import com.hotel.test.utils.common.Utils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class CreateDeleteEntrySteps extends CommonSteps{
	
	public CreateDeleteEntrySteps() {
		hotelEntryCreationPage = new HotelEntryCreationPage(driver);
		
	}
	
	@Given("^I am  on the hotel manangement platform$")
	public void i_am_on_the_hotel_manangement_platform() throws Throwable {
		hotelEntryCreationPage.goToHomePage();
	    
	}

	@When("^I authenticate the page with user id and password$")
	public void i_authenticate_the_page_with_user_id_and_password() throws Throwable {
		hotelEntryCreationPage.selectLogin();
		hotelEntryCreationPage.enteruserName("admin");
		hotelEntryCreationPage.enterPasssword("password");
		
	}

	@When("^I create an entry with Hotelname, address, owner, phoneno and emailadress$")
	public void i_create_an_entry_with_Hotelname_address_owner_phoneno_and_emailadress() throws Throwable {
		hotelEntryCreationPage.enteruserName("name"+Utils.getRandomNumeric(3));
		hotelEntryCreationPage.enterAddress(Utils.getRandomNumeric(4)+"HighStreet");
		hotelEntryCreationPage.enterPhoneNo("0"+Utils.getRandomNumeric(10));
		hotelEntryCreationPage.enterEmail(Utils.getRandomNumeric(10)+"@test.com");
		hotelEntryCreationPage.selectCreate();
	}

	@Then("^the entry should be created sucessfully$")
	public void the_entry_should_be_created_sucessfully() throws Throwable {
		assertTrue(hotelEntryCreationPage.noOfRows()>0);
	}

	@When("^I delete the created entry$")
	public void i_delete_the_created_entry() throws Throwable {
		for(int i=0;i<=hotelEntryCreationPage.noOfRows();i++){
			hotelEntryCreationPage.selectRemove();	
		}
		
	}

	@Then("^the entry should be deleted successfully$")
	public void the_entry_should_be_deleted_successfully() throws Throwable {
		assertTrue(!(hotelEntryCreationPage.noOfRows()>0));
	}

	@When("^I create more than one entry with Hotelname, address, owner, phoneno and emailadress$")
	public void i_createmore_than_one_entry_with_Hotelname_address_owner_phoneno_and_emailadress() throws Throwable {
	   for(int i =0; i<=5;i++){
		   i_create_an_entry_with_Hotelname_address_owner_phoneno_and_emailadress();
	   }
	}

	@Then("^all the entries should be created successfully$")
	public void all_the_entries_should_be_created_successfully() throws Throwable {
		assertTrue(hotelEntryCreationPage.noOfRows()>4);
	}



	
}
	


