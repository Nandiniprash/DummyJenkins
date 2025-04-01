package Login;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericBaseClassUtility.BaseClass;
import GenericListenerUtility.ListenerImplementation;
import GenericUtility.PropertiesFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;

//@Listeners(ListenerImplementation.class)
public class Login extends BaseClass { // this is class name

	//@Parameters("browser")
	@Test(groups={"SmokeTest"}, retryAnalyzer = GenericListenerUtility.RetryListenerImp.class)
	public void LoginTest() throws InterruptedException, IOException { // this is testcase name
		
		String expectedURL = "http://49.249.28.218:8098/dashboar";
		//Launching the browser
//		WebDriver driver=null;
//		ChromeOptions Coption=new ChromeOptions(); //headless testing
//		FirefoxOptions Foption=new FirefoxOptions();
//		EdgeOptions Eoption=new EdgeOptions();
//		Coption.addArguments("--headless");
//		Foption.addArguments("--headless");
//		Eoption.addArguments("--headless");
//		if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			driver=new ChromeDriver(Coption);
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox"))
//		{
//			driver=new FirefoxDriver(Foption);
//		}
//		else if(BROWSER.equalsIgnoreCase("edge"))
//		{
//			driver=new EdgeDriver(Eoption);
//		}
//		else
//		{
//			driver=new ChromeDriver(Coption);
//		} 
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Thread.sleep(3000);
		
		//verification of dashboard
		String actualURL = driver.getCurrentUrl();
		
//		if(actualURL.equals(expectedURL))  // using Asser instead of this , to fail TC
//		{
//			Reporter.log("Validation is pass",true);
//		}
//		else
//		{
//			Reporter.log("Validation is failed",true);
//		}
		
//		Assert.assertEquals(actualURL, expectedURL, "Validation is failed"); //msg displayed only wen it fails
//		Reporter.log("Validation is passed",true); // if we want to display msg wen tc is passed
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(actualURL, expectedURL, "Validation is failed");
		sf.assertAll();// this will make tc fail and stops the execution if its failed.
		Reporter.log("Validation is passed",true);
		
		
		//logout

	}

}
