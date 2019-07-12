package com.iverson.erp.mapper;

import com.iverson.erp.pojo.MemberShipCard;
import com.iverson.erp.provider.MemberShipCardSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface MemberShipMapper {
    @Insert("insert into sed_market_membership_card(card_no,holder,phone_number,type,discount) values (#{cardNo},#{holder},#{phoneNumber},#{type},#{discount})")
    int addOne(MemberShipCard memberShipCard);

    @UpdateProvider(type = MemberShipCardSqlProvider.class, method = "getUpdateSql")
    int update(MemberShipCard memberShipCard);

    @SelectProvider(type = MemberShipCardSqlProvider.class, method = "getListSql")
    List<MemberShipCard> getList(@Param("cardNo") String cardNo,
                                 @Param("holder") String holder,
                                 @Param("phoneNumber") String phoneNumber,
                                 @Param("type") Integer type);

}
