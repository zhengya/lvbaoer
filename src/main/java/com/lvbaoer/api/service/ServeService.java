/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.service;

import java.util.List;

import com.lvbaoer.api.bean.ServeDetailResult;
import com.lvbaoer.api.bean.ServeResult;
import com.lvbaoer.api.domain.Serve;

public interface ServeService {
	List<ServeResult> get();

	Serve getById(int id);
	
	ServeDetailResult getDetailById(int id);
}
