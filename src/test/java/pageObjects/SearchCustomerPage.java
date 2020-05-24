package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage 
{
	WebDriver ldriver;
	public SearchCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
		
		@FindBy(how = How.ID, using = "SearchEmail")
		@CacheLookup
		WebElement txtEmail;
		
		//By txtsearchEmail = By.xpath("//input[@id='SearchEmail']");
		
//		By searchbtn = By.xpath("//button[@id='search-customers']");
		
		@FindBy(how = How.ID, using = "SearchFirstName")
		@CacheLookup
		WebElement txtFname;
		
		By txtfname = By.xpath("//*[@id=\"SearchFirstName\"]");
		
		@FindBy(how = How.ID, using = "SearchLastName")
		@CacheLookup
		WebElement txtLname;
		
		By txtlname = By.xpath("//*[@id=\"SearchLastName\"]");
		
		@FindBy(how = How.ID, using = "search-customers")
		@CacheLookup
		WebElement btnSearch;
		
		@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
		WebElement table;

		@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
		List<WebElement> tableRows;

		@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
		List<WebElement> tableColumns;
			
		
		public void setEmail(String email)
		{
			txtEmail.clear();
			txtEmail.sendKeys(email);
			//ldriver.findElement(txtsearchEmail).sendKeys(email);
		}
		
		public void setFname(String fname)
		{
			//txtFname.clear();
			txtFname.sendKeys(fname);
			//ldriver.findElement(txtfname).sendKeys(fname);
		}
		
		public void setLname(String lname)
		{
			//txtFname.clear();
			txtLname.sendKeys(lname);
			//ldriver.findElement(txtlname).sendKeys(lname);
		}
		
		public void clickonSearch()
		{
			btnSearch.click();
			//ldriver.findElement(searchbtn).click();
		}
		
		public int getNoOfRows() 
		{
			return (tableRows.size());
		}

		public int getNoOfColumns() 
		{
			return (tableColumns.size());
		}
		
		public boolean searchCustomerByEmail(String email) {
			boolean flag = false;

			for (int i = 1; i <= getNoOfRows(); i++) {
				
				String emailid = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]"))
						.getText();				
				System.out.println(emailid);

				if (emailid.equals(email)) {
					flag = true;
					break;
				}
			}

			return flag;

		}
		
		public boolean searchCustomerByName(String name)
		{
			boolean flag = false;
			for(int i = 1; i<=getNoOfRows(); i++)
			{
				String cname = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
				System.out.println(cname);
				if(cname.equals(name))
				{
					flag = true;
					break;
				}
			}
			
			return flag;
		}

}
