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

import com.ntthanh.drink_store.model.Drink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Drink in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DrinkCacheModel implements CacheModel<Drink>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DrinkCacheModel)) {
			return false;
		}

		DrinkCacheModel drinkCacheModel = (DrinkCacheModel)object;

		if (id == drinkCacheModel.id) {
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
		sb.append(", drinkName=");
		sb.append(drinkName);
		sb.append(", category=");
		sb.append(category);
		sb.append(", price=");
		sb.append(price);
		sb.append(", imageUrl=");
		sb.append(imageUrl);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Drink toEntityModel() {
		DrinkImpl drinkImpl = new DrinkImpl();

		drinkImpl.setId(id);

		if (drinkName == null) {
			drinkImpl.setDrinkName("");
		}
		else {
			drinkImpl.setDrinkName(drinkName);
		}

		if (category == null) {
			drinkImpl.setCategory("");
		}
		else {
			drinkImpl.setCategory(category);
		}

		drinkImpl.setPrice(price);

		if (imageUrl == null) {
			drinkImpl.setImageUrl("");
		}
		else {
			drinkImpl.setImageUrl(imageUrl);
		}

		drinkImpl.resetOriginalValues();

		return drinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		drinkName = objectInput.readUTF();
		category = objectInput.readUTF();

		price = objectInput.readDouble();
		imageUrl = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (drinkName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(drinkName);
		}

		if (category == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(category);
		}

		objectOutput.writeDouble(price);

		if (imageUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imageUrl);
		}
	}

	public long id;
	public String drinkName;
	public String category;
	public double price;
	public String imageUrl;

}