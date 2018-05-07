package com.liferay.gs.test.functional.cucumber;

import com.liferay.gs.test.functional.selenium.runner.WebDriverThreadLocal;
import cucumber.api.java.ObjectFactory;
import cucumber.runtime.CucumberException;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Andrew Betts
 *
 * would extend cucumber.runtime.java.DefaultJavaObjectFactory if it wasn't
 * package private.
 *
 */
public class BaseStepObjectFactory implements ObjectFactory {
	private final Map<Class<?>, Object> instances = new HashMap<Class<?>, Object>();

	public void start() {
		// No-op
	}

	public void stop() {
		instances.clear();
	}

	public boolean addClass(Class<?> clazz) {
		return true;
	}

	public <T> T getInstance(Class<T> type) {
		T instance = type.cast(instances.get(type));

		WebDriver webDriver = WebDriverThreadLocal.get();

		if (instance == null) {
			instance = cacheNewInstance(type);
		}

		if (instance instanceof BaseStep) {
			BaseStep step = (BaseStep) instance;

			if (webDriver != null) {
				step.updateWebDriver(webDriver);
			}
		}

		return instance;
	}

	private <T> T cacheNewInstance(Class<T> type) {
		try {
			Constructor<T> constructor = type.getConstructor();
			T instance = constructor.newInstance();
			instances.put(type, instance);
			return instance;
		} catch (NoSuchMethodException e) {
			throw new CucumberException(String.format("%s doesn't have an empty constructor. If you need DI, put cucumber-picocontainer on the classpath", type), e);
		} catch (Exception e) {
			throw new CucumberException(String.format("Failed to instantiate %s", type), e);
		}
	}

}