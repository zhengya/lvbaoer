/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.service.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean login(String code, HttpServletResponse response) {
        /*final Map<String, String> map = CommonUtils.get(WxConfig.getUserTokenUrl(code));
        final String openId = map.get("openid");
        User user = this.get(openId);
        if (user == null) {
            user = new User();
            user.setId(openId);
            user.setCreateTime(Instant.now());
            userMapper.insert(user);
        }*/
        final Cookie cookie = new Cookie("userId", "user001");
        cookie.setPath("/");
        response.addCookie(cookie);
        return true;
    }

}
