package com.iverson.erp.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/16
 */
public class KeyUtil {
    public static String getKey() {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        sb.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        sb.append(String.valueOf(number));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getKey());
    }
}
