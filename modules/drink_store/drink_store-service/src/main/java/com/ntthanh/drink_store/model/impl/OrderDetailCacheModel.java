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

import com.ntthanh.drink_store.model.OrderDetail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing OrderDetail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OrderDetailCacheModel
	implements CacheModel<OrderDetail>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OrderDetailCacheModel)) {
			return false;
		}

		OrderDetailCacheModel orderDetailCacheModel =
			(OrderDetailCacheModel)object;

		if (id == orderDetailCacheModel.id) {
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
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", orderId=");
		sb.append(orderId);
		sb.append(", drinkId=");
		sb.append(drinkId);
		sb.append(", number=");
		sb.append(number);
		sb.append(", price=");
		sb.append(price);
		sb.append(", size=");
		sb.append(size);
		sb.append(", note=");
		sb.append(note);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OrderDetail toEntityModel() {
		OrderDetailImpl orderDetailImpl = new OrderDetailImpl();

		orderDetailImpl.setId(id);
		orderDetailImpl.setOrderId(orderId);
		orderDetailImpl.setDrinkId(drinkId);
		orderDetailImpl.setNumber(number);
		orderDetailImpl.setPrice(price);

		if (size == null) {
			orderDetailImpl.setSize("");
		}
		else {
			orderDetailImpl.setSize(size);
		}

		if (note == null) {
			orderDetailImpl.setNote("");
		}
		else {
			orderDetailImpl.setNote(note);
		}

		orderDetailImpl.resetOriginalValues();

		return orderDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		orderId = objectInput.readLong();

		drinkId = objectInput.readLong();

		number = objectInput.readInt();

		price = objectInput.readDouble();
		size = objectInput.readUTF();
		note = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(orderId);

		objectOutput.writeLong(drinkId);

		objectOutput.writeInt(number);

		objectOutput.writeDouble(price);

		if (size == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(size);
		}

		if (note == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(note);
		}
	}

	public long id;
	public long orderId;
	public long drinkId;
	public int number;
	public double price;
	public String size;
	public String note;

}