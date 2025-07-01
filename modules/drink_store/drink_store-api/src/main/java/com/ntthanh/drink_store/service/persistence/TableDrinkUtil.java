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

package com.ntthanh.drink_store.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.ntthanh.drink_store.model.TableDrink;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the table drink service. This utility wraps <code>com.ntthanh.drink_store.service.persistence.impl.TableDrinkPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TableDrinkPersistence
 * @generated
 */
public class TableDrinkUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TableDrink tableDrink) {
		getPersistence().clearCache(tableDrink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, TableDrink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TableDrink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TableDrink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TableDrink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TableDrink> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TableDrink update(TableDrink tableDrink) {
		return getPersistence().update(tableDrink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TableDrink update(
		TableDrink tableDrink, ServiceContext serviceContext) {

		return getPersistence().update(tableDrink, serviceContext);
	}

	/**
	 * Returns all the table drinks where tableNumber = &#63;.
	 *
	 * @param tableNumber the table number
	 * @return the matching table drinks
	 */
	public static List<TableDrink> findByTableNumber(int tableNumber) {
		return getPersistence().findByTableNumber(tableNumber);
	}

	/**
	 * Returns a range of all the table drinks where tableNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param tableNumber the table number
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @return the range of matching table drinks
	 */
	public static List<TableDrink> findByTableNumber(
		int tableNumber, int start, int end) {

		return getPersistence().findByTableNumber(tableNumber, start, end);
	}

	/**
	 * Returns an ordered range of all the table drinks where tableNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param tableNumber the table number
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table drinks
	 */
	public static List<TableDrink> findByTableNumber(
		int tableNumber, int start, int end,
		OrderByComparator<TableDrink> orderByComparator) {

		return getPersistence().findByTableNumber(
			tableNumber, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table drinks where tableNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param tableNumber the table number
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table drinks
	 */
	public static List<TableDrink> findByTableNumber(
		int tableNumber, int start, int end,
		OrderByComparator<TableDrink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTableNumber(
			tableNumber, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table drink in the ordered set where tableNumber = &#63;.
	 *
	 * @param tableNumber the table number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table drink
	 * @throws NoSuchTableDrinkException if a matching table drink could not be found
	 */
	public static TableDrink findByTableNumber_First(
			int tableNumber, OrderByComparator<TableDrink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchTableDrinkException {

		return getPersistence().findByTableNumber_First(
			tableNumber, orderByComparator);
	}

	/**
	 * Returns the first table drink in the ordered set where tableNumber = &#63;.
	 *
	 * @param tableNumber the table number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	public static TableDrink fetchByTableNumber_First(
		int tableNumber, OrderByComparator<TableDrink> orderByComparator) {

		return getPersistence().fetchByTableNumber_First(
			tableNumber, orderByComparator);
	}

	/**
	 * Returns the last table drink in the ordered set where tableNumber = &#63;.
	 *
	 * @param tableNumber the table number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table drink
	 * @throws NoSuchTableDrinkException if a matching table drink could not be found
	 */
	public static TableDrink findByTableNumber_Last(
			int tableNumber, OrderByComparator<TableDrink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchTableDrinkException {

		return getPersistence().findByTableNumber_Last(
			tableNumber, orderByComparator);
	}

	/**
	 * Returns the last table drink in the ordered set where tableNumber = &#63;.
	 *
	 * @param tableNumber the table number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	public static TableDrink fetchByTableNumber_Last(
		int tableNumber, OrderByComparator<TableDrink> orderByComparator) {

		return getPersistence().fetchByTableNumber_Last(
			tableNumber, orderByComparator);
	}

	/**
	 * Returns the table drinks before and after the current table drink in the ordered set where tableNumber = &#63;.
	 *
	 * @param id the primary key of the current table drink
	 * @param tableNumber the table number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table drink
	 * @throws NoSuchTableDrinkException if a table drink with the primary key could not be found
	 */
	public static TableDrink[] findByTableNumber_PrevAndNext(
			long id, int tableNumber,
			OrderByComparator<TableDrink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchTableDrinkException {

		return getPersistence().findByTableNumber_PrevAndNext(
			id, tableNumber, orderByComparator);
	}

	/**
	 * Removes all the table drinks where tableNumber = &#63; from the database.
	 *
	 * @param tableNumber the table number
	 */
	public static void removeByTableNumber(int tableNumber) {
		getPersistence().removeByTableNumber(tableNumber);
	}

	/**
	 * Returns the number of table drinks where tableNumber = &#63;.
	 *
	 * @param tableNumber the table number
	 * @return the number of matching table drinks
	 */
	public static int countByTableNumber(int tableNumber) {
		return getPersistence().countByTableNumber(tableNumber);
	}

	/**
	 * Returns all the table drinks where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching table drinks
	 */
	public static List<TableDrink> findByStatus(String status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the table drinks where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @return the range of matching table drinks
	 */
	public static List<TableDrink> findByStatus(
		String status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the table drinks where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table drinks
	 */
	public static List<TableDrink> findByStatus(
		String status, int start, int end,
		OrderByComparator<TableDrink> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table drinks where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table drinks
	 */
	public static List<TableDrink> findByStatus(
		String status, int start, int end,
		OrderByComparator<TableDrink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table drink in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table drink
	 * @throws NoSuchTableDrinkException if a matching table drink could not be found
	 */
	public static TableDrink findByStatus_First(
			String status, OrderByComparator<TableDrink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchTableDrinkException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first table drink in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	public static TableDrink fetchByStatus_First(
		String status, OrderByComparator<TableDrink> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last table drink in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table drink
	 * @throws NoSuchTableDrinkException if a matching table drink could not be found
	 */
	public static TableDrink findByStatus_Last(
			String status, OrderByComparator<TableDrink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchTableDrinkException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last table drink in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	public static TableDrink fetchByStatus_Last(
		String status, OrderByComparator<TableDrink> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the table drinks before and after the current table drink in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current table drink
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table drink
	 * @throws NoSuchTableDrinkException if a table drink with the primary key could not be found
	 */
	public static TableDrink[] findByStatus_PrevAndNext(
			long id, String status,
			OrderByComparator<TableDrink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchTableDrinkException {

		return getPersistence().findByStatus_PrevAndNext(
			id, status, orderByComparator);
	}

	/**
	 * Removes all the table drinks where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(String status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of table drinks where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching table drinks
	 */
	public static int countByStatus(String status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the table drinks where seats = &#63;.
	 *
	 * @param seats the seats
	 * @return the matching table drinks
	 */
	public static List<TableDrink> findBySeats(int seats) {
		return getPersistence().findBySeats(seats);
	}

	/**
	 * Returns a range of all the table drinks where seats = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param seats the seats
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @return the range of matching table drinks
	 */
	public static List<TableDrink> findBySeats(int seats, int start, int end) {
		return getPersistence().findBySeats(seats, start, end);
	}

	/**
	 * Returns an ordered range of all the table drinks where seats = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param seats the seats
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table drinks
	 */
	public static List<TableDrink> findBySeats(
		int seats, int start, int end,
		OrderByComparator<TableDrink> orderByComparator) {

		return getPersistence().findBySeats(
			seats, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table drinks where seats = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param seats the seats
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table drinks
	 */
	public static List<TableDrink> findBySeats(
		int seats, int start, int end,
		OrderByComparator<TableDrink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySeats(
			seats, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first table drink in the ordered set where seats = &#63;.
	 *
	 * @param seats the seats
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table drink
	 * @throws NoSuchTableDrinkException if a matching table drink could not be found
	 */
	public static TableDrink findBySeats_First(
			int seats, OrderByComparator<TableDrink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchTableDrinkException {

		return getPersistence().findBySeats_First(seats, orderByComparator);
	}

	/**
	 * Returns the first table drink in the ordered set where seats = &#63;.
	 *
	 * @param seats the seats
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	public static TableDrink fetchBySeats_First(
		int seats, OrderByComparator<TableDrink> orderByComparator) {

		return getPersistence().fetchBySeats_First(seats, orderByComparator);
	}

	/**
	 * Returns the last table drink in the ordered set where seats = &#63;.
	 *
	 * @param seats the seats
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table drink
	 * @throws NoSuchTableDrinkException if a matching table drink could not be found
	 */
	public static TableDrink findBySeats_Last(
			int seats, OrderByComparator<TableDrink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchTableDrinkException {

		return getPersistence().findBySeats_Last(seats, orderByComparator);
	}

	/**
	 * Returns the last table drink in the ordered set where seats = &#63;.
	 *
	 * @param seats the seats
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	public static TableDrink fetchBySeats_Last(
		int seats, OrderByComparator<TableDrink> orderByComparator) {

		return getPersistence().fetchBySeats_Last(seats, orderByComparator);
	}

	/**
	 * Returns the table drinks before and after the current table drink in the ordered set where seats = &#63;.
	 *
	 * @param id the primary key of the current table drink
	 * @param seats the seats
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table drink
	 * @throws NoSuchTableDrinkException if a table drink with the primary key could not be found
	 */
	public static TableDrink[] findBySeats_PrevAndNext(
			long id, int seats, OrderByComparator<TableDrink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchTableDrinkException {

		return getPersistence().findBySeats_PrevAndNext(
			id, seats, orderByComparator);
	}

	/**
	 * Removes all the table drinks where seats = &#63; from the database.
	 *
	 * @param seats the seats
	 */
	public static void removeBySeats(int seats) {
		getPersistence().removeBySeats(seats);
	}

	/**
	 * Returns the number of table drinks where seats = &#63;.
	 *
	 * @param seats the seats
	 * @return the number of matching table drinks
	 */
	public static int countBySeats(int seats) {
		return getPersistence().countBySeats(seats);
	}

	/**
	 * Caches the table drink in the entity cache if it is enabled.
	 *
	 * @param tableDrink the table drink
	 */
	public static void cacheResult(TableDrink tableDrink) {
		getPersistence().cacheResult(tableDrink);
	}

	/**
	 * Caches the table drinks in the entity cache if it is enabled.
	 *
	 * @param tableDrinks the table drinks
	 */
	public static void cacheResult(List<TableDrink> tableDrinks) {
		getPersistence().cacheResult(tableDrinks);
	}

	/**
	 * Creates a new table drink with the primary key. Does not add the table drink to the database.
	 *
	 * @param id the primary key for the new table drink
	 * @return the new table drink
	 */
	public static TableDrink create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the table drink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the table drink
	 * @return the table drink that was removed
	 * @throws NoSuchTableDrinkException if a table drink with the primary key could not be found
	 */
	public static TableDrink remove(long id)
		throws com.ntthanh.drink_store.exception.NoSuchTableDrinkException {

		return getPersistence().remove(id);
	}

	public static TableDrink updateImpl(TableDrink tableDrink) {
		return getPersistence().updateImpl(tableDrink);
	}

	/**
	 * Returns the table drink with the primary key or throws a <code>NoSuchTableDrinkException</code> if it could not be found.
	 *
	 * @param id the primary key of the table drink
	 * @return the table drink
	 * @throws NoSuchTableDrinkException if a table drink with the primary key could not be found
	 */
	public static TableDrink findByPrimaryKey(long id)
		throws com.ntthanh.drink_store.exception.NoSuchTableDrinkException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the table drink with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the table drink
	 * @return the table drink, or <code>null</code> if a table drink with the primary key could not be found
	 */
	public static TableDrink fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the table drinks.
	 *
	 * @return the table drinks
	 */
	public static List<TableDrink> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the table drinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @return the range of table drinks
	 */
	public static List<TableDrink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the table drinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of table drinks
	 */
	public static List<TableDrink> findAll(
		int start, int end, OrderByComparator<TableDrink> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the table drinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of table drinks
	 */
	public static List<TableDrink> findAll(
		int start, int end, OrderByComparator<TableDrink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the table drinks from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of table drinks.
	 *
	 * @return the number of table drinks
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TableDrinkPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TableDrinkPersistence _persistence;

}