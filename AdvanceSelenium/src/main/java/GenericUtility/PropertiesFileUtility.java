package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility {
	
	public String readingDataFromPropFile(String Key) throws IOException // this method i can call while reading data from prop file
	{
		FileInputStream fis= new FileInputStream("C:\\Users\\prash\\eclipse-workspace\\AdvanceSelenium\\src\\test\\resources\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String data = prop.getProperty(Key);
		return data;
		
		
	}

}
//no need of main method as we r not going to execute these classes . we r jus going to store some info
