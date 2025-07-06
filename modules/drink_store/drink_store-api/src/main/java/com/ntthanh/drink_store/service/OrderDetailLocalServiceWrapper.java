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

package com.ntthanh.drink_store.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OrderDetailLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OrderDetailLocalService
 * @generated
 */
public class OrderDetailLocalServiceWrapper
	implements OrderDetailLocalService,
			   ServiceWrapper<OrderDetailLocalService> {

	public OrderDetailLocalServiceWrapper() {
		this(null);
	}

	public OrderDetailLocalServiceWrapper(
		OrderDetailLocalService orderDetailLocalService) {

		_orderDetailLocalService = orderDetailLocalService;
	}

	/**
	 * Adds the order detail to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrderDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param orderDetail the order detail
	 * @return the order detail that was added
	 */
	@Override
	public com.ntthanh.drink_store.model.OrderDetail addOrderDetail(
		com.ntthanh.drink_store.model.OrderDetail orderDetail) {

		return _orderDetailLocalService.addOrderDetail(orderDetail);
	}

	/**
	 * Creates a new order detail with the primary key. Does not add the order detail to the database.
	 *
	 * @param id the primary key for the new order detail
	 * @return the new order detail
	 */
	@Override
	public com.ntthanh.drink_store.model.OrderDetail createOrderDetail(
		long id) {

		return _orderDetailLocalService.createOrderDetail(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _orderDetailLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the order detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrderDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the order detail
	 * @return the order detail that was removed
	 * @throws PortalException if a order detail with the primary key could not be found
	 */
	@Override
	public com.ntthanh.drink_store.model.OrderDetail deleteOrderDetail(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _orderDetailLocalService.deleteOrderDetail(id);
	}

	/**
	 * Deletes the order detail from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrderDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param orderDetail the order detail
	 * @return the order detail that was removed
	 */
	@Override
	public com.ntthanh.drink_store.model.OrderDetail deleteOrderDetail(
		com.ntthanh.drink_store.model.OrderDetail orderDetail) {

		return _orderDetailLocalService.deleteOrderDetail(orderDetail);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _orderDetailLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _orderDetailLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _orderDetailLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _orderDetailLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _orderDetailLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ntthanh.drink_store.model.impl.OrderDetailModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _orderDetailLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ntthanh.drink_store.model.impl.OrderDetailModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _orderDetailLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _orderDetailLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _orderDetailLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ntthanh.drink_store.model.OrderDetail fetchOrderDetail(long id) {
		return _orderDetailLocalService.fetchOrderDetail(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _orderDetailLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _orderDetailLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the order detail with the primary key.
	 *
	 * @param id the primary key of the order detail
	 * @return the order detail
	 * @throws PortalException if a order detail with the primary key could not be found
	 */
	@Override
	public com.ntthanh.drink_store.model.OrderDetail getOrderDetail(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _orderDetailLocalService.getOrderDetail(id);
	}

	/**
	 * Returns a range of all the order details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ntthanh.drink_store.model.impl.OrderDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of order details
	 * @param end the upper bound of the range of order details (not inclusive)
	 * @return the range of order details
	 */
	@Override
	public java.util.List<com.ntthanh.drink_store.model.OrderDetail>
		getOrderDetails(int start, int end) {

		return _orderDetailLocalService.getOrderDetails(start, end);
	}

	@Override
	public java.util.List<com.ntthanh.drink_store.model.OrderDetail>
		getOrderDetailsByOrderId(long orderId) {

		return _orderDetailLocalService.getOrderDetailsByOrderId(orderId);
	}

	/**
	 * Returns the number of order details.
	 *
	 * @return the number of order details
	 */
	@Override
	public int getOrderDetailsCount() {
		return _orderDetailLocalService.getOrderDetailsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _orderDetailLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _orderDetailLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the order detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrderDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param orderDetail the order detail
	 * @return the order detail that was updated
	 */
	@Override
	public com.ntthanh.drink_store.model.OrderDetail updateOrderDetail(
		com.ntthanh.drink_store.model.OrderDetail orderDetail) {

		return _orderDetailLocalService.updateOrderDetail(orderDetail);
	}

	@Override
	public OrderDetailLocalService getWrappedService() {
		return _orderDetailLocalService;
	}

	@Override
	public void setWrappedService(
		OrderDetailLocalService orderDetailLocalService) {

		_orderDetailLocalService = orderDetailLocalService;
	}

	private OrderDetailLocalService _orderDetailLocalService;

}