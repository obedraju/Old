package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import PageTests.BasePage;

public class EmpProfile {
	
	WebDriver driver;
	
	public EmpProfile(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//@FindBy(how=How.XPATH, using="") WebElement emailId;
	
	@FindBy(how=How.XPATH, using="//div[contains(text(),\"Employee ID\")]/parent::li/div[2]") WebElement empID;
	
	
	public void printDetails() throws InterruptedException
	{
		{
			String text1 = empID.getText();
			System.out.println("The EMP ID is: " +text1);
			driver.navigate().back();
		}
		
	
		
	}
	
	

}
