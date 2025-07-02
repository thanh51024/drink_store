package com.ntthanh.drink_store.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.ntthanh.drink_store.service.DrinkLocalService;
import com.ntthanh.drink_store.web.constants.DrinkStoreControllerPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+DrinkStoreControllerPortletKeys.DRINKSTORECONTROLLER,
	        "mvc.command.name=/deleteDrink"
	    },
	    service = MVCActionCommand.class
	)
public class DeleteDrinkMVCActionCommand  extends BaseMVCActionCommand {

    @Reference
    private DrinkLocalService _drinkLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long drinkId = ParamUtil.getLong(actionRequest, "drinkId");

        if (drinkId > 0) {
        	System.out.println("delete drink"+drinkId);
            _drinkLocalService.deleteDrink(drinkId);
        }
    }
}
