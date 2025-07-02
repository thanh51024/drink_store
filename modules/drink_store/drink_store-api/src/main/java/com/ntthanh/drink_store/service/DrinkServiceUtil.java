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

import com.ntthanh.drink_store.model.Drink;

import java.util.List;

/**
 * Provides the remote service utility for Drink. This utility wraps
 * <code>com.ntthanh.drink_store.service.impl.DrinkServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DrinkService
 * @generated
 */
public class DrinkServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ntthanh.drink_store.service.impl.DrinkServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Drink addDrink(
		String drinkName, String category, double price, String imageUrl) {

		return getService().addDrink(drinkName, category, price, imageUrl);
	}

	public static Long getDinkCount() {
		return getService().getDinkCount();
	}

	public static List<Drink> getDinks(int start, int end) {
		return getService().getDinks(start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void updateDrink(
		long drinkId, String drinkName, String category, long price,
		String imageUrl) {

		getService().updateDrink(drinkId, drinkName, category, price, imageUrl);
	}

	public static DrinkService getService() {
		return _service;
	}

	private static volatile DrinkService _service;

}