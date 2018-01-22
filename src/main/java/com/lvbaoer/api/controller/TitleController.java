/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.controller;

import java.util.Date;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvbaoer.api.bean.CommentResult;
import com.lvbaoer.api.bean.TitleResult;
import com.lvbaoer.api.common.NetworkResult;
import com.lvbaoer.api.common.Page;
import com.lvbaoer.api.common.RsHelper;
import com.lvbaoer.api.domain.Comment;
import com.lvbaoer.api.service.CommentService;
import com.lvbaoer.api.service.HealthTitleService;

@RestController
@RequestMapping("/v1/title")
public class TitleController {
	@Autowired
	private HealthTitleService healthTitleService;
	@Autowired
	private CommentService commentService;

	@GetMapping("")
	public Callable<NetworkResult<Object>> get(final Page<TitleResult> page, final HttpServletRequest request,
			final HttpServletResponse response) {
		return new Callable<NetworkResult<Object>>() {
			@Override
			public NetworkResult<Object> call() throws Exception {
				return RsHelper.success(healthTitleService.get(page));
			}
		};
	}

	@GetMapping("/{id}")
	public Callable<NetworkResult<Object>> getById(@PathVariable final int id, final HttpServletRequest request,
			final HttpServletResponse response) {
		return new Callable<NetworkResult<Object>>() {
			@Override
			public NetworkResult<Object> call() throws Exception {
				return RsHelper.success(healthTitleService.getTitle(id));
			}
		};
	}

	@GetMapping("/banner")
	public Callable<NetworkResult<Object>> getBanner(final HttpServletRequest request,
			final HttpServletResponse response) {
		return new Callable<NetworkResult<Object>>() {
			@Override
			public NetworkResult<Object> call() throws Exception {
				return RsHelper.success(healthTitleService.getBanner());
			}
		};
	}

	@GetMapping("/comments/{id}")
	public Callable<NetworkResult<Object>> getComments(@PathVariable final int id, final Page<CommentResult> page,
			final HttpServletRequest request, final HttpServletResponse response) {
		return new Callable<NetworkResult<Object>>() {
			@Override
			public NetworkResult<Object> call() throws Exception {
				return RsHelper.success(commentService.get(page, id));
			}
		};
	}

	@PutMapping("/comment")
	public Callable<NetworkResult<Object>> insertComment(@RequestBody final Comment comment,
			final HttpServletRequest request, final HttpServletResponse response) {
		return new Callable<NetworkResult<Object>>() {
			@Override
			public NetworkResult<Object> call() throws Exception {
				comment.setUserId((String) request.getAttribute("userId"));
				comment.setCreateTime(new Date());
				return RsHelper.success(commentService.insert(comment));
			}
		};
	}

}
