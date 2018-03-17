package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Config;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="(//a[@href='javascript:void(0);'])[3]")
	  public WebElement MyAccountButton;
	
	@FindBy (xpath="(//a[@href='https://www.phptravels.net/login'])[2]")
	   public WebElement LoginingButton;
	
	@FindBy(xpath="(//input[@class='form-control padding-10'])[1]")
	   public WebElement userName;
	@FindBy(xpath="(//input[@class='form-control padding-10'])[2]")
	   public WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-action btn-lg btn-block loginbtn']")
	public WebElement logButton;
	
	@FindBy(xpath="//a[@href='https://www.phptravels.net/invoice?id=73&sessid=6897']")
	public WebElement invoiceButton;
	
	
	public void clickLog() throws InterruptedException{
		System.out.println(driver.getTitle().toString());
	//1	
		Actions action =new Actions(driver);
		Thread.sleep(4000);
	//2	
		action.moveToElement(MyAccountButton).perform();
		Thread.sleep(1000);
		MyAccountButton.click();
		LoginingButton.click();
	//3
		 Thread.sleep(3000);
		userName.sendKeys(Config.getProperty("userName"));
		password.sendKeys(Config.getProperty("password"));
		action.moveToElement(logButton).perform();
		logButton.click();
	//4
		action.moveToElement(invoiceButton).perform();
		Thread.sleep(3000);
		invoiceButton.click();
	//5	
		System.out.println(driver.getTitle().toString());
		List <String> window = new ArrayList<>(driver.getWindowHandles());
		driver.close();
		driver.switchTo().window(window.get(2));
		System.out.println(driver.getTitle().toString());
		
		
	}
	
	

}
