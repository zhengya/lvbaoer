package com.lvbaoer.api.bean;

import com.google.gson.Gson;
import com.lvbaoer.api.domain.OrderGoodsList;

public final class OrderGoodsParam {
	public int addrId;
	public OrderGoodsList[] goods;

	public static void main(String[] args) {
		OrderGoodsParam orderGoodsParam = new OrderGoodsParam();
		orderGoodsParam.addrId = 2;
		orderGoodsParam.goods = new OrderGoodsList[2];
		orderGoodsParam.goods[0] = new OrderGoodsList();
		orderGoodsParam.goods[0].setStandardId(1);
		orderGoodsParam.goods[0].setAmount(1);
		orderGoodsParam.goods[1] = new OrderGoodsList();
		orderGoodsParam.goods[1].setStandardId(8);
		orderGoodsParam.goods[1].setAmount(1);
		System.out.println(new Gson().toJson(orderGoodsParam));
	}

}
