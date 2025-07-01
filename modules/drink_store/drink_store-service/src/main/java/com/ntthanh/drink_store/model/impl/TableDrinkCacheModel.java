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

import com.ntthanh.drink_store.model.TableDrink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TableDrink in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TableDrinkCacheModel
	implements CacheModel<TableDrink>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TableDrinkCacheModel)) {
			return false;
		}

		TableDrinkCacheModel tableDrinkCacheModel =
			(TableDrinkCacheModel)object;

		if (id == tableDrinkCacheModel.id) {
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
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", tableNumber=");
		sb.append(tableNumber);
		sb.append(", seats=");
		sb.append(seats);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TableDrink toEntityModel() {
		TableDrinkImpl tableDrinkImpl = new TableDrinkImpl();

		tableDrinkImpl.setId(id);
		tableDrinkImpl.setTableNumber(tableNumber);
		tableDrinkImpl.setSeats(seats);

		if (status == null) {
			tableDrinkImpl.setStatus("");
		}
		else {
			tableDrinkImpl.setStatus(status);
		}

		tableDrinkImpl.resetOriginalValues();

		return tableDrinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		tableNumber = objectInput.readInt();

		seats = objectInput.readInt();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeInt(tableNumber);

		objectOutput.writeInt(seats);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public long id;
	public int tableNumber;
	public int seats;
	public String status;

}