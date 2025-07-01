<%@ page import="com.ntthanh.drink_store.model.Drink" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.ntthanh.drink_store.service.DrinkLocalServiceUtil" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

do
<liferay-ui:search-container>
	<liferay-ui:search-container-results results="${entries}" />

	<liferay-ui:search-container-row 
		className="com.ntthanh.drink_store.model.Drink"
		keyProperty="id"
		modelVar="drink"
		escapedModel="true">

		<liferay-ui:search-container-column-text
			name="Drink Name"
			property="drinkName" />
			
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<portlet:renderURL var="createEditRender">
      <portlet:param name="mvcRenderCommandName" value="/create/edit" />
</portlet:renderURL>
<a href="${createEditRender}">Create drink</a>

