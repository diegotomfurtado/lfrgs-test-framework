package com.liferay.gs.test.functional.selenium.actions;

/**
 * @author Andrew Betts
 */
public interface WebDriverActionProvider {

	public WebDriverAction getWebDriverAction(String actionKey);

}