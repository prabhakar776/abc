<%@ include file="init.jsp"%>
<%
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>


<%
    List<Award> awards = AwardLocalServiceUtil.getActiveAwards();
%>

<aui:button-row>

    <portlet:renderURL var="addCVLsURL" >
        <portlet:param name="jspPage" value="/html/edit_cvl.jsp" />
        <portlet:param name="redirect" value="<%= redirect %>" />
    </portlet:renderURL>

    <aui:button value="add-cvl" onClick="<%= addCVLsURL%>" />

</aui:button-row>



<liferay-ui:search-container>
    <liferay-ui:search-container-results results="<%= awards %>" />
    
    <liferay-ui:search-container-row
            className="com.instructure.canvas.model.Award"
            keyProperty="awardId" modelVar="award" >

        <liferay-ui:search-container-column-text name="netacadCVLId" property="cvlId" />

        <liferay-ui:search-container-column-text name="netacadCVLName" property="cvlName" />

        <liferay-ui:search-container-column-text name="qualifying-score" property="score" />
        
        <liferay-ui:search-container-column-text name="certificate-article-id" property="certificateArticleId" />
        
        <liferay-ui:search-container-column-text name="letter-article-id" property="letterArticleId" />

        <liferay-ui:search-container-column-jsp
            path="/html/award_actions.jsp" />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>
    
</liferay-ui:search-container>