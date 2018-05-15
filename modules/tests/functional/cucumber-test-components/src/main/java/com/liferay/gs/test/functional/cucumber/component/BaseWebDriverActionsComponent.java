package com.liferay.gs.test.functional.cucumber.component;

import com.liferay.gs.test.functional.cucumber.WebDriverComponent;
import com.liferay.gs.test.functional.selenium.actions.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Andrew Betts
 */
public class BaseWebDriverActionsComponent extends WebDriverComponent {

	public BaseWebDriverActionsComponent() {
		_WebDriverActions = new WebDriverActions();
	}

	public void acceptBrowserDialog() {
		_WebDriverActions.acceptBrowserDialog(webDriver);
	}

	public WebElement fetchButtonByName(String name, boolean exact) {
		return _WebDriverActions.fetchButtonByName(name, exact, webDriver);
	}

	public WebElement fetchByDataQAId(
		String tagName, String qaId, boolean exact) {

		return _WebDriverActions.fetchByDataQAId(
			tagName, qaId, exact, webDriver);
	}

	public WebElement fetchByQACssClass(String cssClass) {
		return _WebDriverActions.fetchByQACssClass(cssClass, webDriver);
	}

	public WebElement fetchByXPath(
		String tagName, String attributeName, String attributeValue,
		boolean exact) {

		return _WebDriverActions.fetchByXPath(
			tagName, attributeName, attributeValue, exact, webDriver);
	}

	public WebElement fetchWebElement(By by) {
		return _WebDriverActions.fetchWebElement(by, webDriver);
	}

	private WebDriverActions _WebDriverActions;

}