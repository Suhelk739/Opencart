package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends BasePage {
	
	//Locators
	public MyaccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement Myaccount;
	@FindBy(linkText = "Logout") WebElement logout;
	
	//Action methods
	
	public boolean myAccountDisplayed(){
		try {
		return Myaccount.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}

	}
	
	public void logout() {
		logout.click();
	}
	
	

}
