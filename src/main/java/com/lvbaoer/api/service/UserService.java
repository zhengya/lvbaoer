/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.service;

import javax.servlet.http.HttpServletResponse;

import com.lvbaoer.api.domain.User;

public interface UserService {
    User get(String id);

    boolean login(String code, HttpServletResponse response);
}
