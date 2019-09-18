package Utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class CreateWorkbookXL {
	
	
	public String createBook() throws Exception
	{
		HSSFWorkbook wb = new HSSFWorkbook();
		String path="./Input/_Report_";
		path=path+new Date().toString()+"_.xls";		 
		FileOutputStream fileOut = new FileOutputStream(path);		 
		wb.write(fileOut);	
		
		//org.apache.poi.ss.usermodel.Sheet sheet1 = wb.createSheet("Sheet1");
		
		fileOut.close();
		return path;
		
		
	}
		 
		public static void main(String args[]) throws IOException
		 
		{
		 
		//To create a new WorkBook with xls extension
		 
		
		
		
		 
		//To create a new WorkBook with xlsx extension
		 
		/*Workbook wb1 = new XSSFWorkbook();
		 
		FileOutputStream fileOut1 = new FileOutputStream("D:\\Test1.xlsx");
		 
		wb.write(fileOut1);
		 
		fileOut1.close();*/
		
		
		 
		}
		 
		}
	
	


