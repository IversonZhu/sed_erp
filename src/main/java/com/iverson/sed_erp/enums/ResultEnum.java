package com.iverson.sed_erp.enums;

import lombok.Getter;

@Getter
public enum  ResultEnum {
    PARAM_ERROR(0,"参数不正确"),
    INSERT_ERROR(400,"插入失败");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
