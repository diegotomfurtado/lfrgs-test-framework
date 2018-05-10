package com.liferay.gs.test.functional.selenium.actions;

import com.liferay.gs.test.functional.selenium.properties.SeleniumProperties;
import com.liferay.gs.test.functional.selenium.properties.SeleniumPropertyKeys;
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
		String defaultTimeout = SeleniumProperties.get(
			SeleniumPropertyKeys.WEBDRIVER_DEFAULT_TIMEOUT);

		_portletId = portletId;

		try {
			_timeout = Long.parseLong(defaultTimeout);
		}
		catch (NumberFormatException nfe) {
			_timeout = 5;
		}

		_basicWebDriverActions = new BasicWebDriverActions();
	}

	public LiferayPortletActions(String portletId, long timeout) {
		_portletId = portletId;
		_timeout = timeout;

		_basicWebDriverActions = new BasicWebDriverActions();
	}

	/*
	 * Remove all portlets from the current screen, but to do this the
	 * user should inform any part of the portlet ID, that all portlets with
	 * this part of ID to be removed.
	 */
	public void remove(WebDriver webDriver) {
		List<WebElement> portlets = webDriver.findElements(
			By.xpath(".//*[contains(@id,'" + _portletId + "')]"));

		for (WebElement portlet : portlets) {
			openPortletActionDropDown(portlet, webDriver);
			clickOnPortletConfigurationMenu("Remove", webDriver);
			_basicWebDriverActions.acceptBrowserDialog(webDriver);
		}
	}

	public void setTimeout(long timeout) {
		_timeout = timeout;
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

		WebDriverWait webDriverWait = new WebDriverWait(webDriver, _timeout);

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

	private BasicWebDriverActions _basicWebDriverActions;

	private long _timeout;
	private String _portletId;

}