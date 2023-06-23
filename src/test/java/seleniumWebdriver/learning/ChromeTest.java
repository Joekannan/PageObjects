package seleniumWebdriver.learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {
	
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/learning/BrowesrDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("application opened");

	}

}
