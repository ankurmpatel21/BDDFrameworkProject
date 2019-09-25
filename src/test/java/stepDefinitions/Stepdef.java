package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.Before;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Stepdef extends BaseClass
{
	@Before
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
		
	}
	
	
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

}
