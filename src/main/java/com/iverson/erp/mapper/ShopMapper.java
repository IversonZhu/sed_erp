package com.iverson.erp.mapper;

import com.iverson.erp.pojo.Shop;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/15
 */
@Component
@Mapper
public interface ShopMapper {
    @Insert("insert into sed_market_shop (shop_no,shop_name,shop_leader,phone_number,shop_address,status) " +
            "values(#{shopNo},#{shopName},#{shopLeader},#{phoneNumber},#{shopAddress},#{status})")
    int addOne(Shop shop);

    @UpdateProvider(type = ShopSqlProvider.class, method = "getUpdateSql")
    int update(Shop shop);

    @Delete("delete from sed_market_shop where shop_no=#{shopNo}")
    int deleteByNo(String shopNo);

    @SelectProvider(type = ShopSqlProvider.class, method = "getListSql")
    List<Shop> getList(@Param("shopNo") String shopNo, @Param("shopName") String shopName, @Param("shopLeader") String shopLeader, @Param("status")Integer status);

    class ShopSqlProvider {
        public String getUpdateSql(Shop shop) {
            StringBuffer sql = new StringBuffer("update sed_market_shop set ");
            if(!StringUtils.isEmpty(shop.getShopName())){
                sql.append("shop_name=#{shopName},");
            }
            if(!StringUtils.isEmpty(shop.getShopLeader())){
                sql.append("shop_leader=#{shopLeader},");
            }
            if(!StringUtils.isEmpty(shop.getPhoneNumber())){
                sql.append("phone_number=#{phoneNumber},");
            }
            if(!StringUtils.isEmpty(shop.getShopAddress())){
                sql.append("shop_address=#{shopAddress},");
            }
            if(shop.getStatus() != null){
                sql.append("status=#{status},");
            }
            sql.replace(sql.length() - 1,sql.length()," ");
            sql.append("where shop_no=#{shopNo}");
            return sql.toString();
        }

        public String getListSql(@Param("shopNo") String shopNo, @Param("shopName") String shopName, @Param("shopLeader") String shopLeader, @Param("status")Integer status){
            StringBuffer sql = new StringBuffer("select * from sed_market_shop where 1=1 ");
            if(!StringUtils.isEmpty(shopNo)){
                sql.append("and shop_no like CONCAT('%',#{shopNo},'%') ");
            }
            if(!StringUtils.isEmpty(shopName)){
                sql.append("and shop_name like CONCAT('%',#{shopName},'%') ");
            }
            if(!StringUtils.isEmpty(shopLeader)){
                sql.append("and shop_leader like CONCAT('%',#{shopLeader},'%') ");
            }
            if(status != null){
                sql.append("and status=#{status}");
            }
            return sql.toString();
        }
    }
}
