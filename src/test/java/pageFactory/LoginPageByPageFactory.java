package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageByPageFactory {

	WebDriver driver; 
	
	
	@FindBy(linkText="Sign in")
    WebElement btnSignin; 
	
	@FindBy(id="email")
    WebElement txtEmail; 
	
	@FindBy(id="passwd")
    WebElement txtPwd; 
	
	@FindBy(id="SubmitLogin")
    WebElement btnLogin;
	
	@FindBy(xpath=".//a[@class='account']/span")
    WebElement lblUserName;
	
	@FindBy(className="page-heading")
    WebElement lblPageHeading;
	
	@FindBy(linkText="Sign out")
    WebElement btnSignOut;
	
	public LoginPageByPageFactory(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSingin() {
		btnSignin.click();
	}
	
	public void enterUsername() {
		txtEmail.sendKeys("sampletest@test.com");
	}
	
	public void enterPassword() {
		txtPwd.sendKeys("Test123");
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogOut() {
		btnSignOut.click();
	}
	public void validateLogin() {
		if(lblUserName.isDisplayed()) {
			String name = lblUserName.getText();
			Assert.assertEquals(name, "sample test");
		}
	}
	
	public void validateLogOut() {
		if(btnSignOut.isDisplayed()) {
			btnSignOut.click();
			String text = lblPageHeading.getText();
			Assert.assertEquals(text,"AUTHENTICATION");
		}
	}
	
	
}