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

package com.ntthanh.drink_store.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DrinkService}.
 *
 * @author Brian Wing Shun Chan
 * @see DrinkService
 * @generated
 */
public class DrinkServiceWrapper
	implements DrinkService, ServiceWrapper<DrinkService> {

	public DrinkServiceWrapper() {
		this(null);
	}

	public DrinkServiceWrapper(DrinkService drinkService) {
		_drinkService = drinkService;
	}

	@Override
	public com.ntthanh.drink_store.model.Drink addDrink(
		String drinkName, String category, double price, String imageUrl) {

		return _drinkService.addDrink(drinkName, category, price, imageUrl);
	}

	@Override
	public java.util.List<com.ntthanh.drink_store.model.Drink> findByCategory(
		String category) {

		return _drinkService.findByCategory(category);
	}

	@Override
	public Long getDinkCount() {
		return _drinkService.getDinkCount();
	}

	@Override
	public java.util.List<com.ntthanh.drink_store.model.Drink> getDinks(
		int start, int end) {

		return _drinkService.getDinks(start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _drinkService.getOSGiServiceIdentifier();
	}

	@Override
	public void updateDrink(
		long drinkId, String drinkName, String category, long price,
		String imageUrl) {

		_drinkService.updateDrink(
			drinkId, drinkName, category, price, imageUrl);
	}

	@Override
	public DrinkService getWrappedService() {
		return _drinkService;
	}

	@Override
	public void setWrappedService(DrinkService drinkService) {
		_drinkService = drinkService;
	}

	private DrinkService _drinkService;

}