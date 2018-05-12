package com.liferay.gs.test.functional.selenium.actions;

import com.liferay.gs.test.functional.selenium.properties.SeleniumProperties;
import com.liferay.gs.test.functional.selenium.properties.SeleniumPropertyKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Andrew Betts
 */
public class LiferayUserActions extends TimeoutAction {

	public LiferayUserActions(long timeout) {
		super(timeout);

		_baseWebDriverActions = new BaseWebDriverActions(timeout);
	}

	public void setTimeout(long timeout) {
		super.setTimeout(timeout);

		_baseWebDriverActions.setTimeout(timeout);
	}

	public void signIn(WebDriver webDriver, String login, String password) {
		String baseURL = SeleniumProperties.get(
			SeleniumPropertyKeys.TEST_DEFAULT_BASE_URL);

		webDriver.navigate().to(baseURL + "/c/portal/login");

		WebElement loginElement = webDriver.findElement(
			By.id("_" + LiferayPortletIds.LoginPortlet + "_login"));

		loginElement.sendKeys(login);

		WebElement passwordElement = webDriver.findElement(
			By.id("_" + LiferayPortletIds.LoginPortlet + "_password"));

		passwordElement.sendKeys(password);

		WebElement signInButton = _baseWebDriverActions.fetchButtonByName(
			"Sign In", false, webDriver);

		signInButton.click();
	}

	public void signOut(WebDriver webDriver) {
		String baseURL = SeleniumProperties.get(
			SeleniumPropertyKeys.TEST_DEFAULT_BASE_URL);

		webDriver.navigate().to(baseURL + "/c/portal/logout");
	}

	private BaseWebDriverActions _baseWebDriverActions;

}