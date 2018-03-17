package test;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.AdminPage;
import pages.DemoPage;
import pages.InvoicePage;
import pages.LoginPage;
import utils.Browser;
import utils.Config;

public class MainTest {
	
	WebDriver driver;
	
	@BeforeClass 
	public void setUp() {
		driver = Browser.getDriver();
	}
	

	
	@Test (priority = 1)
	public void demopage() throws InterruptedException {
		driver.get(Config.getProperty("url"));
		DemoPage loginPage = new DemoPage(driver);
		loginPage.clickDemo();
	}
	
	@Test (priority=2)
	public void loginpage() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.clickLog();
	}
	
	
	@Test (priority=3)
	public void invoicePage() throws InterruptedException {
		InvoicePage invoice = new InvoicePage(driver);
		System.out.println(invoice.hotelRes());
		Thread.sleep(2000);
	    invoice.swi();
	    Thread.sleep(2000);
	    DemoPage demo = new DemoPage(driver);
	    demo.clickAdmin();
		
	}
	
	@Test (priority=4)
	public void Admin() {
		AdminPage admin = new AdminPage(driver);
		
		admin.adminClick();
		admin.edit();
		InvoicePage invoice = new InvoicePage(driver);
		System.out.println(invoice.hotelRes());
		
//		SoftAssert soft = new SoftAssert();
//		soft.assertEquals(admin.hotelNameAdmin(),invoice.hotelRes());
//		soft.assertEquals(admin.adminTax(), invoice.tax());
//		soft.assertEquals(admin.adminDeposit(), invoice.deposit());
//		soft.assertEquals(admin.adminTotal(), invoice.total());
//		soft.assertAll();
		
		System.out.println("Admin info "+admin.hotelNameAdmin()+" tax:"+admin.adminTax()+" deposit:"+
				           admin.adminDeposit()+" total:"+admin.adminTotal());
		
		
		
	}
	

}
