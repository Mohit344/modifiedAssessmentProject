package com.atmecs.qa.validation;

import org.testng.Assert;

public class ValidationMethod {

	/**
	 * 
	 * @param texts
	 * @param expected
	 * @param message
	 */
	public void verify(Object texts, String expected, String message) { // String or objects depend
		try {

			Assert.assertEquals(texts, expected, message);
			System.out.println("passed");

		} catch (AssertionError e) {
			System.out.println(message);
		}
	}

	public void verifyContent(String actual, String expected, String message) {
		try {

			// Assert.as(actual.contains(expected),expected, message);
			Assert.assertEquals(actual.contains(expected), expected, message);
			System.out.println("passed");

		} catch (AssertionError e) {
			System.out.println(message);
		}
	}

	public String removeINR(String cost) {
		cost = cost.replace("INR ", "");
		return cost;
	}

}
