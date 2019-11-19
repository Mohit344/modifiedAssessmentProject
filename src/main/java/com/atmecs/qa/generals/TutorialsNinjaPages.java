package com.atmecs.qa.generals;

import org.openqa.selenium.WebDriver;

import com.atmecs.qa.configuration.FindLocator;
import com.atmecs.qa.dataprovider.ValidatingData;
import com.atmecs.qa.extentreports.ExtentReport;
import com.atmecs.qa.helper.CommonUtility;
import com.atmecs.qa.validation.ValidationMethod;
import com.atmecs.qa.waits.Waits;

public class TutorialsNinjaPages {

	CommonUtility common = new CommonUtility();
	FindLocator loc = new FindLocator();
	ValidationMethod validate = new ValidationMethod();
	ValidatingData data = new ValidatingData();
	ExtentReport extent = new ExtentReport();
	Waits time = new Waits();

	/**
	 * methodName-homePageValidation
	 * 
	 * @param driver
	 */
	public void homePageValidation(WebDriver driver) {
		String actualTitle = driver.getTitle();
		validate.verify(actualTitle, data.getValidatingData("expectedTitle"), "Title not matched");

	}

	/**
	 * methodName-verifyUpdatedPrice
	 * 
	 * @param driver
	 */
	public void verifyUpdatedPrice(WebDriver driver) {

		String actual_grandprice = common.getText(driver, loc.getlocator("updatedprice"));
		System.out.println(actual_grandprice);
		validate.verify(actual_grandprice, data.getValidatingData("updatedgrandpriceupdated"), "not matched");
	}

	/**
	 * methodName-validateProductMac
	 * 
	 * @param driver
	 */
	public void validateProductMac(WebDriver driver) {
		String mac_actual_description = common.getText(driver, loc.getlocator("descriptionTab"));
		validate.verify(mac_actual_description, data.getValidatingData("macDescription"), "not matched");

		String mac_actual_available = common.getText(driver, loc.getlocator("MacAvailability"));
		validate.verify(mac_actual_available, data.getValidatingData("macAvailable"), "not matched");

		String mac_actual_price = common.getText(driver, loc.getlocator("product-price"));
		validate.verify(mac_actual_price, data.getValidatingData("macPrice"), "not matched");

		String ex_taxes = common.getText(driver, loc.getlocator("Ex-Taxes"));
		validate.verify(ex_taxes, data.getValidatingData("macEx-Taxes"), "not matched");
	}

	/**
	 * methodName-validateProductIphone
	 * 
	 * @param driver
	 */
	public void validateProductIphone(WebDriver driver) {
		String iphone_description = common.getText(driver, loc.getlocator("descriptionTab"));
		validate.verify(iphone_description, data.getValidatingData("iphoneDescription"), "not matched");

		String iphone_available = common.getText(driver, loc.getlocator("iphoneAvailability"));
		validate.verify(iphone_available, data.getValidatingData("iphoneAvailable"), "not matched");

		String iphone_actual_price = common.getText(driver, loc.getlocator("product-price"));
		validate.verify(iphone_actual_price, data.getValidatingData("iphonePrice"), "not matched");

		String iphone_taxes = common.getText(driver, loc.getlocator("Ex-Taxes"));
		validate.verify(iphone_taxes, data.getValidatingData("iphoneTaxes"), "not matched");

	}

	/**
	 * methodName-validateProductAdded
	 * 
	 * @param driver
	 */

	public void validateProductAdded(WebDriver driver) {

		String actual_product_presentiphone = common.getText(driver, loc.getlocator("iponeproductPresent"));
		validate.verify(actual_product_presentiphone, data.getValidatingData("productPresentIphone"), "not matched");

		String actual_product_presentmac = common.getText(driver, loc.getlocator("macProductPresent"));
		validate.verify(actual_product_presentmac, data.getValidatingData("productPresentMac"), "not matched");

	}

	/**
	 * methodName-validateGrandTotal
	 * 
	 * @param driver
	 */
	public void validateGrandTotal(WebDriver driver) {
		String actual_GrandTotal = common.getText(driver, loc.getlocator("validateGrandTotal"));
		validate.verify(actual_GrandTotal, data.getValidatingData("grandTotal"), "not matched");

	}

	/**
	 * methodName-validateUpdatedTotal
	 * 
	 * @param driver
	 */
	public void validateUpdatedTotal(WebDriver driver)

	{
		time.isElementVisible(driver, loc.getlocator("validateGrandTotal"));
		// time.isElementVisible(driver, loc.getlocator("validateGrandTotal"));
		// common.wait(1000);
		time.stalenessOf(driver, loc.getlocator("validateGrandTotal"));
		String actual_total = common.getText(driver, loc.getlocator("validateGrandTotal"));
		System.out.println(actual_total);
		validate.verify(actual_total, data.getValidatingData("updatedGrandTotal"), "not matched");

	}

	/**
	 * methodName--negativeScenario
	 * 
	 * @param driver
	 */
	public void negativeScenario(WebDriver driver) {

		String actual_errormsg = common.getText(driver, loc.getlocator("erroMsg"));
		validate.verify(actual_errormsg, data.getValidatingData("negativeScenario"), "not matched");

	}

	public void validateMessageDisplayed(WebDriver driver)
	
	{
		String actual_DisplayedMessage=common.getText(driver, loc.getlocator("displayErrorMessage"));
		validate.verify(actual_DisplayedMessage, data.getValidatingData("negativeScenario"), "not matched");
		
	}
	
	
}
