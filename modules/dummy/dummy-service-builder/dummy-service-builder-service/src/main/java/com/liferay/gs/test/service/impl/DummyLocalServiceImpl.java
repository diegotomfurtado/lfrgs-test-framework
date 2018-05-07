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

package com.liferay.gs.test.service.impl;

import com.liferay.gs.test.model.Dummy;
import com.liferay.gs.test.service.base.DummyLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the dummy local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.gs.test.service.DummyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DummyLocalServiceBaseImpl
 * @see com.liferay.gs.test.service.DummyLocalServiceUtil
 */
public class DummyLocalServiceImpl extends DummyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.gs.test.service.DummyLocalServiceUtil} to access the dummy local service.
	 */

	public Dummy addDummy(
		String one, boolean two, int three, Date four, String five) {

		long dummyId = counterLocalService.increment(Dummy.class.getName());

		Dummy dummy = dummyPersistence.create(dummyId);

		dummy.setField1(one);
		dummy.setField2(two);
		dummy.setField3(three);
		dummy.setField4(four);
		dummy.setField5(five);

		return dummyPersistence.update(dummy);
	}

	public void deleteDummy(boolean two) {
		dummyPersistence.removeByField2(two);
	}

	public Dummy fetchByField1(String one) {
		return dummyPersistence.fetchByField1(one);
	}

	public List<Dummy> getByField2(boolean two) {
		return dummyPersistence.findByField2(two);
	}

	public Dummy updateDummy(
			long dummyId, String one, boolean two, int three, Date four,
			String five)
		throws PortalException {

		Dummy dummy = dummyPersistence.findByPrimaryKey(dummyId);

		dummy.setField1(one);
		dummy.setField2(two);
		dummy.setField3(three);
		dummy.setField4(four);
		dummy.setField5(five);

		return dummyPersistence.update(dummy);
	}

}