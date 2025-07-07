package com.ntthanh.drink_store.web.portlet;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.ntthanh.drink_store.model.TableDrink;
import com.ntthanh.drink_store.service.TableDrinkLocalService;
import com.ntthanh.drink_store.web.constants.DrinkStoreControllerPortletKeys;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
	    service = MVCRenderCommand.class,

		property= {
				"javax.portlet.name=" +DrinkStoreControllerPortletKeys.DRINKSTORECONTROLLER,
				"mvc.command.name=/createTableDrink/editTableDrink"
		}
		)
public class CreateEditTableDrinkMVCRenderCommand implements MVCRenderCommand  {

	@Reference
	private TableDrinkLocalService _tableDrinkLocalService;

	@Reference
	private CounterLocalService _counterLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long tableDrinkId = ParamUtil.getLong(renderRequest, "tableDrinkId");
		System.out.println("tabledrinkid"+tableDrinkId);
	    if (tableDrinkId > 0) {
	        try {
	            TableDrink tableDrink = _tableDrinkLocalService.fetchTableDrink(tableDrinkId);
	    		System.out.println("tabledrinki -> "+tableDrink);
	            if (tableDrink != null) {
	                renderRequest.setAttribute("editTableDrink", tableDrink);
	            }
	        } catch (Exception e) {
	            e.printStackTrace(); 
	        }
	    } else {
	    	try {
	    		List<TableDrink> allTables = _tableDrinkLocalService.getTableDrinks(-1, -1);

	    		 Set<Integer> usedTableNumbers = new HashSet<>();
	             for (TableDrink table : allTables) {
	                 usedTableNumbers.add(table.getTableNumber());
	             }

	             // Tìm số bàn nhỏ nhất chưa sử dụng
	             int nextTableNumber = 1;
	             while (usedTableNumbers.contains(nextTableNumber)) {
	                 nextTableNumber++;
	             }
	    		
	    		// Tạo bàn mới
	    		TableDrink newTable = _tableDrinkLocalService.createTableDrink(
	    				_counterLocalService.increment(TableDrink.class.getName()));
	    		newTable.setTableNumber(nextTableNumber);
	    		newTable.setSeats(4);
	    		newTable.setStatus("Trống");
	    		
	    		renderRequest.setAttribute("editTableDrink", newTable);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    }

	    return "/editTableDrink.jsp";
	}
}
