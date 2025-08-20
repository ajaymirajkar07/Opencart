package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage extends BasePage {

	public myAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement lnkLogout;
	
	public boolean isMyAccountExist() {
		try {
			return (msgHeading.isDisplayed());
		}catch(Exception e){
			return false;
		}
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
}
