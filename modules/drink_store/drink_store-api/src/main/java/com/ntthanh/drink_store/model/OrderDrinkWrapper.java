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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link OrderDrink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrderDrink
 * @generated
 */
public class OrderDrinkWrapper
	extends BaseModelWrapper<OrderDrink>
	implements ModelWrapper<OrderDrink>, OrderDrink {

	public OrderDrinkWrapper(OrderDrink orderDrink) {
		super(orderDrink);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("tableDrinkId", getTableDrinkId());
		attributes.put("totalAmount", getTotalAmount());
		attributes.put("orderDate", getOrderDate());
		attributes.put("paid", isPaid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long tableDrinkId = (Long)attributes.get("tableDrinkId");

		if (tableDrinkId != null) {
			setTableDrinkId(tableDrinkId);
		}

		Double totalAmount = (Double)attributes.get("totalAmount");

		if (totalAmount != null) {
			setTotalAmount(totalAmount);
		}

		Date orderDate = (Date)attributes.get("orderDate");

		if (orderDate != null) {
			setOrderDate(orderDate);
		}

		Boolean paid = (Boolean)attributes.get("paid");

		if (paid != null) {
			setPaid(paid);
		}
	}

	@Override
	public OrderDrink cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ID of this order drink.
	 *
	 * @return the ID of this order drink
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the order date of this order drink.
	 *
	 * @return the order date of this order drink
	 */
	@Override
	public Date getOrderDate() {
		return model.getOrderDate();
	}

	/**
	 * Returns the paid of this order drink.
	 *
	 * @return the paid of this order drink
	 */
	@Override
	public boolean getPaid() {
		return model.getPaid();
	}

	/**
	 * Returns the primary key of this order drink.
	 *
	 * @return the primary key of this order drink
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the table drink ID of this order drink.
	 *
	 * @return the table drink ID of this order drink
	 */
	@Override
	public long getTableDrinkId() {
		return model.getTableDrinkId();
	}

	/**
	 * Returns the total amount of this order drink.
	 *
	 * @return the total amount of this order drink
	 */
	@Override
	public double getTotalAmount() {
		return model.getTotalAmount();
	}

	/**
	 * Returns <code>true</code> if this order drink is paid.
	 *
	 * @return <code>true</code> if this order drink is paid; <code>false</code> otherwise
	 */
	@Override
	public boolean isPaid() {
		return model.isPaid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ID of this order drink.
	 *
	 * @param id the ID of this order drink
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the order date of this order drink.
	 *
	 * @param orderDate the order date of this order drink
	 */
	@Override
	public void setOrderDate(Date orderDate) {
		model.setOrderDate(orderDate);
	}

	/**
	 * Sets whether this order drink is paid.
	 *
	 * @param paid the paid of this order drink
	 */
	@Override
	public void setPaid(boolean paid) {
		model.setPaid(paid);
	}

	/**
	 * Sets the primary key of this order drink.
	 *
	 * @param primaryKey the primary key of this order drink
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the table drink ID of this order drink.
	 *
	 * @param tableDrinkId the table drink ID of this order drink
	 */
	@Override
	public void setTableDrinkId(long tableDrinkId) {
		model.setTableDrinkId(tableDrinkId);
	}

	/**
	 * Sets the total amount of this order drink.
	 *
	 * @param totalAmount the total amount of this order drink
	 */
	@Override
	public void setTotalAmount(double totalAmount) {
		model.setTotalAmount(totalAmount);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected OrderDrinkWrapper wrap(OrderDrink orderDrink) {
		return new OrderDrinkWrapper(orderDrink);
	}

}