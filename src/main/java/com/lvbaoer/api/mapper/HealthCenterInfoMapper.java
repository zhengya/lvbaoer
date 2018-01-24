/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lvbaoer.api.domain.HealthCenterInfo;

@Mapper
public interface HealthCenterInfoMapper {
    @Select("SELECT ID,IMAGE,TITLE,CREATETIME,ISBANNER,ISICON FROM HEALTH_CENTER_INFO WHERE CENTERID=#{centerId} ORDER BY CREATETIME DESC")
    List<HealthCenterInfo> getByCenterId(int id);

    @Select("SELECT * FROM HEALTH_CENTER_INFO LIMIT 1")
    HealthCenterInfo getById(int id);

}
