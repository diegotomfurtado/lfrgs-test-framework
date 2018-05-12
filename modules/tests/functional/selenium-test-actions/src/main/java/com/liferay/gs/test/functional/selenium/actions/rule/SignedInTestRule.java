package com.liferay.gs.test.functional.selenium.actions.rule;

import com.liferay.gs.test.functional.selenium.actions.LiferayUserActions;
import com.liferay.gs.test.functional.selenium.properties.SeleniumProperties;
import com.liferay.gs.test.functional.selenium.properties.SeleniumPropertyKeys;
import com.liferay.gs.test.functional.selenium.threadlocal.WebDriverThreadLocal;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;

/**
 * @author Andrew Betts
 */
public class SignedInTestRule implements TestRule {

	@Override
	public Statement apply(Statement base, Description description) {
		LiferayUserActions liferayUserActions = new LiferayUserActions();

		return new Statement() {

			@Override
			public void evaluate() throws Throwable {
				WebDriver webDriver = WebDriverThreadLocal.get();

				String login = SeleniumProperties.get(
					SeleniumPropertyKeys.TEST_DEFAULT_USER_LOGIN);
				String password = SeleniumProperties.get(
					SeleniumPropertyKeys.TEST_DEFAULT_USER_PASSWWORD);

				liferayUserActions.signIn(login, password, webDriver);

				base.evaluate();

				liferayUserActions.signOut(webDriver);
			}

		};
	}

}
