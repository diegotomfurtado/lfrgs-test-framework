package com.liferay.gs.test.functional.selenium.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Andrew Betts
 */
public class ProductNavigationMenuActions extends TimeoutAction {

	public ProductNavigationMenuActions(long timeout) {
		 super(timeout);
	}

	/*
	 * Add the portlet on Screen, but to do this, the user should inform the
	 * portlet name and the column that the portlet will appear
	 */
	public void addPortletOnScreen(
		String portletName, String column, WebDriver webDriver) {

		clickOnAddButton(webDriver);
		clickOnApplicationCategory(webDriver);
		searchForPortletByName(portletName, webDriver);
		dragAndDropPortletToColumn(portletName, column, webDriver);
	}

	public void dragAndDropPortletToColumn(
		String portletName, String column, WebDriver webDriver) {

		WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeout);

		By searchApplicationResultLocator = By.xpath(
			".//*[@id='_" +
				LiferayPortletIds.ProductNavigationControlMenuPortlet +
					"_portletCategory0']//*[contains (text(), '" +
						portletName + "')]");

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

	public void searchForPortletByName(String portletName, WebDriver webDriver) {
		WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeout);

		webDriverWait.until(
			ExpectedConditions.visibilityOfElementLocated(
				searchApplicationLocator));

		webDriverWait.until(
			ExpectedConditions.elementToBeClickable(searchApplicationLocator));

		webDriver.findElement(searchApplicationLocator).sendKeys(portletName);
	}

	public void clickOnAddButton(WebDriver webDriver) {
		WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeout);

		webDriverWait.until(
			ExpectedConditions.visibilityOfElementLocated(addButtonLocator));

		webDriverWait.until(
			ExpectedConditions.elementToBeClickable(addButtonLocator));

		webDriver.findElement(addButtonLocator).click();
	}

	public void clickOnApplicationCategory(WebDriver webDriver) {
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