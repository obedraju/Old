package com.newProject.Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest
{
	@Test
	public void run()
	{
		WebDriver d=new ChromeDriver();
		d.get("https://www.facebook.com");
		String x=d.getTitle();
		Assert.assertEquals(d.getTitle(), x);
		
		System.out.println("In Testing..This is working. Launching!");
		d.quit();
	}
}