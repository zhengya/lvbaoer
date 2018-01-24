package com.lvbaoer.api.util;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CommonUtils {
    /**
     * HttpClient get方法.
     * 
     */
    public static Map<String, String> get(String url) {
        CloseableHttpClient closeableHttpClient = null;
        try {
            final HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
            closeableHttpClient = httpClientBuilder.build();
            final HttpGet httpGet = new HttpGet(url);
            final HttpResponse response = closeableHttpClient.execute(httpGet);
            // 如果状态码为200,就是正常返回
            if (response.getStatusLine().getStatusCode() == 200) {
                String result = EntityUtils.toString(response.getEntity());
                return new Gson().fromJson(result, new TypeToken<Map<String, String>>() {
                }.getType());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (closeableHttpClient != null) {
                    closeableHttpClient.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }
}
