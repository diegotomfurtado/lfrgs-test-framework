package com.liferay.gs.test.functional.selenium.actions.rule;

import com.liferay.gs.test.functional.selenium.threadlocal.WebDriverThreadLocal;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

/**
 * @author Andrew Betts
 */
public class NavigationTestRule extends TestWatcher {

	public NavigationTestRule(String toUrl) {
		_toURL = toUrl;
	}

	/**
	 * Invoked when a test is about to start
	 */
	protected void starting(Description description) {
		WebDriver webDriver = WebDriverThreadLocal.get();

		_backURL = webDriver.getCurrentUrl();

		webDriver.navigate().to(_toURL);
	}

	/**
	 * Invoked when a test method finishes (whether passing or failing)
	 */
	protected void finished(Description description) {
		WebDriver webDriver = WebDriverThreadLocal.get();

		if ((_backURL != null) && !_backURL.isEmpty()) {
			webDriver.navigate().to(_backURL);
		}
	}

	private String _backURL;
	private String _toURL;

}