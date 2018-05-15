<%@ include file="/init.jsp" %>

<%
SearchContainer<Dummy> dummySearchContainer = (SearchContainer<Dummy>)request.getAttribute(WebKeys.SEARCH_CONTAINER);
%>
<p>
	<b><liferay-ui:message key="Test Dummy MVC Portlet"/></b>
</p>

<portlet:renderURL var="addDummyRenderURL">
	<portlet:param name="mvcRenderCommandName" value="/edit_dummy" />
</portlet:renderURL>

<aui:button
	name="addDummy"
	value="Add"
	data="<%= new HashMap<String, String>(){{ put("qa-id", "add-dummy"); }} %>"
    href="<%= addDummyRenderURL %>"
/>

<liferay-ui:search-container searchContainer="<%= dummySearchContainer %>" >
	<liferay-ui:search-container-row
		className="com.liferay.gs.test.model.Dummy"
		keyProperty="dummyId"
		modelVar="curDummy">

		<liferay-ui:search-container-column-text
			name="id"
			orderable="<%= true %>"
			orderableProperty="dummyId"
			property="dummyId"
			value="<%= String.valueOf(curDummy.getDummyId()) %>"
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
			value="<%= String.valueOf(curDummy.getField3()) %>"
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
			<portlet:param name="mvcRenderCommandName" value="/edit_dummy"/>
			<portlet:param name="dummyId" value="<%= String.valueOf(curDummy.getDummyId()) %>"/>
		</portlet:renderURL>

		<liferay-ui:search-container-column-text
			cssClass="qa-css-edit-dummy"
			name="edit"
			value="edit"
			href="<%= editDummyRenderURL %>"
		/>

		<portlet:actionURL var="deleteDummyActionURL" name="/delete_dummy">
			<portlet:param name="mvcRenderCommandName" value="/view"/>
			<portlet:param name="dummyId" value="<%= String.valueOf(curDummy.getDummyId()) %>"/>
		</portlet:actionURL>

		<liferay-ui:search-container-column-text
			cssClass="qa-css-delete-dummy"
			name="delete"
			value="delete"
			href="<%= deleteDummyActionURL %>"
		/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator markupView="lexicon" paginate="<%= true %>" searchContainer="<%= dummySearchContainer %>" />
</liferay-ui:search-container>