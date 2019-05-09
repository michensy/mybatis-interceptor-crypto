package com.sf.constant;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 加密字段注解
 * @author Zidong
 * @date 2019/5/9 9:31 AM
 */
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CryptField {
    CryptTypeEnum value() default CryptTypeEnum.AES;
}