package com.lvbaoer.api.service;

import java.util.List;

import com.lvbaoer.api.bean.TitleResult;
import com.lvbaoer.api.common.Page;
import com.lvbaoer.api.domain.HealthTitle;

public interface HealthTitleService {
	List<TitleResult> getBanner();

	Page<TitleResult> get(Page<TitleResult> page);

	HealthTitle getById(int id);

	HealthTitle getTitle(int id);
	
	Page<TitleResult> getByUserId(Page<TitleResult> page, String id);
}
