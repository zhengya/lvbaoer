
package com.lvbaoer.api.bean;

import java.util.Date;

import com.lvbaoer.api.domain.HealthTitle.Type;

public final class TitleResult {
	public int id;
	public String title;
	public String image;
	public String[] images;
	public Date createTime;
	public Type type;
	public int browerNum;
	public int commentNum;
}
