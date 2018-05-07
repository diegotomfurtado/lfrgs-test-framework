package com.liferay.gs.test.functional.selenium.support;

import com.liferay.gs.test.functional.selenium.constants.BrowserDrivers;
import com.liferay.gs.test.functional.selenium.constants.Environment;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;

/**
 * @author Andrew Betts
 */
public class WebDriverManager {

	synchronized public static void init() {
		Environment.OSName osName = Environment.getOSName();
		boolean is64Bit = Environment.is64Bit();

		ClassLoader classLoader = WebDriverManager.class.getClassLoader();

		String driverPath = BrowserDrivers.BROWSER_DRIVER_DIRECTORY;

		try {
			URL url = classLoader.getResource("drivers");

			if (url != null) {
				File driverFolder = new File(url.toURI());

				driverPath = driverFolder.getPath();
			}
		}
		catch (Exception e) {
			String systemPropertyDriverPath = System.getProperty(
				BrowserDrivers.BROWSER_DRIVER_DIRECTORY_SYSTEM_PROPERTY);

			if (systemPropertyDriverPath != null) {
				driverPath = systemPropertyDriverPath;
			}
		}

		if (!driverPath.endsWith("/")) {
			driverPath += "/";
		}

		_availableWebDrivers.clear();

		_availableWebDrivers.add(BrowserDrivers.BROWSER_HTML_UNIT_TEST);

		if (osName == Environment.OSName.LINUX) {
			if (is64Bit) {
				System.setProperty(
					BrowserDrivers.SYSTEM_PROPERTY_CHROME_DRIVER,
					driverPath +
						BrowserDrivers.CHROME_DRIVER_LINUX64);
				System.setProperty(
					BrowserDrivers.SYSTEM_PROPERTY_FIREFOX_DRIVER,
					driverPath +
						BrowserDrivers.FIREFOX_DRIVER_LINUX32);

				_availableWebDrivers.add(BrowserDrivers.BROWSER_CHROME);
				_availableWebDrivers.add(BrowserDrivers.BROWSER_FIREFOX);
			}
			else {
				System.setProperty(
					BrowserDrivers.SYSTEM_PROPERTY_FIREFOX_DRIVER,
					driverPath +
						BrowserDrivers.FIREFOX_DRIVER_LINUX32);

				_availableWebDrivers.add(BrowserDrivers.BROWSER_FIREFOX);
			}
		}
		else if (osName == Environment.OSName.MAC) {
			if (is64Bit) {
				System.setProperty(
					BrowserDrivers.SYSTEM_PROPERTY_CHROME_DRIVER,
					driverPath +
						BrowserDrivers.CHROME_DRIVER_MAC64);
				System.setProperty(
					BrowserDrivers.SYSTEM_PROPERTY_FIREFOX_DRIVER,
					driverPath +
						BrowserDrivers.FIREFOX_DRIVER_MAC32);

				_availableWebDrivers.add(BrowserDrivers.BROWSER_CHROME);
				_availableWebDrivers.add(BrowserDrivers.BROWSER_FIREFOX);
			}
			else {
				System.setProperty(
					BrowserDrivers.SYSTEM_PROPERTY_FIREFOX_DRIVER,
					driverPath +
						BrowserDrivers.FIREFOX_DRIVER_MAC32);

				_availableWebDrivers.add(BrowserDrivers.BROWSER_FIREFOX);
			}
		}
		else if (osName == Environment.OSName.WINDOWS) {
			if (is64Bit) {
				System.setProperty(
					BrowserDrivers.SYSTEM_PROPERTY_CHROME_DRIVER,
					driverPath +
						BrowserDrivers.CHROME_DRIVER_WIN32);
				System.setProperty(
					BrowserDrivers.SYSTEM_PROPERTY_FIREFOX_DRIVER,
					driverPath +
						BrowserDrivers.FIREFOX_DRIVER_WIN32);
				System.setProperty(
					BrowserDrivers.INTERNET_EXPLORER_SYSTEM_PROPERTY,
					driverPath +
						BrowserDrivers.INTERNET_EXPLORER_WIN64);

				_availableWebDrivers.add(BrowserDrivers.BROWSER_CHROME);
				_availableWebDrivers.add(BrowserDrivers.BROWSER_FIREFOX);
				_availableWebDrivers.add(
					BrowserDrivers.BROWSER_INTERNET_EXPLORER);
			}
			else {
				System.setProperty(
					BrowserDrivers.SYSTEM_PROPERTY_CHROME_DRIVER,
					driverPath +
						BrowserDrivers.CHROME_DRIVER_WIN32);
				System.setProperty(
					BrowserDrivers.SYSTEM_PROPERTY_FIREFOX_DRIVER,
					driverPath +
						BrowserDrivers.FIREFOX_DRIVER_WIN32);
				System.setProperty(
					BrowserDrivers.INTERNET_EXPLORER_SYSTEM_PROPERTY,
					driverPath +
						BrowserDrivers.INTERNET_EXPLORER_WIN32);

				_availableWebDrivers.add(BrowserDrivers.BROWSER_CHROME);
				_availableWebDrivers.add(BrowserDrivers.BROWSER_FIREFOX);
				_availableWebDrivers.add(
					BrowserDrivers.BROWSER_INTERNET_EXPLORER);
			}
		}
	}

