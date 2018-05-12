package com.liferay.gs.test.functional.selenium.actions;

import com.liferay.gs.test.functional.selenium.runner.Browsers;
import com.liferay.gs.test.functional.selenium.runner.LiferaySeleniumTestRunner;
import com.liferay.gs.test.functional.selenium.runner.WebDriverField;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

/**
 * @author Andrew Betts
 */
@Browsers({BrowserType.CHROME})
@RunWith(LiferaySeleniumTestRunner.class)
public class ProductNavigationMenuActionsTest {

	@Test
	public void testAddPortletOnScreen() {
		ProductNavigationMenuActions productNavigationMenuActions =
			new ProductNavigationMenuActions();

		productNavigationMenuActions.addPortletOnScreen(
			LiferayPortletIds.AlertsPortlet, "i", _webDriver);
	}

	@WebDriverField
	private WebDriver _webDriver;

}
