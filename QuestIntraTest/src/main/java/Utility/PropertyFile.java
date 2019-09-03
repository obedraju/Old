package Utility;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

 public class PropertyFile {
	
	public String LoadProperty(String key) throws Exception
	
	{
		FileReader fr=new FileReader("/Users/g.obedraju/git/master/QuestIntraTest/PropertyFile/ProFile.properties");
		Properties p=new Properties();
		p.load(fr);
		
		return p.getProperty(key);
	}
}


