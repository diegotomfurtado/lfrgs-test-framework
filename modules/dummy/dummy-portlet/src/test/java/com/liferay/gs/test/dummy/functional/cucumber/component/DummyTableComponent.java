package com.liferay.gs.test.dummy.functional.cucumber.component;

import com.liferay.gs.test.functional.cucumber.WebDriverComponent;
import com.liferay.gs.test.functional.cucumber.component.WebDriverActionsComponent;

import org.openqa.selenium.WebElement;

/**
 * @author Andrew Betts
 */
public class DummyTableComponent extends WebDriverComponent {

	public void addDummyToTable(
		String fieldName, String value, ButtonComponent buttonComponent,
		DummyFormComponent dummyFormComponent,
		WebDriverActionsComponent webDriverActionsComponent) {

		WebElement dummyElement = findDummyRow(
			value, webDriverActionsComponent);

		if (dummyElement != null) {
			return;
		}

		buttonComponent.clickButton("add", webDriverActionsComponent);

		dummyFormComponent.typeIntoInputField(
			value, fieldName, webDriverActionsComponent);

		buttonComponent.clickButton("save", webDriverActionsComponent);

		buttonComponent.clickBackButton("view", webDriverActionsComponent);
	}

	public WebElement findDummyRow(
		String value, WebDriverActionsComponent webDriverActionsComponent) {

		return webDriverActionsComponent.fetchByXPath(
			"td", "text()", value, false);
	}

}
