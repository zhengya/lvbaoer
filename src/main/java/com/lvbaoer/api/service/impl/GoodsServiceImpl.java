/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvbaoer.api.bean.GoodsResult;
import com.lvbaoer.api.domain.Goods;
import com.lvbaoer.api.domain.Standard;
import com.lvbaoer.api.mapper.GoodsMapper;
import com.lvbaoer.api.mapper.StandardMapper;
import com.lvbaoer.api.service.GoodsService;

@Component
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private StandardMapper standardMapper;

	@Override
	public GoodsResult getById(int id) {
		final Goods goods = goodsMapper.getById(id);
		final List<Standard> standards = standardMapper.getByGoodsId(id);
		return new GoodsResult(goods, standards);
	}

}
