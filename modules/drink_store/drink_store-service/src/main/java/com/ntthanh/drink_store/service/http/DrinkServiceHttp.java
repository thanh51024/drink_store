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

import com.ntthanh.drink_store.service.DrinkServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>DrinkServiceUtil</code> service
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
public class DrinkServiceHttp {

	public static com.ntthanh.drink_store.model.Drink addDrink(
		HttpPrincipal httpPrincipal, String drinkName, String category,
		double price, String imageUrl) {

		try {
			MethodKey methodKey = new MethodKey(
				DrinkServiceUtil.class, "addDrink", _addDrinkParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, drinkName, category, price, imageUrl);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ntthanh.drink_store.model.Drink)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.ntthanh.drink_store.model.Drink> getDinks(
		HttpPrincipal httpPrincipal, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				DrinkServiceUtil.class, "getDinks", _getDinksParameterTypes1);

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

			return (java.util.List<com.ntthanh.drink_store.model.Drink>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static Long getDinkCount(HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(
				DrinkServiceUtil.class, "getDinkCount",
				_getDinkCountParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (Long)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void updateDrink(
		HttpPrincipal httpPrincipal, long drinkId, String drinkName,
		String category, long price, String imageUrl) {

		try {
			MethodKey methodKey = new MethodKey(
				DrinkServiceUtil.class, "updateDrink",
				_updateDrinkParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, drinkId, drinkName, category, price, imageUrl);

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

	public static java.util.List<com.ntthanh.drink_store.model.Drink>
		findByCategory(HttpPrincipal httpPrincipal, String category) {

		try {
			MethodKey methodKey = new MethodKey(
				DrinkServiceUtil.class, "findByCategory",
				_findByCategoryParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, category);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.ntthanh.drink_store.model.Drink>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ntthanh.drink_store.model.Drink fetchDrink(
		HttpPrincipal httpPrincipal, long drinkId) {

		try {
			MethodKey methodKey = new MethodKey(
				DrinkServiceUtil.class, "fetchDrink",
				_fetchDrinkParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, drinkId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ntthanh.drink_store.model.Drink)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(DrinkServiceHttp.class);

	private static final Class<?>[] _addDrinkParameterTypes0 = new Class[] {
		String.class, String.class, double.class, String.class
	};
	private static final Class<?>[] _getDinksParameterTypes1 = new Class[] {
		int.class, int.class
	};
	private static final Class<?>[] _getDinkCountParameterTypes2 =
		new Class[] {};
	private static final Class<?>[] _updateDrinkParameterTypes3 = new Class[] {
		long.class, String.class, String.class, long.class, String.class
	};
	private static final Class<?>[] _findByCategoryParameterTypes4 =
		new Class[] {String.class};
	private static final Class<?>[] _fetchDrinkParameterTypes5 = new Class[] {
		long.class
	};

}