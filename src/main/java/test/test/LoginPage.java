package test.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="InputEmail")
	WebElement emailtxt;
	
	@FindBy(id="inputPassword")
	WebElement psswdtxt;
	
	
	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	WebElement loginbtn;
	
	@FindBy(xpath  = "/html/body/div[2]/section/div/section/div/div[2]/div/div[1]/form/a")
	WebElement forgtpssbtn;
	
	public void loginAsAdmin(String email, String password)  {
		setTextElementText(emailtxt, email);
		setTextElementText(psswdtxt, password);
	
		clickButton(loginbtn);
	

	}
	public void forgetpassword() {
		clickButton(loginbtn);
	}

}
