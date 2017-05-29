package qa.pageObject.Base.Util;

public class FBConstants {

	//paths
	public static final String CHROME_DRIVER_EXE = ".//chromedriver.exe";
	
	public static final String PAGE_URL = "http://www.facebook.com";
	
	//locatorss
	//Gmail -- //input[@id='identifierId' and @type='email']";
	//Gmail -- 	//*[@name='password']";
	
	//FB -- //*[@id='email']
	//FB -- //*[@id='pass']
	public static final String LOGIN_USERNAME = "//*[@id='email']";
	public static final String LOGIN_PASSWORD = "//*[@id='pass']";
	
	//FBLink 
	//*[@id='u_0_2']/div/div/div/div[1]/div[1]/h1/a/span 

	//GmailLink
	//*[@id=':hi']/div/div
	public static final String PROFILEPAGE_LINK = "//*[@id='u_0_2']/div/div/div/div[1]/div[1]/h1/a/span";
	
	public static final String UNAME = "rampal.singh@sts.in";
	public static final String PWD = "";

	public static final String FIREFOX_DRIVER_EXE = ".//geckodriver.exe";

	public static final String DATA_XLS_PATH = System.getProperty("user.dir")+"\\data\\Data.xlsx";
	public static final String TESTDATA_SHEET = "TestData";
	public static final String TESTCASES_SHEET = "TestCases";

	public static final Object RUNMODE_COL = "Runmode";

	public static final String REPORTS_PATH = "D:\\reports\\";

	


	
}
