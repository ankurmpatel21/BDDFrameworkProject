package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pageObjects.LoginPage;

public class Hooks extends BaseClass
{

	 	@Before(order=0)
	    public void beforeScenario() throws IOException
	 	{
		//Logging
			logger = Logger.getLogger("BDDFrameworkProject");
			PropertyConfigurator.configure("Log4j.properties");
			logger.setLevel(Level.DEBUG);
		 	configProp = new Properties();
			FileInputStream configPropfile = new FileInputStream("config.properties");
			configProp.load(configPropfile);			
			String br = configProp.getProperty("browser"); //Getting Browser Name from Config.properties file
			
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
			//driver.get("http://admin-demo.nopcommerce.com/login");
			//lp = new LoginPage(driver);
			//lp.SetUserName("admin@yourstore.com");
			//lp.setPassword("admin");
			//lp.clickLogin();
			
		 
		 
	        System.out.println("This will run before the Scenario");
	    } 
	 
	 	@Before(order=1)
	    public void beforeFirstScenario(){
	        System.out.println("This will run before First the Scenario");
	    } 
	 
	 	@After
	    public void afterScenario(){
	        System.out.println("This will run after the Scenario");
	    }
	
	 	@After("@first")
	    public void afterFirstScenario(){
	        System.out.println("This will run after First the Scenario");
	    } 
}
