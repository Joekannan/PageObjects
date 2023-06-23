package seleniumWebdriver.learning;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import io.github.bonigarcia.wdm.WebDriverManager;


public class FirstFFTest {

	public static void main(String[] args) {
//		System.setProperty("webdriver.gekco.driver", ".\\Driver\\geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("test");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		System.out.println("browser opened");
		driver.close();
		driver.quit();
	}


}
