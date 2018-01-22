/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvbaoer.api.bean.CommentResult;
import com.lvbaoer.api.common.Page;
import com.lvbaoer.api.domain.Comment;
import com.lvbaoer.api.domain.HealthTitle;
import com.lvbaoer.api.mapper.CommentMapper;
import com.lvbaoer.api.mapper.HealthTitleMapper;
import com.lvbaoer.api.service.CommentService;
import com.lvbaoer.api.service.HealthTitleService;

@Component
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private HealthTitleService healthTitleService;
	@Autowired
	private HealthTitleMapper healthTitleMapper;

	@Override
	public Page<CommentResult> get(Page<CommentResult> page, int id) {
		final List<CommentResult> items = commentMapper.get(page.getIndex(), page.getPageSize(), id);
		page.setItems(items);
		return page;
	}

	@Override
	public int insert(Comment comment) {
		commentMapper.insert(comment);
		final HealthTitle title = healthTitleService.getById(comment.getTitleId());
		title.setCommentNum(title.getCommentNum() + 1);
		healthTitleMapper.update(title);
		return comment.getId();
	}

}
