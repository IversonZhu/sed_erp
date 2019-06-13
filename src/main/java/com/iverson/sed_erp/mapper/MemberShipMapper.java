package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.pojo.MemberShipCard;
import com.iverson.sed_erp.provider.SqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface MemberShipMapper {
    @Insert("insert into sed_market_membership_card values (#{id},#{cardNo},#{holder},#{phoneNumber},#{type},#{discount},#{createTime},#{modifyTime})")
    int addOne(MemberShipCard memberShipCard);

    @UpdateProvider(type = SqlProvider.class, method = "updateMemberShipCardByNo")
    int updateByCardNo(MemberShipCard memberShipCard);

    @SelectProvider(type = SqlProvider.class, method = "searchMemberShipCards")
    List<MemberShipCard> searchMemberShipCards(@Param("cardNo") String cardNo,
                                               @Param("holder") String holder,
                                               @Param("phoneNumber") String phoneNumber,
                                               @Param("type") Integer type);

}
