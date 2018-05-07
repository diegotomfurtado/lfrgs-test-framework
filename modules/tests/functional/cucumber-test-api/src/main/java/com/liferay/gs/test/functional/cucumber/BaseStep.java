package com.liferay.gs.test.functional.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

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
		Consumer<? super WebDriverComponent> pageRegistrar);


	protected <T> T getComponent(Class<T> klass) {
		if (_webDriver == null) {
			updateWebDriver(new HtmlUnitDriver());
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
			updateWebDriver(new HtmlUnitDriver());
		}

		return _webDriver;
	}

	private WebDriver _webDriver;

	private Map<String, ? super WebDriverComponent> componentRegistry =
		new HashMap<>();

}