package testNGMethods;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTestByClass2 {
	
public WebDriver driver;
	
	
	@BeforeClass(description="This test is to set up the browser")
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php?");
	}
	
	@Test(description = "This test is to registration")
	public void registration() {
		
		System.out.println("thread id is - " + Thread.currentThread().getId());
	    driver.findElement(By.linkText("Sign in")).click();
	    driver.findElement(By.id("email_create")).click();
	    driver.findElement(By.id("email_create")).sendKeys("sampletest"+RandomUtils.nextInt()+"@test.com");
	    driver.findElement(By.cssSelector("#SubmitCreate > span")).click();
	    driver.findElement(By.id("id_gender1")).click();
	    driver.findElement(By.id("customer_firstname")).click();
	    driver.findElement(By.id("customer_firstname")).sendKeys("sample");
	    driver.findElement(By.id("customer_lastname")).click();
	    driver.findElement(By.id("customer_lastname")).sendKeys("test");
	    driver.findElement(By.id("passwd")).click();
	    driver.findElement(By.id("passwd")).click();
	    driver.findElement(By.id("passwd")).sendKeys("Test123");

	      WebElement dropdown = driver.findElement(By.id("days"));
	      Select date = new Select(dropdown);
	      date.selectByValue("16");
	
	      WebElement dropdown1 = driver.findElement(By.id("months"));
	      Select month = new Select(dropdown1);
	      month.selectByValue("12");
	  
	      WebElement dropdown2 = driver.findElement(By.id("years"));
	      Select year = new Select(dropdown2);
	      year.selectByValue("2001");
	      
	    driver.findElement(By.id("address1")).click();
	    driver.findElement(By.id("address1")).sendKeys("123 test address");
	    driver.findElement(By.id("city")).click();
	    driver.findElement(By.id("city")).sendKeys("test city");
	      WebElement dropdown3 = driver.findElement(By.id("id_state"));
	      Select state = new Select(dropdown3);
	      state.selectByVisibleText("Idaho");
	    driver.findElement(By.id("postcode")).click();
	    driver.findElement(By.id("postcode")).sendKeys("12345");
	    driver.findElement(By.id("other")).click();
	    driver.findElement(By.id("other")).sendKeys("test comments");
	    driver.findElement(By.id("phone")).click();
	    driver.findElement(By.id("phone")).sendKeys("123456789");
	    driver.findElement(By.id("phone_mobile")).click();
	    driver.findElement(By.id("phone_mobile")).sendKeys("0278945612");
	    driver.findElement(By.id("alias")).click();
	    driver.findElement(By.id("alias")).sendKeys("a.b@gmail.com");
	    driver.findElement(By.id("address1")).click();
	    driver.findElement(By.id("passwd")).click();
	    driver.findElement(By.id("passwd")).sendKeys("Test123");
	    driver.findElement(By.cssSelector("#submitAccount > span")).click();driver.findElement(By.linkText("Sign out")).click();
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	      wait.until(ExpectedConditions.textToBe(By.cssSelector(".page-heading"), "AUTHENTICATION"));
	    }
	    String text = driver.findElement(By.className("page-heading")).getText();
		AssertJUnit.assertEquals(text,"AUTHENTICATION");
	}
	
	@Test
	public void testme() {
		System.out.println("thread id is - " + Thread.currentThread().getId());
		System.out.println("I am test me");
	}
	
	@Test
	public void testyou() {
		System.out.println("thread id is - " + Thread.currentThread().getId());
		System.out.println("I am test you");
	}
	
	@AfterClass(description = "This test is to tidy up the driver")
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
