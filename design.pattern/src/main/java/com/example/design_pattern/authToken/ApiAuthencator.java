package com.example.design_pattern.authToken;

public interface ApiAuthencator {

    CredentialStorage CREDENTIAL_STORAGE = new CredentialStorage() {
        @Override
        public String getPasswordByAppId() {
            return CredentialStorage.super.getPasswordByAppId();
        }
    };

    default void auth(String url) {
        auth(ApiRequest.createFromFullUrl(url));
    }

    default void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();

        AuthToken clientAuth = new AuthToken(token, timestamp);

        if (clientAuth.isExpired()) {
            throw new RuntimeException("token isExpired");
        }

        String passwordByAppId = CREDENTIAL_STORAGE.getPasswordByAppId();
        //生成服务端的token对比
        AuthToken serverAuth = AuthToken.create(apiRequest.getBaseUrl(), timestamp, passwordByAppId, appId);

        if (!serverAuth.match(clientAuth)) {
            throw new RuntimeException("token match fail");
        }

    }

}
