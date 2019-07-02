package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.pojo.ValueCard;
import com.iverson.sed_erp.provider.ValueCardSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ValueCardMapper {
    @Insert("insert into sed_market_value_card (card_no,holder,balance,phone_number) values (#{cardNo},#{holder},#{balance},#{phoneNumber})")
    int addOne(ValueCard valueCard);

    @UpdateProvider(type = ValueCardSqlProvider.class, method = "getUpdateSql")
    int update(ValueCard valueCard);

    @SelectProvider(type = ValueCardSqlProvider.class, method = "getListSql")
    List<ValueCard> getList(@Param("cardNo") String cardNo,
                            @Param("holder") String holder,
                            @Param("phoneNumber") String phoneNumber);
}
