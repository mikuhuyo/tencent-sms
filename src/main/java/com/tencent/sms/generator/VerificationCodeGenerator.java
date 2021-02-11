package com.tencent.sms.generator;

/**
 * <p>
 * 验证码生成器
 * </p>
 *
 * @author yuelimin
 * @since JDK 8
 */
public interface VerificationCodeGenerator {

    /**
     * 认证码生成
     *
     * @return
     */
    String generate();
}
