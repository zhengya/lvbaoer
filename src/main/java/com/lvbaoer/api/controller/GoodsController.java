/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.controller;

import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvbaoer.api.common.NetworkResult;
import com.lvbaoer.api.common.RsHelper;
import com.lvbaoer.api.domain.ShopCart;
import com.lvbaoer.api.service.GoodsService;

@RestController
@RequestMapping("/v1/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/{id}")
    public Callable<NetworkResult<Object>> getHealthCenters(@PathVariable final int id,
        final HttpServletRequest request, final HttpServletResponse response) {
        return new Callable<NetworkResult<Object>>() {
            @Override
            public NetworkResult<Object> call() throws Exception {
                return RsHelper.success(goodsService.getById(id));
            }
        };
    }

    @PutMapping("/cart")
    public Callable<NetworkResult<Object>> addShopCart(@RequestBody final ShopCart cart,
        final HttpServletRequest request, final HttpServletResponse response) {
        return new Callable<NetworkResult<Object>>() {
            @Override
            public NetworkResult<Object> call() throws Exception {
                cart.setUserId((String) request.getAttribute("userId"));
                return RsHelper.success(goodsService.addShopCart(cart));
            }
        };
    }

    @DeleteMapping("/cart/{id}")
    public Callable<NetworkResult<Object>> delShopCart(@PathVariable final int id, final HttpServletRequest request,
        final HttpServletResponse response) {
        return new Callable<NetworkResult<Object>>() {
            @Override
            public NetworkResult<Object> call() throws Exception {
                goodsService.deleteCart(id);
                return RsHelper.success(true);
            }
        };
    }

}
