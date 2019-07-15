package com.iverson.erp.provider;

import com.iverson.erp.pojo.Shop;
import org.springframework.util.StringUtils;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/15
 */
public class ShopSqlProvider {

    public String getUpdateSql(Shop shop) {
        StringBuffer sql = new StringBuffer("update sed_market_shop set ");
        if(!StringUtils.isEmpty(shop.getShopName())){
            sql.append("shop_name=#{shopName}");
        }
        if(shop.getStatus() != null){
            sql.append("status=#{status}");
        }
        sql.replace(sql.length() - 1,sql.length()," ");
        sql.append("where shop_no=#{shopNo}");
        return sql.toString();
    }

    public String getListSql(String shopNo,String shopName,Integer status){
        StringBuffer sql = new StringBuffer("select * from sed_market_shop where 1=1 ");
        if(!StringUtils.isEmpty(shopNo)){
            sql.append("and shop_no like CONCAT('%',#{shopNo},'%') ");
        }
        if(!StringUtils.isEmpty(shopName)){
            sql.append("and shop_name like CONCAT('%',#{shopName},'%') ");
        }
        if(status != null){
            sql.append("and status=#{status}");
        }
        return sql.toString();
    }
}
