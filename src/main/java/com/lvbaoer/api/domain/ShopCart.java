package com.lvbaoer.api.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 购物车
 * 
 * @author zyt
 *
 */
public class ShopCart implements Serializable {
    private static final long serialVersionUID = -7146231161789198618L;
    private int id;
    private String userId;
    private int standardId;
    private int amount;
    private Date createTime;

    public final Date getCreateTime() {
        return createTime;
    }

    public final void setCreateTime(Date createTime) {
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

    public int getStandardId() {
        return standardId;
    }

    public void setStandardId(int standardId) {
        this.standardId = standardId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
