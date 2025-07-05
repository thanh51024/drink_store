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

import com.ntthanh.drink_store.exception.NoSuchDrinkException;
import com.ntthanh.drink_store.model.Drink;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the drink service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DrinkUtil
 * @generated
 */
@ProviderType
public interface DrinkPersistence extends BasePersistence<Drink> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DrinkUtil} to access the drink persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the drinks where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching drinks
	 */
	public java.util.List<Drink> findByCategory(String category);

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
	public java.util.List<Drink> findByCategory(
		String category, int start, int end);

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
	public java.util.List<Drink> findByCategory(
		String category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Drink>
			orderByComparator);

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
	public java.util.List<Drink> findByCategory(
		String category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Drink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first drink in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drink
	 * @throws NoSuchDrinkException if a matching drink could not be found
	 */
	public Drink findByCategory_First(
			String category,
			com.liferay.portal.kernel.util.OrderByComparator<Drink>
				orderByComparator)
		throws NoSuchDrinkException;

	/**
	 * Returns the first drink in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drink, or <code>null</code> if a matching drink could not be found
	 */
	public Drink fetchByCategory_First(
		String category,
		com.liferay.portal.kernel.util.OrderByComparator<Drink>
			orderByComparator);

	/**
	 * Returns the last drink in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drink
	 * @throws NoSuchDrinkException if a matching drink could not be found
	 */
	public Drink findByCategory_Last(
			String category,
			com.liferay.portal.kernel.util.OrderByComparator<Drink>
				orderByComparator)
		throws NoSuchDrinkException;

	/**
	 * Returns the last drink in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drink, or <code>null</code> if a matching drink could not be found
	 */
	public Drink fetchByCategory_Last(
		String category,
		com.liferay.portal.kernel.util.OrderByComparator<Drink>
			orderByComparator);

	/**
	 * Returns the drinks before and after the current drink in the ordered set where category = &#63;.
	 *
	 * @param id the primary key of the current drink
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next drink
	 * @throws NoSuchDrinkException if a drink with the primary key could not be found
	 */
	public Drink[] findByCategory_PrevAndNext(
			long id, String category,
			com.liferay.portal.kernel.util.OrderByComparator<Drink>
				orderByComparator)
		throws NoSuchDrinkException;

	/**
	 * Removes all the drinks where category = &#63; from the database.
	 *
	 * @param category the category
	 */
	public void removeByCategory(String category);

	/**
	 * Returns the number of drinks where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching drinks
	 */
	public int countByCategory(String category);

	/**
	 * Returns all the drinks where price = &#63;.
	 *
	 * @param price the price
	 * @return the matching drinks
	 */
	public java.util.List<Drink> findByPrice(double price);

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
	public java.util.List<Drink> findByPrice(double price, int start, int end);

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
	public java.util.List<Drink> findByPrice(
		double price, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Drink>
			orderByComparator);

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
	public java.util.List<Drink> findByPrice(
		double price, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Drink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first drink in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drink
	 * @throws NoSuchDrinkException if a matching drink could not be found
	 */
	public Drink findByPrice_First(
			double price,
			com.liferay.portal.kernel.util.OrderByComparator<Drink>
				orderByComparator)
		throws NoSuchDrinkException;

	/**
	 * Returns the first drink in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drink, or <code>null</code> if a matching drink could not be found
	 */
	public Drink fetchByPrice_First(
		double price,
		com.liferay.portal.kernel.util.OrderByComparator<Drink>
			orderByComparator);

	/**
	 * Returns the last drink in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drink
	 * @throws NoSuchDrinkException if a matching drink could not be found
	 */
	public Drink findByPrice_Last(
			double price,
			com.liferay.portal.kernel.util.OrderByComparator<Drink>
				orderByComparator)
		throws NoSuchDrinkException;

	/**
	 * Returns the last drink in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drink, or <code>null</code> if a matching drink could not be found
	 */
	public Drink fetchByPrice_Last(
		double price,
		com.liferay.portal.kernel.util.OrderByComparator<Drink>
			orderByComparator);

	/**
	 * Returns the drinks before and after the current drink in the ordered set where price = &#63;.
	 *
	 * @param id the primary key of the current drink
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next drink
	 * @throws NoSuchDrinkException if a drink with the primary key could not be found
	 */
	public Drink[] findByPrice_PrevAndNext(
			long id, double price,
			com.liferay.portal.kernel.util.OrderByComparator<Drink>
				orderByComparator)
		throws NoSuchDrinkException;

	/**
	 * Removes all the drinks where price = &#63; from the database.
	 *
	 * @param price the price
	 */
	public void removeByPrice(double price);

	/**
	 * Returns the number of drinks where price = &#63;.
	 *
	 * @param price the price
	 * @return the number of matching drinks
	 */
	public int countByPrice(double price);

	/**
	 * Caches the drink in the entity cache if it is enabled.
	 *
	 * @param drink the drink
	 */
	public void cacheResult(Drink drink);

	/**
	 * Caches the drinks in the entity cache if it is enabled.
	 *
	 * @param drinks the drinks
	 */
	public void cacheResult(java.util.List<Drink> drinks);

	/**
	 * Creates a new drink with the primary key. Does not add the drink to the database.
	 *
	 * @param id the primary key for the new drink
	 * @return the new drink
	 */
	public Drink create(long id);

	/**
	 * Removes the drink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the drink
	 * @return the drink that was removed
	 * @throws NoSuchDrinkException if a drink with the primary key could not be found
	 */
	public Drink remove(long id) throws NoSuchDrinkException;

	public Drink updateImpl(Drink drink);

	/**
	 * Returns the drink with the primary key or throws a <code>NoSuchDrinkException</code> if it could not be found.
	 *
	 * @param id the primary key of the drink
	 * @return the drink
	 * @throws NoSuchDrinkException if a drink with the primary key could not be found
	 */
	public Drink findByPrimaryKey(long id) throws NoSuchDrinkException;

	/**
	 * Returns the drink with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the drink
	 * @return the drink, or <code>null</code> if a drink with the primary key could not be found
	 */
	public Drink fetchByPrimaryKey(long id);

	/**
	 * Returns all the drinks.
	 *
	 * @return the drinks
	 */
	public java.util.List<Drink> findAll();

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
	public java.util.List<Drink> findAll(int start, int end);

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
	public java.util.List<Drink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Drink>
			orderByComparator);

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
	public java.util.List<Drink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Drink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the drinks from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of drinks.
	 *
	 * @return the number of drinks
	 */
	public int countAll();

}