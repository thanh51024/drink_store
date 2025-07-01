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

/**
 * The table class for the &quot;DRINK_STORE_TableDrink&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TableDrink
 * @generated
 */
public class TableDrinkTable extends BaseTable<TableDrinkTable> {

	public static final TableDrinkTable INSTANCE = new TableDrinkTable();

	public final Column<TableDrinkTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TableDrinkTable, Integer> tableNumber = createColumn(
		"tableNumber", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<TableDrinkTable, Integer> seats = createColumn(
		"seats", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<TableDrinkTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private TableDrinkTable() {
		super("DRINK_STORE_TableDrink", TableDrinkTable::new);
	}

}