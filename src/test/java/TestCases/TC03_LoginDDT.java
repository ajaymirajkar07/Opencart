package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.myAccountPage;
import Utilities.DataProviders;
import testBase.BaseClass;

public class TC03_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class, groups="datadriven")
	public void verify_loginDDT(String email,String pwd,String exp) {
				logger.info("String TC_03LoginDDT****");
				
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
				
				
				/*Data is valid  - login success - test pass  - logout
				Data is valid -- login failed - test fail

				Data is invalid - login success - test fail  - logout
				Data is invalid -- login failed - test pass
				*/
				if(exp.equalsIgnoreCase("Valid")) {
					if(targetPage==true) {
						Assert.assertTrue(true);
						accp.clickLogout();
					}else {
						Assert.assertTrue(false);
					}
				}
				if(exp.equalsIgnoreCase("Invalid")) {
					if(targetPage==true) {
						accp.clickLogout();
						Assert.assertTrue(false);
					}else {
						Assert.assertTrue(true);
					}
				}
				}catch(Exception e) {
					Assert.fail();
				}
				
				logger.info("finished the test case");
	}
}
