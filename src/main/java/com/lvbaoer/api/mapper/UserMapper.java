/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lvbaoer.api.domain.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM USER WHERE ID=#{id} LIMIT 1")
	User getById(String id);
}
