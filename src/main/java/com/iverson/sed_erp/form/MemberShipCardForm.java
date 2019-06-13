package com.iverson.sed_erp.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Description: sed_erp
 * <p>
 * Created by Iverson on 2019/6/13 22:22
 */
@Data
public class MemberShipCardForm {
    /**
     * 卡号
     */
    private String cardNo;
    /**
     * 持有者
     */
    @NotBlank(message = "持有者不能为空！")
    private String holder;
    /**
     * 手机号码
     */
    @NotBlank(message = "手机号码不能为空")
    private String phoneNumber;
    /**
     * 类型（卡种）
     */
    private Integer type;
    /**
     * 折扣
     */
    private Integer discount;
}
