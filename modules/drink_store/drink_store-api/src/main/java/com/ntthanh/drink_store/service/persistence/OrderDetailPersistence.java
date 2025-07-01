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

import com.ntthanh.drink_store.exception.NoSuchOrderDetailException;
import com.ntthanh.drink_store.model.OrderDetail;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the order detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrderDetailUtil
 * @generated
 */
@ProviderType
public interface OrderDetailPersistence extends BasePersistence<OrderDetail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrderDetailUtil} to access the order detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the order details where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @return the matching order details
	 */
	public java.util.List<OrderDetail> findByOrderId(long orderId);

	/**
	 * Returns a range of all the order details where orderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderDetailModelImpl</code>.
	 * </p>
	 *
	 * @param orderId the order ID
	 * @param start the lower bound of the range of order details
	 * @param end the upper bound of the range of order details (not inclusive)
	 * @return the range of matching order details
	 */
	public java.util.List<OrderDetail> findByOrderId(
		long orderId, int start, int end);

	/**
	 * Returns an ordered range of all the order details where orderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderDetailModelImpl</code>.
	 * </p>
	 *
	 * @param orderId the order ID
	 * @param start the lower bound of the range of order details
	 * @param end the upper bound of the range of order details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching order details
	 */
	public java.util.List<OrderDetail> findByOrderId(
		long orderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrderDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the order details where orderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderDetailModelImpl</code>.
	 * </p>
	 *
	 * @param orderId the order ID
	 * @param start the lower bound of the range of order details
	 * @param end the upper bound of the range of order details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching order details
	 */
	public java.util.List<OrderDetail> findByOrderId(
		long orderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrderDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first order detail in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order detail
	 * @throws NoSuchOrderDetailException if a matching order detail could not be found
	 */
	public OrderDetail findByOrderId_First(
			long orderId,
			com.liferay.portal.kernel.util.OrderByComparator<OrderDetail>
				orderByComparator)
		throws NoSuchOrderDetailException;

	/**
	 * Returns the first order detail in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order detail, or <code>null</code> if a matching order detail could not be found
	 */
	public OrderDetail fetchByOrderId_First(
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator<OrderDetail>
			orderByComparator);

	/**
	 * Returns the last order detail in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order detail
	 * @throws NoSuchOrderDetailException if a matching order detail could not be found
	 */
	public OrderDetail findByOrderId_Last(
			long orderId,
			com.liferay.portal.kernel.util.OrderByComparator<OrderDetail>
				orderByComparator)
		throws NoSuchOrderDetailException;

	/**
	 * Returns the last order detail in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order detail, or <code>null</code> if a matching order detail could not be found
	 */
	public OrderDetail fetchByOrderId_Last(
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator<OrderDetail>
			orderByComparator);

	/**
	 * Returns the order details before and after the current order detail in the ordered set where orderId = &#63;.
	 *
	 * @param id the primary key of the current order detail
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next order detail
	 * @throws NoSuchOrderDetailException if a order detail with the primary key could not be found
	 */
	public OrderDetail[] findByOrderId_PrevAndNext(
			long id, long orderId,
			com.liferay.portal.kernel.util.OrderByComparator<OrderDetail>
				orderByComparator)
		throws NoSuchOrderDetailException;

	/**
	 * Removes all the order details where orderId = &#63; from the database.
	 *
	 * @param orderId the order ID
	 */
	public void removeByOrderId(long orderId);

	/**
	 * Returns the number of order details where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @return the number of matching order details
	 */
	public int countByOrderId(long orderId);

	/**
	 * Caches the order detail in the entity cache if it is enabled.
	 *
	 * @param orderDetail the order detail
	 */
	public void cacheResult(OrderDetail orderDetail);

	/**
	 * Caches the order details in the entity cache if it is enabled.
	 *
	 * @param orderDetails the order details
	 */
	public void cacheResult(java.util.List<OrderDetail> orderDetails);

	/**
	 * Creates a new order detail with the primary key. Does not add the order detail to the database.
	 *
	 * @param id the primary key for the new order detail
	 * @return the new order detail
	 */
	public OrderDetail create(long id);

	/**
	 * Removes the order detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the order detail
	 * @return the order detail that was removed
	 * @throws NoSuchOrderDetailException if a order detail with the primary key could not be found
	 */
	public OrderDetail remove(long id) throws NoSuchOrderDetailException;

	public OrderDetail updateImpl(OrderDetail orderDetail);

	/**
	 * Returns the order detail with the primary key or throws a <code>NoSuchOrderDetailException</code> if it could not be found.
	 *
	 * @param id the primary key of the order detail
	 * @return the order detail
	 * @throws NoSuchOrderDetailException if a order detail with the primary key could not be found
	 */
	public OrderDetail findByPrimaryKey(long id)
		throws NoSuchOrderDetailException;

	/**
	 * Returns the order detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the order detail
	 * @return the order detail, or <code>null</code> if a order detail with the primary key could not be found
	 */
	public OrderDetail fetchByPrimaryKey(long id);

	/**
	 * Returns all the order details.
	 *
	 * @return the order details
	 */
	public java.util.List<OrderDetail> findAll();

	/**
	 * Returns a range of all the order details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of order details
	 * @param end the upper bound of the range of order details (not inclusive)
	 * @return the range of order details
	 */
	public java.util.List<OrderDetail> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the order details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of order details
	 * @param end the upper bound of the range of order details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of order details
	 */
	public java.util.List<OrderDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrderDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the order details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of order details
	 * @param end the upper bound of the range of order details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of order details
	 */
	public java.util.List<OrderDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrderDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the order details from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of order details.
	 *
	 * @return the number of order details
	 */
	public int countAll();

}