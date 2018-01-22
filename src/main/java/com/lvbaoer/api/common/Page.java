/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.common;

import java.io.Serializable;
import java.util.List;

/**
 * TODO 通用分页对象.
 * 
 * @author kai
 *
 */
public class Page<E> implements Serializable {
	private static final long serialVersionUID = -6328576888173456966L;

	public static final Integer PAGESIZE = 1;

	private int pageSize = PAGESIZE;
	private int pageNo = 1;
	private List<E> items;

	public int getIndex() {
		return (pageNo - 1) * pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<E> getItems() {
		return items;
	}

	public void setItems(List<E> items) {
		this.items = items;
	}
}
