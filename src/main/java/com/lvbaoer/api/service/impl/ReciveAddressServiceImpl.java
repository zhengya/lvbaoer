/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lvbaoer.api.bean.AddressParam;
import com.lvbaoer.api.domain.ReciveAddress;
import com.lvbaoer.api.mapper.ReciveAddressMapper;
import com.lvbaoer.api.service.ReciveAddressService;

@Component
public class ReciveAddressServiceImpl implements ReciveAddressService {
	@Autowired
	private ReciveAddressMapper reciveAddressMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int save(AddressParam addr, String userId) {
		final ReciveAddress recive = new ReciveAddress(addr, userId);
		reciveAddressMapper.save(recive);
		return recive.getId();
	}

	@Override
	public List<ReciveAddress> getAddrs(String userId) {
		return reciveAddressMapper.getAddrs(userId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(ReciveAddress addr) {
		reciveAddressMapper.update(addr);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(int id) {
		reciveAddressMapper.delete(id);
	}

}
