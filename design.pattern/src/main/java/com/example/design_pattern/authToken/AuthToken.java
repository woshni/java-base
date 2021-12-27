package com.example.design_pattern.authToken;

import java.util.Base64;
import java.util.Date;
import java.util.Map;

/**
 * tocken解析类
 */
public class AuthToken {

    /**
     * 默认失效时间
     */
    private static final long DEFAULT_EXPIRE_TIME_INTERVAL = 1 * 60 * 1000;

    /**
     * token字符串
     */
    private String token;

    /**
     * 创建时间
     */
    private long createTime;

    /**
     * 过期毫秒值
     */
    private long expireTimeInterval;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expireTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expireTimeInterval = expireTimeInterval;
    }

    /**
     * 根据链接创建一个token
     *
     * @param baseUrl
     * @param createTime
     * @param params
     * @return
     */
    public static AuthToken create(String baseUrl, long createTime, String password, String appid) {
        String token = Base64.getEncoder().encodeToString((baseUrl + password + appid + createTime).getBytes());
        return new AuthToken(token, createTime);
    }

    public String getToken() {
        return token;
    }

    /**
     * 是否过期，当前时间在 创建时间+过期时间 之后，过期
     *
     * @return
     */
    public boolean isExpired() {
        return new Date().after(new Date(createTime + DEFAULT_EXPIRE_TIME_INTERVAL));
    }

    public boolean match(AuthToken authToken) {
        return token.equals(authToken.getToken());
    }
}
