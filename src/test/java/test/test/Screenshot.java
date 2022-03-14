package test.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.github.javafaker.Faker;
import com.github.javafaker.File;

public class Screenshot {
	static String screenshotname="";
	static Path dest = Paths.get("./Screenshots",screenshotname+".png");
	public static void captureScreenshot(WebDriver driver , String screenshotname)  
	{
		 
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Excpetion while taking screenshot"+ e.getMessage());
		}
		
	}
	public static void CaptureFullScreen(WebDriver driver , String screenshotname) throws IOException {
		java.io.File source= ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
		org.openqa.selenium.io.FileHandler.copy(source, new java.io.File(dest.toString()));
	}
	public static void TakeElementScreenShot(WebDriver driver , String screenshotname,String Cssselector) throws IOException {
		WebElement elem=driver.findElement(By.cssSelector(Cssselector));
		java.io.File source=elem.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,  new java.io.File(dest.toString()));
		
	}

}
