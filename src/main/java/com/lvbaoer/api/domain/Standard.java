package com.lvbaoer.api.domain;

import java.io.Serializable;

/**
 * 规格
 * 
 * @author zyt
 *
 */
public class Standard implements Serializable {
	private static final long serialVersionUID = 7228506342679439041L;
	private int id;
	private int goodsId;
	private String name;
	private float price;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
