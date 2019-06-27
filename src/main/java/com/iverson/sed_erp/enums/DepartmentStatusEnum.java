package com.iverson.sed_erp.enums;

import lombok.Getter;

/**
 * Description: sed_erp
 * <p>
 * Created by Iverson on 2019/6/27 22:28
 */
@Getter
public enum  DepartmentStatusEnum {
    NORMAL(0, "正常"),
    FORBIDDEN(1, "禁用");

    private Integer code;
    private String message;

    DepartmentStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
