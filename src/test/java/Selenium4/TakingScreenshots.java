package Selenium4;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Utilities.Utils;

public class TakingScreenshots {

private WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		Utils.initiateChromeDriver();
		driver = new ChromeDriver();
		
	//maximize the web browser window	
		driver.manage().window().maximize();
		
	//enter the URL	
		driver.get("https://demo.nopcommerce.com/");
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "nopCommerce demo store");
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
		
	}
	
	@Test( description = "screenshot of complete webpage")
	public void screenshotCompletePage() throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String fileName = new SimpleDateFormat("'CompleteScreenshot'yyyyMMddHHmmss'.png'").format(new Date());
		File dest = new File("./test-output/images/"+ fileName);

		FileUtils.copyFile(src, dest);
		
		
	}
	
	@Test(description = "screenshot of a section")
	public void screenshotOfSection() throws IOException {
		
		WebElement section = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		Utils.highlightElement(section,driver);
		
		File src = section.getScreenshotAs(OutputType.FILE);
		
		String fileName = new SimpleDateFormat("'SectionScreenshot'yyyyMMddHHmmss'.png'").format(new Date());
		File dest = new File("./test-output/images/"+ fileName);

		FileUtils.copyFile(src, dest);	
		
	}
	
	@Test(description = "screenshot of a element")
	public void screenshotOfElement() throws IOException {
		
		WebElement element = driver.findElement(By.xpath("//div[@class='header-logo']//a//img"));
		Utils.highlightElement(element,driver);
		
		
		File src = element.getScreenshotAs(OutputType.FILE);
		
		String fileName = new SimpleDateFormat("'ElementScreenshot'yyyyMMddHHmmss'.png'").format(new Date());
		File dest = new File("./test-output/images/"+ fileName);

		FileUtils.copyFile(src, dest);	
		
		
	}
	
	
	
}
