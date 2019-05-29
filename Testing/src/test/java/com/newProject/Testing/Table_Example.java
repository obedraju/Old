package com.newProject.Testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Table_Example {
	
	
	
		@Test
		public void run()
		{
			WebDriver d=new ChromeDriver();
			d.get("file:///C:/Users/Obedraju/Desktop/1.html");
			
		List<WebElement> ele=	d.findElements(By.xpath("//table//tbody//tr//th"));
			
			
			for(int i=0;i<ele.size();i++)
				System.out.println(ele.get(i).getText());
			
			int rows=d.findElements(By.xpath("//table//tbody//tr")).size();
			
			System.out.println(rows);
			
			/*WebElement dataTest=d.findElement(By.xpath("//table//tbody//tr[2]//td"));
			System.out.println(dataTest.getText());*/
			
			
			for(int j=1;j<=rows;j++)
			{
				
					
					WebElement dataTest=d.findElement(By.xpath("//table//tbody//tr["+(j)+"]//td"));
					System.out.println(dataTest.getText());
				}
				
					
					
				
			}
			
		
		}
	
	

	


