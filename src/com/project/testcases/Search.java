/*
 */

package com.project.testcases;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.project.pageobjects.Home;
import com.project.pageobjects.OrderConfirmation;
import com.project.pageobjects.Payment;
import com.project.pageobjects.ReviewYourCart;
import com.project.pageobjects.ShippingAndContact;
import com.project.util.BaseTestCase;
//import com.project.util.CustomeListener;
import com.project.util.KeyWords;

import java.io.IOException;
import java.util.Hashtable;

// @Listeners(CustomeListener.class) // WITHOUT THIS, I CAN'T GET SCREENNSHOTS.THIS HAS A METHOD WHICH CREATE SCREENSHOTS FOR ERRORS.
public class Search extends BaseTestCase{
	static final String TEST_CASE_NAME="Search";
	public Search()
	{
		super(TEST_CASE_NAME);
	}
@Test(dataProvider="getData")
public void Searchtestcase(Hashtable<String,String> data) throws InterruptedException, IOException {
	  //steps from page objects
	  KeyWords.openBrowser(data.get("BrowerName"));
	  Home.searchProduct(data.get("URL"), data.get("SearchText"));
	  Reporter.log("Successfully searched the required project");
	  Home.addToCartFromSearch(data.get("SearchText"), data.get("AddToCartPanel_Text"));
	  Home.checkout();
	  Thread.sleep(2000);
	  ReviewYourCart.checkout(data.get("SearchText"), data.get("ShippingPageHeading"));
	  ShippingAndContact.shipping(data.get("emailText"), data.get("firstName"), data.get("LastName"), data.get("addressText"), data.get("cityText"), data.get("statetText"), data.get("ziptext"), data.get("countryText"), data.get("phoneNumber"), data.get("methodText"),data.get("PaymentPageHeadline")); //
	  Thread.sleep(5000);
	  Payment.billingAddressVerifications(data.get("firstName"), data.get("LastName"), data.get("addressText"), data.get("cityText"), data.get("statetText"), data.get("ziptext"), data.get("countryText"), data.get("phoneNumber"));
	  Payment.paymentForCreaditCard(data.get("CradTypeText"), data.get("CardNumberText"), data.get("monthText"), data.get("yearText"), data.get("cvvText"));
      Thread.sleep(15000);
	  //OrderConfirmation.calculate_grandtotal(data.get("shippingmethod_price"), data.get("double tax"));
	  OrderConfirmation.orderVerifications(data.get("firstName"), data.get("addressText"), data.get("cityStateZip_Text"), data.get("grandtotal_Text"));
}

@AfterTest(alwaysRun = true)
public void tearDown() throws Exception {
	KeyWords.close();
	String verificationErrorString = KeyWords.verificationErrors.toString();
	if (!"".equals(verificationErrorString)) {
    throw new Exception(verificationErrorString);
  }
}

}