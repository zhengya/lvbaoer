/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.service;

import com.lvbaoer.api.bean.GoodsResult;
import com.lvbaoer.api.domain.ShopCart;

public interface GoodsService {
    GoodsResult getById(int id);

    int addShopCart(ShopCart cart);

    void deleteCart(int id);
}
