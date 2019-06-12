package com.iverson.sed_erp.mapper;

import com.iverson.sed_erp.pojo.ValueCard;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ValueCardMapper {
    @Insert("insert into sed_market_value_card values (#{id},#{cardNo},#{holder},#{balance},#{phoneNumber},#{createTime},#{modifyTime})")
    int addOne(ValueCard valueCard);

    @Select("select * from sed_market_value_card where card_no = #{cardNo}")
    ValueCard searchValueCardByCardNo(String cardNo);

    @Select("select * from sed_market_value_card")
    List<ValueCard> getList();
}
