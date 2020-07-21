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
	
@Sanity	
Scenario: I want to verify price in between
	Given User Launch Chrome browser
	When User opens URL "https://www.walmart.com/"
	And Enter Text in SearchBox
	And Select in between min to max
	And close browser
	
@Sanity	
Scenario: I want to verify sortBy
	Given User Launch Chrome browser
	When User opens URL "https://www.walmart.com/"
	And Enter Text in SearchBox
	And Verify low to high price
	And close browser

@Sanity	
Scenario: I want to verify List of Color
	Given User Launch Chrome browser
	When User opens URL "https://www.walmart.com/"
	And Enter Text in SearchBox
	And Verify list of color
	And close browser
	
@Sanity	
Scenario: Verify price an name in Addtocart
	Given User Launch Chrome browser
	When User opens URL "https://www.walmart.com/"
	And Enter Text in SearchBox
	And Select Item and Add to Cart
	Then Verify Price and Name
	And close browser
	
@Sanity
Scenario: Verify price after Quantity increases
	Given User Launch Chrome browser
	When User opens URL "https://www.walmart.com/"
	And Enter Text in SearchBox
	And Select Item and Add to Cart
	And Verify view cart
	And close browser

@Sanity	
Scenario: Take ScreenShot and verify carasoul
	Given User Launch Chrome browser
	When User opens URL "https://www.walmart.com/"
	And Take ScreenShot and verify
	And close browser

@Sanity	
Scenario: Verify all photos of Item
	Given User Launch Chrome browser
	When User opens URL "https://www.walmart.com/"
	And Enter Text in SearchBox
	And Select Item and Add to Cart
	And check all photos
	And close browser

@Regression	
Scenario: Verify swipe right to left
	Given User Launch Chrome browser
	When User opens URL "https://www.walmart.com/"
	And Enter Text in SearchBox
	And verify swipe button and get screenshot
	And close browser

	