package com.iverson.sed_erp.provider;

import com.iverson.sed_erp.pojo.Goods;
import org.apache.ibatis.annotations.Param;

public class GoodsSqlProvider {

    public String getUpdateSql(Goods goods){

        StringBuffer sql = new StringBuffer("update sed_market_goods set modify_time=#{modifyTime}");
        if(goods.getName() != null){
            sql.append(", name=#{name}");
        }
        if(goods.getBarcode() != null){
            sql.append(", barcode=#{barcode}");
        }
        if(goods.getWeight() != null){
            sql.append(", weight=#{weight}");
        }
        if(goods.getPrice() != null){
            sql.append(", price=#{price}");
        }
        if(goods.getCategoryNo() != null){
            sql.append(", category_no=#{categoryNo}");
        }
        if(goods.getBrandNo() != null){
            sql.append(", brand_no=#{categoryNo}");
        }
        if(goods.getStore() != null){
            sql.append(", store=#{store}");
        }
        sql.append(" where goods_no=#{goodsNo}");
        return sql.toString();
    }

    public String getListSql(@Param("goodsNo") String goodsNo,
                               @Param("name") String name,
                               @Param("barcode") String barcode,
                               @Param("weight") String weight,
                               @Param("price") String price,
                               @Param("categoryNo") String categoryNo,
                               @Param("brandNo") String brandNo){
        String str = "select g.goods_no,g.name,g.barcode,g.weight,g.price,b.name as brand_name,c.name as category_name,g.store " +
                     "from (sed_market_goods g left join sed_market_category c on g.category_no = c.category_no) " +
                     "left join sed_market_brand b on g.brand_no = b.brand_no " +
                     "where 1=1 ";
        StringBuffer sql = new StringBuffer(str);
        if(goodsNo != null){
            sql.append(" and g.goods_no like CONCAT('%',#{goodsNo},'%')");
        }
        if(name != null){
            sql.append(" and g.name like CONCAT('%',#{name},'%')");
        }
        if(barcode != null){
            sql.append(" and g.barcode like CONCAT('%',#{barcode},'%')");
        }
        if(weight != null){
            sql.append(" and g.weight like CONCAT('%',#{weight},'%')");
        }
        if(price != null){
            sql.append(" and g.price like CONCAT('%',#{price},'%')");
        }
        if(categoryNo != null){
            sql.append(" and g.category_no like CONCAT('%',#{categoryNo},'%')");
        }
        if(brandNo != null){
            sql.append(" and g.brand_no like CONCAT('%',#{brandNo},'%')");
        }
        return sql.toString();
    }
}
