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
import com.ntthanh.drink_store.model.impl.DrinkImpl;
import com.ntthanh.drink_store.service.DrinkLocalService;
import com.ntthanh.drink_store.service.base.DrinkLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Brian Wing Shun Chan
 */

//@Component(
//		property = "model.class.name=com.ntthanh.drink_store.model.Drink",
//		service = {DrinkLocalService.class, AopService.class}
//	)
//public class DrinkLocalServiceImpl extends DrinkLocalServiceBaseImpl {
@Component(
		property = "model.class.name=com.ntthanh.drink_store.model.Drink",
		service = AopService.class
	)
public class DrinkLocalServiceImpl extends DrinkLocalServiceBaseImpl implements AopService {

	public Drink addDrink(String drinkName, String category, double price, String imageUrl) {
		Drink drink= new DrinkImpl();
		
		long drinkId= counterLocalService.increment(Drink.class.getName());
		drink.setId(drinkId);
		drink.setDrinkName(drinkName);
		drink.setCategory(category);
		drink.setPrice(price);
		drink.setImageUrl(imageUrl);
		
		drinkLocalService.addDrink(drink);
		return drink;
	}
}