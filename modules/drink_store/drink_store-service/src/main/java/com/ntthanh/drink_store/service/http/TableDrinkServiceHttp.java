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

package com.ntthanh.drink_store.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.ntthanh.drink_store.service.TableDrinkServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>TableDrinkServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TableDrinkServiceHttp {

	public static com.ntthanh.drink_store.model.TableDrink addTableDrink(
		HttpPrincipal httpPrincipal, int tableNumber, int seats,
		String status) {

		try {
			MethodKey methodKey = new MethodKey(
				TableDrinkServiceUtil.class, "addTableDrink",
				_addTableDrinkParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, tableNumber, seats, status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ntthanh.drink_store.model.TableDrink)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.ntthanh.drink_store.model.TableDrink>
		getTableDrinks(HttpPrincipal httpPrincipal, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				TableDrinkServiceUtil.class, "getTableDrinks",
				_getTableDrinksParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.ntthanh.drink_store.model.TableDrink>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getTableDrinkCount(HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(
				TableDrinkServiceUtil.class, "getTableDrinkCount",
				_getTableDrinkCountParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ntthanh.drink_store.model.TableDrink
		fetchTableDrinkByTableDrinkId(
			HttpPrincipal httpPrincipal, long tableNumberId) {

		try {
			MethodKey methodKey = new MethodKey(
				TableDrinkServiceUtil.class, "fetchTableDrinkByTableDrinkId",
				_fetchTableDrinkByTableDrinkIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, tableNumberId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ntthanh.drink_store.model.TableDrink)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void updateTableDrink(
		HttpPrincipal httpPrincipal, long tableNumberId, int tableNumber,
		int seats, String status) {

		try {
			MethodKey methodKey = new MethodKey(
				TableDrinkServiceUtil.class, "updateTableDrink",
				_updateTableDrinkParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, tableNumberId, tableNumber, seats, status);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getTableDinkCount(HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(
				TableDrinkServiceUtil.class, "getTableDinkCount",
				_getTableDinkCountParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ntthanh.drink_store.model.TableDrink fetchTableDrink(
		HttpPrincipal httpPrincipal, long tableDrinkId) {

		try {
			MethodKey methodKey = new MethodKey(
				TableDrinkServiceUtil.class, "fetchTableDrink",
				_fetchTableDrinkParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, tableDrinkId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ntthanh.drink_store.model.TableDrink)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		TableDrinkServiceHttp.class);

	private static final Class<?>[] _addTableDrinkParameterTypes0 =
		new Class[] {int.class, int.class, String.class};
	private static final Class<?>[] _getTableDrinksParameterTypes1 =
		new Class[] {int.class, int.class};
	private static final Class<?>[] _getTableDrinkCountParameterTypes2 =
		new Class[] {};
	private static final Class<?>[]
		_fetchTableDrinkByTableDrinkIdParameterTypes3 = new Class[] {
			long.class
		};
	private static final Class<?>[] _updateTableDrinkParameterTypes4 =
		new Class[] {long.class, int.class, int.class, String.class};
	private static final Class<?>[] _getTableDinkCountParameterTypes5 =
		new Class[] {};
	private static final Class<?>[] _fetchTableDrinkParameterTypes6 =
		new Class[] {long.class};

}