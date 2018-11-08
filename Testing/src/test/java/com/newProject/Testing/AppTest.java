package com.newProject.Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTest
{
	@Test
	public void run()
	{
		WebDriver d=new ChromeDriver();
		d.get("https://www.google.com");
		d.quit();
	}
}