package com.atmecs.qa.generals;

import org.openqa.selenium.WebDriver;


import com.atmecs.qa.configuration.FindLocator;
import com.atmecs.qa.dataprovider.ValidatingData;
import com.atmecs.qa.extentreports.ExtentReport;
import com.atmecs.qa.helper.CommonUtility;
import com.atmecs.qa.validation.ValidationMethod;

public class HeatClinicPages {
	  

	CommonUtility common = new CommonUtility();
	FindLocator loc = new FindLocator();
	ValidationMethod validate = new ValidationMethod();
	ValidatingData data = new ValidatingData();
	ExtentReport extent = new ExtentReport();
	int index = 1;

	/**
	 * methodName-clickMenu
	 * 
	 * @param driver
	 */
	public void clickMenu(WebDriver driver) {
		common.clickElement(driver, loc.getproperty("clickMenu").replace("***", index + ""));
		index++;

	}

	/**
	 * methodName-getTitleAndVerify
	 * 
	 * @param driver
	 * @param expected_Title
	 */
	public void getTitleAndVerify(WebDriver driver, String expected_Title) {
		String actualTitle = driver.getTitle();
		validate.verify(actualTitle, expected_Title, "not matched");

	}

	/**
	 * methodName-verifyViewing
	 * 
	 * @param driver
	 * @param displayed_message
	 * @throws Exception 
	 */
	public void verifyViewing(WebDriver driver, String displayed_message) {
		
		String actual_text = common.getText(driver, loc.getproperty("text.veiwing"));
		//stem.out.println(actual_text);
		validate.verify(actual_text, displayed_message, "not matched");

	}

	/**
	 * methodName--validateAddToCart
 	 * @param driver
	 * @param productname
	 * @param size
	 * @param personalname
	 * @param color
	 * @param price
	 * @param totalPrice
	 */
	public void validateAddToCart(WebDriver driver, String productname, String size, String personalname, String color,
			String price, String totalPrice) {

		String actual_productname = common.getText(driver, loc.getproperty("getproductname"));
		validate.verify(actual_productname, productname, "not matched");

		String actual_size = common.getText(driver, loc.getproperty("getsize"));

		validate.verify(actual_size, size, "not matched");
		String actual_personalname = common.getText(driver, loc.getproperty("getpersonal"));
		validate.verify(actual_personalname, personalname, "not matched");

		String actual_color = common.getText(driver, loc.getproperty("getcolor"));
		validate.verify(actual_color, color, "not matched");

		String actual_price = common.getText(driver, loc.getproperty("getprice"));
		validate.verify(actual_price, price, "not matched");

		String actual_totalprice = common.getText(driver, loc.getproperty("gettotalprice"));
		validate.verify(actual_totalprice, totalPrice, "not matched");

	}

	/**
	 * methodName-validateUpdatedPrice
	 * @param driver
	 * @param updatedprice
	 */
	public void validateUpdatedPrice(WebDriver driver, String updatedprice) {
		String actualupdate = common.getText(driver, loc.getproperty("getupdatedtotal"));
		validate.verify(actualupdate, updatedprice, "not matched");

	}

}
