package com.lvbaoer.api.domain;

import java.io.Serializable;
import java.util.Date;

public class GoodsType implements Serializable {
    private static final long serialVersionUID = -1585400036995044117L;
    private int id;
    private String name;
    private String url;
    private String image;
    private int rank;
    private Date createTime;
    private int isHome;

    public final int getIsHome() {
        return isHome;
    }

    public final void setIsHome(int isHome) {
        this.isHome = isHome;
    }

    public final int getRank() {
        return rank;
    }

    public final void setRank(int rank) {
        this.rank = rank;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
