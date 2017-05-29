package qa.pageObject.TestCase;
import qa.pageObject.TestCase.Base.BaseTest;

public class ___ProfileTest extends BaseTest {/*


	@Test
	public void testProfile() throws Exception{
		System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		ExtentReports extent = ExtentManager.getInstance();
		ExtentTest test =  extent.startTest("Login Test");
		test.log(LogStatus.INFO, "Starting loggin test");
		test.log(LogStatus.INFO, "Opening Browser");
		
		init("Chrome");
		LaunchPage launchPage = PageFactory.initElements(driver, LaunchPage.class);
		LoginPage loginPage = launchPage.gotoLoginPage();
		test.log(LogStatus.INFO, "Logging Inn");
		
		Object page = loginPage.doLogin("singhrampal", "*#ramface#");
		
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
		test.log(LogStatus.PASS, "Login Tested Passed");
		extent.endTest(test);
		extent.flush();
		driver.quit();
	}
	
*/}
