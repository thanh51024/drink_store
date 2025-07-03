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

package com.ntthanh.drink_store.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TableDrink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TableDrink
 * @generated
 */
public class TableDrinkWrapper
	extends BaseModelWrapper<TableDrink>
	implements ModelWrapper<TableDrink>, TableDrink {

	public TableDrinkWrapper(TableDrink tableDrink) {
		super(tableDrink);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tableDrinkId", getTableDrinkId());
		attributes.put("tableNumber", getTableNumber());
		attributes.put("seats", getSeats());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tableDrinkId = (Long)attributes.get("tableDrinkId");

		if (tableDrinkId != null) {
			setTableDrinkId(tableDrinkId);
		}

		Integer tableNumber = (Integer)attributes.get("tableNumber");

		if (tableNumber != null) {
			setTableNumber(tableNumber);
		}

		Integer seats = (Integer)attributes.get("seats");

		if (seats != null) {
			setSeats(seats);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public TableDrink cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the primary key of this table drink.
	 *
	 * @return the primary key of this table drink
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the seats of this table drink.
	 *
	 * @return the seats of this table drink
	 */
	@Override
	public int getSeats() {
		return model.getSeats();
	}

	/**
	 * Returns the status of this table drink.
	 *
	 * @return the status of this table drink
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the table drink ID of this table drink.
	 *
	 * @return the table drink ID of this table drink
	 */
	@Override
	public long getTableDrinkId() {
		return model.getTableDrinkId();
	}

	/**
	 * Returns the table number of this table drink.
	 *
	 * @return the table number of this table drink
	 */
	@Override
	public int getTableNumber() {
		return model.getTableNumber();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this table drink.
	 *
	 * @param primaryKey the primary key of this table drink
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the seats of this table drink.
	 *
	 * @param seats the seats of this table drink
	 */
	@Override
	public void setSeats(int seats) {
		model.setSeats(seats);
	}

	/**
	 * Sets the status of this table drink.
	 *
	 * @param status the status of this table drink
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the table drink ID of this table drink.
	 *
	 * @param tableDrinkId the table drink ID of this table drink
	 */
	@Override
	public void setTableDrinkId(long tableDrinkId) {
		model.setTableDrinkId(tableDrinkId);
	}

	/**
	 * Sets the table number of this table drink.
	 *
	 * @param tableNumber the table number of this table drink
	 */
	@Override
	public void setTableNumber(int tableNumber) {
		model.setTableNumber(tableNumber);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected TableDrinkWrapper wrap(TableDrink tableDrink) {
		return new TableDrinkWrapper(tableDrink);
	}

}