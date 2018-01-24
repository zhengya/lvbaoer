/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.controller;

import java.util.concurrent.Callable;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvbaoer.api.bean.AddressParam;
import com.lvbaoer.api.bean.TitleResult;
import com.lvbaoer.api.common.NetworkResult;
import com.lvbaoer.api.common.Page;
import com.lvbaoer.api.common.RsHelper;
import com.lvbaoer.api.domain.ReciveAddress;
import com.lvbaoer.api.service.HealthTitleService;
import com.lvbaoer.api.service.ReciveAddressService;
import com.lvbaoer.api.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ReciveAddressService reciveAddressService;
    @Autowired
    private HealthTitleService healthTitleService;

    @GetMapping("/login")
    public Callable<NetworkResult<Object>> login(final String code, final HttpServletRequest request,
        final HttpServletResponse response) {
        return new Callable<NetworkResult<Object>>() {
            @Override
            public NetworkResult<Object> call() throws Exception {
                return RsHelper.success(userService.login(code, response));
            }
        };
    }

    @GetMapping("")
    public Callable<NetworkResult<Object>> getUserInfo(final HttpServletRequest request,
        final HttpServletResponse response) {
        return new Callable<NetworkResult<Object>>() {
            @Override
            public NetworkResult<Object> call() throws Exception {
                return RsHelper.success(userService.get((String) request.getAttribute("userId")));
            }
        };
    }

    @PutMapping("/addr")
    public Callable<NetworkResult<Object>> insertAddr(@RequestBody final AddressParam addressParam,
        final HttpServletRequest request, final HttpServletResponse response) {
        return new Callable<NetworkResult<Object>>() {
            @Override
            public NetworkResult<Object> call() throws Exception {
                return RsHelper
                    .success(reciveAddressService.save(addressParam, (String) request.getAttribute("userId")));
            }
        };
    }

    @PostMapping("/addr")
    public Callable<NetworkResult<Object>> updateAddr(@RequestBody final ReciveAddress address,
        final HttpServletRequest request, final HttpServletResponse response) {
        return new Callable<NetworkResult<Object>>() {
            @Override
            public NetworkResult<Object> call() throws Exception {
                reciveAddressService.update(address);
                return RsHelper.success(true);
            }
        };
    }

    @GetMapping("/addrs")
    public Callable<NetworkResult<Object>> getAddr(final HttpServletRequest request,
        final HttpServletResponse response) {
        return new Callable<NetworkResult<Object>>() {
            @Override
            public NetworkResult<Object> call() throws Exception {
                Cookie cookie = new Cookie("userId", "user001");
                cookie.setPath("/");
                response.addCookie(cookie);
                return RsHelper.success(reciveAddressService.getAddrs((String) request.getAttribute("userId")));
            }
        };
    }

    @DeleteMapping("/addr/{id}")
    public Callable<NetworkResult<Object>> delAddr(@PathVariable final int id, final HttpServletRequest request,
        final HttpServletResponse response) {
        return new Callable<NetworkResult<Object>>() {
            @Override
            public NetworkResult<Object> call() throws Exception {
                reciveAddressService.delete(id);
                return RsHelper.success(true);
            }
        };
    }

    @GetMapping("/titles")
    public Callable<NetworkResult<Object>> getComments(final Page<TitleResult> page, final HttpServletRequest request,
        final HttpServletResponse response) {
        return new Callable<NetworkResult<Object>>() {
            @Override
            public NetworkResult<Object> call() throws Exception {
                return RsHelper.success(healthTitleService.getByUserId(page, (String) request.getAttribute("userId")));
            }
        };
    }
}
