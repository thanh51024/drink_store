package com.ntthanh.drink_store.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.ntthanh.drink_store.service.OrderDrinkLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.ntthanh.drink_store.web.constants.DrinkStoreControllerPortletKeys;

@Component(
    property = {
        "javax.portlet.name=" + DrinkStoreControllerPortletKeys.DRINKSTORECONTROLLER,
        "mvc.command.name=/delete_order"
    },
    service = MVCActionCommand.class
)
public class DeleteOrderActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) throws PortletException {
        long orderId = ParamUtil.getLong(request, "orderId");
        
        try {
            OrderDrinkLocalServiceUtil.deleteOrderDrink(orderId);
        } catch (Exception e) {
            throw new PortletException("Lỗi khi xóa đơn hàng: " + e.getMessage());
        }
        
        response.setRenderParameter("mvcRenderCommandName", "/orders");
        return true;
    }
}