package com.liferay.gs.test.dummy.portlet;

import com.liferay.gs.test.dummy.constants.DummyPortletKeys;
import com.liferay.gs.test.model.Dummy;
import com.liferay.gs.test.service.DummyLocalService;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Andrew Betts
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + DummyPortletKeys.Dummy,
		"mvc.command.name=/delete_dummy"
	},
	service = MVCActionCommand.class
)
public class DeleteDummyMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long dummyId = ParamUtil.getLong(actionRequest, "dummyId");

		Dummy dummy = _dummyLocalService.fetchDummy(dummyId);

		if (dummy != null) {
			_dummyLocalService.deleteDummy(dummy);
		}
	}

	@Reference
	private DummyLocalService _dummyLocalService;

}