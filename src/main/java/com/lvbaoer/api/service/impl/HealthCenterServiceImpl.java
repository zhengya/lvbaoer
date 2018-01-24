/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvbaoer.api.bean.CenterInfoResult;
import com.lvbaoer.api.domain.HealthCenter;
import com.lvbaoer.api.domain.HealthCenterInfo;
import com.lvbaoer.api.mapper.HealthCenterInfoMapper;
import com.lvbaoer.api.mapper.HealthCenterMapper;
import com.lvbaoer.api.service.HealthCenterService;

@Component
public class HealthCenterServiceImpl implements HealthCenterService {
    @Autowired
    private HealthCenterMapper healthCenterMapper;
    @Autowired
    private HealthCenterInfoMapper healthCenterInfoMapper;

    @Override
    public List<HealthCenter> getByAddr(String province, String city, int id) {
        if (id == 0) {
            return healthCenterMapper.getByAddr(province, city);
        }
        return healthCenterMapper.getByAddrAndServe(province, city, "^" + id + "$");
    }

    @Override
    public Map<String, List<CenterInfoResult>> getInfos(int centerId) {
        final List<HealthCenterInfo> infos = healthCenterInfoMapper.getByCenterId(centerId);
        if (infos == null || infos.size() == 0) {
            return null;
        }
        final List<CenterInfoResult> banner = new ArrayList<>();
        final List<CenterInfoResult> icon = new ArrayList<>();
        final List<CenterInfoResult> other = new ArrayList<>();
        for (HealthCenterInfo healthCenterInfo : infos) {
            final CenterInfoResult result = new CenterInfoResult(healthCenterInfo);
            if (healthCenterInfo.getIsBanner() == 1) {
                banner.add(result);
            } else if (healthCenterInfo.getIsIcon() == 1) {
                icon.add(result);
            } else {
                other.add(result);
            }
        }
        final Map<String, List<CenterInfoResult>> map = new HashMap<>();
        map.put("banner", banner);
        map.put("icon", icon);
        map.put("other", other);
        return map;
    }

    @Override
    public HealthCenterInfo getInfoById(int id) {
        return healthCenterInfoMapper.getById(id);
    }

}
