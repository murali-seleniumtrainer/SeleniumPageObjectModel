package com.project.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.project.util.KeyWords;
public class Payment {
	static By paymentType=By.cssSelector("#credit-payment > a > span");
	static By cardType=By.cssSelector("#ysb-co-bill-card-type");
	static By cardNumber=By.cssSelector("#ysb-co-bill-card-number");
	static By month=By.cssSelector("#ysb-co-bill-card-month");
	static By year=By.cssSelector("#ysb-co-bill-card-year");
	static By cvv=By.cssSelector("#ysb-co-bill-card-cvv");
	static By placeorder_button=By.cssSelector("#ysb-co-place-order");
	
	static By fname=By.cssSelector("#ysb-co-bill-first-name");
	static By lname=By.cssSelector("#ysb-co-bill-last-name");
	static By address1=By.cssSelector("#ysb-co-bill-address1");
	static By city=By.cssSelector("#ysb-co-bill-city");
	static By state=By.cssSelector("#ysb-co-bill-state");
	static By zip=By.cssSelector("#ysb-co-bill-zip");
	static By country=By.cssSelector("#ysb-co-bill-country");
	static By phone=By.cssSelector("#ysb-co-bill-phone");
	static By checkbox_Foraddress=By.cssSelector("#ysb-co-bill-use-ship-address");
	
	public static void paymentForCreaditCard(String CradTypeText, String CardNumberText, String monthText, String yearText, String cvvText){		
		KeyWords.clickOn(paymentType);
		KeyWords.input(cardType, CradTypeText);
		KeyWords.input(cardNumber, CardNumberText);
		KeyWords.input(month, monthText);
		KeyWords.input(year, yearText);
		KeyWords.input(cvv, cvvText);
		KeyWords.clickOn(placeorder_button);
	}
	public static void billingAddressVerifications(String FirstNameText, String LastNameText, String address1Text, String cityText, String stateText, String zipcodeText, String countryText, String phoneNumberText){
		System.out.println("1:Is checkbox checked : "+ KeyWords.isSelectedCheckBox(checkbox_Foraddress));
		System.out.println("2:Input TestData for Firstname is :" + FirstNameText + "Firstname webelement value is: "+ KeyWords.element(fname).getText());
		System.out.println("3:Input TestData for Lastname is :" + LastNameText + "Lastname webelement value is: "+ KeyWords.element(lname).getText());
		System.out.println("4:Input TestData for Address1 is :" + address1Text + "Address1 webelement value is: "+ KeyWords.element(address1).getText());
		System.out.println("5:Input TestData for CityText is :" + cityText + "CityText webelement value is: "+ KeyWords.element(city).getText());
		System.out.println("6:Input TestData for StateText is :" + stateText + "StateText webelement value is: "+ KeyWords.element(state).getText());
		System.out.println("7:Input TestData for Zipcode is :" + zipcodeText + "Zipcode webelement value is: "+ KeyWords.element(zip).getText());
		System.out.println("8:Input TestData for PhoneNumber is :" + phoneNumberText + "PhoneNumber webelement value is: "+ KeyWords.element(phone).getText());
		System.out.println("9: value from webpage is:   "+ KeyWords.selectedText(country)); // there is an error here, fix it
		
		Assert.assertTrue(KeyWords.isSelectedCheckBox(checkbox_Foraddress));
		KeyWords.verifyText(fname, FirstNameText);
		KeyWords.verifyText(lname, LastNameText);
		KeyWords.verifyText(address1, address1Text);
		KeyWords.verifyText(city, cityText);
		KeyWords.verifyText(state, stateText);
		KeyWords.verifyText(zip, zipcodeText);
		KeyWords.verifySelectedText(KeyWords.selectedText(country), countryText);
		KeyWords.verifyText(phone, phoneNumberText);
}
}
