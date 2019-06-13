package com.iverson.sed_erp.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class MemberShipCard {
    private int id;
    private String cardNo;
    private String holder;
    private String phoneNumber;
    private Integer type;
    private Integer discount;
    private Date createTime;
    private Date modifyTime;
}
