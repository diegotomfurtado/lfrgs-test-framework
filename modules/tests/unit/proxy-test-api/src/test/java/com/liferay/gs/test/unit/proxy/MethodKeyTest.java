package com.liferay.gs.test.unit.proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Andrew Betts
 */
@RunWith(JUnit4.class)
public class MethodKeyTest {

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalClassNameArgument() {
		new MethodKey(null,"", new Class[0]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalMethodNameArgument() {
		new MethodKey("", null, new Class[0]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalParameterTypesArgument() {
		new MethodKey("", "", null);
	}

}