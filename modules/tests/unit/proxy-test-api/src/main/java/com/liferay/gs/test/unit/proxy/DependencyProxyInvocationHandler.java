package com.liferay.gs.test.unit.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Andrew Betts
 */
public class DependencyProxyInvocationHandler implements InvocationHandler {

	public DependencyProxyInvocationHandler(
		String className, Map<MethodKey, Object> returnValues) {

		_className = className;
		_callMap = null;
		_returnValues = returnValues;
	}

	public DependencyProxyInvocationHandler(
		String className, Map<MethodKey, Object> returnValues,
		Map<String, List<MethodInvocation>> callMap) {

		_className = className;
		_callMap = callMap;
		_returnValues = returnValues;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
		throws Throwable {

		if (_callMap != null) {
			List<MethodInvocation> calls = _callMap.computeIfAbsent(
				_className, key -> new ArrayList<>());

			calls.add(new MethodInvocation(method.getName(), args));
		}

		MethodKey methodKey = new MethodKey(
			_className, method.getName(), method.getParameterTypes());

		Object returnValue = _returnValues.get(methodKey);

		if (returnValue instanceof InvokableReturnValue) {
			return ((InvokableReturnValue)returnValue).invoke(
				proxy, method, args);
		}

		return returnValue;
	}

	private String _className;
	private Map<String, List<MethodInvocation>> _callMap;
	private Map<MethodKey, Object> _returnValues;

}
