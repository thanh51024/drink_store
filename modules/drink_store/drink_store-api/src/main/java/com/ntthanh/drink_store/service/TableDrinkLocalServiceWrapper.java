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
 * Provides a wrapper for {@link TableDrinkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TableDrinkLocalService
 * @generated
 */
public class TableDrinkLocalServiceWrapper
	implements ServiceWrapper<TableDrinkLocalService>, TableDrinkLocalService {

	public TableDrinkLocalServiceWrapper() {
		this(null);
	}

	public TableDrinkLocalServiceWrapper(
		TableDrinkLocalService tableDrinkLocalService) {

		_tableDrinkLocalService = tableDrinkLocalService;
	}

	@Override
	public com.ntthanh.drink_store.model.TableDrink addTableDrink(
		int tableNumber, int seats, String status) {

		return _tableDrinkLocalService.addTableDrink(
			tableNumber, seats, status);
	}

	/**
	 * Adds the table drink to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TableDrinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tableDrink the table drink
	 * @return the table drink that was added
	 */
	@Override
	public com.ntthanh.drink_store.model.TableDrink addTableDrink(
		com.ntthanh.drink_store.model.TableDrink tableDrink) {

		return _tableDrinkLocalService.addTableDrink(tableDrink);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableDrinkLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new table drink with the primary key. Does not add the table drink to the database.
	 *
	 * @param tableDrinkId the primary key for the new table drink
	 * @return the new table drink
	 */
	@Override
	public com.ntthanh.drink_store.model.TableDrink createTableDrink(
		long tableDrinkId) {

		return _tableDrinkLocalService.createTableDrink(tableDrinkId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableDrinkLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the table drink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TableDrinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tableDrinkId the primary key of the table drink
	 * @return the table drink that was removed
	 * @throws PortalException if a table drink with the primary key could not be found
	 */
	@Override
	public com.ntthanh.drink_store.model.TableDrink deleteTableDrink(
			long tableDrinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableDrinkLocalService.deleteTableDrink(tableDrinkId);
	}

	/**
	 * Deletes the table drink from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TableDrinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tableDrink the table drink
	 * @return the table drink that was removed
	 */
	@Override
	public com.ntthanh.drink_store.model.TableDrink deleteTableDrink(
		com.ntthanh.drink_store.model.TableDrink tableDrink) {

		return _tableDrinkLocalService.deleteTableDrink(tableDrink);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _tableDrinkLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _tableDrinkLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tableDrinkLocalService.dynamicQuery();
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

		return _tableDrinkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ntthanh.drink_store.model.impl.TableDrinkModelImpl</code>.
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

		return _tableDrinkLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ntthanh.drink_store.model.impl.TableDrinkModelImpl</code>.
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

		return _tableDrinkLocalService.dynamicQuery(
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

		return _tableDrinkLocalService.dynamicQueryCount(dynamicQuery);
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

		return _tableDrinkLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ntthanh.drink_store.model.TableDrink fetchTableDrink(
		long tableDrinkId) {

		return _tableDrinkLocalService.fetchTableDrink(tableDrinkId);
	}

	@Override
	public com.ntthanh.drink_store.model.TableDrink
		fetchTableDrinkByTableDrinkId(long tableDrinkId) {

		return _tableDrinkLocalService.fetchTableDrinkByTableDrinkId(
			tableDrinkId);
	}

	@Override
	public com.ntthanh.drink_store.model.TableDrink fetchTableDrinkId(
		long tableNumberId) {

		return _tableDrinkLocalService.fetchTableDrinkId(tableNumberId);
	}

	@Override
	public com.ntthanh.drink_store.model.TableDrink findByTableDrinkId(
		long tableNumberId) {

		return _tableDrinkLocalService.findByTableDrinkId(tableNumberId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _tableDrinkLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _tableDrinkLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tableDrinkLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableDrinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the table drink with the primary key.
	 *
	 * @param tableDrinkId the primary key of the table drink
	 * @return the table drink
	 * @throws PortalException if a table drink with the primary key could not be found
	 */
	@Override
	public com.ntthanh.drink_store.model.TableDrink getTableDrink(
			long tableDrinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableDrinkLocalService.getTableDrink(tableDrinkId);
	}

	/**
	 * Returns a range of all the table drinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ntthanh.drink_store.model.impl.TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @return the range of table drinks
	 */
	@Override
	public java.util.List<com.ntthanh.drink_store.model.TableDrink>
		getTableDrinks(int start, int end) {

		return _tableDrinkLocalService.getTableDrinks(start, end);
	}

	/**
	 * Returns the number of table drinks.
	 *
	 * @return the number of table drinks
	 */
	@Override
	public int getTableDrinksCount() {
		return _tableDrinkLocalService.getTableDrinksCount();
	}

	@Override
	public com.ntthanh.drink_store.model.TableDrink updateTableDrink(
			long id, int tableNumber, int seats, String status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tableDrinkLocalService.updateTableDrink(
			id, tableNumber, seats, status);
	}

	/**
	 * Updates the table drink in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TableDrinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tableDrink the table drink
	 * @return the table drink that was updated
	 */
	@Override
	public com.ntthanh.drink_store.model.TableDrink updateTableDrink(
		com.ntthanh.drink_store.model.TableDrink tableDrink) {

		return _tableDrinkLocalService.updateTableDrink(tableDrink);
	}

	@Override
	public TableDrinkLocalService getWrappedService() {
		return _tableDrinkLocalService;
	}

	@Override
	public void setWrappedService(
		TableDrinkLocalService tableDrinkLocalService) {

		_tableDrinkLocalService = tableDrinkLocalService;
	}

	private TableDrinkLocalService _tableDrinkLocalService;

}