package pageObjects;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SearchBoxLocators 
{
	WebDriver ldriver;
	
	public SearchBoxLocators(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//input[@id='global-search-input']")
	@CacheLookup
	WebElement txtsearchBox;
	
	
	@FindBy(xpath="//button[@id='global-search-dropdown-toggle']//img")
	@CacheLookup
	WebElement ddbox;
	
	@FindBy(xpath="//div[@id='searchDropdown-list']//div[1]//button[8]")
	@CacheLookup
	WebElement catbutton;
	
	//@FindBy(xpath="//button[@aria-label='Menu']//img")
	@FindBy(xpath="//button[@type='button' and @aria-label = 'Menu']")
	//@CacheLookup
	WebElement menubar;
	
	By tracOrdLink = By.xpath("//a[@data-uid='LHN-0-OTL']//div[text()='Track Orders']");
	
	By reOrdLink = By.xpath("//a[@data-uid='LHN-1-OTL']//div[text()='Reorder Items']");
	
	By listLink = By.xpath("//a[@data-uid='LHN-2-OTL']//div[text()='Lists']");
	
	By walmartCCLink = By.xpath("//a[@data-uid='LHN-3-OTL']//div[text()='Walmart Credit Card']");
	
	By accountBtn = By.xpath("//button[@id='header-account-toggle']//span[contains(text(),'Account')]");
	
	By searchBtn = By.xpath("//button[@type='submit' and @id='global-search-submit']");
	
	By priceFilter = By.xpath("//button[contains(text(),Price)]//parent::div[@class='flowtip-flyout utilbar-store-flyout flowtip-flyout-animate']");
	
	By refindBy = By.xpath("//div[@class='desktop-bar-left-filter-wrapper']//child::p");
	
	By minPrice = By.xpath("//div[@class='flowtip-flyout-modal flowtip-flyout-modal-bottom']//input[@placeholder='Min']");
	
	By maxPrice = By.xpath("//div[@class='flowtip-flyout-modal flowtip-flyout-modal-bottom']//input[@placeholder='Max']");
	
	By go = By.xpath("//div[@class='flowtip-flyout-modal flowtip-flyout-modal-bottom']//span[@class='button-wrapper'][contains(text(),'Go')]");
	
	By filterStrip = By.xpath("//button[contains(text(),Price)]//parent::div[@class='flowtip-flyout utilbar-store-flyout flowtip-flyout-animate']");
	
	public void clickOnGo()
	{
		ldriver.findElement(go).click();
	}
	public void setMaxPrice(String max)
	{
		ldriver.findElement(maxPrice).sendKeys(max);
	}
	public void setMinPrice(String min)
	{
		ldriver.findElement(minPrice).sendKeys(min);
	}
	public void enterText(String txt)
	{
		txtsearchBox.clear();
		txtsearchBox.sendKeys(txt);
	}
	
	public void enterText2(String txt) throws InterruptedException
	{
		txtsearchBox.clear();
		for(int i=0; i < txt.length();i++)
		{
			txtsearchBox.sendKeys(Character.toString(txt.charAt(i)));
			//driver.findElement(By.xpath("//input[@id='global-search-input']")).sendKeys(Character.toString(str.charAt(i)));
			Thread.sleep(200);
		}
	}
	public WebElement getElement(By locator)
	{
		return ldriver.findElement(locator);
	}
	
	public boolean scrollByRefindBy() 
	{
		try {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		//WebElement refindBy = driver.findElement(By.xpath("//button[contains(text(),Price)]//parent::div[@class='flowtip-flyout utilbar-store-flyout flowtip-flyout-animate']"));
		
		js.executeScript("arguments[0].scrollIntoView(false);",getElement(filterStrip));
		Thread.sleep(3000);
	    ((JavascriptExecutor) ldriver).executeScript("window.scrollBy(0,-50)","");
	    Thread.sleep(3000);
	    return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
		
	}
	public void clickSearchButton()
	{
		ldriver.findElement(searchBtn).click();
	}
	
	public void clickDDSearchBox()
	{
		ddbox.click();
	}
	
	public void clickCategory()
	{
		catbutton.click();
	}
	
	public void clickOnMenuBar() 
	{
		menubar.click();
	}
	
	public void clickMenuLink() throws InterruptedException
	{
		Thread.sleep(2000);
		ldriver.findElement(tracOrdLink).click();
		String trackURL = ldriver.getCurrentUrl();
		Assert.assertTrue(trackURL.contains("trackorder"));
		ldriver.navigate().back();
		ldriver.navigate().refresh();
		menubar.click();
		Thread.sleep(5000);
		ldriver.findElement(reOrdLink).click();
		String reOrdURL = ldriver.getCurrentUrl();
		Assert.assertTrue(reOrdURL.contains("https://www.walmart.com/easyreorder?eroType=list"));
		ldriver.navigate().back();
		ldriver.navigate().refresh();
		//System.out.println(reOrdURL);
		menubar.click();
		Thread.sleep(5000);
		ldriver.findElement(listLink).click();
		String listsURL = ldriver.getCurrentUrl();
		Assert.assertTrue(listsURL.contains("https://www.walmart.com/lists/loggedOut"));
		ldriver.navigate().back();
		ldriver.navigate().refresh();
		//System.out.println(listsURL);
		menubar.click();
		Thread.sleep(5000);
		ldriver.findElement(walmartCCLink).click();
		String walCCURL = ldriver.getCurrentUrl();
		Assert.assertTrue(walCCURL.contains("https://www.walmart.com/cp/walmart-credit-card/632402"));
		ldriver.navigate().back();
		ldriver.navigate().refresh();
		System.out.println(walCCURL);
		
	}
	
	public void clickAccount()
	{
		ldriver.findElement(accountBtn).click();
	}
	
	public void clickOnPrice()
	{
		ldriver.findElement(priceFilter).click();
	}
}
