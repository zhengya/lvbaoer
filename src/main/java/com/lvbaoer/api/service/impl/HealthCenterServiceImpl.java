/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvbaoer.api.domain.HealthCenter;
import com.lvbaoer.api.mapper.HealthCenterMapper;
import com.lvbaoer.api.service.HealthCenterService;

@Component
public class HealthCenterServiceImpl implements HealthCenterService {
	@Autowired
	private HealthCenterMapper healthCenterMapper;

	@Override
	public List<HealthCenter> getByAddr(String province, String city, int id) {
		if (id == 0) {
			return healthCenterMapper.getByAddr(province, city);
		}
		return healthCenterMapper.getByAddrAndServe(province, city, "^" + id + "$");
	}

}
