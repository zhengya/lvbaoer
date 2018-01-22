package com.lvbaoer.api.domain;

import java.io.Serializable;

public class OrderGoodsList implements Serializable {
	private static final long serialVersionUID = 708564390720245388L;
	private int id;
	private int standardId;
	private int amount;
	private int orderId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}
