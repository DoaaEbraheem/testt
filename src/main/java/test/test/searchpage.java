package test.test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class searchpage extends PageBase{

	public searchpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="employee_search")
	WebElement Searchbox;


	public void searchddd(String mobile) {
		setTextElementText(Searchbox, mobile);
		Searchbox.sendKeys(Keys.ENTER);
	}

}
