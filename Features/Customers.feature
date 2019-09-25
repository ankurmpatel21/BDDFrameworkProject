Feature: Customers

@Sanity
Scenario: Add new Customer
	Given User Launch Chrome browser
	When User opens URL "http://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then User can view Dashboard
	When User click on customers Menu
	And click on customers Menu Item
	And click on Add new button
	Then User can view Add new customer page
	When user enter customer info
	And click on Save button
	Then User can View confirmation message "The new customer has been added successfully."
	And close browser

@Regression
Scenario: Search Customer by EmailID
	Given User Launch Chrome browser
	When User opens URL "http://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then User can view Dashboard
	When User click on customers Menu
	And click on customers Menu Item
	And Enter Customer EMail
	When Click on Search button
	Then User should found Email in the Search table
	And close browser

@Regression	
Scenario: Search Customer by Name
	Given User Launch Chrome browser
	When User opens URL "http://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then User can view Dashboard
	When User click on customers Menu
	And click on customers Menu Item
	And Enter Customer First Name
	And Enter Customer Last Name
	When Click on Search button
	Then User should found Name in the Search table
	And close browser
	