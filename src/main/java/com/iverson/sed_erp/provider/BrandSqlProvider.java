package com.iverson.sed_erp.provider;

import com.iverson.sed_erp.pojo.Brand;
import org.apache.ibatis.annotations.Param;

public class BrandSqlProvider {

    public String getListSql(@Param("brandNo") String brandNo, @Param("name") String name){
        StringBuffer sql = new StringBuffer("select * from sed_market_brand where 1=1");
        if(brandNo != null){
            sql.append(" and brand_no like CONCAT('%',#{brandNo},'%')");
        }
        if(name != null){
            sql.append(" and name like CONCAT('%',#{name},'%')");
        }
        return sql.toString();
    }

    /**
     * 更新品牌信息
     * @param brand
     * @return
     */
    public String getUpdateSql(Brand brand){
        StringBuffer sql = new StringBuffer("update sed_market_brand set status=#{status} ");
        if(brand.getName() != null){
            sql.append(",name=#{name} ");
        }
        sql.append("where brand_no=#{brandNo}");
        return sql.toString();
    }
}
