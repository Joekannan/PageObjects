package seleniumWebdriver.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorInteractionTest {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://skryabin.com/webdriver/html/sample.html");
		driver.findElement(By.id("name")).click();
		
		driver.findElement(By.id("firstName")).click();
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys("TestFirstName");
		
		driver.findElement(By.id("middleName")).click();
		driver.findElement(By.id("middleName")).clear();
		driver.findElement(By.id("middleName")).sendKeys("TestMiddleName");
		
		driver.findElement(By.id("lastName")).click();
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys("TestLastName");

		driver.findElement(By.xpath(".//button[contains(.,'Save')]")).click();
		
		WebElement countryDropDown = driver.findElement(By.name("countryOfOrigin"));   
		Select dropDown = new Select(countryDropDown);
		dropDown.selectByVisibleText("India");
		
		driver.findElement(By.name("address")).sendKeys("1/N3 Thendral Nagar 3rd Street"
				+ "NSNPalayam"
				+ "Coimbatore");
		
		driver.findElement(By.name("username")).sendKeys("Testers");
		driver.findElement(By.name("password")).sendKeys("Test123");
		driver.findElement(By.name("phone")).sendKeys("+91 7373091234");
		
		driver.findElement(By.name("gender")).click();
		
		System.out.println("browser opened");
		driver.close();
		driver.quit();
	}
}
