package seleniumWebdriver.learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstChromeTest {

	static WebDriver driver;
	
	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "src/test/resource/Driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.countdown.co.nz/");
		System.out.println("Application launched");
		driver.close();
		driver.quit();
		
		
	}

}
