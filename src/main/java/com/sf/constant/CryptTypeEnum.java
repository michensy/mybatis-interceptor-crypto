package com.sf.constant;

/**
 * 验证类型枚举
 *
 * @author Zidong
 * @date 2019/5/9 9:32 AM
 */
public enum CryptTypeEnum {
    /**
     * AES加密（这个可是加密，不是脱敏）
     */
    AES,

    /**
     * 手机号
     */
    @Deprecated
    PhoneNumber,

    /**
     * 身份证
     */
    @Deprecated
    IdCard,

    /**
     * 银行卡
     */
    @Deprecated
    BankCard
}
