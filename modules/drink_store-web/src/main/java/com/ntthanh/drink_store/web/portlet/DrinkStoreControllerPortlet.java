package com.ntthanh.drink_store.web.portlet;

import com.ntthanh.drink_store.model.Drink;
import com.ntthanh.drink_store.model.TableDrink;
import com.ntthanh.drink_store.service.DrinkLocalService;
import com.ntthanh.drink_store.service.DrinkService;
import com.ntthanh.drink_store.service.TableDrinkService;
import com.ntthanh.drink_store.web.constants.DrinkStoreControllerPortletKeys;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
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
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DrinkStoreControllerPortlet extends MVCPortlet {
	// submit form và đẩy dử liệu
	@ProcessAction(name = "searchByCategoryURL")
		public void filterDrinks(ActionRequest request, ActionResponse response) {
			String category = ParamUtil.getString(request, "category");
			response.setRenderParameter("category", category); 
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