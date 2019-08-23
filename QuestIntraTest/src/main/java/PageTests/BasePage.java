package PageTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Utility.PropertyFile;

public class BasePage {

	WebDriver driver = null;
	
	@BeforeSuite
	void startUp()
	{
		driver=new ChromeDriver();
		//To maximize browser
        driver.manage().window().maximize();
		 //Implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 	//To open QuestIntranet
        driver.get("https://intranet.quest-global.com/intranet/Logon.aspx");
        
	}
	
	
		
	@AfterSuite
	void cleanUp() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
		
	}
	
}
