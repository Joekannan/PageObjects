package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageFactory.LoginPageByPageFactory;

public class LoginTestPageFactory {
	WebDriver driver;
	
	
	

	@BeforeMethod(description="This test is to set up the browser")
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php?");
	}
	@Test(description = "This test is to login")
	public void verifyLoginAndLogout() {
		LoginPageByPageFactory loginPage = new LoginPageByPageFactory(driver);
		loginPage.clickSingin();
		loginPage.enterUsername();
		loginPage.enterPassword();
		loginPage.clickLogin();
		loginPage.validateLogin();
//		loginPage.clickLogOut();
		loginPage.validateLogOut();
		
	}
	
	
	
	@AfterMethod(description = "This test is to tidy up the driver")
	public void tearDown() {
		driver.close();
		driver.quit();
	}	
}