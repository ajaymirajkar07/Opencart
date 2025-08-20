package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.myAccountPage;
import testBase.BaseClass;

public class TC02_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity", "Master"})
	public void verify_login() {
		
		logger.info("starting tc_02_loginTest");
		try {
		//homepage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//loginpage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//myaccountpage
		myAccountPage accp=new myAccountPage(driver);
		boolean targetPage=accp.isMyAccountExist();
		Assert.assertEquals(targetPage, true,"Login Failed");
		} catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("completed the test case");
	}
	
	
}	
