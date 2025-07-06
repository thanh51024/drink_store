package com.ntthanh.drink_store.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.ntthanh.drink_store.model.Drink;
import com.ntthanh.drink_store.model.OrderDetail;
import com.ntthanh.drink_store.model.OrderDrink;
import com.ntthanh.drink_store.model.TableDrink;
import com.ntthanh.drink_store.service.DrinkLocalServiceUtil;
import com.ntthanh.drink_store.service.OrderDetailLocalServiceUtil;
import com.ntthanh.drink_store.service.OrderDrinkLocalServiceUtil;
import com.ntthanh.drink_store.service.TableDrinkLocalServiceUtil;
import com.ntthanh.drink_store.web.constants.DrinkStoreControllerPortletKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    property = {
			"javax.portlet.name=" +DrinkStoreControllerPortletKeys.DRINKSTORECONTROLLER,
	       "mvc.command.name=/orders"
	    },
	    service = MVCRenderCommand.class
	)

public class ViewOrderMVCRenderCommand implements MVCRenderCommand  {
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		List<OrderDrink> orderList = OrderDrinkLocalServiceUtil.getOrderDrinks(-1, -1);
		List<OrderDrink> modifiableList = new ArrayList<>(orderList);
		modifiableList.sort((o1, o2) -> o2.getOrderDate().compareTo(o1.getOrderDate())); // Mới nhất lên đầu
		orderList = modifiableList;
		renderRequest.setAttribute("orderList", orderList);

//        List<OrderDrink> orderList = OrderDrinkLocalServiceUtil.getOrderDrinks(
//        	    0, Integer.MAX_VALUE, 
//        	    OrderByComparatorFactoryUtil.create(
//        	        "OrderDrink", "orderDate", false // false = DESC
//        	    )
//        	);
        
        List<TableDrink> tableList = TableDrinkLocalServiceUtil.getTableDrinks(-1, -1);
        renderRequest.setAttribute("tableList", tableList);
        
        List<Drink> drinkList = DrinkLocalServiceUtil.getDrinks(-1, -1);
		renderRequest.setAttribute("drinkList", drinkList);
        
        Map<Long, List<OrderDetail>> orderDetailsMap = new HashMap<>();
        for (OrderDrink order : orderList) {
            List<OrderDetail> details = OrderDetailLocalServiceUtil.getOrderDetailsByOrderId(order.getId());
            orderDetailsMap.put(order.getId(), details);
        }
        renderRequest.setAttribute("orderDetailsMap", orderDetailsMap);
        return "/orders.jsp";
	}
}
