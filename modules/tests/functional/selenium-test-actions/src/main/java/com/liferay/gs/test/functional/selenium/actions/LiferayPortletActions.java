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
		_portletId = portletId;

		_baseWebDriverActions = new BaseWebDriverActions();
	}

	public void remove(WebDriver webDriver) {
		List<WebElement> portlets = webDriver.findElements(
			By.xpath(".//*[contains(@id,'" + _portletId + "')]"));

		for (WebElement portlet : portlets) {
			openPortletActionDropDown(portlet, webDriver);

			clickOnPortletConfigurationMenu("Remove", webDriver);

			_baseWebDriverActions.acceptBrowserDialog(webDriver);
		}
	}

	public WebElement getPortlet(WebDriver webDriver) {
		return _baseWebDriverActions.fetchWebElement(
			By.id("portlet_" + _portletId), webDriver);
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

	private BaseWebDriverActions _baseWebDriverActions;

	private String _portletId;

}