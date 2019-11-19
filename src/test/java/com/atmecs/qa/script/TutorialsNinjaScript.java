package com.atmecs.qa.script;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.atmecs.qa.configuration.FileConstant;
import com.atmecs.qa.configuration.FindLocator;
import com.atmecs.qa.dataprovider.DataProviderData;
import com.atmecs.qa.dataprovider.ValidatingData;
import com.atmecs.qa.extentreports.ExtentReport;
import com.atmecs.qa.generals.TutorialsNinjaPages;
import com.atmecs.qa.helper.CommonUtility;
import com.atmecs.qa.testbase.TestBase;
import com.atmecs.qa.validation.ValidationMethod;
import com.atmecs.qa.waits.Waits;

public class TutorialsNinjaScript extends TestBase {

	CommonUtility common = new CommonUtility();
	FindLocator loc = new FindLocator();
	ValidationMethod validate = new ValidationMethod();
	ValidatingData data = new ValidatingData();
	ExtentReport extent = new ExtentReport();
	TutorialsNinjaPages method = new TutorialsNinjaPages();
	Waits time = new Waits();

	Waits wait = new Waits();

	@Test(priority = 1)
	public void validateHomePage() {
		Logger log = Logger.getLogger(TutorialsNinjaScript.class);
		log.info("Step1:Validate HomePage");
		method.homePageValidation(driver);

	}

	@Test(priority = 2, dataProvider = "homePage", dataProviderClass = DataProviderData.class)
	public void searchItemMethod(String searchItemMac, String searchItemiphone, String macQuantity,
			String iphoneQuantity,String differentProduct) {

		Logger log = Logger.getLogger(TutorialsNinjaScript.class);
		log.info("Step2: Search for iphone qt.two and  mac qt.3 ");
		log.info("click on the add to cart");

		common.clickElement(driver, loc.getlocator("AddtoCardBasket.click"));
		log.info("validate the error message  ");
		method.negativeScenario(driver);
		log.info("search the item macbook ");
		common.clickAndSendText(driver, loc.getlocator("Search.item"), FileConstant.waittime, searchItemMac);

		log.info("click on searchbutton");
		common.clickElement(driver, loc.getlocator("clicksearchbtn"));
		common.scrollToElement(driver, loc.getlocator("click.mac.img"));
		log.info("click on mac. image");
		common.clickElement(driver, loc.getlocator("click.mac.img"));
		log.info("enter  the quantity ");
		common.clearElement(driver, loc.getlocator("input.quantity"));
		common.clickAndSendText(driver, loc.getlocator("input.quantity"), FileConstant.waittime, macQuantity);
		log.info("validate product macbook");
		method.validateProductMac(driver);
		log.info("click on add to cart");
		common.clickElement(driver, loc.getlocator("AddtoCart"));
		log.info("search for second item");
		common.clearElement(driver, loc.getlocator("Search.item"));

		common.clickAndSendText(driver, loc.getlocator("Search.item"), FileConstant.waittime, searchItemiphone);
		common.clickElement(driver, loc.getlocator("clicksearchbtn"));

		common.scrollToElement(driver, loc.getlocator("click.iphone.img"));
		log.info("click the iphone image");
		common.clickElement(driver, loc.getlocator("click.iphone.img"));
		log.info("validate Iphone product details");
		method.validateProductIphone(driver);
		log.info("Add the iphone quantity");
		common.clearElement(driver, loc.getlocator("input.quantity"));
		common.clickAndSendText(driver, loc.getlocator("input.quantity"), FileConstant.waittime, iphoneQuantity);
		log.info("Add to cart");
		common.clickElement(driver, loc.getlocator("AddtoCart"));

		time.stalenessOf(driver, loc.getlocator("AddtoCardBasket.click"));
		log.info("click Add to cart basket");
		common.clickElement(driver, loc.getlocator("AddtoCardBasket.click"));

		time.isElementVisible(driver, loc.getlocator("viewcart.click"));
		log.info("click on the viewcart");
		common.clickElement(driver, loc.getlocator("viewcart.click"));
		log.info("validate the cart");
		method.validateProductAdded(driver);
		log.info("validate the grandTotal ");
		method.validateGrandTotal(driver);
		log.info("remove the one itemm from cart");
		common.clickElement(driver, loc.getlocator("removetocart"));
		log.info("validate the updated grand total");
		method.validateUpdatedTotal(driver);
		
		common.clickAndSendText(driver, loc.getlocator("Search.item"), FileConstant.waittime, differentProduct);
		common.clickElement(driver, loc.getlocator("clicksearchbtn"));
		method.validateMessageDisplayed(driver);
		
	}

}