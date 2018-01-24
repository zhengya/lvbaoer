package com.lvbaoer.api.domain;

import java.io.Serializable;
import java.util.Date;

public class Serve implements Serializable {
    private static final long serialVersionUID = 6273990512558627364L;
    private int id;
    private String name;
    // 原始价格
    private float price;
    // 当前价格
    private float localPrice;
    private String images;
    private String headImage;
    private String content;
    private Date createTime;
    private int sales;

    public final int getSales() {
        return sales;
    }

    public final void setSales(int sales) {
        this.sales = sales;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
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

    public float getLocalPrice() {
        return localPrice;
    }

    public void setLocalPrice(float localPrice) {
        this.localPrice = localPrice;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
