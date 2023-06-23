package seleniumWebdriver.commands;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementMethods {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://skryabin.com/webdriver/html/sample.html");	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Calendar 
		driver.findElement(By.id("dateOfBirth")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']")));
		
		Select month = new Select(driver.findElement(By.className("ui-datepicker-month")));
		month.selectByVisibleText("Jun");
		
		Select year = new Select(driver.findElement(By.className("ui-datepicker-year")));
		year.selectByVisibleText("1989");
		
		List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']"));
		int noOfDays = days.size();
		
		
		System.out.println("No of days - " + noOfDays);
		
		
		for(WebElement day : days) {
			day.click();
			System.out.println("Selected date is - " + day.getText());
			break;
		}
		
		
		//1. Find Element
		driver.findElement(By.id("name")).click();
		System.out.println("Name textbox clicked successfully");
		
		//2. send keys method 
		driver.findElement(By.id("firstName")).sendKeys("TestFirstName");
		System.out.println("first name got entered");
		//3. Clear Method
		driver.findElement(By.id("firstName")).clear();
		System.out.println("First name cleared");
		
		driver.findElement(By.id("firstName")).sendKeys("TestFirstName");
		System.out.println("first name got entered again");
		driver.findElement(By.id("middleName")).sendKeys("TestMiddleName");
		
		driver.findElement(By.id("lastName")).sendKeys("TestLastName");
		//4. Click Method - You can use .click() method to click on any button of software web application. Means element's type = "button" or type = "submit", .click() method will works for both.
		driver.findElement(By.xpath(".//button[contains(.,'Save')]")).click();
		
		
		
		
		
		
		WebElement countryDropDown = driver.findElement(By.name("countryOfOrigin")); 
		Select dropDown = new Select(countryDropDown);
		
		dropDown.selectByVisibleText("India");
		dropDown.selectByIndex(1); // austria
		dropDown.selectByValue("Japan");
		
		
		driver.findElement(By.name("address")).sendKeys("1/N3 Thendral Nagar 3rd Street"
				+ "NSNPalayam"
				+ "Coimbatore");
		
		driver.findElement(By.name("username")).sendKeys("Nova Testers");
		driver.findElement(By.name("password")).sendKeys("Test123");
		driver.findElement(By.name("phone")).sendKeys("+91 7373091234");
		
		
		
		
		//5. find elements
		List<WebElement> gender = driver.findElements(By.name("gender"));
		System.out.println("No of gender elements " + gender.size());
		
		//6. Get Attribute
		System.out.println("First radio button value is "+gender.get(0).getAttribute("value"));
		System.out.println("Second radio button value is "+gender.get(1).getAttribute("value"));
		
		gender.get(1).click();
		
		
		//7. getCssValue - CSS = cascading style sheet
		String backgroundColor = driver.findElement(By.name("carMake")).getCssValue("background-color");
		System.out.println("css value - background color is - " + backgroundColor);
		String fontSize = driver.findElement(By.name("carMake")).getCssValue("font-size");
		System.out.println("css value - font size is - " + fontSize);
		
		//8. get location
		Point location = driver.findElement(By.name("carMake")).getLocation();
		System.out.println("Location of Car Make element is - " + location);
		
		//9. getRect method
		Rectangle rect = driver.findElement(By.name("carMake")).getRect();
		System.out.println("Heigth of the element is - " + rect.getHeight());
		System.out.println("Width of the element is - " + rect.getWidth());
		System.out.println("Location of the element is - " + rect.getPoint());
		
		//10. getSize method
		Dimension elementSize = driver.findElement(By.name("carMake")).getSize();
		System.out.println("Size of the element is - " + elementSize);
		
		//11.getTagName method
		String tagName = driver.findElement(By.name("carMake")).getTagName();
		System.out.println("Tag Name of the car make element is - " + tagName);
		
		//12. getText Method
		String text = driver.findElement(By.name("username")).getText();
		System.out.println("Text of the user name element is - " + text);
		
		//13. isDisplayed - similar to css value "style"
		boolean blnDisplayed = driver.findElement(By.name("username")).isDisplayed();
		System.out.println("Is Username field displayed - "+ blnDisplayed);
		
		//14. isEnabled method - returns either enabled or disabled
		boolean blnEnabled = driver.findElement(By.name("username")).isEnabled();
		System.out.println("Is Username field enabled - "+ blnEnabled);
		
		//15.isSelected method
		boolean blnSelected = driver.findElement(By.name("allowedToContact")).isSelected();
		System.out.println("Is checkbox field selected - "+ blnSelected);
		
		driver.findElement(By.name("email")).sendKeys("testsample@test.com");
		driver.findElement(By.name("confirmPassword")).sendKeys("Test123");
		
		driver.findElement(By.name("agreedToPrivacyPolicy")).click();
		
		//16. submit method - It's type will be "submit". In this case, .submit() method Is very good alternative of .click() method.
		driver.findElement(By.name("formSubmit")).submit();
		
		driver.close();
		driver.quit();
	}

}
