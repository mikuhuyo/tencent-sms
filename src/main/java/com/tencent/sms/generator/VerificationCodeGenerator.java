package com.tencent.sms.generator;

/**
 * @author yuelimin
 * @software IntelliJ IDEA
 * @description 验证码生成器
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
