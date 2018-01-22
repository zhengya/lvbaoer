package com.lvbaoer.api.domain;

import java.io.Serializable;
import java.util.Date;

public class BaseOrder implements Serializable {
	private static final long serialVersionUID = -4604163142167563379L;
	private int id;
	private String userId;
	private String orderId;
	private String wxOrderId;
	// 订单状态
	private String status;
	private float price;
	// 下单时间
	private Date createTime;
	// 支付时间
	private Date payTime;
	// 完成时间
	private Date completeTime;
	// 收货地址
	private int addrId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getAddrId() {
		return addrId;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public String getWxOrderId() {
		return wxOrderId;
	}

	public void setWxOrderId(String wxOrderId) {
		this.wxOrderId = wxOrderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public enum Status {
		PREPARE_PAY("待付款"), PREPARE_RECEVICE("待收货"), COMPLETE("已完成");

		private String name;

		private Status(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

}
