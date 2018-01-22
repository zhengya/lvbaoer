/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.lvbaoer.api.domain.OrderServe;

@Mapper
public interface OrderServeMapper {
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "ID")
	@Insert("INSERT INTO ORDER_SERVE (USERID,ORDERID,WXORDERID,STATUS,PRICE,CREATETIME,ADDRID,NAME,PHONE,TIME,CENTERID,SERVEID) "
			+ "VALUES (#{userId},#{orderId},#{wxOrderId},#{status},#{price},#{createTime},#{addrId},#{name},#{phone},#{time},#{centerId},#{serveId})")
	void insert(OrderServe order);

	@Select("SELECT * FROM ORDER_SERVE WHERE ID=#{id} LIMIT 1")
	OrderServe getById(int id);

	@Select("SELECT * FROM ORDER_SERVE WHERE STATUS='已完成' AND USERID=#{userId} AND TIME<=NOW()")
	List<OrderServe> getPreByUserId(String userId);

	@Select("SELECT * FROM ORDER_SERVE WHERE STATUS='已完成' AND USERID=#{userId} AND TIME>NOW()")
	List<OrderServe> getAftByUserId(String userId);
}
