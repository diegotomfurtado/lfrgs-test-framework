package com.liferay.gs.test.dummy.unit.proxy;

import com.liferay.gs.test.dummy.portlet.EditDummyMVCRenderCommand;
import com.liferay.gs.test.model.Dummy;
import com.liferay.gs.test.service.DummyLocalService;
import com.liferay.gs.test.unit.proxy.DependencyProxyManager;
import com.liferay.gs.test.unit.proxy.MethodInvocation;
import com.liferay.gs.test.unit.proxy.MethodKey;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Andrew Betts
 */
@RunWith(JUnit4.class)
public class EditDummyRenderCommandTest {

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dependencyProxyManager = new DependencyProxyManager();

		_editDummyMVCRenderCommand = new EditDummyMVCRenderCommand();

		_dependencyProxyManager.setProxies(_editDummyMVCRenderCommand);

		_renderRequest = _dependencyProxyManager.getCallCollectingProxyInstance(
			RenderRequest.class);
		_renderResponse =
			_dependencyProxyManager.getCallCollectingProxyInstance(
				RenderResponse.class);

		_dummy = _dependencyProxyManager.getProxyInstance(Dummy.class);
	}

	@Test
	public void testDoRender() throws Exception {
		// set mock return values

		_dependencyProxyManager.putReturnValue(
			new MethodKey(
				DummyLocalService.class.getName(), "fetchDummy",
				new Class[] {long.class}),
			_dummy);

		// run test

		_editDummyMVCRenderCommand.render(_renderRequest, _renderResponse);

		List<MethodInvocation> methodInvocations =
			_dependencyProxyManager.getMethodInvocations(RenderRequest.class);

		for (MethodInvocation methodInvocation : methodInvocations) {
			if (_SET_ATTRIBUTE_METHOD_NAME.equals(
					methodInvocation.getMethodName())) {

				Object[] args = methodInvocation.getArgs();

				Assert.assertNotNull(args);
				Assert.assertEquals(2, args.length);
				Assert.assertEquals("dummy", args[0]);
				Assert.assertNotNull(args[1]);
			}
		}
	}

	private static final String _SET_ATTRIBUTE_METHOD_NAME = "setAttribute";

	private static Dummy _dummy;
	private static DependencyProxyManager _dependencyProxyManager;
	private static EditDummyMVCRenderCommand _editDummyMVCRenderCommand;
	private static RenderRequest _renderRequest;
	private static RenderResponse _renderResponse;

}