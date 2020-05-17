package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utils extends BaseClass {
	

	public Utils(WebDriver driver) {
		super(driver);
	}
	
	
	public static void initiateChromeDriver() {
		
		WebDriverManager.chromedriver().setup();

	}
	

	public static void takescreenshot(WebDriver driver, String imgPath) throws IOException {
		
		
		WebElement img = driver.findElement(By.xpath(imgPath));
		File file = img.getScreenshotAs(OutputType.FILE);
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss'.png'").format(new Date());
		File destFile = new File("./test-output/images/"+ fileName);
		FileUtils.copyFile(file, destFile);
		
	}
	
	
}
