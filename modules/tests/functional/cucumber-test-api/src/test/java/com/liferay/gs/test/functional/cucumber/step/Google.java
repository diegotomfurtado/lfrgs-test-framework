package com.liferay.gs.test.functional.cucumber.step;

import com.liferay.gs.test.functional.cucumber.WebDriverComponent;
import com.liferay.gs.test.functional.cucumber.BaseStep;
import com.liferay.gs.test.functional.cucumber.component.GoogleComponent;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.function.Consumer;

/**
 * @author Andrew Betts
 */
public class Google extends BaseStep {

	@Given("I go to google home")
	public void go_to_home_page() {
		GoogleComponent googleComponent = getComponent(GoogleComponent.class);

		googleComponent.goHome();
	}

	@Then("^I should see '(.*?)' as the page title$")
	public void results_have(String title){
		GoogleComponent googleComponent = getComponent(GoogleComponent.class);

		googleComponent.hasPageTitle(title);
	}

	@Override
	protected void registerComponents(
		Consumer<? super WebDriverComponent> componentRegistrar) {

		componentRegistrar.accept(new GoogleComponent());
	}

}