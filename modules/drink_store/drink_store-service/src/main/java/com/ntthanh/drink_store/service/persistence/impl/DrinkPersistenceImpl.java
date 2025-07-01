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

import com.ntthanh.drink_store.exception.NoSuchDrinkException;
import com.ntthanh.drink_store.model.Drink;
import com.ntthanh.drink_store.model.DrinkTable;
import com.ntthanh.drink_store.model.impl.DrinkImpl;
import com.ntthanh.drink_store.model.impl.DrinkModelImpl;
import com.ntthanh.drink_store.service.persistence.DrinkPersistence;
import com.ntthanh.drink_store.service.persistence.DrinkUtil;
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
 * The persistence implementation for the drink service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DrinkPersistence.class)
public class DrinkPersistenceImpl
	extends BasePersistenceImpl<Drink> implements DrinkPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DrinkUtil</code> to access the drink persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DrinkImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDrinkName;
	private FinderPath _finderPathWithoutPaginationFindByDrinkName;
	private FinderPath _finderPathCountByDrinkName;

	/**
	 * Returns all the drinks where drinkName = &#63; and category = &#63;.
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 * @return the matching drinks
	 */
	@Override
	public List<Drink> findByDrinkName(String drinkName, String category) {
		return findByDrinkName(
			drinkName, category, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the drinks where drinkName = &#63; and category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @return the range of matching drinks
	 */
	@Override
	public List<Drink> findByDrinkName(
		String drinkName, String category, int start, int end) {

		return findByDrinkName(drinkName, category, start, end, null);
	}

	/**
	 * Returns an ordered range of all the drinks where drinkName = &#63; and category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching drinks
	 */
	@Override
	public List<Drink> findByDrinkName(
		String drinkName, String category, int start, int end,
		OrderByComparator<Drink> orderByComparator) {

		return findByDrinkName(
			drinkName, category, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the drinks where drinkName = &#63; and category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching drinks
	 */
	@Override
	public List<Drink> findByDrinkName(
		String drinkName, String category, int start, int end,
		OrderByComparator<Drink> orderByComparator, boolean useFinderCache) {

		drinkName = Objects.toString(drinkName, "");
		category = Objects.toString(category, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDrinkName;
				finderArgs = new Object[] {drinkName, category};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDrinkName;
			finderArgs = new Object[] {
				drinkName, category, start, end, orderByComparator
			};
		}

		List<Drink> list = null;

		if (useFinderCache) {
			list = (List<Drink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Drink drink : list) {
					if (!drinkName.equals(drink.getDrinkName()) ||
						!category.equals(drink.getCategory())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DRINK_WHERE);

			boolean bindDrinkName = false;

			if (drinkName.isEmpty()) {
				sb.append(_FINDER_COLUMN_DRINKNAME_DRINKNAME_3);
			}
			else {
				bindDrinkName = true;

				sb.append(_FINDER_COLUMN_DRINKNAME_DRINKNAME_2);
			}

			boolean bindCategory = false;

			if (category.isEmpty()) {
				sb.append(_FINDER_COLUMN_DRINKNAME_CATEGORY_3);
			}
			else {
				bindCategory = true;

				sb.append(_FINDER_COLUMN_DRINKNAME_CATEGORY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DrinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDrinkName) {
					queryPos.add(drinkName);
				}

				if (bindCategory) {
					queryPos.add(category);
				}

				list = (List<Drink>)QueryUtil.list(
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
	 * Returns the first drink in the ordered set where drinkName = &#63; and category = &#63;.
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drink
	 * @throws NoSuchDrinkException if a matching drink could not be found
	 */
	@Override
	public Drink findByDrinkName_First(
			String drinkName, String category,
			OrderByComparator<Drink> orderByComparator)
		throws NoSuchDrinkException {

		Drink drink = fetchByDrinkName_First(
			drinkName, category, orderByComparator);

		if (drink != null) {
			return drink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("drinkName=");
		sb.append(drinkName);

		sb.append(", category=");
		sb.append(category);

		sb.append("}");

		throw new NoSuchDrinkException(sb.toString());
	}

	/**
	 * Returns the first drink in the ordered set where drinkName = &#63; and category = &#63;.
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drink, or <code>null</code> if a matching drink could not be found
	 */
	@Override
	public Drink fetchByDrinkName_First(
		String drinkName, String category,
		OrderByComparator<Drink> orderByComparator) {

		List<Drink> list = findByDrinkName(
			drinkName, category, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last drink in the ordered set where drinkName = &#63; and category = &#63;.
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drink
	 * @throws NoSuchDrinkException if a matching drink could not be found
	 */
	@Override
	public Drink findByDrinkName_Last(
			String drinkName, String category,
			OrderByComparator<Drink> orderByComparator)
		throws NoSuchDrinkException {

		Drink drink = fetchByDrinkName_Last(
			drinkName, category, orderByComparator);

		if (drink != null) {
			return drink;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("drinkName=");
		sb.append(drinkName);

		sb.append(", category=");
		sb.append(category);

		sb.append("}");

		throw new NoSuchDrinkException(sb.toString());
	}

	/**
	 * Returns the last drink in the ordered set where drinkName = &#63; and category = &#63;.
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drink, or <code>null</code> if a matching drink could not be found
	 */
	@Override
	public Drink fetchByDrinkName_Last(
		String drinkName, String category,
		OrderByComparator<Drink> orderByComparator) {

		int count = countByDrinkName(drinkName, category);

		if (count == 0) {
			return null;
		}

		List<Drink> list = findByDrinkName(
			drinkName, category, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the drinks before and after the current drink in the ordered set where drinkName = &#63; and category = &#63;.
	 *
	 * @param id the primary key of the current drink
	 * @param drinkName the drink name
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next drink
	 * @throws NoSuchDrinkException if a drink with the primary key could not be found
	 */
	@Override
	public Drink[] findByDrinkName_PrevAndNext(
			long id, String drinkName, String category,
			OrderByComparator<Drink> orderByComparator)
		throws NoSuchDrinkException {

		drinkName = Objects.toString(drinkName, "");
		category = Objects.toString(category, "");

		Drink drink = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Drink[] array = new DrinkImpl[3];

			array[0] = getByDrinkName_PrevAndNext(
				session, drink, drinkName, category, orderByComparator, true);

			array[1] = drink;

			array[2] = getByDrinkName_PrevAndNext(
				session, drink, drinkName, category, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Drink getByDrinkName_PrevAndNext(
		Session session, Drink drink, String drinkName, String category,
		OrderByComparator<Drink> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DRINK_WHERE);

		boolean bindDrinkName = false;

		if (drinkName.isEmpty()) {
			sb.append(_FINDER_COLUMN_DRINKNAME_DRINKNAME_3);
		}
		else {
			bindDrinkName = true;

			sb.append(_FINDER_COLUMN_DRINKNAME_DRINKNAME_2);
		}

		boolean bindCategory = false;

		if (category.isEmpty()) {
			sb.append(_FINDER_COLUMN_DRINKNAME_CATEGORY_3);
		}
		else {
			bindCategory = true;

			sb.append(_FINDER_COLUMN_DRINKNAME_CATEGORY_2);
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
			sb.append(DrinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDrinkName) {
			queryPos.add(drinkName);
		}

		if (bindCategory) {
			queryPos.add(category);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(drink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Drink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the drinks where drinkName = &#63; and category = &#63; from the database.
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 */
	@Override
	public void removeByDrinkName(String drinkName, String category) {
		for (Drink drink :
				findByDrinkName(
					drinkName, category, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(drink);
		}
	}

	/**
	 * Returns the number of drinks where drinkName = &#63; and category = &#63;.
	 *
	 * @param drinkName the drink name
	 * @param category the category
	 * @return the number of matching drinks
	 */
	@Override
	public int countByDrinkName(String drinkName, String category) {
		drinkName = Objects.toString(drinkName, "");
		category = Objects.toString(category, "");

		FinderPath finderPath = _finderPathCountByDrinkName;

		Object[] finderArgs = new Object[] {drinkName, category};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DRINK_WHERE);

			boolean bindDrinkName = false;

			if (drinkName.isEmpty()) {
				sb.append(_FINDER_COLUMN_DRINKNAME_DRINKNAME_3);
			}
			else {
				bindDrinkName = true;

				sb.append(_FINDER_COLUMN_DRINKNAME_DRINKNAME_2);
			}

			boolean bindCategory = false;

			if (category.isEmpty()) {
				sb.append(_FINDER_COLUMN_DRINKNAME_CATEGORY_3);
			}
			else {
				bindCategory = true;

				sb.append(_FINDER_COLUMN_DRINKNAME_CATEGORY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDrinkName) {
					queryPos.add(drinkName);
				}

				if (bindCategory) {
					queryPos.add(category);
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

	private static final String _FINDER_COLUMN_DRINKNAME_DRINKNAME_2 =
		"drink.drinkName = ? AND ";

	private static final String _FINDER_COLUMN_DRINKNAME_DRINKNAME_3 =
		"(drink.drinkName IS NULL OR drink.drinkName = '') AND ";

	private static final String _FINDER_COLUMN_DRINKNAME_CATEGORY_2 =
		"drink.category = ?";

	private static final String _FINDER_COLUMN_DRINKNAME_CATEGORY_3 =
		"(drink.category IS NULL OR drink.category = '')";

	private FinderPath _finderPathWithPaginationFindByCategory;
	private FinderPath _finderPathWithoutPaginationFindByCategory;
	private FinderPath _finderPathCountByCategory;

	/**
	 * Returns all the drinks where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching drinks
	 */
	@Override
	public List<Drink> findByCategory(String category) {
		return findByCategory(
			category, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the drinks where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @return the range of matching drinks
	 */
	@Override
	public List<Drink> findByCategory(String category, int start, int end) {
		return findByCategory(category, start, end, null);
	}

	/**
	 * Returns an ordered range of all the drinks where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching drinks
	 */
	@Override
	public List<Drink> findByCategory(
		String category, int start, int end,
		OrderByComparator<Drink> orderByComparator) {

		return findByCategory(category, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the drinks where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching drinks
	 */
	@Override
	public List<Drink> findByCategory(
		String category, int start, int end,
		OrderByComparator<Drink> orderByComparator, boolean useFinderCache) {

		category = Objects.toString(category, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCategory;
				finderArgs = new Object[] {category};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCategory;
			finderArgs = new Object[] {category, start, end, orderByComparator};
		}

		List<Drink> list = null;

		if (useFinderCache) {
			list = (List<Drink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Drink drink : list) {
					if (!category.equals(drink.getCategory())) {
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

			sb.append(_SQL_SELECT_DRINK_WHERE);

			boolean bindCategory = false;

			if (category.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DrinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCategory) {
					queryPos.add(category);
				}

				list = (List<Drink>)QueryUtil.list(
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
	 * Returns the first drink in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drink
	 * @throws NoSuchDrinkException if a matching drink could not be found
	 */
	@Override
	public Drink findByCategory_First(
			String category, OrderByComparator<Drink> orderByComparator)
		throws NoSuchDrinkException {

		Drink drink = fetchByCategory_First(category, orderByComparator);

		if (drink != null) {
			return drink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("category=");
		sb.append(category);

		sb.append("}");

		throw new NoSuchDrinkException(sb.toString());
	}

	/**
	 * Returns the first drink in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drink, or <code>null</code> if a matching drink could not be found
	 */
	@Override
	public Drink fetchByCategory_First(
		String category, OrderByComparator<Drink> orderByComparator) {

		List<Drink> list = findByCategory(category, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last drink in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drink
	 * @throws NoSuchDrinkException if a matching drink could not be found
	 */
	@Override
	public Drink findByCategory_Last(
			String category, OrderByComparator<Drink> orderByComparator)
		throws NoSuchDrinkException {

		Drink drink = fetchByCategory_Last(category, orderByComparator);

		if (drink != null) {
			return drink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("category=");
		sb.append(category);

		sb.append("}");

		throw new NoSuchDrinkException(sb.toString());
	}

	/**
	 * Returns the last drink in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drink, or <code>null</code> if a matching drink could not be found
	 */
	@Override
	public Drink fetchByCategory_Last(
		String category, OrderByComparator<Drink> orderByComparator) {

		int count = countByCategory(category);

		if (count == 0) {
			return null;
		}

		List<Drink> list = findByCategory(
			category, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the drinks before and after the current drink in the ordered set where category = &#63;.
	 *
	 * @param id the primary key of the current drink
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next drink
	 * @throws NoSuchDrinkException if a drink with the primary key could not be found
	 */
	@Override
	public Drink[] findByCategory_PrevAndNext(
			long id, String category,
			OrderByComparator<Drink> orderByComparator)
		throws NoSuchDrinkException {

		category = Objects.toString(category, "");

		Drink drink = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Drink[] array = new DrinkImpl[3];

			array[0] = getByCategory_PrevAndNext(
				session, drink, category, orderByComparator, true);

			array[1] = drink;

			array[2] = getByCategory_PrevAndNext(
				session, drink, category, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Drink getByCategory_PrevAndNext(
		Session session, Drink drink, String category,
		OrderByComparator<Drink> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DRINK_WHERE);

		boolean bindCategory = false;

		if (category.isEmpty()) {
			sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
		}
		else {
			bindCategory = true;

			sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
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
			sb.append(DrinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCategory) {
			queryPos.add(category);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(drink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Drink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the drinks where category = &#63; from the database.
	 *
	 * @param category the category
	 */
	@Override
	public void removeByCategory(String category) {
		for (Drink drink :
				findByCategory(
					category, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(drink);
		}
	}

	/**
	 * Returns the number of drinks where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching drinks
	 */
	@Override
	public int countByCategory(String category) {
		category = Objects.toString(category, "");

		FinderPath finderPath = _finderPathCountByCategory;

		Object[] finderArgs = new Object[] {category};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DRINK_WHERE);

			boolean bindCategory = false;

			if (category.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCategory) {
					queryPos.add(category);
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

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_2 =
		"drink.category = ?";

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_3 =
		"(drink.category IS NULL OR drink.category = '')";

	private FinderPath _finderPathWithPaginationFindByPrice;
	private FinderPath _finderPathWithoutPaginationFindByPrice;
	private FinderPath _finderPathCountByPrice;

	/**
	 * Returns all the drinks where price = &#63;.
	 *
	 * @param price the price
	 * @return the matching drinks
	 */
	@Override
	public List<Drink> findByPrice(double price) {
		return findByPrice(price, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the drinks where price = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param price the price
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @return the range of matching drinks
	 */
	@Override
	public List<Drink> findByPrice(double price, int start, int end) {
		return findByPrice(price, start, end, null);
	}

	/**
	 * Returns an ordered range of all the drinks where price = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param price the price
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching drinks
	 */
	@Override
	public List<Drink> findByPrice(
		double price, int start, int end,
		OrderByComparator<Drink> orderByComparator) {

		return findByPrice(price, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the drinks where price = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param price the price
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching drinks
	 */
	@Override
	public List<Drink> findByPrice(
		double price, int start, int end,
		OrderByComparator<Drink> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPrice;
				finderArgs = new Object[] {price};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPrice;
			finderArgs = new Object[] {price, start, end, orderByComparator};
		}

		List<Drink> list = null;

		if (useFinderCache) {
			list = (List<Drink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Drink drink : list) {
					if (price != drink.getPrice()) {
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

			sb.append(_SQL_SELECT_DRINK_WHERE);

			sb.append(_FINDER_COLUMN_PRICE_PRICE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DrinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(price);

				list = (List<Drink>)QueryUtil.list(
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
	 * Returns the first drink in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drink
	 * @throws NoSuchDrinkException if a matching drink could not be found
	 */
	@Override
	public Drink findByPrice_First(
			double price, OrderByComparator<Drink> orderByComparator)
		throws NoSuchDrinkException {

		Drink drink = fetchByPrice_First(price, orderByComparator);

		if (drink != null) {
			return drink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("price=");
		sb.append(price);

		sb.append("}");

		throw new NoSuchDrinkException(sb.toString());
	}

	/**
	 * Returns the first drink in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching drink, or <code>null</code> if a matching drink could not be found
	 */
	@Override
	public Drink fetchByPrice_First(
		double price, OrderByComparator<Drink> orderByComparator) {

		List<Drink> list = findByPrice(price, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last drink in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drink
	 * @throws NoSuchDrinkException if a matching drink could not be found
	 */
	@Override
	public Drink findByPrice_Last(
			double price, OrderByComparator<Drink> orderByComparator)
		throws NoSuchDrinkException {

		Drink drink = fetchByPrice_Last(price, orderByComparator);

		if (drink != null) {
			return drink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("price=");
		sb.append(price);

		sb.append("}");

		throw new NoSuchDrinkException(sb.toString());
	}

	/**
	 * Returns the last drink in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching drink, or <code>null</code> if a matching drink could not be found
	 */
	@Override
	public Drink fetchByPrice_Last(
		double price, OrderByComparator<Drink> orderByComparator) {

		int count = countByPrice(price);

		if (count == 0) {
			return null;
		}

		List<Drink> list = findByPrice(
			price, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the drinks before and after the current drink in the ordered set where price = &#63;.
	 *
	 * @param id the primary key of the current drink
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next drink
	 * @throws NoSuchDrinkException if a drink with the primary key could not be found
	 */
	@Override
	public Drink[] findByPrice_PrevAndNext(
			long id, double price, OrderByComparator<Drink> orderByComparator)
		throws NoSuchDrinkException {

		Drink drink = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Drink[] array = new DrinkImpl[3];

			array[0] = getByPrice_PrevAndNext(
				session, drink, price, orderByComparator, true);

			array[1] = drink;

			array[2] = getByPrice_PrevAndNext(
				session, drink, price, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Drink getByPrice_PrevAndNext(
		Session session, Drink drink, double price,
		OrderByComparator<Drink> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DRINK_WHERE);

		sb.append(_FINDER_COLUMN_PRICE_PRICE_2);

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
			sb.append(DrinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(price);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(drink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Drink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the drinks where price = &#63; from the database.
	 *
	 * @param price the price
	 */
	@Override
	public void removeByPrice(double price) {
		for (Drink drink :
				findByPrice(
					price, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(drink);
		}
	}

	/**
	 * Returns the number of drinks where price = &#63;.
	 *
	 * @param price the price
	 * @return the number of matching drinks
	 */
	@Override
	public int countByPrice(double price) {
		FinderPath finderPath = _finderPathCountByPrice;

		Object[] finderArgs = new Object[] {price};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DRINK_WHERE);

			sb.append(_FINDER_COLUMN_PRICE_PRICE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(price);

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

	private static final String _FINDER_COLUMN_PRICE_PRICE_2 =
		"drink.price = ?";

	public DrinkPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Drink.class);

		setModelImplClass(DrinkImpl.class);
		setModelPKClass(long.class);

		setTable(DrinkTable.INSTANCE);
	}

	/**
	 * Caches the drink in the entity cache if it is enabled.
	 *
	 * @param drink the drink
	 */
	@Override
	public void cacheResult(Drink drink) {
		entityCache.putResult(DrinkImpl.class, drink.getPrimaryKey(), drink);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the drinks in the entity cache if it is enabled.
	 *
	 * @param drinks the drinks
	 */
	@Override
	public void cacheResult(List<Drink> drinks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (drinks.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Drink drink : drinks) {
			if (entityCache.getResult(DrinkImpl.class, drink.getPrimaryKey()) ==
					null) {

				cacheResult(drink);
			}
		}
	}

	/**
	 * Clears the cache for all drinks.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DrinkImpl.class);

		finderCache.clearCache(DrinkImpl.class);
	}

	/**
	 * Clears the cache for the drink.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Drink drink) {
		entityCache.removeResult(DrinkImpl.class, drink);
	}

	@Override
	public void clearCache(List<Drink> drinks) {
		for (Drink drink : drinks) {
			entityCache.removeResult(DrinkImpl.class, drink);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DrinkImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DrinkImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new drink with the primary key. Does not add the drink to the database.
	 *
	 * @param id the primary key for the new drink
	 * @return the new drink
	 */
	@Override
	public Drink create(long id) {
		Drink drink = new DrinkImpl();

		drink.setNew(true);
		drink.setPrimaryKey(id);

		return drink;
	}

	/**
	 * Removes the drink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the drink
	 * @return the drink that was removed
	 * @throws NoSuchDrinkException if a drink with the primary key could not be found
	 */
	@Override
	public Drink remove(long id) throws NoSuchDrinkException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the drink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the drink
	 * @return the drink that was removed
	 * @throws NoSuchDrinkException if a drink with the primary key could not be found
	 */
	@Override
	public Drink remove(Serializable primaryKey) throws NoSuchDrinkException {
		Session session = null;

		try {
			session = openSession();

			Drink drink = (Drink)session.get(DrinkImpl.class, primaryKey);

			if (drink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDrinkException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(drink);
		}
		catch (NoSuchDrinkException noSuchEntityException) {
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
	protected Drink removeImpl(Drink drink) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(drink)) {
				drink = (Drink)session.get(
					DrinkImpl.class, drink.getPrimaryKeyObj());
			}

			if (drink != null) {
				session.delete(drink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (drink != null) {
			clearCache(drink);
		}

		return drink;
	}

	@Override
	public Drink updateImpl(Drink drink) {
		boolean isNew = drink.isNew();

		if (!(drink instanceof DrinkModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(drink.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(drink);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in drink proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Drink implementation " +
					drink.getClass());
		}

		DrinkModelImpl drinkModelImpl = (DrinkModelImpl)drink;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(drink);
			}
			else {
				drink = (Drink)session.merge(drink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(DrinkImpl.class, drinkModelImpl, false, true);

		if (isNew) {
			drink.setNew(false);
		}

		drink.resetOriginalValues();

		return drink;
	}

	/**
	 * Returns the drink with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the drink
	 * @return the drink
	 * @throws NoSuchDrinkException if a drink with the primary key could not be found
	 */
	@Override
	public Drink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDrinkException {

		Drink drink = fetchByPrimaryKey(primaryKey);

		if (drink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDrinkException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return drink;
	}

	/**
	 * Returns the drink with the primary key or throws a <code>NoSuchDrinkException</code> if it could not be found.
	 *
	 * @param id the primary key of the drink
	 * @return the drink
	 * @throws NoSuchDrinkException if a drink with the primary key could not be found
	 */
	@Override
	public Drink findByPrimaryKey(long id) throws NoSuchDrinkException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the drink with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the drink
	 * @return the drink, or <code>null</code> if a drink with the primary key could not be found
	 */
	@Override
	public Drink fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the drinks.
	 *
	 * @return the drinks
	 */
	@Override
	public List<Drink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the drinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @return the range of drinks
	 */
	@Override
	public List<Drink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the drinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of drinks
	 */
	@Override
	public List<Drink> findAll(
		int start, int end, OrderByComparator<Drink> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the drinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DrinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of drinks
	 * @param end the upper bound of the range of drinks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of drinks
	 */
	@Override
	public List<Drink> findAll(
		int start, int end, OrderByComparator<Drink> orderByComparator,
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

		List<Drink> list = null;

		if (useFinderCache) {
			list = (List<Drink>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DRINK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DRINK;

				sql = sql.concat(DrinkModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Drink>)QueryUtil.list(
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
	 * Removes all the drinks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Drink drink : findAll()) {
			remove(drink);
		}
	}

	/**
	 * Returns the number of drinks.
	 *
	 * @return the number of drinks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DRINK);

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
		return _SQL_SELECT_DRINK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DrinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the drink persistence.
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

		_finderPathWithPaginationFindByDrinkName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDrinkName",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"drinkName", "category"}, true);

		_finderPathWithoutPaginationFindByDrinkName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDrinkName",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"drinkName", "category"}, true);

		_finderPathCountByDrinkName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDrinkName",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"drinkName", "category"}, false);

		_finderPathWithPaginationFindByCategory = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategory",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"category"}, true);

		_finderPathWithoutPaginationFindByCategory = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] {String.class.getName()}, new String[] {"category"},
			true);

		_finderPathCountByCategory = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] {String.class.getName()}, new String[] {"category"},
			false);

		_finderPathWithPaginationFindByPrice = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPrice",
			new String[] {
				Double.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"price"}, true);

		_finderPathWithoutPaginationFindByPrice = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPrice",
			new String[] {Double.class.getName()}, new String[] {"price"},
			true);

		_finderPathCountByPrice = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPrice",
			new String[] {Double.class.getName()}, new String[] {"price"},
			false);

		_setDrinkUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDrinkUtilPersistence(null);

		entityCache.removeCache(DrinkImpl.class.getName());
	}

	private void _setDrinkUtilPersistence(DrinkPersistence drinkPersistence) {
		try {
			Field field = DrinkUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, drinkPersistence);
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

	private static final String _SQL_SELECT_DRINK =
		"SELECT drink FROM Drink drink";

	private static final String _SQL_SELECT_DRINK_WHERE =
		"SELECT drink FROM Drink drink WHERE ";

	private static final String _SQL_COUNT_DRINK =
		"SELECT COUNT(drink) FROM Drink drink";

	private static final String _SQL_COUNT_DRINK_WHERE =
		"SELECT COUNT(drink) FROM Drink drink WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "drink.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Drink exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Drink exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DrinkPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}