package com.liferay.gs.test.functional.cucumber;

import java.util.Collections;
import java.util.List;

import com.liferay.gs.test.functional.selenium.runner.BrowserRunnerBuilder;
import com.liferay.gs.test.functional.selenium.support.WebDriverManager;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;


/**
 * @author andrewbetts
 */
public class LiferayCucumberRunner extends ParentRunner<Runner> {

	private final List<Runner> runners;

	/**
	 * Called reflectively on classes annotated with
	 * <code>@RunWith(LiferayCucumberRunner.class)</code>
	 *
	 * @param klass the root class
	 */
	public LiferayCucumberRunner(Class<?> klass)
		throws InitializationError {

		this(klass, new BrowserRunnerBuilder(
			new CucumberRunnerBuilder(), new WebDriverManager()));
	}

	public LiferayCucumberRunner(Class<?> klass, RunnerBuilder builder)
		throws InitializationError {

		this(klass, builder.runners(klass, new Class[]{klass}));
	}

	/**
	 * Called by this class and subclasses once the runners making up the
	 * LiferayCucumberRunner have been determined
	 *
	 * @param klass root of the LiferayCucumberRunner
	 * @param runners for each class in the LiferayCucumberRunner, a {@link Runner}
	 */
	protected LiferayCucumberRunner(Class<?> klass, List<Runner> runners)
		throws InitializationError {

		super(klass);

		WebDriverManager.init();

		this.runners = Collections.unmodifiableList(runners);
	}

	@Override
	protected String getName() {
		return LiferayCucumberRunner.class.getName();
	}

	@Override
	protected List<Runner> getChildren() {
		return runners;
	}

	@Override
	protected Description describeChild(Runner child) {
		return child.getDescription();
	}

	@Override
	protected void runChild(Runner runner, final RunNotifier notifier) {
		runner.run(notifier);
	}

}