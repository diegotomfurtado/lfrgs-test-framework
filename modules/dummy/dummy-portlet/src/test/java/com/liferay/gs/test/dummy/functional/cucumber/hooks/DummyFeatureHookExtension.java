package com.liferay.gs.test.dummy.functional.cucumber.hooks;

import com.liferay.gs.test.dummy.constants.DummyPortletKeys;
import com.liferay.gs.test.functional.cucumber.hook.BaseCucumberHookExtension;
import com.liferay.gs.test.functional.selenium.actions.LiferayUserActions;
import com.liferay.gs.test.functional.selenium.actions.ProductNavigationMenuActions;
import com.liferay.gs.test.functional.selenium.actions.WebDriverActions;
import com.liferay.gs.test.functional.selenium.actions.LiferayPortletActions;
import com.liferay.gs.test.functional.selenium.properties.SeleniumProperties;
import com.liferay.gs.test.functional.selenium.properties.SeleniumPropertyKeys;
import com.liferay.gs.test.functional.selenium.threadlocal.WebDriverThreadLocal;

import com.liferay.gs.test.functional.selenium.xpath.XPathStringBuilder;
import gherkin.formatter.Reporter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author Andrew Betts
 */
public class DummyFeatureHookExtension extends BaseCucumberHookExtension {

	public DummyFeatureHookExtension(String[] tagExpressions, int order) {
		super(tagExpressions, order);
	}

	@Override
	public void after(Reporter reporter) {
		WebDriver webDriver = WebDriverThreadLocal.get();

		if (webDriver == null) {
			reporter.write(
				"unable to perform clean up action because web driver is null");

			return;
		}

		String rowXPath = XPathStringBuilder.buildXPathContains(
			"tr", "@data-qa-id", "row");
		String columnXPath = XPathStringBuilder.buildXPathContains(
			"td", "@class", "qa-css-delete-dummy");

		By xpath = By.xpath(rowXPath + columnXPath + "//a");

		List<WebElement> deleteLinks = webDriver.findElements(xpath);

		deleteLinks.forEach(WebElement::click);

		LiferayPortletActions liferayPortletActions =
			new LiferayPortletActions(DummyPortletKeys.Dummy);

		liferayPortletActions.remove(webDriver);

		LiferayUserActions liferayUserActions = new LiferayUserActions();

		liferayUserActions.signOut(webDriver);
	}

	@Override
	public void before(Reporter reporter) {
		WebDriver webDriver = WebDriverThreadLocal.get();

		if (webDriver == null) {
			reporter.write(
				"unable to perform set up action because web driver is null");

			return;
		}

		LiferayUserActions liferayUserActions = new LiferayUserActions();

		String login = SeleniumProperties.get(
			SeleniumPropertyKeys.TEST_USER_LOGIN_DEFAULT);
		String password = SeleniumProperties.get(
			SeleniumPropertyKeys.TEST_USER_PASSWORD_DEFAULT);

		liferayUserActions.signIn(login, password, webDriver);

		LiferayPortletActions liferayPortletActions =
			new LiferayPortletActions(DummyPortletKeys.Dummy);

		WebElement dummyPortlet = liferayPortletActions.getPortlet(webDriver);

		if (dummyPortlet != null) {
			return;
		}

		ProductNavigationMenuActions productNavigationMenuActions =
			new ProductNavigationMenuActions();

		productNavigationMenuActions.addPortletOnScreen(
			"dummy", DummyPortletKeys.Dummy, "column-1", webDriver);
	}

}