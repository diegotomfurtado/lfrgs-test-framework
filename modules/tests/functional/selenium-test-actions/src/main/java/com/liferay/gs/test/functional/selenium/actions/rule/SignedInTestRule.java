package com.liferay.gs.test.functional.selenium.actions.rule;

import com.liferay.gs.test.functional.selenium.actions.LiferayUserActions;
import com.liferay.gs.test.functional.selenium.properties.SeleniumProperties;
import com.liferay.gs.test.functional.selenium.properties.SeleniumPropertyKeys;
import com.liferay.gs.test.functional.selenium.threadlocal.WebDriverThreadLocal;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

/**
 * @author Andrew Betts
 */
public class SignedInTestRule extends TestWatcher {

	public SignedInTestRule() {
		_liferayUserActions = new LiferayUserActions();
	}

	/**
	 * Invoked when a test is about to start
	 */
	protected void starting(Description description) {
		WebDriver webDriver = WebDriverThreadLocal.get();

		String login = SeleniumProperties.get(
			SeleniumPropertyKeys.TEST_DEFAULT_USER_LOGIN);
		String password = SeleniumProperties.get(
			SeleniumPropertyKeys.TEST_DEFAULT_USER_PASSWWORD);

		_liferayUserActions.signIn(login, password, webDriver);
	}

	/**
	 * Invoked when a test method finishes (whether passing or failing)
	 */
	protected void finished(Description description) {
		WebDriver webDriver = WebDriverThreadLocal.get();

		_liferayUserActions.signOut(webDriver);
	}

	private LiferayUserActions _liferayUserActions;

}
