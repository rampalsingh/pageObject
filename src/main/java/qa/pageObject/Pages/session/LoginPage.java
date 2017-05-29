package qa.pageObject.Pages.session;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import qa.pageObject.Base.BasePage;
import qa.pageObject.Pages.LandingPage;
import qa.pageObject.Base.Util.FBConstants;

public class LoginPage  extends BasePage{

	@FindBy(xpath=FBConstants.LOGIN_USERNAME) 
	public WebElement email;
	
	@FindBy(xpath=FBConstants.LOGIN_PASSWORD)
	public WebElement password;
	
	//Instead of declaring here, declare it in BasePage
	//ExtentTest test;

	public LoginPage(WebDriver driver, ExtentTest test){
		super(driver,test);
		//this.test = test;
/*		this.driver= driver;
		System.out.println("2. LoginPage");*/
	}
	
	public Object doLogin(String uName, String pWord) throws Exception{
		email.sendKeys(uName);
//		email.sendKeys(Keys.ENTER);
		
		password.sendKeys(pWord);
		password.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		//validate -- login
		//boolean loginSuccess = true;
		boolean loginSuccess = isElementPresent(FBConstants.PROFILEPAGE_LINK);
		
		
		if(loginSuccess){
	/*		we can use as below mentioned instead of 
			 return PageFactory.initElements(driver, LandingPage.class);
	*/	LandingPage landingPage = new LandingPage(driver, test);
		PageFactory.initElements(driver, landingPage);
		return landingPage;
		
		
		}
		else{
		//	return PageFactory.initElements(driver, LoginPage.class);
		LoginPage loginPage = new LoginPage(driver, test);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
		}
	}
}
