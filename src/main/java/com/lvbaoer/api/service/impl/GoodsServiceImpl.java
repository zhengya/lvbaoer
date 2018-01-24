/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvbaoer.api.bean.GoodsResult;
import com.lvbaoer.api.bean.HealthMarketResult;
import com.lvbaoer.api.bean.HealthMarketResult.GoodsTypeTemp;
import com.lvbaoer.api.domain.Goods;
import com.lvbaoer.api.domain.GoodsType;
import com.lvbaoer.api.domain.ShopCart;
import com.lvbaoer.api.domain.Standard;
import com.lvbaoer.api.mapper.GoodsMapper;
import com.lvbaoer.api.mapper.GoodsTypeMapper;
import com.lvbaoer.api.mapper.ShopCartMapper;
import com.lvbaoer.api.mapper.StandardMapper;
import com.lvbaoer.api.service.GoodsService;

@Component
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private StandardMapper standardMapper;
    @Autowired
    private ShopCartMapper shopCartMapper;
    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    @Override
    public GoodsResult getById(int id) {
        final Goods goods = goodsMapper.getById(id);
        final List<Standard> standards = standardMapper.getByGoodsId(id);
        return new GoodsResult(goods, standards);
    }

    @Override
    public int addShopCart(ShopCart cart) {
        cart.setCreateTime(new Date());
        shopCartMapper.insert(cart);
        return cart.getId();
    }

    @Override
    public void deleteCart(int id) {
        shopCartMapper.delete(id);
    }

    @Override
    public List<GoodsType> getHomeGoodsTypes() {
        return goodsTypeMapper.getHomeTypes();
    }

    @Override
    public HealthMarketResult getGoodsTypes() {
        final HealthMarketResult result = new HealthMarketResult();
        final List<GoodsType> fatherTypes = goodsTypeMapper.getFatherTypes();
        for (GoodsType goodsType : fatherTypes) {
            final List<GoodsType> childTypes = goodsTypeMapper.getChildTypes(goodsType.getId());
            if (childTypes != null && childTypes.size() > 0) {
                final GoodsTypeTemp<GoodsType> temp = new GoodsTypeTemp<>();
                temp.type = goodsType;
                temp.child = childTypes;
                result.types.add(temp);
            } else {
                final List<Goods> goods = goodsMapper.getByTypeId(goodsType.getId());
                if (goods != null && goods.size() > 0) {
                    final GoodsTypeTemp<Goods> temp = new GoodsTypeTemp<>();
                    temp.type = goodsType;
                    temp.child = goods;
                    result.goods.add(temp);
                }
            }
        }
        return result;
    }

}
