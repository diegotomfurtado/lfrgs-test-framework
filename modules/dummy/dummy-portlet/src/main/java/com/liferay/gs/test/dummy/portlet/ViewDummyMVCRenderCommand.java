package com.liferay.gs.test.dummy.portlet;

import com.liferay.gs.test.dummy.constants.DummyPortletKeys;
import com.liferay.gs.test.model.Dummy;
import com.liferay.gs.test.service.DummyLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

/**
 * @author Andrew Betts
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + DummyPortletKeys.Dummy,
		"mvc.command.name=/", "mvc.command.name=/view"
	},
	service = MVCRenderCommand.class
)
public class ViewDummyMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		SearchContainer<Dummy> searchContainer = new SearchContainer<>(
			renderRequest, renderResponse.createRenderURL(), null, "empty");
		List<Dummy> dummies = _dummyLocalService.getDummies(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		searchContainer.setResults(dummies);
		searchContainer.setTotal(dummies.size());

		renderRequest.setAttribute(WebKeys.SEARCH_CONTAINER, searchContainer);

		return "/view.jsp";
	}

	@Reference
	private DummyLocalService _dummyLocalService;

}