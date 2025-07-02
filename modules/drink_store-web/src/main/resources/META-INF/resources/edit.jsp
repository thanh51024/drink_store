<%@ page import="com.ntthanh.drink_store.model.Drink" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%-- Thêm import này --%>

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
    .aui-field-input-number,
    .aui-field-input-select {
        width: 100%;
        padding: 12px 15px;
        border: 1px solid #ddd;
        border-radius: 8px;
        font-size: 1em;
        box-sizing: border-box; 
        transition: border-color 0.3s ease, box-shadow 0.3s ease;
    }

    .aui-field-input-text:focus,
    .aui-field-input-number:focus,
    .aui-field-input-select:focus {
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

<portlet:actionURL name="/saveDrink" var="saveDrinkURL" />

<div class="form-container">
	<h1>${empty editDrink ? "Tạo đồ uống mới" : "Chỉnh sửa đồ uống"}</h1>

    <aui:form action="${saveDrinkURL}" method="post" name="fm" enctype="multipart/form-data">
        <aui:model-context bean="${drink}" model="<%= Drink.class %>" />
		<c:if test="${not empty editDrink}">
		    <aui:input type="hidden" name="drinkId" value="${editDrink.id}" />
		    <aui:input type="hidden" name="existingImageUrl" value="${editDrink.imageUrl}" />
		</c:if>
        <aui:input name="drinkName" value="${editDrink.drinkName}" label="Tên đồ uống" required="true" />

        <%-- Dropdown cho Loại (Category) --%>
        <aui:select name="category" label="Loại" required="true" value="${editDrink.category}">
            <aui:option value="">-- Chọn loại --</aui:option>
            <aui:option value="Cà phê">Cà Phê</aui:option>
            <aui:option value="Trà">Trà</aui:option>
            <aui:option value="Nước ép">Nước Ép</aui:option>
            <aui:option value="Sinh tố">Sinh Tố</aui:option>
            <aui:option value="Nước ngọt">Nước ngọt</aui:option>
            <aui:option value="Trà Sữa">Trà Sữa</aui:option>
        </aui:select>

        <aui:input name="price" label="Giá (VND)" type="number" step="1000" min="1000" value="${editDrink.price}" />

        <div class="form-field-row">
            <span class="field-label-text">Ảnh:</span>
            <aui:input name="newImageFile" label="" type="file" /> 
        </div>
        
        <%-- Hiển thị ảnh hiện tại nếu đang ở chế độ chỉnh sửa và có ảnh --%>
        <c:if test="${not empty editDrink.imageUrl}">
            <div style="text-align: center; margin-top: 15px;">
                <p>Ảnh hiện tại:</p>
                <img src="${editDrink.imageUrl}" alt="Ảnh ${editDrink.drinkName}" class="current-drink-image" style="width:150px; height:200px; object-fit:cover;" />
            </div>
            
            <aui:input type="hidden" name="oldImageUrl" value="${editDrink.imageUrl}" />
            
        </c:if>
                                    	
        <aui:button-row>
            <aui:button cssClass="btn btn-primary" type="submit"  value="${empty editDrink ? 'Tạo' : 'Cập nhật'}"/>
            <aui:button type="cancel" value="Hủy" onClick="history.back();"cssClass="btn-cancel" />
            
        </aui:button-row>
      
    </aui:form>
</div>

