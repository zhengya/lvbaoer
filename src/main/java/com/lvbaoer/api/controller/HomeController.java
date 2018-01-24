/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.controller;

import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvbaoer.api.bean.HomeResult;
import com.lvbaoer.api.common.NetworkResult;
import com.lvbaoer.api.common.RsHelper;
import com.lvbaoer.api.mapper.BannerMapper;
import com.lvbaoer.api.service.GoodsService;
import com.lvbaoer.api.service.HealthTitleService;

@RestController
@RequestMapping("/v1/home")
public class HomeController {
    @Autowired
    private BannerMapper bannerMapper;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private HealthTitleService healthTitleService;

    @GetMapping("")
    public Callable<NetworkResult<Object>> getGoods(final HttpServletRequest request,
        final HttpServletResponse response) {
        return new Callable<NetworkResult<Object>>() {
            @Override
            public NetworkResult<Object> call() throws Exception {
                final HomeResult result = new HomeResult();
                result.banners = bannerMapper.get();
                result.goods = goodsService.getHomeGoodsTypes();
                result.title = healthTitleService.getBanner();
                return RsHelper.success(result);
            }
        };
    }

}
