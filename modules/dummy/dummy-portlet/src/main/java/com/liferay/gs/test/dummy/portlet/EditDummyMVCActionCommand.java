package com.liferay.gs.test.dummy.portlet;

import com.liferay.gs.test.dummy.constants.DummyPortletKeys;
import com.liferay.gs.test.model.Dummy;
import com.liferay.gs.test.service.DummyLocalService;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Date;

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
		"mvc.command.name=/edit_dummy"
	},
	service = MVCActionCommand.class
)
public class EditDummyMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long dummyId = ParamUtil.getLong(actionRequest, "dummyId");
		String one = ParamUtil.getString(actionRequest, "one");
		boolean two = ParamUtil.getBoolean(actionRequest, "two");
		int three = ParamUtil.getInteger(actionRequest, "three");
		Date four = ParamUtil.getDate(
			actionRequest, "four", DateUtil.getISOFormat());
		String five = ParamUtil.getString(actionRequest, "five");

		Dummy dummy = _dummyLocalService.fetchDummy(dummyId);

		if (dummy == null) {
			dummy = _dummyLocalService.addDummy(one, two, three, four, five);
		}
		else {
			dummy = _dummyLocalService.updateDummy(
				dummyId, one, two, three, four, five);
		}

		actionResponse.setRenderParameter(
			"dummyId", String.valueOf(dummy.getDummyId()));
	}

	@Reference
	private DummyLocalService _dummyLocalService;

}