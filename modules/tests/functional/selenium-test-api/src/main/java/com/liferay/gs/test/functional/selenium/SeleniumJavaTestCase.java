package com.liferay.gs.test.functional.selenium;

import com.liferay.gs.test.functional.selenium.support.WebDriverManager;

import junit.framework.TestCase;

import org.openqa.selenium.WebDriver;

/**
 * @author Andrew Betts
 */
public class SeleniumJavaTestCase extends TestCase {

	static {
		WebDriverManager.init();

		_WEB_DRIVER_MANAGER = new WebDriverManager();
	}

	@Override
	protected void setUp() throws Exception {
		webDriver = _WEB_DRIVER_MANAGER.getWebDriver();
	}

	@Override
	protected void tearDown() throws Exception {
		webDriver.quit();

		_WEB_DRIVER_MANAGER.stopService();

		webDriver = null;
	}

	private static WebDriverManager _WEB_DRIVER_MANAGER;

	protected WebDriver webDriver;

}
