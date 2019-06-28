package com.iverson.sed_erp.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ValueCard {
    /** id */
    private int id;
    /** 储值卡卡号 */
    private String cardNo;
    /** 持有人 */
    private String holder;
    /** 余额 */
    private Double balance;
    /** 手机号码 */
    private String phoneNumber;
}
