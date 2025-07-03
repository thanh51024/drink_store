/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ntthanh.drink_store.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.ntthanh.drink_store.model.Drink;
import com.ntthanh.drink_store.model.TableDrink;
import com.ntthanh.drink_store.service.base.TableDrinkServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=drink_store",
		"json.web.service.context.path=TableDrink"
	},
	service = AopService.class
)
public class TableDrinkServiceImpl extends TableDrinkServiceBaseImpl {
	
	public TableDrink addTableDrink(int tableNumber, int seats, String status) {
		long id = counterLocalService.increment(TableDrink.class.getName());
		 System.out.println("create table");

	    TableDrink tableDrink = tableDrinkPersistence.create(id);
	    tableDrink.setTableNumber(tableNumber);
	    tableDrink.setSeats(seats);
	    tableDrink.setStatus(status);

	    return tableDrinkPersistence.update(tableDrink);
	}
	
	public List<TableDrink> getTableDrinks(int start, int end) {
		return tableDrinkLocalService.getTableDrinks(start, end);
		
	}
	
	public int getTableDrinkCount() {
		return (int) tableDrinkLocalService.getTableDrinksCount();
		
	}
	
	public TableDrink fetchTableDrinkByTableDrinkId(long tableNumberId) {
	    return tableDrinkLocalService.findByTableDrinkId(tableNumberId);
	}
	
	@Override
	public void updateTableDrink(long tableNumberId, int tableNumber, int seats, String status){
		 TableDrink tableDrink = tableDrinkLocalService.fetchTableDrink(tableNumberId);
		 tableDrink.setTableNumber(tableNumber);
		 tableDrink.setSeats(seats);
		 tableDrink.setStatus(status);

		 tableDrinkPersistence.update(tableDrink);
	}

	@Override
	public int getTableDinkCount() {
		return tableDrinkLocalService.getTableDrinksCount();

	}

	@Override
	public TableDrink fetchTableDrink(long tableDrinkId) {
		// TODO Auto-generated method stub
		return null;
	}

}