package seleniumWebdriver.commands;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ActionClass {
	
	public static WebDriverWait wait;
	public static WebDriver driver;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	//maximise the window
	driver.manage().window().maximize();
	wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	
	
//	clickAndHoldAction(driver);
//	dragAndDropAction(driver, wait);
	
	//specify the URL of the webpage
	
	
	driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.id("btnLogin")).click();
	
	
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("welcome")));
	
	
	System.out.println(driver.findElement(By.id("welcome")).getText().split(" ")[0]);
	//verify the successful login
	assertEquals(driver.findElement(By.id("welcome")).getText().split(" ")[0], "Welcome");
	
	
//	moveToElementAction(driver);
	keyboardEventAction(driver);
	
	driver.close();
	driver.quit();
	}
	
	public static void moveToElementAction(WebDriver driver) {
		
		//create an object for the Actions class and pass the driver argument 
		Actions action = new Actions(driver);

		//specify the locator
		WebElement elementMenu = driver.findElement(By.id("menu_admin_viewAdminModule")); //admin
		WebElement elementSubMenu = driver.findElement(By.id("menu_admin_Qualifications")); //qualification
		WebElement elementSubSubMenu = driver.findElement(By.id("menu_admin_viewEducation")); //education
		
		
		
		action.moveToElement(elementMenu).build().perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_admin_Qualifications")));
		
		
		action.moveToElement(elementSubMenu).build().perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_admin_viewEducation")));
		
		
		elementSubSubMenu.click();
		System.out.println(driver.getCurrentUrl());
	}
	
	
	public void doubleClickAction(WebDriver driver) {
		//create an object for the Actions class and pass the driver argument 
		Actions action = new Actions(driver);

		//specify the locator
		WebElement elementMenu = driver.findElement(By.id("menu_recruitment_viewRecruitmentModule"));
		action.moveToElement(elementMenu).doubleClick();
		
		System.out.println(driver.getCurrentUrl());
	}
	
	public static void contextClickAction(WebDriver driver) {
		//create an object for the Actions class and pass the driver argument 
		Actions action = new Actions(driver);

		//specify the locator
		WebElement elementMenu = driver.findElement(By.id("menu_buzz_viewBuzz"));
		action.contextClick(elementMenu);
		
		System.out.println(driver.getCurrentUrl());
	}
	
	public static void dragAndDropAction(WebDriver driver, WebDriverWait wait) {
		driver.get("http://demo.guru99.com/test/drag_drop.html");					
        
		//Element which needs to drag.    		
        WebElement Bank=driver.findElement(By.xpath("//*[@id='credit2']/a"));	
         
         //Element on which need to drop.		
         WebElement debitAccount=driver.findElement(By.xpath("//*[@id='bank']/li"));					
         		
         //Using Action class for drag and drop.		
         Actions act=new Actions(driver);					

         //Dragged and dropped.		
         act.dragAndDrop(Bank, debitAccount).build().perform();
         
         //Element which needs to drag.    		
         List<WebElement> amount=driver.findElements(By.xpath("//*[@id='fourth']/a"));	
          
	     //Element on which need to drop.		
	     WebElement debitAmount=driver.findElement(By.xpath("//*[@id='amt7']/li"));
	     
	     //Dragged and dropped.		
         act.dragAndDrop(amount.get(0),debitAmount).build().perform();
         
        //Element which needs to drag.    		
         WebElement sales=driver.findElement(By.xpath("//*[@id='credit1']/a"));	
          
	     //Element on which need to drop.		
	     WebElement creditAccount=driver.findElement(By.xpath("//*[@id='loan']/li"));
	     
	     //Dragged and dropped.		
         act.dragAndDrop(sales, creditAccount).build().perform();
         
       //Element on which need to drop.		
	     WebElement creditAmount=driver.findElement(By.xpath("//*[@id='amt8']/li"));
	     
	     //Dragged and dropped.		
         act.dragAndDrop(amount.get(0),creditAmount).build().perform();
         
         wait.until(ExpectedConditions.presenceOfElementLocated(By.id("equal")));
         assertEquals(driver.findElement(By.xpath(".//*[@id='equal']/a[contains(.,'Perfect')]")).getText(), "Perfect!");
	     
	}
	
	public static void clickAndHoldAction(WebDriver driver) {
		
		String url = "https://selenium08.blogspot.com/2020/01/click-and-hold.html"; 
		driver.get(url); 

		// Locate the element C by By.xpath. 
		  WebElement titleC = driver.findElement(By.xpath("//li[text()= 'C']")); 
		// Create an object of actions class and pass reference of WebDriver as a parameter to its constructor. 
		   Actions actions = new Actions(driver); 
		// Move the cursor to the position of element C. 
		   actions.moveToElement(titleC); // Call clickAndHold() method to perform click and hold operation. 
		   actions.clickAndHold().perform(); 
	}
	
	public static void keyboardEventAction(WebDriver driver) {
		
		//specify the locator
		WebElement elementMenu = driver.findElement(By.id("menu_admin_viewAdminModule"));
		elementMenu.click();
		WebElement txtUsername = driver.findElement(By.id("searchSystemUser_userName"));

		
		Action seriesOfActions = new Actions(driver)
			.moveToElement(txtUsername)
			.click()
			.keyDown(txtUsername, Keys.SHIFT)
			.sendKeys(txtUsername, "hello")
			.keyUp(txtUsername, Keys.SHIFT)
			.build();
			
		seriesOfActions.perform() ;
	}
}
