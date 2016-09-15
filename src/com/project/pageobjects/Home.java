package com.project.pageobjects;

import java.util.List;
import org.apache.xpath.compiler.Keywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.project.util.KeyWords;

public class Home extends KeyWords {
	/* WEB ELEMENT LOCATORS */
	//static double pricevalue;
	//static long pricevalue;
	static By SearchKeyWord = By.id("search");
	static By ButtonKeyword = By.id("ysb-search-submit");
	static By ItemSelection = By.xpath("//img[contains(@src, 'my_image.png')]");
	static By Popup1_Dialog_ClasName = By.className(".js-applet-view-container-main");
	static By searchResult = By.cssSelector(".col-md-12.text-center.search-result"); //If there are any items found with given search string?
	static By searchResults = By.cssSelector(".text-center.product-text>strong>a");
	static By addTocart = By.cssSelector("#ysb-add-to-cart");
	static By checkout = By.cssSelector("#ysb-fc-checkout");
	static By reviewHeadline = By.cssSelector(".ysb-cart-heading.editable");
	static By close = By.cssSelector(".ysb-quickview-close");
	static By SearchImagesItems = By.xpath("//div[2]/div[2]/div/a/img");
	static By getItemPrice = By.cssSelector("#pdv-sale-price>span");
	static By getAddToCart_panel = By.cssSelector("#ysb-fc-checkout");

	/* METHODS DECLARATION */
	public static void searchProduct(String URL, String SearchText) throws InterruptedException {
		KeyWords.maximize();
		KeyWords.goTOURL(URL);
		KeyWords.input(SearchKeyWord, SearchText);
		KeyWords.clickOn(ButtonKeyword);
		Thread.sleep(3000);
		Assert.assertTrue(KeyWords.element(searchResult).isDisplayed());
	}

	public static void addToCartFromSearch(String SearchText, String AddToCartPanel_Text) throws InterruptedException {
		List<WebElement> items = driver.findElements(searchResults);
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).getText());
			System.out.println(SearchText);
			if (items.get(i).getText().equalsIgnoreCase(SearchText)) {
				items.get(i).click();
				System.out.println("Found the item" + i);
				break;
			}
		}
		String value = KeyWords.element(getItemPrice).getText();
		//pricevalue = Integer.parseInt(value);
		//pricevalue = Long.parseLong(value);
		//System.out.println(pricevalue);
		
		
		KeyWords.clickOn(addTocart);
		System.out.println("-- landed In ADDToCart page.");
		Thread.sleep(3000);
		// table any element to verify
		System.out.println(getAddToCart_panel);
		System.out.println(AddToCartPanel_Text);
		KeyWords.verifyText(getAddToCart_panel, AddToCartPanel_Text); 
		// REMOVE HARDCODE AND GET VALUE FROM EXCELHEET.
	}

	public static void checkout() {
		KeyWords.clickOn(checkout);
		// Assert.assertEquals(KeyWords.element(reviewHeadline).getText(),
		KeyWords.verifyText(reviewHeadline, "REVIEW YOUR CART");
	}

	public static void addToCardFromSearchMultiple(int number) throws InterruptedException {
		List<WebElement> items = driver.findElements(SearchImagesItems);
		for (int i = 0; i < number; i++) {
			items.get(i).click();
			Thread.sleep(2000);
			KeyWords.clickOn(close);
		}
	}
}
