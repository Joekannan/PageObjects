package seleniumWebdriver.learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstIETest {
	public static void main(String[] args) {
		WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://www.google.com");
		System.out.println("browser opened");
		driver.close();
		driver.quit();
	}
}
