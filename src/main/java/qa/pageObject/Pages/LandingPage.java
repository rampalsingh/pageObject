package qa.pageObject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import qa.pageObject.Base.BasePage;
import qa.pageObject.Base.Util.FBConstants;

public class LandingPage extends BasePage{
	
	@FindBy(xpath=FBConstants.PROFILEPAGE_LINK)
	public WebElement profileLink;
	
	
	public LandingPage(WebDriver driver, ExtentTest test){
		super(driver, test);
		this.test = test;
/*		this.driver= driver;
		System.out.println("3. LandingPage");*/
	}
	
	public ProfilePage gotoProfilePage() throws Exception{
		profileLink.click();
		Thread.sleep(5000);
		return PageFactory.initElements(driver, ProfilePage.class);
	}
	
	public void verifyTitle(String title){
		
	}
}
