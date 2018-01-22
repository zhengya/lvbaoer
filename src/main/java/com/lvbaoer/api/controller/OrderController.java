/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.controller;

import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvbaoer.api.bean.OrderGoodsParam;
import com.lvbaoer.api.bean.OrderServeParam;
import com.lvbaoer.api.common.NetworkResult;
import com.lvbaoer.api.common.RsHelper;
import com.lvbaoer.api.service.OrderService;

@RestController
@RequestMapping("/v1/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PutMapping("/serve")
	public Callable<NetworkResult<Object>> insertOrderServe(@RequestBody final OrderServeParam orderServeParam,
			final HttpServletRequest request, final HttpServletResponse response) {
		return new Callable<NetworkResult<Object>>() {
			@Override
			public NetworkResult<Object> call() throws Exception {
				return RsHelper.success(
						orderService.insertOrderServe(orderServeParam, (String) request.getAttribute("userId")));
			}
		};
	}

	@GetMapping("/serve/{id}")
	public Callable<NetworkResult<Object>> getOrderServe(@PathVariable final int id, final HttpServletRequest request,
			final HttpServletResponse response) {
		return new Callable<NetworkResult<Object>>() {
			@Override
			public NetworkResult<Object> call() throws Exception {
				return RsHelper.success(orderService.getOrderServeById(id));
			}
		};
	}

	@GetMapping("/serves")
	public Callable<NetworkResult<Object>> getOrderServes(final String type, final HttpServletRequest request,
			final HttpServletResponse response) {
		return new Callable<NetworkResult<Object>>() {
			@Override
			public NetworkResult<Object> call() throws Exception {
				return RsHelper.success(orderService.getOrderServes(type, (String) request.getAttribute("userId")));
			}
		};
	}

	@PutMapping("/goods")
	public Callable<NetworkResult<Object>> insertOrderGoods(@RequestBody final OrderGoodsParam orderGoodsParam,
			final HttpServletRequest request, final HttpServletResponse response) {
		return new Callable<NetworkResult<Object>>() {
			@Override
			public NetworkResult<Object> call() throws Exception {
				return RsHelper.success(
						orderService.insertOrderGoods(orderGoodsParam, (String) request.getAttribute("userId")));
			}
		};
	}

	@GetMapping("/goods/{id}")
	public Callable<NetworkResult<Object>> getOrderGoods(@PathVariable final int id, final HttpServletRequest request,
			final HttpServletResponse response) {
		return new Callable<NetworkResult<Object>>() {
			@Override
			public NetworkResult<Object> call() throws Exception {
				return RsHelper.success(orderService.getOrderGoodsById(id));
			}
		};
	}
}
