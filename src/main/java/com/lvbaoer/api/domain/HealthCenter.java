package com.lvbaoer.api.domain;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

/**
 * 体检中心
 * 
 * @author zyt
 *
 */
public class HealthCenter implements Serializable {
	private static final long serialVersionUID = 5595162999990639282L;
	private int id;
	private String name;
	private String shortName;
	private LocalTime workStartTime;
	private LocalTime workEndTime;
	private String restTime;
	private String province;
	private String city;
	private String area;
	private String detail;
	private String image;
	// 服务列表，以^开头+服务id+$结束
	private String serves;
	private Date createTime;

	public String getServes() {
		return serves;
	}

	public void setServes(String serves) {
		this.serves = serves;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public LocalTime getWorkStartTime() {
		return workStartTime;
	}

	public void setWorkStartTime(LocalTime workStartTime) {
		this.workStartTime = workStartTime;
	}

	public LocalTime getWorkEndTime() {
		return workEndTime;
	}

	public void setWorkEndTime(LocalTime workEndTime) {
		this.workEndTime = workEndTime;
	}

	public String getRestTime() {
		return restTime;
	}

	public void setRestTime(String restTime) {
		this.restTime = restTime;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
