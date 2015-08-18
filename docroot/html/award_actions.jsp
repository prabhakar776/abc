<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@include file="init.jsp"%>

<%
    ResultRow row = (ResultRow) request.getAttribute(
            WebKeys.SEARCH_CONTAINER_RESULT_ROW);

    Award award = (Award) row.getObject();

%>

<liferay-ui:icon-menu>
    <portlet:renderURL var="editCVLURL">
        <portlet:param name="jspPage" value="/html/edit_cvl.jsp" />
        <portlet:param name="awardId" value="<%= String.valueOf(award.getAwardId()) %>" />
        <portlet:param name="cvlId" value="<%= String.valueOf(award.getCvlId()) %>" />  <!-- this is required to get courseId for MongoDB -->
        <portlet:param name="redirect" value="<%= redirect %>" />
    </portlet:renderURL>

    <liferay-ui:icon image="edit" label="edit" url="<%= editCVLURL%>" />

    <portlet:actionURL name="deleteCVL" var="deleteCVLURL" >
        <portlet:param name="awardId" value="<%= String.valueOf(award.getAwardId()) %>" />
        <portlet:param name="redirect" value="<%= redirect %>" />
    </portlet:actionURL>

    <liferay-ui:icon image="delete" label="delete" url="<%= deleteCVLURL %>" />
</liferay-ui:icon-menu>