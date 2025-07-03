package com.ntthanh.drink_store.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.ntthanh.drink_store.service.TableDrinkLocalService;
import com.ntthanh.drink_store.web.constants.DrinkStoreControllerPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+DrinkStoreControllerPortletKeys.DRINKSTORECONTROLLER,
	        "mvc.command.name=/deleteTableDrink"
	    },
	    service = MVCActionCommand.class
	)
public class DeleteTableDrinkMVCActionCommand extends BaseMVCActionCommand {

    @Reference
    private TableDrinkLocalService _tableDrinkLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long tableDrinkId = ParamUtil.getLong(actionRequest, "tableDrinkId");

        try {
            _tableDrinkLocalService.deleteTableDrink(tableDrinkId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

