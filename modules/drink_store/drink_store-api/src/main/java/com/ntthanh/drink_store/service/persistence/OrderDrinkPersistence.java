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

import com.ntthanh.drink_store.exception.NoSuchOrderDrinkException;
import com.ntthanh.drink_store.model.OrderDrink;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the order drink service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrderDrinkUtil
 * @generated
 */
@ProviderType
public interface OrderDrinkPersistence extends BasePersistence<OrderDrink> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrderDrinkUtil} to access the order drink persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the order drinks where orderDate = &#63;.
	 *
	 * @param orderDate the order date
	 * @return the matching order drinks
	 */
	public java.util.List<OrderDrink> findByOrderDate(Date orderDate);

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
	public java.util.List<OrderDrink> findByOrderDate(
		Date orderDate, int start, int end);

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
	public java.util.List<OrderDrink> findByOrderDate(
		Date orderDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrderDrink>
			orderByComparator);

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
	public java.util.List<OrderDrink> findByOrderDate(
		Date orderDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrderDrink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first order drink in the ordered set where orderDate = &#63;.
	 *
	 * @param orderDate the order date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order drink
	 * @throws NoSuchOrderDrinkException if a matching order drink could not be found
	 */
	public OrderDrink findByOrderDate_First(
			Date orderDate,
			com.liferay.portal.kernel.util.OrderByComparator<OrderDrink>
				orderByComparator)
		throws NoSuchOrderDrinkException;

	/**
	 * Returns the first order drink in the ordered set where orderDate = &#63;.
	 *
	 * @param orderDate the order date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order drink, or <code>null</code> if a matching order drink could not be found
	 */
	public OrderDrink fetchByOrderDate_First(
		Date orderDate,
		com.liferay.portal.kernel.util.OrderByComparator<OrderDrink>
			orderByComparator);

	/**
	 * Returns the last order drink in the ordered set where orderDate = &#63;.
	 *
	 * @param orderDate the order date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order drink
	 * @throws NoSuchOrderDrinkException if a matching order drink could not be found
	 */
	public OrderDrink findByOrderDate_Last(
			Date orderDate,
			com.liferay.portal.kernel.util.OrderByComparator<OrderDrink>
				orderByComparator)
		throws NoSuchOrderDrinkException;

	/**
	 * Returns the last order drink in the ordered set where orderDate = &#63;.
	 *
	 * @param orderDate the order date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order drink, or <code>null</code> if a matching order drink could not be found
	 */
	public OrderDrink fetchByOrderDate_Last(
		Date orderDate,
		com.liferay.portal.kernel.util.OrderByComparator<OrderDrink>
			orderByComparator);

	/**
	 * Returns the order drinks before and after the current order drink in the ordered set where orderDate = &#63;.
	 *
	 * @param id the primary key of the current order drink
	 * @param orderDate the order date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next order drink
	 * @throws NoSuchOrderDrinkException if a order drink with the primary key could not be found
	 */
	public OrderDrink[] findByOrderDate_PrevAndNext(
			long id, Date orderDate,
			com.liferay.portal.kernel.util.OrderByComparator<OrderDrink>
				orderByComparator)
		throws NoSuchOrderDrinkException;

	/**
	 * Removes all the order drinks where orderDate = &#63; from the database.
	 *
	 * @param orderDate the order date
	 */
	public void removeByOrderDate(Date orderDate);

	/**
	 * Returns the number of order drinks where orderDate = &#63;.
	 *
	 * @param orderDate the order date
	 * @return the number of matching order drinks
	 */
	public int countByOrderDate(Date orderDate);

	/**
	 * Caches the order drink in the entity cache if it is enabled.
	 *
	 * @param orderDrink the order drink
	 */
	public void cacheResult(OrderDrink orderDrink);

	/**
	 * Caches the order drinks in the entity cache if it is enabled.
	 *
	 * @param orderDrinks the order drinks
	 */
	public void cacheResult(java.util.List<OrderDrink> orderDrinks);

	/**
	 * Creates a new order drink with the primary key. Does not add the order drink to the database.
	 *
	 * @param id the primary key for the new order drink
	 * @return the new order drink
	 */
	public OrderDrink create(long id);

	/**
	 * Removes the order drink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the order drink
	 * @return the order drink that was removed
	 * @throws NoSuchOrderDrinkException if a order drink with the primary key could not be found
	 */
	public OrderDrink remove(long id) throws NoSuchOrderDrinkException;

	public OrderDrink updateImpl(OrderDrink orderDrink);

	/**
	 * Returns the order drink with the primary key or throws a <code>NoSuchOrderDrinkException</code> if it could not be found.
	 *
	 * @param id the primary key of the order drink
	 * @return the order drink
	 * @throws NoSuchOrderDrinkException if a order drink with the primary key could not be found
	 */
	public OrderDrink findByPrimaryKey(long id)
		throws NoSuchOrderDrinkException;

	/**
	 * Returns the order drink with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the order drink
	 * @return the order drink, or <code>null</code> if a order drink with the primary key could not be found
	 */
	public OrderDrink fetchByPrimaryKey(long id);

	/**
	 * Returns all the order drinks.
	 *
	 * @return the order drinks
	 */
	public java.util.List<OrderDrink> findAll();

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
	public java.util.List<OrderDrink> findAll(int start, int end);

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
	public java.util.List<OrderDrink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrderDrink>
			orderByComparator);

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
	public java.util.List<OrderDrink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrderDrink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the order drinks from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of order drinks.
	 *
	 * @return the number of order drinks
	 */
	public int countAll();

}