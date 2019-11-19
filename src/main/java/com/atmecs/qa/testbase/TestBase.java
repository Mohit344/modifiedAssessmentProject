package com.atmecs.qa.testbase;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.atmecs.qa.configuration.FileConstant;
import com.atmecs.qa.helper.CommonUtility;

public class TestBase {
	/**
	 * switch case is created for the browsers-chrome,firefox.
	 * 
	 * @throws IOException
	 */
	BaseClassGrid grid = new BaseClassGrid();
	public WebDriver driver;// remove it when use the extent report
	CommonUtility common = new CommonUtility();
	public Properties promote;

	@Parameters({ "webdrivername", "url" })
	@BeforeTest
	public void configSetup(String webdrivername, String URL) throws IOException {
	//	promote = common.propertyFileLoad(FileConstant.config);

		if (FileConstant.gridRun.equalsIgnoreCase("grid")) {

			driver = grid.getDriver(webdrivername);
		} else {

			switch (webdrivername) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", FileConstant.chromeexe);
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", FileConstant.firefoxexe);
				driver = new FirefoxDriver();
				break;
			case "ie":
				System.setProperty("webdriver.ie.driver", FileConstant.ieexe);
				driver = new InternetExplorerDriver();
				break;
			}

		}

		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(FileConstant.implicit_wait, TimeUnit.SECONDS);

	}

	@AfterTest
	public void endReport() {
		driver.quit();// quit the webdriver
	}
}
