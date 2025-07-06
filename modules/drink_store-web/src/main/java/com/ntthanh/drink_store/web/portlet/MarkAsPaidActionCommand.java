package com.ntthanh.drink_store.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.ntthanh.drink_store.model.OrderDrink;
import com.ntthanh.drink_store.model.TableDrink;
import com.ntthanh.drink_store.service.OrderDrinkLocalServiceUtil;
import com.ntthanh.drink_store.service.TableDrinkLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.ntthanh.drink_store.web.constants.DrinkStoreControllerPortletKeys;

@Component(
	    property = {
	    	"javax.portlet.name=" + DrinkStoreControllerPortletKeys.DRINKSTORECONTROLLER,
	        "mvc.command.name=/markAsPaid"
	    },
	    service = MVCActionCommand.class
	)
public class MarkAsPaidActionCommand  implements MVCActionCommand{

	@SuppressWarnings("deprecation")
	@Override
	public boolean processAction(ActionRequest request, ActionResponse response) throws PortletException {
		long orderId = ParamUtil.getLong(request, "orderId");
		System.out.println("thanh toán");
		
        OrderDrink order = OrderDrinkLocalServiceUtil.fetchOrderDrink(orderId);
        if (order != null) {
            order.setPaid(true);
            OrderDrinkLocalServiceUtil.updateOrderDrink(order);
            
            // set status 
    	    long tableDrinkId = order.getTableDrinkId();
    	    
    	    TableDrink table = TableDrinkLocalServiceUtil.fetchTableDrink(tableDrinkId);
    	    if (table != null) {
		        table.setStatus("Trong"); 
		        TableDrinkLocalServiceUtil.updateTableDrink(table);
    	    }   
        }
        response.setRenderParameter("mvcRenderCommandName", "/orders");
        return true;
	}

}
