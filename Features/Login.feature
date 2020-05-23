Feature: Login

Background: User is Logged In
Given User Launch Chrome browser
	Given User Launch Chrome browser
	When User opens URL "http://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	


@Sanity @Regression @first
Scenario: Login Data Driven1
	And close browser
	
	@Sanity  @Regression @second
Scenario: Successful Login with Valid Credential
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on Log out link
	Then Page Title should be "Your store. Login"
	And close browser
	
@Regression	
Scenario Outline: Login Data Driven
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on Log out link
	Then Page Title should be "Your store. Login"
	And close browser
	Examples:
		|	email	|	password	|
		|	admin@yourstore.com	|	admin	|
		|	admin1@yourstore.com	|	admin123	|
	
	
