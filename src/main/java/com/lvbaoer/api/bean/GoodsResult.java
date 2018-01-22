package com.lvbaoer.api.bean;

import java.util.List;

import com.lvbaoer.api.domain.Goods;
import com.lvbaoer.api.domain.Standard;

public final class GoodsResult {
	public Goods goods;
	public List<Standard> standards;

	public GoodsResult() {

	}

	public GoodsResult(Goods goods, List<Standard> standards) {
		this.goods = goods;
		this.standards = standards;
	}
}
