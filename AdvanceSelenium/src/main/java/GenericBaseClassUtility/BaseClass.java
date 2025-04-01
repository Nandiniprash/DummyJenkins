package GenericBaseClassUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import GenericUtility.DatabaseUtility;
import GenericUtility.PropertiesFileUtility;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;

public class BaseClass {
	
	public WebDriver driver = null;
	public static WebDriver sdriver=null;
	DatabaseUtility dbUtil = new DatabaseUtility();
	PropertiesFileUtility propUtil = new PropertiesFileUtility();
	
	@BeforeSuite
	public void beforeSuite() throws SQLException
	{
		//System.out.println("Before suite method");
		System.out.println("Established db connection");
		dbUtil.getDBConnection("jdbc:mysql://localhost:3306/Ninza_E18", "root", "@Alpine604");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		//System.out.println("Before Test method");
		System.out.println("Pre configuration set up");
	}
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		//System.out.println("Before class method");
		System.out.println("Launch the browser");
		String BROWSER = propUtil.readingDataFromPropFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		sdriver= driver;
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		//System.out.println("Before method");
		System.out.println("Login");
		String URL = propUtil.readingDataFromPropFile("url");
		String UN = propUtil.readingDataFromPropFile("uname");
		String PWD = propUtil.readingDataFromPropFile("pwd");
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.login(UN, PWD);
	}
	
	@AfterMethod
	public void afterMethod()
	{
		//System.out.println("after method");
		System.out.println("Logout");
		DashboardPage dp = new DashboardPage(driver);
		dp.logout();
	}
	
	@AfterClass
	public void afterClass()
	{
		//System.out.println("after class method");
		System.out.println("Close the browser");
		driver.quit();
	}
	
	@AfterTest
	public void afterTest()
	{
		//System.out.println("after test method");
		System.out.println("Post configuration set up");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		//System.out.println("after suite method");
		System.out.println("Close db connection");
		dbUtil.closeDBConnection();
	}
	
	

}
