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

import com.ntthanh.drink_store.model.OrderDetail;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the order detail service. This utility wraps <code>com.ntthanh.drink_store.service.persistence.impl.OrderDetailPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrderDetailPersistence
 * @generated
 */
public class OrderDetailUtil {

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
	public static void clearCache(OrderDetail orderDetail) {
		getPersistence().clearCache(orderDetail);
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
	public static Map<Serializable, OrderDetail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OrderDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OrderDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OrderDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OrderDetail> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OrderDetail update(OrderDetail orderDetail) {
		return getPersistence().update(orderDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OrderDetail update(
		OrderDetail orderDetail, ServiceContext serviceContext) {

		return getPersistence().update(orderDetail, serviceContext);
	}

	/**
	 * Returns all the order details where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @return the matching order details
	 */
	public static List<OrderDetail> findByOrderId(long orderId) {
		return getPersistence().findByOrderId(orderId);
	}

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
	public static List<OrderDetail> findByOrderId(
		long orderId, int start, int end) {

		return getPersistence().findByOrderId(orderId, start, end);
	}

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
	public static List<OrderDetail> findByOrderId(
		long orderId, int start, int end,
		OrderByComparator<OrderDetail> orderByComparator) {

		return getPersistence().findByOrderId(
			orderId, start, end, orderByComparator);
	}

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
	public static List<OrderDetail> findByOrderId(
		long orderId, int start, int end,
		OrderByComparator<OrderDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrderId(
			orderId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first order detail in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order detail
	 * @throws NoSuchOrderDetailException if a matching order detail could not be found
	 */
	public static OrderDetail findByOrderId_First(
			long orderId, OrderByComparator<OrderDetail> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchOrderDetailException {

		return getPersistence().findByOrderId_First(orderId, orderByComparator);
	}

	/**
	 * Returns the first order detail in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order detail, or <code>null</code> if a matching order detail could not be found
	 */
	public static OrderDetail fetchByOrderId_First(
		long orderId, OrderByComparator<OrderDetail> orderByComparator) {

		return getPersistence().fetchByOrderId_First(
			orderId, orderByComparator);
	}

	/**
	 * Returns the last order detail in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order detail
	 * @throws NoSuchOrderDetailException if a matching order detail could not be found
	 */
	public static OrderDetail findByOrderId_Last(
			long orderId, OrderByComparator<OrderDetail> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchOrderDetailException {

		return getPersistence().findByOrderId_Last(orderId, orderByComparator);
	}

	/**
	 * Returns the last order detail in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order detail, or <code>null</code> if a matching order detail could not be found
	 */
	public static OrderDetail fetchByOrderId_Last(
		long orderId, OrderByComparator<OrderDetail> orderByComparator) {

		return getPersistence().fetchByOrderId_Last(orderId, orderByComparator);
	}

	/**
	 * Returns the order details before and after the current order detail in the ordered set where orderId = &#63;.
	 *
	 * @param id the primary key of the current order detail
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next order detail
	 * @throws NoSuchOrderDetailException if a order detail with the primary key could not be found
	 */
	public static OrderDetail[] findByOrderId_PrevAndNext(
			long id, long orderId,
			OrderByComparator<OrderDetail> orderByComparator)
		throws com.ntthanh.drink_store.exception.NoSuchOrderDetailException {

		return getPersistence().findByOrderId_PrevAndNext(
			id, orderId, orderByComparator);
	}

	/**
	 * Removes all the order details where orderId = &#63; from the database.
	 *
	 * @param orderId the order ID
	 */
	public static void removeByOrderId(long orderId) {
		getPersistence().removeByOrderId(orderId);
	}

	/**
	 * Returns the number of order details where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @return the number of matching order details
	 */
	public static int countByOrderId(long orderId) {
		return getPersistence().countByOrderId(orderId);
	}

	/**
	 * Caches the order detail in the entity cache if it is enabled.
	 *
	 * @param orderDetail the order detail
	 */
	public static void cacheResult(OrderDetail orderDetail) {
		getPersistence().cacheResult(orderDetail);
	}

	/**
	 * Caches the order details in the entity cache if it is enabled.
	 *
	 * @param orderDetails the order details
	 */
	public static void cacheResult(List<OrderDetail> orderDetails) {
		getPersistence().cacheResult(orderDetails);
	}

	/**
	 * Creates a new order detail with the primary key. Does not add the order detail to the database.
	 *
	 * @param id the primary key for the new order detail
	 * @return the new order detail
	 */
	public static OrderDetail create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the order detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the order detail
	 * @return the order detail that was removed
	 * @throws NoSuchOrderDetailException if a order detail with the primary key could not be found
	 */
	public static OrderDetail remove(long id)
		throws com.ntthanh.drink_store.exception.NoSuchOrderDetailException {

		return getPersistence().remove(id);
	}

	public static OrderDetail updateImpl(OrderDetail orderDetail) {
		return getPersistence().updateImpl(orderDetail);
	}

	/**
	 * Returns the order detail with the primary key or throws a <code>NoSuchOrderDetailException</code> if it could not be found.
	 *
	 * @param id the primary key of the order detail
	 * @return the order detail
	 * @throws NoSuchOrderDetailException if a order detail with the primary key could not be found
	 */
	public static OrderDetail findByPrimaryKey(long id)
		throws com.ntthanh.drink_store.exception.NoSuchOrderDetailException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the order detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the order detail
	 * @return the order detail, or <code>null</code> if a order detail with the primary key could not be found
	 */
	public static OrderDetail fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the order details.
	 *
	 * @return the order details
	 */
	public static List<OrderDetail> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<OrderDetail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<OrderDetail> findAll(
		int start, int end, OrderByComparator<OrderDetail> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<OrderDetail> findAll(
		int start, int end, OrderByComparator<OrderDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the order details from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of order details.
	 *
	 * @return the number of order details
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OrderDetailPersistence getPersistence() {
		return _persistence;
	}

	private static volatile OrderDetailPersistence _persistence;

}