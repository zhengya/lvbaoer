/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lvbaoer.api.domain.Standard;

@Mapper
public interface StandardMapper {
	@Select("SELECT * FROM STANDARD WHERE GOODSID=#{id}")
	List<Standard> getByGoodsId(int id);

	@Select("SELECT * FROM STANDARD WHERE ID=#{id}")
	Standard getById(int id);
}
