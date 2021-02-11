package com.tencent.sms.handler;

import com.tencent.sms.dto.VerificationInfo;
import com.tencent.sms.generator.VerificationCodeGenerator;
import com.tencent.sms.generator.VerificationKeyGenerator;
import com.tencent.sms.store.VerificationStore;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * <p>
 * 验证处理接口
 * </p>
 *
 * @author yuelimin
 * @since JDK 8
 */
public abstract class AbstractVerificationHandler {
    public abstract String getName();

    public abstract VerificationStore getVerificationStore();

    public abstract VerificationKeyGenerator getVerificationKeyGenerator();

    public abstract VerificationCodeGenerator getVerificationCodeGenerator();

    public abstract int getEffectiveTime();

    /**
     * 执行混淆操作
     *
     * @param payload 载荷
     * @param key     秘钥
     * @param code    验证码
     * @return
     */
    abstract String confusion(Map<String, Object> payload, String key, String code);

    /**
     * 生成验证信息
     *
     * @param payload       业务携带参数, 如手机号 , 邮箱
     * @param effectiveTime 验证信息有效时间(秒)
     * @return
     */
    public VerificationInfo generateVerificationInfo(Map<String, Object> payload, int effectiveTime) {
        effectiveTime = effectiveTime > 0 ? effectiveTime : getEffectiveTime();
        String key = getVerificationKeyGenerator().generate(getName() + ":");
        String code = getVerificationCodeGenerator().generate();
        String content = confusion(payload, key, code);
        getVerificationStore().set(key, code, effectiveTime);
        return new VerificationInfo(key, content);
    }


    /**
     * 验证信息
     *
     * @param verificationKey  验证key
     * @param verificationCode 验证码
     * @return
     */
    public boolean verify(String verificationKey, String verificationCode) {
        if (StringUtils.isBlank(verificationKey) || StringUtils.isBlank(verificationCode)) {
            return false;
        }
        String code = getVerificationStore().get(verificationKey);
        if (code == null) {
            return false;
        }
        return code.equals(verificationCode);
    }


}
