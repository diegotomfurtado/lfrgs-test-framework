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
public class LiferayPortletActionsTest {

	@Rule
	public SignedInTestRule signedInTestRule = new SignedInTestRule();

	@Test
	public void testOpenPortletActionDropDown() {
		LiferayPortletActions liferayUserActions = new LiferayPortletActions(
			LiferayPortletIds.HelloWorldPortlet);

		_webDriver.navigate();

		WebElement portletElement = liferayUserActions.getPortlet(_webDriver);

		liferayUserActions.openPortletOptionsMenu(
			portletElement, _webDriver);

		WebElement portletConfiguration =
			liferayUserActions.getPortletMenuOption(
				portletElement, LiferayPortletMenuOption.CONFIGURATION,
				_webDriver);

		Assert.assertTrue(portletConfiguration.isDisplayed());
	}

	@WebDriverField
	private WebDriver _webDriver;

}