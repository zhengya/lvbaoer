/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lvbaoer.api.domain.GoodsType;

@Mapper
public interface GoodsTypeMapper {
    @Select("SELECT * FROM GOODS_TYPE WHERE GOODSTYPEID=0 AND ID!=1 ORDER BY RANK")
    List<GoodsType> getFatherTypes();

    @Select("SELECT * FROM GOODS_TYPE WHERE GOODSTYPEID=1 ORDER BY RANK DESC LIMIT 5")
    List<GoodsType> getHomeTypes();

    @Select("SELECT * FROM GOODS_TYPE WHERE GOODSTYPEID=#{id} ORDER BY RANK DESC")
    List<GoodsType> getChildTypes(int id);
}
