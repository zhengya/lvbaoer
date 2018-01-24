/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.service;

import java.util.List;

import com.lvbaoer.api.bean.GoodsResult;
import com.lvbaoer.api.bean.HealthMarketResult;
import com.lvbaoer.api.common.Page;
import com.lvbaoer.api.domain.Goods;
import com.lvbaoer.api.domain.GoodsType;
import com.lvbaoer.api.domain.ShopCart;

public interface GoodsService {
    GoodsResult getById(int id);

    int addShopCart(ShopCart cart);

    void deleteCart(int id);

    List<GoodsType> getHomeGoodsTypes();

    HealthMarketResult getGoodsTypes();

    Page<Goods> getGoodsByTypeId(Page<Goods> page, int typeId);
}
