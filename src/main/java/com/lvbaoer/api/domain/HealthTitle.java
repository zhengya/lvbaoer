/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

public class HealthTitle implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String title;
	private String image;
	private String content;
	private String video;
	private Type type;
	private int browerNum;
	private int commentNum;
	private Instant createTime;
	// 0:否 ;1:是
	private int isBanner;

	public enum Type {
		IMAGE, VIDEO
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

	public final String getVideo() {
		return video;
	}

	public final void setVideo(String video) {
		this.video = video;
	}

	public final Type getType() {
		return type;
	}

	public final void setType(Type type) {
		this.type = type;
	}

	public final int getBrowerNum() {
		return browerNum;
	}

	public final void setBrowerNum(int browerNum) {
		this.browerNum = browerNum;
	}

	public final int getCommentNum() {
		return commentNum;
	}

	public final void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
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
