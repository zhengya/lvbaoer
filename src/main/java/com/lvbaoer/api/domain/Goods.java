package com.lvbaoer.api.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 健康超市商品
 * 
 * @author zyt
 *
 */
public class Goods implements Serializable {
	private static final long serialVersionUID = 635849806619654526L;
	private int id;
	private int typeId;
	private String name;
	private float price;
	private float localPrice;
	private String headImage;
	private String images;
	private String content;
	private Date createTime;

	public float getLocalPrice() {
		return localPrice;
	}

	public void setLocalPrice(float localPrice) {
		this.localPrice = localPrice;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
