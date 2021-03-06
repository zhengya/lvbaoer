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

import com.google.gson.Gson;
import com.lvbaoer.api.common.NetworkResult;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpRequest, HttpServletResponse response, FilterChain chain)
        throws ServletException, IOException {
        // 设置禁止缓存
        response.setCharacterEncoding("utf8");
        if (httpRequest.getRequestURI().startsWith("/v1/user/login")) {
            chain.doFilter(httpRequest, response);
            return;
        }
        final Cookie cookie = WebUtils.getCookie(httpRequest, "userId");
        if (cookie == null && !httpRequest.getRequestURI().startsWith("/v1/wx")) {
            ((HttpServletResponse) response).setStatus(403);
            NetworkResult<Object> result = new NetworkResult<>(NetworkResult.ACCESS_FORBIDDEN_ERROR_CODE, "no cookie");
            response.getWriter().write(new Gson().toJson(result));
            return; // 直接返回
        }
        if (cookie != null) {
            httpRequest.setAttribute("userId", cookie.getValue());
        }
        chain.doFilter(httpRequest, response);
    }

    @Override
    public void destroy() {
    }

}
