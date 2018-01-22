/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.lvbaoer.api.domain.ShopCart;

@Mapper
public interface ShopCartMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "ID")
    @Insert("INSERT INTO SHOP_CART (USERID,STANDARDID,AMOUNT,CREATETIME) VALUES (#{userId},#{standardId},#{amount},#{createTime})")
    void insert(ShopCart cart);

    @Delete("DELETE FROM SHOP_CART WHERE ID=#{id}")
    void delete(int id);

}
