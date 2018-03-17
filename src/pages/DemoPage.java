package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoPage {
	
	WebDriver driver;
	
	public DemoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//a[@href='//www.phptravels.net']")
	public WebElement wwwPHPTravels;
	
	public void clickDemo () throws InterruptedException {
		Thread.sleep(2000);
		wwwPHPTravels.click();
		System.out.println(driver.getTitle().toString());
		
		List <String> window = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(window.get(1));
		
	}
	
	@FindBy (xpath="(//a[@class='btn btn-primary btn-lg btn-block'])[2]")
	public WebElement admin;
	
	public void clickAdmin() {
		admin.click();

	List <String> window = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(window.get(1));
		System.out.println(driver.getTitle().toString());
	}

}
