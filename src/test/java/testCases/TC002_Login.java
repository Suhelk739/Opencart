package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;


public class TC002_Login extends BaseClass{
	
	
	@Test(groups ="Regression")
	public void login() {
		
		logger.info("******Login Started******");
		try {
		LandingPage lp=new LandingPage(driver);
		lp.accountClick();
		lp.loginClick();
		
	//Entering login details:
		LoginPage login=new LoginPage(driver);
		login.enter_username(p.getProperty("UN"));
		login.enter_password(p.getProperty("Pass"));
		login.login_click();
		
		//validating My account page
		MyaccountPage account=new MyaccountPage(driver);
		boolean display=account.myAccountDisplayed();
		Assert.assertTrue(display);
		logger.info("*******Login Success**********");
		}
		
		catch(Exception e) {
			logger.info("******Login failed*********");
			Assert.fail();
			
			
		}
		
	}
	
	

}
