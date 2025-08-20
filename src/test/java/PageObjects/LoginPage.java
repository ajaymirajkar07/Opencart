package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;
	
	public void setEmail(String email) {
		emailAddress.sendKeys(email);
	}
	
	public void setPassword(String password) {
		txtpassword.sendKeys(password);
	}
	
	public void clickLogin() {
		loginbtn.click();
	}
	
}	
