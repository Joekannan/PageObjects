package testNGMethods;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTestOutsideClass {
	
	public WebDriver driver;
		
		
		@BeforeMethod(description="This test is to set up the browser")
		public void setUp() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://automationpractice.com/index.php?");
		}
		
		@Test(description = "This test is to login", priority = -1, dataProvider="loginData" , dataProviderClass=DataproviderMethod.class)
		public void verifyLoginandLogout(String username, String password) {
			driver.findElement(By.linkText("Sign in")).click();
			driver.findElement(By.id("email")).sendKeys(username);
			driver.findElement(By.id("passwd")).sendKeys(password);
			driver.findElement(By.id("SubmitLogin")).click();
			if(driver.findElement(By.className("account")).isDisplayed()) {
				String name = driver.findElement(By.xpath(".//a[@class='account']/span")).getText();
				AssertJUnit.assertEquals(name, "sample test");
			}
			if(driver.findElement(By.linkText("Sign out")).isDisplayed()) {
				driver.findElement(By.linkText("Sign out")).click();
				String text = driver.findElement(By.className("page-heading")).getText();
				AssertJUnit.assertEquals(text,"AUTHENTICATION");
			}
		}
		
		
	
		@AfterMethod(description = "This test is to tidy up the driver")
		public void tearDown() {
			driver.close();
			driver.quit();
		}	

		
}
