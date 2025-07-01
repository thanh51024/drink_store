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
import com.ntthanh.drink_store.model.Drink;
import com.ntthanh.drink_store.service.DrinkLocalService;
import com.ntthanh.drink_store.service.base.DrinkServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=drink_store",
		"json.web.service.context.path=Drink"
	},
	service = AopService.class
)
public class DrinkServiceImpl extends DrinkServiceBaseImpl {
	public Drink addDrink(String drinkName, String category, double price, String imageUrl) {
		return drinkLocalService.addDrink(drinkName, category, price, imageUrl);
	}
	
	public List<Drink> getDinks(int start, int end) {
		return drinkLocalService.getDrinks(start, end);
		
	}
	
	public Long getDinkCount() {
		return (long) drinkLocalService.getDrinksCount();
		
	}
	
}