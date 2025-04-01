package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignsPage {
	
	WebDriver driver;
	
	public CreateCampaignsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="campaignName")
	private WebElement campaignName;
	
	@FindBy(name="targetSize")
	private WebElement targetSize;
	
	@FindBy(name="expectedCloseDate")
	private WebElement expectedCloseDate;
	
	@FindBy(xpath="//button[text()='Create Campaign']")
	private WebElement createCampaign;


	public WebElement getCampaignNameTxtFld() {
		return campaignName;
	}

	public WebElement getTargetSizeTxtFld() {
		return targetSize;
	}
	
	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}

	public WebElement getCreateCampaign() {
		return createCampaign;
	}
	
	public void createCampaignWitMandatoryFields(String campName, String target)
	{
		campaignName.sendKeys(campName);
		targetSize.clear();
		targetSize.sendKeys(target);
		createCampaign.click();
	}
	
	public void createCampaignWitCloseDate(String campName, String target, String date)
	{
		campaignName.sendKeys(campName);
		targetSize.clear();
		targetSize.sendKeys(target);
		expectedCloseDate.sendKeys(date);
		createCampaign.click();
	}
	
}
