package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	
	//construcor
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators:
	@FindBy(xpath="//input[@id='input-email']") WebElement username;
	@FindBy(xpath="//input[@id='input-password']") WebElement Pass;
	@FindBy(xpath="//input[@value='Login']") WebElement btnLogin;
	@FindBy(linkText = "Login") WebElement login_link;
	
	
	//Action Methods
	
	public void enter_username(String Username) {
		username.sendKeys(Username);
	}
	
	public void enter_password(String pass) {
		Pass.sendKeys(pass);
		
	}
	
	public void login_click() {
		btnLogin.click();
	}
	public void login_link_click() {
		login_link.click();
	}
	

}
