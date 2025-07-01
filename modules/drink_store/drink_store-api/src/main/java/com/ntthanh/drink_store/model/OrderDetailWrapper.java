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
 * This class is a wrapper for {@link OrderDetail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrderDetail
 * @generated
 */
public class OrderDetailWrapper
	extends BaseModelWrapper<OrderDetail>
	implements ModelWrapper<OrderDetail>, OrderDetail {

	public OrderDetailWrapper(OrderDetail orderDetail) {
		super(orderDetail);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("orderId", getOrderId());
		attributes.put("drinkId", getDrinkId());
		attributes.put("number", getNumber());
		attributes.put("price", getPrice());
		attributes.put("size", getSize());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long orderId = (Long)attributes.get("orderId");

		if (orderId != null) {
			setOrderId(orderId);
		}

		Long drinkId = (Long)attributes.get("drinkId");

		if (drinkId != null) {
			setDrinkId(drinkId);
		}

		Integer number = (Integer)attributes.get("number");

		if (number != null) {
			setNumber(number);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		String size = (String)attributes.get("size");

		if (size != null) {
			setSize(size);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	@Override
	public OrderDetail cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the drink ID of this order detail.
	 *
	 * @return the drink ID of this order detail
	 */
	@Override
	public long getDrinkId() {
		return model.getDrinkId();
	}

	/**
	 * Returns the ID of this order detail.
	 *
	 * @return the ID of this order detail
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the note of this order detail.
	 *
	 * @return the note of this order detail
	 */
	@Override
	public String getNote() {
		return model.getNote();
	}

	/**
	 * Returns the number of this order detail.
	 *
	 * @return the number of this order detail
	 */
	@Override
	public int getNumber() {
		return model.getNumber();
	}

	/**
	 * Returns the order ID of this order detail.
	 *
	 * @return the order ID of this order detail
	 */
	@Override
	public long getOrderId() {
		return model.getOrderId();
	}

	/**
	 * Returns the price of this order detail.
	 *
	 * @return the price of this order detail
	 */
	@Override
	public double getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the primary key of this order detail.
	 *
	 * @return the primary key of this order detail
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the size of this order detail.
	 *
	 * @return the size of this order detail
	 */
	@Override
	public String getSize() {
		return model.getSize();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the drink ID of this order detail.
	 *
	 * @param drinkId the drink ID of this order detail
	 */
	@Override
	public void setDrinkId(long drinkId) {
		model.setDrinkId(drinkId);
	}

	/**
	 * Sets the ID of this order detail.
	 *
	 * @param id the ID of this order detail
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the note of this order detail.
	 *
	 * @param note the note of this order detail
	 */
	@Override
	public void setNote(String note) {
		model.setNote(note);
	}

	/**
	 * Sets the number of this order detail.
	 *
	 * @param number the number of this order detail
	 */
	@Override
	public void setNumber(int number) {
		model.setNumber(number);
	}

	/**
	 * Sets the order ID of this order detail.
	 *
	 * @param orderId the order ID of this order detail
	 */
	@Override
	public void setOrderId(long orderId) {
		model.setOrderId(orderId);
	}

	/**
	 * Sets the price of this order detail.
	 *
	 * @param price the price of this order detail
	 */
	@Override
	public void setPrice(double price) {
		model.setPrice(price);
	}

	/**
	 * Sets the primary key of this order detail.
	 *
	 * @param primaryKey the primary key of this order detail
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the size of this order detail.
	 *
	 * @param size the size of this order detail
	 */
	@Override
	public void setSize(String size) {
		model.setSize(size);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected OrderDetailWrapper wrap(OrderDetail orderDetail) {
		return new OrderDetailWrapper(orderDetail);
	}

}