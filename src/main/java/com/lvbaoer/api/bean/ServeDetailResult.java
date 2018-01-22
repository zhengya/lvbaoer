package com.lvbaoer.api.bean;

import java.io.Serializable;

import com.lvbaoer.api.domain.Serve;

public final class ServeDetailResult implements Serializable {
	private static final long serialVersionUID = 6273990512558627364L;
	public int id;
	public String name;
	// 原始价格
	public float price;
	// 当前价格
	public float localPrice;
	public String[] images;
	public String content;

	public ServeDetailResult() {

	}

	public ServeDetailResult(Serve serve) {
		this.id = serve.getId();
		this.name = serve.getName();
		this.price = serve.getPrice();
		this.localPrice = serve.getLocalPrice();
		this.images = serve.getImages().split("___");
		this.content = serve.getContent();
	}

}
