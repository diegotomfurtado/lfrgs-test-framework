package com.liferay.gs.test.functional.selenium.actions.rule;

import com.liferay.gs.test.functional.selenium.actions.LiferayUserActions;
import com.liferay.gs.test.functional.selenium.properties.SeleniumProperties;
import com.liferay.gs.test.functional.selenium.properties.SeleniumPropertyKeys;
import com.liferay.gs.test.functional.selenium.threadlocal.WebDriverThreadLocal;

import java.util.function.Supplier;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import org.openqa.selenium.WebDriver;

/**
 * @author Andrew Betts
 */
public class SignedInTestRule extends TestWatcher {

	public SignedInTestRule() {
		this(
			() -> SeleniumProperties.get(
				SeleniumPropertyKeys.TEST_DEFAULT_USER_LOGIN),
			() -> SeleniumProperties.get(
				SeleniumPropertyKeys.TEST_DEFAULT_USER_PASSWWORD));
	}

	public SignedInTestRule(
		Supplier<String> loginSupplier, Supplier<String> passwordSupplier) {

		_liferayUserActions = new LiferayUserActions();

		_loginSupplier = loginSupplier;
		_passwordSupplier = passwordSupplier;
	}

	/**
	 * Invoked when a test is about to start
	 */
	protected void starting(Description description) {
		WebDriver webDriver = WebDriverThreadLocal.get();

		_liferayUserActions.signIn(
			_loginSupplier.get(), _passwordSupplier.get(), webDriver);
	}

	/**
	 * Invoked when a test method finishes (whether passing or failing)
	 */
	protected void finished(Description description) {
		WebDriver webDriver = WebDriverThreadLocal.get();

		_liferayUserActions.signOut(webDriver);
	}

	private LiferayUserActions _liferayUserActions;
	private Supplier<String> _loginSupplier;
	private Supplier<String> _passwordSupplier;

}
