package com.liferay.gs.test.functional.selenium.actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

/**
 * @author Andrew Betts
 */
public class BasicWebDriverActions {

	public void acceptBrowserDialog(WebDriver webDriver) {
		Alert alert = webDriver.switchTo().alert();

		alert.accept();
	}

}