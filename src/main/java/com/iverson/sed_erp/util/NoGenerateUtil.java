package com.iverson.sed_erp.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class NoGenerateUtil {
    public static String getBrandNo(){
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        sb.append("bn");
        sb.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        sb.append(String.valueOf(number));
        return sb.toString();
    }

    public static String getMemberShipCardNo(){
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        sb.append("mscn");
        sb.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        sb.append(String.valueOf(number));
        return sb.toString();
    }

    public static String getValueCardNo(){
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        sb.append("vcn");
        sb.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        sb.append(String.valueOf(number));
        return sb.toString();
    }

    public static String getCategoryNo(){
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        sb.append("cn");
        sb.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        sb.append(String.valueOf(number));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getBrandNo());
    }
}
