package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchBoxLocators;
import pageObjects.SearchCustomerPage;

public class Stepdef extends BaseClass
{
	public WebDriver driver  = BaseClass.driver;
	/*@Before
	public void setup() throws IOException
	{
		//Logging
		logger = Logger.getLogger("BDDFrameworkProject");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
		
		//Load Proerties File
		configProp = new Properties();
		FileInputStream configPropfile = new FileInputStream("config.properties");
		configProp.load(configPropfile);
		
		String br = configProp.getProperty("browser"); //Getting Browser Name from Config.properties file
		
		//Launching Browser
		
		if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}
		else if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}
		
	}*/
	
	
	//Login Steps.....
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser()
	{
		logger.info("*************** Launching Browser ***************");
		lp = new LoginPage(driver);
		
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) 
	{
		logger.info("*************** Opening ULR ***************");
		driver.get(url);
		driver.manage().window().maximize();	
	}
	
	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) 
	{
		logger.info("*************** Provide Username and Password ***************");
		lp.SetUserName(email);
	 	lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_Login() 
	{
		logger.info("*************** Click on Login ***************");
		lp.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String exptitle) throws InterruptedException 
	{
		if(driver.getPageSource().contains("Login was unsuccessful"))
		{
			logger.info("*************** Login Failed ***************");
			driver.close();
			Assert.assertTrue(false);
		}
		else
		{
			logger.info("*************** Login Passed ***************");
			Assert.assertEquals(exptitle, driver.getTitle());
		}
		Thread.sleep(3000);
	}

	@When("User click on Log out link")
	public void user_click_on_Log_out_link() throws InterruptedException 
	{
		logger.info("*************** Clicking Log Out ***************");
		lp.clickLogout();
	    Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() 
	{
		logger.info("*************** Closing Browser ***************");
		driver.quit();
	}

	//Customer Features Step Definition File..........
	
	
	@Then("User can view Dashboard")
	public void user_can_view_Dashboard()
	{
		addCust = new AddCustomerPage(driver);
		logger.info("*************** Verify Dashboard Page ***************");
		Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
	}
	
	@When("User click on customers Menu")
	public void user_click_on_customers_Menu() throws InterruptedException
	{
		Thread.sleep(3000);
		logger.info("*************** Clicking on Main Menu ***************");
		addCust.clickOnCustomersMenu();
	
	}
	
	@When("click on customers Menu Item")
	public void click_on_customers_Menu_Item() throws InterruptedException 
	{
		Thread.sleep(3000);
		logger.info("*************** Clicking on Sub Menu ***************");
		addCust.clickOnCustomers();
	
	}
	
	@When("click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException
	{
		Thread.sleep(3000);
		
		addCust.clickOnAddnew();
	
	}
	
	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() throws InterruptedException 
	{
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}
	
	@When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException 
	{
		String email = randomestring() +"@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		addCust.setFname("Akshay");
		addCust.setLname("Patel");
		addCust.setGender("Male");
		addCust.setDob("7/05/1980");
		addCust.setCompanyName("Infosys Limited");
		addCust.clickTax();
		addCust.clicknewsletter();
		addCust.setCustomerRole("Guest");
		addCust.setManagerOfVendor("Vendor 1");
		addCust.clickactive();
		addCust.setAdminComment("This is for Testing");
		
	}
	
	@When("click on Save button")
	public void click_on_Save_button() throws InterruptedException 
	{
		logger.info("*************** Saving Customer Deatils ***************");
		addCust.clickSave();
		Thread.sleep(3000);
	}
	
	@Then("User can View confirmation message {string}")
	public void user_can_View_confirmation_message(String string) 
	{
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully."));
	}
	
	//Search by Email.......
	
	@When("Enter Customer EMail")
	public void enter_Customer_EMail() throws InterruptedException
	{
		Thread.sleep(5000);
		searchCust=new SearchCustomerPage(driver);
		logger.info("*************** Searching Customer Deatail By Email ***************");
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on Search button")
	public void click_on_Search_button() throws InterruptedException
	{
		searchCust.clickonSearch();
		Thread.sleep(3000);
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_Email_in_the_Search_table() 
	{
		boolean status=searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}
	
	//Search By Name....
	@When("Enter Customer First Name")
	public void enter_Customer_First_Name() throws InterruptedException
	{
		Thread.sleep(3000);
		searchCust=new SearchCustomerPage(driver);
		logger.info("*************** Searching Customer Deatail By Name ***************");
		searchCust.setFname("Victoria");
	}

	@When("Enter Customer Last Name")
	public void enter_Customer_Last_Name() throws InterruptedException 
	{
		Thread.sleep(3000);
		searchCust.setLname("Terces");
	}
	
	@Then("User should found Name in the Search table")
	public void user_should_found_Name_in_the_Search_table() 
	{
		boolean status = searchCust.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);
	}
	
	@And("^User enters Email and Password New$")
	public void user_enters_testuser__and_Test(DataTable usercredentials) throws Throwable {
	 
		//Write the code to handle Data Table
		 List<Map<String,String>> data = usercredentials.asMaps(String.class,String.class);
		 System.out.println(data.get(0).get("Username"));
		 System.out.println(data.get(1).get("Username"));
			
	 }
	
	@When("Enter Text in SearchBox")
	public void enter_Text_in_SearchBox() throws InterruptedException 
	{
		sb = new SearchBoxLocators(driver);
		
		sb.enterText("Mobile");
		Thread.sleep(3000);
		sb.clickSearchButton();
		//sb.clickSearchButton();
		/*
		 * String title = driver.getTitle(); System.out.println(title);
		 * Assert.assertTrue(title.contains("Mobile"));
		 */
	}
	
	@When("Enter Text with single character in SearchBox")
	public void enter_Text_with_single_character_in_SearchBox() throws InterruptedException 
	{
		sb = new SearchBoxLocators(driver);
		sb.enterText2("Mobile");
		
	}
	
	@Then("Get result on suggestion text")
	public void get_result_on_suggestion_text() throws InterruptedException
	{
		Thread.sleep(5000);
	  //List<WebElement> list = driver.findElements(By.className("typeahead-text"));
	  List<WebElement> list = driver.findElements(By.xpath("//li[@class='typeahead-row']//child::div[@class='typeahead-text']"));
	 // SoftAssert softAssert = new SoftAssert();
	  for(WebElement suggest : list)
	  {
		  Assert.assertTrue(suggest.getText().contains("1"));
		  System.out.println(suggest.getText());
		  
	  }
	  //softAssert.assertAll();
	  
	}
	
	@When("Selecty Categories")
	public void selecty_Categories()
	{
		sb = new SearchBoxLocators(driver);
		sb.clickDDSearchBox();
		sb.clickCategory();
	}
	
	@When("Enter text with Space in searchbox")
	public void enter_text_with_space_in_searchbox() 
	{
		
		StringBuilder text = new StringBuilder()
				.append("Mobile")
				.append(" ")
				.append("Phones");
		
		driver.findElement(By.xpath("//input[@id='global-search-input']")).sendKeys(text);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
	}
	
	@When("Click on Hamburg Menu")
	public void click_on_Hamburg_Menu() 
	{
		sb = new SearchBoxLocators(driver);
		sb.clickOnMenuBar();
	}

	@When("Verify links")
	public void verify_links() throws InterruptedException 
	{
		sb = new SearchBoxLocators(driver);
		sb.clickMenuLink();
	}
	
	@When("Click on Account icon")
	public void click_on_Account_icon() throws InterruptedException, IOException 
	{
		sb = new SearchBoxLocators(driver);
		sb.clickAccount();
		
	 
	}

	@When("Get links and verify")
	public void get_links_and_verify() throws InterruptedException 
	{
		Thread.sleep(5000);
		List<WebElement> getlink = driver.findElements(By.xpath("//div[@data-tl-id='header-account-links']//child::a"));
		
		XLUtils reader = new XLUtils("./TestData/TestData.xlsx");
		String sheetname = "sheet1";
		int i=0;
		for(WebElement printlink : getlink)
		  {
				i++;
				String data = reader.getCellData(sheetname, 0, i);
				String livedata = printlink.getText();
				
				System.out.println(printlink.getText());
				System.out.println(data);
				Assert.assertEquals(data, livedata);
		  }	
	}
	
	@When("Select in between min to max")
	public void select_in_between_min_to_max() throws InterruptedException
	{
		sb = new SearchBoxLocators(driver);
		Thread.sleep(3000);
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver; //WebElement refindBy =
		 * driver.findElement(By.
		 * xpath("//button[contains(text(),Price)]//parent::div[@class='flowtip-flyout utilbar-store-flyout flowtip-flyout-animate']"
		 * ));
		 * 
		 * js.executeScript("arguments[0].scrollIntoView(false);",refindBy);
		 * Thread.sleep(3000); ((JavascriptExecutor)
		 * driver).executeScript("window.scrollBy(0,-50)",""); Thread.sleep(3000);
		 */
		if(sb.scrollByRefindBy())
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
		sb.clickOnPrice();
		Thread.sleep(3000);
		sb.setMinPrice("50");
		sb.setMaxPrice("120");
		Thread.sleep(3000);
		sb.clickOnGo();
		Thread.sleep(60000);
	}

	


}
