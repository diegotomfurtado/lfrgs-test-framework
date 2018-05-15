package com.liferay.gs.test.functional.cucumber.hook;

import gherkin.formatter.model.Tag;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Andrew Betts
 */
public class CucumberHookExtensionRegistry {

	public static void clear() {
		_hooks.clear();
	}

	public static List<CucumberHookExtension> getHooks(Set<Tag> tags) {
		List<CucumberHookExtension> hooks = new ArrayList<>(_hooks.size());

		for (CucumberHookExtension hook : _hooks) {
			if (hook.matches(tags)) {
				hooks.add(hook);
			}
		}

		return hooks;
	}

	public static void register(CucumberHookExtension cucumberHookExtension) {
		_hooks.add(cucumberHookExtension);

		_hooks.sort(_hookExtensionComparator);
	}

	public static void unregister(CucumberHookExtension cucumberHookExtension) {
		int index = _hooks.lastIndexOf(cucumberHookExtension);

		if (index < 0) {
			return;
		}

		_hooks.remove(index);
	}

	private static class CucumberHookExtensionCompator
		implements Comparator<CucumberHookExtension> {

		@Override
		public int compare(
			CucumberHookExtension che1, CucumberHookExtension che2) {

			if ((che1 == null) && (che2 == null)) {
				return 0;
			}

			if (che2 == null) {
				return -1;
			}

			if (che1 == null) {
				return 1;
			}

			return che2.compareTo(che1);
		}

	}

	private static Comparator<CucumberHookExtension> _hookExtensionComparator =
		new CucumberHookExtensionCompator();

	private static List<CucumberHookExtension> _hooks = new LinkedList<>();

}