package com.iverson.erp.enums;

import lombok.Getter;

@Getter
public enum  ResultEnum {
    PARAM_ERROR(0,"参数不正确"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDERDETAIL_NOT_EXIST(13, "订单详情不存在"),
    INSERT_ERROR(1,"插入失败"),
    UPDATE_ERROR(2,"更新失败"),
    CART_EMPTY(18, "购物车为空"),
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    UNLOGIN(101,"token失效");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
