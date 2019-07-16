package com.iverson.erp.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    //xin
    NEW_ORDER(0,"新订单"),
    CANCEL_ORDER(1,"已取消订单"),
    UNFINISHED_ORDER(2,"未完成订单"),
    FINISHED(3,"已完成");


    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
