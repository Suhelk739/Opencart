package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import utilities.Data;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider = "LoginData", dataProviderClass = Data.class )
	public void loginDDT(String UN, String Pass, String exp_result) { 
		
		
		LandingPage lp=new LandingPage(driver);
		lp.accountClick();
		lp.loginClick();
		//Entering UN and pass:
		LoginPage login=new LoginPage(driver);
		login.enter_username(UN);
		login.enter_password(Pass);
		login.login_click();
		//to validate after login
		MyaccountPage account=new MyaccountPage(driver);
		boolean result=account.myAccountDisplayed();
		
		if(exp_result.equalsIgnoreCase("valid")) {
			if(result==true) {
				account.logout();
				login.login_link_click();
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertTrue(false);
			}
		
			
		}
		else if(exp_result.equalsIgnoreCase("invalid")) {
			if(result==true) {
				account.logout();
				login.login_link_click();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
			
		}
		
		
		
		
		
	}

}
