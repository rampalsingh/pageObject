package qa.pageObject;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import qa.pageObject.Base.Util.FBConstants;


public class All_Links {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://bbc.com");
		
		//driver.findElements(By.xpath("//a"));
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total links-> "+ allLinks.size());
		
		WebElement fifthLink = allLinks.get(4);
		System.out.println(fifthLink.getText());
		int x = fifthLink.getLocation().x;
	//	fifthLink.click();
		
		// no text
		// image
		// hidden
		for(int i=0;i<allLinks.size();i++){
			System.out.println(allLinks.get(i).getText()+" --- "+ allLinks.get(i).isDisplayed());
		}

	}

}
