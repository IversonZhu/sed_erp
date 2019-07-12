package com.iverson.erp.enums;

import lombok.Getter;

/**
 * @author Iverson
 * @date 2019/07/13
 */
@Getter
public enum BrandStatusEnum {
    /**正常 */
    NORMAL(0,"正常"),
    /** 禁用 */
    FORBIDDEN(1,"禁用");

    private Integer code;

    private String message;

    /** 构造函数 */
    BrandStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
