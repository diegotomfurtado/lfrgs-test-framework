package com.liferay.gs.test.dummy.functional.cucumber.step;

import com.liferay.gs.test.dummy.functional.cucumber.component.ButtonComponent;
import com.liferay.gs.test.dummy.functional.cucumber.component.DummyFormComponent;
import com.liferay.gs.test.dummy.functional.cucumber.component.DummyTableComponent;
import com.liferay.gs.test.functional.cucumber.BaseStep;
import com.liferay.gs.test.functional.cucumber.WebDriverComponent;
import com.liferay.gs.test.functional.cucumber.component.WebDriverActionsComponent;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.function.Consumer;

import org.junit.Assert;

import org.openqa.selenium.WebElement;

/**
 * @author Andrew Betts
 */
public class DummyTableSteps extends BaseStep {

	@Given("I see a dummy displayed in the portlet with '(.*)' equal to '(.*)'")
	public void createDummyInTable(String fieldName, String value) {
		ButtonComponent buttonComponent = getComponent(ButtonComponent.class);
		DummyFormComponent dummyFormComponent = getComponent(
			DummyFormComponent.class);
		DummyTableComponent dummyTableComponent = getComponent(
			DummyTableComponent.class);
		WebDriverActionsComponent webDriverActionsComponent = getComponent(
			WebDriverActionsComponent.class);

		dummyTableComponent.addDummyToTable(
			fieldName, value, buttonComponent, dummyFormComponent,
			webDriverActionsComponent);
	}

	@Then("I '(.*)' see a dummy displayed in the portlet with '(.*)' equal to '(.*)'")
	public void seeDummyInTableWith(
		String command, String fieldName, String value) {

		DummyTableComponent dummyTableComponent = getComponent(
			DummyTableComponent.class);
		WebDriverActionsComponent webDriverActionsComponent = getComponent(
			WebDriverActionsComponent.class);

		WebElement dummy = dummyTableComponent.findDummyRow(
			value, webDriverActionsComponent);

		switch (command) {
			case _SHOULD:
				Assert.assertNotNull(dummy);

				break;

			case _SHOULD_NOT:
				Assert.assertNull(dummy);
		}
	}

	@Override
	protected void registerComponents(
		Consumer<? super WebDriverComponent> componentRegistrar) {

		componentRegistrar.accept(new ButtonComponent());
		componentRegistrar.accept(new DummyFormComponent());
		componentRegistrar.accept(new DummyTableComponent());
		componentRegistrar.accept(new WebDriverActionsComponent());
	}

	private static final String _SHOULD = "should";

	private static final String _SHOULD_NOT = "should not";

}