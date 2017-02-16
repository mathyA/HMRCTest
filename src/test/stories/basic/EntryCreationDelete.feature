Feature: Create and delete an entry 

#Create an entry
Scenario: User should be able to login and create an entry 
	Given I am  on the hotel manangement platform 
	When I authenticate the page with user id and password 
	When I create an entry with Hotelname, address, owner, phoneno and emailadress 
	Then the entry should be created sucessfully 
	
	#Delete an entry	
Scenario: User should be able to delete the created entry 
	Given I am  on the hotel manangement platform 
	When I authenticate the page with user id and password 
	When I create an entry with Hotelname, address, owner, phoneno and emailadress 
	Then the entry should be created sucessfully 
	When I delete the created entry 
	Then the entry should be deleted successfully 
	
	#Create multiple entries
Scenario: User should be able to delete the created entry 
	Given I am  on the hotel manangement platform 
	When I authenticate the page with user id and password 
	When I create more than one entry with Hotelname, address, owner, phoneno and emailadress 
	Then all the entries should be created successfully 
