package Utility;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

 public class PropertyFile {
	
	public String LoadProperty(String key) throws Exception
	
	{
		String path="./PropertyFile/ProFile.properties";
		FileReader fr=new FileReader(path);
		Properties p=new Properties();
		p.load(fr);
		System.out.print("");
		
		return p.getProperty(key);
		
	}
}


