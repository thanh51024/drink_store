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

import com.ntthanh.drink_store.model.Drink;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the drink service. This utility wraps <code>com.ntthanh.drink_store.service.persistence.impl.DrinkPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DrinkPersistence
 * @generated
 */
public class DrinkUtil {

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
	public static void clearCache(Drink drink) {
		getPersistence().clearCache(drink);
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
	public static Map<Serializable, Drink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Drink> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Drink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Drink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Drink> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Drink update(Drink drink) {
		return getPersistence().update(drink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Drink update(Drink drink, ServiceContext serviceContext) {
		return getPersistence().update(drink, serviceContext);
	}

	/**
	 * Returns all the drinks where drinkName = &#63; and category = &#63;.
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 * @return the matching drinks
	 */
	public static List<Drink> findByDrinkName(
		String drinkName, String category) {

		return getPersistence().findByDrinkName(drinkName, category);
	}

	/**
	 * Returns a range of all the drinks where drinkName = &#63; and category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @return the range of matching drinks
	 */
	public static List<Drink> findByDrinkName(
		String drinkName, String category, int start, int end) {

		return getPersistence().findByDrinkName(
			drinkName, category, start, end);
	}

	/**
	 * Returns an ordered range of all the drinks where drinkName = &#63; and category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching drinks
	 */
	public static List<Drink> findByDrinkName(
		String drinkName, String category, int start, int end,
		OrderByComparator<Drink> orderByComparator) {

		return getPersistence().findByDrinkName(
			drinkName, category, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the drinks where drinkName = &#63; and category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching drinks
	 */
	public static List<Drink> findByDrinkName(
		String drinkName, String category, int start, int end,
		OrderByComparator<Drink> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDrinkName(
			drinkName, category, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first drink in the ordered set where drinkName = &#63; and category = &#63;.
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drink
	 * @throws NoSuchDrinkException if a matching drink could not be found
	 */
	public static Drink findByDrinkName_First(
			String drinkName, String category,
			OrderByComparator<Drink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchDrinkException {

		return getPersistence().findByDrinkName_First(
			drinkName, category, orderByComparator);
	}

	/**
	 * Returns the first drink in the ordered set where drinkName = &#63; and category = &#63;.
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drink, or <code>null</code> if a matching drink could not be found
	 */
	public static Drink fetchByDrinkName_First(
		String drinkName, String category,
		OrderByComparator<Drink> orderByComparator) {

		return getPersistence().fetchByDrinkName_First(
			drinkName, category, orderByComparator);
	}

	/**
	 * Returns the last drink in the ordered set where drinkName = &#63; and category = &#63;.
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drink
	 * @throws NoSuchDrinkException if a matching drink could not be found
	 */
	public static Drink findByDrinkName_Last(
			String drinkName, String category,
			OrderByComparator<Drink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchDrinkException {

		return getPersistence().findByDrinkName_Last(
			drinkName, category, orderByComparator);
	}

	/**
	 * Returns the last drink in the ordered set where drinkName = &#63; and category = &#63;.
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drink, or <code>null</code> if a matching drink could not be found
	 */
	public static Drink fetchByDrinkName_Last(
		String drinkName, String category,
		OrderByComparator<Drink> orderByComparator) {

		return getPersistence().fetchByDrinkName_Last(
			drinkName, category, orderByComparator);
	}

	/**
	 * Returns the drinks before and after the current drink in the ordered set where drinkName = &#63; and category = &#63;.
	 *
	 * @param id the primary key of the current drink
	 * @param drinkName the drink name
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next drink
	 * @throws NoSuchDrinkException if a drink with the primary key could not be found
	 */
	public static Drink[] findByDrinkName_PrevAndNext(
			long id, String drinkName, String category,
			OrderByComparator<Drink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchDrinkException {

		return getPersistence().findByDrinkName_PrevAndNext(
			id, drinkName, category, orderByComparator);
	}

	/**
	 * Removes all the drinks where drinkName = &#63; and category = &#63; from the database.
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 */
	public static void removeByDrinkName(String drinkName, String category) {
		getPersistence().removeByDrinkName(drinkName, category);
	}

	/**
	 * Returns the number of drinks where drinkName = &#63; and category = &#63;.
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 * @return the number of matching drinks
	 */
	public static int countByDrinkName(String drinkName, String category) {
		return getPersistence().countByDrinkName(drinkName, category);
	}

	/**
	 * Returns all the drinks where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching drinks
	 */
	public static List<Drink> findByCategory(String category) {
		return getPersistence().findByCategory(category);
	}

	/**
	 * Returns a range of all the drinks where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @return the range of matching drinks
	 */
	public static List<Drink> findByCategory(
		String category, int start, int end) {

		return getPersistence().findByCategory(category, start, end);
	}

	/**
	 * Returns an ordered range of all the drinks where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching drinks
	 */
	public static List<Drink> findByCategory(
		String category, int start, int end,
		OrderByComparator<Drink> orderByComparator) {

		return getPersistence().findByCategory(
			category, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the drinks where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching drinks
	 */
	public static List<Drink> findByCategory(
		String category, int start, int end,
		OrderByComparator<Drink> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCategory(
			category, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first drink in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drink
	 * @throws NoSuchDrinkException if a matching drink could not be found
	 */
	public static Drink findByCategory_First(
			String category, OrderByComparator<Drink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchDrinkException {

		return getPersistence().findByCategory_First(
			category, orderByComparator);
	}

	/**
	 * Returns the first drink in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drink, or <code>null</code> if a matching drink could not be found
	 */
	public static Drink fetchByCategory_First(
		String category, OrderByComparator<Drink> orderByComparator) {

		return getPersistence().fetchByCategory_First(
			category, orderByComparator);
	}

	/**
	 * Returns the last drink in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drink
	 * @throws NoSuchDrinkException if a matching drink could not be found
	 */
	public static Drink findByCategory_Last(
			String category, OrderByComparator<Drink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchDrinkException {

		return getPersistence().findByCategory_Last(
			category, orderByComparator);
	}

	/**
	 * Returns the last drink in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drink, or <code>null</code> if a matching drink could not be found
	 */
	public static Drink fetchByCategory_Last(
		String category, OrderByComparator<Drink> orderByComparator) {

		return getPersistence().fetchByCategory_Last(
			category, orderByComparator);
	}

	/**
	 * Returns the drinks before and after the current drink in the ordered set where category = &#63;.
	 *
	 * @param id the primary key of the current drink
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next drink
	 * @throws NoSuchDrinkException if a drink with the primary key could not be found
	 */
	public static Drink[] findByCategory_PrevAndNext(
			long id, String category,
			OrderByComparator<Drink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchDrinkException {

		return getPersistence().findByCategory_PrevAndNext(
			id, category, orderByComparator);
	}

	/**
	 * Removes all the drinks where category = &#63; from the database.
	 *
	 * @param category the category
	 */
	public static void removeByCategory(String category) {
		getPersistence().removeByCategory(category);
	}

	/**
	 * Returns the number of drinks where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching drinks
	 */
	public static int countByCategory(String category) {
		return getPersistence().countByCategory(category);
	}

	/**
	 * Returns all the drinks where price = &#63;.
	 *
	 * @param price the price
	 * @return the matching drinks
	 */
	public static List<Drink> findByPrice(double price) {
		return getPersistence().findByPrice(price);
	}

	/**
	 * Returns a range of all the drinks where price = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param price the price
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @return the range of matching drinks
	 */
	public static List<Drink> findByPrice(double price, int start, int end) {
		return getPersistence().findByPrice(price, start, end);
	}

	/**
	 * Returns an ordered range of all the drinks where price = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param price the price
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching drinks
	 */
	public static List<Drink> findByPrice(
		double price, int start, int end,
		OrderByComparator<Drink> orderByComparator) {

		return getPersistence().findByPrice(
			price, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the drinks where price = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param price the price
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching drinks
	 */
	public static List<Drink> findByPrice(
		double price, int start, int end,
		OrderByComparator<Drink> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByPrice(
			price, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first drink in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drink
	 * @throws NoSuchDrinkException if a matching drink could not be found
	 */
	public static Drink findByPrice_First(
			double price, OrderByComparator<Drink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchDrinkException {

		return getPersistence().findByPrice_First(price, orderByComparator);
	}

	/**
	 * Returns the first drink in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drink, or <code>null</code> if a matching drink could not be found
	 */
	public static Drink fetchByPrice_First(
		double price, OrderByComparator<Drink> orderByComparator) {

		return getPersistence().fetchByPrice_First(price, orderByComparator);
	}

	/**
	 * Returns the last drink in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drink
	 * @throws NoSuchDrinkException if a matching drink could not be found
	 */
	public static Drink findByPrice_Last(
			double price, OrderByComparator<Drink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchDrinkException {

		return getPersistence().findByPrice_Last(price, orderByComparator);
	}

	/**
	 * Returns the last drink in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drink, or <code>null</code> if a matching drink could not be found
	 */
	public static Drink fetchByPrice_Last(
		double price, OrderByComparator<Drink> orderByComparator) {

		return getPersistence().fetchByPrice_Last(price, orderByComparator);
	}

	/**
	 * Returns the drinks before and after the current drink in the ordered set where price = &#63;.
	 *
	 * @param id the primary key of the current drink
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next drink
	 * @throws NoSuchDrinkException if a drink with the primary key could not be found
	 */
	public static Drink[] findByPrice_PrevAndNext(
			long id, double price, OrderByComparator<Drink> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchDrinkException {

		return getPersistence().findByPrice_PrevAndNext(
			id, price, orderByComparator);
	}

	/**
	 * Removes all the drinks where price = &#63; from the database.
	 *
	 * @param price the price
	 */
	public static void removeByPrice(double price) {
		getPersistence().removeByPrice(price);
	}

	/**
	 * Returns the number of drinks where price = &#63;.
	 *
	 * @param price the price
	 * @return the number of matching drinks
	 */
	public static int countByPrice(double price) {
		return getPersistence().countByPrice(price);
	}

	/**
	 * Caches the drink in the entity cache if it is enabled.
	 *
	 * @param drink the drink
	 */
	public static void cacheResult(Drink drink) {
		getPersistence().cacheResult(drink);
	}

	/**
	 * Caches the drinks in the entity cache if it is enabled.
	 *
	 * @param drinks the drinks
	 */
	public static void cacheResult(List<Drink> drinks) {
		getPersistence().cacheResult(drinks);
	}

	/**
	 * Creates a new drink with the primary key. Does not add the drink to the database.
	 *
	 * @param id the primary key for the new drink
	 * @return the new drink
	 */
	public static Drink create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the drink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the drink
	 * @return the drink that was removed
	 * @throws NoSuchDrinkException if a drink with the primary key could not be found
	 */
	public static Drink remove(long id)
		throws com.ntthanh.drink_store.exception.NoSuchDrinkException {

		return getPersistence().remove(id);
	}

	public static Drink updateImpl(Drink drink) {
		return getPersistence().updateImpl(drink);
	}

	/**
	 * Returns the drink with the primary key or throws a <code>NoSuchDrinkException</code> if it could not be found.
	 *
	 * @param id the primary key of the drink
	 * @return the drink
	 * @throws NoSuchDrinkException if a drink with the primary key could not be found
	 */
	public static Drink findByPrimaryKey(long id)
		throws com.ntthanh.drink_store.exception.NoSuchDrinkException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the drink with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the drink
	 * @return the drink, or <code>null</code> if a drink with the primary key could not be found
	 */
	public static Drink fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the drinks.
	 *
	 * @return the drinks
	 */
	public static List<Drink> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the drinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @return the range of drinks
	 */
	public static List<Drink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the drinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of drinks
	 */
	public static List<Drink> findAll(
		int start, int end, OrderByComparator<Drink> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the drinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of drinks
	 */
	public static List<Drink> findAll(
		int start, int end, OrderByComparator<Drink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the drinks from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of drinks.
	 *
	 * @return the number of drinks
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DrinkPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DrinkPersistence _persistence;

}