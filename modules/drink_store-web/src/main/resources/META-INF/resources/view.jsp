<%@ page import="com.ntthanh.drink_store.model.Drink" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f0f2f5;
        color: #333;
        margin: 0;
        padding: 0;
    }

    .header-section {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.08);
        margin: 20px;
        text-align: center;
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        align-items: center;
        gap: 15px;
    }

    .header-section .aui-select-wrapper,
    .header-section .aui-button-row {
        margin: 0;
    }

    .header-section .aui-button {
        margin: 0 5px;
        padding: 10px 20px;
        border-radius: 5px;
        font-weight: 600;
    }

    .drink-list-outer-container {
        padding: 0 20px 20px;
    }

    .drink-list-container {
        padding: 15px;
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.08);
        min-width: 0; 
    }

    .drink-card-wrapper {
        display: flex;
        flex-wrap: wrap; 
        overflow-x: auto; 
        -webkit-overflow-scrolling: touch;
        gap: 10px; 
        padding: 5px;
        padding-bottom: 10px; 
        align-items: flex-start; 
        width: 100%;
        min-width: 0; 
    }

    .drink-card-wrapper::-webkit-scrollbar {
        height: 8px; 
    }

    .drink-card-wrapper::-webkit-scrollbar-track {
        background: #f1f1f1;
        border-radius: 10px;
    }

    .drink-card-wrapper::-webkit-scrollbar-thumb {
        background: #888;
        border-radius: 10px;
    }

    .drink-card-wrapper::-webkit-scrollbar-thumb:hover {
        background: #555; 
    }

    .drink-card {
        flex-shrink: 0; 
        width: 300px; 
        height: auto; 
        display: flex;
        flex-direction: column;
        align-items: center;
        border: 1px solid #e0e0e0;
        border-radius: 12px;
        padding: 15px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.05);
        background: #ffffff;
        text-align: center;
        box-sizing: border-box;
    }

    .drink-card:hover {
        transform: translateY(-3px);
        box-shadow: 0 6px 20px rgba(0,0,0,0.1);
    }

    .drink-card img {
        width: 150px;
        height: 150px;
        object-fit: cover;
        border-radius: 8px;
        margin-bottom: 15px;
    }

    .drink-details {
        width: 100%;
        overflow: hidden;
        text-overflow: ellipsis; 
    }

    .drink-details h2 {
        font-size: 1.2em;
        color: #0056b3;
        margin-top: 0;
        margin-bottom: 0px;
        white-space: nowrap; 
        overflow: hidden;
        text-overflow: ellipsis;
    }

    .drink-card .aui-form {
        display: flex;
        flex-direction: column;
        width: 100%;
        margin-top: 15px;
        gap: 10px;
    }
    
    .drink-card .aui-button {
        margin-top: 10px;
        padding: 10px 20px;
        border-radius: 5px;
        font-size: 1em;
        width: 100%;
    }


    .aui-field-input-text,
    .aui-field-input-select {
        border: 1px solid #ccc;
        border-radius: 5px;
        padding: 10px 12px;
        width: 100%;
        box-sizing: border-box;
    }
.drink-card img {
    width: 150px; 
    height: 200px; 
    object-fit: cover; 
    border-radius: 8px;
    margin-bottom: 15px;
    /* Nếu có border khi không có ảnh, thêm vào đây để nhất quán */
    border: 1px solid #eee; /* Ví dụ: thêm border nhẹ */
}

/* Thêm CSS cho phần không có ảnh để chúng có cùng kích thước */
.drink-card .no-image-placeholder {
    width: 150px; 
    height: 200px; 
    display: flex; /* Dùng flexbox để căn giữa chữ */
    align-items: center;
    justify-content: center;
    border: 1px dashed #ccc; /* Border cho placeholder */
    border-radius: 8px;
    margin-bottom: 15px;
    color: #888;
    background-color: #f9f9f9;
    font-size: 0.9em;
    text-align: center;
}
    @media (max-width: 768px) {
        .header-section {
            flex-direction: column;
            align-items: stretch;
            margin: 10px;
            padding: 15px;
        }

        .header-section .aui-select-wrapper,
        .header-section .aui-button-row {
            width: 100%;
        }

        .header-section .aui-button {
            width: 100%;
            margin-bottom: 10px;
        }
    }
</style>

 <portlet:renderURL var="createEditRender">
    <portlet:param name="mvcRenderCommandName" value="/create/edit" />
</portlet:renderURL>
				
<portlet:renderURL var="searchByCategoryURL">
    <portlet:param name="mvcRenderCommandName" value="/view" />
</portlet:renderURL>

 <portlet:renderURL var="createEditTableDrinkRender">
    <portlet:param name="mvcRenderCommandName" value="/createTableDrink/editTableDrink" />
</portlet:renderURL>


