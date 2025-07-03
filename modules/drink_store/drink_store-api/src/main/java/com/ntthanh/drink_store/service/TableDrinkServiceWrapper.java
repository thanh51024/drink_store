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
 * Provides a wrapper for {@link TableDrinkService}.
 *
 * @author Brian Wing Shun Chan
 * @see TableDrinkService
 * @generated
 */
public class TableDrinkServiceWrapper
	implements ServiceWrapper<TableDrinkService>, TableDrinkService {

	public TableDrinkServiceWrapper() {
		this(null);
	}

	public TableDrinkServiceWrapper(TableDrinkService tableDrinkService) {
		_tableDrinkService = tableDrinkService;
	}

	@Override
	public com.ntthanh.drink_store.model.TableDrink addTableDrink(
		int tableNumber, int seats, String status) {

		return _tableDrinkService.addTableDrink(tableNumber, seats, status);
	}

	@Override
	public com.ntthanh.drink_store.model.TableDrink fetchTableDrink(
		long tableDrinkId) {

		return _tableDrinkService.fetchTableDrink(tableDrinkId);
	}

	@Override
	public com.ntthanh.drink_store.model.TableDrink
		fetchTableDrinkByTableDrinkId(long tableNumberId) {

		return _tableDrinkService.fetchTableDrinkByTableDrinkId(tableNumberId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tableDrinkService.getOSGiServiceIdentifier();
	}

	@Override
	public int getTableDinkCount() {
		return _tableDrinkService.getTableDinkCount();
	}

	@Override
	public int getTableDrinkCount() {
		return _tableDrinkService.getTableDrinkCount();
	}

	@Override
	public java.util.List<com.ntthanh.drink_store.model.TableDrink>
		getTableDrinks(int start, int end) {

		return _tableDrinkService.getTableDrinks(start, end);
	}

	@Override
	public void updateTableDrink(
		long tableNumberId, int tableNumber, int seats, String status) {

		_tableDrinkService.updateTableDrink(
			tableNumberId, tableNumber, seats, status);
	}

	@Override
	public TableDrinkService getWrappedService() {
		return _tableDrinkService;
	}

	@Override
	public void setWrappedService(TableDrinkService tableDrinkService) {
		_tableDrinkService = tableDrinkService;
	}

	private TableDrinkService _tableDrinkService;

}