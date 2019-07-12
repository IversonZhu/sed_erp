package com.iverson.erp.pojo;

import lombok.Data;

@Data
public class MemberShipCard {
    /** id */
    private int id;
    /** 会员卡编号 */
    private String cardNo;
    /** 持有人 */
    private String holder;
    /** 手机号码 */
    private String phoneNumber;
    /** 类型 */
    private Integer type;
    /** 折扣 */
    private Integer discount;
}
