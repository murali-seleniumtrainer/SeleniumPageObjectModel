package com.project.util;

import java.io.PrintStream;
import java.util.Hashtable;

public class TestUtil {
	public static String dataSheet = "Test Data";

	public TestUtil() {
	}

	public static Object[][] getData(Xls_Reader xls, String testCase) {
		int totalRows = xls.getRowCount(dataSheet);
		int testStartRowNum = 0;
		for (int rNum = 1; rNum < totalRows; rNum++) {
			if (!xls.getCellData(dataSheet, 0, rNum).equals(testCase))
				continue;
			testStartRowNum = rNum;
			break;
		}
		int dataStartRowNum = testStartRowNum + 2;
		int colStartRowNum = testStartRowNum + 1;
		int totalCols;

		for (totalCols = 0; !xls.getCellData(dataSheet, totalCols, colStartRowNum).equals(""); totalCols++)
			;
		// System.out.println((new StringBuilder("Test
		// ")).append(testCase).append(" has ").append(totalCols).append("
		// columns ").toString());
		int totalTestRows;
		for (totalTestRows = 0; !xls.getCellData(dataSheet, 0, dataStartRowNum + totalTestRows)
				.equals(""); totalTestRows++)
			;
		// System.out.println((new StringBuilder("Test
		// ")).append(testCase).append(" has ").append(totalTestRows).append("
		// rows ").toString());
		Object testData[][] = new Object[totalTestRows][1];
		Hashtable<String, String> table = null;
		int x = 0;
		for (int rNum = dataStartRowNum; rNum < dataStartRowNum + totalTestRows; rNum++) {
			table = new Hashtable<String, String>();
			for (int cNum = 0; cNum < totalCols; cNum++) {
				String data = xls.getCellData(dataSheet, cNum, rNum);
				System.out.print((new StringBuilder(String.valueOf(data))).append(" -- ").toString());
				table.put(xls.getCellData(dataSheet, cNum, colStartRowNum), data);
			}

			testData[x][0] = table;
			x++;
		}

		return testData;
	}

	public static boolean isExecutable(Xls_Reader xls, String testCase) {
		int totalRows = xls.getRowCount("Test Cases");
		for (int rNum = 2; rNum <= totalRows; rNum++)
			if (xls.getCellData("Test Cases", "TCID", rNum).equals(testCase))
				return xls.getCellData("Test Cases", "Runmode", rNum).equals("Y");

		return false;
	}
}