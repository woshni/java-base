package com.example.design_pattern.authToken;

/**
 * 数据层
 */
public interface CredentialStorage {

    default String getPasswordByAppId() {
        return "123456";
    }
}
