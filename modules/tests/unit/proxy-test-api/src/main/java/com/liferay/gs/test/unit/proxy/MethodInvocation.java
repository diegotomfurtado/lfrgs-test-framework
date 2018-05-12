package com.liferay.gs.test.unit.proxy;

/**
 * @author Andrew Betts
 */
public class MethodInvocation {
	private String _methodName;
	private Object[] _args;

	public MethodInvocation(String methodName, Object[] args) {
		_methodName = methodName;
		_args = args;
	}

	public String getMethodName() {
		return _methodName;
	}

	public Object[] getArgs() {
		return _args;
	}

}
