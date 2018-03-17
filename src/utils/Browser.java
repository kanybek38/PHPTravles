package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	
static WebDriver driver;
	
	public static WebDriver getDriver() {
		String browser = Config.getProperty("browser");
		switch(browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Config.getProperty("chromePath"));
		 driver = new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	           break;
		case "fireFox":
			
		}
		return driver;
	}

}
