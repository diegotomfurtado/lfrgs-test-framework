package com.liferay.gs.test.dummy.functional.cucumber.component;

import com.liferay.gs.test.functional.cucumber.WebDriverComponent;
import com.liferay.gs.test.functional.cucumber.component.WebDriverActionsComponent;

import org.junit.Assert;

import org.openqa.selenium.WebElement;

/**
 * @author Andrew Betts
 */
public class DummyFormComponent extends WebDriverComponent {

	public void typeIntoInputField(
		String value, String fieldName,
		WebDriverActionsComponent webDriverActionsComponent) {

		WebElement inputField = webDriverActionsComponent.fetchByXPath(
			"input", "@name", fieldName, false);

		Assert.assertNotNull(inputField);

		inputField.clear();

		inputField.sendKeys(value);
	}

}
