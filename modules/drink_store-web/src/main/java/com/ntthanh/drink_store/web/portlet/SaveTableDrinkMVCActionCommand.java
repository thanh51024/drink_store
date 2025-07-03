package com.ntthanh.drink_store.web.portlet;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.ntthanh.drink_store.model.TableDrink;
import com.ntthanh.drink_store.service.DrinkService;
import com.ntthanh.drink_store.service.TableDrinkLocalService;
import com.ntthanh.drink_store.service.TableDrinkService;
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
				"mvc.command.name=/saveTableDrink"
		}
		)
public class SaveTableDrinkMVCActionCommand extends BaseMVCActionCommand{

	 @Reference
	    private CounterLocalService _counterLocalService;

	    private TableDrinkService tableDrinkService;

	    @Reference(unbind = "-")
	    protected void setTableDrinkService(TableDrinkService tableDrinkService) {
	        this.tableDrinkService = tableDrinkService;
	    }

	    @Reference
	    private TableDrinkLocalService tableDrinkLocalService;
	    
	    @Override
	    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
	        long tableDrinkId = ParamUtil.getLong(actionRequest, "tableDrinkId", 0);
	        int tableNumber = ParamUtil.getInteger(actionRequest, "tableNumber", 1);
	        int seats = ParamUtil.getInteger(actionRequest, "seats", 4);
	        String status = ParamUtil.getString(actionRequest, "status", "Trống");

	        System.out.println("save() -> id: " + tableDrinkId + ", name: " + tableNumber);

	        TableDrink existingTableDrink = null;
	        if (tableDrinkId > 0) {
	            // Cố gắng tìm bàn trong database
	            existingTableDrink = tableDrinkLocalService.fetchTableDrink(tableDrinkId);
	        }

	        if (existingTableDrink != null) {
	            // Nếu tìm thấy bàn với tableDrinkId này trong DB, thì là cập nhật
	            System.out.println("update table ->>>>>>>>>>>>");
	            tableDrinkService.updateTableDrink(tableDrinkId, tableNumber, seats, status);
	        } else {
	            // Nếu không tìm thấy bàn hoặc tableDrinkId là 0, thì là tạo mới
	            System.out.println("create table ->>>>>>>>>>>>");
	            tableDrinkService.addTableDrink(tableNumber, seats, status);
	        }

	        // Sau khi lưu thành công, chuyển hướng về trang danh sách
	        String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
	        if (redirectURL != null && !redirectURL.isEmpty()) {
	            actionResponse.sendRedirect(redirectURL);
	        } else {
	            // Fallback URL nếu không có redirectURL được cung cấp
	            // Bạn có thể tạo một renderURL đến view.jsp ở đây nếu cần
	            System.out.println("Không có redirectURL. Có thể cần chuyển hướng mặc định.");
	        }
	    }
}
