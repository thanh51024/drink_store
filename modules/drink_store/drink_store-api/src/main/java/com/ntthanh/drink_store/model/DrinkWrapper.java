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
 * This class is a wrapper for {@link Drink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Drink
 * @generated
 */
public class DrinkWrapper
	extends BaseModelWrapper<Drink> implements Drink, ModelWrapper<Drink> {

	public DrinkWrapper(Drink drink) {
		super(drink);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("drinkName", getDrinkName());
		attributes.put("category", getCategory());
		attributes.put("price", getPrice());
		attributes.put("imageUrl", getImageUrl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String drinkName = (String)attributes.get("drinkName");

		if (drinkName != null) {
			setDrinkName(drinkName);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		String imageUrl = (String)attributes.get("imageUrl");

		if (imageUrl != null) {
			setImageUrl(imageUrl);
		}
	}

	@Override
	public Drink cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the category of this drink.
	 *
	 * @return the category of this drink
	 */
	@Override
	public String getCategory() {
		return model.getCategory();
	}

	/**
	 * Returns the drink name of this drink.
	 *
	 * @return the drink name of this drink
	 */
	@Override
	public String getDrinkName() {
		return model.getDrinkName();
	}

	/**
	 * Returns the ID of this drink.
	 *
	 * @return the ID of this drink
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the image url of this drink.
	 *
	 * @return the image url of this drink
	 */
	@Override
	public String getImageUrl() {
		return model.getImageUrl();
	}

	/**
	 * Returns the price of this drink.
	 *
	 * @return the price of this drink
	 */
	@Override
	public double getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the primary key of this drink.
	 *
	 * @return the primary key of this drink
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the category of this drink.
	 *
	 * @param category the category of this drink
	 */
	@Override
	public void setCategory(String category) {
		model.setCategory(category);
	}

	/**
	 * Sets the drink name of this drink.
	 *
	 * @param drinkName the drink name of this drink
	 */
	@Override
	public void setDrinkName(String drinkName) {
		model.setDrinkName(drinkName);
	}

	/**
	 * Sets the ID of this drink.
	 *
	 * @param id the ID of this drink
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the image url of this drink.
	 *
	 * @param imageUrl the image url of this drink
	 */
	@Override
	public void setImageUrl(String imageUrl) {
		model.setImageUrl(imageUrl);
	}

	/**
	 * Sets the price of this drink.
	 *
	 * @param price the price of this drink
	 */
	@Override
	public void setPrice(double price) {
		model.setPrice(price);
	}

	/**
	 * Sets the primary key of this drink.
	 *
	 * @param primaryKey the primary key of this drink
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DrinkWrapper wrap(Drink drink) {
		return new DrinkWrapper(drink);
	}

}