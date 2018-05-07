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

import com.liferay.gs.test.exception.NoSuchDummyException;
import com.liferay.gs.test.model.Dummy;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the dummy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.gs.test.service.persistence.impl.DummyPersistenceImpl
 * @see DummyUtil
 * @generated
 */
@ProviderType
public interface DummyPersistence extends BasePersistence<Dummy> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DummyUtil} to access the dummy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the dummies where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching dummies
	*/
	public java.util.List<Dummy> findByUuid(java.lang.String uuid);

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
	public java.util.List<Dummy> findByUuid(java.lang.String uuid, int start,
		int end);

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
	public java.util.List<Dummy> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator);

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
	public java.util.List<Dummy> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first dummy in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dummy
	* @throws NoSuchDummyException if a matching dummy could not be found
	*/
	public Dummy findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException;

	/**
	* Returns the first dummy in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public Dummy fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator);

	/**
	* Returns the last dummy in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dummy
	* @throws NoSuchDummyException if a matching dummy could not be found
	*/
	public Dummy findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException;

	/**
	* Returns the last dummy in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public Dummy fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator);

	/**
	* Returns the dummies before and after the current dummy in the ordered set where uuid = &#63;.
	*
	* @param dummyId the primary key of the current dummy
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dummy
	* @throws NoSuchDummyException if a dummy with the primary key could not be found
	*/
	public Dummy[] findByUuid_PrevAndNext(long dummyId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException;

	/**
	* Removes all the dummies where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of dummies where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching dummies
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the dummy where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchDummyException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching dummy
	* @throws NoSuchDummyException if a matching dummy could not be found
	*/
	public Dummy findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchDummyException;

	/**
	* Returns the dummy where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public Dummy fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the dummy where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public Dummy fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the dummy where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the dummy that was removed
	*/
	public Dummy removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchDummyException;

	/**
	* Returns the number of dummies where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching dummies
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the dummies where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching dummies
	*/
	public java.util.List<Dummy> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<Dummy> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<Dummy> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator);

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
	public java.util.List<Dummy> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dummy
	* @throws NoSuchDummyException if a matching dummy could not be found
	*/
	public Dummy findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException;

	/**
	* Returns the first dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public Dummy fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator);

	/**
	* Returns the last dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dummy
	* @throws NoSuchDummyException if a matching dummy could not be found
	*/
	public Dummy findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException;

	/**
	* Returns the last dummy in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public Dummy fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator);

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
	public Dummy[] findByUuid_C_PrevAndNext(long dummyId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException;

	/**
	* Removes all the dummies where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of dummies where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching dummies
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the dummy where field1 = &#63; or throws a {@link NoSuchDummyException} if it could not be found.
	*
	* @param field1 the field1
	* @return the matching dummy
	* @throws NoSuchDummyException if a matching dummy could not be found
	*/
	public Dummy findByField1(java.lang.String field1)
		throws NoSuchDummyException;

	/**
	* Returns the dummy where field1 = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param field1 the field1
	* @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public Dummy fetchByField1(java.lang.String field1);

	/**
	* Returns the dummy where field1 = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param field1 the field1
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public Dummy fetchByField1(java.lang.String field1,
		boolean retrieveFromCache);

	/**
	* Removes the dummy where field1 = &#63; from the database.
	*
	* @param field1 the field1
	* @return the dummy that was removed
	*/
	public Dummy removeByField1(java.lang.String field1)
		throws NoSuchDummyException;

	/**
	* Returns the number of dummies where field1 = &#63;.
	*
	* @param field1 the field1
	* @return the number of matching dummies
	*/
	public int countByField1(java.lang.String field1);

	/**
	* Returns all the dummies where field2 = &#63;.
	*
	* @param field2 the field2
	* @return the matching dummies
	*/
	public java.util.List<Dummy> findByField2(boolean field2);

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
	public java.util.List<Dummy> findByField2(boolean field2, int start, int end);

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
	public java.util.List<Dummy> findByField2(boolean field2, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator);

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
	public java.util.List<Dummy> findByField2(boolean field2, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first dummy in the ordered set where field2 = &#63;.
	*
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dummy
	* @throws NoSuchDummyException if a matching dummy could not be found
	*/
	public Dummy findByField2_First(boolean field2,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException;

	/**
	* Returns the first dummy in the ordered set where field2 = &#63;.
	*
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public Dummy fetchByField2_First(boolean field2,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator);

	/**
	* Returns the last dummy in the ordered set where field2 = &#63;.
	*
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dummy
	* @throws NoSuchDummyException if a matching dummy could not be found
	*/
	public Dummy findByField2_Last(boolean field2,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException;

	/**
	* Returns the last dummy in the ordered set where field2 = &#63;.
	*
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	public Dummy fetchByField2_Last(boolean field2,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator);

	/**
	* Returns the dummies before and after the current dummy in the ordered set where field2 = &#63;.
	*
	* @param dummyId the primary key of the current dummy
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dummy
	* @throws NoSuchDummyException if a dummy with the primary key could not be found
	*/
	public Dummy[] findByField2_PrevAndNext(long dummyId, boolean field2,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator)
		throws NoSuchDummyException;

	/**
	* Removes all the dummies where field2 = &#63; from the database.
	*
	* @param field2 the field2
	*/
	public void removeByField2(boolean field2);

	/**
	* Returns the number of dummies where field2 = &#63;.
	*
	* @param field2 the field2
	* @return the number of matching dummies
	*/
	public int countByField2(boolean field2);

	/**
	* Caches the dummy in the entity cache if it is enabled.
	*
	* @param dummy the dummy
	*/
	public void cacheResult(Dummy dummy);

	/**
	* Caches the dummies in the entity cache if it is enabled.
	*
	* @param dummies the dummies
	*/
	public void cacheResult(java.util.List<Dummy> dummies);

	/**
	* Creates a new dummy with the primary key. Does not add the dummy to the database.
	*
	* @param dummyId the primary key for the new dummy
	* @return the new dummy
	*/
	public Dummy create(long dummyId);

	/**
	* Removes the dummy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dummyId the primary key of the dummy
	* @return the dummy that was removed
	* @throws NoSuchDummyException if a dummy with the primary key could not be found
	*/
	public Dummy remove(long dummyId) throws NoSuchDummyException;

	public Dummy updateImpl(Dummy dummy);

	/**
	* Returns the dummy with the primary key or throws a {@link NoSuchDummyException} if it could not be found.
	*
	* @param dummyId the primary key of the dummy
	* @return the dummy
	* @throws NoSuchDummyException if a dummy with the primary key could not be found
	*/
	public Dummy findByPrimaryKey(long dummyId) throws NoSuchDummyException;

	/**
	* Returns the dummy with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dummyId the primary key of the dummy
	* @return the dummy, or <code>null</code> if a dummy with the primary key could not be found
	*/
	public Dummy fetchByPrimaryKey(long dummyId);

	@Override
	public java.util.Map<java.io.Serializable, Dummy> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the dummies.
	*
	* @return the dummies
	*/
	public java.util.List<Dummy> findAll();

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
	public java.util.List<Dummy> findAll(int start, int end);

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
	public java.util.List<Dummy> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator);

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
	public java.util.List<Dummy> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dummy> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the dummies from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of dummies.
	*
	* @return the number of dummies
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}