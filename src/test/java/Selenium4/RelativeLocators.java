package Selenium4;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.Constants;
import Utilities.Utils;

public class RelativeLocators {
	
private WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		Utils.initiateChromeDriver();
		driver = new ChromeDriver();
		
	//maximize the web browser window	
		driver.manage().window().maximize();
		
	//enter the URL	
		driver.get("https://automationbookstore.dev/");
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "Automation Bookstore");
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
		
	}

	@Test(description = "test Book 5 is left of book 6 and below book 1")
	public void Test1() {
		WebElement book5 = driver.findElement(RelativeLocator.withTagName("li").toLeftOf(By.id("pid6")).below(By.id("pid1")));
		
		String id = book5.getAttribute("id");
		
		Assert.assertEquals(id, "pid5");
	}
		
	@Test(description = "test Book 2 is right of book 1 and above book 6")
	public void Test2() {
		WebElement book2 = driver.findElement(RelativeLocator.withTagName("li").toRightOf(By.id("pid1")).above(By.id("pid6")));
		
		String id = book2.getAttribute("id");
		
		Assert.assertEquals(id, "pid2");
	}
		
	
}
	

