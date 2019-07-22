package com.iverson.erp.enums;

import lombok.Getter;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/22
 */
@Getter
public enum  RoleStatusEnum {
    /**正常 */
    NORMAL(0,"正常"),
    /** 禁用 */
    FORBIDDEN(1,"禁用");

    private Integer code;

    private String message;

    /** 构造函数 */
    RoleStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
