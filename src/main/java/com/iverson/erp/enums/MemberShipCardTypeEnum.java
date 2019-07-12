package com.iverson.erp.enums;

import lombok.Getter;

@Getter
public enum  MemberShipCardTypeEnum {
    //白银
    SILVER(0,"白银"),
    //黄金
    GOLD(1,"黄金"),
    //白金
    PLATINUM(2,"白金"),
    //钻石
    DIAMOND(3,"钻石");

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    MemberShipCardTypeEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
