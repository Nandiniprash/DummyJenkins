package Contacts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import GenericUtility.WebDriverUtility;
import ObjectRepository.CampaignsPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;

//@Listeners(ListenerImplementation.class)
public class CreateContact extends BaseClass {

	//@Parameters("browser")
	@Test(groups= {"RegressionTest"})
	public void createContactWithCampaignTest() throws IOException, InterruptedException {
		
		JavaUtility jUtil = new JavaUtility();
		int randomNum = jUtil.getRandomNum(1000);
		
		
		ExcelFileUtility exUtil = new ExcelFileUtility();
		String campaign = exUtil.readingDataFromExcel("DDT", 1, 2)+randomNum;
		String targetSize = exUtil.readingDataFromExcel("DDT", 1, 3);
		String org = exUtil.readingDataFromExcel("Contact", 1, 2)+randomNum;
		String title = exUtil.readingDataFromExcel("Contact", 1, 3);
		String contactName = exUtil.readingDataFromExcel("Contact", 1, 4)+randomNum;
		String mobile = exUtil.readingDataFromExcel("Contact", 1, 5);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		DashboardPage dp = new DashboardPage(driver);
		Thread.sleep(20);
		dp.getCampaignsLink().click();
		
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignBtn().click();
		
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		ccp.createCampaignWitMandatoryFields(campaign, targetSize);
		Thread.sleep(5000);
		
		WebElement contactLink = dp.getContactsLink();
		WebDriverUtility wUtil= new WebDriverUtility();
		wUtil.waitForElementToBeClickable(driver, contactLink, 20);
		contactLink.click();
		Thread.sleep(5000);
		
		
		ContactsPage ccp1 = new ContactsPage(driver);
		WebElement createContactBtn = ccp1.getCreateContactBtn();
		wUtil.waitForElementToBeClickable(driver, createContactBtn, 20);
		createContactBtn.click();
		
		CreateContactPage cct = new CreateContactPage(driver);
		cct.createContactWithCampaign(org, title, contactName, mobile, "selectCampaign", campaign, "create-contact");

		Thread.sleep(5000);
		
		String confirmationMsg = ccp1.getConfMsg().getText();
		Thread.sleep(5000);
	 	
//		if(confirmationMsg.contains(contactName))
//		 	{
//				Reporter.log("Contact added Successfully",true);
//		 	}
//		 	else
//		 	{
//		 		Reporter.log("Contact not added",true);
//		 	}
		
		boolean status = confirmationMsg.contains(contactName);
		Assert.assertTrue(status, "Contact not added");
		Reporter.log("Contact "+contactName+" added Successfully",true);
	        
	    Thread.sleep(5000);

	}

}
