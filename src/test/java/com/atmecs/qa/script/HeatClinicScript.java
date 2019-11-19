package com.atmecs.qa.script;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.atmecs.qa.configuration.FileConstant;
import com.atmecs.qa.configuration.FindLocator;
import com.atmecs.qa.dataprovider.DataProviderData;
import com.atmecs.qa.dataprovider.ValidatingData;
import com.atmecs.qa.extentreports.ExtentReport;
import com.atmecs.qa.generals.HeatClinicPages;
import com.atmecs.qa.helper.CommonUtility;
import com.atmecs.qa.testbase.TestBase;
import com.atmecs.qa.validation.ValidationMethod;
import com.atmecs.qa.waits.Waits;

public class HeatClinicScript extends TestBase {

	CommonUtility common = new CommonUtility();
	FindLocator loc = new FindLocator();
	ValidationMethod validate = new ValidationMethod();
	ValidatingData data = new ValidatingData();
	ExtentReport extent = new ExtentReport();
	HeatClinicPages methods = new HeatClinicPages();
	Waits time = new Waits();

	@Test(priority = 1, dataProvider = "title", dataProviderClass = DataProviderData.class)
	/**
	 * methodsname-clickMenuVerify
	 * 
	 * @param expected_Title
	 */
	public void clickMenuVerify(String expected_Title) {
		Logger log = Logger.getLogger(TutorialsNinjaScript.class);
		log.info("click all menu and validate redirection");
		methods.clickMenu(driver);
		methods.getTitleAndVerify(driver, expected_Title);

	}

	@Test(priority = 2, dataProvider = "product", dataProviderClass = DataProviderData.class)
	/**
	 * methodname-clickMerchantVerifyProduct
	 * 
	 * @param displayed_message
	 * @param personNameinput
	 * @param productname
	 * @param size
	 * @param personalname
	 * @param color
	 * @param price
	 * @param totalPrice
	 * @param addmoreQT
	 * @param updatedprice
	 */
	public void clickMerchantVerifyProduct(String displayed_message, String personNameinput, String productname,
			String size, String personalname, String color, String price, String totalPrice, String addmoreQuantity,
			String updatedprice) {
		Logger log = Logger.getLogger(HeatClinicScript.class);
		log.info("click on merchandise");
		common.mouseHover(loc.getproperty("clickMerchant"), driver);
		common.clickElement(driver, loc.getproperty("mouseHover"));
		methods.verifyViewing(driver, displayed_message);
		log.info("select the tshrit color size ");
		common.clickElement(driver, loc.getproperty("click.buy.now"));
		common.clickElement(driver, loc.getproperty("selectColor"));
		common.clickElement(driver, loc.getproperty("selectsize"));
		log.info("enter the personal name");
		common.clickAndSendText(driver, loc.getproperty("inputname"), FileConstant.waittime, personNameinput);
		common.clickElement(driver, loc.getproperty("clickBuyOnWindow"));
		common.clickElement(driver, loc.getproperty("click.addtocart"));
		log.info("addQuantity");
		methods.validateAddToCart(driver, productname, size, personalname, color, price, totalPrice);
		common.clearElement(driver, loc.getproperty("inputupdate"));
		driver.findElement(By.cssSelector("input.quantityInput")).sendKeys(addmoreQuantity);

		log.info("click update");

		common.clickElement(driver, loc.getproperty("clickUpdate"));
		System.out.println("updated");

		time.visibilityOfAllElements(driver, loc.getproperty("visibilityOfImage"));
		methods.validateUpdatedPrice(driver, updatedprice);
		System.out.println("program passed");

	}

}
