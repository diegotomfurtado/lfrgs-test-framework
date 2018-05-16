package com.liferay.gs.test.dummy.functional.cucumber.component;

import com.liferay.gs.test.functional.cucumber.WebDriverComponent;
import com.liferay.gs.test.functional.cucumber.component.WebDriverActionsComponent;

import org.junit.Assert;

import org.openqa.selenium.WebElement;

/**
 * @author Andrew Betts
 */
public class ButtonComponent extends WebDriverComponent {

	public void clickBackButton(
		String buttonName,
		WebDriverActionsComponent webDriverActionsComponent) {

		WebElement backButton = webDriverActionsComponent.fetchByDataQAId(
			"a", "back-to-" + buttonName, false);

		backButton.click();
	}

	public void clickButton(
		String buttonName,
		WebDriverActionsComponent webDriverActionsComponent) {

		WebElement button = null;

		switch (buttonName) {
			case "add":
			case "save":

				button = webDriverActionsComponent.fetchByDataQAId(
					"*", buttonName + "-dummy", true);

				break;

			case "delete":
			case "edit":

				button = webDriverActionsComponent.fetchByQACssClass(
					buttonName + "-dummy");

				break;
		}

		Assert.assertNotNull(button);

		button.click();
	}

}