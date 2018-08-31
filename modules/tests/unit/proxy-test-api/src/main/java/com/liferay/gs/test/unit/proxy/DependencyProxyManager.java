package com.liferay.gs.test.unit.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Andrew Betts
 */
public class DependencyProxyManager {

	@SuppressWarnings("unchecked")
	public <I> I getCallCollectingProxyInstance(Class<I> interfaceClass) {
		if (!interfaceClass.isInterface()) {
			throw new IllegalArgumentException(
				"did you mean to make a test class instead? " +
					"only able to create proxies on interfaces");
		}

		return (I)Proxy.newProxyInstance(
			interfaceClass.getClassLoader(),
			new Class[] {interfaceClass},
			new DependencyProxyInvocationHandler(
				interfaceClass.getName(), returnValues, callMap));
	}

	public List<MethodInvocation> getMethodInvocations(
		Class<?> interfaceClass) {

		return callMap.get(interfaceClass.getName());
	}

	@SuppressWarnings("unchecked")
	public <I> I getProxyInstance(Class<I> interfaceClass) {
		if (!interfaceClass.isInterface()) {
			throw new IllegalArgumentException(
				"did you mean to make a test class instead? " +
					"only able to create proxies on interfaces");
		}

		return getProxyInstance(
			interfaceClass,
			new DependencyProxyInvocationHandler(
				interfaceClass.getName(), returnValues)
		);
	}

	@SuppressWarnings("unchecked")
	public <I> I getProxyInstance(
		Class<I> interfaceClass, InvocationHandler invocationHandler) {

		if (!interfaceClass.isInterface()) {
			throw new IllegalArgumentException(
				"did you mean to make a test class instead? " +
					"only able to create proxies on interfaces");
		}

		return (I)Proxy.newProxyInstance(
			interfaceClass.getClassLoader(),
			new Class<?>[] { interfaceClass },
			invocationHandler
		);
	}

	public void putReturnValue(MethodKey testMethodKey, Object returnValue) {
		returnValues.put(testMethodKey, returnValue);
	}

	public void putReturnValue(
		String className, String methodName, Object returnValue) {

		putReturnValue(
			new MethodKey(className, methodName, new Class[0]), returnValue);
	}

	public void putReturnValue(
		String className, String methodName, Class[] parameterTypes,
		Object returnValue) {

		putReturnValue(
			new MethodKey(className, methodName, parameterTypes), returnValue);
	}

	public void reset() {
		returnValues.clear();
		callMap.clear();
	}

	public <D> List<Field> setProxies(D testDependency) throws Exception {
		List<Field> fields = new ArrayList<>();

		Class<?> concreteClass = testDependency.getClass();

		Class<?> currentClass = concreteClass;

		while (currentClass.getSuperclass() != null) {
			if (currentClass != DependencyProxyManager.class) {
				for (Field declaredField : currentClass.getDeclaredFields()) {
					fields.add(declaredField);
				}
			}

			currentClass = currentClass.getSuperclass();
		}

		ClassLoader classLoader = concreteClass.getClassLoader();

		List<Field> unProxiableFields = new ArrayList<>();

		for (Field field : fields) {
			Class<?> fieldType = field.getType();

			if (fieldType.equals(Map.class) &&
				(RETURN_VALUES_FIELD_NAME.equals(field.getName()) ||
					CALL_MAP_FIELD_NAME.equals(field.getName()))) {

				continue;
			}

			field.setAccessible(true);

			if (!fieldType.isInterface()) {
				unProxiableFields.add(field);

				continue;
			}

			field.set(
				testDependency,
				Proxy.newProxyInstance(
					classLoader,
					new Class<?>[] { fieldType },
					new DependencyProxyInvocationHandler(
						fieldType.getName(), returnValues)
				));
		}

		return unProxiableFields;
	}

	private static final String RETURN_VALUES_FIELD_NAME = "returnValues";

	private static final String CALL_MAP_FIELD_NAME = "callMap";

	private Map<MethodKey, Object> returnValues = new HashMap<>();
	private Map<String, List<MethodInvocation>> callMap = new HashMap<>();

}