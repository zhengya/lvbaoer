package com.lvbaoer.api.domain;

public class OrderGoods extends BaseOrder {
	private static final long serialVersionUID = -5668774973161831157L;
	// 物流公司
	private String deliveryName;
	// 物流单号
	private String deliveryNo;

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryNo() {
		return deliveryNo;
	}

	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}
}
