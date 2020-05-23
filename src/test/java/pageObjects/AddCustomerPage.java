package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage 
{
public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);

	}
	
	
	By lnkCustomer_menu = By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/a/span");
	By lnkCustomer_menuitem = By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/ul/li[1]/a/span");
	
	By btnAddnew = By.xpath("//a[@class='btn bg-blue']");
	
	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");
	By txtfname = By.xpath("//input[@id='FirstName']");
	By txtlname = By.xpath("//input[@id='LastName']");
	By rdbtnmale = By.xpath("//input[@id='Gender_Male']");
	By rdbtnfemale = By.xpath("//input[@id='Gender_Female']");
	By txtDob=By.xpath("//input[@id='DateOfBirth']");
	By txtcmpnname = By.xpath("//input[@id='Company']");
	By chkboxexmpt = By.xpath("//input[@id='IsTaxExempt']");
	By chkboxyrname = By.xpath("//body[@class='skin-blue sidebar-mini']/div[@class='wrapper']/div[@class='content-wrapper']/div/form/div[@class='content']/div[@class='form-horizontal']/nop-panels[@id='customer-panels']/nop-panel/div[@id='customer-info']/div[@class='panel-container']/div[@class='panel-body']/div[@class='form-group']/div[@class='col-md-9']/div[1]/label[1]/input[1]");
	By chkboxtstore = By.xpath("//body[@class='skin-blue sidebar-mini']/div[@class='wrapper']/div[@class='content-wrapper']/div/form/div[@class='content']/div[@class='form-horizontal']/nop-panels[@id='customer-panels']/nop-panel/div[@id='customer-info']/div[@class='panel-container']/div[@class='panel-body']/div[@class='form-group']/div[@class='col-md-9']/div[2]/label[1]/input[1]");
	By customerrole = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	By listadminstrators = By.xpath("//li[contains(text(),'Administrators')]");
	By listguest = By.xpath("//li[contains(text(),'Guests')]");
	By listresgister = By.xpath("//li[contains(text(),'Registered')]");
	By listvendors =By.xpath("//li[contains(text(),'Vendors')]");
	By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
	By drpmgrOfVendor=By.xpath("//*[@id='VendorId']");
	By active = By.xpath("//input[@id='Active']");
	By admincomment = By.xpath("//textarea[@id='AdminComment']");
	
	By btnsave = By.xpath("//button[@name='save']");
	
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}
	
	public void clickOnCustomersMenu() 
	{
		ldriver.findElement(lnkCustomer_menu).click();
	}
	
	public void clickOnCustomers()
	{
		ldriver.findElement(lnkCustomer_menuitem).click();
	}
	
	public void clickOnAddnew()
	{
		ldriver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		ldriver.findElement(txtPassword).sendKeys(pwd);
	}
	
	public void setFname(String fname)
	{
		ldriver.findElement(txtfname).sendKeys(fname);
	}
	
	public void setLname(String lname)
	{
		ldriver.findElement(txtlname).sendKeys(lname);
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdbtnmale).click();
		}
		else if(gender.equals("Female"))
		{
			ldriver.findElement(rdbtnfemale).click();
		}
		else
		{
			ldriver.findElement(rdbtnmale).click();//Default
		}
	}
	
	public void setDob(String dob)
	{
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	
	public void setCompanyName(String comname)
	{
		ldriver.findElement(txtcmpnname).sendKeys(comname);
	}

	public void clickTax()
	{
		ldriver.findElement(chkboxexmpt).click();
	}
	
	public void clicknewsletter()
	{
		ldriver.findElement(chkboxyrname).click();
		ldriver.findElement(chkboxtstore).click();
	}
	
	
	public void setCustomerRole(String role) throws InterruptedException
	{
		
		
		if(!role.equals("Vendors")) //If role is vendors should not delete Register as per req.
		{
		ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
		}
		ldriver.findElement(customerrole).click();
					
		WebElement listitem;
		
		Thread.sleep(3000);
					
		if(role.equals("Administrators"))
		{
			listitem=ldriver.findElement(listadminstrators); 
		}
		else if(role.equals("Guests"))
		{
			listitem=ldriver.findElement(listguest);
		}
		else if(role.equals("Registered"))
		{
			listitem=ldriver.findElement(listresgister);
		}
		else if(role.equals("Vendors"))
		{
			listitem=ldriver.findElement(listvendors);
		}
		else
		{
			listitem=ldriver.findElement(listguest);
		}
					
		//listitem.click();
		//Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listitem);
		

	}
	
	public void setManagerOfVendor(String value)
	{
		Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
	}

	public void clickactive()
	{
		ldriver.findElement(active).click();
	}
	
	public void setAdminComment(String adcomment)
	{
		ldriver.findElement(admincomment).sendKeys(adcomment);
	}
	
	public void clickSave()
	{
		ldriver.findElement(btnsave).click();
	}

}
