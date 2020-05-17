package PageObjects;

import org.openqa.selenium.By;

public class PageObjects {
	
	 public static final String  locator1 = "//body/div[@id='content']/div[@id='bodyContent']/div[@id='mw-content-text']/div/table/tbody/tr/td/a/img[1]";
	 public static final String locator = "//body[@id='www-wikipedia-org']/div[1]";
	 
	 
	 public static By img_mainPage = By.xpath(locator);
	 
	 public static By strSearch = By.id("searchInput");
	 public static By btnSearch = By.xpath("//form[@id='search-form']//fieldset//button");
	 

}
