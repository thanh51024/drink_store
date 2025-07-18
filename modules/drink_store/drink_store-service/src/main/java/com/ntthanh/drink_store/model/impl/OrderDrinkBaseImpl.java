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

import com.ntthanh.drink_store.model.OrderDrink;
import com.ntthanh.drink_store.service.OrderDrinkLocalServiceUtil;

/**
 * The extended model base implementation for the OrderDrink service. Represents a row in the &quot;DRINK_STORE_OrderDrink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OrderDrinkImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrderDrinkImpl
 * @see OrderDrink
 * @generated
 */
public abstract class OrderDrinkBaseImpl
	extends OrderDrinkModelImpl implements OrderDrink {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a order drink model instance should use the <code>OrderDrink</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			OrderDrinkLocalServiceUtil.addOrderDrink(this);
		}
		else {
			OrderDrinkLocalServiceUtil.updateOrderDrink(this);
		}
	}

}