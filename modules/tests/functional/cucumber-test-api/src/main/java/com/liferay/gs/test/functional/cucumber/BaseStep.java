package com.liferay.gs.test.functional.cucumber;

import com.liferay.gs.test.functional.selenium.properties.SeleniumProperties;
import com.liferay.gs.test.functional.selenium.properties.SeleniumPropertyKeys;
import com.liferay.gs.test.functional.selenium.support.WebDriverManager;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

/**
 * @author Andrew Betts
 */
public abstract class BaseStep {

	void updateWebDriver(WebDriver webDriver) {
		this._webDriver = webDriver;

		componentRegistry.clear();

		registerComponents(
			(page) -> {
				componentRegistry.put(page.getClass().getName(), page);

				page.setWebDriver(webDriver);
			}
		);
	}

	protected abstract void registerComponents(
		Consumer<? super WebDriverComponent> componentRegistrar);


	protected <T> T getComponent(Class<T> klass) {
		if (_webDriver == null) {
			getWebDriver();
		}

		WebDriverComponent baseComponent =
			(WebDriverComponent) componentRegistry.get(klass.getName());

		if (klass.isAssignableFrom(baseComponent.getClass())) {
			return klass.cast(baseComponent);
		}

		return null;
	}

	protected WebDriver getWebDriver() {
		if (_webDriver == null) {
			String defaultBrowser = SeleniumProperties.get(
				SeleniumPropertyKeys.TEST_DEFAULT_BROWSER);

			if (defaultBrowser == null) {
				defaultBrowser = BrowserType.HTMLUNIT;
			}

			updateWebDriver(_webDriverManager.getWebDriver(defaultBrowser));
		}

		return _webDriver;
	}

	private WebDriver _webDriver;
	private WebDriverManager _webDriverManager = new WebDriverManager();

	private Map<String, ? super WebDriverComponent> componentRegistry =
		new HashMap<>();

}