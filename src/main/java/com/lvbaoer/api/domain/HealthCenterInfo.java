/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.domain;

import java.io.Serializable;
import java.time.Instant;

public class HealthCenterInfo implements Serializable {
    private static final long serialVersionUID = -4457939143966046812L;
    private int id;
    private String title;
    private String image;
    private String content;
    private Instant createTime;
    // 0:否 ;1:是
    private int isBanner;
    private int isIcon;
    private int centerId;

    public final int getCenterId() {
        return centerId;
    }

    public final void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public final int getIsIcon() {
        return isIcon;
    }

    public final void setIsIcon(int isIcon) {
        this.isIcon = isIcon;
    }

    public final int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public final String getTitle() {
        return title;
    }

    public final void setTitle(String title) {
        this.title = title;
    }

    public final String getImage() {
        return image;
    }

    public final void setImage(String image) {
        this.image = image;
    }

    public final String getContent() {
        return content;
    }

    public final void setContent(String content) {
        this.content = content;
    }

    public final Instant getCreateTime() {
        return createTime;
    }

    public final void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public final int getIsBanner() {
        return isBanner;
    }

    public final void setIsBanner(int isBanner) {
        this.isBanner = isBanner;
    }
}
