package com.liferay.gs.test.unit;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author Andrew Betts
 */
public class MapBackedInvocationHandler implements InvocationHandler {

	public MapBackedInvocationHandler(
		String className, Map<MethodKey, Object> returnValues) {
		_className = className;
		_returnValues = returnValues;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
		throws Throwable {

		MethodKey testMethodKey = new MethodKey(
			_className, method.getName(), method.getParameterTypes());

		return _returnValues.get(testMethodKey);
	}

	private String _className;
	private Map<MethodKey, Object> _returnValues;

}
