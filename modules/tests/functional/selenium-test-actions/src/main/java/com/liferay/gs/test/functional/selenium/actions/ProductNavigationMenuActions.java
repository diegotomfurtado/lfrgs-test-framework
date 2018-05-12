package com.liferay.gs.test.functional.selenium.actions;

import com.liferay.gs.test.functional.selenium.properties.SeleniumProperties;
import com.liferay.gs.test.functional.selenium.properties.SeleniumPropertyKeys;
import com.liferay.gs.test.functional.selenium.xpath.XPathStringBuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Andrew Betts
 */
public class ProductNavigationMenuActions {

	/*
	 * Add the portlet on Screen, but to do this, the user should inform the
	 * portlet name and the column that the portlet will appear
	 */
	public void addPortletOnScreen(
		String search, String portletId, String column, WebDriver webDriver) {

		clickOnAddButton(webDriver);
		clickOnApplicationCategory(webDriver);
		searchForPortletByName(search, webDriver);
		dragAndDropPortletToColumn(portletId, column, webDriver);
	}

	public void clickOnAddButton(WebDriver webDriver) {
		long timeout = SeleniumProperties.getInteger(
			SeleniumPropertyKeys.TEST_ACTION_TIMEOUT);

		WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeout);

		webDriverWait.until(
			ExpectedConditions.visibilityOfElementLocated(addButtonLocator));

		webDriverWait.until(
			ExpectedConditions.elementToBeClickable(addButtonLocator));

		webDriver.findElement(addButtonLocator).click();
	}

	public void clickOnApplicationCategory(WebDriver webDriver) {
		long timeout = SeleniumProperties.getInteger(
			SeleniumPropertyKeys.TEST_ACTION_TIMEOUT);

		WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeout);

		webDriverWait.until(
			ExpectedConditions.visibilityOfElementLocated(
				applicationHeadingLocator));

		webDriverWait.until(
			ExpectedConditions.elementToBeClickable(applicationHeadingLocator));

		By portletContentCategories =
			By.cssSelector(".add-content-menu .lfr-content-category");

		boolean isApplicationCategoriesDisplayed =
			webDriver.findElement(portletContentCategories).isDisplayed();

		if (!isApplicationCategoriesDisplayed) {
			webDriverWait.until(
				ExpectedConditions.visibilityOfElementLocated(
					applicationHeadingLocator));

			webDriverWait.until(
				ExpectedConditions.elementToBeClickable(
					applicationHeadingLocator));

			webDriver.findElement(applicationHeadingLocator).click();
		}
	}

	public void dragAndDropPortletToColumn(
		String portletId, String column, WebDriver webDriver) {

		long timeout = SeleniumProperties.getInteger(
			SeleniumPropertyKeys.TEST_ACTION_TIMEOUT);

		WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeout);

		String portletIdXPath = XPathStringBuilder.buildXPathContains(
			"span", "@data-portlet-id", portletId);

		By searchApplicationResultLocator = By.xpath(portletIdXPath);

		By columnLocator = By.xpath(".//*[@id='" + column + "']");

		webDriverWait.until(
			ExpectedConditions.visibilityOfElementLocated(
				searchApplicationResultLocator));
		webDriverWait.until(
			ExpectedConditions.elementToBeClickable(
				searchApplicationResultLocator));

		WebElement element =
			webDriver.findElement(searchApplicationResultLocator);

		WebElement target = webDriver.findElement(columnLocator);

		Actions actions = new Actions(webDriver)
			.dragAndDrop(element, target);

		actions.perform();
	}

	public void searchForPortletByName(String search, WebDriver webDriver) {
		long timeout = SeleniumProperties.getInteger(
			SeleniumPropertyKeys.TEST_ACTION_TIMEOUT);

		WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeout);

		webDriverWait.until(
			ExpectedConditions.visibilityOfElementLocated(
				searchApplicationLocator));

		webDriverWait.until(
			ExpectedConditions.elementToBeClickable(searchApplicationLocator));

		webDriver.findElement(searchApplicationLocator).sendKeys(search);
	}

	private static final By addButtonLocator = By.xpath(
		".//*[@id='_" + LiferayPortletIds.ProductNavigationControlMenuPortlet +
			"_addToggleId']");

	private static final By applicationHeadingLocator = By.xpath(
		".//*[@id='_" + LiferayPortletIds.ProductNavigationControlMenuPortlet +
			"_addApplicationHeading']");

	private static final By searchApplicationLocator = By.xpath(
		".//*[@id='_" + LiferayPortletIds.ProductNavigationControlMenuPortlet +
			"_searchApplication']");

}