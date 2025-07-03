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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.ntthanh.drink_store.exception.NoSuchTableDrinkException;
import com.ntthanh.drink_store.model.TableDrink;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the table drink service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TableDrinkUtil
 * @generated
 */
@ProviderType
public interface TableDrinkPersistence extends BasePersistence<TableDrink> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TableDrinkUtil} to access the table drink persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the table drink where tableDrinkId = &#63; or throws a <code>NoSuchTableDrinkException</code> if it could not be found.
	 *
	 * @param tableDrinkId the table drink ID
	 * @return the matching table drink
	 * @throws NoSuchTableDrinkException if a matching table drink could not be found
	 */
	public TableDrink findByTableDrinkId(long tableDrinkId)
		throws NoSuchTableDrinkException;

	/**
	 * Returns the table drink where tableDrinkId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tableDrinkId the table drink ID
	 * @return the matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	public TableDrink fetchByTableDrinkId(long tableDrinkId);

	/**
	 * Returns the table drink where tableDrinkId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tableDrinkId the table drink ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	public TableDrink fetchByTableDrinkId(
		long tableDrinkId, boolean useFinderCache);

	/**
	 * Removes the table drink where tableDrinkId = &#63; from the database.
	 *
	 * @param tableDrinkId the table drink ID
	 * @return the table drink that was removed
	 */
	public TableDrink removeByTableDrinkId(long tableDrinkId)
		throws NoSuchTableDrinkException;

	/**
	 * Returns the number of table drinks where tableDrinkId = &#63;.
	 *
	 * @param tableDrinkId the table drink ID
	 * @return the number of matching table drinks
	 */
	public int countByTableDrinkId(long tableDrinkId);

	/**
	 * Returns all the table drinks where tableNumber = &#63;.
	 *
	 * @param tableNumber the table number
	 * @return the matching table drinks
	 */
	public java.util.List<TableDrink> findByTableNumber(int tableNumber);

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
	public java.util.List<TableDrink> findByTableNumber(
		int tableNumber, int start, int end);

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
	public java.util.List<TableDrink> findByTableNumber(
		int tableNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
			orderByComparator);

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
	public java.util.List<TableDrink> findByTableNumber(
		int tableNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table drink in the ordered set where tableNumber = &#63;.
	 *
	 * @param tableNumber the table number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table drink
	 * @throws NoSuchTableDrinkException if a matching table drink could not be found
	 */
	public TableDrink findByTableNumber_First(
			int tableNumber,
			com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
				orderByComparator)
		throws NoSuchTableDrinkException;

	/**
	 * Returns the first table drink in the ordered set where tableNumber = &#63;.
	 *
	 * @param tableNumber the table number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	public TableDrink fetchByTableNumber_First(
		int tableNumber,
		com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
			orderByComparator);

	/**
	 * Returns the last table drink in the ordered set where tableNumber = &#63;.
	 *
	 * @param tableNumber the table number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table drink
	 * @throws NoSuchTableDrinkException if a matching table drink could not be found
	 */
	public TableDrink findByTableNumber_Last(
			int tableNumber,
			com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
				orderByComparator)
		throws NoSuchTableDrinkException;

	/**
	 * Returns the last table drink in the ordered set where tableNumber = &#63;.
	 *
	 * @param tableNumber the table number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	public TableDrink fetchByTableNumber_Last(
		int tableNumber,
		com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
			orderByComparator);

	/**
	 * Returns the table drinks before and after the current table drink in the ordered set where tableNumber = &#63;.
	 *
	 * @param tableDrinkId the primary key of the current table drink
	 * @param tableNumber the table number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table drink
	 * @throws NoSuchTableDrinkException if a table drink with the primary key could not be found
	 */
	public TableDrink[] findByTableNumber_PrevAndNext(
			long tableDrinkId, int tableNumber,
			com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
				orderByComparator)
		throws NoSuchTableDrinkException;

	/**
	 * Removes all the table drinks where tableNumber = &#63; from the database.
	 *
	 * @param tableNumber the table number
	 */
	public void removeByTableNumber(int tableNumber);

	/**
	 * Returns the number of table drinks where tableNumber = &#63;.
	 *
	 * @param tableNumber the table number
	 * @return the number of matching table drinks
	 */
	public int countByTableNumber(int tableNumber);

	/**
	 * Returns all the table drinks where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching table drinks
	 */
	public java.util.List<TableDrink> findByStatus(String status);

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
	public java.util.List<TableDrink> findByStatus(
		String status, int start, int end);

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
	public java.util.List<TableDrink> findByStatus(
		String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
			orderByComparator);

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
	public java.util.List<TableDrink> findByStatus(
		String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table drink in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table drink
	 * @throws NoSuchTableDrinkException if a matching table drink could not be found
	 */
	public TableDrink findByStatus_First(
			String status,
			com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
				orderByComparator)
		throws NoSuchTableDrinkException;

	/**
	 * Returns the first table drink in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	public TableDrink fetchByStatus_First(
		String status,
		com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
			orderByComparator);

	/**
	 * Returns the last table drink in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table drink
	 * @throws NoSuchTableDrinkException if a matching table drink could not be found
	 */
	public TableDrink findByStatus_Last(
			String status,
			com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
				orderByComparator)
		throws NoSuchTableDrinkException;

	/**
	 * Returns the last table drink in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	public TableDrink fetchByStatus_Last(
		String status,
		com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
			orderByComparator);

	/**
	 * Returns the table drinks before and after the current table drink in the ordered set where status = &#63;.
	 *
	 * @param tableDrinkId the primary key of the current table drink
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table drink
	 * @throws NoSuchTableDrinkException if a table drink with the primary key could not be found
	 */
	public TableDrink[] findByStatus_PrevAndNext(
			long tableDrinkId, String status,
			com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
				orderByComparator)
		throws NoSuchTableDrinkException;

	/**
	 * Removes all the table drinks where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(String status);

	/**
	 * Returns the number of table drinks where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching table drinks
	 */
	public int countByStatus(String status);

	/**
	 * Returns all the table drinks where seats = &#63;.
	 *
	 * @param seats the seats
	 * @return the matching table drinks
	 */
	public java.util.List<TableDrink> findBySeats(int seats);

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
	public java.util.List<TableDrink> findBySeats(
		int seats, int start, int end);

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
	public java.util.List<TableDrink> findBySeats(
		int seats, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
			orderByComparator);

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
	public java.util.List<TableDrink> findBySeats(
		int seats, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first table drink in the ordered set where seats = &#63;.
	 *
	 * @param seats the seats
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table drink
	 * @throws NoSuchTableDrinkException if a matching table drink could not be found
	 */
	public TableDrink findBySeats_First(
			int seats,
			com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
				orderByComparator)
		throws NoSuchTableDrinkException;

	/**
	 * Returns the first table drink in the ordered set where seats = &#63;.
	 *
	 * @param seats the seats
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	public TableDrink fetchBySeats_First(
		int seats,
		com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
			orderByComparator);

	/**
	 * Returns the last table drink in the ordered set where seats = &#63;.
	 *
	 * @param seats the seats
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table drink
	 * @throws NoSuchTableDrinkException if a matching table drink could not be found
	 */
	public TableDrink findBySeats_Last(
			int seats,
			com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
				orderByComparator)
		throws NoSuchTableDrinkException;

	/**
	 * Returns the last table drink in the ordered set where seats = &#63;.
	 *
	 * @param seats the seats
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	public TableDrink fetchBySeats_Last(
		int seats,
		com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
			orderByComparator);

	/**
	 * Returns the table drinks before and after the current table drink in the ordered set where seats = &#63;.
	 *
	 * @param tableDrinkId the primary key of the current table drink
	 * @param seats the seats
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table drink
	 * @throws NoSuchTableDrinkException if a table drink with the primary key could not be found
	 */
	public TableDrink[] findBySeats_PrevAndNext(
			long tableDrinkId, int seats,
			com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
				orderByComparator)
		throws NoSuchTableDrinkException;

	/**
	 * Removes all the table drinks where seats = &#63; from the database.
	 *
	 * @param seats the seats
	 */
	public void removeBySeats(int seats);

	/**
	 * Returns the number of table drinks where seats = &#63;.
	 *
	 * @param seats the seats
	 * @return the number of matching table drinks
	 */
	public int countBySeats(int seats);

	/**
	 * Caches the table drink in the entity cache if it is enabled.
	 *
	 * @param tableDrink the table drink
	 */
	public void cacheResult(TableDrink tableDrink);

	/**
	 * Caches the table drinks in the entity cache if it is enabled.
	 *
	 * @param tableDrinks the table drinks
	 */
	public void cacheResult(java.util.List<TableDrink> tableDrinks);

	/**
	 * Creates a new table drink with the primary key. Does not add the table drink to the database.
	 *
	 * @param tableDrinkId the primary key for the new table drink
	 * @return the new table drink
	 */
	public TableDrink create(long tableDrinkId);

	/**
	 * Removes the table drink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tableDrinkId the primary key of the table drink
	 * @return the table drink that was removed
	 * @throws NoSuchTableDrinkException if a table drink with the primary key could not be found
	 */
	public TableDrink remove(long tableDrinkId)
		throws NoSuchTableDrinkException;

	public TableDrink updateImpl(TableDrink tableDrink);

	/**
	 * Returns the table drink with the primary key or throws a <code>NoSuchTableDrinkException</code> if it could not be found.
	 *
	 * @param tableDrinkId the primary key of the table drink
	 * @return the table drink
	 * @throws NoSuchTableDrinkException if a table drink with the primary key could not be found
	 */
	public TableDrink findByPrimaryKey(long tableDrinkId)
		throws NoSuchTableDrinkException;

	/**
	 * Returns the table drink with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tableDrinkId the primary key of the table drink
	 * @return the table drink, or <code>null</code> if a table drink with the primary key could not be found
	 */
	public TableDrink fetchByPrimaryKey(long tableDrinkId);

	/**
	 * Returns all the table drinks.
	 *
	 * @return the table drinks
	 */
	public java.util.List<TableDrink> findAll();

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
	public java.util.List<TableDrink> findAll(int start, int end);

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
	public java.util.List<TableDrink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
			orderByComparator);

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
	public java.util.List<TableDrink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TableDrink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the table drinks from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of table drinks.
	 *
	 * @return the number of table drinks
	 */
	public int countAll();

}