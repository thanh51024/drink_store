package com.ntthanh.drink_store.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.ntthanh.drink_store.service.DrinkService;
import com.ntthanh.drink_store.web.constants.DrinkStoreControllerPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
	    service = MVCActionCommand.class,
		property= {
				"javax.portlet.name=" +DrinkStoreControllerPortletKeys.DRINKSTORECONTROLLER,
				"mvc.command.name=/saveDrink"
		}
		)
public class SaveMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long drinkId = ParamUtil.getLong(actionRequest, "drinkId", 0);
	    String drinkName = ParamUtil.getString(actionRequest, "drinkName", "");
	    String category = ParamUtil.getString(actionRequest, "category", "");
	    long price = ParamUtil.getLong(actionRequest, "price", 1000);
	    String imageUrl = ParamUtil.getString(actionRequest, "imageUrl", "");

	    System.out.println("save() -> id: " + drinkId + ", name: " + drinkName);

	    if (drinkId > 0) {
	        drinkService.updateDrink(drinkId, drinkName, category, price, imageUrl);
	    } else {
	        drinkService.addDrink(drinkName, category, price, imageUrl);
	    }
	}
	
	private DrinkService drinkService;
	
	@Reference(unbind ="-")
	protected void setDrinkService(DrinkService drinkService) {
	
		this.drinkService=drinkService;
	}

}
