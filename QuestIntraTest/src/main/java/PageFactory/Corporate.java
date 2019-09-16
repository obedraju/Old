package PageFactory;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import PageTests.BasePage;

public class Corporate 
{
	WebDriver driver;
	
	
	
	
	
@FindBy(how=How.XPATH, using="//*[@id=\"AA\"]/a") WebElement CorporateBtn;
@FindBy(how=How.XPATH, using="//*[@id=\"AB\"]/b") WebElement DeliveryLocBtn;



@FindBy(how=How.XPATH, using="//*[@id=\"ABA\"]/a") WebElement IndiaBtn;

@FindBy(how=How.XPATH, using="//a[@href=\"/intranet/OBU/India/News.aspx\"]") WebElement viewAll2;


@FindBy(how=How.XPATH, using="//a[@href=\"/intranet/OBU/India/News.aspx?page=2\"]") WebElement nextBtn;


@FindBy(how=How.XPATH, using="//li//a[@href=\"/intranet/QuEST-Global-Net.aspx\"]") WebElement Home;
@FindBy(how=How.XPATH, using="//a[@href=\"/intranet/My-Intranet/Applications.aspx\"]") WebElement viewAll;



	
	public Corporate(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public void Clickable()
	
	{
		
	CorporateBtn.click();
	DeliveryLocBtn.click(); 
	IndiaBtn.click();
	
	
	viewAll2.click();
	
	nextBtn.click();
	
	Home.click();
	
	viewAll.click();
	
	
System.out.println("Execution is successfull");
		
		
	
	}
	

	}

	
	


  
