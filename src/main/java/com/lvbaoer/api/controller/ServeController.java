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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvbaoer.api.common.NetworkResult;
import com.lvbaoer.api.common.RsHelper;
import com.lvbaoer.api.service.ServeService;

@RestController
@RequestMapping("/v1/serve")
public class ServeController {
	@Autowired
	private ServeService serveService;

	@GetMapping("")
	public Callable<NetworkResult<Object>> getServes(final HttpServletRequest request,
			final HttpServletResponse response) {
		return new Callable<NetworkResult<Object>>() {
			@Override
			public NetworkResult<Object> call() throws Exception {
				return RsHelper.success(serveService.get());
			}
		};
	}

	@GetMapping("/{id}")
	public Callable<NetworkResult<Object>> getServe(@PathVariable final int id, final HttpServletRequest request,
			final HttpServletResponse response) {
		return new Callable<NetworkResult<Object>>() {
			@Override
			public NetworkResult<Object> call() throws Exception {
				return RsHelper.success(serveService.getDetailById(id));
			}
		};
	}

}
