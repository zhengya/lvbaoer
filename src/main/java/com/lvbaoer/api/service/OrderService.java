/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.service;

import java.text.ParseException;
import java.util.List;

import com.lvbaoer.api.bean.OrderGoodsParam;
import com.lvbaoer.api.bean.OrderGoodsResult;
import com.lvbaoer.api.bean.OrderServeParam;
import com.lvbaoer.api.bean.OrderServeResult;

public interface OrderService {
	int insertOrderServe(OrderServeParam param, String userId) throws ParseException;

	int insertOrderGoods(OrderGoodsParam param, String userId);

	OrderServeResult getOrderServeById(int id);

	List<OrderServeResult> getOrderServes(String type, String userId);

	OrderGoodsResult getOrderGoodsById(int id);
}
