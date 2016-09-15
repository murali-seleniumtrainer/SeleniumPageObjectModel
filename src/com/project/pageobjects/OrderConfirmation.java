package com.project.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.project.util.KeyWords;

public class OrderConfirmation extends Home{

	static By orderNumber = By.xpath("//h3/strong[1]");
	static By fname = By.xpath("//div/ul/li[1]");
	static By address = By.xpath("//div/ul/li[2]");
	static By cityStateZip = By.xpath("//div/ul/li[4]");
	static By grandtotal = By.xpath("//div[3]/strong");
	static By ItemDetails_Price = By.xpath("//div[@id='_product-detail']//div[@id='_price']");
	

	public static void orderVerifications(String firstNameText, String address_Text, String cityStateZip_Text,
			String grandtotal_Text) {
		String order = KeyWords.element(orderNumber).getText();
		System.out.println("1: value from webpage is:  " + KeyWords.element(fname).getText() + "My value is: ");
		System.out.println("2: value from webpage is:   " + KeyWords.element(address).getText());
		System.out.println("3: value from webpage is:   " + KeyWords.element(cityStateZip).getText());
		System.out.println("4: value from webpage is:   " + KeyWords.element(grandtotal).getText());

		Assert.assertTrue(order.startsWith("[#][a-zA-Z][0-9]{3}")); //#T403, #ROOOO, #KB
		/*KeyWords.verifyText(fname, firstNameText);
		KeyWords.verifyText(address, address_Text);
		KeyWords.verifyText(cityStateZip, cityStateZip_Text); 
		KeyWords.verifyText(grandtotal, calculate_grandtotal(shippingmethod_price, tax)); */ //5: Get locator values for tax
}

	 /* public static String calculate_grandtotal(double shippingmethod_price, double tax) {
		double GrandTotal = Home.pricevalue + shippingmethod_price + tax;
		return String.valueOf(GrandTotal); 
	} */
}
