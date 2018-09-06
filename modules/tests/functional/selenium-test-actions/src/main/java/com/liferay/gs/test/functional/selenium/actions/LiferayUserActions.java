package com.liferay.gs.test.functional.selenium.actions;

import com.liferay.gs.test.functional.selenium.properties.SeleniumProperties;
import com.liferay.gs.test.functional.selenium.properties.SeleniumPropertyKeys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.function.Supplier;

/**
 * @author Andrew Betts
 */
public class LiferayUserActions {

	public LiferayUserActions() {
		_webDriverActions = new WebDriverActions();
	}

	public Boolean acceptUserTerms(WebDriver webDriver) {
		WebElement termsOfUsePortlet = _webDriverActions.fetchWebElement(
			By.id("portlet_" + LiferayPortletIds.TermsOfUse), webDriver);
		
		if (termsOfUsePortlet == null) {
			return null;
		}

		WebElement agreeButton =
			_webDriverActions.fetchButtonByName("I Agree", false, webDriver);

		if (agreeButton == null) {
			return false;
		}

		agreeButton.click();

		return true;
	}

	public Boolean setPasswordReminder(WebDriver webDriver) {
		WebElement passwordReminderPortlet = _webDriverActions.fetchWebElement(
			By.id("portlet_" + LiferayPortletIds.PasswordReminder), webDriver);

		if (passwordReminderPortlet == null) {
			return null;
		}

		WebElement reminderQueryAnswer = _webDriverActions.fetchWebElement(
			By.id("reminderQueryAnswer"), webDriver);

		if (reminderQueryAnswer == null) {
			return false;
		}

		reminderQueryAnswer.sendKeys("test");

		WebElement saveButton = _webDriverActions.fetchButtonByName(
			"Save", false, webDriver);

		if (saveButton == null) {
			 return false;
		}

		saveButton.click();

		return true;
	}

	public Boolean signIn(
		String login, String password, Supplier<Boolean> successTest,
		WebDriver webDriver) {

		String baseURL = SeleniumProperties.get(
			SeleniumPropertyKeys.TEST_BASE_URL);

		WebElement signInButton = _webDriverActions.fetchWebElement(
			By.cssSelector("sign-in"), webDriver);

		if (signInButton == null) {
			webDriver.navigate().to(baseURL + "/c/portal/login");

			WebElement loginElement = _webDriverActions.fetchWebElement(
				By.id("_" + LiferayPortletIds.LoginPortlet + "_login"),
				webDriver);

			if (loginElement == null) {
				return false;
			}

			loginElement.clear();
			loginElement.sendKeys(login);

			WebElement passwordElement = _webDriverActions.fetchWebElement(
				By.id("_" + LiferayPortletIds.LoginPortlet + "_password"),
				webDriver);

			if (passwordElement == null) {
				return false;
			}

			passwordElement.clear();
			passwordElement.sendKeys(password);

			signInButton = _webDriverActions.fetchButtonByName(
				"Sign In", false, webDriver);
		}


		if (signInButton == null) {
			return null;
		}

		signInButton.click();

		if (successTest == null) {
			return true;
		}

		Boolean success = successTest.get();

		if (success == null || success) {
			return true;
		}

		return false;
	}

	public Boolean signIn(String login, String password, WebDriver webDriver) {
		return signIn(
			login, password,
			() -> {
				Boolean userTerms = this.acceptUserTerms(webDriver);
				Boolean passwordReminder = this.setPasswordReminder(webDriver);

				if (userTerms != null && passwordReminder != null) {
					return userTerms && passwordReminder;
				}

				if (userTerms != null) {
					return userTerms;
				}

				if (passwordReminder != null) {
					return passwordReminder;
				}

				return true;
			},
			webDriver);
	}

	public Boolean signOut(WebDriver webDriver) {
		String baseURL = SeleniumProperties.get(
			SeleniumPropertyKeys.TEST_BASE_URL);

		webDriver.navigate().to(baseURL + "/c/portal/logout");

		return null;
	}

	private WebDriverActions _webDriverActions;

}