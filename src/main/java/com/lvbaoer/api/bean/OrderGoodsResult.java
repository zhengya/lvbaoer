package com.lvbaoer.api.bean;

import java.util.List;

import com.lvbaoer.api.domain.Goods;
import com.lvbaoer.api.domain.OrderGoods;
import com.lvbaoer.api.domain.ReciveAddress;
import com.lvbaoer.api.domain.Standard;

public final class OrderGoodsResult {
	public ReciveAddress addr;
	public List<GoodsDetail> goodsDetail;
	public OrderGoods order;

	public static final class GoodsDetail {
		public Goods goods;
		public Standard standard;
		public int amount;
	}
}
