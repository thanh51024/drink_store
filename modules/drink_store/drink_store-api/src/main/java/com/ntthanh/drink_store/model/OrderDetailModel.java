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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the OrderDetail service. Represents a row in the &quot;DRINK_STORE_OrderDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ntthanh.drink_store.model.impl.OrderDetailModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ntthanh.drink_store.model.impl.OrderDetailImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrderDetail
 * @generated
 */
@ProviderType
public interface OrderDetailModel extends BaseModel<OrderDetail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a order detail model instance should use the {@link OrderDetail} interface instead.
	 */

	/**
	 * Returns the primary key of this order detail.
	 *
	 * @return the primary key of this order detail
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this order detail.
	 *
	 * @param primaryKey the primary key of this order detail
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this order detail.
	 *
	 * @return the ID of this order detail
	 */
	public long getId();

	/**
	 * Sets the ID of this order detail.
	 *
	 * @param id the ID of this order detail
	 */
	public void setId(long id);

	/**
	 * Returns the order ID of this order detail.
	 *
	 * @return the order ID of this order detail
	 */
	public long getOrderId();

	/**
	 * Sets the order ID of this order detail.
	 *
	 * @param orderId the order ID of this order detail
	 */
	public void setOrderId(long orderId);

	/**
	 * Returns the drink ID of this order detail.
	 *
	 * @return the drink ID of this order detail
	 */
	public long getDrinkId();

	/**
	 * Sets the drink ID of this order detail.
	 *
	 * @param drinkId the drink ID of this order detail
	 */
	public void setDrinkId(long drinkId);

	/**
	 * Returns the number of this order detail.
	 *
	 * @return the number of this order detail
	 */
	public int getNumber();

	/**
	 * Sets the number of this order detail.
	 *
	 * @param number the number of this order detail
	 */
	public void setNumber(int number);

	/**
	 * Returns the price of this order detail.
	 *
	 * @return the price of this order detail
	 */
	public double getPrice();

	/**
	 * Sets the price of this order detail.
	 *
	 * @param price the price of this order detail
	 */
	public void setPrice(double price);

	/**
	 * Returns the size of this order detail.
	 *
	 * @return the size of this order detail
	 */
	@AutoEscape
	public String getSize();

	/**
	 * Sets the size of this order detail.
	 *
	 * @param size the size of this order detail
	 */
	public void setSize(String size);

	/**
	 * Returns the note of this order detail.
	 *
	 * @return the note of this order detail
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this order detail.
	 *
	 * @param note the note of this order detail
	 */
	public void setNote(String note);

	@Override
	public OrderDetail cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}