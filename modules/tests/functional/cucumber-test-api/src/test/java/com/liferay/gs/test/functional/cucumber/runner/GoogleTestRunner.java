package com.liferay.gs.test.functional.cucumber.runner;

import com.liferay.gs.test.functional.cucumber.LiferayCucumberRunner;
import com.liferay.gs.test.functional.selenium.constants.BrowserDrivers;
import com.liferay.gs.test.functional.selenium.runner.Browsers;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author Andrew Betts
 */
@Browsers({BrowserDrivers.BROWSER_CHROME})
@CucumberOptions(
	features = {"src/test/resources/features/Google.feature"},
	glue = {"com.liferay.functional.test.cucumber.step"}
)
@RunWith(LiferayCucumberRunner.class)
public class GoogleTestRunner {
}
