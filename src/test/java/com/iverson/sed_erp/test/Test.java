package com.iverson.sed_erp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = "2019-06-13 12:00:00";
        Date date = sdf.parse(time);
        System.out.println(date);
    }
}
