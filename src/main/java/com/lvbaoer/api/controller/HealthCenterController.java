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
import com.lvbaoer.api.service.HealthCenterService;

@RestController
@RequestMapping("/v1/center")
public class HealthCenterController {
    @Autowired
    private HealthCenterService healthCenterService;

    @GetMapping("")
    public Callable<NetworkResult<Object>> getHealthCenters(final String province, final String city, final int id,
        final HttpServletRequest request, final HttpServletResponse response) {
        return new Callable<NetworkResult<Object>>() {
            @Override
            public NetworkResult<Object> call() throws Exception {
                return RsHelper.success(healthCenterService.getByAddr(province, city, id));
            }
        };
    }

    @GetMapping("/{id}")
    public Callable<NetworkResult<Object>> getHealthCenterInfos(@PathVariable final int id,
        final HttpServletRequest request, final HttpServletResponse response) {
        return new Callable<NetworkResult<Object>>() {
            @Override
            public NetworkResult<Object> call() throws Exception {
                return RsHelper.success(healthCenterService.getInfos(id));
            }
        };
    }

    @GetMapping("/title/{id}")
    public Callable<NetworkResult<Object>> getCenterTitle(@PathVariable final int id, final HttpServletRequest request,
        final HttpServletResponse response) {
        return new Callable<NetworkResult<Object>>() {
            @Override
            public NetworkResult<Object> call() throws Exception {
                return RsHelper.success(healthCenterService.getInfoById(id));
            }
        };
    }

}
