package seleniumWebdriver.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMethods {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.navigate().to("https://phptravels.org/index.php?rp=/login");
		
		System.out.println("Navigated to the given URL successfully");
		
		driver.findElement(By.linkText("Forgot Password?")).click();
		
		String title = driver.getTitle();
		
		System.out.println("successfully navigated to contact us page. Current page title is - " + title);
		
		driver.navigate().back();
		
		String title1 = driver.getTitle();
		
		System.out.println("successfully navigated to Home page. The current page title is - " + title1);
		
		driver.navigate().forward();
		
		String title11 = driver.getTitle();
		
		System.out.println("successfully navigated to contact us page again. The current page title is -" + title11);
		
		driver.close();
		
		driver.quit();
		
	}

}
