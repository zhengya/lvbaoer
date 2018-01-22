/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */

package com.lvbaoer.api.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest httpRequest, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		// 设置禁止缓存
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setCharacterEncoding("utf8");
		final Cookie cookie = WebUtils.getCookie(httpRequest, "userId");
		if(cookie==null) {
			return;
		}
		httpRequest.setAttribute("userId", cookie.getValue());
		chain.doFilter(httpRequest, response);
	}

	@Override
	public void destroy() {
	}

}
