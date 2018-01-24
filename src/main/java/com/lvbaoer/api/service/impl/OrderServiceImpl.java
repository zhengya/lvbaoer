/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.lvbaoer.api.bean.OrderGoodsParam;
import com.lvbaoer.api.bean.OrderGoodsResult;
import com.lvbaoer.api.bean.OrderGoodsResult.GoodsDetail;
import com.lvbaoer.api.bean.OrderServeParam;
import com.lvbaoer.api.bean.OrderServeResult;
import com.lvbaoer.api.domain.BaseOrder.Status;
import com.lvbaoer.api.domain.Goods;
import com.lvbaoer.api.domain.OrderGoods;
import com.lvbaoer.api.domain.OrderGoodsList;
import com.lvbaoer.api.domain.OrderServe;
import com.lvbaoer.api.domain.Serve;
import com.lvbaoer.api.domain.Standard;
import com.lvbaoer.api.mapper.GoodsMapper;
import com.lvbaoer.api.mapper.HealthCenterMapper;
import com.lvbaoer.api.mapper.OrderGoodsListMapper;
import com.lvbaoer.api.mapper.OrderGoodsMapper;
import com.lvbaoer.api.mapper.OrderServeMapper;
import com.lvbaoer.api.mapper.ReciveAddressMapper;
import com.lvbaoer.api.mapper.ServeMapper;
import com.lvbaoer.api.mapper.StandardMapper;
import com.lvbaoer.api.service.OrderService;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ServeMapper serveMapper;
    @Autowired
    private OrderServeMapper orderServeMapper;
    @Autowired
    private ReciveAddressMapper reciveAddressMapper;
    @Autowired
    private HealthCenterMapper healthCenterMapper;
    @Autowired
    private StandardMapper standardMapper;
    @Autowired
    private OrderGoodsListMapper orderGoodsListMapper;
    @Autowired
    private OrderGoodsMapper orderGoodsMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertOrderServe(OrderServeParam param, String userId) throws ParseException {
        final Serve serve = serveMapper.getById(param.serveId);
        final OrderServe order = new OrderServe();
        order.setUserId(userId);
        order.setOrderId(System.currentTimeMillis() + "");
        // TODO 临时设为已完成
        order.setStatus(Status.COMPLETE.getName());
        order.setPrice(serve.getLocalPrice() <= 0 ? serve.getPrice() : serve.getLocalPrice());
        order.setCreateTime(new Date());
        order.setAddrId(param.addrId);
        order.setName(param.name);
        order.setPhone(param.phone);
        order.setTime(format.parse(param.time));
        order.setCenterId(param.centerId);
        // TODO 临时设置微信支付号
        order.setWxOrderId("test");
        order.setServeId(serve.getId());
        orderServeMapper.insert(order);
        serve.setSales(serve.getSales() + 1);
        serveMapper.updateSales(serve);
        return order.getId();
    }

    @Override
    public OrderServeResult getOrderServeById(int id) {
        final OrderServe order = orderServeMapper.getById(id);
        if (order != null) {
            return getOrderServeResult(order);
        }
        return null;
    }

    private OrderServeResult getOrderServeResult(OrderServe order) {
        final OrderServeResult result = new OrderServeResult();
        result.order = order;
        result.addr = reciveAddressMapper.getAddrsById(order.getAddrId());
        result.serve = serveMapper.getById(order.getServeId());
        result.center = healthCenterMapper.getById(order.getCenterId());
        return result;
    }

    @Override
    public List<OrderServeResult> getOrderServes(String type, String userId) {
        if (StringUtils.isEmpty(type)) {
            return null;
        }
        List<OrderServe> orders = null;
        switch (type.toLowerCase()) {
        case "pre":
            orders = orderServeMapper.getPreByUserId(userId);
            break;
        case "aft":
            orders = orderServeMapper.getAftByUserId(userId);
            break;
        default:
            break;
        }
        if (orders != null && orders.size() > 0) {
            final List<OrderServeResult> result = new ArrayList<>(orders.size());
            for (OrderServe order : orders) {
                result.add(getOrderServeResult(order));
            }
            return result;
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertOrderGoods(OrderGoodsParam param, String userId) {
        float price = 0;
        for (OrderGoodsList goods : param.goods) {
            final Standard standard = standardMapper.getById(goods.getStandardId());
            price += standard.getPrice() * goods.getAmount();
            final Goods goodsTemp = goodsMapper.getById(standard.getGoodsId());
            goodsTemp.setSales(goodsTemp.getSales() + 1);
            goodsMapper.updateSales(goodsTemp);
        }
        final OrderGoods order = new OrderGoods();
        order.setUserId(userId);
        order.setOrderId(System.currentTimeMillis() + "");
        // TODO 临时设为已完成
        order.setStatus(Status.COMPLETE.getName());
        order.setPrice(price);
        order.setCreateTime(new Date());
        order.setAddrId(param.addrId);
        // TODO 临时设置微信支付号
        order.setWxOrderId("test");
        orderGoodsMapper.insert(order);
        for (OrderGoodsList goods : param.goods) {
            goods.setOrderId(order.getId());
            orderGoodsListMapper.insert(goods);
        }
        return order.getId();
    }

    @Override
    public OrderGoodsResult getOrderGoodsById(int id) {
        final OrderGoods order = orderGoodsMapper.getById(id);
        if (order != null) {
            return getOrderGoodsResult(order);
        }
        return null;
    }

    private OrderGoodsResult getOrderGoodsResult(OrderGoods order) {
        final OrderGoodsResult result = new OrderGoodsResult();
        result.order = order;
        result.addr = reciveAddressMapper.getAddrsById(order.getAddrId());
        final List<OrderGoodsList> goodsList = orderGoodsListMapper.getByOrderId(order.getId());
        result.goodsDetail = new ArrayList<>(goodsList.size());
        for (OrderGoodsList goods : goodsList) {
            final GoodsDetail detail = new GoodsDetail();
            detail.amount = goods.getAmount();
            detail.standard = standardMapper.getById(goods.getStandardId());
            detail.goods = goodsMapper.getById(detail.standard.getGoodsId());
            result.goodsDetail.add(detail);
        }
        return result;
    }

}
