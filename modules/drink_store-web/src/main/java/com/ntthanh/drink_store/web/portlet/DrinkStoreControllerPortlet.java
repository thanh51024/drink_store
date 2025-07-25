package com.ntthanh.drink_store.web.portlet;

import com.ntthanh.drink_store.model.Drink;
import com.ntthanh.drink_store.model.OrderDetail;
import com.ntthanh.drink_store.model.OrderDrink;
import com.ntthanh.drink_store.model.TableDrink;
import com.ntthanh.drink_store.service.DrinkLocalService;
import com.ntthanh.drink_store.service.DrinkService;
import com.ntthanh.drink_store.service.OrderDetailLocalServiceUtil;
import com.ntthanh.drink_store.service.OrderDrinkLocalServiceUtil;
import com.ntthanh.drink_store.service.TableDrinkLocalServiceUtil;
import com.ntthanh.drink_store.service.TableDrinkService;
import com.ntthanh.drink_store.web.constants.DrinkStoreControllerPortletKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


/**
 * @author thanh
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DrinkStoreController",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DrinkStoreControllerPortletKeys.DRINKSTORECONTROLLER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
	},
	service = Portlet.class
)
public class DrinkStoreControllerPortlet extends MVCPortlet {
	
	// submit form và đẩy dử liệu
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "searchByCategoryURL")
	public void filterDrinks(ActionRequest request, ActionResponse response) {
			String category = ParamUtil.getString(request, "category");
			System.out.println("|category"+category);
			response.setRenderParameter("category", category); 
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "selectTableDrinkURL")
	public void selectTableDrink(ActionRequest request, ActionResponse response) {
		String tableDrinkId = ParamUtil.getString(request, "tableDrinkId");
		System.out.println("table"+tableDrinkId);
		response.setRenderParameter("tableDrinkId", tableDrinkId); 
	}
	
	@ProcessAction(name = "addToOrder")
	public void addToOrder(ActionRequest request, ActionResponse response) {
	    long drinkId = ParamUtil.getLong(request, "drinkId");
	    String size = ParamUtil.getString(request, "size","S");
	    int quantity = ParamUtil.getInteger(request, "quantity", 1);
	    String note = ParamUtil.getString(request, "note","");

        System.out.println(">> Them mon: " + drinkId + ", Size: " + size + ", SL: " + quantity + ", Ghi chú: " + note);

	    Drink drink = drinkService.fetchDrink(drinkId);
	    if (drink == null) return;

	    // Tính giá theo size
	    double price = drink.getPrice();
	    if ("M".equals(size)) {
	    	price += 5000;
	    } else if ("L".equals(size)) {
	    	price += 15000;
	    }
	    
	    // Lấy list tạm từ session
	    List<OrderDetail> tempList = (List<OrderDetail>) request.getPortletSession().getAttribute("tempOrderList", PortletSession.PORTLET_SCOPE);
	    if (tempList == null) {
	        tempList = new ArrayList<>();
	    }

	    // Kiểm tra món cùng size đã tồn tại chưa
	    boolean found = false;
	    for (OrderDetail item : tempList) {
	        if (item.getDrinkId() == drinkId && item.getSize().equals(size)) {
	            // Nếu đã có -> cộng dồn
	            item.setNumber(item.getNumber() + quantity);
	            item.setPrice(item.getPrice() + price * quantity);
	            item.setNote(item.getNote() + note); 
	            found = true;
	            break;
	        }
	    }

	    // Nếu chưa có -> thêm mới
	    if (!found) {
	        OrderDetail temp = OrderDetailLocalServiceUtil.createOrderDetail(0);
	        temp.setDrinkId(drinkId);
	        temp.setSize(size);
	        temp.setNote(note);
	        temp.setNumber(quantity);
	        temp.setPrice(price * quantity);
	        tempList.add(temp);
	    }
	    
	    System.out.println("TempList "+tempList);
	    request.getPortletSession().setAttribute("tempOrderList", tempList, PortletSession.PORTLET_SCOPE);
	    response.setRenderParameter("mvcRenderCommandName", "/view");
	}
	
	@ProcessAction(name = "deleteTempItem")
	public void deleteTempItem(ActionRequest request, ActionResponse response) {
	    long drinkId = ParamUtil.getLong(request, "drinkId");

	    List<OrderDetail> tempList = (List<OrderDetail>) request.getPortletSession().getAttribute("tempOrderList", PortletSession.PORTLET_SCOPE);

	    if (tempList != null) {
	    	tempList.removeIf(item -> {
	    	    return item.getDrinkId() == drinkId;
	    	});
	    }

	    request.getPortletSession().setAttribute("tempOrderList", tempList, PortletSession.PORTLET_SCOPE);
	    response.setRenderParameter("mvcRenderCommandName", "/view");
	}
	
	@ProcessAction(name = "confirmOrder")
	public void confirmOrder(ActionRequest request, ActionResponse response) throws Exception {

	    List<OrderDetail> tempList = (List<OrderDetail>) request.getPortletSession().getAttribute("tempOrderList", PortletSession.PORTLET_SCOPE);
	    if (tempList == null || tempList.isEmpty()) {
	        SessionErrors.add(request, "order-empty");
	        return;
	    }

	    long tableDrinkId = ParamUtil.getLong(request, "tableDrinkId");
	    if (tableDrinkId == 0) {
	        SessionErrors.add(request, "table-not-selected");
	        return;
	    }
	    
	    TableDrink table = TableDrinkLocalServiceUtil.fetchTableDrink(tableDrinkId);
	    if (table != null) {
	        table.setStatus("Dang su dung");
	        TableDrinkLocalServiceUtil.updateTableDrink(table);
	    }

	    // Kiểm tra tất cả đơn chưa thanh toán
	    List<OrderDrink> allOrders = OrderDrinkLocalServiceUtil.getOrderDrinks(-1, -1);
	    OrderDrink existingOrder = null;

	    for (OrderDrink order : allOrders) {
	        if (order.getTableDrinkId() == tableDrinkId && !order.getPaid()) {
	            existingOrder = order;
	            break;
	        }
	    }

	    if (existingOrder != null) {
	        long orderId = existingOrder.getId();
	        List<OrderDetail> existingDetails = OrderDetailLocalServiceUtil.getOrderDetailsByOrderId(orderId);

	        for (OrderDetail tempItem : tempList) {
	            boolean found = false;
            	double price = tempItem.getPrice();
            	String size = tempItem.getSize();

	            for (OrderDetail existingItem : existingDetails) {
	            	// tồn tại món có cùng size với món vừa đặt
	                if (existingItem.getDrinkId() == tempItem.getDrinkId() && existingItem.getSize().equals(size)) {
	                    existingItem.setNumber(existingItem.getNumber() + tempItem.getNumber());
	    	       
	                    // tính lại tổng tiền mới = tổng tiền cũ + tổng tiền mới
	                    existingItem.setPrice(existingItem.getPrice() + tempItem.getPrice());
	                    existingItem.setNote(existingItem.getNote() + tempItem.getNote());
	                    OrderDetailLocalServiceUtil.updateOrderDetail(existingItem);
	                    found = true;
	                    break;
	                }
	            }

	            if (!found) {
	                OrderDetail newDetail = OrderDetailLocalServiceUtil.createOrderDetail(CounterLocalServiceUtil.increment());
	                newDetail.setOrderId(orderId);
	                newDetail.setDrinkId(tempItem.getDrinkId());
	                newDetail.setNumber(tempItem.getNumber());
	                newDetail.setPrice(price * tempItem.getNumber());
	                newDetail.setSize(tempItem.getSize());
	                newDetail.setNote(tempItem.getNote());
	                OrderDetailLocalServiceUtil.addOrderDetail(newDetail);
	            }
	        }

	        double newTotal = OrderDetailLocalServiceUtil.getOrderDetailsByOrderId(orderId)
	            .stream().mapToDouble(OrderDetail::getPrice).sum();
	        existingOrder.setTotalAmount(newTotal);
	        OrderDrinkLocalServiceUtil.updateOrderDrink(existingOrder);

	    } else {
	        OrderDrink newOrder = OrderDrinkLocalServiceUtil.createOrderDrink(CounterLocalServiceUtil.increment());
	        newOrder.setTableDrinkId(tableDrinkId);
	        newOrder.setOrderDate(new Date());
	        newOrder.setPaid(false);

	        double total = 0;
	        for (OrderDetail tempItem : tempList) {	            
	            OrderDetail detail = OrderDetailLocalServiceUtil.createOrderDetail(CounterLocalServiceUtil.increment());
	            detail.setOrderId(newOrder.getId());
	            detail.setDrinkId(tempItem.getDrinkId());
	            detail.setNumber(tempItem.getNumber());
	            detail.setPrice(tempItem.getPrice());
	            detail.setSize(tempItem.getSize());
	            detail.setNote(tempItem.getNote());
	            OrderDetailLocalServiceUtil.addOrderDetail(detail);
	            total += detail.getPrice();
	        }

	        newOrder.setTotalAmount(total);
	        OrderDrinkLocalServiceUtil.addOrderDrink(newOrder);
	    }
	    // Xóa list session tạm
	    request.getPortletSession().removeAttribute("tempOrderList", PortletSession.PORTLET_SCOPE);
	    response.setRenderParameter("mvcRenderCommandName", "/view");
	}
	
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		System.out.println("DrinkPortlet.doView() -> ");
		List<TableDrink> tableList = tableDrinkService.getTableDrinks(-1, -1);
		renderRequest.setAttribute("tableList", tableList);

		for(Drink drink: drinkService.getDinks(0,100))
			System.out.println("Drink name =" + drink.getDrinkName());
		renderRequest.setAttribute("drinkList", drinkService.getDinks(-1,-1));
		renderRequest.setAttribute("totalDrink", drinkService.getDinkCount());
		
		String category = ParamUtil.getString(renderRequest, "category");
        System.out.println(">> category = " + category);

        List<Drink> drinks;
        if (Validator.isNotNull(category)) {
            drinks = drinkService.findByCategory(category);
        } else {
            drinks = drinkService.getDinks(-1, -1);
        }
        renderRequest.setAttribute("drinkList", drinks);
        renderRequest.setAttribute("selectedCategory", category);
        
        List<OrderDetail> tempOrderList = (List<OrderDetail>) renderRequest.getPortletSession().getAttribute("tempOrderList", PortletSession.PORTLET_SCOPE);
        if (tempOrderList != null) {
            System.out.println("Temp list loaded in render: " + tempOrderList.size());
            renderRequest.setAttribute("tempOrderList", tempOrderList);
        }
        
		super.doView(renderRequest, renderResponse);
	}
	private TableDrinkService tableDrinkService;
	
	@Reference(unbind ="-")
	protected void setTableDrinkService(TableDrinkService tableDrinkService) {
	
		this.tableDrinkService=tableDrinkService;
	}
	
	private DrinkService drinkService;
	
	@Reference(unbind ="-")
	protected void setDrinkService(DrinkService drinkService) {
	
		this.drinkService=drinkService;
	}
}