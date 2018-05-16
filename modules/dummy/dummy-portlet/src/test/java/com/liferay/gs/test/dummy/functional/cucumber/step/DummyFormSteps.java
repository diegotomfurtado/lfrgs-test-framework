package com.liferay.gs.test.dummy.functional.cucumber.step;

import com.liferay.gs.test.dummy.functional.cucumber.component.DummyFormComponent;
import com.liferay.gs.test.functional.cucumber.BaseStep;
import com.liferay.gs.test.functional.cucumber.WebDriverComponent;
import com.liferay.gs.test.functional.cucumber.component.WebDriverActionsComponent;

import cucumber.api.java.en.And;

import java.util.function.Consumer;

/**
 * @author Andrew Betts
 */
public class DummyFormSteps extends BaseStep {

	@And("I type '(.*)' into field '(.*)'")
	public void typeIntoInputField(String value, String fieldName) {
		WebDriverActionsComponent webDriverActionsComponent = getComponent(
			WebDriverActionsComponent.class);
		DummyFormComponent dummyFormComponent = getComponent(
			DummyFormComponent.class);

		dummyFormComponent.typeIntoInputField(
			value, fieldName, webDriverActionsComponent);
	}

	@Override
	protected void registerComponents(
		Consumer<? super WebDriverComponent> componentRegistrar) {

		componentRegistrar.accept(new WebDriverActionsComponent());
		componentRegistrar.accept(new DummyFormComponent());
	}

}