<%@ include file="/init.jsp" %>

<%
	Dummy dummy = (Dummy)request.getAttribute("dummy");

	long dummyId = 0;

	String one = "one";
	boolean two = true;
	int three = 3;
	Date four = new Date();
	String five = "five";

	if (dummy != null) {
		dummyId = dummy.getDummyId();

		one = dummy.getField1();
		two = dummy.getField2();
		three = dummy.getField3();
		four = dummy.getField4();
		five = dummy.getField5();
	}
%>

<portlet:actionURL name="/edit_dummy" var="editDummyActionURL">
	<portlet:param name="mvcRenderCommandName" value="/edit_dummy" />
</portlet:actionURL>

<portlet:renderURL var="viewDummyRenderURL">
	<portlet:param name="mvcRenderCommandName" value="/view" />
</portlet:renderURL>

<aui:button data="<%= new HashMap<String, String>(){{ put("qa-id", "back-to-view"); }}%>" name="back" value="back" href="<%= viewDummyRenderURL %>" />

<aui:form action="<%= editDummyActionURL %>" name="fm">
	<aui:input name="dummyId" type="hidden" value="<%= dummyId %>" />

	<aui:fieldset-group>
		<aui:fieldset>
			<aui:input name="one" value="<%= one %>" />
			<aui:input name="two" value="<%= two %>" />
			<aui:input name="three" value="<%= three %>" />
		</aui:fieldset>

		<aui:fieldset>
			<liferay-ui:input-date
				name="four"
				dayValue="<%= four.getDate() %>"
			    monthValue="<%= four.getMonth() %>"
			    yearValue="<%= four.getYear() %>"
			/>
		</aui:fieldset>

		<aui:fieldset>
			<aui:input name="five" value="<%= five %>" />
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:button data="<%= new HashMap<String, String>(){{ put("qa-id", "save-dummy"); }}%>" name="save" type="submit"/>
</aui:form>