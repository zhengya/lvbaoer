package com.lvbaoer.api.bean;

import java.util.ArrayList;
import java.util.List;

import com.lvbaoer.api.domain.Goods;
import com.lvbaoer.api.domain.GoodsType;

public final class HealthMarketResult {
    public List<GoodsTypeTemp<GoodsType>> types;
    public List<GoodsTypeTemp<Goods>> goods;

    public HealthMarketResult() {
        this.types = new ArrayList<>();
        this.goods = new ArrayList<>();
    }

    public static final class GoodsTypeTemp<T> {
        public GoodsType type;
        public List<T> child;

    }
}
