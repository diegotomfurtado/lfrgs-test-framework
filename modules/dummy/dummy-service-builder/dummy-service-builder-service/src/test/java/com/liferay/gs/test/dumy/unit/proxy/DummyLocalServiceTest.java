package com.liferay.gs.test.dumy.unit.proxy;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.gs.test.model.Dummy;
import com.liferay.gs.test.model.impl.DummyImpl;
import com.liferay.gs.test.service.DummyLocalService;
import com.liferay.gs.test.service.impl.DummyLocalServiceImpl;
import com.liferay.gs.test.service.persistence.DummyPersistence;
import com.liferay.gs.test.unit.proxy.DependencyProxyManager;

import com.liferay.gs.test.unit.proxy.InvokableReturnValue;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactory;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;

import java.lang.reflect.Method;
import java.util.Date;

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Andrew Betts
 */
@RunWith(JUnit4.class)
public class DummyLocalServiceTest {

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dependencyProxyManager = new DependencyProxyManager();

		_dummyLocalService = new DummyLocalServiceImpl();

		_dependencyProxyManager.setProxies(_dummyLocalService);

		ConfigurationFactoryUtil.setConfigurationFactory(
			_dependencyProxyManager.getProxyInstance(
				ConfigurationFactory.class,
				(Object proxy, Method method, Object[] args) ->
					_dependencyProxyManager.getProxyInstance(
						Configuration.class,
						(Object proxy1, Method method1, Object[] args1) -> "")
			));
	}

	@Test
	public void testAddDummy() throws Exception {
		// set mock return values

		_dependencyProxyManager.putReturnValue(
			DummyPersistence.class.getName(), "create",
			new Class[] {long.class}, new DummyImpl());

		_dependencyProxyManager.putReturnValue(
			DummyPersistence.class.getName(), "update",
			new Class[] {BaseModel.class},
			((InvokableReturnValue)
				(Object proxy, Method method, Object[] args) -> args[0]));

		_dependencyProxyManager.putReturnValue(
			CounterLocalService.class.getName(), "increment",
			new Class[] {String.class}, 1L);

		// run test

		Date now = new Date();

		Dummy dummy = _dummyLocalService.addDummy(
			"one", true, 3, now, "five");

		Assert.assertEquals(dummy.getField1(), "one");
		Assert.assertEquals(dummy.getField2(), true);
		Assert.assertEquals(dummy.getField3(), 3);
		Assert.assertEquals(dummy.getField4(), now);
		Assert.assertEquals(dummy.getField5(), "five");
	}

	private static DummyLocalService _dummyLocalService;
	private static DependencyProxyManager _dependencyProxyManager;

}