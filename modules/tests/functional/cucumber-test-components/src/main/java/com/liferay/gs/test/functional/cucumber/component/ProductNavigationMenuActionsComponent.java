package com.liferay.gs.test.functional.cucumber.component;

import com.liferay.gs.test.functional.cucumber.WebDriverComponent;
import com.liferay.gs.test.functional.selenium.actions.ProductNavigationMenuActions;

/**
 * @author Andrew Betts
 */
public class ProductNavigationMenuActionsComponent extends WebDriverComponent {

	public ProductNavigationMenuActionsComponent() {
		_productNavigationMenuActions = new ProductNavigationMenuActions();
	}

	public void addPortletOnScreen(
		String search, String portletId, String column) {

		_productNavigationMenuActions.addPortletOnScreen(
			search, portletId, column, webDriver);
	}

	public void clickOnAddButton() {
		_productNavigationMenuActions.clickOnAddButton(webDriver);
	}

	public void clickOnApplicationCategory() {
		_productNavigationMenuActions.clickOnApplicationCategory(webDriver);
	}

	public void dragAndDropPortletToColumn(String portletId, String column) {
		_productNavigationMenuActions.dragAndDropPortletToColumn(
			portletId, column, webDriver);
	}

	public void searchForPortletByName(String search) {
		_productNavigationMenuActions.searchForPortletByName(search, webDriver);
	}

	private ProductNavigationMenuActions _productNavigationMenuActions;

}
