package seleniumWebdriver.commands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserMethods {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.alertdriving.co.nz/test-tips/saturn-pl-albany-driving-test-tip-for-restricted-and-full");
		
		System.out.println("Application under test opened successfully.");
		
		String url = driver.getCurrentUrl();
		
		System.out.println("Current URL of the application is " + url);
		
		String title = driver.getTitle();
		
		System.out.println("Current Title of the application is " + title);
	
		String pageSource = driver.getPageSource();
		
		System.out.println("Application's pageSource is " + pageSource);
		
		driver.close();
		System.out.println("Browser is closed successfully.");
		
		driver.quit();
		System.out.println("Browser instance is quitted successfully.");
		
		
		
		
	
	}

}
