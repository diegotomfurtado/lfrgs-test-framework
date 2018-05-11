package com.liferay.gs.test.unit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Andrew Betts
 */
@RunWith(JUnit4.class)
public class MapBackedInvocationHandlerTest {

	@Test
	public void testInvoke() {
		String testObjectClassName = TestMap.class.getName();

		Map<MethodKey, Object> returnValues = new HashMap<>();

		returnValues.put(
			new MethodKey(
				testObjectClassName, "test", new Class[0]),
			true);

		MapBackedInvocationHandler mapBackedInvocationHandler =
			new MapBackedInvocationHandler(
				testObjectClassName, returnValues);

		ClassLoader classLoader = getClass().getClassLoader();

		Testable proxiedTestObject =
			(Testable)Proxy.newProxyInstance(
				classLoader, new Class[] {Testable.class},
				mapBackedInvocationHandler);

		Assert.assertTrue(proxiedTestObject.test());
	}

	private interface Testable {

		public boolean test();

	}

	private static class TestMap<K, V> extends HashMap<K, V>
		implements Testable {

		@Override
		public V get(Object key) {
			return super.get(key);
		}

		public boolean test() {
			return false;
		}

	}

}