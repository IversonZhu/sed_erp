package com.iverson.sed_erp.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ValueCard {
    private int id;
    private String cardNo;
    private String holder;
    private Double balance;
    private String phoneNumber;
    private Date createTime;
    private Date modifyTime;
}
