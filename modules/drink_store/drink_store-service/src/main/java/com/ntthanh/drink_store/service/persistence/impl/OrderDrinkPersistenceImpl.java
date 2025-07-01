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

package com.ntthanh.drink_store.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import com.ntthanh.drink_store.exception.NoSuchOrderDrinkException;
import com.ntthanh.drink_store.model.OrderDrink;
import com.ntthanh.drink_store.model.OrderDrinkTable;
import com.ntthanh.drink_store.model.impl.OrderDrinkImpl;
import com.ntthanh.drink_store.model.impl.OrderDrinkModelImpl;
import com.ntthanh.drink_store.service.persistence.OrderDrinkPersistence;
import com.ntthanh.drink_store.service.persistence.OrderDrinkUtil;
import com.ntthanh.drink_store.service.persistence.impl.constants.DRINK_STOREPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the order drink service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = OrderDrinkPersistence.class)
public class OrderDrinkPersistenceImpl
	extends BasePersistenceImpl<OrderDrink> implements OrderDrinkPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OrderDrinkUtil</code> to access the order drink persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OrderDrinkImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByOrderDate;
	private FinderPath _finderPathWithoutPaginationFindByOrderDate;
	private FinderPath _finderPathCountByOrderDate;

	/**
	 * Returns all the order drinks where orderDate = &#63;.
	 *
	 * @param orderDate the order date
	 * @return the matching order drinks
	 */
	@Override
	public List<OrderDrink> findByOrderDate(Date orderDate) {
		return findByOrderDate(
			orderDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<OrderDrink> findByOrderDate(
		Date orderDate, int start, int end) {

		return findByOrderDate(orderDate, start, end, null);
	}

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
	@Override
	public List<OrderDrink> findByOrderDate(
		Date orderDate, int start, int end,
		OrderByComparator<OrderDrink> orderByComparator) {

		return findByOrderDate(orderDate, start, end, orderByComparator, true);
	}

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
	@Override
	public List<OrderDrink> findByOrderDate(
		Date orderDate, int start, int end,
		OrderByComparator<OrderDrink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOrderDate;
				finderArgs = new Object[] {_getTime(orderDate)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOrderDate;
			finderArgs = new Object[] {
				_getTime(orderDate), start, end, orderByComparator
			};
		}

		List<OrderDrink> list = null;

		if (useFinderCache) {
			list = (List<OrderDrink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrderDrink orderDrink : list) {
					if (!Objects.equals(orderDate, orderDrink.getOrderDate())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ORDERDRINK_WHERE);

			boolean bindOrderDate = false;

			if (orderDate == null) {
				sb.append(_FINDER_COLUMN_ORDERDATE_ORDERDATE_1);
			}
			else {
				bindOrderDate = true;

				sb.append(_FINDER_COLUMN_ORDERDATE_ORDERDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrderDrinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOrderDate) {
					queryPos.add(new Timestamp(orderDate.getTime()));
				}

				list = (List<OrderDrink>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first order drink in the ordered set where orderDate = &#63;.
	 *
	 * @param orderDate the order date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order drink
	 * @throws NoSuchOrderDrinkException if a matching order drink could not be found
	 */
	@Override
	public OrderDrink findByOrderDate_First(
			Date orderDate, OrderByComparator<OrderDrink> orderByComparator)
		throws NoSuchOrderDrinkException {

		OrderDrink orderDrink = fetchByOrderDate_First(
			orderDate, orderByComparator);

		if (orderDrink != null) {
			return orderDrink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("orderDate=");
		sb.append(orderDate);

		sb.append("}");

		throw new NoSuchOrderDrinkException(sb.toString());
	}

	/**
	 * Returns the first order drink in the ordered set where orderDate = &#63;.
	 *
	 * @param orderDate the order date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order drink, or <code>null</code> if a matching order drink could not be found
	 */
	@Override
	public OrderDrink fetchByOrderDate_First(
		Date orderDate, OrderByComparator<OrderDrink> orderByComparator) {

		List<OrderDrink> list = findByOrderDate(
			orderDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last order drink in the ordered set where orderDate = &#63;.
	 *
	 * @param orderDate the order date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order drink
	 * @throws NoSuchOrderDrinkException if a matching order drink could not be found
	 */
	@Override
	public OrderDrink findByOrderDate_Last(
			Date orderDate, OrderByComparator<OrderDrink> orderByComparator)
		throws NoSuchOrderDrinkException {

		OrderDrink orderDrink = fetchByOrderDate_Last(
			orderDate, orderByComparator);

		if (orderDrink != null) {
			return orderDrink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("orderDate=");
		sb.append(orderDate);

		sb.append("}");

		throw new NoSuchOrderDrinkException(sb.toString());
	}

	/**
	 * Returns the last order drink in the ordered set where orderDate = &#63;.
	 *
	 * @param orderDate the order date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order drink, or <code>null</code> if a matching order drink could not be found
	 */
	@Override
	public OrderDrink fetchByOrderDate_Last(
		Date orderDate, OrderByComparator<OrderDrink> orderByComparator) {

		int count = countByOrderDate(orderDate);

		if (count == 0) {
			return null;
		}

		List<OrderDrink> list = findByOrderDate(
			orderDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the order drinks before and after the current order drink in the ordered set where orderDate = &#63;.
	 *
	 * @param id the primary key of the current order drink
	 * @param orderDate the order date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next order drink
	 * @throws NoSuchOrderDrinkException if a order drink with the primary key could not be found
	 */
	@Override
	public OrderDrink[] findByOrderDate_PrevAndNext(
			long id, Date orderDate,
			OrderByComparator<OrderDrink> orderByComparator)
		throws NoSuchOrderDrinkException {

		OrderDrink orderDrink = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			OrderDrink[] array = new OrderDrinkImpl[3];

			array[0] = getByOrderDate_PrevAndNext(
				session, orderDrink, orderDate, orderByComparator, true);

			array[1] = orderDrink;

			array[2] = getByOrderDate_PrevAndNext(
				session, orderDrink, orderDate, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected OrderDrink getByOrderDate_PrevAndNext(
		Session session, OrderDrink orderDrink, Date orderDate,
		OrderByComparator<OrderDrink> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ORDERDRINK_WHERE);

		boolean bindOrderDate = false;

		if (orderDate == null) {
			sb.append(_FINDER_COLUMN_ORDERDATE_ORDERDATE_1);
		}
		else {
			bindOrderDate = true;

			sb.append(_FINDER_COLUMN_ORDERDATE_ORDERDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(OrderDrinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindOrderDate) {
			queryPos.add(new Timestamp(orderDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(orderDrink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrderDrink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the order drinks where orderDate = &#63; from the database.
	 *
	 * @param orderDate the order date
	 */
	@Override
	public void removeByOrderDate(Date orderDate) {
		for (OrderDrink orderDrink :
				findByOrderDate(
					orderDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(orderDrink);
		}
	}

	/**
	 * Returns the number of order drinks where orderDate = &#63;.
	 *
	 * @param orderDate the order date
	 * @return the number of matching order drinks
	 */
	@Override
	public int countByOrderDate(Date orderDate) {
		FinderPath finderPath = _finderPathCountByOrderDate;

		Object[] finderArgs = new Object[] {_getTime(orderDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORDERDRINK_WHERE);

			boolean bindOrderDate = false;

			if (orderDate == null) {
				sb.append(_FINDER_COLUMN_ORDERDATE_ORDERDATE_1);
			}
			else {
				bindOrderDate = true;

				sb.append(_FINDER_COLUMN_ORDERDATE_ORDERDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOrderDate) {
					queryPos.add(new Timestamp(orderDate.getTime()));
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ORDERDATE_ORDERDATE_1 =
		"orderDrink.orderDate IS NULL";

	private static final String _FINDER_COLUMN_ORDERDATE_ORDERDATE_2 =
		"orderDrink.orderDate = ?";

	public OrderDrinkPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(OrderDrink.class);

		setModelImplClass(OrderDrinkImpl.class);
		setModelPKClass(long.class);

		setTable(OrderDrinkTable.INSTANCE);
	}

	/**
	 * Caches the order drink in the entity cache if it is enabled.
	 *
	 * @param orderDrink the order drink
	 */
	@Override
	public void cacheResult(OrderDrink orderDrink) {
		entityCache.putResult(
			OrderDrinkImpl.class, orderDrink.getPrimaryKey(), orderDrink);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the order drinks in the entity cache if it is enabled.
	 *
	 * @param orderDrinks the order drinks
	 */
	@Override
	public void cacheResult(List<OrderDrink> orderDrinks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (orderDrinks.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (OrderDrink orderDrink : orderDrinks) {
			if (entityCache.getResult(
					OrderDrinkImpl.class, orderDrink.getPrimaryKey()) == null) {

				cacheResult(orderDrink);
			}
		}
	}

	/**
	 * Clears the cache for all order drinks.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OrderDrinkImpl.class);

		finderCache.clearCache(OrderDrinkImpl.class);
	}

	/**
	 * Clears the cache for the order drink.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrderDrink orderDrink) {
		entityCache.removeResult(OrderDrinkImpl.class, orderDrink);
	}

	@Override
	public void clearCache(List<OrderDrink> orderDrinks) {
		for (OrderDrink orderDrink : orderDrinks) {
			entityCache.removeResult(OrderDrinkImpl.class, orderDrink);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(OrderDrinkImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(OrderDrinkImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new order drink with the primary key. Does not add the order drink to the database.
	 *
	 * @param id the primary key for the new order drink
	 * @return the new order drink
	 */
	@Override
	public OrderDrink create(long id) {
		OrderDrink orderDrink = new OrderDrinkImpl();

		orderDrink.setNew(true);
		orderDrink.setPrimaryKey(id);

		return orderDrink;
	}

	/**
	 * Removes the order drink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the order drink
	 * @return the order drink that was removed
	 * @throws NoSuchOrderDrinkException if a order drink with the primary key could not be found
	 */
	@Override
	public OrderDrink remove(long id) throws NoSuchOrderDrinkException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the order drink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the order drink
	 * @return the order drink that was removed
	 * @throws NoSuchOrderDrinkException if a order drink with the primary key could not be found
	 */
	@Override
	public OrderDrink remove(Serializable primaryKey)
		throws NoSuchOrderDrinkException {

		Session session = null;

		try {
			session = openSession();

			OrderDrink orderDrink = (OrderDrink)session.get(
				OrderDrinkImpl.class, primaryKey);

			if (orderDrink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrderDrinkException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(orderDrink);
		}
		catch (NoSuchOrderDrinkException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected OrderDrink removeImpl(OrderDrink orderDrink) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(orderDrink)) {
				orderDrink = (OrderDrink)session.get(
					OrderDrinkImpl.class, orderDrink.getPrimaryKeyObj());
			}

			if (orderDrink != null) {
				session.delete(orderDrink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (orderDrink != null) {
			clearCache(orderDrink);
		}

		return orderDrink;
	}

	@Override
	public OrderDrink updateImpl(OrderDrink orderDrink) {
		boolean isNew = orderDrink.isNew();

		if (!(orderDrink instanceof OrderDrinkModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(orderDrink.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(orderDrink);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in orderDrink proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom OrderDrink implementation " +
					orderDrink.getClass());
		}

		OrderDrinkModelImpl orderDrinkModelImpl =
			(OrderDrinkModelImpl)orderDrink;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(orderDrink);
			}
			else {
				orderDrink = (OrderDrink)session.merge(orderDrink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			OrderDrinkImpl.class, orderDrinkModelImpl, false, true);

		if (isNew) {
			orderDrink.setNew(false);
		}

		orderDrink.resetOriginalValues();

		return orderDrink;
	}

	/**
	 * Returns the order drink with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the order drink
	 * @return the order drink
	 * @throws NoSuchOrderDrinkException if a order drink with the primary key could not be found
	 */
	@Override
	public OrderDrink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrderDrinkException {

		OrderDrink orderDrink = fetchByPrimaryKey(primaryKey);

		if (orderDrink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrderDrinkException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return orderDrink;
	}

	/**
	 * Returns the order drink with the primary key or throws a <code>NoSuchOrderDrinkException</code> if it could not be found.
	 *
	 * @param id the primary key of the order drink
	 * @return the order drink
	 * @throws NoSuchOrderDrinkException if a order drink with the primary key could not be found
	 */
	@Override
	public OrderDrink findByPrimaryKey(long id)
		throws NoSuchOrderDrinkException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the order drink with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the order drink
	 * @return the order drink, or <code>null</code> if a order drink with the primary key could not be found
	 */
	@Override
	public OrderDrink fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the order drinks.
	 *
	 * @return the order drinks
	 */
	@Override
	public List<OrderDrink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<OrderDrink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<OrderDrink> findAll(
		int start, int end, OrderByComparator<OrderDrink> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<OrderDrink> findAll(
		int start, int end, OrderByComparator<OrderDrink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<OrderDrink> list = null;

		if (useFinderCache) {
			list = (List<OrderDrink>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ORDERDRINK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ORDERDRINK;

				sql = sql.concat(OrderDrinkModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<OrderDrink>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the order drinks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OrderDrink orderDrink : findAll()) {
			remove(orderDrink);
		}
	}

	/**
	 * Returns the number of order drinks.
	 *
	 * @return the number of order drinks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ORDERDRINK);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ORDERDRINK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OrderDrinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the order drink persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByOrderDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrderDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"orderDate"}, true);

		_finderPathWithoutPaginationFindByOrderDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrderDate",
			new String[] {Date.class.getName()}, new String[] {"orderDate"},
			true);

		_finderPathCountByOrderDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrderDate",
			new String[] {Date.class.getName()}, new String[] {"orderDate"},
			false);

		_setOrderDrinkUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setOrderDrinkUtilPersistence(null);

		entityCache.removeCache(OrderDrinkImpl.class.getName());
	}

	private void _setOrderDrinkUtilPersistence(
		OrderDrinkPersistence orderDrinkPersistence) {

		try {
			Field field = OrderDrinkUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, orderDrinkPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = DRINK_STOREPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DRINK_STOREPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DRINK_STOREPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_ORDERDRINK =
		"SELECT orderDrink FROM OrderDrink orderDrink";

	private static final String _SQL_SELECT_ORDERDRINK_WHERE =
		"SELECT orderDrink FROM OrderDrink orderDrink WHERE ";

	private static final String _SQL_COUNT_ORDERDRINK =
		"SELECT COUNT(orderDrink) FROM OrderDrink orderDrink";

	private static final String _SQL_COUNT_ORDERDRINK_WHERE =
		"SELECT COUNT(orderDrink) FROM OrderDrink orderDrink WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "orderDrink.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No OrderDrink exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No OrderDrink exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		OrderDrinkPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}