package com.ntthanh.drink_store.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.ntthanh.drink_store.model.Drink;
import com.ntthanh.drink_store.service.DrinkLocalServiceUtil;
import com.ntthanh.drink_store.web.constants.DrinkStoreControllerPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;


@Component(
		immediate = true,
	    service = MVCRenderCommand.class,

		property= {
				"javax.portlet.name=" +DrinkStoreControllerPortletKeys.DRINKSTORECONTROLLER,
				"mvc.command.name=/create/edit"
		}
		)
public class CreateEditMVCRenderCommand implements MVCRenderCommand  {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long drinkId = ParamUtil.getLong(renderRequest, "drinkId");

	    if (drinkId > 0) {
	        try {
	            Drink drink = DrinkLocalServiceUtil.fetchDrink(drinkId);
	            if (drink != null) {
	                renderRequest.setAttribute("editDrink", drink);
	            }
	        } catch (Exception e) {
	            e.printStackTrace(); 
	        }
	    }
	    return "/edit.jsp";
	}

}
