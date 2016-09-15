package com.project.pageobjects;
import java.util.List;

import org.apache.xpath.compiler.Keywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.project.util.KeyWords;

public class ReviewYourCart extends Keywords{
    
	//static By checkoutItem=By.cssSelector(".product-detail > div > a"); // fixed it.
	static By checkoutButton=By.cssSelector("#ysb-cart-checkout-button");
	//static By checkoutButton=By.cssSelector("#ysb-fc-checkout");
	static By ItemsPanel_InCart = By.cssSelector("#ysb-floating-cart-items");
	static By searchResults=By.cssSelector(".text-center.product-text>strong>a");  // Items displayed in Search Results Panel/Div
	static By addTocart=By.cssSelector("#ysb-add-to-cart");
	//static By getShoppingPageHeading = By.cssSelector("ysb-cart-heading default-margin-left");
	static By getShoppingPageHeading = By.cssSelector("#ysb-co-ship-header");
	
	public static void checkout(String searchText, String ShippingPageHeading){	
		KeyWords.clickOn(checkoutButton);		
		System.out.println("Function pass");
		//KeyWords.verifyText(checkoutItem, " get payment headline/label"); // 3: Change Checkoutitem to your desired webelement (SHIPPING PAGE) which you want to verify in the following page.
		KeyWords.verifyText(getShoppingPageHeading,  ShippingPageHeading);
	}
	

//	public static void addToCardFromSearch(String SearchText){
//		List<WebElement> items=driver.findElements(searchResults);
//		for(int i=0; i<items.size(); i++){
//			System.out.println(items.get(i).getText());
//			System.out.println(SearchText);
//			if(items.get(i).getText().equalsIgnoreCase(SearchText)){
//				items.get(i).click();
//				System.out.println("Found the item"+i);
//				break;
//			}
//		}
//		
//		KeyWords.clickOn(addTocart);	
//	}
}
