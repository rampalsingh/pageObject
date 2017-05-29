package qa.pageObject.TestCase;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import qa.pageObject.Base.Util.DataUtil;
import qa.pageObject.Base.Util.FBConstants;
import qa.pageObject.Pages.LandingPage;
import qa.pageObject.Pages.session.LaunchPage;
import qa.pageObject.Pages.session.LoginPage;
import qa.pageObject.TestCase.Base.BaseTest;

public class LoginTest extends BaseTest {

	String testCaseName="LoginTest";
	
	@Test(dataProvider="getData")
	public void doLogin(Hashtable<String,String> data) throws Exception{
		
		test = extent.startTest("Login Test");
		
		test.log(LogStatus.INFO, "Starting login test");
		
		if(data.get(FBConstants.RUNMODE_COL).contains("N")){
			throw new SkipException("Skipping the Testcase as Runmode is : N");
		}
		
		test.log(LogStatus.INFO, "Opening Browser");
		init(data.get("Browser"));
		
/*		//Old code
		LaunchPage launchPage = PageFactory.initElements(driver, LaunchPage.class);
*/		LaunchPage launchPage = new LaunchPage(driver,test);
		PageFactory.initElements(driver, launchPage);
		
		
		
		test.log(LogStatus.INFO, "Logging Inn");
		LoginPage loginPage = launchPage.gotoLoginPage();
		
		Object page = loginPage.doLogin(data.get("Username"), data.get("Password"));
		String actualResult = "";
		//if i am logged in
		if(page instanceof LandingPage)
			actualResult = "Success";
		else
			actualResult = "Unsuccessful";
		
		if(!actualResult.equals(data.get("ExpectedResult"))){
			//faliure message
			reportFailure("failure message");
		}
		test.log(LogStatus.PASS, "Login Test Passed");
		
		test.log(LogStatus.INFO, "Closing Browser");
		driver.quit();
		
		
	}
	
	@AfterMethod
	public void quit(){
		if(extent!=null){
		extent.endTest(test);
		extent.flush();
		}
	}
	
	@DataProvider
	public Object[][] getData(){
/*
//		Xls_Reader xls = new Xls_Reader(FBConstants.DATA_XLS_PATH);
		String sheetName=FBConstants.TESTDATA_SHEET;
		//String testCaseName="LoginTest";
		
		// reads data for only testCaseName
		
		int testStartRowNum=1;
		while(!xls.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName)){
			testStartRowNum++;
		}
		System.out.println("Test starts from row - "+ testStartRowNum);
		int colStartRowNum=testStartRowNum+1;
		int dataStartRowNum=testStartRowNum+2;
		
		// calculate rows of data
		int rows=0;
		while(!xls.getCellData(sheetName, 0, dataStartRowNum+rows).equals("")){
			rows++;
		}
		System.out.println("Total rows are  - "+rows );
		
		//calculate total cols
		int cols=0;
		while(!xls.getCellData(sheetName, cols, colStartRowNum).equals("")){
			cols++;
		}
		System.out.println("Total cols are  - "+cols );
		Object[][] data = new Object[rows][1];
		//read the data
		int dataRow=0;
		Hashtable<String,String> table=null;
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++){
			table = new Hashtable<String,String>();
			for(int cNum=0;cNum<cols;cNum++){
				String key=xls.getCellData(sheetName,cNum,colStartRowNum);
				String value= xls.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
				// 0,0 0,1 0,2
				//1,0 1,1
			}
			data[dataRow][0] =table;
			dataRow++;
		}
		return data;
*/
		return DataUtil.getData(xls, testCaseName);
	}
}
