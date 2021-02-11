package com.tencent.sms.generator;

/**
 * <p>
 * 验证秘钥生成器
 * </p>
 *
 * @author yuelimin
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
