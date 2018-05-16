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
			openPortletActionDropDown(portlet, webDriver);

			clickOnPortletConfigurationMenu("Remove", webDriver);

			_webDriverActions.acceptBrowserDialog(webDriver);

			portlet = getPortlet(webDriver);
		}
	}

	public WebElement getPortlet(WebDriver webDriver) {
		String xpath = XPathStringBuilder.buildXPathContains(
			"section", "@id", "portlet_" + _portletId);

		return _webDriverActions.fetchWebElement(By.xpath(xpath), webDriver);
	}

	public void openPortletActionDropDown(
		WebElement portletElement, WebDriver webDriver) {

		WebElement configButton = portletElement.findElement(
			By.cssSelector(".lexicon-icon-ellipsis-v"));

		Actions actions = new Actions(webDriver)
			.moveToElement(configButton)
			.pause(Duration.ofMillis(200));

		actions.perform();

		configButton.click();
	}

	public void clickOnPortletConfigurationMenu(
		String title, WebDriver webDriver) {

		By dropDownMenu = By.cssSelector(".dropdown-menu");

		long timeout = SeleniumProperties.getInteger(
			SeleniumPropertyKeys.TEST_ACTION_TIMEOUT);

		WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeout);

		WebElement configurationMenu =
			webDriverWait.until((driver) -> {
				WebElement dropDownMenuElement =
					driver.findElement(dropDownMenu);

				List<WebElement> elements = dropDownMenuElement.findElements(
					By.cssSelector("li a.lfr-icon-item"));

				return elements.stream().filter(
					el -> el.getText().trim().equals(title)).findFirst().get();
			});

		configurationMenu.click();
	}

	private WebDriverActions _webDriverActions;

	private String _portletId;

}