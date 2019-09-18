package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;


import Utility.PropertyFile;

public class QuestIntraHomeLogin {
	
	WebDriver driver; //Declaring the driver
	
	static String LoginUser;
	static String LoginPassword;
	
	PropertyFile pf=new PropertyFile();
	
	   void LoadingPropertyFile() throws Exception
	{
		LoginUser=pf.LoadProperty("LoginUser");
		LoginPassword=pf.LoadProperty("LoginPassword");
		
	}
	
	//Using @FindBy declaring the elements of the page for Login
	
	@FindBy(how=How.XPATH, using= "//input[@id=\"p_lt_zoneLeft_Quest_LoginAD1_txtUserName\"]") WebElement username;
	@FindBy(how=How.XPATH, using= "//input[@id=\"p_lt_zoneLeft_Quest_LoginAD1_txtPassword\"]") WebElement password;
	@FindBy(how=How.XPATH, using= "//input[@value='Login']") WebElement loginBTN;
	

	//Using @FindBy for Logout
	
	@FindBy(how=How.XPATH, using="//a[@href=\"javascript:__doPostBack('p$lt$zoneTopIcons7$SignOutButton$btnSignOutLink','')\"]") WebElement logoutBTN;
	
	
	@FindBy(how=How.XPATH, using="//div[@class=\"username place-left\"]/a") WebElement userTitle;
	
	
	
	
	//Actions
	public void loginAuthentication() throws Exception 
	{
		
		LoadingPropertyFile();
		username.clear();
		username.sendKeys(LoginUser);
		password.clear();
		password.sendKeys(LoginPassword);
		loginBTN.click();
		String Logintitle=driver.getTitle();
		Assert.assertEquals(Logintitle,"Intranet Portal - Home QuEST");
		System.out.println("Login Successful.");
		
		
		
	}
	
	public void printUser()
	{
	String text = userTitle.getText();
	System.out.println("The user name is: " +text);
	}
	
	public void logoutAction()
	{
		logoutBTN.click();
		Assert.assertTrue(driver.getTitle().contains("Logon"));		
		System.out.println("Logout Successful.");
	}
	
	public void clickUser()
	{
		userTitle.click();
	}


	//Will be called with driver
	public QuestIntraHomeLogin(WebDriver driver)
	{
		this.driver=driver;
	}

}
