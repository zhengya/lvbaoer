/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.controller;

import java.io.IOException;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvbaoer.api.common.NetworkResult;
import com.lvbaoer.api.common.RsHelper;
import com.lvbaoer.api.service.WxService;

@RestController
@RequestMapping("/v1/wx")
public class WxController {
    @Autowired
    private WxService wxService;

    @GetMapping("/token")
    public Callable<NetworkResult<Object>> getApiToken(final HttpServletRequest request,
        final HttpServletResponse response) {
        return new Callable<NetworkResult<Object>>() {
            @Override
            public NetworkResult<Object> call() throws Exception {
                return RsHelper.success(wxService.getApiToken());
            }
        };
    }

    @GetMapping("/login")
    public Callable<NetworkResult<Object>> login(final String code, final HttpServletRequest request,
        final HttpServletResponse response) {
        return new Callable<NetworkResult<Object>>() {
            @Override
            public NetworkResult<Object> call() throws Exception {
                response.sendRedirect("http://beevane.cn/");
                return null;
            }
        };
    }

}
