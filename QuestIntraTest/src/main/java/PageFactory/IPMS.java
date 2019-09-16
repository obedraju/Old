package PageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IPMS {
	WebDriver driver;
	
	
	@FindBy(how=How.XPATH, using="//a[@href='/intranet/Functions/PMO/IPMS-V10-Home.aspx']") WebElement ipmslink;
	//@FindBy(how=How.XPATH, using="//div[@class=\"FormBox\"]//a[@href=\"https://ipms.quest-global.com/\"]") WebElement impsloginlink;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"form\"]/div[6]/div/div[1]/span/a") WebElement impsloginlink;
	
	@FindBy(how=How.XPATH, using="//input[@id='login']")WebElement id;
	@FindBy(how=How.XPATH, using="//input[@id='password']")WebElement password;
	@FindBy(how=How.XPATH, using="//button[@type='submit']")WebElement loginBTN;
	
	
	
	public void ipmsClick()
	{
		ipmslink.click();
	}
	
	
	public void impsLoginLink() throws InterruptedException
	{
		Thread.sleep(3000);
		//Actions act = new Actions(driver);
		//act.moveToElement(impsloginlink).click().perform();
		//JavascriptExecutor js = (JavascriptExecutor)driver;	
		//js.executeScript("document.getElementsByTagName() ");
	impsloginlink.click();
		
	}
	
	public void ipmsLoginCredentials() throws InterruptedException
	{
		id.sendKeys("g.obedraju");
		password.sendKeys("Quest@100");
		loginBTN.click();
		Thread.sleep(2000);
		driver.get("https://intranet.quest-global.com/intranet/My-Intranet/Applications.aspx");
	}
	
	public IPMS(WebDriver driver)
	{
		this.driver=driver;
	}
}
