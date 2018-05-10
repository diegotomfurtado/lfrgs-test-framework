package com.liferay.gs.test.unit;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Andrew Betts
 */
public class TestDependencyProxyManager<T> {

	public List<MethodInvocation> getMethodInvocations(
		String invocationClassName) {

		return callMap.get(invocationClassName);
	}

	public void puReturnValue(TestMethodKey testMethodKey, Object object) {
		returnValues.put(testMethodKey, object);
	}

	public void setProxies(T testDependency) throws Exception {
		returnValues.clear();
		callMap.clear();

		List<Field> fields = new ArrayList<>();

		Class<?> concreteClass = testDependency.getClass();

		Class<?> currentClass = concreteClass;

		while (currentClass.getSuperclass() != null) {
			if (currentClass != TestDependencyProxyManager.class) {
				for (Field declaredField : currentClass.getDeclaredFields()) {
					fields.add(declaredField);
				}
			}

			currentClass = currentClass.getSuperclass();
		}

		ClassLoader classLoader = concreteClass.getClassLoader();

		for (Field field : fields) {
			Class<?> declaringClass = field.getType();

			if (declaringClass.equals(Map.class) &&
				(RETURN_VALUES_FIELD_NAME.equals(field.getName()) ||
					CALL_MAP_FIELD_NAME.equals(field.getName()))) {

				continue;
			}

			field.setAccessible(true);

			field.set(
				testDependency,
				Proxy.newProxyInstance(
					classLoader,
					new Class<?>[] { declaringClass },
					new MapBackedInvocationHandler(
						declaringClass.getName(), returnValues)
				));
		}
	}

	@SuppressWarnings("unchecked")
	public <I> I getCallCollectingProxyInstance(Class<I> invocationClass) {
		return (I)Proxy.newProxyInstance(
			invocationClass.getClassLoader(),
			new Class[] {invocationClass},
			((proxy, method, args) -> {
				List<MethodInvocation> calls = callMap.get(
					invocationClass.getName());

				if (calls == null) {
					calls = new ArrayList<>();

					callMap.put(invocationClass.getName(), calls);
				}

				calls.add(new MethodInvocation(method.getName(), args));

				return returnValues.get(
					new TestMethodKey(
						invocationClass.getName(), method.getName(),
						method.getParameterTypes()));
			}));
	}

	private static final String RETURN_VALUES_FIELD_NAME = "returnValues";

	private static final String CALL_MAP_FIELD_NAME = "callMap";

	private Map<TestMethodKey, Object> returnValues = new HashMap<>();
	private Map<String, List<MethodInvocation>> callMap = new HashMap<>();

}