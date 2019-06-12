package com.iverson.sed_erp.vo;

import lombok.Data;

@Data
public class ResultVo<T> {

    /** 状态码 */
    private Integer code;

    /** 提示信息码 */
    private String msg;

    /** 返回内容 */
    private T data;
}
