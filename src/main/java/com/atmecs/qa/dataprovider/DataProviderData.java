package com.atmecs.qa.dataprovider;

import org.testng.annotations.DataProvider;

import com.atmecs.qa.configuration.FileConstant;
import com.atmecs.qa.util.ProviderData;

/**
 * 
 * @author Mohit.Jaiswal
 *
 */
public class DataProviderData {

	/**
	 * Data provider name-homePage
	 * 
	 * @return
	 */
	@DataProvider(name = "homePage")
	public Object[][] getDataOne() {
		ProviderData provideData = new ProviderData(FileConstant.tutorialNinjaHomePage);
		Object[][] getData = provideData.provideData();
		return getData;
	}

	/**
	 * Data provider name-heatclinicHomePage
	 * 
	 * @return
	 */
	@DataProvider(name = "title")
	public Object[][] getDataSecond() {
		ProviderData provideData = new ProviderData(FileConstant.heatclinicHomePage);
		Object[][] getData = provideData.provideData();
		return getData;
	}

	/**
	 * Data provider name -heatclinicValidation
	 * 
	 * @return
	 */
	@DataProvider(name = "product")
	public Object[][] getDataThird() {
		ProviderData provideData = new ProviderData(FileConstant.heatclinicValidation);
		Object[][] getData = provideData.provideData();
		return getData;
	}
	//
	// /**
	// * Data provider 4
	// * @return
	// */
	// @DataProvider(name = "productReview")
	// public Object[][] getDataForth() {
	// ProviderData provideData = new ProviderData(FileConstant.productReview);
	// Object[][] getData = provideData.provideData();
	// return getData;
	// }
	//
	//

}
