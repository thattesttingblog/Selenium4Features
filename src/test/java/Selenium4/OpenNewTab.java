package Selenium4;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.Constants;
import Utilities.Utils;

public class OpenNewTab {

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
	public void openNewTab() throws IOException, InterruptedException {
		
	//maximize the web browser window	
		driver.manage().window().maximize();
		
	//enter the URL	
		driver.get(Constants.baseURL);
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "Wikipedia");
		
	//Open another application in NEW TAB
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://www.google.com");
		Assert.assertEquals(driver.getTitle(), "Google");
		Thread.sleep(5000);
		
		
	}
	
	
}
