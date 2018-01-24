package com.lvbaoer.api.domain;

import java.io.Serializable;
import java.time.Instant;

public class User implements Serializable {
	private static final long serialVersionUID = -1145056224186110285L;
	private String id;
	private String name;
	private String image;
	private Instant createTime;

	public Instant getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Instant createTime) {
		this.createTime = createTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
