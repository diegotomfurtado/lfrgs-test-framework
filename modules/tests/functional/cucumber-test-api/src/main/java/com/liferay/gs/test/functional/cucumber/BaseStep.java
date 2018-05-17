package com.liferay.gs.test.functional.cucumber;

import com.liferay.gs.test.functional.selenium.properties.SeleniumProperties;
import com.liferay.gs.test.functional.selenium.properties.SeleniumPropertyKeys;
import com.liferay.gs.test.functional.selenium.support.WebDriverManager;
import com.liferay.gs.test.functional.selenium.threadlocal.WebDriverManagerThreadLocal;
import com.liferay.gs.test.functional.selenium.threadlocal.WebDriverThreadLocal;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

/**
 * @author Andrew Betts
 */
public abstract class BaseStep {

	public BaseStep() {
		_componentRegistry = new HashMap<>();
		_webDriverManager = new WebDriverManager();
	}

	void updateWebDriver(WebDriver webDriver) {
		if (Objects.equals(_webDriver, webDriver)) {
			return;
		}

		_webDriver = webDriver;

		_componentRegistry.clear();

		registerComponents(
			(page) -> {
				_componentRegistry.put(page.getClass().getName(), page);

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
			(WebDriverComponent) _componentRegistry.get(klass.getName());

		if (klass.isAssignableFrom(baseComponent.getClass())) {
			return klass.cast(baseComponent);
		}

		return null;
	}

	protected WebDriver getWebDriver() {
		if (_webDriver != null) {
			return _webDriver;
		}

		WebDriver webDriver = WebDriverThreadLocal.get();

		if (webDriver == null) {
			String defaultBrowser = SeleniumProperties.get(
				SeleniumPropertyKeys.TEST_DEFAULT_BROWSER);

			if (defaultBrowser == null) {
				defaultBrowser = BrowserType.HTMLUNIT;
			}

			WebDriverManager webDriverManager =
				WebDriverManagerThreadLocal.get();

			if (webDriverManager == null) {
				webDriverManager = _webDriverManager;
			}

			webDriver = webDriverManager.getWebDriver(defaultBrowser);
		}

		updateWebDriver(webDriver);

		return _webDriver;
	}

	private Map<String, ? super WebDriverComponent> _componentRegistry;
	private WebDriver _webDriver;
	private WebDriverManager _webDriverManager;

}