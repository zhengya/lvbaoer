package com.lvbaoer.api.domain;

import java.util.Date;

public class OrderServe extends BaseOrder {
	private static final long serialVersionUID = 4350869390770282638L;
	private String name;
	// 预约时间
	private Date time;
	private String phone;
	private int centerId;
	private int serveId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCenterId() {
		return centerId;
	}

	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}

	public int getServeId() {
		return serveId;
	}

	public void setServeId(int serveId) {
		this.serveId = serveId;
	}

}
