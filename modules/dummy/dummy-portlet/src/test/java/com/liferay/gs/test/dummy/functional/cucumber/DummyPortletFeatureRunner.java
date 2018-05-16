package com.liferay.gs.test.dummy.functional.cucumber;

import com.liferay.gs.test.dummy.functional.cucumber.hooks.DummyFeatureHookExtension;
import com.liferay.gs.test.functional.cucumber.LiferayCucumberRunner;
import com.liferay.gs.test.functional.cucumber.hook.CucumberHookExtensionDefinition;
import com.liferay.gs.test.functional.selenium.constants.BrowserDrivers;
import com.liferay.gs.test.functional.selenium.runner.Browsers;

import cucumber.api.CucumberOptions;

import org.junit.runner.RunWith;

/**
 * @author Andrew Betts
 */
@Browsers({BrowserDrivers.BROWSER_CHROME})
@CucumberOptions(
	features = {"src/test/resources/feature/DummyPortlet.feature"},
	glue = {"com.liferay.gs.test.dummy.functional.cucumber.step"}
)
@CucumberHookExtensionDefinition(DummyFeatureHookExtension.class)
@RunWith(LiferayCucumberRunner.class)
public class DummyPortletFeatureRunner {
}
