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

package com.liferay.gs.test.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.gs.test.model.Dummy;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Dummy in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Dummy
 * @generated
 */
@ProviderType
public class DummyCacheModel implements CacheModel<Dummy>, Externalizable,
	MVCCModel {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DummyCacheModel)) {
			return false;
		}

		DummyCacheModel dummyCacheModel = (DummyCacheModel)obj;

		if ((dummyId == dummyCacheModel.dummyId) &&
				(mvccVersion == dummyCacheModel.mvccVersion)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, dummyId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", dummyId=");
		sb.append(dummyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", field1=");
		sb.append(field1);
		sb.append(", field2=");
		sb.append(field2);
		sb.append(", field3=");
		sb.append(field3);
		sb.append(", field4=");
		sb.append(field4);
		sb.append(", field5=");
		sb.append(field5);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Dummy toEntityModel() {
		DummyImpl dummyImpl = new DummyImpl();

		dummyImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			dummyImpl.setUuid(StringPool.BLANK);
		}
		else {
			dummyImpl.setUuid(uuid);
		}

		dummyImpl.setDummyId(dummyId);
		dummyImpl.setGroupId(groupId);
		dummyImpl.setCompanyId(companyId);
		dummyImpl.setUserId(userId);

		if (userName == null) {
			dummyImpl.setUserName(StringPool.BLANK);
		}
		else {
			dummyImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dummyImpl.setCreateDate(null);
		}
		else {
			dummyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dummyImpl.setModifiedDate(null);
		}
		else {
			dummyImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (field1 == null) {
			dummyImpl.setField1(StringPool.BLANK);
		}
		else {
			dummyImpl.setField1(field1);
		}

		dummyImpl.setField2(field2);
		dummyImpl.setField3(field3);

		if (field4 == Long.MIN_VALUE) {
			dummyImpl.setField4(null);
		}
		else {
			dummyImpl.setField4(new Date(field4));
		}

		if (field5 == null) {
			dummyImpl.setField5(StringPool.BLANK);
		}
		else {
			dummyImpl.setField5(field5);
		}

		dummyImpl.resetOriginalValues();

		return dummyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		dummyId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		field1 = objectInput.readUTF();

		field2 = objectInput.readBoolean();

		field3 = objectInput.readInt();
		field4 = objectInput.readLong();
		field5 = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(mvccVersion);

		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(dummyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (field1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(field1);
		}

		objectOutput.writeBoolean(field2);

		objectOutput.writeInt(field3);
		objectOutput.writeLong(field4);

		if (field5 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(field5);
		}
	}

	public long mvccVersion;
	public String uuid;
	public long dummyId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String field1;
	public boolean field2;
	public int field3;
	public long field4;
	public String field5;
}