package com.iverson.erp.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ValueCardForm {

    /** 卡号 */
    private String cardNo;
    /** 持有者 */
    @NotBlank(message = "持有者不能为空！")
    private String holder;
    /** 余额 */
    private Double balance;
    /** 手机号码 */
    @NotBlank(message = "手机号码不能为空！")
    private String phoneNumber;
}
