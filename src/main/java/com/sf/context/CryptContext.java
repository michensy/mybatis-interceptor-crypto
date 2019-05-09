package com.sf.context;

import com.sf.constant.CryptTypeEnum;
import com.sf.crypt.Crypt;
import com.sf.crypt.impl.CryptImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zidong
 * @date 2019/5/9 9:34 AM
 */
public class CryptContext {

    private static Map<CryptTypeEnum, Crypt> Crypts = new HashMap<>(CryptTypeEnum.values().length);

    /**
     * 获取加密方式
     *
     * @param cryptTypeEnum
     *            加密方式枚举
     * @return 机密方式实现类
     */
    public static Crypt getCrypt(CryptTypeEnum cryptTypeEnum) {
        Crypt crypt = Crypts.get(cryptTypeEnum);
        if (crypt == null) {
            // crypt = ..get(CryptTypeEnum.AES);
            crypt = new CryptImpl();
        }

        return crypt;
    }

    /**
     * 设置加密方式
     *
     * @param cryptTypeEnum
     *            加密类型
     * @param crypt
     *            加载方式
     */
    public static void setCrypt(CryptTypeEnum cryptTypeEnum, Crypt crypt) {
        Crypts.put(cryptTypeEnum, crypt);
    }

}
