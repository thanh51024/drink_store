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

import com.ntthanh.drink_store.exception.NoSuchOrderDetailException;
import com.ntthanh.drink_store.model.OrderDetail;
import com.ntthanh.drink_store.model.OrderDetailTable;
import com.ntthanh.drink_store.model.impl.OrderDetailImpl;
import com.ntthanh.drink_store.model.impl.OrderDetailModelImpl;
import com.ntthanh.drink_store.service.persistence.OrderDetailPersistence;
import com.ntthanh.drink_store.service.persistence.OrderDetailUtil;
import com.ntthanh.drink_store.service.persistence.impl.constants.DRINK_STOREPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the order detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = OrderDetailPersistence.class)
public class OrderDetailPersistenceImpl
	extends BasePersistenceImpl<OrderDetail> implements OrderDetailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OrderDetailUtil</code> to access the order detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OrderDetailImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByOrderId;
	private FinderPath _finderPathWithoutPaginationFindByOrderId;
	private FinderPath _finderPathCountByOrderId;

	/**
	 * Returns all the order details where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @return the matching order details
	 */
	@Override
	public List<OrderDetail> findByOrderId(long orderId) {
		return findByOrderId(
			orderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<OrderDetail> findByOrderId(long orderId, int start, int end) {
		return findByOrderId(orderId, start, end, null);
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
	@Override
	public List<OrderDetail> findByOrderId(
		long orderId, int start, int end,
		OrderByComparator<OrderDetail> orderByComparator) {

		return findByOrderId(orderId, start, end, orderByComparator, true);
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
	@Override
	public List<OrderDetail> findByOrderId(
		long orderId, int start, int end,
		OrderByComparator<OrderDetail> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOrderId;
				finderArgs = new Object[] {orderId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOrderId;
			finderArgs = new Object[] {orderId, start, end, orderByComparator};
		}

		List<OrderDetail> list = null;

		if (useFinderCache) {
			list = (List<OrderDetail>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrderDetail orderDetail : list) {
					if (orderId != orderDetail.getOrderId()) {
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

			sb.append(_SQL_SELECT_ORDERDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_ORDERID_ORDERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrderDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(orderId);

				list = (List<OrderDetail>)QueryUtil.list(
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
	 * Returns the first order detail in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order detail
	 * @throws NoSuchOrderDetailException if a matching order detail could not be found
	 */
	@Override
	public OrderDetail findByOrderId_First(
			long orderId, OrderByComparator<OrderDetail> orderByComparator)
		throws NoSuchOrderDetailException {

		OrderDetail orderDetail = fetchByOrderId_First(
			orderId, orderByComparator);

		if (orderDetail != null) {
			return orderDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("orderId=");
		sb.append(orderId);

		sb.append("}");

		throw new NoSuchOrderDetailException(sb.toString());
	}

	/**
	 * Returns the first order detail in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order detail, or <code>null</code> if a matching order detail could not be found
	 */
	@Override
	public OrderDetail fetchByOrderId_First(
		long orderId, OrderByComparator<OrderDetail> orderByComparator) {

		List<OrderDetail> list = findByOrderId(
			orderId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last order detail in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order detail
	 * @throws NoSuchOrderDetailException if a matching order detail could not be found
	 */
	@Override
	public OrderDetail findByOrderId_Last(
			long orderId, OrderByComparator<OrderDetail> orderByComparator)
		throws NoSuchOrderDetailException {

		OrderDetail orderDetail = fetchByOrderId_Last(
			orderId, orderByComparator);

		if (orderDetail != null) {
			return orderDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("orderId=");
		sb.append(orderId);

		sb.append("}");

		throw new NoSuchOrderDetailException(sb.toString());
	}

	/**
	 * Returns the last order detail in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order detail, or <code>null</code> if a matching order detail could not be found
	 */
	@Override
	public OrderDetail fetchByOrderId_Last(
		long orderId, OrderByComparator<OrderDetail> orderByComparator) {

		int count = countByOrderId(orderId);

		if (count == 0) {
			return null;
		}

		List<OrderDetail> list = findByOrderId(
			orderId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public OrderDetail[] findByOrderId_PrevAndNext(
			long id, long orderId,
			OrderByComparator<OrderDetail> orderByComparator)
		throws NoSuchOrderDetailException {

		OrderDetail orderDetail = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			OrderDetail[] array = new OrderDetailImpl[3];

			array[0] = getByOrderId_PrevAndNext(
				session, orderDetail, orderId, orderByComparator, true);

			array[1] = orderDetail;

			array[2] = getByOrderId_PrevAndNext(
				session, orderDetail, orderId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected OrderDetail getByOrderId_PrevAndNext(
		Session session, OrderDetail orderDetail, long orderId,
		OrderByComparator<OrderDetail> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ORDERDETAIL_WHERE);

		sb.append(_FINDER_COLUMN_ORDERID_ORDERID_2);

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
			sb.append(OrderDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(orderId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(orderDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrderDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the order details where orderId = &#63; from the database.
	 *
	 * @param orderId the order ID
	 */
	@Override
	public void removeByOrderId(long orderId) {
		for (OrderDetail orderDetail :
				findByOrderId(
					orderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(orderDetail);
		}
	}

	/**
	 * Returns the number of order details where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @return the number of matching order details
	 */
	@Override
	public int countByOrderId(long orderId) {
		FinderPath finderPath = _finderPathCountByOrderId;

		Object[] finderArgs = new Object[] {orderId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORDERDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_ORDERID_ORDERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(orderId);

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

	private static final String _FINDER_COLUMN_ORDERID_ORDERID_2 =
		"orderDetail.orderId = ?";

	public OrderDetailPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("number", "number_");
		dbColumnNames.put("size", "size_");

		setDBColumnNames(dbColumnNames);

		setModelClass(OrderDetail.class);

		setModelImplClass(OrderDetailImpl.class);
		setModelPKClass(long.class);

		setTable(OrderDetailTable.INSTANCE);
	}

	/**
	 * Caches the order detail in the entity cache if it is enabled.
	 *
	 * @param orderDetail the order detail
	 */
	@Override
	public void cacheResult(OrderDetail orderDetail) {
		entityCache.putResult(
			OrderDetailImpl.class, orderDetail.getPrimaryKey(), orderDetail);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the order details in the entity cache if it is enabled.
	 *
	 * @param orderDetails the order details
	 */
	@Override
	public void cacheResult(List<OrderDetail> orderDetails) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (orderDetails.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (OrderDetail orderDetail : orderDetails) {
			if (entityCache.getResult(
					OrderDetailImpl.class, orderDetail.getPrimaryKey()) ==
						null) {

				cacheResult(orderDetail);
			}
		}
	}

	/**
	 * Clears the cache for all order details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OrderDetailImpl.class);

		finderCache.clearCache(OrderDetailImpl.class);
	}

	/**
	 * Clears the cache for the order detail.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrderDetail orderDetail) {
		entityCache.removeResult(OrderDetailImpl.class, orderDetail);
	}

	@Override
	public void clearCache(List<OrderDetail> orderDetails) {
		for (OrderDetail orderDetail : orderDetails) {
			entityCache.removeResult(OrderDetailImpl.class, orderDetail);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(OrderDetailImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(OrderDetailImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new order detail with the primary key. Does not add the order detail to the database.
	 *
	 * @param id the primary key for the new order detail
	 * @return the new order detail
	 */
	@Override
	public OrderDetail create(long id) {
		OrderDetail orderDetail = new OrderDetailImpl();

		orderDetail.setNew(true);
		orderDetail.setPrimaryKey(id);

		return orderDetail;
	}

	/**
	 * Removes the order detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the order detail
	 * @return the order detail that was removed
	 * @throws NoSuchOrderDetailException if a order detail with the primary key could not be found
	 */
	@Override
	public OrderDetail remove(long id) throws NoSuchOrderDetailException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the order detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the order detail
	 * @return the order detail that was removed
	 * @throws NoSuchOrderDetailException if a order detail with the primary key could not be found
	 */
	@Override
	public OrderDetail remove(Serializable primaryKey)
		throws NoSuchOrderDetailException {

		Session session = null;

		try {
			session = openSession();

			OrderDetail orderDetail = (OrderDetail)session.get(
				OrderDetailImpl.class, primaryKey);

			if (orderDetail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrderDetailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(orderDetail);
		}
		catch (NoSuchOrderDetailException noSuchEntityException) {
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
	protected OrderDetail removeImpl(OrderDetail orderDetail) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(orderDetail)) {
				orderDetail = (OrderDetail)session.get(
					OrderDetailImpl.class, orderDetail.getPrimaryKeyObj());
			}

			if (orderDetail != null) {
				session.delete(orderDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (orderDetail != null) {
			clearCache(orderDetail);
		}

		return orderDetail;
	}

	@Override
	public OrderDetail updateImpl(OrderDetail orderDetail) {
		boolean isNew = orderDetail.isNew();

		if (!(orderDetail instanceof OrderDetailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(orderDetail.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(orderDetail);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in orderDetail proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom OrderDetail implementation " +
					orderDetail.getClass());
		}

		OrderDetailModelImpl orderDetailModelImpl =
			(OrderDetailModelImpl)orderDetail;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(orderDetail);
			}
			else {
				orderDetail = (OrderDetail)session.merge(orderDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			OrderDetailImpl.class, orderDetailModelImpl, false, true);

		if (isNew) {
			orderDetail.setNew(false);
		}

		orderDetail.resetOriginalValues();

		return orderDetail;
	}

	/**
	 * Returns the order detail with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the order detail
	 * @return the order detail
	 * @throws NoSuchOrderDetailException if a order detail with the primary key could not be found
	 */
	@Override
	public OrderDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrderDetailException {

		OrderDetail orderDetail = fetchByPrimaryKey(primaryKey);

		if (orderDetail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrderDetailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return orderDetail;
	}

	/**
	 * Returns the order detail with the primary key or throws a <code>NoSuchOrderDetailException</code> if it could not be found.
	 *
	 * @param id the primary key of the order detail
	 * @return the order detail
	 * @throws NoSuchOrderDetailException if a order detail with the primary key could not be found
	 */
	@Override
	public OrderDetail findByPrimaryKey(long id)
		throws NoSuchOrderDetailException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the order detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the order detail
	 * @return the order detail, or <code>null</code> if a order detail with the primary key could not be found
	 */
	@Override
	public OrderDetail fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the order details.
	 *
	 * @return the order details
	 */
	@Override
	public List<OrderDetail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<OrderDetail> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<OrderDetail> findAll(
		int start, int end, OrderByComparator<OrderDetail> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<OrderDetail> findAll(
		int start, int end, OrderByComparator<OrderDetail> orderByComparator,
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

		List<OrderDetail> list = null;

		if (useFinderCache) {
			list = (List<OrderDetail>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ORDERDETAIL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ORDERDETAIL;

				sql = sql.concat(OrderDetailModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<OrderDetail>)QueryUtil.list(
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
	 * Removes all the order details from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OrderDetail orderDetail : findAll()) {
			remove(orderDetail);
		}
	}

	/**
	 * Returns the number of order details.
	 *
	 * @return the number of order details
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ORDERDETAIL);

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
		return _SQL_SELECT_ORDERDETAIL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OrderDetailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the order detail persistence.
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

		_finderPathWithPaginationFindByOrderId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrderId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"orderId"}, true);

		_finderPathWithoutPaginationFindByOrderId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrderId",
			new String[] {Long.class.getName()}, new String[] {"orderId"},
			true);

		_finderPathCountByOrderId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrderId",
			new String[] {Long.class.getName()}, new String[] {"orderId"},
			false);

		_setOrderDetailUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setOrderDetailUtilPersistence(null);

		entityCache.removeCache(OrderDetailImpl.class.getName());
	}

	private void _setOrderDetailUtilPersistence(
		OrderDetailPersistence orderDetailPersistence) {

		try {
			Field field = OrderDetailUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, orderDetailPersistence);
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

	private static final String _SQL_SELECT_ORDERDETAIL =
		"SELECT orderDetail FROM OrderDetail orderDetail";

	private static final String _SQL_SELECT_ORDERDETAIL_WHERE =
		"SELECT orderDetail FROM OrderDetail orderDetail WHERE ";

	private static final String _SQL_COUNT_ORDERDETAIL =
		"SELECT COUNT(orderDetail) FROM OrderDetail orderDetail";

	private static final String _SQL_COUNT_ORDERDETAIL_WHERE =
		"SELECT COUNT(orderDetail) FROM OrderDetail orderDetail WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "orderDetail.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No OrderDetail exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No OrderDetail exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		OrderDetailPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "number", "size"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}