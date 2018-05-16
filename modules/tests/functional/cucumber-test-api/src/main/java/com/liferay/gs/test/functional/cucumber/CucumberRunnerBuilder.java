package com.liferay.gs.test.functional.cucumber;

import com.liferay.gs.test.functional.cucumber.hook.BaseCucumberHookExtension;
import com.liferay.gs.test.functional.cucumber.hook.CucumberHookExtension;
import com.liferay.gs.test.functional.cucumber.hook.CucumberHookExtensionDefinition;
import com.liferay.gs.test.functional.cucumber.hook.CucumberHookExtensionRegistry;
import com.liferay.gs.test.functional.cucumber.hook.CucumberHookExtensionDefinitions;

import cucumber.api.junit.Cucumber;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;

import gherkin.formatter.Reporter;
import gherkin.formatter.model.Tag;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Set;

import org.junit.runner.Runner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

/**
 * @author Andrew Betts
 */
public class CucumberRunnerBuilder extends RunnerBuilder {

	@Override
	public Runner runnerForClass(Class<?> testClass) throws Throwable {
		System.setProperty(
			"cucumber.api.java.ObjectFactory",
			BaseStepObjectFactory.class.getName());

		CucumberHookExtensionDefinitions hookExtensionDefinitions =
			testClass.getAnnotation(CucumberHookExtensionDefinitions.class);

		if (hookExtensionDefinitions != null) {
			processHookExtensionDefinitions(hookExtensionDefinitions.value());
		}
		else {
			processHookExtensionDefinitions(
				testClass.getAnnotationsByType(
					CucumberHookExtensionDefinition.class));
		}

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

			return new LiferayCucumberRuntime(
				resourceLoader, classFinder, classLoader, runtimeOptions);
		}

	}

	private static class LiferayCucumberRuntime extends Runtime {

		public LiferayCucumberRuntime(
			ResourceLoader resourceLoader, ClassFinder classFinder,
			ClassLoader classLoader, RuntimeOptions runtimeOptions) {

			super(resourceLoader, classFinder, classLoader, runtimeOptions);
		}

		public void runBeforeHooks(Reporter reporter, Set<Tag> tags) {
			List<CucumberHookExtension> cucumberHookExtensions =
				CucumberHookExtensionRegistry.getHooks(tags);

			for (CucumberHookExtension hook : cucumberHookExtensions) {
				hook.before(reporter);
			}

			super.runBeforeHooks(reporter, tags);
		}

		public void runAfterHooks(Reporter reporter, Set<Tag> tags) {
			List<CucumberHookExtension> cucumberHookExtensions =
				CucumberHookExtensionRegistry.getHooks(tags);

			for (CucumberHookExtension hook : cucumberHookExtensions) {
				hook.after(reporter);
			}

			super.runAfterHooks(reporter, tags);
		}
	}

	private void processHookExtensionDefinitions(
		CucumberHookExtensionDefinition[] hookDefinitions) {

		if (hookDefinitions == null) {
			return;
		}

		for (CucumberHookExtensionDefinition hookDefinition : hookDefinitions) {
			Class<? extends BaseCucumberHookExtension> hookDefinitionClass =
				hookDefinition.value();

			try {
				Constructor<? extends BaseCucumberHookExtension> constructor =
					hookDefinitionClass.getConstructor(
						String[].class, int.class);

				CucumberHookExtension hook = constructor.newInstance(
					hookDefinition.tagExpressions(), hookDefinition.order());

				CucumberHookExtensionRegistry.register(hook);
			}
			catch (NoSuchMethodException nsme) {
				throw new IllegalArgumentException(
					"CucumberHookExtension must have a constructor matching " +
						BaseCucumberHookExtension.class.getName());
			}
			catch (Exception e) {
				throw new IllegalArgumentException(
					"unable to instantiate hook class " +
						hookDefinitionClass.getName());
			}
		}
	}

}