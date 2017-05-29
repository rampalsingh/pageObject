package qa.pageObject.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class TopMenu {

	WebDriver driver;
	@FindBy(xpath=".//*[@id='userNavigationLabel']")
	public WebElement NAVIGATIONAL_LABEL;
	
	@FindBy(xpath=".//span[text()='Settings']")
	public WebElement SETTINGS_LINK;
	
	ExtentTest test;
	
	
	
	public TopMenu(WebDriver driver){
		this.driver = driver;
	}
	
	public void logOut(){
		
	}
	
	public void gotoSetting(){
		NAVIGATIONAL_LABEL.click();
		SETTINGS_LINK.click();
		
/*		JavascriptException js = (JavascriptException)driver;
		js.executeScript("document.getElementById('userNavigationLabel').click()");
*/		
		
	}
	
	public void Search(){
		
	}
}


