package PageTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageFactory.EmpProfile;
import PageFactory.LogoTest;
import PageFactory.QuestHome;
import PageFactory.QuestIntraHomeLogin;

public class DriverScript extends BasePage{
	
	
	@Test(priority=0)
	public void LoginAuthentication() throws Exception
	{
		QuestIntraHomeLogin obj1=PageFactory.initElements(driver, QuestIntraHomeLogin.class);
		obj1.loginAuthentication();
				
	}
	
	@Test(priority=1)
	public void LogoutAuthentication()
	{
		QuestIntraHomeLogin obj1=PageFactory.initElements(driver, QuestIntraHomeLogin.class);
		obj1.printUser();
		obj1.logoutAction();		
		
		
	}
	
	@Test(dependsOnMethods = {"LoginAuthentication" })
	public void HomeViewAllApps()
	{				
		
		QuestHome obj2=PageFactory.initElements(driver, QuestHome.class);
		obj2.viewAllBtn();
		
	}
	
	@Test(dependsOnMethods = {"HomeViewAllApps" })
	public void HomeLogoTest() throws InterruptedException
	{
		LogoTest obj1=PageFactory.initElements(driver, LogoTest.class);
		obj1.windowTest();
		
		
		
		
	}
	
@Test(dependsOnMethods = {"HomeLogoTest"})
public void UserDetails() throws InterruptedException
{
	QuestIntraHomeLogin obj1=PageFactory.initElements(driver, QuestIntraHomeLogin.class);
	obj1.clickUser();
	EmpProfile obj2=PageFactory.initElements(driver, EmpProfile.class);
	obj2.printDetails();
}
}
