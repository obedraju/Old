package PageTests;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import PageFactory.Corporate;
import PageFactory.EmpProfile;
import PageFactory.IPMS;
import PageFactory.LogoTest;
import PageFactory.QuestHome;
import PageFactory.QuestIntraHomeLogin;
import Utility.ExcelUtil;


public class DriverScript extends BasePage{
	String test="test";
	
	/************************************************/
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeTest
	 public void startReport(){
	 
	String path="./ExtentReportOutput/Report_";	
	Date d1=new Date();
	path=path+d1.toString()+".html";
	
	
	 htmlReporter = new ExtentHtmlReporter(path);
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
	 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
	 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.BROWN));
	 }else if(result.getStatus() == ITestResult.SKIP){
	 //logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
	 logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
	 }
	 } 
	
	@AfterTest
	protected void endReport(){
	 extent.flush();
	    }

	/**
	 * @throws Exception ***********************************************/
	
	public void start() throws Exception
	{
		LoginAuthentication();
	}
	
	@Test(priority=0)
	//@Parameters({"key","key2"})
	public void LoginAuthentication() throws Exception
	{
		
			
		logger = extent.createTest("LoginAuthentication");
		QuestIntraHomeLogin obj1=PageFactory.initElements(driver, QuestIntraHomeLogin.class);
		obj1.loginAuthentication();
		logger.log(Status.PASS, MarkupHelper.createLabel("Login Sucessfull", ExtentColor.GREEN));
		ExcelUtil xl=new ExcelUtil();
		xl.xlWriteData("LoginAuthentication");
		
		
						
	}
	
	@Test(priority=1)
	public void LogoutAuthentication() throws Exception
	{	
		logger = extent.createTest("LogoutAuthentication");
		QuestIntraHomeLogin obj1=PageFactory.initElements(driver, QuestIntraHomeLogin.class);
		obj1.printUser();
		obj1.logoutAction();
		logger.log(Status.PASS, MarkupHelper.createLabel("Logout Sucessfull", ExtentColor.GREEN));
		ExcelUtil xl=new ExcelUtil();
		xl.xlWriteData("LogoutAuthentication");
		
		
	}
	
	@Test(dependsOnMethods = {"LoginAuthentication" })
	public void HomeViewAllApps() throws Exception
	{	
		
		logger = extent.createTest("ViewAll");
		QuestHome obj2=PageFactory.initElements(driver, QuestHome.class);
		obj2.viewAllBtn();
		logger.log(Status.PASS, MarkupHelper.createLabel("Clicking ViewAll Sucessfull", ExtentColor.GREEN));
		ExcelUtil xl=new ExcelUtil();
		xl.xlWriteData("HomeViewAllApps");
		
		
	} 
		
		
		//@Test(dependsOnMethods= {"corporate_"})
		public void IPMS_() throws InterruptedException
		{
			IPMS obj=PageFactory.initElements(driver, IPMS.class);
			obj.ipmsClick();
			obj.impsLoginLink();
			obj.ipmsLoginCredentials();
			
		}
	
	
	@Test(dependsOnMethods = {"HomeViewAllApps" })
	public void HomeLogoTest() throws InterruptedException, Exception
	{
		logger = extent.createTest("HomeLogo Test");
		LogoTest obj1=PageFactory.initElements(driver, LogoTest.class);
		obj1.windowTest();
		logger.log(Status.PASS, MarkupHelper.createLabel("Home Logo Click Test Sucessfull", ExtentColor.GREEN));
		ExcelUtil xl=new ExcelUtil();
		xl.xlWriteData("HomeLogoTest");
		
		
		
	}
	
@Test(dependsOnMethods = {"HomeLogoTest"})
public void UserDetails() throws Exception
{	logger = extent.createTest("User Details");
	QuestIntraHomeLogin obj1=PageFactory.initElements(driver, QuestIntraHomeLogin.class);
	obj1.clickUser();
	EmpProfile obj2=PageFactory.initElements(driver, EmpProfile.class);
	obj2.printDetails();
	logger.log(Status.PASS, MarkupHelper.createLabel("Internal Data Test Sucessfull", ExtentColor.GREEN));
	ExcelUtil xl=new ExcelUtil();
	xl.xlWriteData("UserDetails");
	
}
	
	
	@Test(dependsOnMethods= {"UserDetails"})
	public void corporate_() throws Exception
	{			
		Corporate obj=PageFactory.initElements(driver, Corporate.class);
		obj.Clickable();



}

}