	public WebDriver getWebDriver() {
		return getWebDriver(BrowserDrivers.BROWSER_HTML_UNIT_TEST, false);
	}

	public WebDriver getWebDriver(String browserType) {
		return getWebDriver(browserType, false);
	}

	public WebDriver getWebDriver(
		String browserType, boolean stopActiveService) {

		if (_availableWebDrivers.isEmpty()) {
			throw new IllegalStateException("no web drivers are available");
		}

		if (!_availableWebDrivers.contains(browserType)) {
			throw new IllegalArgumentException(
				"no web driver available for " + browserType);
		}

		if (_webDriver != null) {
			_webDriver.quit();
		}

		if (stopActiveService && (_activeService != null)) {
			_activeService.stop();
		}

		DriverService driverService = null;
		Capabilities capabilities = null;

		switch (browserType) {
			case BrowserDrivers.BROWSER_CHROME:
				if (_chromeDriverService == null) {
					_chromeDriverService =
						ChromeDriverService.createDefaultService();
				}

				driverService = _chromeDriverService;
				capabilities = new ChromeOptions();

				break;

			case BrowserDrivers.BROWSER_FIREFOX:
				if (_geckoDriverService == null) {
					_geckoDriverService =
						GeckoDriverService.createDefaultService();
				}

				driverService = _geckoDriverService;
				capabilities = new FirefoxOptions();

				break;

			case BrowserDrivers.BROWSER_INTERNET_EXPLORER:
				if (_ieDriverService == null) {
					_ieDriverService =
						InternetExplorerDriverService.createDefaultService();
				}

				driverService = _ieDriverService;
				capabilities = new InternetExplorerOptions();

				break;

			default:
				if (_webDriver != null) {
					_webDriver.quit();

					_webDriver = null;
				}

				if (_activeService != null) {
					_activeService.stop();

					_activeService = null;
				}

				return new HtmlUnitDriver();
		}

		if (!driverService.equals(_activeService)) {
			if (_activeService != null) {
				_activeService.stop();
			}

			_activeService = driverService;
		}

		try {
			driverService.start();
		}
		catch (IOException ioe) {
			throw new UncheckedIOException(ioe);
		}

		_webDriver = new RemoteWebDriver(driverService.getUrl(), capabilities);

		return _webDriver;
	}

	public boolean isAvailable(String browser) {
		return _availableWebDrivers.contains(browser);
	}

	public void stopService() {
		if (_webDriver != null) {
			_webDriver.quit();
		}

		if (_activeService != null) {
			_activeService.stop();
		}
	}

	private static final List<String> _availableWebDrivers = new ArrayList<>();

	private DriverService _activeService;
	private WebDriver _webDriver;

	private ChromeDriverService _chromeDriverService;
	private GeckoDriverService _geckoDriverService;
	private InternetExplorerDriverService _ieDriverService;

}
