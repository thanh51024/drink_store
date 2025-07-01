<%@ page import="com.ntthanh.drink_store.model.Drink" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<portlet:actionURL name="saveDrink" var="saveDrinkURL" />

<h1> Create drink </h1>

<aui:form action="${saveDrinkURL}" method="post" name="fm">
    <aui:model-context bean="${drink}" model="<%= Drink.class %>" />

    <aui:input name="drinkName" label="Tên đồ uống" required="true" />
    <aui:input name="category" label="Loại" />
    <aui:input name="price" label="Giá"  type="number" step="1000" />
    <aui:input name="imageUrl" label="Link ảnh" />

    <aui:button-row>
        <aui:button cssClass="btn btn-primary" type="submit" value="Tạo" />
    </aui:button-row>
</aui:form>
