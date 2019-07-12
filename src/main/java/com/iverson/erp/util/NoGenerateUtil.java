package com.iverson.erp.util;

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

    public static String getGoodsNo(){
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        sb.append("gd");
        sb.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        sb.append(String.valueOf(number));
        return sb.toString();
    }

    public static String getDepartmentNo(){
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        sb.append("DN");
        sb.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        sb.append(String.valueOf(number));
        return sb.toString();
    }

    public static String getStaffNo() {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        sb.append("SN");
        sb.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        sb.append(String.valueOf(number));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getGoodsNo());
    }
}
