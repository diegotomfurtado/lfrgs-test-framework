package com.liferay.gs.test.unit.proxy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author Andrew Betts
 */
@RunWith(JUnit4.class)
public class DependencyProxyManagerTest {

	@Test
	public void testCallCollectingProxy() {
		DependencyProxyManager dependencyProxyManager =
			new DependencyProxyManager();

		Interface1 interface1 =
			dependencyProxyManager.getCallCollectingProxyInstance(
				Interface1.class);

		dependencyProxyManager.putReturnValue(
			new MethodKey(
				Interface1.class.getName(), "test1WithArg",
				new Class[] {Object.class}),
			true);

		Object first = new Object();
		Object second = new Object();

		interface1.test1WithArg(first);
		interface1.test1WithArg(second);

		List<MethodInvocation> methodInvocations =
			dependencyProxyManager.getMethodInvocations(Interface1.class);

		Assert.assertEquals(2, methodInvocations.size());

		Assert.assertEquals(
			"test1WithArg", methodInvocations.get(0).getMethodName());
		Assert.assertArrayEquals(
			new Object[] {first}, methodInvocations.get(0).getArgs());

		Assert.assertEquals(
			"test1WithArg", methodInvocations.get(1).getMethodName());
		Assert.assertArrayEquals(
			new Object[] {second}, methodInvocations.get(1).getArgs());
	}

	@Test
	public void testSetProxies() throws Exception {
		DependencyProxyManager dependencyProxyManager =
			new DependencyProxyManager();

		dependencyProxyManager.putReturnValue(
			new MethodKey(
				Interface1.class.getName(), "test1", new Class[0]),
			true);
		dependencyProxyManager.putReturnValue(
			new MethodKey(
				Interface2.class.getName(), "test2", new Class[0]),
			true);
		dependencyProxyManager.putReturnValue(
			new MethodKey(
				Class3.class.getName(), "test3", new Class[0]),
			true);

		TestDependency testDependency = new TestDependency();

		List<Field> fields = dependencyProxyManager.setProxies(testDependency);

		Assert.assertEquals(1, fields.size());
		Assert.assertEquals(Class3.class, fields.get(0).getType());

		Assert.assertEquals(testDependency.test1(), true);
		Assert.assertEquals(testDependency.test2(), true);
		Assert.assertEquals(testDependency.test3(), false);
	}

	private interface Interface1 {
		boolean test1();

		void test1WithArg(Object obj);
	}

	private interface Interface2 {
		boolean test2();
	}

	private static class Class1 implements Interface1 {

		public boolean test1() {
			return false;
		}

		public void test1WithArg(Object obj) {
		}

	}

	private static class Class2 implements Interface2 {

		public boolean test2() {
			return false;
		}

	}

	private static class Class3 {

		boolean test3() {
			return false;
		}

	}

	private static class TestDependency {

		public TestDependency() {
			interface1 = new Class1();
			interface2 = new Class2();
			class3 = new Class3();
		}

		public boolean test1() {
			return interface1.test1();
		}

		public boolean test2() {
			return interface2.test2();
		}

		public boolean test3() {
			return class3.test3();
		}

		private Interface1 interface1;

		private Interface2 interface2;

		private Class3 class3;

	}

}
