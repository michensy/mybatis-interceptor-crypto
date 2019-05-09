package com.sf.crypt;

/**
 * @author Zidong
 * @date 2019/5/9 9:33 AM
 */
public interface Crypt {
    /**
     * 加密
     *
     * @param plain
     *            原始明文
     * @return 密文
     */
    String encrypt(String plain);

    /**
     * 解密
     *
     * @param cipher
     *            密文
     * @return 原始明文
     */
    String decrypt(String cipher);
}
