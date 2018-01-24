/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lvbaoer.api.domain.Banner;

@Mapper
public interface BannerMapper {
    @Select("SELECT * FROM BANNER")
    List<Banner> get();

}
