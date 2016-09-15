package com.project.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.project.util.KeyWords;

public class ShippingAndContact extends KeyWords{
	static By email=By.cssSelector("#ysb-co-email");
	static By fname=By.cssSelector("#ysb-co-ship-first-name");
	static By lname=By.cssSelector("#ysb-co-ship-last-name");
	static By address1=By.cssSelector("#ysb-co-ship-address1");
	static By city=By.cssSelector("#ysb-co-ship-city");
	static By state=By.cssSelector("#ysb-co-ship-state");
	static By zip=By.cssSelector("#ysb-co-ship-zip");
	static By country=By.cssSelector("#ysb-co-ship-country");
	static By phone=By.cssSelector("#ysb-co-ship-phone");
	static By method=By.cssSelector("#ysb-co-ship-method");
	static By checkout_Button=By.cssSelector("#ysb-co-shipping-details-next");
	static By checkoutItem=By.cssSelector(".product-detail > div > div >  a"); // it was changed.
	static By paymentPageHeading=By.cssSelector("#payment-header");
	
	
	
	public static void shipping(String emailText, String firstName, String LastName, String addressText, String cityText,
						String statetText, String ziptext, String countryText, String phoneNumber, String methodText, String PaymentPageHeadline) throws InterruptedException{
		KeyWords.input(email, emailText);
		Thread.sleep(1000);
		KeyWords.input(fname, firstName);
		Thread.sleep(1000);
		KeyWords.input(lname, LastName);
		Thread.sleep(1000);
		KeyWords.input(address1, addressText);
		Thread.sleep(1000);
		KeyWords.input(city, cityText);
		Thread.sleep(3000);
		KeyWords.input(state, statetText);
		Thread.sleep(1000);
		KeyWords.input(zip, ziptext);
		Thread.sleep(1000);
		KeyWords.input(country, countryText);
		Thread.sleep(3000);
		KeyWords.input(phone, phoneNumber);
		Thread.sleep(1000);
		KeyWords.input(method, methodText);
		Thread.sleep(3000);
		KeyWords.clickOn(checkout_Button);	
		KeyWords.verifyText(paymentPageHeading, PaymentPageHeadline); //4: confirm if checkoutItemITSNOT CORRECT locator value? 
}
}
