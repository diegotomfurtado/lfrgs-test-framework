package com.liferay.gs.test.dummy.functional.cucumber.step;

import com.liferay.gs.test.dummy.functional.cucumber.component.ButtonComponent;
import com.liferay.gs.test.functional.cucumber.BaseStep;
import com.liferay.gs.test.functional.cucumber.WebDriverComponent;
import com.liferay.gs.test.functional.cucumber.component.WebDriverActionsComponent;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import java.util.function.Consumer;

/**
 * @author Andrew Betts
 */
public class ButtonSteps extends BaseStep {

	@And("I click on the back '(.*)' button")
	public void clickBackButton(String buttonName) {
		ButtonComponent buttonComponent = getComponent(ButtonComponent.class);
		WebDriverActionsComponent webDriverActionsComponent = getComponent(
			WebDriverActionsComponent.class);

		buttonComponent.clickBackButton(buttonName, webDriverActionsComponent);
	}

	@And("I also click on the '(.*)' button")
	public void andClickButton(String buttonName) {
		ButtonComponent buttonComponent = getComponent(ButtonComponent.class);
		WebDriverActionsComponent webDriverActionsComponent = getComponent(
			WebDriverActionsComponent.class);

		buttonComponent.clickButton(buttonName, webDriverActionsComponent);
	}

	@When("I click on the '(.*)' button")
	public void whenClickButtonString(String buttonName) {
		ButtonComponent buttonComponent = getComponent(ButtonComponent.class);
		WebDriverActionsComponent webDriverActionsComponent = getComponent(
			WebDriverActionsComponent.class);

		buttonComponent.clickButton(buttonName, webDriverActionsComponent);
	}

	@Override
	protected void registerComponents(
		Consumer<? super WebDriverComponent> componentRegistrar) {

		componentRegistrar.accept(new ButtonComponent());
		componentRegistrar.accept(new WebDriverActionsComponent());
	}

}