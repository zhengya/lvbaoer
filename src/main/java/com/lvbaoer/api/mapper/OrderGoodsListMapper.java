/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.lvbaoer.api.domain.OrderGoodsList;

@Mapper
public interface OrderGoodsListMapper {
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "ID")
	@Insert("INSERT INTO ORDER_GOODS_LIST (STANDARDID,AMOUNT,ORDERID) VALUES (#{standardId},#{amount},#{orderId})")
	void insert(OrderGoodsList goods);

	@Select("SELECT * FROM ORDER_GOODS_LIST WHERE ORDERID=#{id}")
	List<OrderGoodsList> getByOrderId(int id);
}
