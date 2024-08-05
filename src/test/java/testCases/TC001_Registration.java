package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;
import pageObjects.LandingPage;
import pageObjects.RegistrationPage;

public class TC001_Registration extends BaseClass{
	
	
	@Test(groups = {"Sanity","Regression"})
	
	public void registration(){
		
		try {
		
		logger.info("******Registration is started********");
		
		LandingPage lg=new LandingPage(driver);
		lg.accountClick();
		lg.regClick();
		
		RegistrationPage regPage=new RegistrationPage(driver);
		regPage.firstName(randomName());
		regPage.lastName(randomLname());
		regPage.email(randomEmail()+"@gmail.com");
		regPage.number("7667656545");
		regPage.password(passWord());
		regPage.check_box();
		regPage.click_submit();
		if(regPage.confirm().equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
			
		}
		else{
			logger.error("Getting error...");
			logger.debug("Debug logs ....");
			Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(regPage.confirm(), "Your Account Has Been Created!");
		logger.info("*****Registration is completed********");

		}
		
		catch(Exception e) {
			Assert.fail();
		}
		
		


		
		
	}
	
	
	
	

}
