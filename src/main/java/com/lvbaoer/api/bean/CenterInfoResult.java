package com.lvbaoer.api.bean;

import java.time.Instant;

import com.lvbaoer.api.domain.HealthCenterInfo;

public final class CenterInfoResult {
    public int id;
    public String title;
    public String image;
    public Instant createTime;

    public CenterInfoResult() {

    }

    public CenterInfoResult(HealthCenterInfo healthCenterInfo) {
        this.id = healthCenterInfo.getId();
        this.title = healthCenterInfo.getTitle();
        this.image = healthCenterInfo.getImage();
        this.createTime = healthCenterInfo.getCreateTime();
    }
}
