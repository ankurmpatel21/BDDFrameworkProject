package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchBoxLocators;
import pageObjects.SearchCustomerPage;

public class BaseClass 
{
	public static WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCust;
	public SearchCustomerPage searchCust;
	public static Logger logger; 
	public Properties configProp;
	public SearchBoxLocators sb;
	
	public static String randomestring()
	{
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		System.out.println(generatedString1);
		return generatedString1;
	}
}
