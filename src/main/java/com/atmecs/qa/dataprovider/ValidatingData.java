package com.atmecs.qa.dataprovider;

import java.io.IOException;
import java.util.Properties;

import com.atmecs.qa.configuration.FileConstant;
import com.atmecs.qa.helper.CommonUtility;

public class ValidatingData {
	CommonUtility common = new CommonUtility();
	Properties Property;
	Properties Propertyfile;

	/**
	 * In this constructor, reading of property file is being done
	 */
	public ValidatingData() {
		try {

			Property = common.propertyFileLoad(FileConstant.tutorialNinjaValidationFile);
		} catch (IOException e) {
			e.getMessage();
		}
	}
//	try {
//		
//		Propertyfile=common.propertyFileLoad(FileConstant.heatClinicdata);
//	} catch (IOException e) {
//		e.getMessage();
//	}
//}
//	

	/**
	 * In this method, validation data from the property file is taken
	 * 
	 * @param key
	 */
	public String getValidatingData(String key) {
		String value = Property.getProperty(key);
		return value;
	}

//	public  String getdata(String key) 
//	{
//		String value = Property.getProperty(key);
//		return value;
//	}
}
