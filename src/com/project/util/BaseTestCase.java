package com.project.util;

import java.util.Hashtable;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class BaseTestCase {
	public static Xls_Reader xls = new Xls_Reader("/Users/Admin/Documents/workspace/Selenium_PageObjectModel/TestData/TestData.xlsx");
	String tcase;

	public BaseTestCase(String tcase) {
		this.tcase = tcase;
	}

	@DataProvider
	public Object[][] getData() {
		return TestUtil.getData(xls, this.tcase);

	}
}