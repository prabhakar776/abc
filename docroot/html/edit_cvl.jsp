<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@include file="init.jsp" %>

<liferay-ui:error key="duplicate-cvlId" message="duplicate-cvlId" />
<liferay-ui:error key="duplicate-cvlName" message="duplicate-cvlName" />
<liferay-ui:error key="invalid-cvlid" message="invalid-cvlid" />
<liferay-ui:error key="invalid-score" message="invalid-score" />

<%
    long awardId = ParamUtil.getLong(request, "awardId");
	String cvlIdParam = ParamUtil.getString(request, "cvlId");

    Award award = null;
    if (awardId > 0) {
    	
    	//get award from MongoDB - new REST call
        award = AwardLocalServiceUtil.getAward(awardId, cvlIdParam);
    	
    	//get award from PostgreSQL - original code
    	if(award == null){
        	award = AwardLocalServiceUtil.getAward(awardId);
    	}
    }

    redirect = ParamUtil.getString(request, "redirect");
%>

<portlet:actionURL name="editCVL" var="editCVLURL" >
    <portlet:param name="redirect" value="<%= redirect %>" />
</portlet:actionURL>

<aui:form method="post" name="fm" action="<%= editCVLURL %>" >

    <aui:model-context bean="<%= award %>"
                       model="<%= Award.class %>" />

    <liferay-ui:error key="no-letters-web-content"
                      message="no-letters-web-content" />

    <aui:input type="hidden" name="awardId" 
               value='<%= award == null ? "" : award.getAwardId() %>' />

    <%
        String cvlId = StringPool.BLANK;
        if (award != null) {
            cvlId = award.getCvlId();
            cvlId = StringUtil.shorten(cvlId, 15, StringPool.BLANK);
        }
    %>

    <aui:input name="netacadCVLId" type="text" label="netacadCVLId" required="true" size="75" value="<%= cvlId %>" />

    <aui:input name="cvlName" type="text" label="netacadCVLName" required="true" size="75" />

    <aui:input name="score" type="text" label="qualifying-score" />
    
    <aui:input name="certificateArticleId" type="text" label="certificate-article-id" required="true" />
    <aui:input name="letterArticleId" type="text" label="letter-article-id" />

	<br />
	<br />
    <aui:button type="submit" />
    <aui:button type="cancel" href="<%=redirect%>" />
</aui:form>
