package com.iverson.erp.util;

import io.netty.handler.codec.base64.Base64Encoder;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.util.Random;

/**
 * Description: token 生成工具
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/15
 */
public class TokenUtil {

    private TokenUtil(){}

    private static final TokenUtil instance = new TokenUtil();

    public static TokenUtil getInstance(){
        return instance;
    }

    public String getToken(){
        String token = System.currentTimeMillis() + new Random().nextInt(999999999) + "";
        try{
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] = md.digest(token.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (Exception e) {
            return null;
        }
    }
}
