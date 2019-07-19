package com.iverson.erp.util;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/19
 */
@Slf4j
public class PasswordUtil {
    public static String getPassword(String password) {
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            Base64.Encoder base64Encode = Base64.getEncoder();
            return base64Encode.encodeToString(md5.digest(password.getBytes("utf-8")));
        } catch (Exception e){
            log.error("【转换密码】 失败 message={}", e.getMessage());
            return password;
        }
    }

    public static void main(String[] args) {
        System.out.println(getPassword("zhy19930816"));
    }
}
