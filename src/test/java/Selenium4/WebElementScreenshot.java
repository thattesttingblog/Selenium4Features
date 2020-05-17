package Selenium4;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.*;
import Utilities.*;



public class WebElementScreenshot {
	
	private WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		Utils.initiateChromeDriver();
		driver = new ChromeDriver();
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
		
	}
	
	@Test
	public void captureScreenshot() throws IOException {
		
	//maximize the web browser window	
		driver.manage().window().maximize();
		
	//enter the URL	
		driver.get(Constants.baseURL);
		String title1 = driver.getTitle();
		
		AssertJUnit.assertEquals(title1, "Wikipedia");
		
	//TAKE SCREENSHOT OF MAIN IMG	
		 Utils.takescreenshot(driver,PageObjects.locator);
		 
		
	//Enter search keywords	
		 driver.findElement(PageObjects.strSearch).sendKeys("selenium");
		 driver.findElement(PageObjects.btnSearch).click();
		 
	//Assert page Title	 
		 String title2 = driver.getTitle();
		 AssertJUnit.assertEquals(title2, "Selenium - Wikipedia");
		 
	//TAKE SCREENSHOT OF SEARCH IMG	
		 Utils.takescreenshot(driver, PageObjects.locator1);
		
	
	}
	

}
