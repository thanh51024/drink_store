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

package com.ntthanh.drink_store.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.ntthanh.drink_store.model.OrderDrink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing OrderDrink in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OrderDrinkCacheModel
	implements CacheModel<OrderDrink>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OrderDrinkCacheModel)) {
			return false;
		}

		OrderDrinkCacheModel orderDrinkCacheModel =
			(OrderDrinkCacheModel)object;

		if (id == orderDrinkCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", tableDrinkId=");
		sb.append(tableDrinkId);
		sb.append(", totalAmount=");
		sb.append(totalAmount);
		sb.append(", orderDate=");
		sb.append(orderDate);
		sb.append(", paid=");
		sb.append(paid);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OrderDrink toEntityModel() {
		OrderDrinkImpl orderDrinkImpl = new OrderDrinkImpl();

		orderDrinkImpl.setId(id);
		orderDrinkImpl.setTableDrinkId(tableDrinkId);
		orderDrinkImpl.setTotalAmount(totalAmount);

		if (orderDate == Long.MIN_VALUE) {
			orderDrinkImpl.setOrderDate(null);
		}
		else {
			orderDrinkImpl.setOrderDate(new Date(orderDate));
		}

		orderDrinkImpl.setPaid(paid);

		orderDrinkImpl.resetOriginalValues();

		return orderDrinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		tableDrinkId = objectInput.readLong();

		totalAmount = objectInput.readDouble();
		orderDate = objectInput.readLong();

		paid = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(tableDrinkId);

		objectOutput.writeDouble(totalAmount);
		objectOutput.writeLong(orderDate);

		objectOutput.writeBoolean(paid);
	}

	public long id;
	public long tableDrinkId;
	public double totalAmount;
	public long orderDate;
	public boolean paid;

}