package com.iverson.sed_erp.provider;

import com.iverson.sed_erp.pojo.MemberShipCard;
import org.apache.ibatis.annotations.Param;

public class MemberShipCardSqlProvider {

    /**
     * 更新会员卡信息
     * @param memberShipCard
     * @return
     */
    public String updateMemberShipCardByNo(MemberShipCard memberShipCard){
        StringBuffer sql = new StringBuffer("update sed_market_membership_card set modify_time=#{modifyTime}");
        if(memberShipCard.getHolder() != null){
            sql.append(", holder=#{holder}");
        }
        if(memberShipCard.getPhoneNumber() != null){
            sql.append(", phone_number=#{phoneNumber}");
        }
        if(memberShipCard.getType() != null){
            sql.append(", type=#{type}");
        }
        if(memberShipCard.getDiscount() != null){
            sql.append(", discount=#{discount}");
        }
        sql.append(" where card_no=#{cardNo}");
        return sql.toString();
    }

    /**
     * 条件查找会员卡列表
     * @param cardNo
     * @param holder
     * @param phoneNumber
     * @param type
     * @return
     */
    public String searchMemberShipCards(@Param("cardNo") String cardNo,
                                        @Param("holder") String holder,
                                        @Param("phoneNumber") String phoneNumber,
                                        @Param("type") Integer type) {
        StringBuffer sql = new StringBuffer("select * from sed_market_membership_card where 1=1");
        if(cardNo != null){
            sql.append(" and card_no like CONCAT('%',#{cardNo},'%')");
        }
        if(holder != null){
            sql.append(" and holder like CONCAT('%',#{holder},'%')");
        }
        if(phoneNumber != null){
            sql.append(" and phone_number like CONCAT('%',#{phoneNumber},'%')");
        }
        if(type != null){
            sql.append(" and type=#{type}");
        }
        return sql.toString();
    }
}
