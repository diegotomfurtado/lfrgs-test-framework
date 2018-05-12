package com.liferay.gs.test.unit.proxy;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Andrew Betts
 */
public class MethodKey {

	public MethodKey(
		String className, String methodName, Class<?>[] parameterTypes) {

		if ((className == null) || (methodName == null) ||
			(parameterTypes == null)) {

			throw new IllegalArgumentException(
				"Constructor arguments must not be null");
		}

		_className = className;
		_methodName = methodName;
		_parameterTypes = parameterTypes;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MethodKey)) {
			return false;
		}

		MethodKey methodKey = (MethodKey)object;

		if (!Objects.equals(_className, methodKey._className) ||
			!Objects.equals(_methodName, methodKey._methodName) ||
			!Arrays.equals(_parameterTypes, methodKey._parameterTypes)) {

			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(_className, _methodName, _parameterTypes.length);
	}

	@Override
	public String toString() {
		return "className: " + _className + ", methodName: " + _methodName +
			", parameterTypes: " + Arrays.toString(_parameterTypes);
	}

	private String _className;
	private String _methodName;
	private Class<?>[] _parameterTypes;

}
