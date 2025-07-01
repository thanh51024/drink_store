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

import com.ntthanh.drink_store.exception.NoSuchTableDrinkException;
import com.ntthanh.drink_store.model.TableDrink;
import com.ntthanh.drink_store.model.TableDrinkTable;
import com.ntthanh.drink_store.model.impl.TableDrinkImpl;
import com.ntthanh.drink_store.model.impl.TableDrinkModelImpl;
import com.ntthanh.drink_store.service.persistence.TableDrinkPersistence;
import com.ntthanh.drink_store.service.persistence.TableDrinkUtil;
import com.ntthanh.drink_store.service.persistence.impl.constants.DRINK_STOREPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the table drink service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TableDrinkPersistence.class)
public class TableDrinkPersistenceImpl
	extends BasePersistenceImpl<TableDrink> implements TableDrinkPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TableDrinkUtil</code> to access the table drink persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TableDrinkImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByTableNumber;
	private FinderPath _finderPathWithoutPaginationFindByTableNumber;
	private FinderPath _finderPathCountByTableNumber;

	/**
	 * Returns all the table drinks where tableNumber = &#63;.
	 *
	 * @param tableNumber the table number
	 * @return the matching table drinks
	 */
	@Override
	public List<TableDrink> findByTableNumber(int tableNumber) {
		return findByTableNumber(
			tableNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table drinks where tableNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param tableNumber the table number
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @return the range of matching table drinks
	 */
	@Override
	public List<TableDrink> findByTableNumber(
		int tableNumber, int start, int end) {

		return findByTableNumber(tableNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table drinks where tableNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param tableNumber the table number
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table drinks
	 */
	@Override
	public List<TableDrink> findByTableNumber(
		int tableNumber, int start, int end,
		OrderByComparator<TableDrink> orderByComparator) {

		return findByTableNumber(
			tableNumber, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table drinks where tableNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param tableNumber the table number
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table drinks
	 */
	@Override
	public List<TableDrink> findByTableNumber(
		int tableNumber, int start, int end,
		OrderByComparator<TableDrink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTableNumber;
				finderArgs = new Object[] {tableNumber};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTableNumber;
			finderArgs = new Object[] {
				tableNumber, start, end, orderByComparator
			};
		}

		List<TableDrink> list = null;

		if (useFinderCache) {
			list = (List<TableDrink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TableDrink tableDrink : list) {
					if (tableNumber != tableDrink.getTableNumber()) {
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

			sb.append(_SQL_SELECT_TABLEDRINK_WHERE);

			sb.append(_FINDER_COLUMN_TABLENUMBER_TABLENUMBER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableDrinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tableNumber);

				list = (List<TableDrink>)QueryUtil.list(
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
	 * Returns the first table drink in the ordered set where tableNumber = &#63;.
	 *
	 * @param tableNumber the table number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table drink
	 * @throws NoSuchTableDrinkException if a matching table drink could not be found
	 */
	@Override
	public TableDrink findByTableNumber_First(
			int tableNumber, OrderByComparator<TableDrink> orderByComparator)
		throws NoSuchTableDrinkException {

		TableDrink tableDrink = fetchByTableNumber_First(
			tableNumber, orderByComparator);

		if (tableDrink != null) {
			return tableDrink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tableNumber=");
		sb.append(tableNumber);

		sb.append("}");

		throw new NoSuchTableDrinkException(sb.toString());
	}

	/**
	 * Returns the first table drink in the ordered set where tableNumber = &#63;.
	 *
	 * @param tableNumber the table number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	@Override
	public TableDrink fetchByTableNumber_First(
		int tableNumber, OrderByComparator<TableDrink> orderByComparator) {

		List<TableDrink> list = findByTableNumber(
			tableNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table drink in the ordered set where tableNumber = &#63;.
	 *
	 * @param tableNumber the table number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table drink
	 * @throws NoSuchTableDrinkException if a matching table drink could not be found
	 */
	@Override
	public TableDrink findByTableNumber_Last(
			int tableNumber, OrderByComparator<TableDrink> orderByComparator)
		throws NoSuchTableDrinkException {

		TableDrink tableDrink = fetchByTableNumber_Last(
			tableNumber, orderByComparator);

		if (tableDrink != null) {
			return tableDrink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tableNumber=");
		sb.append(tableNumber);

		sb.append("}");

		throw new NoSuchTableDrinkException(sb.toString());
	}

	/**
	 * Returns the last table drink in the ordered set where tableNumber = &#63;.
	 *
	 * @param tableNumber the table number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	@Override
	public TableDrink fetchByTableNumber_Last(
		int tableNumber, OrderByComparator<TableDrink> orderByComparator) {

		int count = countByTableNumber(tableNumber);

		if (count == 0) {
			return null;
		}

		List<TableDrink> list = findByTableNumber(
			tableNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table drinks before and after the current table drink in the ordered set where tableNumber = &#63;.
	 *
	 * @param id the primary key of the current table drink
	 * @param tableNumber the table number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table drink
	 * @throws NoSuchTableDrinkException if a table drink with the primary key could not be found
	 */
	@Override
	public TableDrink[] findByTableNumber_PrevAndNext(
			long id, int tableNumber,
			OrderByComparator<TableDrink> orderByComparator)
		throws NoSuchTableDrinkException {

		TableDrink tableDrink = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TableDrink[] array = new TableDrinkImpl[3];

			array[0] = getByTableNumber_PrevAndNext(
				session, tableDrink, tableNumber, orderByComparator, true);

			array[1] = tableDrink;

			array[2] = getByTableNumber_PrevAndNext(
				session, tableDrink, tableNumber, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableDrink getByTableNumber_PrevAndNext(
		Session session, TableDrink tableDrink, int tableNumber,
		OrderByComparator<TableDrink> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TABLEDRINK_WHERE);

		sb.append(_FINDER_COLUMN_TABLENUMBER_TABLENUMBER_2);

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
			sb.append(TableDrinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(tableNumber);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableDrink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableDrink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the table drinks where tableNumber = &#63; from the database.
	 *
	 * @param tableNumber the table number
	 */
	@Override
	public void removeByTableNumber(int tableNumber) {
		for (TableDrink tableDrink :
				findByTableNumber(
					tableNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tableDrink);
		}
	}

	/**
	 * Returns the number of table drinks where tableNumber = &#63;.
	 *
	 * @param tableNumber the table number
	 * @return the number of matching table drinks
	 */
	@Override
	public int countByTableNumber(int tableNumber) {
		FinderPath finderPath = _finderPathCountByTableNumber;

		Object[] finderArgs = new Object[] {tableNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TABLEDRINK_WHERE);

			sb.append(_FINDER_COLUMN_TABLENUMBER_TABLENUMBER_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tableNumber);

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

	private static final String _FINDER_COLUMN_TABLENUMBER_TABLENUMBER_2 =
		"tableDrink.tableNumber = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the table drinks where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching table drinks
	 */
	@Override
	public List<TableDrink> findByStatus(String status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table drinks where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @return the range of matching table drinks
	 */
	@Override
	public List<TableDrink> findByStatus(String status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table drinks where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table drinks
	 */
	@Override
	public List<TableDrink> findByStatus(
		String status, int start, int end,
		OrderByComparator<TableDrink> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table drinks where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table drinks
	 */
	@Override
	public List<TableDrink> findByStatus(
		String status, int start, int end,
		OrderByComparator<TableDrink> orderByComparator,
		boolean useFinderCache) {

		status = Objects.toString(status, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<TableDrink> list = null;

		if (useFinderCache) {
			list = (List<TableDrink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TableDrink tableDrink : list) {
					if (!status.equals(tableDrink.getStatus())) {
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

			sb.append(_SQL_SELECT_TABLEDRINK_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableDrinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatus) {
					queryPos.add(status);
				}

				list = (List<TableDrink>)QueryUtil.list(
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
	 * Returns the first table drink in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table drink
	 * @throws NoSuchTableDrinkException if a matching table drink could not be found
	 */
	@Override
	public TableDrink findByStatus_First(
			String status, OrderByComparator<TableDrink> orderByComparator)
		throws NoSuchTableDrinkException {

		TableDrink tableDrink = fetchByStatus_First(status, orderByComparator);

		if (tableDrink != null) {
			return tableDrink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchTableDrinkException(sb.toString());
	}

	/**
	 * Returns the first table drink in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	@Override
	public TableDrink fetchByStatus_First(
		String status, OrderByComparator<TableDrink> orderByComparator) {

		List<TableDrink> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table drink in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table drink
	 * @throws NoSuchTableDrinkException if a matching table drink could not be found
	 */
	@Override
	public TableDrink findByStatus_Last(
			String status, OrderByComparator<TableDrink> orderByComparator)
		throws NoSuchTableDrinkException {

		TableDrink tableDrink = fetchByStatus_Last(status, orderByComparator);

		if (tableDrink != null) {
			return tableDrink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchTableDrinkException(sb.toString());
	}

	/**
	 * Returns the last table drink in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	@Override
	public TableDrink fetchByStatus_Last(
		String status, OrderByComparator<TableDrink> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<TableDrink> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table drinks before and after the current table drink in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current table drink
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table drink
	 * @throws NoSuchTableDrinkException if a table drink with the primary key could not be found
	 */
	@Override
	public TableDrink[] findByStatus_PrevAndNext(
			long id, String status,
			OrderByComparator<TableDrink> orderByComparator)
		throws NoSuchTableDrinkException {

		status = Objects.toString(status, "");

		TableDrink tableDrink = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TableDrink[] array = new TableDrinkImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, tableDrink, status, orderByComparator, true);

			array[1] = tableDrink;

			array[2] = getByStatus_PrevAndNext(
				session, tableDrink, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableDrink getByStatus_PrevAndNext(
		Session session, TableDrink tableDrink, String status,
		OrderByComparator<TableDrink> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TABLEDRINK_WHERE);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			sb.append(_FINDER_COLUMN_STATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);
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
			sb.append(TableDrinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindStatus) {
			queryPos.add(status);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableDrink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableDrink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the table drinks where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(String status) {
		for (TableDrink tableDrink :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tableDrink);
		}
	}

	/**
	 * Returns the number of table drinks where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching table drinks
	 */
	@Override
	public int countByStatus(String status) {
		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TABLEDRINK_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatus) {
					queryPos.add(status);
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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"tableDrink.status = ?";

	private static final String _FINDER_COLUMN_STATUS_STATUS_3 =
		"(tableDrink.status IS NULL OR tableDrink.status = '')";

	private FinderPath _finderPathWithPaginationFindBySeats;
	private FinderPath _finderPathWithoutPaginationFindBySeats;
	private FinderPath _finderPathCountBySeats;

	/**
	 * Returns all the table drinks where seats = &#63;.
	 *
	 * @param seats the seats
	 * @return the matching table drinks
	 */
	@Override
	public List<TableDrink> findBySeats(int seats) {
		return findBySeats(seats, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table drinks where seats = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param seats the seats
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @return the range of matching table drinks
	 */
	@Override
	public List<TableDrink> findBySeats(int seats, int start, int end) {
		return findBySeats(seats, start, end, null);
	}

	/**
	 * Returns an ordered range of all the table drinks where seats = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param seats the seats
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching table drinks
	 */
	@Override
	public List<TableDrink> findBySeats(
		int seats, int start, int end,
		OrderByComparator<TableDrink> orderByComparator) {

		return findBySeats(seats, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table drinks where seats = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param seats the seats
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching table drinks
	 */
	@Override
	public List<TableDrink> findBySeats(
		int seats, int start, int end,
		OrderByComparator<TableDrink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySeats;
				finderArgs = new Object[] {seats};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySeats;
			finderArgs = new Object[] {seats, start, end, orderByComparator};
		}

		List<TableDrink> list = null;

		if (useFinderCache) {
			list = (List<TableDrink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TableDrink tableDrink : list) {
					if (seats != tableDrink.getSeats()) {
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

			sb.append(_SQL_SELECT_TABLEDRINK_WHERE);

			sb.append(_FINDER_COLUMN_SEATS_SEATS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TableDrinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(seats);

				list = (List<TableDrink>)QueryUtil.list(
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
	 * Returns the first table drink in the ordered set where seats = &#63;.
	 *
	 * @param seats the seats
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table drink
	 * @throws NoSuchTableDrinkException if a matching table drink could not be found
	 */
	@Override
	public TableDrink findBySeats_First(
			int seats, OrderByComparator<TableDrink> orderByComparator)
		throws NoSuchTableDrinkException {

		TableDrink tableDrink = fetchBySeats_First(seats, orderByComparator);

		if (tableDrink != null) {
			return tableDrink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("seats=");
		sb.append(seats);

		sb.append("}");

		throw new NoSuchTableDrinkException(sb.toString());
	}

	/**
	 * Returns the first table drink in the ordered set where seats = &#63;.
	 *
	 * @param seats the seats
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	@Override
	public TableDrink fetchBySeats_First(
		int seats, OrderByComparator<TableDrink> orderByComparator) {

		List<TableDrink> list = findBySeats(seats, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last table drink in the ordered set where seats = &#63;.
	 *
	 * @param seats the seats
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table drink
	 * @throws NoSuchTableDrinkException if a matching table drink could not be found
	 */
	@Override
	public TableDrink findBySeats_Last(
			int seats, OrderByComparator<TableDrink> orderByComparator)
		throws NoSuchTableDrinkException {

		TableDrink tableDrink = fetchBySeats_Last(seats, orderByComparator);

		if (tableDrink != null) {
			return tableDrink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("seats=");
		sb.append(seats);

		sb.append("}");

		throw new NoSuchTableDrinkException(sb.toString());
	}

	/**
	 * Returns the last table drink in the ordered set where seats = &#63;.
	 *
	 * @param seats the seats
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching table drink, or <code>null</code> if a matching table drink could not be found
	 */
	@Override
	public TableDrink fetchBySeats_Last(
		int seats, OrderByComparator<TableDrink> orderByComparator) {

		int count = countBySeats(seats);

		if (count == 0) {
			return null;
		}

		List<TableDrink> list = findBySeats(
			seats, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the table drinks before and after the current table drink in the ordered set where seats = &#63;.
	 *
	 * @param id the primary key of the current table drink
	 * @param seats the seats
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next table drink
	 * @throws NoSuchTableDrinkException if a table drink with the primary key could not be found
	 */
	@Override
	public TableDrink[] findBySeats_PrevAndNext(
			long id, int seats, OrderByComparator<TableDrink> orderByComparator)
		throws NoSuchTableDrinkException {

		TableDrink tableDrink = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TableDrink[] array = new TableDrinkImpl[3];

			array[0] = getBySeats_PrevAndNext(
				session, tableDrink, seats, orderByComparator, true);

			array[1] = tableDrink;

			array[2] = getBySeats_PrevAndNext(
				session, tableDrink, seats, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TableDrink getBySeats_PrevAndNext(
		Session session, TableDrink tableDrink, int seats,
		OrderByComparator<TableDrink> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TABLEDRINK_WHERE);

		sb.append(_FINDER_COLUMN_SEATS_SEATS_2);

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
			sb.append(TableDrinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(seats);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tableDrink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TableDrink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the table drinks where seats = &#63; from the database.
	 *
	 * @param seats the seats
	 */
	@Override
	public void removeBySeats(int seats) {
		for (TableDrink tableDrink :
				findBySeats(
					seats, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tableDrink);
		}
	}

	/**
	 * Returns the number of table drinks where seats = &#63;.
	 *
	 * @param seats the seats
	 * @return the number of matching table drinks
	 */
	@Override
	public int countBySeats(int seats) {
		FinderPath finderPath = _finderPathCountBySeats;

		Object[] finderArgs = new Object[] {seats};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TABLEDRINK_WHERE);

			sb.append(_FINDER_COLUMN_SEATS_SEATS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(seats);

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

	private static final String _FINDER_COLUMN_SEATS_SEATS_2 =
		"tableDrink.seats = ?";

	public TableDrinkPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TableDrink.class);

		setModelImplClass(TableDrinkImpl.class);
		setModelPKClass(long.class);

		setTable(TableDrinkTable.INSTANCE);
	}

	/**
	 * Caches the table drink in the entity cache if it is enabled.
	 *
	 * @param tableDrink the table drink
	 */
	@Override
	public void cacheResult(TableDrink tableDrink) {
		entityCache.putResult(
			TableDrinkImpl.class, tableDrink.getPrimaryKey(), tableDrink);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the table drinks in the entity cache if it is enabled.
	 *
	 * @param tableDrinks the table drinks
	 */
	@Override
	public void cacheResult(List<TableDrink> tableDrinks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (tableDrinks.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TableDrink tableDrink : tableDrinks) {
			if (entityCache.getResult(
					TableDrinkImpl.class, tableDrink.getPrimaryKey()) == null) {

				cacheResult(tableDrink);
			}
		}
	}

	/**
	 * Clears the cache for all table drinks.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TableDrinkImpl.class);

		finderCache.clearCache(TableDrinkImpl.class);
	}

	/**
	 * Clears the cache for the table drink.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TableDrink tableDrink) {
		entityCache.removeResult(TableDrinkImpl.class, tableDrink);
	}

	@Override
	public void clearCache(List<TableDrink> tableDrinks) {
		for (TableDrink tableDrink : tableDrinks) {
			entityCache.removeResult(TableDrinkImpl.class, tableDrink);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TableDrinkImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TableDrinkImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new table drink with the primary key. Does not add the table drink to the database.
	 *
	 * @param id the primary key for the new table drink
	 * @return the new table drink
	 */
	@Override
	public TableDrink create(long id) {
		TableDrink tableDrink = new TableDrinkImpl();

		tableDrink.setNew(true);
		tableDrink.setPrimaryKey(id);

		return tableDrink;
	}

	/**
	 * Removes the table drink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the table drink
	 * @return the table drink that was removed
	 * @throws NoSuchTableDrinkException if a table drink with the primary key could not be found
	 */
	@Override
	public TableDrink remove(long id) throws NoSuchTableDrinkException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the table drink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the table drink
	 * @return the table drink that was removed
	 * @throws NoSuchTableDrinkException if a table drink with the primary key could not be found
	 */
	@Override
	public TableDrink remove(Serializable primaryKey)
		throws NoSuchTableDrinkException {

		Session session = null;

		try {
			session = openSession();

			TableDrink tableDrink = (TableDrink)session.get(
				TableDrinkImpl.class, primaryKey);

			if (tableDrink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTableDrinkException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(tableDrink);
		}
		catch (NoSuchTableDrinkException noSuchEntityException) {
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
	protected TableDrink removeImpl(TableDrink tableDrink) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tableDrink)) {
				tableDrink = (TableDrink)session.get(
					TableDrinkImpl.class, tableDrink.getPrimaryKeyObj());
			}

			if (tableDrink != null) {
				session.delete(tableDrink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (tableDrink != null) {
			clearCache(tableDrink);
		}

		return tableDrink;
	}

	@Override
	public TableDrink updateImpl(TableDrink tableDrink) {
		boolean isNew = tableDrink.isNew();

		if (!(tableDrink instanceof TableDrinkModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(tableDrink.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(tableDrink);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in tableDrink proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TableDrink implementation " +
					tableDrink.getClass());
		}

		TableDrinkModelImpl tableDrinkModelImpl =
			(TableDrinkModelImpl)tableDrink;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(tableDrink);
			}
			else {
				tableDrink = (TableDrink)session.merge(tableDrink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TableDrinkImpl.class, tableDrinkModelImpl, false, true);

		if (isNew) {
			tableDrink.setNew(false);
		}

		tableDrink.resetOriginalValues();

		return tableDrink;
	}

	/**
	 * Returns the table drink with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the table drink
	 * @return the table drink
	 * @throws NoSuchTableDrinkException if a table drink with the primary key could not be found
	 */
	@Override
	public TableDrink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTableDrinkException {

		TableDrink tableDrink = fetchByPrimaryKey(primaryKey);

		if (tableDrink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTableDrinkException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return tableDrink;
	}

	/**
	 * Returns the table drink with the primary key or throws a <code>NoSuchTableDrinkException</code> if it could not be found.
	 *
	 * @param id the primary key of the table drink
	 * @return the table drink
	 * @throws NoSuchTableDrinkException if a table drink with the primary key could not be found
	 */
	@Override
	public TableDrink findByPrimaryKey(long id)
		throws NoSuchTableDrinkException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the table drink with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the table drink
	 * @return the table drink, or <code>null</code> if a table drink with the primary key could not be found
	 */
	@Override
	public TableDrink fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the table drinks.
	 *
	 * @return the table drinks
	 */
	@Override
	public List<TableDrink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the table drinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @return the range of table drinks
	 */
	@Override
	public List<TableDrink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the table drinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of table drinks
	 */
	@Override
	public List<TableDrink> findAll(
		int start, int end, OrderByComparator<TableDrink> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the table drinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TableDrinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of table drinks
	 * @param end the upper bound of the range of table drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of table drinks
	 */
	@Override
	public List<TableDrink> findAll(
		int start, int end, OrderByComparator<TableDrink> orderByComparator,
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

		List<TableDrink> list = null;

		if (useFinderCache) {
			list = (List<TableDrink>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TABLEDRINK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TABLEDRINK;

				sql = sql.concat(TableDrinkModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TableDrink>)QueryUtil.list(
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
	 * Removes all the table drinks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TableDrink tableDrink : findAll()) {
			remove(tableDrink);
		}
	}

	/**
	 * Returns the number of table drinks.
	 *
	 * @return the number of table drinks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TABLEDRINK);

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
		return _SQL_SELECT_TABLEDRINK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TableDrinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the table drink persistence.
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

		_finderPathWithPaginationFindByTableNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTableNumber",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"tableNumber"}, true);

		_finderPathWithoutPaginationFindByTableNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTableNumber",
			new String[] {Integer.class.getName()},
			new String[] {"tableNumber"}, true);

		_finderPathCountByTableNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTableNumber",
			new String[] {Integer.class.getName()},
			new String[] {"tableNumber"}, false);

		_finderPathWithPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {String.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {String.class.getName()}, new String[] {"status"},
			false);

		_finderPathWithPaginationFindBySeats = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySeats",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"seats"}, true);

		_finderPathWithoutPaginationFindBySeats = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySeats",
			new String[] {Integer.class.getName()}, new String[] {"seats"},
			true);

		_finderPathCountBySeats = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySeats",
			new String[] {Integer.class.getName()}, new String[] {"seats"},
			false);

		_setTableDrinkUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTableDrinkUtilPersistence(null);

		entityCache.removeCache(TableDrinkImpl.class.getName());
	}

	private void _setTableDrinkUtilPersistence(
		TableDrinkPersistence tableDrinkPersistence) {

		try {
			Field field = TableDrinkUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, tableDrinkPersistence);
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

	private static final String _SQL_SELECT_TABLEDRINK =
		"SELECT tableDrink FROM TableDrink tableDrink";

	private static final String _SQL_SELECT_TABLEDRINK_WHERE =
		"SELECT tableDrink FROM TableDrink tableDrink WHERE ";

	private static final String _SQL_COUNT_TABLEDRINK =
		"SELECT COUNT(tableDrink) FROM TableDrink tableDrink";

	private static final String _SQL_COUNT_TABLEDRINK_WHERE =
		"SELECT COUNT(tableDrink) FROM TableDrink tableDrink WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "tableDrink.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TableDrink exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TableDrink exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TableDrinkPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}