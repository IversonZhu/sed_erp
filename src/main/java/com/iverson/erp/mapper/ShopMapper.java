package com.iverson.erp.mapper;

import com.iverson.erp.pojo.Shop;
import com.iverson.erp.provider.ShopSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

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


    @Insert("insert into sed_market_shop (shop_no,shop_name,token,status) values(#{shopNo},#{shopName},#{token},#{status})")
    int addOne(Shop shop);

    @UpdateProvider(type = ShopSqlProvider.class, method = "getUpdateSql")
    int update(Shop shop);

    @Delete("delete from sed_market_shop where shop_no=#{shopNo}")
    int deleteByNo(String shopNo);

    @SelectProvider(type = ShopSqlProvider.class, method = "getListSql")
    List<Shop> getList(String shopNo,String shopName,Integer status);

    @Select("select * from sed_market_shop where token=#{token} and status=#{status}")
    Shop getShopByToken(@Param("token") String token, @Param("status") int status);
}
