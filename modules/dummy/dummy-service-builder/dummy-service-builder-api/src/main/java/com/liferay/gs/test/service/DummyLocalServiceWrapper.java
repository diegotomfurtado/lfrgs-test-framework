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

package com.liferay.gs.test.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DummyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DummyLocalService
 * @generated
 */
@ProviderType
public class DummyLocalServiceWrapper implements DummyLocalService,
	ServiceWrapper<DummyLocalService> {
	public DummyLocalServiceWrapper(DummyLocalService dummyLocalService) {
		_dummyLocalService = dummyLocalService;
	}

	/**
	* Adds the dummy to the database. Also notifies the appropriate model listeners.
	*
	* @param dummy the dummy
	* @return the dummy that was added
	*/
	@Override
	public com.liferay.gs.test.model.Dummy addDummy(
		com.liferay.gs.test.model.Dummy dummy) {
		return _dummyLocalService.addDummy(dummy);
	}

	@Override
	public com.liferay.gs.test.model.Dummy addDummy(java.lang.String one,
		boolean two, int three, java.util.Date four, java.lang.String five) {
		return _dummyLocalService.addDummy(one, two, three, four, five);
	}

	/**
	* Creates a new dummy with the primary key. Does not add the dummy to the database.
	*
	* @param dummyId the primary key for the new dummy
	* @return the new dummy
	*/
	@Override
	public com.liferay.gs.test.model.Dummy createDummy(long dummyId) {
		return _dummyLocalService.createDummy(dummyId);
	}

	@Override
	public void deleteDummy(boolean two) {
		_dummyLocalService.deleteDummy(two);
	}

	/**
	* Deletes the dummy from the database. Also notifies the appropriate model listeners.
	*
	* @param dummy the dummy
	* @return the dummy that was removed
	*/
	@Override
	public com.liferay.gs.test.model.Dummy deleteDummy(
		com.liferay.gs.test.model.Dummy dummy) {
		return _dummyLocalService.deleteDummy(dummy);
	}

	/**
	* Deletes the dummy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dummyId the primary key of the dummy
	* @return the dummy that was removed
	* @throws PortalException if a dummy with the primary key could not be found
	*/
	@Override
	public com.liferay.gs.test.model.Dummy deleteDummy(long dummyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dummyLocalService.deleteDummy(dummyId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dummyLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dummyLocalService.dynamicQuery();
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
		return _dummyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.test.model.impl.DummyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dummyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.test.model.impl.DummyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dummyLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _dummyLocalService.dynamicQueryCount(dynamicQuery);
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
		return _dummyLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.gs.test.model.Dummy fetchByField1(java.lang.String one) {
		return _dummyLocalService.fetchByField1(one);
	}

	@Override
	public com.liferay.gs.test.model.Dummy fetchDummy(long dummyId) {
		return _dummyLocalService.fetchDummy(dummyId);
	}

	/**
	* Returns the dummy matching the UUID and group.
	*
	* @param uuid the dummy's UUID
	* @param groupId the primary key of the group
	* @return the matching dummy, or <code>null</code> if a matching dummy could not be found
	*/
	@Override
	public com.liferay.gs.test.model.Dummy fetchDummyByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _dummyLocalService.fetchDummyByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _dummyLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.gs.test.model.Dummy> getByField2(
		boolean two) {
		return _dummyLocalService.getByField2(two);
	}

	/**
	* Returns a range of all the dummies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.test.model.impl.DummyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dummies
	* @param end the upper bound of the range of dummies (not inclusive)
	* @return the range of dummies
	*/
	@Override
	public java.util.List<com.liferay.gs.test.model.Dummy> getDummies(
		int start, int end) {
		return _dummyLocalService.getDummies(start, end);
	}

	/**
	* Returns all the dummies matching the UUID and company.
	*
	* @param uuid the UUID of the dummies
	* @param companyId the primary key of the company
	* @return the matching dummies, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.gs.test.model.Dummy> getDummiesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _dummyLocalService.getDummiesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of dummies matching the UUID and company.
	*
	* @param uuid the UUID of the dummies
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of dummies
	* @param end the upper bound of the range of dummies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching dummies, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.gs.test.model.Dummy> getDummiesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.gs.test.model.Dummy> orderByComparator) {
		return _dummyLocalService.getDummiesByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of dummies.
	*
	* @return the number of dummies
	*/
	@Override
	public int getDummiesCount() {
		return _dummyLocalService.getDummiesCount();
	}

	/**
	* Returns the dummy with the primary key.
	*
	* @param dummyId the primary key of the dummy
	* @return the dummy
	* @throws PortalException if a dummy with the primary key could not be found
	*/
	@Override
	public com.liferay.gs.test.model.Dummy getDummy(long dummyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dummyLocalService.getDummy(dummyId);
	}

	/**
	* Returns the dummy matching the UUID and group.
	*
	* @param uuid the dummy's UUID
	* @param groupId the primary key of the group
	* @return the matching dummy
	* @throws PortalException if a matching dummy could not be found
	*/
	@Override
	public com.liferay.gs.test.model.Dummy getDummyByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dummyLocalService.getDummyByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _dummyLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _dummyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _dummyLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dummyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the dummy in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dummy the dummy
	* @return the dummy that was updated
	*/
	@Override
	public com.liferay.gs.test.model.Dummy updateDummy(
		com.liferay.gs.test.model.Dummy dummy) {
		return _dummyLocalService.updateDummy(dummy);
	}

	@Override
	public com.liferay.gs.test.model.Dummy updateDummy(long dummyId,
		java.lang.String one, boolean two, int three, java.util.Date four,
		java.lang.String five)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dummyLocalService.updateDummy(dummyId, one, two, three, four,
			five);
	}

	@Override
	public DummyLocalService getWrappedService() {
		return _dummyLocalService;
	}

	@Override
	public void setWrappedService(DummyLocalService dummyLocalService) {
		_dummyLocalService = dummyLocalService;
	}

	private DummyLocalService _dummyLocalService;
}