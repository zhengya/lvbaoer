/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.lvbaoer.api.bean.TitleResult;
import com.lvbaoer.api.common.Page;
import com.lvbaoer.api.domain.HealthTitle;
import com.lvbaoer.api.mapper.HealthTitleMapper;
import com.lvbaoer.api.service.HealthTitleService;

@Component
public class HealthTitleServiceImpl implements HealthTitleService {
	@Autowired
	private HealthTitleMapper healthTitleMapper;

	@Override
	public List<TitleResult> getBanner() {
		final List<TitleResult> banner = healthTitleMapper.getBanner();
		if (banner != null && banner.size() > 0) {
			final Iterator<TitleResult> it = banner.iterator();
			while (it.hasNext()) {
				final TitleResult title = it.next();
				if (!StringUtils.isEmpty(title.image)) {
					title.image = title.image.split("___")[0];
				}
			}
		}
		return banner;
	}

	@Override
	public Page<TitleResult> get(Page<TitleResult> page) {
		final List<TitleResult> items = healthTitleMapper.get(page.getIndex(), page.getPageSize());
		if (items != null && items.size() > 0) {
			final Iterator<TitleResult> it = items.iterator();
			while (it.hasNext()) {
				final TitleResult title = it.next();
				if (!StringUtils.isEmpty(title.image)) {
					title.images = title.image.split("___");
				}
			}
		}
		page.setItems(items);
		return page;
	}

	@Override
	public HealthTitle getById(int id) {
		return healthTitleMapper.getById(id);
	}

	@Override
	public HealthTitle getTitle(int id) {
		final HealthTitle healthTitle = getById(id);
		healthTitle.setBrowerNum(healthTitle.getBrowerNum() + 1);
		healthTitleMapper.update(healthTitle);
		return healthTitle;
	}

	@Override
	public Page<TitleResult> getByUserId(Page<TitleResult> page, String id) {
		final List<TitleResult> titles = healthTitleMapper.getByUserId(id);
		if (titles != null && titles.size() > 0) {
			final Iterator<TitleResult> it = titles.iterator();
			while (it.hasNext()) {
				final TitleResult title = it.next();
				if (!StringUtils.isEmpty(title.image)) {
					title.image = title.image.split("___")[0];
				}
			}
			page.setItems(titles);
		}
		return page;
	}

}
