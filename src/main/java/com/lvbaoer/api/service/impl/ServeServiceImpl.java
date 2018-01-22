/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvbaoer.api.bean.ServeDetailResult;
import com.lvbaoer.api.bean.ServeResult;
import com.lvbaoer.api.domain.Serve;
import com.lvbaoer.api.mapper.ServeMapper;
import com.lvbaoer.api.service.ServeService;

@Component
public class ServeServiceImpl implements ServeService {
	@Autowired
	private ServeMapper serveMapper;

	@Override
	public List<ServeResult> get() {
		return serveMapper.get();
	}

	@Override
	public Serve getById(int id) {
		return serveMapper.getById(id);
	}

	@Override
	public ServeDetailResult getDetailById(int id) {
		final Serve serve = getById(id);
		return new ServeDetailResult(serve);
	}

}
