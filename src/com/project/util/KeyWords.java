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
	
	/**
	 * To Start driver or required browser
	 * pars: browser type parameter required
	 * @author mk
	 *
	 */
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

	/**
	 * To navigate to URL
	 * pars: URL to navigate parameter required
	 * @author mk
	 *
	 */
	public static void goTOURL(String url) {
		driver.get(url);
	}

	/**
	 * To click on web element
	 * pars: required element location parameter
	 * @author mk
	 *
	 */
	public static void clickOn(By object) {

		new WebDriverWait(driver, maxwait).until(ExpectedConditions.visibilityOfElementLocated(object));
		driver.findElement(object).click();
	}

	/**
	 * To check check box is selected or not
	 * pars: check box element location is required
	 * return boolen value pass or fail exp: pass if check box is already selected
	 * @author mk
	 *
	 */
	public static boolean isSelectedCheckBox(By object) {
		
		new WebDriverWait(driver, maxwait).until(ExpectedConditions.visibilityOfElementLocated(object));
		return driver.findElement(object).isSelected();

	}
	
	/**
	 * To enter text or input in input field
	 * pars: input filed location and test data to enter parameters are required
	 * @author mk
	 *
	 */
	public static void input(By object, String testdata) {
		new WebDriverWait(driver, maxwait).until(ExpectedConditions.visibilityOfElementLocated(object));
		driver.findElement(object).sendKeys(testdata);
	}

	/**
	 * To get required web element
	 * pars: required element location
	 * returns web element
	 * @author mk
	 *
	 */
	public static WebElement element(By object) {
		new WebDriverWait(driver, maxwait).until(ExpectedConditions.visibilityOfElementLocated(object));
		return driver.findElement(object);
	}

	/**
	 * To maximize the browser
	 * @author mk
	 *
	 */
	public static void maximize() {
		driver.manage().window().maximize();
	}

	/**
	 * To quite the selenium.
	 * all the browsers opened by selenium or driver will be closed
	 * @author mk
	 *
	 */
	public static void close() {	
			driver.quit();
	}
	
	/**
	 * To get the selected option in drop down or select drop down or combo box
	 * pars: location of dropdown
	 * returns selected text in dropdown
	 * @author mk
	 *
	 */
	public static String selectedText(By object){
		
		return new Select(element(object)).getFirstSelectedOption().getText();
				
	}
	
	/**
	 * To get the screenshot of the page
	 * pars: name for the screen
	 * takes screenshot and saved in Screenshots folder
	 * @author mk
	 *
	 */
	public static void takeScreenshot(String name) throws IOException{
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Users/Admin/Documents/workspace/Selenium_PageObjectModel/Screenshots/"+name+"_"+System.currentTimeMillis()));
	}
	
	/**
	 * To verify the text in web page
	 * pars: location element to verify text and expected text
	 * if assertion fails it will take screenshot and continue to next step
	 * @author mk
	 *
	 */
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
