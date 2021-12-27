package com.example.design_pattern.authToken;

import java.util.HashMap;
import java.util.Map;

public class ApiRequest {
    private String baseUrl;

    private String token;

    private String appId;

    private long timestamp;

    public ApiRequest(String baseUrl, String token, String appId, long timestamp) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    /**
     * 解析url 成为 ApiRequest 对象
     *
     * @param url
     * @return
     */
    public static ApiRequest createFromFullUrl(String url) {
        String[] split = url.split("\\?");
        String baseUrl = split[0];

        String[] paramsArr = split[1].split("&");
        Map<String, Object> params = new HashMap<>();
        for (String s : paramsArr) {
            String[] split1 = s.split("=");
            params.put(split1[0], split1[1]);
        }

        return new ApiRequest(baseUrl, (String) params.get("token"), (String) params.get("appId"), (long) params.get("timestamp"));
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getToken() {
        return token;
    }

    public String getAppId() {
        return appId;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
