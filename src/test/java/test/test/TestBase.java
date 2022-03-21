package test.test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import com.applitools.eyes.selenium.Eyes;
import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	protected static WebDriver driver;
	protected static Eyes eyes;
	public static Properties prop;
	public Faker faker = new Faker();
	//LoginPage loginpageObject;
	public static FileInputStream fis;
	// soft assertion method
	protected SoftAssert softassert = new SoftAssert();



	// Initiate the Chrome browser
	@BeforeSuite
	public void openBrowser() throws InterruptedException, Exception {
		
		prop = new Properties();
		try {
			fis = new FileInputStream("resources\\test.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	   
	    driver.manage().window().maximize();
	    
		driver.get(prop.getProperty("url"));
		
		driver.manage().deleteAllCookies();
	
	}
	@BeforeMethod
	public void eee() {
		 initiEyes();
	}

	// Initiate Eye apptlitool for visual testing
	private static void initiEyes() {
		eyes = new Eyes();
		eyes.setApiKey(prop.getProperty("applitools.api.key"));

	}


	// validate window design and elements
	public void validateWindow() {
		eyes.open(driver, "Easy buy", Thread.currentThread().getStackTrace()[2].getMethodName());
		// get image for the whole screen
		eyes.setForceFullPageScreenshot(true);
		eyes.checkWindow();
		eyes.close();
	}

	// taking screenshot for failures
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			Screenshot.captureScreenshot(driver, result.getName());
		}
	}

	// close browser
	@AfterSuite
	public void quitBrowser() {
		driver.quit();
		eyes.abortIfNotClosed();
	}

}

