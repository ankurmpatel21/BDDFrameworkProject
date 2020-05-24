package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver ldriver;
	
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtemail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtpwd;
	
	@FindBy(xpath="//input[@class='button-1 login-button']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement btnLogout;
	
	public void SetUserName(String uname)
	{
		txtemail.clear();
		txtemail.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtpwd.clear();
		txtpwd.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		btnLogout.click();
	}
}
