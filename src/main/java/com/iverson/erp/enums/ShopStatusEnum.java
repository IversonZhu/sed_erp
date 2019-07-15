package com.iverson.erp.enums;

import lombok.Getter;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/15
 */
@Getter
public enum ShopStatusEnum {
    /**正常 */
    NORMAL(0,"正常"),
    /** 禁用 */
    FORBIDDEN(1,"禁用");

    private Integer code;
    private String message;

    /** 构造函数 */
    ShopStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
