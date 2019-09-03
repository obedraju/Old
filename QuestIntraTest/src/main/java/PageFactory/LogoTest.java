package PageFactory;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogoTest {
	
	WebDriver driver;
	
	public LogoTest(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	@FindBy(how=How.XPATH, using="//a[@class=\"brand\"]") WebElement QuestHomePagelogo;
		
	public void windowTest() throws InterruptedException
	{
		System.out.println("Logo clicked successfully!");
		Thread.sleep(1000);
		QuestHomePagelogo.click();
		String homeHandle=driver.getWindowHandle();
		
		Set<String> allHandles=driver.getWindowHandles();
		
		
		for(String handle:allHandles)
		
		{
			driver.switchTo().window(handle);
			Thread.sleep(1000);
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			System.out.println();
			
			
		}		
		
		
		driver.switchTo().window(homeHandle);
		
		
		
	}

}
