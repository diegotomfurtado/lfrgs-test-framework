package com.liferay.gs.test.functional.cucumber.component;

import com.liferay.gs.test.functional.cucumber.WebDriverComponent;

import org.junit.Assert;

/**
 * @author Andrew Betts
 */
public class GoogleComponent extends WebDriverComponent {

	public void goHome() {
		webDriver.navigate().to("https://www.google.com");
	}

	public void hasPageTitle(String result) {
		Assert.assertEquals(result, webDriver.getTitle());
	}

}
