/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lvbaoer.api.domain.Goods;

@Mapper
public interface GoodsMapper {
    @Select("SELECT * FROM GOODS WHERE ID=#{id} LIMIT 1")
    Goods getById(int id);

    @Select("SELECT * FROM GOODS WHERE TYPEID=#{id} LIMIT #{index},#{size}")
    List<Goods> getByTypeId(@Param("index") int index, @Param("size") int size, @Param("id") int id);

    @Update("UPDATE GOODS SET SALES=#{sales} WHERE ID=#{id}")
    void updateSales(Goods goods);

    @Select("SELECT * FROM GOODS ORDER BY SALES DESC LIMIT #{index},#{size}")
    List<Goods> getGoods(@Param("index") int index, @Param("size") int size);

}
