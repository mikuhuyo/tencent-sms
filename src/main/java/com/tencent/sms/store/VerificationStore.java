package com.tencent.sms.store;

/**
 * <p>
 * 验证信息存储key value
 * </p>
 *
 * @author yuelimin
 * @since JDK 8
 */
public interface VerificationStore {
    void set(String key, String value, Integer expire);

    String get(String key);
}
