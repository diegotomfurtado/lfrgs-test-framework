package com.liferay.gs.test.functional.selenium;

import com.liferay.gs.test.functional.selenium.constants.BrowserDrivers;
import com.liferay.gs.test.functional.selenium.runner.Browsers;
import com.liferay.gs.test.functional.selenium.runner.LiferaySeleniumTestRunner;
import com.liferay.gs.test.functional.selenium.runner.WebDriverField;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;

/**
 * @author Andrew Betts
 */
@RunWith(LiferaySeleniumTestRunner.class)
public class BrowserAnnotationMethodTest extends BaseTest {

	@Test
	@Browsers({
		BrowserDrivers.BROWSER_HTML_UNIT_TEST,
		BrowserDrivers.BROWSER_CHROME,
		BrowserDrivers.BROWSER_FIREFOX,
		BrowserDrivers.BROWSER_INTERNET_EXPLORER
	})
	public void testBrowsers() throws Exception {
		testGoogle(webDriver);
	}

	@WebDriverField
	private WebDriver webDriver;

}