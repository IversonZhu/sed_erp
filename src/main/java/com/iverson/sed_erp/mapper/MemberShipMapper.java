package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.pojo.MemberShipCard;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface MemberShipMapper {
    @Insert("insert into sed_market_membership_card values (#{id},#{cardNo},#{holder},#{phoneNumber},#{type},#{discount},#{createTime},#{modifyTime})")
    void addOne(MemberShipCard memberShipCard);

    @Select("select * from sed_market_membership_card where card_no = #{cardNo}")
    MemberShipCard searchMemberShipCardByCardNo(String cardNo);
}
