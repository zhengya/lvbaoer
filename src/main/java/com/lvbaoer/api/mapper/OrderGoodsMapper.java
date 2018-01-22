/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.lvbaoer.api.domain.OrderGoods;

@Mapper
public interface OrderGoodsMapper {
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "ID")
	@Insert("INSERT INTO ORDER_GOODS (USERID,ORDERID,WXORDERID,STATUS,PRICE,CREATETIME,ADDRID) "
			+ "VALUES (#{userId},#{orderId},#{wxOrderId},#{status},#{price},#{createTime},#{addrId})")
	void insert(OrderGoods order);
	
	@Select("SELECT * FROM ORDER_GOODS WHERE ID=#{id} LIMIT 1")
	OrderGoods getById(int id);
}
