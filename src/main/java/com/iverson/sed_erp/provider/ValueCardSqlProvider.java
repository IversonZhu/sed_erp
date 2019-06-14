package com.iverson.sed_erp.provider;

import com.iverson.sed_erp.pojo.ValueCard;
import org.apache.ibatis.annotations.Param;

public class ValueCardSqlProvider {

    /**
     * 更新储值卡信息
     * @param valueCard
     * @return
     */
    public String updateValueCardByNo(ValueCard valueCard){
        StringBuffer sql = new StringBuffer("update sed_market_value_card set modify_time=#{modifyTime}");
        if(valueCard.getHolder() != null){
            sql.append(", holder=#{holder}");
        }
        if(valueCard.getBalance() != null){
            sql.append(", balance=#{balance}");
        }
        if(valueCard.getPhoneNumber() != null){
            sql.append(", phone_number=#{phoneNumber}");
        }
        sql.append(" where card_no=#{cardNo}");
        return sql.toString();
    }

    /**
     * 条件查找储值卡信息
     * @param cardNo
     * @param holder
     * @param phoneNumber
     * @return
     */
    public String searchValueCards(@Param("cardNo") String cardNo,
                                   @Param("holder") String holder,
                                   @Param("phoneNumber") String phoneNumber) {
        StringBuffer sql = new StringBuffer("select * from sed_market_value_card where 1=1");
        if(cardNo != null){
            sql.append(" and card_no like CONCAT('%',#{cardNo},'%')");
        }
        if(holder != null){
            sql.append(" and holder like CONCAT('%',#{holder},'%')");
        }
        if(phoneNumber != null){
            sql.append(" and phone_number like CONCAT('%',#{phoneNumber},'%')");
        }
        return sql.toString();
    }
}
