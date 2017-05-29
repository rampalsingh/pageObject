package qa.pageObject.TestCase.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import qa.pageObject.Base.Util.ExtentManager;
import qa.pageObject.Base.Util.FBConstants;
import qa.pageObject.Base.Util.Xls_Reader;

public class BaseTest {
	public WebDriver driver;
	public Xls_Reader xls = new Xls_Reader(FBConstants.DATA_XLS_PATH);
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;

	public void init(String browserType) {
		if (browserType.equals("Mozilla")) {
			System.setProperty("webdriver.gecko.driver", FBConstants.FIREFOX_DRIVER_EXE);
			driver = new FirefoxDriver();
		} else if (browserType.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", FBConstants.CHROME_DRIVER_EXE);
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void reportFailure(String failureMessage){
		Assert.fail(failureMessage);
	}
}
