package testNGMethods;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class BeforeAfterTest {
	
	public WebDriver driver;
	
	@BeforeMethod
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php?");
	}
	
	@Test
	public void verifyLoginAndLogout() {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email")).sendKeys("sampletest@test.com");
		driver.findElement(By.id("passwd")).sendKeys("Test123");
		driver.findElement(By.id("SubmitLogin")).click();
		driver.findElement(By.linkText("Sign out")).click();
		String text = driver.findElement(By.className("page-heading")).getText();
		AssertJUnit.assertEquals(text,"AUTHENTICATION");
	}
	
	@AfterMethod
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}	

}
