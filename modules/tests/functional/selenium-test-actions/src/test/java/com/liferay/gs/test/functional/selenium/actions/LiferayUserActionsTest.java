package com.liferay.gs.test.functional.selenium.actions;

import com.liferay.gs.test.functional.selenium.properties.SeleniumProperties;
import com.liferay.gs.test.functional.selenium.properties.SeleniumPropertyKeys;
import com.liferay.gs.test.functional.selenium.runner.Browsers;
import com.liferay.gs.test.functional.selenium.runner.LiferaySeleniumTestRunner;
import com.liferay.gs.test.functional.selenium.runner.WebDriverField;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;

/**
 * @author Andrew Betts
 */
@Browsers({BrowserType.CHROME})
@RunWith(LiferaySeleniumTestRunner.class)
public class LiferayUserActionsTest {

	@Test
	public void testSignInSignOut() {
		LiferayUserActions liferayUserActions = new LiferayUserActions();
		BaseWebDriverActions baseWebDriverActions = new BaseWebDriverActions();

		By userIcon = By.cssSelector(
			".user-icon-color-6.user-icon.user-icon-default");

		WebElement userIconElement = baseWebDriverActions.fetchWebElement(
			userIcon, _webDriver);

		Assert.assertNull(userIconElement);

		String login = SeleniumProperties.get(
			SeleniumPropertyKeys.TEST_DEFAULT_USER_LOGIN);
		String password = SeleniumProperties.get(
			SeleniumPropertyKeys.TEST_DEFAULT_USER_PASSWWORD);

		liferayUserActions.signIn(login, password, _webDriver);

		userIconElement = baseWebDriverActions.fetchWebElement(
			userIcon, _webDriver);

		Assert.assertNotNull(userIconElement);

		liferayUserActions.signOut(_webDriver);

		userIconElement = baseWebDriverActions.fetchWebElement(
			userIcon, _webDriver);

		Assert.assertNull(userIconElement);
	}

	@WebDriverField
	private WebDriver _webDriver;

}
