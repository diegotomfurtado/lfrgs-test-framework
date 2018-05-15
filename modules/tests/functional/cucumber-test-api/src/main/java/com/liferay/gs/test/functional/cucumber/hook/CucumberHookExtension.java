package com.liferay.gs.test.functional.cucumber.hook;

import gherkin.formatter.Reporter;
import gherkin.formatter.model.Tag;

import java.util.Collection;

/**
 * @author Andrew Betts
 */
public interface CucumberHookExtension
	extends Comparable<CucumberHookExtension> {

	public void after(Reporter reporter);

	public void before(Reporter reporter);

	public boolean matches(Collection<Tag> tags);

	public int order();

}