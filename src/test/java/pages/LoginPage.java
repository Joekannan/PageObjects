package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver; 
	
	public By btnSignin = By.linkText("Sign in");
	public By txtEmail = By.id("email");
	public By txtPwd = By.id("passwd");
	public By btnLogin = By.id("SubmitLogin");
	public By lblUserName = By.xpath(".//a[@class='account']/span");
	public By lblPageHeading = By.className("page-heading");
	public By btnSignOut = By.linkText("Sign out");
	
	public LoginPage(WebDriver driver1) {
		driver = driver1;
	}
	
	public void clickSingin() {
		driver.findElement(btnSignin).click();
	}
	
	public void enterUsername() {
		driver.findElement(txtEmail).sendKeys("sampletest@test.com");
	}
	
	public void enterPassword() {
		driver.findElement(txtPwd).sendKeys("Test123");
	}
	
	public void clickLogin() {
		driver.findElement(btnLogin).click();
	}
	
	public void clickLogOut() {
		driver.findElement(btnSignOut).click();
	}
	public void validateLogin() {
		if(driver.findElement(lblUserName).isDisplayed()) {
			String name = driver.findElement(lblUserName).getText();
			Assert.assertEquals(name, "sample test");
		}
	}
	
	public void validateLogOut() {
		if(driver.findElement(btnSignOut).isDisplayed()) {
			driver.findElement(btnSignOut).click();
			String text = driver.findElement(lblPageHeading).getText();
			Assert.assertEquals(text,"AUTHENTICATION");
		}
	}
	
	
}