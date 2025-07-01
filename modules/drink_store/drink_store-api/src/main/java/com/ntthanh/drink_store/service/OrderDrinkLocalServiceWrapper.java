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
 * Provides a wrapper for {@link OrderDrinkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OrderDrinkLocalService
 * @generated
 */
public class OrderDrinkLocalServiceWrapper
	implements OrderDrinkLocalService, ServiceWrapper<OrderDrinkLocalService> {

	public OrderDrinkLocalServiceWrapper() {
		this(null);
	}

	public OrderDrinkLocalServiceWrapper(
		OrderDrinkLocalService orderDrinkLocalService) {

		_orderDrinkLocalService = orderDrinkLocalService;
	}

	/**
	 * Adds the order drink to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrderDrinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param orderDrink the order drink
	 * @return the order drink that was added
	 */
	@Override
	public com.ntthanh.drink_store.model.OrderDrink addOrderDrink(
		com.ntthanh.drink_store.model.OrderDrink orderDrink) {

		return _orderDrinkLocalService.addOrderDrink(orderDrink);
	}

	/**
	 * Creates a new order drink with the primary key. Does not add the order drink to the database.
	 *
	 * @param id the primary key for the new order drink
	 * @return the new order drink
	 */
	@Override
	public com.ntthanh.drink_store.model.OrderDrink createOrderDrink(long id) {
		return _orderDrinkLocalService.createOrderDrink(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _orderDrinkLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the order drink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrderDrinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the order drink
	 * @return the order drink that was removed
	 * @throws PortalException if a order drink with the primary key could not be found
	 */
	@Override
	public com.ntthanh.drink_store.model.OrderDrink deleteOrderDrink(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _orderDrinkLocalService.deleteOrderDrink(id);
	}

	/**
	 * Deletes the order drink from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrderDrinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param orderDrink the order drink
	 * @return the order drink that was removed
	 */
	@Override
	public com.ntthanh.drink_store.model.OrderDrink deleteOrderDrink(
		com.ntthanh.drink_store.model.OrderDrink orderDrink) {

		return _orderDrinkLocalService.deleteOrderDrink(orderDrink);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _orderDrinkLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _orderDrinkLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _orderDrinkLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _orderDrinkLocalService.dynamicQuery();
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

		return _orderDrinkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ntthanh.drink_store.model.impl.OrderDrinkModelImpl</code>.
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

		return _orderDrinkLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ntthanh.drink_store.model.impl.OrderDrinkModelImpl</code>.
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

		return _orderDrinkLocalService.dynamicQuery(
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

		return _orderDrinkLocalService.dynamicQueryCount(dynamicQuery);
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

		return _orderDrinkLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ntthanh.drink_store.model.OrderDrink fetchOrderDrink(long id) {
		return _orderDrinkLocalService.fetchOrderDrink(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _orderDrinkLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _orderDrinkLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the order drink with the primary key.
	 *
	 * @param id the primary key of the order drink
	 * @return the order drink
	 * @throws PortalException if a order drink with the primary key could not be found
	 */
	@Override
	public com.ntthanh.drink_store.model.OrderDrink getOrderDrink(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _orderDrinkLocalService.getOrderDrink(id);
	}

	/**
	 * Returns a range of all the order drinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ntthanh.drink_store.model.impl.OrderDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of order drinks
	 * @param end the upper bound of the range of order drinks (not inclusive)
	 * @return the range of order drinks
	 */
	@Override
	public java.util.List<com.ntthanh.drink_store.model.OrderDrink>
		getOrderDrinks(int start, int end) {

		return _orderDrinkLocalService.getOrderDrinks(start, end);
	}

	/**
	 * Returns the number of order drinks.
	 *
	 * @return the number of order drinks
	 */
	@Override
	public int getOrderDrinksCount() {
		return _orderDrinkLocalService.getOrderDrinksCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _orderDrinkLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _orderDrinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the order drink in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrderDrinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param orderDrink the order drink
	 * @return the order drink that was updated
	 */
	@Override
	public com.ntthanh.drink_store.model.OrderDrink updateOrderDrink(
		com.ntthanh.drink_store.model.OrderDrink orderDrink) {

		return _orderDrinkLocalService.updateOrderDrink(orderDrink);
	}

	@Override
	public OrderDrinkLocalService getWrappedService() {
		return _orderDrinkLocalService;
	}

	@Override
	public void setWrappedService(
		OrderDrinkLocalService orderDrinkLocalService) {

		_orderDrinkLocalService = orderDrinkLocalService;
	}

	private OrderDrinkLocalService _orderDrinkLocalService;

}