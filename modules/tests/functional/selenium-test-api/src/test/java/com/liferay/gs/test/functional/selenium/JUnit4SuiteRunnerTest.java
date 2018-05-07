package com.liferay.gs.test.functional.selenium;

import com.liferay.gs.test.functional.selenium.suite.JUnit4SuiteTest1;
import com.liferay.gs.test.functional.selenium.suite.JUnit4SuiteTest2;
import com.liferay.gs.test.functional.selenium.suite.JUnit4SuiteTest3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Andrew Betts
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
	value = {
		JUnit4SuiteTest1.class,
		JUnit4SuiteTest2.class,
		JUnit4SuiteTest3.class
	}
)
public class JUnit4SuiteRunnerTest {
}