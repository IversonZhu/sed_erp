package com.iverson.sed_erp.test;

import com.iverson.sed_erp.pojo.Department;
import com.iverson.sed_erp.pojo.Goods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = "2019-06-13 12:00:00";
//        Date date = sdf.parse(time);
//        System.out.println(date);

//        Department department = new Department();
//        System.out.println("状态: " + department.getStatus());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date birth = sdf.parse("1993-10-01");
//        System.out.println(birth.toString());

        Goods goods = new Goods();
        goods.setName("小明");
        goods.setPrice(100.00);

        StringBuffer sql = new StringBuffer("update sed_market_goods set ");
        if(goods.getName() != null){
            sql.append("name=#{name},");
        }
        if(goods.getBarcode() != null){
            sql.append("barcode=#{barcode},");
        }
        if(goods.getWeight() != null){
            sql.append("weight=#{weight},");
        }
        if(goods.getPrice() != null){
            sql.append("price=#{price},");
        }
        if(goods.getCategoryNo() != null){
            sql.append("category_no=#{categoryNo},");
        }
        if(goods.getBrandNo() != null){
            sql.append("brand_no=#{categoryNo},");
        }
        if(goods.getStore() != null){
            sql.append("store=#{store},");
        }
        sql.replace(sql.length() - 1,sql.length(),"");
        sql.append(" where goods_no=#{goodsNo}");
        System.out.println(sql);
    }
}
