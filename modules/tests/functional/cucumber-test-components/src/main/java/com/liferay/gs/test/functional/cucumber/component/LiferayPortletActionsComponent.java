package com.liferay.gs.test.functional.cucumber.component;

import com.liferay.gs.test.functional.cucumber.WebDriverComponent;
import com.liferay.gs.test.functional.selenium.actions.LiferayPortletActions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;

/**
 * @author Andrew Betts
 */
public class LiferayPortletActionsComponent extends WebDriverComponent {

	public LiferayPortletActionsComponent() {
		_portletIdToActionsMap = new HashMap<>();
	}

	public void remove(String portletId) {
		LiferayPortletActions liferayPortletActions =
			_portletIdToActionsMap.computeIfAbsent(
				portletId, LiferayPortletActions::new);

		liferayPortletActions.remove(webDriver);
	}

	public WebElement getPortlet(String portletId) {
		LiferayPortletActions liferayPortletActions =
			_portletIdToActionsMap.computeIfAbsent(
				portletId, LiferayPortletActions::new);

		return liferayPortletActions.getPortlet(webDriver);
	}

	public void openPortletActionDropDown(
		WebElement portletElement, String portletId) {

		LiferayPortletActions liferayPortletActions =
			_portletIdToActionsMap.computeIfAbsent(
				portletId, LiferayPortletActions::new);

		liferayPortletActions.openPortletActionDropDown(
			portletElement, webDriver);
	}

	public void clickOnPortletConfigurationMenu(
		String title, String portletId) {

		LiferayPortletActions liferayPortletActions = 
			_portletIdToActionsMap.computeIfAbsent(
				portletId, LiferayPortletActions::new);

		liferayPortletActions.clickOnPortletConfigurationMenu(title, webDriver);
	}
	
	private Map<String, LiferayPortletActions> _portletIdToActionsMap; 

}
