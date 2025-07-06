<%@ page import="com.ntthanh.drink_store.model.OrderDrink" %>
<%@ page import="com.ntthanh.drink_store.model.TableDrink" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<aui:button value="Quay lại" onClick="history.back()" cssClass="btn btn-outline-warning" />

<liferay-ui:search-container>
    <liferay-ui:search-container-results results="${orderList}" />
    
    <liferay-ui:search-container-row className="com.ntthanh.drink_store.model.OrderDrink" modelVar="order">
        
        <liferay-ui:search-container-column-text name="Tên bàn">
            <c:forEach var="table" items="${tableList}">
                <c:if test="${table.tableDrinkId == order.tableDrinkId}">
                    Bàn ${table.tableNumber}
                </c:if>
            </c:forEach>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="Tổng tiền" value="${order.totalAmount} VND" />
        <liferay-ui:search-container-column-text name="Ngày đặt" value="${order.orderDate}" />
        <liferay-ui:search-container-column-text name="Trạng thái">
            <c:choose>
                <c:when test="${order.paid}">Đã thanh toán</c:when>
                <c:otherwise>Chưa thanh toán</c:otherwise>
            </c:choose>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="Tùy chọn">
            <portlet:actionURL name="/markAsPaid" var="payURL">
                <portlet:param name="orderId" value="${order.id}" />
            </portlet:actionURL>

            <portlet:actionURL name="/delete_order" var="deleteURL">
                <portlet:param name="orderId" value="${order.id}" />
            </portlet:actionURL>

            <c:if test="${not order.paid}">
                <form action="${payURL}" method="post" style="display:inline;">
                    <button type="submit" class="btn btn-outline-success btn-sm">Thanh toán</button>
                </form>
            </c:if>
<!-- 
            <button type="button" class="btn btn-outline-info btn-sm" onclick="toggleOrderDetails('${order.id}')">Xem chi tiết</button>

 -->

            <form action="${deleteURL}" method="post" style="display:inline;">
                <button type="submit" class="btn btn-outline-danger btn-sm">Xóa</button>
            </form>
        </liferay-ui:search-container-column-text>
        
		<liferay-ui:search-container-column-text name="Chi tiết">
		    <div id="details_${order.id}" style=" height: auto;">
		        <c:forEach var="item" items="${orderDetailsMap[order.id]}">
		            <c:forEach var="drink" items="${drinkList}">
		                <c:if test="${drink.id == item.drinkId}">
		                    <strong>${drink.drinkName}</strong> - Size: ${item.size} - Giá: ${drink.price} VND 
		                </c:if>
		            </c:forEach>
		            - Số lượng: ${item.number} - Thành tiền: ${item.price} VND - Ghi chú: ${item.note}<br/>
		        </c:forEach>
		    </div>
		</liferay-ui:search-container-column-text>

		
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator />
</liferay-ui:search-container>
<!-- 
<script>
    function toggleOrderDetails(orderId) {
        const element = document.getElementById("details_"+orderId);
        if (element.style.display === "none") {
        	element.style.display = "block";
        } else {
        	element.style.display = "none";
        }
    }
</script>
 -->

