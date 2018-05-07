package com.liferay.gs.test.functional.selenium;

import com.liferay.gs.test.functional.selenium.constants.BrowserDrivers;
import com.liferay.gs.test.functional.selenium.suite.SeleniumSuiteTest1;
import com.liferay.gs.test.functional.selenium.runner.Browsers;
import com.liferay.gs.test.functional.selenium.runner.LiferaySeleniumSuiteRunner;
import com.liferay.gs.test.functional.selenium.runner.WebDriverField;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import org.openqa.selenium.WebDriver;

/**
 * @author Andrew Betts
 */
@RunWith(LiferaySeleniumSuiteRunner.class)
@Suite.SuiteClasses(SeleniumSuiteTest1.class)
@Browsers({
	BrowserDrivers.BROWSER_HTML_UNIT_TEST,
	BrowserDrivers.BROWSER_CHROME,
	BrowserDrivers.BROWSER_FIREFOX,
	BrowserDrivers.BROWSER_INTERNET_EXPLORER
})
public class BrowserAnnotationSuiteTest extends BaseTest {

	@Test
	public void testBrowsers()throws Exception {
		testGoogle(webDriver);
	}

	@WebDriverField
	private WebDriver webDriver;

}