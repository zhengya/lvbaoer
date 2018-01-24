/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lvbaoer.api.bean.ServeResult;
import com.lvbaoer.api.domain.Serve;

@Mapper
public interface ServeMapper {
    @Select("SELECT * FROM SERVE ORDER BY SALES DESC")
    List<ServeResult> get();

    @Select("SELECT * FROM SERVE WHERE ID=#{id} LIMIT 1")
    Serve getById(int id);

    @Update("UPDATE SERVE SET SALES=#{sales} WHERE ID=#{id}")
    void updateSales(Serve serve);
}
