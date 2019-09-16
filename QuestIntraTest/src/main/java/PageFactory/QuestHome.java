package PageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class QuestHome {
	
	WebDriver driver;    
	
	@FindBy(how=How.XPATH, using="//a[@href=\"/intranet/My-Intranet/Applications.aspx\"]") WebElement viewAll;
	
	public QuestHome(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public void viewAllBtn()
	{
		
		viewAll.click();
		System.out.println("ViewAll Home Page Btn clicked successfully!");
		
		
		
	}

}
