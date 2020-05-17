package Selenium4;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.Constants;
import Utilities.Utils;

public class getElementLocation {

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
	public void getLocation() throws IOException, InterruptedException {
		
	//maximize the web browser window	
		driver.manage().window().maximize();
		
	//enter the URL	
		driver.get(Constants.baseURL);
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "Wikipedia");
		
	//GET DETAILS OF MAIN LOGO	
		WebElement logo = driver.findElement(By.xpath("//body[@id='www-wikipedia-org']/div[1]"));
		System.out.println("X POS: "+logo.getRect().getX());
		System.out.println("Y POS: "+logo.getRect().getY());
		
		
	}
	
	@Test
	public void getSize() throws IOException, InterruptedException {
		
	//maximize the web browser window	
		driver.manage().window().maximize();
		
	//enter the URL	
		driver.get(Constants.baseURL);
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "Wikipedia");
		
	//GET DETAILS OF MAIN LOGO	
		WebElement logo = driver.findElement(By.xpath("//body[@id='www-wikipedia-org']/div[1]"));
		System.out.println("Size: "+logo.getSize());
		System.out.println("Height: "+logo.getRect().getHeight());
		System.out.println("Width: "+logo.getRect().getWidth());

		
		
	}
	
}
