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

package com.liferay.gs.test.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.gs.test.model.Dummy;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the dummy service. This utility wraps {@link com.liferay.gs.test.service.persistence.impl.DummyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DummyPersistence
 * @see com.liferay.gs.test.service.persistence.impl.DummyPersistenceImpl
 * @generated
 */
@ProviderType
public class DummyUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Dummy dummy) {
		getPersistence().clearCache(dummy);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Dummy> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Dummy> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Dummy> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Dummy> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Dummy update(Dummy dummy) {
		return getPersistence().update(dummy);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Dummy update(Dummy dummy, ServiceContext serviceContext) {
		return getPersistence().update(dummy, serviceContext);
	}

	/**
	* Returns all the dummies where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching dummies
	*/
	public static List<Dummy> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<Dummy> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<Dummy> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Dummy> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<Dummy> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Dummy> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first dummy in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dummy
	* @throws NoSuchDummyException if a matching dummy could not be found
	*/
	public static Dummy findByUuid_First(java.lang.String uuid,
		OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.gs.test.exception.NoSuchDummyException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first dummy in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public static Dummy fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Dummy> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last dummy in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dummy
	* @throws NoSuchDummyException if a matching dummy could not be found
	*/
	public static Dummy findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.gs.test.exception.NoSuchDummyException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last dummy in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public static Dummy fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Dummy> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static Dummy[] findByUuid_PrevAndNext(long dummyId,
		java.lang.String uuid, OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.gs.test.exception.NoSuchDummyException {
		return getPersistence()
				   .findByUuid_PrevAndNext(dummyId, uuid, orderByComparator);
	}

	/**
	* Removes all the dummies where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of dummies where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching dummies
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the dummy where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchDummyException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching dummy
	* @throws NoSuchDummyException if a matching dummy could not be found
	*/
	public static Dummy findByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.gs.test.exception.NoSuchDummyException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the dummy where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public static Dummy fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the dummy where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public static Dummy fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the dummy where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the dummy that was removed
	*/
	public static Dummy removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.gs.test.exception.NoSuchDummyException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of dummies where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching dummies
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the dummies where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching dummies
	*/
	public static List<Dummy> findByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<Dummy> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<Dummy> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Dummy> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
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
	public static List<Dummy> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Dummy> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
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
	public static Dummy findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.gs.test.exception.NoSuchDummyException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public static Dummy fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Dummy> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
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
	public static Dummy findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.gs.test.exception.NoSuchDummyException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public static Dummy fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Dummy> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
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
	public static Dummy[] findByUuid_C_PrevAndNext(long dummyId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.gs.test.exception.NoSuchDummyException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(dummyId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the dummies where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of dummies where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching dummies
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns the dummy where field1 = &#63; or throws a {@link NoSuchDummyException} if it could not be found.
	*
	* @param field1 the field1
	* @return the matching dummy
	* @throws NoSuchDummyException if a matching dummy could not be found
	*/
	public static Dummy findByField1(java.lang.String field1)
		throws com.liferay.gs.test.exception.NoSuchDummyException {
		return getPersistence().findByField1(field1);
	}

	/**
	* Returns the dummy where field1 = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param field1 the field1
	* @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public static Dummy fetchByField1(java.lang.String field1) {
		return getPersistence().fetchByField1(field1);
	}

	/**
	* Returns the dummy where field1 = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param field1 the field1
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public static Dummy fetchByField1(java.lang.String field1,
		boolean retrieveFromCache) {
		return getPersistence().fetchByField1(field1, retrieveFromCache);
	}

	/**
	* Removes the dummy where field1 = &#63; from the database.
	*
	* @param field1 the field1
	* @return the dummy that was removed
	*/
	public static Dummy removeByField1(java.lang.String field1)
		throws com.liferay.gs.test.exception.NoSuchDummyException {
		return getPersistence().removeByField1(field1);
	}

	/**
	* Returns the number of dummies where field1 = &#63;.
	*
	* @param field1 the field1
	* @return the number of matching dummies
	*/
	public static int countByField1(java.lang.String field1) {
		return getPersistence().countByField1(field1);
	}

	/**
	* Returns all the dummies where field2 = &#63;.
	*
	* @param field2 the field2
	* @return the matching dummies
	*/
	public static List<Dummy> findByField2(boolean field2) {
		return getPersistence().findByField2(field2);
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
	public static List<Dummy> findByField2(boolean field2, int start, int end) {
		return getPersistence().findByField2(field2, start, end);
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
	public static List<Dummy> findByField2(boolean field2, int start, int end,
		OrderByComparator<Dummy> orderByComparator) {
		return getPersistence()
				   .findByField2(field2, start, end, orderByComparator);
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
	public static List<Dummy> findByField2(boolean field2, int start, int end,
		OrderByComparator<Dummy> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByField2(field2, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first dummy in the ordered set where field2 = &#63;.
	*
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dummy
	* @throws NoSuchDummyException if a matching dummy could not be found
	*/
	public static Dummy findByField2_First(boolean field2,
		OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.gs.test.exception.NoSuchDummyException {
		return getPersistence().findByField2_First(field2, orderByComparator);
	}

	/**
	* Returns the first dummy in the ordered set where field2 = &#63;.
	*
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public static Dummy fetchByField2_First(boolean field2,
		OrderByComparator<Dummy> orderByComparator) {
		return getPersistence().fetchByField2_First(field2, orderByComparator);
	}

	/**
	* Returns the last dummy in the ordered set where field2 = &#63;.
	*
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dummy
	* @throws NoSuchDummyException if a matching dummy could not be found
	*/
	public static Dummy findByField2_Last(boolean field2,
		OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.gs.test.exception.NoSuchDummyException {
		return getPersistence().findByField2_Last(field2, orderByComparator);
	}

	/**
	* Returns the last dummy in the ordered set where field2 = &#63;.
	*
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public static Dummy fetchByField2_Last(boolean field2,
		OrderByComparator<Dummy> orderByComparator) {
		return getPersistence().fetchByField2_Last(field2, orderByComparator);
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
	public static Dummy[] findByField2_PrevAndNext(long dummyId,
		boolean field2, OrderByComparator<Dummy> orderByComparator)
		throws com.liferay.gs.test.exception.NoSuchDummyException {
		return getPersistence()
				   .findByField2_PrevAndNext(dummyId, field2, orderByComparator);
	}

	/**
	* Removes all the dummies where field2 = &#63; from the database.
	*
	* @param field2 the field2
	*/
	public static void removeByField2(boolean field2) {
		getPersistence().removeByField2(field2);
	}

	/**
	* Returns the number of dummies where field2 = &#63;.
	*
	* @param field2 the field2
	* @return the number of matching dummies
	*/
	public static int countByField2(boolean field2) {
		return getPersistence().countByField2(field2);
	}

	/**
	* Caches the dummy in the entity cache if it is enabled.
	*
	* @param dummy the dummy
	*/
	public static void cacheResult(Dummy dummy) {
		getPersistence().cacheResult(dummy);
	}

	/**
	* Caches the dummies in the entity cache if it is enabled.
	*
	* @param dummies the dummies
	*/
	public static void cacheResult(List<Dummy> dummies) {
		getPersistence().cacheResult(dummies);
	}

	/**
	* Creates a new dummy with the primary key. Does not add the dummy to the database.
	*
	* @param dummyId the primary key for the new dummy
	* @return the new dummy
	*/
	public static Dummy create(long dummyId) {
		return getPersistence().create(dummyId);
	}

	/**
	* Removes the dummy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dummyId the primary key of the dummy
	* @return the dummy that was removed
	* @throws NoSuchDummyException if a dummy with the primary key could not be found
	*/
	public static Dummy remove(long dummyId)
		throws com.liferay.gs.test.exception.NoSuchDummyException {
		return getPersistence().remove(dummyId);
	}

	public static Dummy updateImpl(Dummy dummy) {
		return getPersistence().updateImpl(dummy);
	}

	/**
	* Returns the dummy with the primary key or throws a {@link NoSuchDummyException} if it could not be found.
	*
	* @param dummyId the primary key of the dummy
	* @return the dummy
	* @throws NoSuchDummyException if a dummy with the primary key could not be found
	*/
	public static Dummy findByPrimaryKey(long dummyId)
		throws com.liferay.gs.test.exception.NoSuchDummyException {
		return getPersistence().findByPrimaryKey(dummyId);
	}

	/**
	* Returns the dummy with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dummyId the primary key of the dummy
	* @return the dummy, or <code>null</code> if a dummy with the primary key could not be found
	*/
	public static Dummy fetchByPrimaryKey(long dummyId) {
		return getPersistence().fetchByPrimaryKey(dummyId);
	}

	public static java.util.Map<java.io.Serializable, Dummy> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the dummies.
	*
	* @return the dummies
	*/
	public static List<Dummy> findAll() {
		return getPersistence().findAll();
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
	public static List<Dummy> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Dummy> findAll(int start, int end,
		OrderByComparator<Dummy> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Dummy> findAll(int start, int end,
		OrderByComparator<Dummy> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the dummies from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dummies.
	*
	* @return the number of dummies
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static DummyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DummyPersistence, DummyPersistence> _serviceTracker =
		ServiceTrackerFactory.open(DummyPersistence.class);
}