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
 * Provides a wrapper for {@link DummyService}.
 *
 * @author Brian Wing Shun Chan
 * @see DummyService
 * @generated
 */
@ProviderType
public class DummyServiceWrapper implements DummyService,
	ServiceWrapper<DummyService> {
	public DummyServiceWrapper(DummyService dummyService) {
		_dummyService = dummyService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _dummyService.getOSGiServiceIdentifier();
	}

	@Override
	public DummyService getWrappedService() {
		return _dummyService;
	}

	@Override
	public void setWrappedService(DummyService dummyService) {
		_dummyService = dummyService;
	}

	private DummyService _dummyService;
}