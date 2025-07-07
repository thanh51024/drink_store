<%@ page import="com.ntthanh.drink_store.model.TableDrink" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<style>
    .form-container {
        background-color: #ffffff;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 8px 25px rgba(0,0,0,0.1);
        width: 100%;
        max-width: 500px;
        margin: 20px auto;
        box-sizing: border-box;
    }

    h1 {
        text-align: center;
        color: #0056b3;
        margin-bottom: 30px;
        font-size: 2.2em;
        font-weight: 700;
    }

    .aui-field {
        margin-bottom: 20px;
    }

    .aui-field-label {
        font-weight: 600;
        color: #555;
        margin-bottom: 8px;
        display: block;
    }

    .aui-field-input-text,
    .aui-field-input-number {
        width: 100%;
        padding: 12px 15px;
        border: 1px solid #ddd;
        border-radius: 8px;
        font-size: 1em;
        box-sizing: border-box;
        transition: border-color 0.3s ease, box-shadow 0.3s ease;
    }

    .aui-field-input-text:focus,
    .aui-field-input-number:focus {
        border-color: #007bff;
        box-shadow: 0 0 0 3px rgba(0, 123, 255, 0.25);
        outline: none;
    }


    .aui-button-row {
        text-align: center;
        margin-top: 30px;
    }

    .aui-button {
    	text-align: center;
    	display:flex;
    	justify-content: center;
        padding: 12px 30px;
        font-size: 1.1em;
        font-weight: 600;
        border-radius: 8px;
        cursor: pointer;
        transition: background-color 0.3s ease, transform 0.2s ease, box-shadow 0.3s ease;
        border: none;
        background-color: #007bff;
        color: white;
        box-shadow: 0 4px 10px rgba(0, 123, 255, 0.2);
    }

    input[type="number"]::-webkit-inner-spin-button,
    input[type="number"]::-webkit-outer-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }

    input[type="number"] {
        -moz-appearance: textfield;
    }
</style>

<portlet:actionURL name="/saveTableDrink" var="saveTableDrinkURL" />

<div class="form-container">
	<h1>${empty editTableDrink ? 'Tạo bàn':'Chỉnh sửa bàn'}</h1>

    <aui:form action="${saveTableDrinkURL}" method="post" name="fm">
        <aui:model-context bean="${editTableDrink}" model="<%= TableDrink.class %>" />

        <c:if test="${not empty editTableDrink}">
            <aui:input type="hidden" name="tableDrinkId" value="${editTableDrink.tableDrinkId}" />
        </c:if>

		<aui:input name="tableNumber" label="Số bàn" value="${editTableDrink.tableNumber}" type="text" readonly="true" />

        <aui:select name="seats" label="Số chỗ ngồi" required="true" value="4">
        	<aui:option value="2" selected="${editTableDrink.seats eq 2}">2</aui:option>
		    <aui:option value="4" selected="${editTableDrink.seats eq 4}">4</aui:option>
		    <aui:option value="6" selected="${editTableDrink.seats eq 6}">6</aui:option>
		    <aui:option value="8" selected="${editTableDrink.seats eq 8}">8</aui:option>
		    <aui:option value="10" selected="${editTableDrink.seats eq 10}">10</aui:option>
		</aui:select>

        <aui:select name="status" label="Trạng thái" required="true">
            <aui:option value="Trống" selected="${empty editTableDrink or editTableDrink.status eq 'Trống'}">Trống</aui:option>
            <aui:option value="Đang sử dụng" selected="${editTableDrink.status eq 'Đang sử dụngg'}">Đang sử dụng</aui:option>
            <aui:option value="Đã đặt" selected="${editTableDrink.status eq 'Đã đặt'}">Đã đặt</aui:option>
        </aui:select>

        <aui:button-row>
			<aui:button cssClass="btn btn-success btn-sm" type="submit" value="Xác nhận" />
            <aui:button type="cancel" value="Hủy" onClick="history.back();" cssClass="btn-cancel btn btn-sm" />
        </aui:button-row>

    </aui:form>
</div>
