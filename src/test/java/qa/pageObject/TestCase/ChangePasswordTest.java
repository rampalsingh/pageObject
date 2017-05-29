package qa.pageObject.TestCase;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.pageObject.Base.Util.DataUtil;
import qa.pageObject.Base.Util.FBConstants;
import qa.pageObject.Pages.LandingPage;
import qa.pageObject.Pages.session.LaunchPage;
import qa.pageObject.Pages.session.LoginPage;
import qa.pageObject.TestCase.Base.BaseTest;

public class ChangePasswordTest extends BaseTest{

	String testCaseName="ChangePasswordTest";
	
	@Test(dataProvider = "getData")
	public void changePassword(Hashtable<String, String> data) throws Exception{
		if(data.get(FBConstants.RUNMODE_COL).contains("N")){
			throw new SkipException("Skipping the Testcase as Runmode is : N");
		}
		
		init(data.get("Browser"));
		LaunchPage launchPage = PageFactory.initElements(driver, LaunchPage.class);
		LoginPage loginPage = launchPage.gotoLoginPage();
		Object page = loginPage.doLogin(data.get("Username"), data.get("OldPassword"));
		
		if(page instanceof LoginPage)
			reportFailure("Could not login");
		LandingPage landingPage = (LandingPage) page;
		landingPage.getMenu().gotoSetting();
		driver.quit();
	}
	
	
	@DataProvider
	public Object[][] getData(){

		return DataUtil.getData(xls, testCaseName);
	}
}
