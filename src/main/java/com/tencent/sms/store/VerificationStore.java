package com.tencent.sms.store;

/**
 * @author yuelimin
 * @software IntelliJ IDEA
 * @description 验证信息存储key value
 * @since JDK 8
 */
public interface VerificationStore {
    void set(String key, String value, Integer expire);

    String get(String key);
}
