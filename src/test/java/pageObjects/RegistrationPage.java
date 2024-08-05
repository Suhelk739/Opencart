package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage extends BasePage{
	
	public RegistrationPage(WebDriver driver){
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//input[@id='input-firstname']") WebElement first_name;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement last_name;
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement phone_num;
	@FindBy(xpath="//input[@id='input-password']") WebElement Pass;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement confirmPass;
	@FindBy(xpath="//input[@value='Continue']") WebElement click_btn;
	@FindBy(xpath="//input[@name='agree']") WebElement checck;
	@FindBy(how=How.XPATH, using ="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirn_screen;
	
	//Action methods
	public void firstName(String Fname) {
		first_name.sendKeys(Fname);
	}
	public void lastName(String Lname) {
		last_name.sendKeys(Lname);
		
	}
	
	public void email(String Email) {
		email.sendKeys(Email);
	}
	
	public void number(String Number) {
		phone_num.sendKeys(Number);
		
	}
	
	public void password(String Password){
		Pass.sendKeys(Password);
		confirmPass.sendKeys(Password);
		
	
	}
	public void check_box() {
		checck.click();
	}
	
	public void click_submit() {
		click_btn.click();
	}
	
	public String confirm() {
		String conf=confirn_screen.getText();
		return conf;
	}

	
	
	

}