<div class="header-section">
   <aui:select name="tableDrinkId" label="Chọn bàn">
	    <c:forEach var="table" items="${tableList}">
	        <aui:option value="${table.tableDrinkId}">
	            Bàn ${table.tableNumber} - ${table.seats} chỗ - ${table.status}
	        </aui:option>
	    </c:forEach>
	</aui:select>
	
	
    <aui:form action="${searchByCategoryURL}" method="get" name="categorySearchForm">
        <aui:select name="category" label="Tìm theo thể loại" onchange="document.forms.categorySearchForm.submit();">
            <c:set var="allSelected" value="${empty param.category || param.category eq ''}" />
            <aui:option value="" selected="${allSelected}">Tất cả</aui:option>

            <c:set var="coffeeSelected" value="${param.category eq 'Cà phê'}" />
            <aui:option value="Cà phê" selected="${coffeeSelected}">Cà phê</aui:option>

            <c:set var="teaSelected" value="${param.category eq 'Trà'}" />
            <aui:option value="Trà" selected="${teaSelected}">Trà</aui:option>

			<c:set var="milkTeaSelected" value="${param.category eq 'Trà sữa'}" />
            <aui:option value="Trà sữa" selected="${teaSelected}">Trà sữa</aui:option>
            
            <c:set var="juiceSelected" value="${param.category eq 'Nước ép'}" />
            <aui:option value="Nước ép" selected="${juiceSelected}">Nước ép</aui:option>

			<c:set var="sodaSelected" value="${param.category eq 'Nước ngọt'}" />
            <aui:option value="Nước ngọt" selected="${smoothieSelected}">Nước ngọt</aui:option>
            
            <c:set var="smoothieSelected" value="${param.category eq 'Sinh tố'}" />
            <aui:option value="Sinh tố" selected="${smoothieSelected}">Sinh tố</aui:option>

        </aui:select>
    </aui:form>

    <aui:button-row>
        <aui:button value="Thêm nước mới" href="${createEditRender}" cssClass="btn btn-success"/>
    	<aui:button value="Thêm bàn mới" href="${createEditTableDrinkRender}" cssClass="btn btn-success" />
        <aui:button value="Xem đơn đã đặt" onClick="location.href='${viewOrderURL}'" cssClass="btn btn-info" />
		<aui:button value="Xem danh sách bàn" onClick="toggleTableList()" cssClass="btn btn-info" />
    </aui:button-row>
    <div id="tableListContainer" style="display: none;">
	
	    <div class="drink-card-wrapper">
		    <c:forEach var="table" items="${tableList}">
		        <div class="drink-card" style="width: 250px;height:90;padding-top: 10px">
		            Bàn ${table.tableNumber}- ${table.seats} chỗ – ${table.status}
		
		            <div style="margin-top: 10px;">
		                <portlet:renderURL var="editTableURL">
		                    <portlet:param name="mvcRenderCommandName" value="/createTableDrink/editTableDrink" />
		                    <portlet:param name="tableDrinkId" value="${table.tableDrinkId}" />
		                </portlet:renderURL>
		
		                <portlet:actionURL name="/deleteTableDrink" var="deleteTableURL">
		                    <portlet:param name="tableDrinkId" value="${table.tableDrinkId}" />
		                </portlet:actionURL>
		
		                <aui:button value="Sửa" href="${editTableURL}" cssClass="btn btn-success" />
		                <aui:button value="Xóa" href="${deleteTableURL}" cssClass="btn" />
		            </div>
		        </div>
		    </c:forEach>
		</div>
	</div>
</div>

<div class="drink-list-outer-container">
    <div class="drink-list-container">
        <liferay-ui:search-container>
            <div class="drink-card-wrapper"> 
                <liferay-ui:search-container-results results="${drinkList}" />
                <liferay-ui:search-container-row
                    className="com.ntthanh.drink_store.model.Drink"
                    modelVar="drink"
                    keyProperty="id"
                >
               
				
				<portlet:renderURL var="editDrinkURL">
				    <portlet:param name="mvcRenderCommandName" value="/create/edit" />
				    <portlet:param name="drinkId" value="${drink.id}" />
				</portlet:renderURL>
								
				<portlet:actionURL name="/deleteDrink" var="deleteDrinkActionURL">
				    <portlet:param name="drinkId" value="${drink.id}" />
				</portlet:actionURL>
                    <div class="drink-card">
                    	<c:if test="${not empty drink.imageUrl}">
                            <img src="${drink.imageUrl}" alt="${drink.drinkName}"/>
                        </c:if>
                        <c:if test="${empty drink.imageUrl}">
                            <div class="no-image-placeholder">
					            Không có ảnh
					        </div>
                        </c:if>
                        <div class="drink-details">
                            <h2>${drink.drinkName}</h4>
                            <h4><strong>Loại:</strong> ${drink.category} - <strong>Giá:</strong> ${drink.price} VND</h4>

                            <aui:form action="<portlet:actionURL name='/addToOrder'/>" method="post" name="drinkForm${drink.id}">
                                <aui:input type="hidden" name="drinkId" value="${drink.id}" />
                                <aui:select name="size" label="" placeholder="Số lượng">
							        <aui:option value="S" label="S (Loại nhỏ)" />
							        <aui:option value="M" label="M (Loại vừa)" />
							        <aui:option value="L" label="L (Loại lớn)" />
							    </aui:select>
                                <aui:input name="quantity" label="" type="number" min="1" value="1" placeholder="Số lượng"/>
                                <aui:input name="note" label="" placeholder="Ghi chú"/>
                                <aui:button type="submit" value="Chọn món" cssClass="btn btn-success" />
                            	<aui:button value="Sửa"  href="${editDrinkURL}&drinkId=${drink.id}" cssClass="btn btn-info" />         
							
								<aui:button value="Xóa" href="${deleteDrinkActionURL}" onClick="toggleTableList()"/>
		                                           
                            </aui:form>
                        </div>
                    </div>
                </liferay-ui:search-container-row>
            </div>
            <liferay-ui:search-iterator />
        </liferay-ui:search-container>
    </div>
</div>
<script>
	function toggleTableList() {
	    var container = document.getElementById("tableListContainer");
	    var toggleButton = document.getElementById("toggleTableListButton");
	    if (container.style.display === "none") {
	        container.style.display = "block";
	    } else {
	        container.style.display = "none";
	    }
	}
</script>
