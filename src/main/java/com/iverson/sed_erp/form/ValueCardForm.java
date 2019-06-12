package com.iverson.sed_erp.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ValueCardForm {
    /**
     * 持有者
     */
    @NotBlank(message = "持有者不能为空！")
    private String holder;
    /**
     * 余额
     */
    private double balance;
    /**
     * 手机号码
     */
    @NotBlank(message = "手机号码不能为空！")
    private String phoneNumber;
}
