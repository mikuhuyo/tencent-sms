package com.tencent.sms.generator;

import java.util.UUID;

/**
 * @author yuelimin
 * @software IntelliJ IDEA
 * @description 唯一标识
 * @since JDK 8
 */
public class UUIDVerificationKeyGenerator implements VerificationKeyGenerator {
    @Override
    public String generate(String prefix) {
        String uuid = UUID.randomUUID().toString();
        return prefix + uuid.replaceAll("-", "");
    }
}
