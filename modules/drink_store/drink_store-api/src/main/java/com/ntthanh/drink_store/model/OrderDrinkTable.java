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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;DRINK_STORE_OrderDrink&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see OrderDrink
 * @generated
 */
public class OrderDrinkTable extends BaseTable<OrderDrinkTable> {

	public static final OrderDrinkTable INSTANCE = new OrderDrinkTable();

	public final Column<OrderDrinkTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<OrderDrinkTable, Long> tableId = createColumn(
		"tableId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OrderDrinkTable, Double> totalAmount = createColumn(
		"totalAmount", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<OrderDrinkTable, Date> orderDate = createColumn(
		"orderDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<OrderDrinkTable, Boolean> paid = createColumn(
		"paid", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private OrderDrinkTable() {
		super("DRINK_STORE_OrderDrink", OrderDrinkTable::new);
	}

}