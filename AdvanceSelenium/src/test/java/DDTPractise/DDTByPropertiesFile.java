package DDTPractise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DDTByPropertiesFile {

	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream("C:\\Users\\prash\\eclipse-workspace\\AdvanceSelenium\\src\\test\\resources\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String UN = prop.getProperty("uname");
		String PWD = prop.getProperty("pwd");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(UN);
		System.out.println(PWD);
	}

}


// this is reading data from properties file