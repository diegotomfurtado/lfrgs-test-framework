package com.liferay.gs.test.portlet;

import com.liferay.gs.test.constants.DummyPortletKeys;
import com.liferay.gs.test.model.Dummy;
import com.liferay.gs.test.service.DummyLocalService;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Andrew Betts
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + DummyPortletKeys.Dummy,
		"mvc.command.name=/edit_dummy"
	},
	service = MVCRenderCommand.class
)
public class EditDummyMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		long dummyId = ParamUtil.getLong(renderRequest, "dummyId");

		Dummy dummy = _dummyLocalService.fetchDummy(dummyId);

		renderRequest.setAttribute("dummy", dummy);

		return "/edit.jsp";
	}

	@Reference
	private DummyLocalService _dummyLocalService;

}