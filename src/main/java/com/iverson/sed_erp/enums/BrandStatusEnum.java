package com.iverson.sed_erp.enums;

import lombok.Getter;

@Getter
public enum BrandStatusEnum {
    NORMAL(0,"正常"),
    FORBIDDEN(1,"禁用");

    private Integer code;

    private String message;

    BrandStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
