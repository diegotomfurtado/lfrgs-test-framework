package com.liferay.gs.test.functional.cucumber;

import cucumber.api.junit.Cucumber;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import org.junit.runner.Runner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

import java.io.IOException;

/**
 * @author Andrew Betts
 */
public class CucumberRunnerBuilder extends RunnerBuilder {

	@Override
	public Runner runnerForClass(Class<?> testClass) throws Throwable {
		System.setProperty(
			"cucumber.api.java.ObjectFactory",
			BaseStepObjectFactory.class.getName());

		return new CucumberExt(testClass);
	}

	private static class CucumberExt extends Cucumber {

		/**
		 * Constructor called by JUnit.
		 *
		 * @param clazz the class with the @RunWith annotation.
		 * @throws IOException                         if there is a problem
		 * @throws InitializationError if there is another problem
		 */
		public CucumberExt(Class clazz) throws InitializationError, IOException {
			super(clazz);
		}

		protected Runtime createRuntime(
				ResourceLoader resourceLoader, ClassLoader classLoader,
				RuntimeOptions runtimeOptions)
			throws InitializationError, IOException {

			ClassFinder classFinder =
				new ResourceLoaderClassFinder(resourceLoader, classLoader);

			return new Runtime(
				resourceLoader, classFinder, classLoader, runtimeOptions);
		}

	}

}