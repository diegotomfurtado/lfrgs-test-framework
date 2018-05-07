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

package com.liferay.gs.test.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Dummy}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Dummy
 * @generated
 */
@ProviderType
public class DummyWrapper implements Dummy, ModelWrapper<Dummy> {
	public DummyWrapper(Dummy dummy) {
		_dummy = dummy;
	}

	@Override
	public Class<?> getModelClass() {
		return Dummy.class;
	}

	@Override
	public String getModelClassName() {
		return Dummy.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("dummyId", getDummyId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("field1", getField1());
		attributes.put("field2", getField2());
		attributes.put("field3", getField3());
		attributes.put("field4", getField4());
		attributes.put("field5", getField5());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dummyId = (Long)attributes.get("dummyId");

		if (dummyId != null) {
			setDummyId(dummyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String field1 = (String)attributes.get("field1");

		if (field1 != null) {
			setField1(field1);
		}

		Boolean field2 = (Boolean)attributes.get("field2");

		if (field2 != null) {
			setField2(field2);
		}

		Integer field3 = (Integer)attributes.get("field3");

		if (field3 != null) {
			setField3(field3);
		}

		Date field4 = (Date)attributes.get("field4");

		if (field4 != null) {
			setField4(field4);
		}

		String field5 = (String)attributes.get("field5");

		if (field5 != null) {
			setField5(field5);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new DummyWrapper((Dummy)_dummy.clone());
	}

	@Override
	public int compareTo(Dummy dummy) {
		return _dummy.compareTo(dummy);
	}

	/**
	* Returns the company ID of this dummy.
	*
	* @return the company ID of this dummy
	*/
	@Override
	public long getCompanyId() {
		return _dummy.getCompanyId();
	}

	/**
	* Returns the create date of this dummy.
	*
	* @return the create date of this dummy
	*/
	@Override
	public Date getCreateDate() {
		return _dummy.getCreateDate();
	}

	/**
	* Returns the dummy ID of this dummy.
	*
	* @return the dummy ID of this dummy
	*/
	@Override
	public long getDummyId() {
		return _dummy.getDummyId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _dummy.getExpandoBridge();
	}

	/**
	* Returns the field1 of this dummy.
	*
	* @return the field1 of this dummy
	*/
	@Override
	public java.lang.String getField1() {
		return _dummy.getField1();
	}

	/**
	* Returns the field2 of this dummy.
	*
	* @return the field2 of this dummy
	*/
	@Override
	public boolean getField2() {
		return _dummy.getField2();
	}

	/**
	* Returns the field3 of this dummy.
	*
	* @return the field3 of this dummy
	*/
	@Override
	public int getField3() {
		return _dummy.getField3();
	}

	/**
	* Returns the field4 of this dummy.
	*
	* @return the field4 of this dummy
	*/
	@Override
	public Date getField4() {
		return _dummy.getField4();
	}

	/**
	* Returns the field5 of this dummy.
	*
	* @return the field5 of this dummy
	*/
	@Override
	public java.lang.String getField5() {
		return _dummy.getField5();
	}

	/**
	* Returns the group ID of this dummy.
	*
	* @return the group ID of this dummy
	*/
	@Override
	public long getGroupId() {
		return _dummy.getGroupId();
	}

	/**
	* Returns the modified date of this dummy.
	*
	* @return the modified date of this dummy
	*/
	@Override
	public Date getModifiedDate() {
		return _dummy.getModifiedDate();
	}

	/**
	* Returns the mvcc version of this dummy.
	*
	* @return the mvcc version of this dummy
	*/
	@Override
	public long getMvccVersion() {
		return _dummy.getMvccVersion();
	}

	/**
	* Returns the primary key of this dummy.
	*
	* @return the primary key of this dummy
	*/
	@Override
	public long getPrimaryKey() {
		return _dummy.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dummy.getPrimaryKeyObj();
	}

	/**
	* Returns the user ID of this dummy.
	*
	* @return the user ID of this dummy
	*/
	@Override
	public long getUserId() {
		return _dummy.getUserId();
	}

	/**
	* Returns the user name of this dummy.
	*
	* @return the user name of this dummy
	*/
	@Override
	public java.lang.String getUserName() {
		return _dummy.getUserName();
	}

	/**
	* Returns the user uuid of this dummy.
	*
	* @return the user uuid of this dummy
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _dummy.getUserUuid();
	}

	/**
	* Returns the uuid of this dummy.
	*
	* @return the uuid of this dummy
	*/
	@Override
	public java.lang.String getUuid() {
		return _dummy.getUuid();
	}

	@Override
	public int hashCode() {
		return _dummy.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _dummy.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _dummy.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this dummy is field2.
	*
	* @return <code>true</code> if this dummy is field2; <code>false</code> otherwise
	*/
	@Override
	public boolean isField2() {
		return _dummy.isField2();
	}

	@Override
	public boolean isNew() {
		return _dummy.isNew();
	}

	@Override
	public void persist() {
		_dummy.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dummy.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this dummy.
	*
	* @param companyId the company ID of this dummy
	*/
	@Override
	public void setCompanyId(long companyId) {
		_dummy.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this dummy.
	*
	* @param createDate the create date of this dummy
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_dummy.setCreateDate(createDate);
	}

	/**
	* Sets the dummy ID of this dummy.
	*
	* @param dummyId the dummy ID of this dummy
	*/
	@Override
	public void setDummyId(long dummyId) {
		_dummy.setDummyId(dummyId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_dummy.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_dummy.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_dummy.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the field1 of this dummy.
	*
	* @param field1 the field1 of this dummy
	*/
	@Override
	public void setField1(java.lang.String field1) {
		_dummy.setField1(field1);
	}

	/**
	* Sets whether this dummy is field2.
	*
	* @param field2 the field2 of this dummy
	*/
	@Override
	public void setField2(boolean field2) {
		_dummy.setField2(field2);
	}

	/**
	* Sets the field3 of this dummy.
	*
	* @param field3 the field3 of this dummy
	*/
	@Override
	public void setField3(int field3) {
		_dummy.setField3(field3);
	}

	/**
	* Sets the field4 of this dummy.
	*
	* @param field4 the field4 of this dummy
	*/
	@Override
	public void setField4(Date field4) {
		_dummy.setField4(field4);
	}

	/**
	* Sets the field5 of this dummy.
	*
	* @param field5 the field5 of this dummy
	*/
	@Override
	public void setField5(java.lang.String field5) {
		_dummy.setField5(field5);
	}

	/**
	* Sets the group ID of this dummy.
	*
	* @param groupId the group ID of this dummy
	*/
	@Override
	public void setGroupId(long groupId) {
		_dummy.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this dummy.
	*
	* @param modifiedDate the modified date of this dummy
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_dummy.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the mvcc version of this dummy.
	*
	* @param mvccVersion the mvcc version of this dummy
	*/
	@Override
	public void setMvccVersion(long mvccVersion) {
		_dummy.setMvccVersion(mvccVersion);
	}

	@Override
	public void setNew(boolean n) {
		_dummy.setNew(n);
	}

	/**
	* Sets the primary key of this dummy.
	*
	* @param primaryKey the primary key of this dummy
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dummy.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_dummy.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this dummy.
	*
	* @param userId the user ID of this dummy
	*/
	@Override
	public void setUserId(long userId) {
		_dummy.setUserId(userId);
	}

	/**
	* Sets the user name of this dummy.
	*
	* @param userName the user name of this dummy
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_dummy.setUserName(userName);
	}

	/**
	* Sets the user uuid of this dummy.
	*
	* @param userUuid the user uuid of this dummy
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dummy.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this dummy.
	*
	* @param uuid the uuid of this dummy
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_dummy.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Dummy> toCacheModel() {
		return _dummy.toCacheModel();
	}

	@Override
	public Dummy toEscapedModel() {
		return new DummyWrapper(_dummy.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dummy.toString();
	}

	@Override
	public Dummy toUnescapedModel() {
		return new DummyWrapper(_dummy.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _dummy.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DummyWrapper)) {
			return false;
		}

		DummyWrapper dummyWrapper = (DummyWrapper)obj;

		if (Objects.equals(_dummy, dummyWrapper._dummy)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _dummy.getStagedModelType();
	}

	@Override
	public Dummy getWrappedModel() {
		return _dummy;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _dummy.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _dummy.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_dummy.resetOriginalValues();
	}

	private final Dummy _dummy;
}