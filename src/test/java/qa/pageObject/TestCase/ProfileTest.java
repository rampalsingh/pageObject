package qa.pageObject.TestCase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import qa.pageObject.Base.Util.FBConstants;
import qa.pageObject.Pages.LandingPage;
import qa.pageObject.Pages.ProfilePage;
import qa.pageObject.Pages.session.LaunchPage;
import qa.pageObject.Pages.session.LoginPage;
import qa.pageObject.TestCase.Base.BaseTest;


public class ProfileTest extends BaseTest {


	@Test
	public void testProfile() throws Exception{
		test = extent.startTest("Profile Test");
		test.log(LogStatus.INFO, "Starting Profile Test");
		
		
		
		init("Chrome");
		
		// old code -- LaunchPage launchPage = PageFactory.initElements(driver, LaunchPage.class);
		LaunchPage launchPage = new LaunchPage(driver, test);
		PageFactory.initElements(driver, launchPage);
		
		LoginPage loginPage = launchPage.gotoLoginPage();
		Object page = loginPage.doLogin(FBConstants.UNAME, FBConstants.PWD);
		
		if(page instanceof LoginPage)
			Assert.fail("Login Failed");
		else if (page instanceof LandingPage) {
			System.out.println("Logged in Successfully");
		}
		
		LandingPage landingPage = (LandingPage)page;
		landingPage.getMenu().Search();
		landingPage.verifyTitle("XXXXX");
		
		ProfilePage profPage = landingPage.gotoProfilePage();
		profPage.verifyProfile();
		
		profPage.getMenu().logOut();
		
		driver.quit();
	}
	
	@AfterMethod
	public void quit(){
		if(extent!=null){
		extent.endTest(test);
		extent.flush();
		}
	}
	
	
}
