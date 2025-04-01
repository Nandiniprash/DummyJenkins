package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CampaignsPage {
	
	WebDriver driver;
	
	public CampaignsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//select[@class='form-control']")
	private WebElement searchCampaign;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchCampaignId;
	
	@FindBy(xpath="//span[text()='Create Campaign']")
	private WebElement createCampaignBtn;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement confMsg;

	public WebElement getSearchCampaign() {
		return searchCampaign;
	}

	public WebElement getSearchCampaignId() {
		return searchCampaignId;
	}

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}

	public WebElement getConfMsg() {
		return confMsg;
	}
	
//	public void searchCampaign(int index)
//	{
//		Select select = new Select(searchCampaign);
//		select.selectByIndex(index);
//	} - required only if we are using it

}
