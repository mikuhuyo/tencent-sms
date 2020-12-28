package com.tencent.sms.generator;

/**
 * @author yuelimin
 * @software IntelliJ IDEA
 * @description 验证秘钥生成器
 * @since JDK 8
 */
public interface VerificationKeyGenerator {
    /**
     * 验证秘钥生成
     *
     * @param prefix 前缀
     * @return
     */
    String generate(String prefix);
}
