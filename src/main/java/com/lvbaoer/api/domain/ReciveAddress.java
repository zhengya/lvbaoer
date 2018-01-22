package com.lvbaoer.api.domain;

import java.io.Serializable;
import java.util.Date;

import com.lvbaoer.api.bean.AddressParam;

public class ReciveAddress implements Serializable {
	private static final long serialVersionUID = 9004015531637960939L;
	private int id;
	private String userId;
	private String name;
	private String phone;
	private String province;
	private String city;
	private String area;
	private String detail;
	private Date createTime;

	public ReciveAddress(AddressParam addr, String userId) {
		this.userId = userId;
		this.name = addr.name;
		this.phone = addr.phone;
		this.province = addr.province;
		this.city = addr.city;
		this.area = addr.area;
		this.detail = addr.detail;
		this.createTime = new Date();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public ReciveAddress() {

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
