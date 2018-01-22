/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lvbaoer.api.domain.HealthCenter;

@Mapper
public interface HealthCenterMapper {
	@Select("SELECT * FROM HEALTH_CENTER WHERE PROVINCE=#{province} AND CITY=#{city}")
	List<HealthCenter> getByAddr(@Param("province") String province, @Param("city") String city);

	@Select("SELECT * FROM HEALTH_CENTER WHERE PROVINCE=#{province} AND CITY=#{city} AND SERVES LIKE '%${serve}%'")
	List<HealthCenter> getByAddrAndServe(@Param("province") String province, @Param("city") String city,
			@Param("serve") String serve);

	@Select("SELECT * FROM HEALTH_CENTER WHERE ID=#{id}")
	HealthCenter getById(int id);
}
