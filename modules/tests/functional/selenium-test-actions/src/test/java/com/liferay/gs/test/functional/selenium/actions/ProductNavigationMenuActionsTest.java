package com.liferay.gs.test.functional.selenium.actions;

import com.liferay.gs.test.functional.selenium.actions.rule.SignedInTestRule;
import com.liferay.gs.test.functional.selenium.runner.Browsers;
import com.liferay.gs.test.functional.selenium.runner.LiferaySeleniumTestRunner;
import com.liferay.gs.test.functional.selenium.runner.WebDriverField;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;

/**
 * @author Andrew Betts
 */
@Browsers({BrowserType.CHROME})
@RunWith(LiferaySeleniumTestRunner.class)
public class ProductNavigationMenuActionsTest {

	@Rule
	public SignedInTestRule signedInTestRule = new SignedInTestRule();

	@Test
	public void testAddPortletOnScreen() {
		LiferayPortletActions alertsPortletActions = new LiferayPortletActions(
			LiferayPortletIds.AlertsPortlet);

		ProductNavigationMenuActions productNavigationMenuActions =
			new ProductNavigationMenuActions();

		productNavigationMenuActions.addPortletOnScreen(
			"Alerts", LiferayPortletIds.AlertsPortlet, "column-1", _webDriver);

		WebElement alertsPortlet = alertsPortletActions.getPortlet(_webDriver);

		Assert.assertNotNull(alertsPortlet);

		alertsPortletActions.remove(_webDriver);

		alertsPortlet = alertsPortletActions.getPortlet(_webDriver);

		Assert.assertNull(alertsPortlet);
	}

	@WebDriverField
	private WebDriver _webDriver;

}
