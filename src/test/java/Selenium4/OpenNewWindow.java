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

public class OpenNewWindow {
	
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
	public void openNewWindow() throws IOException, InterruptedException {
		
	//maximize the web browser window	
		driver.manage().window().maximize();
		
	//enter the URL	
		driver.get(Constants.baseURL);
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "Wikipedia");
		
	//Open another application in NEW WINDOW
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to("https://www.google.com");
		Assert.assertEquals(driver.getTitle(), "Google");
		Thread.sleep(3000);
		
		
	}
	

}
