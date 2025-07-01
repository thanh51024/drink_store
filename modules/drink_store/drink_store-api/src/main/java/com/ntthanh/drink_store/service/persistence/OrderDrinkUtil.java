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

import com.ntthanh.drink_store.model.OrderDrink;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the order drink service. This utility wraps <code>com.ntthanh.drink_store.service.persistence.impl.OrderDrinkPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrderDrinkPersistence
 * @generated
 */
public class OrderDrinkUtil {

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
	public static void clearCache(OrderDrink orderDrink) {
		getPersistence().clearCache(orderDrink);
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
	public static Map<Serializable, OrderDrink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OrderDrink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OrderDrink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OrderDrink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OrderDrink> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OrderDrink update(OrderDrink orderDrink) {
		return getPersistence().update(orderDrink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OrderDrink update(
		OrderDrink orderDrink, ServiceContext serviceContext) {

		return getPersistence().update(orderDrink, serviceContext);
	}

	/**
	 * Returns all the order drinks where orderDate = &#63;.
	 *
	 * @param orderDate the order date
	 * @return the matching order drinks
	 */
	public static List<OrderDrink> findByOrderDate(Date orderDate) {
		return getPersistence().findByOrderDate(orderDate);
	}

	/**
	 * Returns a range of all the order drinks where orderDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param orderDate the order date
	 * @param start the lower bound of the range of order drinks
	 * @param end the upper bound of the range of order drinks (not inclusive)
	 * @return the range of matching order drinks
	 */
	public static List<OrderDrink> findByOrderDate(
		Date orderDate, int start, int end) {

		return getPersistence().findByOrderDate(orderDate, start, end);
	}

	/**
	 * Returns an ordered range of all the order drinks where orderDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param orderDate the order date
	 * @param start the lower bound of the range of order drinks
	 * @param end the upper bound of the range of order drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching order drinks
	 */
	public static List<OrderDrink> findByOrderDate(
		Date orderDate, int start, int end,
		OrderByComparator<OrderDrink> orderByComparator) {

		return getPersistence().findByOrderDate(
			orderDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the order drinks where orderDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param orderDate the order date
	 * @param start the lower bound of the range of order drinks
	 * @param end the upper bound of the range of order drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching order drinks
	 */
	public static List<OrderDrink> findByOrderDate(
		Date orderDate, int start, int end,
		OrderByComparator<OrderDrink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrderDate(
			orderDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first order drink in the ordered set where orderDate = &#63;.
	 *
	 * @param orderDate the order date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order drink
	 * @throws NoSuchOrderDrinkException if a matching order drink could not be found
	 */
	public static OrderDrink findByOrderDate_First(
			Date orderDate, OrderByComparator<OrderDrink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchOrderDrinkException {

		return getPersistence().findByOrderDate_First(
			orderDate, orderByComparator);
	}

	/**
	 * Returns the first order drink in the ordered set where orderDate = &#63;.
	 *
	 * @param orderDate the order date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order drink, or <code>null</code> if a matching order drink could not be found
	 */
	public static OrderDrink fetchByOrderDate_First(
		Date orderDate, OrderByComparator<OrderDrink> orderByComparator) {

		return getPersistence().fetchByOrderDate_First(
			orderDate, orderByComparator);
	}

	/**
	 * Returns the last order drink in the ordered set where orderDate = &#63;.
	 *
	 * @param orderDate the order date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order drink
	 * @throws NoSuchOrderDrinkException if a matching order drink could not be found
	 */
	public static OrderDrink findByOrderDate_Last(
			Date orderDate, OrderByComparator<OrderDrink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchOrderDrinkException {

		return getPersistence().findByOrderDate_Last(
			orderDate, orderByComparator);
	}

	/**
	 * Returns the last order drink in the ordered set where orderDate = &#63;.
	 *
	 * @param orderDate the order date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order drink, or <code>null</code> if a matching order drink could not be found
	 */
	public static OrderDrink fetchByOrderDate_Last(
		Date orderDate, OrderByComparator<OrderDrink> orderByComparator) {

		return getPersistence().fetchByOrderDate_Last(
			orderDate, orderByComparator);
	}

	/**
	 * Returns the order drinks before and after the current order drink in the ordered set where orderDate = &#63;.
	 *
	 * @param id the primary key of the current order drink
	 * @param orderDate the order date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next order drink
	 * @throws NoSuchOrderDrinkException if a order drink with the primary key could not be found
	 */
	public static OrderDrink[] findByOrderDate_PrevAndNext(
			long id, Date orderDate,
			OrderByComparator<OrderDrink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchOrderDrinkException {

		return getPersistence().findByOrderDate_PrevAndNext(
			id, orderDate, orderByComparator);
	}

	/**
	 * Removes all the order drinks where orderDate = &#63; from the database.
	 *
	 * @param orderDate the order date
	 */
	public static void removeByOrderDate(Date orderDate) {
		getPersistence().removeByOrderDate(orderDate);
	}

	/**
	 * Returns the number of order drinks where orderDate = &#63;.
	 *
	 * @param orderDate the order date
	 * @return the number of matching order drinks
	 */
	public static int countByOrderDate(Date orderDate) {
		return getPersistence().countByOrderDate(orderDate);
	}

	/**
	 * Caches the order drink in the entity cache if it is enabled.
	 *
	 * @param orderDrink the order drink
	 */
	public static void cacheResult(OrderDrink orderDrink) {
		getPersistence().cacheResult(orderDrink);
	}

	/**
	 * Caches the order drinks in the entity cache if it is enabled.
	 *
	 * @param orderDrinks the order drinks
	 */
	public static void cacheResult(List<OrderDrink> orderDrinks) {
		getPersistence().cacheResult(orderDrinks);
	}

	/**
	 * Creates a new order drink with the primary key. Does not add the order drink to the database.
	 *
	 * @param id the primary key for the new order drink
	 * @return the new order drink
	 */
	public static OrderDrink create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the order drink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the order drink
	 * @return the order drink that was removed
	 * @throws NoSuchOrderDrinkException if a order drink with the primary key could not be found
	 */
	public static OrderDrink remove(long id)
		throws com.ntthanh.drink_store.exception.NoSuchOrderDrinkException {

		return getPersistence().remove(id);
	}

	public static OrderDrink updateImpl(OrderDrink orderDrink) {
		return getPersistence().updateImpl(orderDrink);
	}

	/**
	 * Returns the order drink with the primary key or throws a <code>NoSuchOrderDrinkException</code> if it could not be found.
	 *
	 * @param id the primary key of the order drink
	 * @return the order drink
	 * @throws NoSuchOrderDrinkException if a order drink with the primary key could not be found
	 */
	public static OrderDrink findByPrimaryKey(long id)
		throws com.ntthanh.drink_store.exception.NoSuchOrderDrinkException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the order drink with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the order drink
	 * @return the order drink, or <code>null</code> if a order drink with the primary key could not be found
	 */
	public static OrderDrink fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the order drinks.
	 *
	 * @return the order drinks
	 */
	public static List<OrderDrink> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the order drinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of order drinks
	 * @param end the upper bound of the range of order drinks (not inclusive)
	 * @return the range of order drinks
	 */
	public static List<OrderDrink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the order drinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of order drinks
	 * @param end the upper bound of the range of order drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of order drinks
	 */
	public static List<OrderDrink> findAll(
		int start, int end, OrderByComparator<OrderDrink> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the order drinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of order drinks
	 * @param end the upper bound of the range of order drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of order drinks
	 */
	public static List<OrderDrink> findAll(
		int start, int end, OrderByComparator<OrderDrink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the order drinks from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of order drinks.
	 *
	 * @return the number of order drinks
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OrderDrinkPersistence getPersistence() {
		return _persistence;
	}

	private static volatile OrderDrinkPersistence _persistence;

}