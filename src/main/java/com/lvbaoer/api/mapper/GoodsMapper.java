/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lvbaoer.api.domain.Goods;

@Mapper
public interface GoodsMapper {
    @Select("SELECT * FROM GOODS WHERE ID=#{id} LIMIT 1")
    Goods getById(int id);

    @Select("SELECT * FROM GOODS WHERE TYPEID=#{id} LIMIT #{index},#{size}")
    List<Goods> getByTypeId(@Param("index") int index, @Param("size") int size, @Param("id") int id);
}
