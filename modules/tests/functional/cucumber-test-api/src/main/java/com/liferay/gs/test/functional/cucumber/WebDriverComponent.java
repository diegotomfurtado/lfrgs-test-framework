package com.liferay.gs.test.functional.cucumber;

import org.openqa.selenium.WebDriver;

/**
 * @author Andrew Betts
 */
public abstract class WebDriverComponent {

	void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	protected WebDriver webDriver;

}