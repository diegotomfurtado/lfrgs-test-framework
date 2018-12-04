package com.liferay.gs.test.functional.selenium.actions;

import com.liferay.gs.test.functional.selenium.properties.SeleniumProperties;
import com.liferay.gs.test.functional.selenium.properties.SeleniumPropertyKeys;
import com.liferay.gs.test.functional.selenium.xpath.XPathStringBuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Andrew Betts
 */
public class LiferayPortletActions {

	public LiferayPortletActions(String portletId) {
		_portletId = portletId;

		_webDriverActions = new WebDriverActions();
	}

	public void remove(WebDriver webDriver) {
		WebElement portlet = getPortlet(webDriver);

		while (portlet != null) {
			openPortletOptionsMenu(portlet, webDriver);

			WebElement removeOption = getPortletMenuOption(
				portlet, LiferayPortletMenuOption.REMOVE, webDriver);

			removeOption.click();

			_webDriverActions.acceptBrowserDialog(webDriver);

			portlet = getPortlet(webDriver);
		}
	}

	public WebElement getPortlet(WebDriver webDriver) {
		String xpath = XPathStringBuilder.buildXPathContains(
			"section", "@id", "portlet_" + _portletId);

		return _webDriverActions.fetchWebElement(By.xpath(xpath), webDriver);
	}

	public void openPortletOptionsMenu(
		WebElement portletElement, WebDriver webDriver) {

		WebElement portletOptionsButton = portletElement.findElement(
			By.xpath(_PORTLET_OPTIONS_XPATH_STRING));

		Actions actions = new Actions(webDriver)
			.moveToElement(portletOptionsButton)
			.pause(Duration.ofMillis(200));

		actions.perform();

		portletOptionsButton.click();
	}

	public WebElement getPortletMenuOption(
		WebElement portletElement, LiferayPortletMenuOption portletMenuOption,
		WebDriver webDriver) {

		WebElement menuOptionElement = _webDriverActions.fetchWebElement(
			By.xpath(
				XPathStringBuilder.buildXPathContains(
					"li", "@class", portletMenuOption.CSS_CLASS) +
					XPathStringBuilder.buildXPathContains(
						"a", "@id", _portletId)),
			webDriver);

		if (menuOptionElement != null) {
			return menuOptionElement;
		}

		By dropDownMenu = By.cssSelector(".dropdown-menu");

		long timeout = SeleniumProperties.getInteger(
			SeleniumPropertyKeys.TEST_ACTION_TIMEOUT);

		WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeout);

		Predicate<WebElement> titleMatcher =
			(el -> el.getText().trim().equals(portletMenuOption.TITLE));

		return webDriverWait.until(
			(driver) -> {
				WebElement dropDownMenuElement =
					driver.findElement(dropDownMenu);

				List<WebElement> elements = dropDownMenuElement.findElements(
					By.cssSelector(
						"li a." +
							LiferayPortletMenuOption.MENU_OPTION_SPAN_CLASS));

				return elements.stream().filter(titleMatcher).findFirst().get();
			}
		);
	}

	private static final String _PORTLET_OPTIONS_XPATH_STRING =
		".//div[contains(@class,'portlet-options')]" +
			"//a[contains(@title,'Options')]";

	private WebDriverActions _webDriverActions;

	private String _portletId;

}