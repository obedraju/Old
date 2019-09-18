package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;



public class ExcelUtil {
	int x;
	HSSFWorkbook wb;
	HSSFSheet sheet;
	String path="./Input/Sheet1.xls";
		
	
		public ExcelUtil() throws IOException
		{
		System.out.println("Loading Excel...");
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		wb=new HSSFWorkbook(fis);
		System.out.println("Excel Sheet loading complete.");
		System.out.println("");
		
		
		}
		
		
		public void xlWriteData(String executionMethod) throws Exception
		{
			Date d1 = new Date(); 
			if(executionMethod.equalsIgnoreCase("LoginAuthentication"))
			{
				x=1;
			}
			else if(executionMethod.equalsIgnoreCase("LogoutAuthentication"))
			{
				x=5;
			}
			else if(executionMethod.equalsIgnoreCase("HomeViewAllApps"))
			{
				x=2;
			}
			else if(executionMethod.equalsIgnoreCase("HomeLogoTest"))
			{
				x=3;
			}
			else if(executionMethod.equalsIgnoreCase("UserDetails"))
			{
				x=4;
			}
			
			
				
				
			sheet=wb.getSheetAt(0);
			System.out.println("");
			System.out.println("Writing new Data");
			
					
				Row row = sheet.getRow(x);			 
				Cell cell = row.createCell(2);			 
				cell.setCellValue("Pass");
				
				
				cell = row.createCell(3);			 
				cell.setCellValue(d1.toString());
				
				
				
			
			FileOutputStream fos = new FileOutputStream(path);			 
			wb.write(fos);			 
			fos.close();
			 
			System.out.println("Write complete.");
			
			
			//xlDataLoad();
		}
		
	/*	public void xlDataLoad() throws Exception
		{
			
			sheet=wb.getSheetAt(0);
			int rc=sheet.getLastRowNum();
			System.out.println("");
			System.out.println("Total rows: "+rc);
			for(int i=0;i<=rc;i++)
			{
										
				String data1=sheet.getRow(i).getCell(0).getStringCellValue().toString();
				String data2=sheet.getRow(i).getCell(1).getStringCellValue().toString();
				String data3=sheet.getRow(i).getCell(2).getStringCellValue().toString();
				//String data4=sheet.getRow(i).getCell(3).getStringCellValue().toString();
				
				
				
				System.out.println("Data: "+data1+ ", "+data2+", "+data3);
				
			}
			
		
						
		}*/
		
		/*public static void main(String args[]) throws Exception
		{
			ExcelUtil obj=new ExcelUtil();
			obj.xlWriteData();
		}*/
		

}
