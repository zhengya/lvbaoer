/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lvbaoer.api.domain.Goods;

@Mapper
public interface GoodsMapper {
	@Select("SELECT * FROM GOODS WHERE ID=#{id} LIMIT 1")
	Goods getById(int id);
}
