package com.liferay.gs.test.functional.cucumber.hook;

import gherkin.TagExpression;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.Tag;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Andrew Betts
 */
public abstract class BaseCucumberHookExtension
	implements CucumberHookExtension {

	public BaseCucumberHookExtension(String[] tagExpressions, int order) {
		_order = order;

		if (tagExpressions != null) {
			_tagExpression = new TagExpression(Arrays.asList(tagExpressions));
		}
	}

	@Override
	public void after(Reporter reporter) {
	}

	@Override
	public void before(Reporter reporter) {
	}

	@Override
	public int compareTo(CucumberHookExtension cucumberHookExtension) {
		if (cucumberHookExtension == null) {
			return this.order();
		}

		return Integer.compare(this.order(), cucumberHookExtension.order());
	}

	@Override
	public boolean matches(Collection<Tag> tags) {
		if ((_tagExpression == null) || _tagExpression.isEmpty()) {
			return true;
		}

		return _tagExpression.evaluate(tags);
	}

	@Override
	public int order() {
		return _order;
	}

	private TagExpression _tagExpression;
	private int _order;

}