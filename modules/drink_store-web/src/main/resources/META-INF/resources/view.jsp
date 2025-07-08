<%@ page import="com.ntthanh.drink_store.model.Drink" %>
<%@ page import="com.ntthanh.drink_store.model.OrderDetail"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

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
        padding: 5px;
        border-radius: 10px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.08);
        margin: 5px;
        text-align: center;
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        align-items: center;
        gap: 5px;
    }

    .header-section .aui-button {
        margin: 0 5px;
        padding: 10px 20px;
        border-radius: 5px;
        font-weight: 600;
        min-width: 120px;
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
        width: 280px; 
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
    	background-color: transparent;
        margin-top: 10px;
        padding: 10px 10px;
        border-radius: 5px;
        font-size: 1em;
        width: 80%;
    }

.btn-outline-success {
    color: #28a745; 
    border-color: #28a745; 
    background-color: transparent;
}
.btn-outline-success:hover {
    color: #fff; 
    background-color: #28a745;
    border-color: #28a745;
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
    border: 1px solid #eee; 
}

.drink-card .no-image-placeholder {
    width: 150px; 
    height: 200px; 
    display: flex; 
    align-items: center;
    justify-content: center;
    border: 1px dashed #ccc; 
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
				
 <portlet:renderURL var="createEditTableDrinkRender">
    <portlet:param name="mvcRenderCommandName" value="/createTableDrink/editTableDrink" />
</portlet:renderURL>

<portlet:actionURL var="searchByCategory" name="searchByCategoryURL"/>

<portlet:actionURL var="selectTableDrink" name="selectTableDrinkURL"/>
	
<portlet:actionURL var="addToOrderURL" name="addToOrder"/>
	
<portlet:actionURL var="confirmOrderURL" name="confirmOrder" />
	
<portlet:renderURL var="viewOrderURL">
    <portlet:param name="mvcRenderCommandName" value="/orders" />
</portlet:renderURL>

<liferay-ui:error key="order-empty" message="Bạn chưa chọn món nào để đặt!" />

<div class="header-section">
	<aui:form action="${selectTableDrink}" method="post" name="fm">
	   <aui:select name="tableDrinkId" label="Chọn bàn" onchange="this.form.submit();">
	   		<aui:option value="Chọn bàn">Chọn bàn</aui:option>
		    <c:forEach var="table" items="${tableList}">
		        <aui:option value="${table.tableDrinkId}" selected="${param.tableDrinkId eq table.tableDrinkId }">
		            Bàn ${table.tableNumber} - ${table.seats} chỗ - ${table.status}
		        </aui:option>
		    </c:forEach>
		</aui:select>
	</aui:form>
	
	<aui:form action="${searchByCategory}" method="post" name="fm">
	    <aui:select name="category" label="Tìm theo thể loại" onchange="this.form.submit();">
	        <aui:option value="" selected="${empty param.category || param.category eq ''}">Tất cả</aui:option>
	        <aui:option value="Trà sữa" selected="${param.category eq 'Trà sữa'}">Trà sữa</aui:option>
	        <aui:option value="Nước ép" selected="${param.category eq 'Nước ép'}">Nước ép</aui:option>
	        <aui:option value="Sinh tố" selected="${param.category eq 'Sinh tố'}">Sinh tố</aui:option>
	        <aui:option value="Cà phê" selected="${param.category eq 'Cà phê'}">Cà phê</aui:option>
	        <aui:option value="Trà" selected="${param.category eq 'Trà'}">Trà</aui:option>
	        <aui:option value="Nước ngọt" selected="${param.category eq 'Nước ngọt'}">Nước ngọt</aui:option>
	       	<aui:option value="Nước suối" selected="${param.category eq 'Nước suối'}">Nước suối</aui:option>
	    	<aui:option value="Đồ ăn vặt" selected="${param.category eq 'Đồ ăn vặt'}">Đồ ăn vặt</aui:option>
            <aui:option value="Topping đi kèm" selected="${param.category eq 'Topping đi kèm'}">Topping đi kèm</aui:option>
            <aui:option value="Khác" selected="${param.category eq 'Khác'}">Khác</aui:option>
	    </aui:select>
	</aui:form>
		
	<aui:form action="${confirmOrderURL}" method="post" name="confirmForm">
	    <aui:input type="hidden" name="tableDrinkId" value="${param.tableDrinkId}" />
	    <aui:button type="submit" value="Xác nhận đặt món" cssClass="btn btn-outline-success btn-sm" />
	</aui:form>
	<aui:button value="Thêm nước mới" href="${createEditRender}" cssClass="btn btn-outline-success btn-sm"/>
   	<aui:button value="Thêm bàn mới" href="${createEditTableDrinkRender}" cssClass="btn btn-outline-success btn-sm" />
    <aui:button value="Xem đơn đã đặt" href='${viewOrderURL}' cssClass="btn btn-outline-info btn-sm" />
	<aui:button value="Xem danh sách bàn" onClick="toggleTableList()" cssClass="btn btn-outline-info btn-sm" />	
	<br>
	
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
		
		                <aui:button value="Sửa" href="${editTableURL}" cssClass="btn btn-outline-success btn-sm"/>
		                <aui:button value="Xóa" href="${deleteTableURL}" cssClass="btn btn-outline-danger btn-sm" />
		            </div>
		        </div>
		    </c:forEach>
		</div>
	</div>
</div>
<h4>Món đã chọn:</h4>
<liferay-ui:search-container>
	<liferay-ui:search-container-results results="${tempOrderList}" />
	<liferay-ui:search-container-row
         className="com.ntthanh.drink_store.model.OrderDetail"
         modelVar="item">
	
	<portlet:actionURL var="deleteTempItemURL" name="deleteTempItem">
		<portlet:param name="drinkId" value="${item.drinkId}" />
	</portlet:actionURL>
	
    <liferay-ui:search-container-column-text name="Tên">
	    <c:forEach var="drink" items="${drinkList}">
	        <c:if test="${drink.id == item.drinkId}">${drink.drinkName}</c:if>
	    </c:forEach>
	</liferay-ui:search-container-column-text>

	<liferay-ui:search-container-column-text name="Loại">
	    <c:forEach var="drink" items="${drinkList}">
	        <c:if test="${drink.id == item.drinkId}">${drink.category}</c:if>
	    </c:forEach>
	</liferay-ui:search-container-column-text>

    <liferay-ui:search-container-column-text name="Số lượng" value="${item.number}" />
    <liferay-ui:search-container-column-text name="Size" value="${item.size}" />
    <liferay-ui:search-container-column-text name="Ghi chú" value="${item.note}" />
    <liferay-ui:search-container-column-text name="Đơn giá" value="${item.price / item.number} VNĐ" />
    <liferay-ui:search-container-column-text name="Tổng" value="${item.price} VNĐ" />
    	
   	<liferay-ui:search-container-column-text name="Tùy chỉnh">
        <aui:button value="Xóa"
            cssClass="btn btn-outline-danger btn-sm"
            href='${deleteTempItemURL}' />
     </liferay-ui:search-container-column-text>
     
     </liferay-ui:search-container-row>
     <liferay-ui:search-iterator />
 </liferay-ui:search-container>



<div class="drink-list-outer-container">
    <div class="drink-list-container">
        <liferay-ui:search-container >
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
                         <div class="no-image-placeholder">Không có ảnh</div>
                     </c:if>
                     <div class="drink-details">
                     <h2>${drink.drinkName}</h4>
                     <h4><strong>Loại:</strong> ${drink.category} - ${drink.price} VND</h4>

				<aui:form action="${addToOrderURL}" method="post" name="drinkForm${drink.id}">
                             <aui:input type="hidden" name="drinkId" value="${drink.id}" />
                             <aui:input type="hidden" name="tableDrinkId" value="${param.tableDrinkId}" />
                             
                 <aui:select name="size" label="" placeholder="Số lượng">
				        <aui:option value="S" label="S (Loại nhỏ)" />
				        <aui:option value="M" label="M (Loại vừa)" />
				        <aui:option value="L" label="L (Loại lớn)" />
			   	</aui:select>
                             <aui:input name="quantity" label="" type="number" min="1" value="1" placeholder="Số lượng"/>
                             <aui:input name="note" label="" placeholder="Ghi chú"/>
                             
                             <aui:button type="submit" value="Chọn món" cssClass="btn btn-outline-success btn-sm" />
                             
                         	<aui:button value="Sửa"  href="${editDrinkURL}&drinkId=${drink.id}" cssClass="btn btn-outline-info btn-sm" />         
				
					<aui:button value="Xóa" href="${deleteDrinkActionURL}" onClick="toggleTableList()" cssClass="btn btn-outline-danger btn-sm"/>
                                          
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
