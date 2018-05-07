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

package com.liferay.gs.test.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.gs.test.exception.NoSuchDummyException;
import com.liferay.gs.test.model.Dummy;
import com.liferay.gs.test.model.impl.DummyImpl;
import com.liferay.gs.test.model.impl.DummyModelImpl;
import com.liferay.gs.test.service.persistence.DummyPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the dummy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DummyPersistence
 * @see com.liferay.gs.test.service.persistence.DummyUtil
 * @generated
 */
@ProviderType
public class DummyPersistenceImpl extends BasePersistenceImpl<Dummy>
	implements DummyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DummyUtil} to access the dummy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DummyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DummyModelImpl.ENTITY_CACHE_ENABLED,
			DummyModelImpl.FINDER_CACHE_ENABLED, DummyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DummyModelImpl.ENTITY_CACHE_ENABLED,
			DummyModelImpl.FINDER_CACHE_ENABLED, DummyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DummyModelImpl.ENTITY_CACHE_ENABLED,
			DummyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(DummyModelImpl.ENTITY_CACHE_ENABLED,
			DummyModelImpl.FINDER_CACHE_ENABLED, DummyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(DummyModelImpl.ENTITY_CACHE_ENABLED,
			DummyModelImpl.FINDER_CACHE_ENABLED, DummyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			DummyModelImpl.UUID_COLUMN_BITMASK |
			DummyModelImpl.FIELD1_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(DummyModelImpl.ENTITY_CACHE_ENABLED,
			DummyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the dummies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dummies
	 */
	@Override
	public List<Dummy> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dummies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DummyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @return the range of matching dummies
	 */
	@Override
	public List<Dummy> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dummies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DummyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dummies
	 */
	@Override
	public List<Dummy> findByUuid(String uuid, int start, int end,
		OrderByComparator<Dummy> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dummies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DummyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching dummies
	 */
	@Override
	public List<Dummy> findByUuid(String uuid, int start, int end,
		OrderByComparator<Dummy> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Dummy> list = null;

		if (retrieveFromCache) {
			list = (List<Dummy>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Dummy dummy : list) {
					if (!Objects.equals(uuid, dummy.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DUMMY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DummyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Dummy>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Dummy>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first dummy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	@Override
	public Dummy findByUuid_First(String uuid,
		OrderByComparator<Dummy> orderByComparator) throws NoSuchDummyException {
		Dummy dummy = fetchByUuid_First(uuid, orderByComparator);

		if (dummy != null) {
			return dummy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDummyException(msg.toString());
	}

	/**
	 * Returns the first dummy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByUuid_First(String uuid,
		OrderByComparator<Dummy> orderByComparator) {
		List<Dummy> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dummy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	@Override
	public Dummy findByUuid_Last(String uuid,
		OrderByComparator<Dummy> orderByComparator) throws NoSuchDummyException {
		Dummy dummy = fetchByUuid_Last(uuid, orderByComparator);

		if (dummy != null) {
			return dummy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDummyException(msg.toString());
	}

	/**
	 * Returns the last dummy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByUuid_Last(String uuid,
		OrderByComparator<Dummy> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Dummy> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dummies before and after the current dummy in the ordered set where uuid = &#63;.
	 *
	 * @param dummyId the primary key of the current dummy
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dummy
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	@Override
	public Dummy[] findByUuid_PrevAndNext(long dummyId, String uuid,
		OrderByComparator<Dummy> orderByComparator) throws NoSuchDummyException {
		Dummy dummy = findByPrimaryKey(dummyId);

		Session session = null;

		try {
			session = openSession();

			Dummy[] array = new DummyImpl[3];

			array[0] = getByUuid_PrevAndNext(session, dummy, uuid,
					orderByComparator, true);

			array[1] = dummy;

			array[2] = getByUuid_PrevAndNext(session, dummy, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Dummy getByUuid_PrevAndNext(Session session, Dummy dummy,
		String uuid, OrderByComparator<Dummy> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DUMMY_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DummyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dummy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Dummy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dummies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Dummy dummy : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(dummy);
		}
	}

	/**
	 * Returns the number of dummies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dummies
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DUMMY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "dummy.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "dummy.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(dummy.uuid IS NULL OR dummy.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(DummyModelImpl.ENTITY_CACHE_ENABLED,
			DummyModelImpl.FINDER_CACHE_ENABLED, DummyImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			DummyModelImpl.UUID_COLUMN_BITMASK |
			DummyModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(DummyModelImpl.ENTITY_CACHE_ENABLED,
			DummyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the dummy where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchDummyException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	@Override
	public Dummy findByUUID_G(String uuid, long groupId)
		throws NoSuchDummyException {
		Dummy dummy = fetchByUUID_G(uuid, groupId);

		if (dummy == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDummyException(msg.toString());
		}

		return dummy;
	}

	/**
	 * Returns the dummy where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the dummy where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Dummy) {
			Dummy dummy = (Dummy)result;

			if (!Objects.equals(uuid, dummy.getUuid()) ||
					(groupId != dummy.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DUMMY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Dummy> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Dummy dummy = list.get(0);

					result = dummy;

					cacheResult(dummy);

					if ((dummy.getUuid() == null) ||
							!dummy.getUuid().equals(uuid) ||
							(dummy.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, dummy);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Dummy)result;
		}
	}

	/**
	 * Removes the dummy where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dummy that was removed
	 */
	@Override
	public Dummy removeByUUID_G(String uuid, long groupId)
		throws NoSuchDummyException {
		Dummy dummy = findByUUID_G(uuid, groupId);

		return remove(dummy);
	}

	/**
	 * Returns the number of dummies where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dummies
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DUMMY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "dummy.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "dummy.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(dummy.uuid IS NULL OR dummy.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "dummy.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(DummyModelImpl.ENTITY_CACHE_ENABLED,
			DummyModelImpl.FINDER_CACHE_ENABLED, DummyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(DummyModelImpl.ENTITY_CACHE_ENABLED,
			DummyModelImpl.FINDER_CACHE_ENABLED, DummyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			DummyModelImpl.UUID_COLUMN_BITMASK |
			DummyModelImpl.COMPANYID_COLUMN_BITMASK |
			DummyModelImpl.FIELD1_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(DummyModelImpl.ENTITY_CACHE_ENABLED,
			DummyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the dummies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dummies
	 */
	@Override
	public List<Dummy> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dummies where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DummyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @return the range of matching dummies
	 */
	@Override
	public List<Dummy> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dummies where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DummyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dummies
	 */
	@Override
	public List<Dummy> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Dummy> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dummies where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DummyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching dummies
	 */
	@Override
	public List<Dummy> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Dummy> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Dummy> list = null;

		if (retrieveFromCache) {
			list = (List<Dummy>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Dummy dummy : list) {
					if (!Objects.equals(uuid, dummy.getUuid()) ||
							(companyId != dummy.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DUMMY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DummyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Dummy>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Dummy>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	@Override
	public Dummy findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Dummy> orderByComparator) throws NoSuchDummyException {
		Dummy dummy = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (dummy != null) {
			return dummy;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDummyException(msg.toString());
	}

	/**
	 * Returns the first dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Dummy> orderByComparator) {
		List<Dummy> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	@Override
	public Dummy findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Dummy> orderByComparator) throws NoSuchDummyException {
		Dummy dummy = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (dummy != null) {
			return dummy;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDummyException(msg.toString());
	}

	/**
	 * Returns the last dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Dummy> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Dummy> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dummies before and after the current dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dummyId the primary key of the current dummy
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dummy
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	@Override
	public Dummy[] findByUuid_C_PrevAndNext(long dummyId, String uuid,
		long companyId, OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException {
		Dummy dummy = findByPrimaryKey(dummyId);

		Session session = null;

		try {
			session = openSession();

			Dummy[] array = new DummyImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, dummy, uuid, companyId,
					orderByComparator, true);

			array[1] = dummy;

			array[2] = getByUuid_C_PrevAndNext(session, dummy, uuid, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Dummy getByUuid_C_PrevAndNext(Session session, Dummy dummy,
		String uuid, long companyId,
		OrderByComparator<Dummy> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DUMMY_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DummyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dummy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Dummy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dummies where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Dummy dummy : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(dummy);
		}
	}

	/**
	 * Returns the number of dummies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dummies
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DUMMY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "dummy.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "dummy.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(dummy.uuid IS NULL OR dummy.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "dummy.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_FIELD1 = new FinderPath(DummyModelImpl.ENTITY_CACHE_ENABLED,
			DummyModelImpl.FINDER_CACHE_ENABLED, DummyImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByField1",
			new String[] { String.class.getName() },
			DummyModelImpl.FIELD1_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FIELD1 = new FinderPath(DummyModelImpl.ENTITY_CACHE_ENABLED,
			DummyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByField1",
			new String[] { String.class.getName() });

	/**
	 * Returns the dummy where field1 = &#63; or throws a {@link NoSuchDummyException} if it could not be found.
	 *
	 * @param field1 the field1
	 * @return the matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	@Override
	public Dummy findByField1(String field1) throws NoSuchDummyException {
		Dummy dummy = fetchByField1(field1);

		if (dummy == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("field1=");
			msg.append(field1);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDummyException(msg.toString());
		}

		return dummy;
	}

	/**
	 * Returns the dummy where field1 = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param field1 the field1
	 * @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByField1(String field1) {
		return fetchByField1(field1, true);
	}

	/**
	 * Returns the dummy where field1 = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param field1 the field1
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByField1(String field1, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { field1 };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_FIELD1,
					finderArgs, this);
		}

		if (result instanceof Dummy) {
			Dummy dummy = (Dummy)result;

			if (!Objects.equals(field1, dummy.getField1())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DUMMY_WHERE);

			boolean bindField1 = false;

			if (field1 == null) {
				query.append(_FINDER_COLUMN_FIELD1_FIELD1_1);
			}
			else if (field1.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIELD1_FIELD1_3);
			}
			else {
				bindField1 = true;

				query.append(_FINDER_COLUMN_FIELD1_FIELD1_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindField1) {
					qPos.add(field1);
				}

				List<Dummy> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_FIELD1,
						finderArgs, list);
				}
				else {
					Dummy dummy = list.get(0);

					result = dummy;

					cacheResult(dummy);

					if ((dummy.getField1() == null) ||
							!dummy.getField1().equals(field1)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_FIELD1,
							finderArgs, dummy);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_FIELD1, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Dummy)result;
		}
	}

	/**
	 * Removes the dummy where field1 = &#63; from the database.
	 *
	 * @param field1 the field1
	 * @return the dummy that was removed
	 */
	@Override
	public Dummy removeByField1(String field1) throws NoSuchDummyException {
		Dummy dummy = findByField1(field1);

		return remove(dummy);
	}

	/**
	 * Returns the number of dummies where field1 = &#63;.
	 *
	 * @param field1 the field1
	 * @return the number of matching dummies
	 */
	@Override
	public int countByField1(String field1) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FIELD1;

		Object[] finderArgs = new Object[] { field1 };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DUMMY_WHERE);

			boolean bindField1 = false;

			if (field1 == null) {
				query.append(_FINDER_COLUMN_FIELD1_FIELD1_1);
			}
			else if (field1.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIELD1_FIELD1_3);
			}
			else {
				bindField1 = true;

				query.append(_FINDER_COLUMN_FIELD1_FIELD1_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindField1) {
					qPos.add(field1);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FIELD1_FIELD1_1 = "dummy.field1 IS NULL";
	private static final String _FINDER_COLUMN_FIELD1_FIELD1_2 = "dummy.field1 = ?";
	private static final String _FINDER_COLUMN_FIELD1_FIELD1_3 = "(dummy.field1 IS NULL OR dummy.field1 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FIELD2 = new FinderPath(DummyModelImpl.ENTITY_CACHE_ENABLED,
			DummyModelImpl.FINDER_CACHE_ENABLED, DummyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByField2",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2 =
		new FinderPath(DummyModelImpl.ENTITY_CACHE_ENABLED,
			DummyModelImpl.FINDER_CACHE_ENABLED, DummyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByField2",
			new String[] { Boolean.class.getName() },
			DummyModelImpl.FIELD2_COLUMN_BITMASK |
			DummyModelImpl.FIELD1_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FIELD2 = new FinderPath(DummyModelImpl.ENTITY_CACHE_ENABLED,
			DummyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByField2",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the dummies where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @return the matching dummies
	 */
	@Override
	public List<Dummy> findByField2(boolean field2) {
		return findByField2(field2, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dummies where field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DummyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param field2 the field2
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @return the range of matching dummies
	 */
	@Override
	public List<Dummy> findByField2(boolean field2, int start, int end) {
		return findByField2(field2, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dummies where field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DummyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param field2 the field2
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dummies
	 */
	@Override
	public List<Dummy> findByField2(boolean field2, int start, int end,
		OrderByComparator<Dummy> orderByComparator) {
		return findByField2(field2, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dummies where field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DummyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param field2 the field2
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching dummies
	 */
	@Override
	public List<Dummy> findByField2(boolean field2, int start, int end,
		OrderByComparator<Dummy> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2;
			finderArgs = new Object[] { field2 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FIELD2;
			finderArgs = new Object[] { field2, start, end, orderByComparator };
		}

		List<Dummy> list = null;

		if (retrieveFromCache) {
			list = (List<Dummy>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Dummy dummy : list) {
					if ((field2 != dummy.getField2())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DUMMY_WHERE);

			query.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DummyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(field2);

				if (!pagination) {
					list = (List<Dummy>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Dummy>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first dummy in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	@Override
	public Dummy findByField2_First(boolean field2,
		OrderByComparator<Dummy> orderByComparator) throws NoSuchDummyException {
		Dummy dummy = fetchByField2_First(field2, orderByComparator);

		if (dummy != null) {
			return dummy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("field2=");
		msg.append(field2);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDummyException(msg.toString());
	}

	/**
	 * Returns the first dummy in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByField2_First(boolean field2,
		OrderByComparator<Dummy> orderByComparator) {
		List<Dummy> list = findByField2(field2, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dummy in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy
	 * @throws NoSuchDummyException if a matching dummy could not be found
	 */
	@Override
	public Dummy findByField2_Last(boolean field2,
		OrderByComparator<Dummy> orderByComparator) throws NoSuchDummyException {
		Dummy dummy = fetchByField2_Last(field2, orderByComparator);

		if (dummy != null) {
			return dummy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("field2=");
		msg.append(field2);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDummyException(msg.toString());
	}

	/**
	 * Returns the last dummy in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	 */
	@Override
	public Dummy fetchByField2_Last(boolean field2,
		OrderByComparator<Dummy> orderByComparator) {
		int count = countByField2(field2);

		if (count == 0) {
			return null;
		}

		List<Dummy> list = findByField2(field2, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dummies before and after the current dummy in the ordered set where field2 = &#63;.
	 *
	 * @param dummyId the primary key of the current dummy
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dummy
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	@Override
	public Dummy[] findByField2_PrevAndNext(long dummyId, boolean field2,
		OrderByComparator<Dummy> orderByComparator) throws NoSuchDummyException {
		Dummy dummy = findByPrimaryKey(dummyId);

		Session session = null;

		try {
			session = openSession();

			Dummy[] array = new DummyImpl[3];

			array[0] = getByField2_PrevAndNext(session, dummy, field2,
					orderByComparator, true);

			array[1] = dummy;

			array[2] = getByField2_PrevAndNext(session, dummy, field2,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Dummy getByField2_PrevAndNext(Session session, Dummy dummy,
		boolean field2, OrderByComparator<Dummy> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DUMMY_WHERE);

		query.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DummyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(field2);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dummy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Dummy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dummies where field2 = &#63; from the database.
	 *
	 * @param field2 the field2
	 */
	@Override
	public void removeByField2(boolean field2) {
		for (Dummy dummy : findByField2(field2, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(dummy);
		}
	}

	/**
	 * Returns the number of dummies where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @return the number of matching dummies
	 */
	@Override
	public int countByField2(boolean field2) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FIELD2;

		Object[] finderArgs = new Object[] { field2 };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DUMMY_WHERE);

			query.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(field2);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FIELD2_FIELD2_2 = "dummy.field2 = ?";

	public DummyPersistenceImpl() {
		setModelClass(Dummy.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the dummy in the entity cache if it is enabled.
	 *
	 * @param dummy the dummy
	 */
	@Override
	public void cacheResult(Dummy dummy) {
		entityCache.putResult(DummyModelImpl.ENTITY_CACHE_ENABLED,
			DummyImpl.class, dummy.getPrimaryKey(), dummy);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { dummy.getUuid(), dummy.getGroupId() }, dummy);

		finderCache.putResult(FINDER_PATH_FETCH_BY_FIELD1,
			new Object[] { dummy.getField1() }, dummy);

		dummy.resetOriginalValues();
	}

	/**
	 * Caches the dummies in the entity cache if it is enabled.
	 *
	 * @param dummies the dummies
	 */
	@Override
	public void cacheResult(List<Dummy> dummies) {
		for (Dummy dummy : dummies) {
			if (entityCache.getResult(DummyModelImpl.ENTITY_CACHE_ENABLED,
						DummyImpl.class, dummy.getPrimaryKey()) == null) {
				cacheResult(dummy);
			}
			else {
				dummy.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dummies.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DummyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dummy.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Dummy dummy) {
		entityCache.removeResult(DummyModelImpl.ENTITY_CACHE_ENABLED,
			DummyImpl.class, dummy.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DummyModelImpl)dummy, true);
	}

	@Override
	public void clearCache(List<Dummy> dummies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Dummy dummy : dummies) {
			entityCache.removeResult(DummyModelImpl.ENTITY_CACHE_ENABLED,
				DummyImpl.class, dummy.getPrimaryKey());

			clearUniqueFindersCache((DummyModelImpl)dummy, true);
		}
	}

	protected void cacheUniqueFindersCache(DummyModelImpl dummyModelImpl) {
		Object[] args = new Object[] {
				dummyModelImpl.getUuid(), dummyModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			dummyModelImpl, false);

		args = new Object[] { dummyModelImpl.getField1() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_FIELD1, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_FIELD1, args,
			dummyModelImpl, false);
	}

	protected void clearUniqueFindersCache(DummyModelImpl dummyModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					dummyModelImpl.getUuid(), dummyModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((dummyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					dummyModelImpl.getOriginalUuid(),
					dummyModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] { dummyModelImpl.getField1() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_FIELD1, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_FIELD1, args);
		}

		if ((dummyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FIELD1.getColumnBitmask()) != 0) {
			Object[] args = new Object[] { dummyModelImpl.getOriginalField1() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_FIELD1, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_FIELD1, args);
		}
	}

	/**
	 * Creates a new dummy with the primary key. Does not add the dummy to the database.
	 *
	 * @param dummyId the primary key for the new dummy
	 * @return the new dummy
	 */
	@Override
	public Dummy create(long dummyId) {
		Dummy dummy = new DummyImpl();

		dummy.setNew(true);
		dummy.setPrimaryKey(dummyId);

		String uuid = PortalUUIDUtil.generate();

		dummy.setUuid(uuid);

		dummy.setCompanyId(companyProvider.getCompanyId());

		return dummy;
	}

	/**
	 * Removes the dummy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dummyId the primary key of the dummy
	 * @return the dummy that was removed
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	@Override
	public Dummy remove(long dummyId) throws NoSuchDummyException {
		return remove((Serializable)dummyId);
	}

	/**
	 * Removes the dummy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dummy
	 * @return the dummy that was removed
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	@Override
	public Dummy remove(Serializable primaryKey) throws NoSuchDummyException {
		Session session = null;

		try {
			session = openSession();

			Dummy dummy = (Dummy)session.get(DummyImpl.class, primaryKey);

			if (dummy == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDummyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dummy);
		}
		catch (NoSuchDummyException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Dummy removeImpl(Dummy dummy) {
		dummy = toUnwrappedModel(dummy);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dummy)) {
				dummy = (Dummy)session.get(DummyImpl.class,
						dummy.getPrimaryKeyObj());
			}

			if (dummy != null) {
				session.delete(dummy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dummy != null) {
			clearCache(dummy);
		}

		return dummy;
	}

	@Override
	public Dummy updateImpl(Dummy dummy) {
		dummy = toUnwrappedModel(dummy);

		boolean isNew = dummy.isNew();

		DummyModelImpl dummyModelImpl = (DummyModelImpl)dummy;

		if (Validator.isNull(dummy.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			dummy.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (dummy.getCreateDate() == null)) {
			if (serviceContext == null) {
				dummy.setCreateDate(now);
			}
			else {
				dummy.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!dummyModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dummy.setModifiedDate(now);
			}
			else {
				dummy.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (dummy.isNew()) {
				session.save(dummy);

				dummy.setNew(false);
			}
			else {
				dummy = (Dummy)session.merge(dummy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!DummyModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { dummyModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					dummyModelImpl.getUuid(), dummyModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { dummyModelImpl.getField2() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_FIELD2, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((dummyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { dummyModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { dummyModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((dummyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dummyModelImpl.getOriginalUuid(),
						dummyModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						dummyModelImpl.getUuid(), dummyModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((dummyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { dummyModelImpl.getOriginalField2() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FIELD2, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2,
					args);

				args = new Object[] { dummyModelImpl.getField2() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FIELD2, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2,
					args);
			}
		}

		entityCache.putResult(DummyModelImpl.ENTITY_CACHE_ENABLED,
			DummyImpl.class, dummy.getPrimaryKey(), dummy, false);

		clearUniqueFindersCache(dummyModelImpl, false);
		cacheUniqueFindersCache(dummyModelImpl);

		dummy.resetOriginalValues();

		return dummy;
	}

	protected Dummy toUnwrappedModel(Dummy dummy) {
		if (dummy instanceof DummyImpl) {
			return dummy;
		}

		DummyImpl dummyImpl = new DummyImpl();

		dummyImpl.setNew(dummy.isNew());
		dummyImpl.setPrimaryKey(dummy.getPrimaryKey());

		dummyImpl.setMvccVersion(dummy.getMvccVersion());
		dummyImpl.setUuid(dummy.getUuid());
		dummyImpl.setDummyId(dummy.getDummyId());
		dummyImpl.setGroupId(dummy.getGroupId());
		dummyImpl.setCompanyId(dummy.getCompanyId());
		dummyImpl.setUserId(dummy.getUserId());
		dummyImpl.setUserName(dummy.getUserName());
		dummyImpl.setCreateDate(dummy.getCreateDate());
		dummyImpl.setModifiedDate(dummy.getModifiedDate());
		dummyImpl.setField1(dummy.getField1());
		dummyImpl.setField2(dummy.isField2());
		dummyImpl.setField3(dummy.getField3());
		dummyImpl.setField4(dummy.getField4());
		dummyImpl.setField5(dummy.getField5());

		return dummyImpl;
	}

	/**
	 * Returns the dummy with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dummy
	 * @return the dummy
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	@Override
	public Dummy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDummyException {
		Dummy dummy = fetchByPrimaryKey(primaryKey);

		if (dummy == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDummyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dummy;
	}

	/**
	 * Returns the dummy with the primary key or throws a {@link NoSuchDummyException} if it could not be found.
	 *
	 * @param dummyId the primary key of the dummy
	 * @return the dummy
	 * @throws NoSuchDummyException if a dummy with the primary key could not be found
	 */
	@Override
	public Dummy findByPrimaryKey(long dummyId) throws NoSuchDummyException {
		return findByPrimaryKey((Serializable)dummyId);
	}

	/**
	 * Returns the dummy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dummy
	 * @return the dummy, or <code>null</code> if a dummy with the primary key could not be found
	 */
	@Override
	public Dummy fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(DummyModelImpl.ENTITY_CACHE_ENABLED,
				DummyImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Dummy dummy = (Dummy)serializable;

		if (dummy == null) {
			Session session = null;

			try {
				session = openSession();

				dummy = (Dummy)session.get(DummyImpl.class, primaryKey);

				if (dummy != null) {
					cacheResult(dummy);
				}
				else {
					entityCache.putResult(DummyModelImpl.ENTITY_CACHE_ENABLED,
						DummyImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DummyModelImpl.ENTITY_CACHE_ENABLED,
					DummyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dummy;
	}

	/**
	 * Returns the dummy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dummyId the primary key of the dummy
	 * @return the dummy, or <code>null</code> if a dummy with the primary key could not be found
	 */
	@Override
	public Dummy fetchByPrimaryKey(long dummyId) {
		return fetchByPrimaryKey((Serializable)dummyId);
	}

	@Override
	public Map<Serializable, Dummy> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Dummy> map = new HashMap<Serializable, Dummy>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Dummy dummy = fetchByPrimaryKey(primaryKey);

			if (dummy != null) {
				map.put(primaryKey, dummy);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(DummyModelImpl.ENTITY_CACHE_ENABLED,
					DummyImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Dummy)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DUMMY_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Dummy dummy : (List<Dummy>)q.list()) {
				map.put(dummy.getPrimaryKeyObj(), dummy);

				cacheResult(dummy);

				uncachedPrimaryKeys.remove(dummy.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DummyModelImpl.ENTITY_CACHE_ENABLED,
					DummyImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the dummies.
	 *
	 * @return the dummies
	 */
	@Override
	public List<Dummy> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dummies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DummyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @return the range of dummies
	 */
	@Override
	public List<Dummy> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dummies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DummyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dummies
	 */
	@Override
	public List<Dummy> findAll(int start, int end,
		OrderByComparator<Dummy> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dummies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DummyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dummies
	 * @param end the upper bound of the range of dummies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of dummies
	 */
	@Override
	public List<Dummy> findAll(int start, int end,
		OrderByComparator<Dummy> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Dummy> list = null;

		if (retrieveFromCache) {
			list = (List<Dummy>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DUMMY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DUMMY;

				if (pagination) {
					sql = sql.concat(DummyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Dummy>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Dummy>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the dummies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Dummy dummy : findAll()) {
			remove(dummy);
		}
	}

	/**
	 * Returns the number of dummies.
	 *
	 * @return the number of dummies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DUMMY);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
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
	protected Map<String, Integer> getTableColumnsMap() {
		return DummyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dummy persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DummyImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_DUMMY = "SELECT dummy FROM Dummy dummy";
	private static final String _SQL_SELECT_DUMMY_WHERE_PKS_IN = "SELECT dummy FROM Dummy dummy WHERE dummyId IN (";
	private static final String _SQL_SELECT_DUMMY_WHERE = "SELECT dummy FROM Dummy dummy WHERE ";
	private static final String _SQL_COUNT_DUMMY = "SELECT COUNT(dummy) FROM Dummy dummy";
	private static final String _SQL_COUNT_DUMMY_WHERE = "SELECT COUNT(dummy) FROM Dummy dummy WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dummy.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Dummy exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Dummy exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DummyPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}