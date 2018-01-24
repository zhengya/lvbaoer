package com.lvbaoer.api.common;

public class WxConfig {
    public static final String GRANT_TYPE_KEY = "grant_type";
    public static final String GRANT_TYPE_VALUE = "client_credential";
    public static final String APP_ID_KEY = "appid";
    public static final String APP_ID = "wx007358d8d516321a";
    public static final String SECRET_KEY = "secret";
    public static final String SECRET = "5a38dd6729d7de15c1cab185bbb5210b";
    public static final String GET_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx007358d8d516321a&secret=5a38dd6729d7de15c1cab185bbb5210b";

    public static volatile String API_TOKEN;
    public static volatile long API_TOKEN_OVERTIME;

    public static String getUserTokenUrl(String code) {
        return "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx007358d8d516321a&secret=5a38dd6729d7de15c1cab185bbb5210b&code="
            + code + "&grant_type=authorization_code";
    }

    public static String getUserInfo(String token) {
        return "https://api.weixin.qq.com/sns/userinfo?access_token=" + token + "&openid=OPENID&lang=zh_CN";
    }
}
