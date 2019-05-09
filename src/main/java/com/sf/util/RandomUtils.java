package com.sf.util;

import java.util.Random;

/**
 * @author Zidong
 * @date 2019/5/8 5:42 PM
 */
public class RandomUtils {

    private static final String NUMBER_CHAR = "0123456789";

    /**
     * 获取定长的随机数，只包含数字
     * @param length 随机数长度
     * @return str
     */
    public static String generateNumberString(int length){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(NUMBER_CHAR.charAt(random.nextInt(NUMBER_CHAR.length())));
        }
        return sb.toString();
    }
}
