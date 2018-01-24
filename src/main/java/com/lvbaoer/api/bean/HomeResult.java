package com.lvbaoer.api.bean;

import java.util.List;

import com.lvbaoer.api.domain.Banner;
import com.lvbaoer.api.domain.GoodsType;

public final class HomeResult {
    public List<Banner> banners;
    public List<GoodsType> goods;
    public List<TitleResult> title;
}
