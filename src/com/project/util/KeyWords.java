package com.project.util;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.xml.dtm.ref.ExpandedNameTable;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.thoughtworks.selenium.condition.Presence;

public class KeyWords {
	public static WebDriver driver;
	
	static int maxwait=30;

	public static StringBuffer verificationErrors = new StringBuffer();

	public static void openBrowser(String browserType) {
		if (browserType.equals("Mozilla")) {
			System.setProperty("webdriver.firefox.bin", "/Users/Admin/Documents/workspace/Selenium_PageObjectModel/lib/Firefox");
			driver = new FirefoxDriver();
		} else if (browserType.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/appledev/Documents/PageObjectModel/lib/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserType.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "/Users/Admin/Documents/workspace/Selenium_PageObjectModel/lib/chromedriver.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
	}

	public static void goTOURL(String url) {
		driver.get(url);
	}

	public static void clickOn(By object) {

		new WebDriverWait(driver, maxwait).until(ExpectedConditions.visibilityOfElementLocated(object));
		driver.findElement(object).click();
	}

	public static boolean isSelectedCheckBox(By object) {
		
		new WebDriverWait(driver, maxwait).until(ExpectedConditions.visibilityOfElementLocated(object));
		return driver.findElement(object).isSelected();

	}

	public static void input(By object, String testdata) {
		new WebDriverWait(driver, maxwait).until(ExpectedConditions.visibilityOfElementLocated(object));
		driver.findElement(object).sendKeys(testdata);
	}

	public static WebElement element(By object) {
		new WebDriverWait(driver, maxwait).until(ExpectedConditions.visibilityOfElementLocated(object));
		return driver.findElement(object);
	}

	public static void maximize() {
		driver.manage().window().maximize();
	}

	// Using Xpath locator: Click on HTML element.
	public static void close() {	
			driver.quit();
}
	public static String selectedText(By object){
		
		return new Select(element(object)).getFirstSelectedOption().getText();
				
	}
	
	public static void takeScreenshot(String name) throws IOException{
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Users/Admin/Documents/workspace/Selenium_PageObjectModel/Screenshots/"+name+"_"+System.currentTimeMillis()));
	}
	
	public static void verifyText(By object, String expectedText){
		
		try {
		    Assert.assertEquals(driver.findElement(object).getText(), expectedText);
		   } catch (Error e) {
		     verificationErrors.append(e.toString());
		     try {
				takeScreenshot("TextVerificationError");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   }

	}
	
	public static void verifySelectedText(String Actual, String expectedText){
		
		try {
		    Assert.assertEquals(Actual, expectedText);
		   } catch (Error e) {
		     verificationErrors.append(e.toString());
		     try {
				takeScreenshot("TextVerificationError");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   }

	}
}