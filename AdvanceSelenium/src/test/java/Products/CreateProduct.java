package Products;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
import ObjectRepository.CreateProductsPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductPage;

//@Listeners(ListenerImplementation.class)
public class CreateProduct extends BaseClass {

	//@Parameters("browser")
	@Test(groups={"Integration"})
	public void addProductTest() throws InterruptedException, IOException {
		
		JavaUtility jUtil = new JavaUtility();
		int randomNum = jUtil.getRandomNum(1000);
		
		
		ExcelFileUtility exUtil = new ExcelFileUtility();
		String pname = exUtil.readingDataFromExcel("Product", 1, 2)+randomNum;
		String quantity = exUtil.readingDataFromExcel("Product", 1, 3);
		String price = exUtil.readingDataFromExcel("Product", 1, 4);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		DashboardPage dp = new DashboardPage(driver);
		dp.getProductsLink().click();
		
		ProductPage pp = new ProductPage(driver);
		pp.getAddProdcut().click();
		
		CreateProductsPage cpp = new CreateProductsPage(driver);
		cpp.CreateProduct(pname, quantity, price);
		
		Thread.sleep(5000);
		String successMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		Thread.sleep(5000);
		
//		if(successMsg.contains(pname))
//		{
//			Reporter.log("Product "+pname+" Successfully added",true);
//		}
//		else
//		{
//			Reporter.log("Product Not added",true);
//		}
		boolean status = successMsg.contains(pname);
		Assert.assertTrue(status, "Product Not added");
		Reporter.log("Product "+pname+" Successfully added",true);
		
		Thread.sleep(3000);
		
	}

}
