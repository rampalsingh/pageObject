package qa.pageObject.Pages.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import qa.pageObject.Base.BasePage;
import qa.pageObject.Base.Util.FBConstants;

public class LaunchPage extends BasePage {

	ExtentTest test;
	
	public LaunchPage(WebDriver driver, ExtentTest test){
		super(driver, test);
		this.test = test;
/*		this.driver= driver;
		System.out.println("1. LaunchPage");*/
	}
	
	public LoginPage gotoLoginPage(){
		
		test.log(LogStatus.INFO, "Opening the URL : "+FBConstants.PAGE_URL);
		driver.get(FBConstants.PAGE_URL);
		test.log(LogStatus.PASS, "URL Opened : "+FBConstants.PAGE_URL);
		
		//Old Init code
		//return PageFactory.initElements(driver, LoginPage.class);
		LoginPage loginPage = new LoginPage(driver,test);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
	}
	
}
