package com.iverson.sed_erp.enums;

import lombok.Getter;

@Getter
public enum  MemberShipCardTypeEnum {
    SILVER(0,"白银"),//白银
    GOLD(1,"黄金"),//黄金
    PLATINUM(2,"白金"),//白金
    DIAMOND(3,"钻石");//钻石

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
