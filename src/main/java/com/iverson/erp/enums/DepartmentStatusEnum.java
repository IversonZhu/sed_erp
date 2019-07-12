package com.iverson.erp.enums;

import lombok.Getter;

/**
 * Description: sed_erp
 * @author Iverson
 * @date 2019/6/27
 */
@Getter
public enum  DepartmentStatusEnum {
    /** 正常 */
    NORMAL(0, "正常"),
    /** 禁用 */
    FORBIDDEN(1, "禁用");

    private Integer code;
    private String message;

    /** 构造函数 */
    DepartmentStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
