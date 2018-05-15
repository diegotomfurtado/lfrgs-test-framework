package com.liferay.gs.test.functional.selenium.actions;

import com.liferay.gs.test.functional.selenium.properties.SeleniumProperties;
import com.liferay.gs.test.functional.selenium.properties.SeleniumPropertyKeys;
import com.liferay.gs.test.functional.selenium.xpath.XPathStringBuilder;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Andrew Betts
 */
public class WebDriverActions {

	public void acceptBrowserDialog(WebDriver webDriver) {
		Alert alert = webDriver.switchTo().alert();

		alert.accept();
	}

	public WebElement fetchButtonByName(
		String name, boolean exact, WebDriver webDriver) {

		return fetchByXPath("button", ".", name, exact, webDriver);
	}

	public WebElement fetchByDataQAId(
		String tagName, String qaId, boolean exact, WebDriver webDriver) {

		return fetchByXPath(tagName, "@data-qa-id", qaId, exact, webDriver);
	}

	public WebElement fetchByQACssClass(String cssClass, WebDriver webDriver) {
		return fetchWebElement(
			By.cssSelector(".qa-css-" + cssClass), webDriver);
	}

	public WebElement fetchByXPath(
		String tagName, String attributeName, String attributeValue,
		boolean exact, WebDriver webDriver) {

		String xPath = "";

		if (exact) {
			xPath = XPathStringBuilder.buildXPathEquals(
				tagName, attributeName, attributeValue);
		}
		else {
			xPath = XPathStringBuilder.buildXPathContains(
				tagName, attributeName, attributeValue);
		}

		try {
			return fetchWebElement(By.xpath(xPath), webDriver);
		}
		catch (NoSuchElementException nsee) {
			return null;
		}
	}

	public WebElement fetchWebElement(By by, WebDriver webDriver) {
		try {
			long timeout = SeleniumProperties.getInteger(
				SeleniumPropertyKeys.TEST_ACTION_TIMEOUT);

			WebDriverWait webDriverWait = new WebDriverWait(
				webDriver, timeout);

			webDriverWait.until(ExpectedConditions.elementToBeClickable(by));

			return webDriver.findElement(by);
		}
		catch (NoSuchElementException nsee) {
			return null;
		}
		catch (TimeoutException te) {
			return null;
		}
	}

}