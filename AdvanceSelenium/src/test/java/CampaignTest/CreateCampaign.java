package CampaignTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import GenericBaseClassUtility.BaseClass;
import GenericListenerUtility.ListenerImplementation;
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertiesFileUtility;
import ObjectRepository.CampaignsPage;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;

//@Listeners(ListenerImplementation.class)
public class CreateCampaign extends BaseClass {
	
	//@Parameters("browser") // this is only for crossbrowser execution
	@Test()
	public void createCampaignTest() throws InterruptedException, IOException { // this is one testcase
		
		JavaUtility jUtil = new JavaUtility();
		int randomNum = jUtil.getRandomNum(1000);
		
		ExcelFileUtility exUtil = new ExcelFileUtility();
		String campaign = exUtil.readingDataFromExcel("DDT", 1, 2)+randomNum;
		String targetSize = exUtil.readingDataFromExcel("DDT", 1, 3);
		
		//Launching the browser
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		DashboardPage dp = new DashboardPage(driver);
		dp.getCampaignsLink().click();
		
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignBtn().click();
		
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		ccp.createCampaignWitMandatoryFields(campaign, targetSize);
		
		Thread.sleep(5000);
		
		String confMsg = cp.getConfMsg().getText();
		Thread.sleep(5000);
		
//		if(confMsg.contains(campaign))
//		{
//			Reporter.log("Campaign "+campaign+" added successfully",true);
//		}
//		else
//		{
//			Reporter.log("Campaign not added",true);
//		}
		
		boolean status = confMsg.contains(campaign);
		//Assert.assertTrue(status);
		//Assert.assertTrue(status, "Campaign not added");
		Assert.assertEquals(status, true, "Campaign not added");
		Reporter.log("Campaign "+campaign+" added successfully",true);
		Thread.sleep(6000);
	
	}
	
	//@Parameters("browser")
	@Test(groups= {"RegressionTest"})
	public void createCampaignWithCloseDateTest() throws InterruptedException, IOException{ // this is another testcase
		
		JavaUtility jUtil = new JavaUtility();
		int randomNum = jUtil.getRandomNum(1000);
		
		ExcelFileUtility exUtil = new ExcelFileUtility();
		String campaign = exUtil.readingDataFromExcel("DDT", 1, 2)+randomNum;
		String targetSize = exUtil.readingDataFromExcel("DDT", 1, 3);
		
		String closeDate = jUtil.generateReqDate(30);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		DashboardPage dp = new DashboardPage(driver);
		dp.getCampaignsLink().click();
		
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignBtn().click();
		
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		ccp.createCampaignWitCloseDate(campaign, targetSize, closeDate);
		
		Thread.sleep(2000);
		
		String confMsg = cp.getConfMsg().getText();
		Thread.sleep(2000);
		
//		if(confMsg.contains(campaign))
//		{
//			Reporter.log("Campaign "+campaign+" added successfully",true);
//		}
//		else
//		{
//			Reporter.log("Camapign not added",true);
//		}
		
		boolean status = confMsg.contains(campaign);
		Assert.assertEquals(status, true, "Campaign not added");
		Reporter.log("Campaign "+campaign+" added successfully",true);
		Thread.sleep(3000);

	}

}
