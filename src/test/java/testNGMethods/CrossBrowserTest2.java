package testNGMethods;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTest2 {
public WebDriver driver;

@Parameters({"browser"})
@BeforeTest
public void setup(String browser) {
	if(browser.equalsIgnoreCase("Chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	  	  	
	}
	if(browser.equalsIgnoreCase("Edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
	 
	}
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://dbankdemo.com/login");
		  driver.manage().window().maximize();
		     
}

	@Test
	public void loginandlogout() {
	  driver.findElement(By.id("username")).sendKeys("sample1test@testmail.com");
	  driver.findElement(By.id("password")).sendKeys("Test1234");
	  driver.findElement(By.id("submit")).click();
	  driver.findElement(By.xpath("//img[@alt='User Avatar']")).click();
	    driver.findElement(By.linkText("Logout")).click();
	  String result = driver.findElement(By.xpath("//*[text()='Success']")).getText();
	  System.out.println("The Logout message:" + result);
	 driver.close();
	 driver.quit();
	}
}
