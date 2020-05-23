Feature: Customers

@Sanity
Scenario: Add new Customer
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
	Then User can view Dashboard
	When User click on customers Menu
	And click on customers Menu Item
	And Enter Customer EMail
	When Click on Search button
	Then User should found Email in the Search table
	And close browser

@Regression	
Scenario: Search Customer by Name
	Then User can view Dashboard
	When User click on customers Menu
	And click on customers Menu Item
	And Enter Customer First Name
	And Enter Customer Last Name
	When Click on Search button
	Then User should found Name in the Search table
	And close browser
	