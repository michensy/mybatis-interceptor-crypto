package com.sf.loader;

import com.sf.constant.CryptTypeEnum;
import com.sf.context.CryptContext;
import com.sf.crypt.impl.CryptImpl;

/**
 * @author Zidong
 * @date 2019/5/9 9:35 AM
 */
public class CryptLoader {

    /**
     * 加载所有加密方式实现类
     */
    public void loadCrypt() {
        CryptContext.setCrypt(CryptTypeEnum.AES, new CryptImpl());
    }
}
