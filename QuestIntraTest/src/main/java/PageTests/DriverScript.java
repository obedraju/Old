package PageTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import PageFactory.EmpProfile;
import PageFactory.LogoTest;
import PageFactory.QuestHome;
import PageFactory.QuestIntraHomeLogin;


public class DriverScript extends BasePage{
	String test="test";
	
	/************************************************/
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeTest
	 public void startReport(){
	 
	 htmlReporter = new ExtentHtmlReporter("//Users/g.obedraju/Downloads/Report/TestOutput.html");
	 extent = new ExtentReports ();
	 extent.attachReporter(htmlReporter);
	 extent.setSystemInfo("Host Name", "Quest_Testing");
	 extent.setSystemInfo("Environment", "Automation Testing");
	 extent.setSystemInfo("User Name", "Obedraju");
	 
	 htmlReporter.config().setDocumentTitle("Quest Intra Test");
	 htmlReporter.config().setReportName("Quest Intra App Test Report");
	 htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	 htmlReporter.config().setTheme(Theme.STANDARD);
	 }
	
	@AfterMethod
	 public void getResult(ITestResult result){
	 if(result.getStatus() == ITestResult.FAILURE){
	 //logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
	 //MarkupHelper is used to display the output in different colors
	 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
	 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.BROWN));
	 }else if(result.getStatus() == ITestResult.SKIP){
	 //logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
	 logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
	 }
	 }
	
	@AfterTest
	 public void endReport(){
	 extent.flush();
	    }

	/*************************************************/
	
	@Test(priority=0)
	public void LoginAuthentication() throws Exception
	{
		
			
		logger = extent.createTest("LoginAuthentication");
		QuestIntraHomeLogin obj1=PageFactory.initElements(driver, QuestIntraHomeLogin.class);
		String result=obj1.loginAuthentication();
		if(result.equalsIgnoreCase("pass"))
		{
		logger.log(Status.PASS, MarkupHelper.createLabel("Login Sucessfull", ExtentColor.GREEN));
		}
		else
		{
			logger = extent.createTest("failTest");
			logger.log(Status.PASS, "Test Case (failTest) Status is passed");
			logger.log(Status.PASS, MarkupHelper.createLabel("Test Case (failTest) Status is passed", ExtentColor.GREEN));
		}
		
				
	}
	
	@Test(priority=1)
	public void LogoutAuthentication()
	{	logger = extent.createTest("LogoutAuthentication");
		QuestIntraHomeLogin obj1=PageFactory.initElements(driver, QuestIntraHomeLogin.class);
		obj1.printUser();
		obj1.logoutAction();
		logger.log(Status.PASS, MarkupHelper.createLabel("Logout Sucessfull", ExtentColor.GREEN));
		
		
	}
	
	@Test(dependsOnMethods = {"LoginAuthentication" })
	public void HomeViewAllApps()
	{	
		
		logger = extent.createTest("ViewAll");
		QuestHome obj2=PageFactory.initElements(driver, QuestHome.class);
		obj2.viewAllBtn();
		logger.log(Status.PASS, MarkupHelper.createLabel("Clicking ViewAll Sucessfull", ExtentColor.GREEN));
	} 
		
		
		
	
	
	@Test(dependsOnMethods = {"HomeViewAllApps" })
	public void HomeLogoTest() throws InterruptedException
	{
		logger = extent.createTest("HomeLogo Test");
		LogoTest obj1=PageFactory.initElements(driver, LogoTest.class);
		obj1.windowTest();
		logger.log(Status.PASS, MarkupHelper.createLabel("Home Logo Click Test Sucessfull", ExtentColor.GREEN));
		
		
		
		
	}
	
@Test(dependsOnMethods = {"HomeLogoTest"})
public void UserDetails() throws InterruptedException
{	logger = extent.createTest("User Details");
	QuestIntraHomeLogin obj1=PageFactory.initElements(driver, QuestIntraHomeLogin.class);
	obj1.clickUser();
	EmpProfile obj2=PageFactory.initElements(driver, EmpProfile.class);
	obj2.printDetails();
	logger.log(Status.PASS, MarkupHelper.createLabel("Internal Data Test Sucessfull", ExtentColor.GREEN));
}
}
