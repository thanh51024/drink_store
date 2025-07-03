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

import com.ntthanh.drink_store.model.TableDrink;

import java.util.List;

/**
 * Provides the remote service utility for TableDrink. This utility wraps
 * <code>com.ntthanh.drink_store.service.impl.TableDrinkServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TableDrinkService
 * @generated
 */
public class TableDrinkServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ntthanh.drink_store.service.impl.TableDrinkServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static TableDrink addTableDrink(
		int tableNumber, int seats, String status) {

		return getService().addTableDrink(tableNumber, seats, status);
	}

	public static TableDrink fetchTableDrink(long tableDrinkId) {
		return getService().fetchTableDrink(tableDrinkId);
	}

	public static TableDrink fetchTableDrinkByTableDrinkId(long tableNumberId) {
		return getService().fetchTableDrinkByTableDrinkId(tableNumberId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static int getTableDinkCount() {
		return getService().getTableDinkCount();
	}

	public static int getTableDrinkCount() {
		return getService().getTableDrinkCount();
	}

	public static List<TableDrink> getTableDrinks(int start, int end) {
		return getService().getTableDrinks(start, end);
	}

	public static void updateTableDrink(
		long tableNumberId, int tableNumber, int seats, String status) {

		getService().updateTableDrink(
			tableNumberId, tableNumber, seats, status);
	}

	public static TableDrinkService getService() {
		return _service;
	}

	private static volatile TableDrinkService _service;

}