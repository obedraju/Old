package PageTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Utility.PropertyFile;


//import Reports.EReport;


public class BasePage   {
	
	PropertyFile pf=new PropertyFile();
	
	WebDriver driver = null;
	String browser=null;
	
	public void loadPFile() throws Exception {
		
		browser=pf.LoadProperty("browser");
	
	
	}
	
		@BeforeSuite
		public void startUp() throws Exception
		{
			loadPFile();
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("head"))
		{
			//add HTML Unit Driver
		}
		
		
		//To maximize browser
        driver.manage().window().maximize();
		 //Implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 	//To open QuestIntranet
        driver.get("https://intranet.quest-global.com/intranet/Logon.aspx");
        
	}
	
	
		
	@AfterSuite
	public void cleanUp() throws InterruptedException
	{
		//Thread.sleep(3000);
		driver.quit();
		
	}
	
}
