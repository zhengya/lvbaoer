/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.service.impl;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.lvbaoer.api.common.WxConfig;
import com.lvbaoer.api.service.WxService;
import com.lvbaoer.api.util.CommonUtils;

@Component
public class WxServiceImpl implements WxService {

    @Override
    public String getApiToken() {
        final long time = System.currentTimeMillis();
        if (time > WxConfig.API_TOKEN_OVERTIME) {
            final Map<String, String> map = CommonUtils.get(WxConfig.GET_TOKEN_URL);
            WxConfig.API_TOKEN = map.get("access_token");
            WxConfig.API_TOKEN_OVERTIME = time + 7200000;
        }
        return WxConfig.API_TOKEN;
    }

}
