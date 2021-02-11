package com.tencent.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yuelimin
 * @since JDK 8
 */
@Data
@AllArgsConstructor
public class VerificationInfo {

    /**
     * 客户端保存key
     */
    private String key;

    /**
     * 混淆后的内容
     */
    private String content;

}
