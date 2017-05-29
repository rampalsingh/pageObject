package qa.pageObject.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import qa.pageObject.Common.TopMenu;

public class BasePage {

	public WebDriver driver;
	public TopMenu menu;
	public ExtentTest test;
	public BasePage(){
		
	}
	
	public BasePage(WebDriver driver, ExtentTest test){
		this.driver= driver;
		this.test = test;
//		menu = PageFactory.initElements(driver, TopMenu.class);
//		System.out.println(driver.getClass());
	}
	
	public TopMenu getMenu(){
		return menu;
	}
	
	public boolean isElementPresent(String locator){
		int s = driver.findElements(By.xpath(locator)).size();
		if(s==0)
			return false;
		else
			return true;
					
	}
	
	public void reportFailure(String failureMessage){
		Assert.fail(failureMessage);
	}
}
