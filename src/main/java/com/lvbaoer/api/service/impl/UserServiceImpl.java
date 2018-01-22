/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvbaoer.api.domain.User;
import com.lvbaoer.api.mapper.UserMapper;
import com.lvbaoer.api.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User get(String id) {
		return userMapper.getById(id);
	}

}
