/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.service;

import java.util.List;

import com.lvbaoer.api.domain.HealthCenter;

public interface HealthCenterService {
	List<HealthCenter> getByAddr(String province, String city, int id);
}
