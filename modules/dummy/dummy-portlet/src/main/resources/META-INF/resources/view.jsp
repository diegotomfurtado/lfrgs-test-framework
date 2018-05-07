<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="Test Dummy MVC Portlet"/></b>
</p>

<portlet:renderURL var="addDummyRenderURL">
	<portlet:param name="mvcRenderCommand" value="/edit_dummy" />
</portlet:renderURL>

<aui:button
	name="addDummy"
	data="<%= new HashMap<String, String>(){{put("qa-id", "add-dummy-button");}}%>"
    href="<%= addDummyRenderURL %>"
/>

<liferay-ui:search-container searchContainer="<%= request.getAttribute(WebKeys.SEARCH_CONTAINER) %>">
	<liferay-ui:search-container-row
		className="com.liferay.gs.test.model.Dummy"
		keyProperty="dummyId"
		modelVar="curDummy">

		<liferay-ui:search-container-column-text
			name="id"
			orderable="<%= true %>"
			orderableProperty="dummyId"
			property="dummyId"
		/>

		<liferay-ui:search-container-column-text
			name="one"
			orderable="<%= true %>"
			orderableProperty="field1"
			property="field1"
		/>

		<liferay-ui:search-container-column-text
			name="two"
			orderable="<%= true %>"
			orderableProperty="field2"
			property="field2"
		/>

		<liferay-ui:search-container-column-text
			name="three"
			orderable="<%= true %>"
			orderableProperty="field3"
			property="field3"
		/>

		<liferay-ui:search-container-column-text
			name="four"
			orderable="<%= true %>"
			orderableProperty="field4"
			property="field4"
		/>

		<liferay-ui:search-container-column-text
			name="five"
			orderable="<%= true %>"
			orderableProperty="field5"
			property="field5"
		/>

		<portlet:renderURL var="editDummyRenderURL">
			<portlet:param name="mvcRenderCommand" value="/edit_dummy"/>
			<portlet:param name="dummyId" value="<%= curDummy.getDummyId() %>"/>
		</portlet:renderURL>

		<liferay-ui:search-container-column-button
			cssClass="qa-css-edit-dummy"
			name="edit"
			href="<%= editDummyRenderURL %>"
		>

		</liferay-ui:search-container-column-button>
	</liferay-ui:search-container-row>
</liferay-ui:search-container>