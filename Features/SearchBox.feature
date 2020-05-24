Feature: SearchBox

@Sanity
Scenario: Serach Box
	Given User Launch Chrome browser
	When User opens URL "https://www.walmart.com/"
	And Enter Text in SearchBox
	And close browser

@Sanity
Scenario: Enter text with single character
	Given User Launch Chrome browser
	When User opens URL "https://www.walmart.com/"
	And Enter Text with single character in SearchBox
	Then Get result on suggestion text
	And close browser

@Sanity
Scenario: Select Categories and Enter text with space
	Given User Launch Chrome browser
	When User opens URL "https://www.walmart.com/"
	And Selecty Categories
	And Enter text with Space in searchbox
	Then Get result on suggestion text
	And close browser
	
@Sanity
Scenario: I Want to verify Menu Bar
	Given User Launch Chrome browser
	When User opens URL "https://www.walmart.com/"
	And Click on Hamburg Menu
	And Verify links
	And close browser

@Sanity	
Scenario: I want ti verify link in Account
	Given User Launch Chrome browser
	When User opens URL "https://www.walmart.com/"
	And Click on Account icon
	And Get links and verify
	And close browser
	
@Regression	
Scenario: I want to verify price in between
	Given User Launch Chrome browser
	When User opens URL "https://www.walmart.com/"
	And Enter Text in SearchBox
	And Select in between min to max
	And close browser
	

	