package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.pojo.ValueCard;
import com.iverson.sed_erp.provider.SqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ValueCardMapper {
    @Insert("insert into sed_market_value_card values (#{id},#{cardNo},#{holder},#{balance},#{phoneNumber},#{createTime},#{modifyTime})")
    int addOne(ValueCard valueCard);

    @UpdateProvider(type = SqlProvider.class, method = "updateValueCardByNo")
    int updateByCardNo(ValueCard valueCard);

    //@Select("select * from sed_market_value_card where 1=1 and holder=#{holder}")
    @SelectProvider(type = SqlProvider.class, method = "searchValueCards")
    List<ValueCard> searchValueCards(@Param("cardNo") String cardNo,
                              @Param("holder") String holder,
                              @Param("phoneNumber") String phoneNumber);

    @Select("select * from sed_market_value_card")
    List<ValueCard> getList();
}
