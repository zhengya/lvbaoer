/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.service;

import java.util.List;
import java.util.Map;

import com.lvbaoer.api.bean.CenterInfoResult;
import com.lvbaoer.api.domain.HealthCenter;
import com.lvbaoer.api.domain.HealthCenterInfo;

public interface HealthCenterService {
    List<HealthCenter> getByAddr(String province, String city, int id);

    Map<String, List<CenterInfoResult>> getInfos(int centerId);

    HealthCenterInfo getInfoById(int id);
}
