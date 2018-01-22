package com.lvbaoer.api.domain;

import java.io.Serializable;

/**
 * 购物车
 * 
 * @author zyt
 *
 */
public class ShopCart implements Serializable {
	private static final long serialVersionUID = -7146231161789198618L;
	private int id;
	private String userId;
	private int standardId;
	private int goodsId;
	private int amount;
	private OrderType type;

	public enum OrderType {
		SERVICE, GOODS
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getStandardId() {
		return standardId;
	}

	public void setStandardId(int standardId) {
		this.standardId = standardId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
