package com.lvbaoer.api.service;

import com.lvbaoer.api.bean.CommentResult;
import com.lvbaoer.api.common.Page;
import com.lvbaoer.api.domain.Comment;

public interface CommentService {

	Page<CommentResult> get(Page<CommentResult> page, int id);

	int insert(Comment comment);

}
