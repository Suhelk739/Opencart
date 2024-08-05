package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {
	
	//Contructor
	public LandingPage(WebDriver driver){
		super(driver);
		
	}
	
	//Locators
	@FindBy(xpath="//a[@title='My Account']")
	WebElement myact_link;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement registration_link;
	@FindBy(xpath="(//a[normalize-space()='Login'])[1]")
	WebElement Login;
	
	
	//Action methods
	
	public void accountClick() {
		myact_link.click();
	}
	public void regClick() {
		
		registration_link.click();
		
	}
	public void loginClick() {
		Login.click();
	}

	
	

}
